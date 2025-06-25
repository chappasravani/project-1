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



"C:\Users\chapp\OneDrive\Pictures\Screenshots\Screenshot 2025-06-25 222242.png"

#OUTPUT
 C:\Users\chapp\OneDrive\Documents>javac QuizGame.java

C:\Users\chapp\OneDrive\Documents>java QuizGame
=== Welcome to the Quiz Game ===

What is the capital of France?
A. Berlin
B. London
C. Paris
D. Madrid
Your answer (A/B/C/D): b
Wrong! Correct answer is: C

Which planet is known as the Red Planet?
A. Earth
B. Mars
C. Jupiter
D. Saturn
Your answer (A/B/C/D): b
Correct!

Who wrote 'Romeo and Juliet'?
A. Mark Twain
B. William Shakespeare
C. Charles Dickens
D. Leo Tolstoy
Your answer (A/B/C/D): b
Correct!

Which gas do plants absorb?
A. Oxygen
B. Nitrogen
C. Carbon Dioxide
D. Hydrogen
Your answer (A/B/C/D): c
Correct!

How many continents are there on Earth?
A. 5
B. 6
C. 7
D. 8
Your answer (A/B/C/D): c
Correct!

=== Quiz Over! ===
Your Score: 4 out of 5
Good job! Keep learning.
"C:\Users\chapp\OneDrive\Pictures\Screenshots\Screenshot 2025-06-25 222242.png"
