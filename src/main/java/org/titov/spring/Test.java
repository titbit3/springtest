package org.titov.spring;

import java.util.List;

public interface Test {

    public List<Question> ReadQuestions();

    public  Boolean hasNextQuestion();

    public Question getNextQuestion();

    Boolean getPassed();
}
