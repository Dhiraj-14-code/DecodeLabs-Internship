import java.util.Random;
import java.util.Scanner;

public class DecodeLabs_Java_P1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        boolean playAgain = true;

        System.out.println("=== Welcome to Number Guessing Game ===");

        while (playAgain) {
            int secretNumber = random.nextInt(100) + 1; // 1 to 100
            int guess = 0;
            int attempts = 0;
            int maxAttempts = 10;

            System.out.println("\nI have chosen a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts.");

            while (guess != secretNumber && attempts < maxAttempts) {
                System.out.print("Enter your guess: ");

                try {
                    guess = sc.nextInt();
                    attempts++;

                    if (guess < secretNumber) {
                        System.out.println("Too low!");
                    } else if (guess > secretNumber) {
                        System.out.println("Too high!");
                    } else {
                        System.out.println("Correct! You guessed it in " + attempts + " attempts.");
                    }

                } catch (Exception e) {
                    System.out.println("Invalid input! Please enter a number.");
                    sc.nextLine(); // clear invalid input buffer
                    continue;
                }
            }

            if (guess != secretNumber) {
                System.out.println("Game Over! The correct number was: " + secretNumber);
            }

            sc.nextLine(); // clear leftover newline

            System.out.print("Do you want to play again? (yes/no): ");
            String choice = sc.nextLine();

            if (!choice.equalsIgnoreCase("yes")) {
                playAgain = false;
            }
        }

        System.out.println("Thanks for playing!");
        sc.close();
    }
}