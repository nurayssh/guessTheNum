import java.util.Random;
import java.util.Scanner;

public class playGame {

    int bestScore = 1000; // начальный рекорд

    public void start() {
        Scanner sc = new Scanner(System.in);
        Random number = new Random();

        System.out.println("Welcome to the game <Guess The Number>");
        System.out.println("======================================");

        boolean play = true;

        while (play) {

            System.out.println("Please choose the level of the game");
            System.out.println("1. Easy (1–50)");
            System.out.println("2. Normal (1–100)");
            System.out.println("3. Hard (1–500)");
            System.out.println();
            System.out.print("Choose option (1/2/3): ");

            int choice = sc.nextInt();
            sc.nextLine();
            int max = 0;

            if (choice == 1) {
                System.out.println("You chose easy level");
                max = 50;
            } else if (choice == 2) {
                System.out.println("You chose normal level");
                max = 100;
            } else if (choice == 3) {
                System.out.println("You chose hard level");
                max = 500;
            } else {
                System.out.println("Invalid option! Try again.");
                continue;
            }

            int secret = number.nextInt(max) + 1;
            int attempts = 0;

            System.out.println("I guessed a number from 1 to " + max + ". Try to guess!");

            while (true) {
                System.out.print("Your guess: ");
                int guess = sc.nextInt();
                sc.nextLine();
                attempts++;

                if (guess > secret) {
                    System.out.println("Too big!");
                } else if (guess < secret) {
                    System.out.println("Too small!");
                } else {
                    System.out.println("You guessed it! 🎉");
                    System.out.println("Attempts: " + attempts);


                    if (attempts < bestScore) {
                        bestScore = attempts;
                        System.out.println("🏆 New record! Your best score: " + bestScore + " attempts");
                    } else {
                        System.out.println("Best score so far: " + bestScore);
                    }
                    break;
                }
            }


            System.out.print("Do you want to play again? (y/n): ");
            String again = sc.nextLine().toLowerCase();

            if (!again.equals("y")) {
                play = false;
                System.out.println("Thanks for playing!");
            }

            System.out.println("======================================");
        }
    }

}
