package ru.mmtr.dictionary.ui.swing;

import ru.mmtr.dictionary.domain.ValidationRule;
import ru.mmtr.dictionary.domain.DictionaryFileEnum;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class SearchPanel extends JPanel {
    private final SwingFacade facade;
    private JRadioButton dict1RadioButton;
    private JRadioButton dict2RadioButton;
    private JTextField keyTextField;
    private JTextField valueTextField;
    private JButton searchButton;
    private JButton searchInBothButton;
    private JButton exportJsonButton;
    private JTextArea resultTextArea;
    private JTextArea dictionaryContentsTextArea;

    public SearchPanel(SwingFacade facade) {
        this.facade = facade;
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout(10, 10));
        setBorder(new EmptyBorder(10, 10, 10, 10));

        JPanel dictionarySelectionPanel = new JPanel();
        dict1RadioButton = new JRadioButton("Словарь 1");
        dict2RadioButton = new JRadioButton("Словарь 2");
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(dict1RadioButton);
        buttonGroup.add(dict2RadioButton);
        dict1RadioButton.setSelected(true);
        
        dictionarySelectionPanel.add(dict1RadioButton);
        dictionarySelectionPanel.add(dict2RadioButton);

        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        inputPanel.add(new JLabel("Ключ:"));
        keyTextField = new JTextField();
        inputPanel.add(keyTextField);
        inputPanel.add(new JLabel("Значение:"));
        valueTextField = new JTextField();
        inputPanel.add(valueTextField);
        
        //кнопки
        JPanel buttonPanel = new JPanel();
        searchButton = new JButton("Поиск");
        searchInBothButton = new JButton("Поиск в обоих словарях");
        exportJsonButton = new JButton("Экспорт в JSON");
        buttonPanel.add(searchButton);
        buttonPanel.add(searchInBothButton);
        buttonPanel.add(exportJsonButton);
        
        // вывод
        JPanel resultsPanel = new JPanel(new BorderLayout());
        resultTextArea = new JTextArea(5, 40);
        resultTextArea.setEditable(false);
        JScrollPane resultScrollPane = new JScrollPane(resultTextArea);
        resultsPanel.add(new JLabel("Результат:"), BorderLayout.NORTH);
        resultsPanel.add(resultScrollPane, BorderLayout.CENTER);
        
        // панель содержимого словаря
        JPanel dictionaryPanel = new JPanel(new BorderLayout());
        dictionaryContentsTextArea = new JTextArea(10, 40);
        dictionaryContentsTextArea.setEditable(false);
        JScrollPane dictionaryScrollPane = new JScrollPane(dictionaryContentsTextArea);
        dictionaryPanel.add(new JLabel("Содержимое словаря:"), BorderLayout.NORTH);
        dictionaryPanel.add(dictionaryScrollPane, BorderLayout.CENTER);
        
        // Объединяем все панели
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(dictionarySelectionPanel, BorderLayout.NORTH);
        topPanel.add(inputPanel, BorderLayout.CENTER);
        topPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        add(topPanel, BorderLayout.NORTH);
        add(resultsPanel, BorderLayout.CENTER);
        add(dictionaryPanel, BorderLayout.SOUTH);

        searchButton.addActionListener(e -> performSearch());
        searchInBothButton.addActionListener(e -> performSearchInBoth());
        exportJsonButton.addActionListener(e -> exportToJson());
        
        // обновляем отображение содержимого
        dict1RadioButton.addActionListener(e -> updateDictionaryContents());
        dict2RadioButton.addActionListener(e -> updateDictionaryContents());

        updateDictionaryContents();
    }
    
    private void updateDictionaryContents() {
        int dictionaryNumber = getSelectedDictionary();
        String contents = facade.showAll(dictionaryNumber);
        dictionaryContentsTextArea.setText(contents);
    }
    
    private void performSearch() {
        int dictionaryNumber = getSelectedDictionary();
        String key = keyTextField.getText().trim();
        String value = valueTextField.getText().trim();
        String result;
        
        if (!key.isEmpty()) {
            ValidationRule rule = DictionaryFileEnum.resolveDictionaryNumber(dictionaryNumber).getDictionaryPattern();
            if (!rule.verification(key)) {
                result = "Неправильный формат ключа";
            } else {
                result = facade.searchKey(key, dictionaryNumber);
            }
        } else if (!value.isEmpty()) {
            result = facade.searchValue(value, dictionaryNumber);
        } else {
            result = "Введите ключ или значение для поиска";
        }
        
        resultTextArea.setText(result);
    }
    
    private void performSearchInBoth() {
        String value = valueTextField.getText().trim();
        if (value.isEmpty()) {
            resultTextArea.setText("Для поиска в обоих словарях введите значение");
            return;
        }
        
        String result1 = facade.searchValue(value, 1);
        String result2 = facade.searchValue(value, 2);
        resultTextArea.setText("Словарь 1: " + result1 + "\nСловарь 2: " + result2);
    }
    
    private int getSelectedDictionary() {
        return dict1RadioButton.isSelected() ? 1 : 2;
    }

    private void exportToJson() {
        int dictionaryNumber = getSelectedDictionary();
        
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Сохранить JSON файл");
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("JSON файлы (*.json)", "json"));
        
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                String jsonContent = facade.exportToJson(dictionaryNumber);
                String filePath = fileChooser.getSelectedFile().getPath();
                if (!filePath.toLowerCase().endsWith(".json")) {
                    filePath += ".json";
                }
                
                java.nio.file.Files.writeString(java.nio.file.Path.of(filePath), jsonContent);
                JOptionPane.showMessageDialog(this, 
                    "Словарь успешно экспортирован в JSON файл", 
                    "Успех", 
                    JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,
                    "Ошибка при экспорте: " + ex.getMessage(),
                    "Ошибка",
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }
} 