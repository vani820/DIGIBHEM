import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Number Guessing Game!");

        boolean playAgain = true;
        while (playAgain) {
            System.out.print("Enter the minimum number of the range: ");
            int min = scanner.nextInt();
            System.out.print("Enter the maximum number of the range: ");
            int max = scanner.nextInt();

            int randomNumber = random.nextInt(max - min + 1) + min;
            int maxGuesses = 5; // Limiting guesses to 5

            System.out.println("I've selected a number between " + min + " and " + max + ". You have " + maxGuesses + " guesses.");

            boolean hasGuessedCorrectly = false;
            for (int i = 0; i < maxGuesses; i++) {
                System.out.print("Guess #" + (i + 1) + ": ");
                int guess = scanner.nextInt();

                if (guess == randomNumber) {
                    hasGuessedCorrectly = true;
                    break;
                } else if (guess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (hasGuessedCorrectly) {
                System.out.println("Congratulations! You guessed the correct number.");
            } else {
                System.out.println("Sorry, you've run out of guesses. The correct number was: " + randomNumber);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainResponse = scanner.next();
            playAgain = playAgainResponse.equalsIgnoreCase("yes");
        }

        System.out.println("Thank you for playing!");
        scanner.close();
    }
}
