package ru.titov.spring;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;
@Component
public class Quiz implements Controller{
    private static final String PASSED_TITLE = "ТЕСТ СДАН";
    private static final String FAILED_TITLE = "ТЕСТ НЕ СДАН";
    private static final String WRONG_INPUT_TITLE = "Ошибка ввода - ответ не засчитан";
   private Test test;
    private int count;
    String text = "";
private  Scanner scanner;

    public Quiz(Test test) {
        this.test = test;
        scanner = new Scanner(System.in);
    }

    public void setTest(Test test) {
        this.test = test;
    }

    @Override
    public void start() {
         text = scanner.nextLine();



     /*   while(test.hasNextQuestion()){
            Question q = test.getNextQuestion();
            System.out.println(q.getText());
            for (int i = 0; i < q.getAnswers().size(); i++) {
                System.out.println((i + 1) + ". " + q.getAnswers().get(i));
            }
            Scanner sc = new Scanner(System.in);
            try {
                text = sc.nextLine();


                q.setAnswer(Integer.parseInt(text)-1);
            } catch (NumberFormatException e) {
                System.out.println(WRONG_INPUT_TITLE);
            }
        }
*/
        List<Question> questions  = test.ReadQuestions(text);
        for(Question q: questions) {
            System.out.println(q.getText());
            try {
                for (int i = 0; i < q.getAnswers().size(); i++) {
                    System.out.println((i + 1) + ". " + q.getAnswers().get(i));
                }

                q.setAnswer(Integer.parseInt(scanner.nextLine()) - 1);
            }
            catch (NumberFormatException e) {
                System.out.println(WRONG_INPUT_TITLE);
            }
            if(q.getAnswer()==q.getCorrectanswer())
            {
                count++;
            }
        }
   //     String result = test.getPassed() ? PASSED_TITLE : FAILED_TITLE;
        String result = count== questions.size() ? PASSED_TITLE : FAILED_TITLE;
        System.out.println(result);
    }


}
