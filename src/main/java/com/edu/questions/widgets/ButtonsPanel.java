package com.edu.questions.widgets;

import com.edu.questions.model.QuestionsModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonsPanel extends JPanel {

    private final QuestionsModel model;

    private ActionListener contentShowListener;

    public ButtonsPanel(QuestionsModel model) {
        this.model = model;
        init();
    }

    private void init() {
        setLayout(new GridLayout(10, 1, 5, 12));

        JButton addQuestionButton = new JButton("Add new question");
        addQuestionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newQuestion = JOptionPane.showInputDialog(addQuestionButton, "Add new question: ");
                if (newQuestion == null) {
                    return;
                }
                String answer = JOptionPane.showInputDialog(addQuestionButton, "Add an answer to the question: ");
                if (answer == null) {
                    return;
                }
                model.addQuestion(newQuestion, answer);
                JOptionPane.showMessageDialog(addQuestionButton, "Question has been added");
            }
        });
        add(addQuestionButton);

        JButton startTrainingSessionButton = new JButton("Start training session");
        startTrainingSessionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contentShowListener.actionPerformed(e);
            }
        });
        add(startTrainingSessionButton);
    }

    public void setContentShowListener(ActionListener contentShowListener) {
        this.contentShowListener = contentShowListener;
    }
}
