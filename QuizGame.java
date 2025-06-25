import java.util.Scanner;

class Question {
    String question, optionA, optionB, optionC, optionD, correctAnswer;

    Question(String question, String a, String b, String c, String d, String correct) {
        this.question = question;
        this.optionA = a;
        this.optionB = b;
        this.optionC = c;
        this.optionD = d;
        this.correctAnswer = correct.toUpperCase();
    }

    boolean askQuestion() {
        System.out.println("\n" + question);
        System.out.println("A. " + optionA);
        System.out.println("B. " + optionB);
        System.out.println("C. " + optionC);
        System.out.println("D. " + optionD);
        System.out.print("Your answer (A/B/C/D): ");
        
        Scanner sc = new Scanner(System.in);
        String userAnswer = sc.nextLine().toUpperCase();

        if (userAnswer.equals(correctAnswer)) {
            System.out.println("Correct!");
            return true;
        } else {
            System.out.println("Wrong! Correct answer is: " + correctAnswer);
            return false;
        }
    }
}

public class QuizGame {
    public static void main(String[] args) {
        System.out.println("=== Welcome to the Quiz Game ===");

        Question[] questions = {
            new Question("What is the capital of France?", "Berlin", "London", "Paris", "Madrid", "C"),
            new Question("Which planet is known as the Red Planet?", "Earth", "Mars", "Jupiter", "Saturn", "B"),
            new Question("Who wrote 'Romeo and Juliet'?", "Mark Twain", "William Shakespeare", "Charles Dickens", "Leo Tolstoy", "B"),
            new Question("Which gas do plants absorb?", "Oxygen", "Nitrogen", "Carbon Dioxide", "Hydrogen", "C"),
            new Question("How many continents are there on Earth?", "5", "6", "7", "8", "C")
        };

        int score = 0;

        for (Question q : questions) {
            if (q.askQuestion()) {
                score++;
            }
        }

        System.out.println("\n=== Quiz Over! ===");
        System.out.println("Your Score: " + score + " out of " + questions.length);
        
        if (score == questions.length) {
            System.out.println("Excellent! You're a quiz master!");
        } else if (score >= 3) {
            System.out.println("Good job! Keep learning.");
        } else {
            System.out.println("Better luck next time.");
        }
    }
}
