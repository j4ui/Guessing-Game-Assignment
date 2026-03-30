import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to the Guessing Game!");
            System.out.println("Which level of the game do you want to play? (2, 3, 4)");
            String gameLevel = scanner.nextLine();

            switch (gameLevel) {
                case "2":
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

                case "3":
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

                case "4":
                    String again4;
                    do {
                        int secretNumber = (int) (100 * Math.random()) + 1;
                        int turn = 0;
                        int guess = 0;

                        System.out.println("Guess the number from 1 - 100 (inclusive)");
                        do {
                            guess = scanner.nextInt();
                            turn++;
                            if (guess != secretNumber) {
                                if (guess < secretNumber) {
                                    System.out.println("Too low");
                                } else {
                                    System.out.println("Too high");
                                }
                            }
                        } while (guess != secretNumber && turn < 10);
                        if (turn == 10 && guess != secretNumber) {
                            System.out.println("That was your tenth incorrect guess, the computer wins!");
                        }
                        System.out.println("Do you want to play again? (y/n)");
                        again4 = scanner.next();
                    } while (again4.equals("y"));
                    break;

                case "4+":
                    /*
                    -The level 4+ version uses the rules of Level 4, but instead of the user playing, the computer will play
                    itself by trying to guess the correct number.

                    -The user will determine the number of games the computer will play

                    -If the number of games selected is 5 or less, the user will be shown all the details of the game (i.e. the
                    computer guesses, the guess feedback etc.)

                    -If the number of games selected is more than 5, the user will only be shown a final win-loss summary.

                    -Note: There are several different strategies the computer can use to guess numbers, better marks for
                    the better strategy.
                     */

                    int secretNumber = (int) (100 * Math.random()) + 1;
                    int guess1, guess2, guess3, guess4, guess5, guess6, guess7, guess8, guess9 = 0;
                    int lastGuess = 0;
                    int turn = 1;
                    int high;
                    int low;
                    String feedback1, feedback2, feedback3, feedback4, feedback5, feedback6, feedback7, feedback8, feedback9;

                    System.out.println("Guess the number from 1 - 100 (inclusive)");
                    do {
                        switch (turn) {
                            case 1:
                                guess1 = 50;
                                lastGuess = guess1;
                                turn++;
                                if (lastGuess > secretNumber && lastGuess != secretNumber) {feedback1 = "Too High";}
                                else {feedback1 = "Too Low";}
                                System.out.println(lastGuess + "\n" + feedback1);
                                break;

                            case 2:
                                break;

                            case 3:
                                break;

                            case 4:
                                break;

                            case 5:
                                break;

                            case 6:
                                break;

                            case 7:
                                break;

                            case 8:
                                break;

                            case 9:
                                break;

                            case 10:
                                break;
                        }
                    } while (lastGuess != secretNumber);

                    break;

                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
    }
}
