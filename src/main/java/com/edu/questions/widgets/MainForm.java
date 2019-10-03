package com.edu.questions.widgets;

import com.edu.questions.model.QuestionsModel;
import com.edu.questions.persistence.QuestionsRepository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainForm extends JFrame {

    private final QuestionsModel model;

    public MainForm() throws HeadlessException {
        model = QuestionsRepository.loadQuestions();
        setSize(1200, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                QuestionsRepository.saveQuestions(model);
            }
        });
        init();
        setVisible(true);
    }

    private void init() {
        setLayout(new BorderLayout());

        ButtonsPanel buttonsPanel = new ButtonsPanel(model);
        add(buttonsPanel, BorderLayout.WEST);

        ContentPanel contentPanel = new ContentPanel(model);
        add(contentPanel, BorderLayout.CENTER);

        buttonsPanel.setContentShowListener(contentPanel.getContentShowListener());
    }
}
