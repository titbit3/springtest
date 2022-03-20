package ru.titov.spring;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        Question question = new Question();







   //     ClassPathXmlApplicationContext  context = new ClassPathXmlApplicationContext(
   //             "spring-context.xml"
   //     );
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);


        Controller quiz =  context.getBean("quiz", Controller.class);
        quiz.start();


    }


}
