package rockpaperscissors;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner optionScanner = new Scanner(System.in);
        String playerName;
        System.out.print("Enter your name: ");
        playerName = optionScanner.nextLine();
        System.out.println("Hello, " + playerName);

        int rating = getRating(playerName);
        String lineOfChoices = optionScanner.nextLine();

        if (lineOfChoices.isEmpty()) {
            StandardGameOfThree(rating, optionScanner);
        } else {
            ExtendedVersionOfGame(rating, lineOfChoices, optionScanner);
        }

    }

    public static int getRating(String playerName) {
        int rating = 350;
        File file = new File("/Users/retr0/IdeaProjects/Rock-Paper-Scissors/Rock-Paper-Scissors/task/src/rockpaperscissors/rating.txt");
        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNext()) {
                if (playerName.equals(fileScanner.next())) {
                    rating = fileScanner.nextInt();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
        return rating;
    }

    public static void StandardGameOfThree(int rating, Scanner scanner) {
        Random random = new Random();
        String[] choicesAvailable = {"rock", "paper", "scissors"};
        String userChoice = "";
        System.out.println("Okay, let's start");

        while (!(userChoice.equals("!exit"))) {
            userChoice = scanner.nextLine();
            String computerChoice = choicesAvailable[random.nextInt(3)];
            switch (userChoice) {
                case "rock" -> {
                    if (computerChoice.equals("paper")) {
                        System.out.println("Sorry, but the computer chose " + computerChoice);
                    } else if (computerChoice.equals("scissors")) {
                        System.out.println("Well done. The computer chose " + computerChoice + " and failed");
                        rating += 100;
                    } else {
                        System.out.println("There is a draw (" + computerChoice + ")");
                        rating += 50;
                    }
                }
                case "paper" -> {
                    if (computerChoice.equals("scissors")) {
                        System.out.println("Sorry, but the computer chose " + computerChoice);
                    } else if (computerChoice.equals("rock")) {
                        System.out.println("Well done. The computer chose " + computerChoice + " and failed");
                        rating += 100;
                    } else {
                        System.out.println("There is a draw (" + computerChoice + ")");
                        rating += 50;
                    }
                }
                case "scissors" -> {
                    if (computerChoice.equals("rock")) {
                        System.out.println("Sorry, but the computer chose " + computerChoice);
                    } else if (computerChoice.equals("paper")) {
                        System.out.println("Well done. The computer chose " + computerChoice + " and failed");
                        rating += 100;
                    } else {
                        System.out.println("There is a draw (" + computerChoice + ")");
                        rating += 50;
                    }
                }
                case "!rating" -> System.out.println("Your rating: " + rating);
                case "!exit" -> {
                    scanner.close();
                    System.out.println("Bye!");
                }
                default -> System.out.println("Invalid input");
            }
        }
    }

    public static void ExtendedVersionOfGame(int rating, String options, Scanner scanner) {
        Random random = new Random();
        String[] choicesAvailable = options.split(",");
        Element[] elementsInGame = new Element[choicesAvailable.length];

        int index = 0;
        File file = new File("/Users/retr0/IdeaProjects/Rock-Paper-Scissors/Rock-Paper-Scissors/task/src/rockpaperscissors/Elements.txt");
        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNext()) {
                String beforeAdd = fileScanner.next();
                if (options.contains(beforeAdd)) {
                    Element element = new Element();
                    element.name = beforeAdd;
                    element.counterPicks = fileScanner.nextLine();
                    elementsInGame[index] = element;
                    index++;
                } else {
                    fileScanner.nextLine();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File of elements not found!");
        }
        System.out.println("Okay, let's start");

        String userChoice = "";
        while (!"!exit".equals(userChoice)) {
            userChoice = scanner.nextLine();
            String computerChoice = choicesAvailable[random.nextInt(choicesAvailable.length)];

            if ("!exit".equals(userChoice)) {
                System.out.println("Bye!");
                continue;
            }

            if ("!rating".equals(userChoice)) {
                System.out.println(rating);
                continue;
            }

            if (!options.contains(userChoice)) {
                System.out.println("Invalid input!");
                continue;
            }

            if (userChoice.equals(computerChoice)) {
                System.out.println("There is a draw (" + computerChoice + ")");
                rating += 50;
            } else {
                String betterElements = "";
                for (Element element : elementsInGame) {
                    if (element.name.equals(userChoice)) {
                        betterElements = element.counterPicks;
                    }
                }

                if (betterElements.contains(computerChoice)) {
                    System.out.println("Well done. The computer chose " + computerChoice + " and failed");
                    rating += 100;
                } else {
                    System.out.println("Sorry, but the computer chose " + computerChoice);
                }
            }

        }
    }

    public static class Element {
        String name = " ";
        String counterPicks = " ";
    }

}
