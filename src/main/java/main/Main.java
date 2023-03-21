package main;

import model.Question;
import repository.QuestionRepositoryImp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Make a choice:\nСlick 1 Do you want a random question?\nСlick 2 Want to add a question to the database?\nСlick 3 Do you want to remove a question from the database?");
        switch (scanner.nextInt()) {
            case (1):
                do {
                    System.out.println(new QuestionRepositoryImp().getRandom());
                    System.out.println("Do you wanna a next question?");
                } while (scanner.next().equals("Yes"));
                break;
            case (2):
                System.out.println("Specify id:");
                int id = scanner.nextInt();
                System.out.println("Specify text:");
                String text = scanner.nextLine();
                System.out.println("Specify topic:");
                String topic = scanner.nextLine();
                new QuestionRepositoryImp().save(new Question(id, text, topic));
                System.out.println("Question added to database.");
                break;
            case (3):
                System.out.println("Specify the id of the question to be deleted:");
                new QuestionRepositoryImp().delete(scanner.nextInt());
                System.out.println("Question removed from database.");
                break;
            default:
                break;
        }
        scanner.close();
        System.out.println("End!");
    }

}

