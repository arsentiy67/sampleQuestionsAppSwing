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
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                QuestionsRepository.saveQuestions(model);
            }
        });
        setVisible(true);
    }
}
