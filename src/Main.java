import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to the Guessing Game!");
            System.out.println("Which level of the game do you want to play? (2, 3, 4, 4+)");
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

                    System.out.println("How many games do you want the computer to play?");
                    int numGames = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    
                    int wins = 0;
                    int losses = 0;
                    
                    for (int game = 1; game <= numGames; game++) {
                        int secretNumber = (int) (100 * Math.random()) + 1;
                        int guess = 0;
                        int turn = 0;
                        int high = 100;
                        int low = 1;
                        boolean won = false;
                        
                        if (numGames <= 5) {
                            System.out.println("\n--- Game " + game + " ---");
                            System.out.println("Secret number: " + secretNumber);
                            System.out.println("Computer's guesses:");
                        }
                        
                        do {
                            guess = (high + low) / 2;
                            turn++;
                            
                            if (numGames <= 5) {
                                System.out.println("Turn " + turn + ": Computer guesses " + guess);
                            }
                            
                            if (guess == secretNumber) {
                                won = true;
                                if (numGames <= 5) {
                                    System.out.println("Correct! Computer won in " + turn + " turns!");
                                }
                                wins++;
                            } else if (guess < secretNumber) {
                                low = guess + 1;
                                if (numGames <= 5) {
                                    System.out.println("Too low");
                                }
                            } else {
                                high = guess - 1;
                                if (numGames <= 5) {
                                    System.out.println("Too high");
                                }
                            }
                        } while (guess != secretNumber && turn < 10);
                        
                        if (!won) {
                            if (numGames <= 5) {
                                System.out.println("Computer lost! Secret number was " + secretNumber);
                            }
                            losses++;
                        }
                    }
                    
                    System.out.println("\n=== Final Results ===");
                    System.out.println("Games played: " + numGames);
                    System.out.println("Computer wins: " + wins);
                    System.out.println("Computer losses: " + losses);
                    System.out.println("Win rate: " + (wins * 100 / numGames) + "%");
                    
                    break;

                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
    }
}
