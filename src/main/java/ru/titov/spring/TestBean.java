package ru.titov.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import com.opencsv.CSVReader;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.util.*;
@Component
public class TestBean implements Test {
    public List<Question> qlist;
    public Iterator<Question> iterator;
    String filename_ru;
    String filename_en;
    String locale;
    public TestBean(@Value("${filename_ru}") String filename_ru, @Value("${filename_en}") String filename_en) {
        this.filename_ru = filename_ru;
        this.filename_en = filename_en;
    }

   public List<Question> ReadQuestions(String text) {
        List<Question> questions = new ArrayList<>();
       Resource resource = new ClassPathResource(filename_ru);

        if(text.equals("en")) {
            resource = new ClassPathResource(filename_en);
        }


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
