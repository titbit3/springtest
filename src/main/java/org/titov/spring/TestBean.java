package org.titov.spring;

import org.springframework.core.io.ClassPathResource;
import com.opencsv.CSVReader;
import org.springframework.core.io.Resource;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TestBean implements Test {
    public List<Question> qlist;
    public Iterator<Question> iterator;
    String filename;

    public TestBean(String filename) {
        this.filename = filename;
    }

   public List<Question> ReadQuestions() {
        List<Question> questions = new ArrayList<>();
        Resource resource = new ClassPathResource(filename);
        try (CSVReader csvReader = new CSVReader(new FileReader(resource.getURI().getPath()))) {
            List<String[]> myEntries = csvReader.readAll();
            for (String[] s: myEntries) {
                Question q = new Question();
                q.setText(s[0]);
                q.setCorrectanswer(Integer.parseInt(s[1]));
                List<String> answers = Arrays.asList(s).subList(2,s.length);
                q.setAnswers(answers);
                questions.add(q);
            }
        } catch (
                Exception e) {
            e.printStackTrace();
        }
        return questions;
    }


    public void load(){
        if (qlist == null || qlist.isEmpty()) {
            qlist = ReadQuestions();
            iterator = qlist.iterator();
        }
    }

   public Question getNextQuestion() {

       load();
        return iterator.next();
    }
    public Boolean hasNextQuestion() {
        load();
        return iterator.hasNext();
    }

     public Boolean getPassed(){
         load();
         int sum = 0;
         for(Question q: qlist) {
             if(q.checkCorrect(q.getAnswer()) == 1)
             {
                 sum++;
             }
         }
         if(sum == qlist.size()) {
             return true;
         }
         else{ return false;}


    }
}
