package com.edu.questions.persistence;

import com.edu.questions.model.Questions;
import com.edu.questions.model.QuestionsModel;

import java.io.*;

public class QuestionsRepository {

    private static final String FILE_NAME_QUESTIONS_MODEL = "questions.txt";

    public static QuestionsModel loadQuestions() {
        Questions questions = loadQuestions(FILE_NAME_QUESTIONS_MODEL);
        if (questions == null) {
            return new QuestionsModel(new Questions());
        }
        return new QuestionsModel(questions);
    }

    public static void saveQuestions(QuestionsModel model) {
        saveQuestions(FILE_NAME_QUESTIONS_MODEL, model.getQuestions());
    }

    private static void saveQuestions(String fileName, Questions questions) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(questions);
        } catch (IOException e) {
            System.out.println("Error saving questions to file: " + e.getMessage());
        }
    }

    private static Questions loadQuestions(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            Object fromFileObj = ois.readObject();
            if (!(fromFileObj instanceof Questions)) {
                return null;
            }
            return (Questions) fromFileObj;
        } catch (FileNotFoundException e1) {
            System.out.println("There is no questions saved previously");
            return null;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error during loading questions from file: " + e.getMessage());
            return null;
        }
    }
}
