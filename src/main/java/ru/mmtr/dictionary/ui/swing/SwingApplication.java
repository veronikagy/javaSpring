package ru.mmtr.dictionary.ui.swing;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import ru.mmtr.dictionary.DictionaryApplication;

import javax.swing.*;

public class SwingApplication {
    private static ConfigurableApplicationContext context;

    public static void main(String[] args) {
        System.out.println("Запуск Swing приложения...");
        SwingUtilities.invokeLater(() -> {
            try {
                System.out.println("Инициализация Spring контекста...");
                // Запуск Spring контекста без веб-сервера
                context = new SpringApplicationBuilder(DictionaryApplication.class)
                        .headless(false)
                        .web(WebApplicationType.NONE) // Явно указываем, что это не веб-приложение
                        .run(args);
                
                System.out.println("Получение MainFrame из контекста...");
                MainFrame mainFrame = context.getBean(MainFrame.class);
                System.out.println("MainFrame создан: " + mainFrame);
                
                mainFrame.setSize(800, 600);
                mainFrame.setLocationRelativeTo(null);
                mainFrame.setVisible(true);
                System.out.println("Главное окно отображено");
                
                mainFrame.repaint();
                mainFrame.revalidate();
            } catch (Exception e) {
                System.err.println("Ошибка запуска Swing GUI: ");
                e.printStackTrace();
            }
        });
    }
    
    public static ConfigurableApplicationContext getContext() {
        return context;
    }
} 