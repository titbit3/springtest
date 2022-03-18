package org.titov.spring;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.titov.spring.MusicFolder.Music;
import org.titov.spring.MusicFolder.MusicPlayer;

public class Main {

    public static void main(String[] args) {

        Question question = new Question();







        ClassPathXmlApplicationContext  context = new ClassPathXmlApplicationContext(
                "spring-context.xml"
        );

        Controller quiz =  context.getBean("quizBean", Controller.class);
        quiz.start();

    }


}
