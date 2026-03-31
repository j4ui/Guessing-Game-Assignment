import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to the Guessing Game!");
            System.out.println("Which level of the game do you want to play? (2, 3, 4, 4+)");
            String gameLevel;
            gameLevel = scanner.nextLine();
            if (!gameLevel.equals("2") && !gameLevel.equals("3") && !gameLevel.equals("4") && !gameLevel.equals("4+")) {
                do {
                    System.out.println("Please enter a valid level");
                    gameLevel = scanner.nextLine();
                } while (!gameLevel.equals("2") && !gameLevel.equals("3") && !gameLevel.equals("4") && !gameLevel.equals("4+"));
            }


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
                        System.out.println("Correct! You won!");
                    } while (false);
                    break;

                case "3":
                    String again3;
                    do {
                        int guess = 0;
                        System.out.println("Enter the minimum value:");
                        int min = scanner.nextInt();
                        System.out.println("Enter the maximum value:");
                        int max = scanner.nextInt();

                        if (min > max) {
                            do {
                                System.out.println("The minimum value must be less than the maximum value");
                                System.out.println("Enter the minimum value:");
                                min = scanner.nextInt();
                                System.out.println("Enter the maximum value:");
                                max = scanner.nextInt();
                            } while (min > max);
                        }

                        int secretNumber = (int) ((max-min+1) * Math.random()) + min;

                        System.out.println("Guess the number from " + min + " - " + max + " (inclusive)");
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
                    int turn = 0;
                    int guess = 0;

                    System.out.println("Enter the minimum value:");
                    int min = scanner.nextInt();
                    System.out.println("Enter the maximum value:");
                    int max = scanner.nextInt();

                    if (min > max) {
                        do {
                            System.out.println("The minimum value must be less than the maximum value");
                            System.out.println("Enter the minimum value:");
                            min = scanner.nextInt();
                            System.out.println("Enter the maximum value:");
                            max = scanner.nextInt();
                        } while (min > max);
                    }

                    int secretNumber = (int) ((max-min+1) * Math.random()) + min;

                    System.out.println("Guess the number from " + min + " - " + max + " (inclusive)");
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
                    } else {
                        System.out.println("Correct! You won!");
                    }
                    break;

                case "4+":
                    System.out.println("How many games do you want the computer to play?");
                    int numGames = scanner.nextInt();
                    scanner.nextLine();

                    if (numGames < 1) {
                        do {
                            System.out.println("The computer must play at least one game!");
                            System.out.println("How many games do you want the computer to play?");
                            numGames = scanner.nextInt();
                        } while (numGames < 1);
                    }

                    System.out.println("Enter the minimum value:");
                    int minFourPlus = scanner.nextInt();
                    System.out.println("Enter the maximum value:");
                    int maxFourPlus = scanner.nextInt();

                    if (minFourPlus > maxFourPlus) {
                        do {
                            System.out.println("The minimum value must be less than the maximum value");
                            System.out.println("Enter the minimum value:");
                            minFourPlus = scanner.nextInt();
                            System.out.println("Enter the maximum value:");
                            maxFourPlus = scanner.nextInt();
                        } while (minFourPlus > maxFourPlus);
                    }

                    int wins = 0;
                    int losses = 0;

                    for (int game = 1; game <= numGames; game++) {
                        int secretNumberFourPlus = (int) ((maxFourPlus-minFourPlus+1) * Math.random()) + minFourPlus;
                        int guessFourPlus = 0;
                        int turnFourPlus = 0;
                        int high = maxFourPlus;
                        int low = minFourPlus;
                        boolean won = false;

                        if (numGames <= 5) {
                            System.out.println("\n--- Game " + game + " ---");
                            System.out.println("Secret number: " + secretNumberFourPlus);
                            System.out.println("Computer's guesses:");
                        }

                        do {
                            guessFourPlus = (high + low) / 2;
                            turnFourPlus++;

                            if (numGames <= 5) {
                                System.out.println("Turn " + turnFourPlus + ": Computer guesses " + guessFourPlus);
                            }

                            if (guessFourPlus == secretNumberFourPlus) {
                                won = true;
                                if (numGames <= 5) {
                                    System.out.println("Correct! Computer won in " + turnFourPlus + " turns!");
                                }
                                wins++;
                            } else if (guessFourPlus < secretNumberFourPlus) {
                                low = guessFourPlus + 1;
                                if (numGames <= 5) {
                                    System.out.println("Too low");
                                }
                            } else {
                                high = guessFourPlus - 1;
                                if (numGames <= 5) {
                                    System.out.println("Too high");
                                }
                            }
                        } while (guessFourPlus != secretNumberFourPlus && turnFourPlus < 10);

                        if (!won) {
                            if (numGames <= 5) {
                                System.out.println("Computer lost! Secret number was " + secretNumberFourPlus);
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
            }
            scanner.nextLine();
        }

    }
}
