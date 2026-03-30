import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to the Guessing Game!");
            System.out.println("Which level of the game do you want to play? (2, 3, 4)");
            int gameLevel = scanner.nextInt();

            switch (gameLevel) {
                case 2:
                    do {
                        int secretNumber = (int) (100 * Math.random()) + 1;
                        int guess = 0;

                        System.out.println("Guess the number from 1 - 100 (inclusive)");
                        do {
                            guess = scanner.nextInt();
                            if (guess != secretNumber) {
                                if (guess < secretNumber) {
                                    System.out.println("Too low");
                                } else {
                                    System.out.println("Too high");
                                }
                            }
                        } while (guess != secretNumber);
                    } while (false);
                    break;

                case 3:
                    String again3;
                    do {
                        int secretNumber = (int) (100 * Math.random()) + 1;
                        int guess = 0;

                        System.out.println("Guess the number from 1 - 100 (inclusive)");
                        do {
                            guess = scanner.nextInt();
                            if (guess != secretNumber) {
                                if (guess < secretNumber) {
                                    System.out.println("Too low");
                                } else {
                                    System.out.println("Too high");
                                }
                            }
                        } while (guess != secretNumber);
                        System.out.println("Do you want to play again? (y/n)");
                        again3 = scanner.next();
                    } while (again3.equals("y"));
                    break;

                case 4:
                    String again4;
                    do {
                        int secretNumber = (int) (100 * Math.random()) + 1;
                        int guessAmount = 0;
                        int guess = 0;

                        System.out.println("Guess the number from 1 - 100 (inclusive)");
                        do {
                            guess = scanner.nextInt();
                            guessAmount++;
                            if (guess != secretNumber) {
                                if (guess < secretNumber) {
                                    System.out.println("Too low");
                                } else {
                                    System.out.println("Too high");
                                }
                            }
                        } while (guess != secretNumber && guessAmount < 10);
                        if (guessAmount == 10 && guess != secretNumber) {
                            System.out.println("That was your tenth incorrect guess, the computer wins!");
                        }
                        System.out.println("Do you want to play again? (y/n)");
                        again4 = scanner.next();
                    } while (again4.equals("y"));
                    break;

                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
    }
}
