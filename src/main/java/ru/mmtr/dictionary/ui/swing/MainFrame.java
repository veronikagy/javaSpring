package ru.mmtr.dictionary.ui.swing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.mmtr.dictionary.domain.DictionaryFileEnum;

import javax.swing.*;
import java.awt.*;

@Component
public class MainFrame extends JFrame {
    private final SwingFacade facade;
    private JTabbedPane tabbedPane;

    @Autowired
    public MainFrame(SwingFacade facade) {
        this.facade = facade;
        initComponents();
    }

    private void initComponents() {
        setTitle("Приложение Словари");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        tabbedPane = new JTabbedPane();
        
        // Создаем панели для каждой вкладки
        SearchPanel searchPanel = new SearchPanel(facade);
        AddEditPanel addEditPanel = new AddEditPanel(facade);
        
        // Добавляем вкладки
        tabbedPane.addTab("Поиск", searchPanel);
        tabbedPane.addTab("Добавление/Редактирование", addEditPanel);
        
        add(tabbedPane, BorderLayout.CENTER);
    }
} 