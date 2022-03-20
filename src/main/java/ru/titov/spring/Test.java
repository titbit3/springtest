package ru.titov.spring;

import java.util.List;

public interface Test {

    public List<Question> ReadQuestions(String text);

    public  Boolean hasNextQuestion();

    public Question getNextQuestion();

    Boolean getPassed();
}
