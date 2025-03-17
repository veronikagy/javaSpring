package ru.mmtr.dictionary.ui.swing;

import ru.mmtr.dictionary.domain.ValidationRule;
import ru.mmtr.dictionary.domain.DictionaryFileEnum;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AddEditPanel extends JPanel {
    private final SwingFacade facade;
    private JRadioButton dict1RadioButton;
    private JRadioButton dict2RadioButton;
    private JTextField keyTextField;
    private JTextField valueTextField;
    private JButton addButton;
    private JButton editButton;
    private JButton deleteButton;
    private JTextArea resultTextArea;

    public AddEditPanel(SwingFacade facade) {
        this.facade = facade;
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout(10, 10));
        setBorder(new EmptyBorder(10, 10, 10, 10));

        // Панель выбора словаря
        JPanel dictionarySelectionPanel = new JPanel();
        dict1RadioButton = new JRadioButton("Словарь 1");
        dict2RadioButton = new JRadioButton("Словарь 2");
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(dict1RadioButton);
        buttonGroup.add(dict2RadioButton);
        dict1RadioButton.setSelected(true);
        
        dictionarySelectionPanel.add(dict1RadioButton);
        dictionarySelectionPanel.add(dict2RadioButton);
        
        // Панель ввода данных
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        inputPanel.add(new JLabel("Ключ:"));
        keyTextField = new JTextField();
        inputPanel.add(keyTextField);
        inputPanel.add(new JLabel("Значение:"));
        valueTextField = new JTextField();
        inputPanel.add(valueTextField);
        
        // Панель кнопок
        JPanel buttonPanel = new JPanel();
        addButton = new JButton("Добавить");
        editButton = new JButton("Редактировать");
        deleteButton = new JButton("Удалить");
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        
        // Панель вывода результатов
        JPanel resultsPanel = new JPanel(new BorderLayout());
        resultTextArea = new JTextArea(10, 40);
        resultTextArea.setEditable(false);
        JScrollPane resultScrollPane = new JScrollPane(resultTextArea);
        resultsPanel.add(new JLabel("Результат:"), BorderLayout.NORTH);
        resultsPanel.add(resultScrollPane, BorderLayout.CENTER);
        
        // Объединяем все панели
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(dictionarySelectionPanel, BorderLayout.NORTH);
        topPanel.add(inputPanel, BorderLayout.CENTER);
        topPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        add(topPanel, BorderLayout.NORTH);
        add(resultsPanel, BorderLayout.CENTER);
        
        // Обработчики событий
        addButton.addActionListener(e -> performAdd());
        editButton.addActionListener(e -> performEdit());
        deleteButton.addActionListener(e -> performDelete());
        
        // Подсказка для ввода ключа
        JPanel hintPanel = new JPanel();
        JLabel hintLabel = new JLabel("Ключ для Словаря 1: 4 буквы, для Словаря 2: 5 цифр");
        hintPanel.add(hintLabel);
        add(hintPanel, BorderLayout.SOUTH);
    }
    
    private void performAdd() {
        int dictionaryNumber = getSelectedDictionary();
        String key = keyTextField.getText().trim();
        String value = valueTextField.getText().trim();
        
        if (key.isEmpty() || value.isEmpty()) {
            resultTextArea.setText("Ключ и значение должны быть заполнены");
            return;
        }
        
        ValidationRule rule = DictionaryFileEnum.resolveDictionaryNumber(dictionaryNumber).getDictionaryPattern();
        if (!rule.verification(key)) {
            resultTextArea.setText("Неправильный формат ключа");
            return;
        }
        
        String result = facade.addEntry(key, value, dictionaryNumber);
        resultTextArea.setText(result);
    }
    
    private void performEdit() {
        int dictionaryNumber = getSelectedDictionary();
        String key = keyTextField.getText().trim();
        String value = valueTextField.getText().trim();
        
        if (key.isEmpty() || value.isEmpty()) {
            resultTextArea.setText("Ключ и значение должны быть заполнены");
            return;
        }
        
        ValidationRule rule = DictionaryFileEnum.resolveDictionaryNumber(dictionaryNumber).getDictionaryPattern();
        if (!rule.verification(key)) {
            resultTextArea.setText("Неправильный формат ключа");
            return;
        }
        
        String result = facade.editEntry(key, value, dictionaryNumber);
        resultTextArea.setText(result);
    }
    
    private void performDelete() {
        int dictionaryNumber = getSelectedDictionary();
        String key = keyTextField.getText().trim();
        
        if (key.isEmpty()) {
            resultTextArea.setText("Ключ должен быть заполнен");
            return;
        }
        
        ValidationRule rule = DictionaryFileEnum.resolveDictionaryNumber(dictionaryNumber).getDictionaryPattern();
        if (!rule.verification(key)) {
            resultTextArea.setText("Неправильный формат ключа");
            return;
        }
        
        String result = facade.deleteEntry(key, dictionaryNumber);
        resultTextArea.setText(result);
    }
    
    private int getSelectedDictionary() {
        return dict1RadioButton.isSelected() ? 1 : 2;
    }
} 