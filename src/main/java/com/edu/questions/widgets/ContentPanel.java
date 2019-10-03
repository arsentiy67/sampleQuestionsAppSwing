package com.edu.questions.widgets;

import com.edu.questions.model.Question;
import com.edu.questions.model.Questions;
import com.edu.questions.model.QuestionsModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContentPanel extends JPanel {

    private final QuestionsModel model;

    public ContentPanel(QuestionsModel model) {
        this.model = model;
        setVisible(false);
    }

    private void redraw() {
        removeAll();

        Questions questions = model.getQuestions();
        setLayout(new GridLayout(questions.size(), 0, 5, 12));

        for (Question question: questions) {
            JTextArea questionTextArea = new JTextArea();
            questionTextArea.append(question.getQuestionText());
            add(questionTextArea);
        }

        revalidate();
    }

    public ActionListener getContentShowListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                redraw();
                setVisible(true);
            }
        };
    }
}
