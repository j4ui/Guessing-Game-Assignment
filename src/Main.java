import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Guessing Game!");
        System.out.println("Which level of the game do you want to play? (2 or 3)");
        int gameLevel = scanner.nextInt();

        switch (gameLevel) {
            case 2:
                do {
                    int secretNumber = (int) (100 * Math.random()) + 1;
                    int guess = 0;

                } while (false);
                break;

            case 3:
                String again;
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
                    again = scanner.next();
                } while (again.equals("y"));
                break;
            default:
                System.out.println("Invalid input");
                break;
        }


    }
}
