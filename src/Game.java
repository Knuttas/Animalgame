import java.util.Objects;
import java.util.Scanner;

public class Game {
    public Game() {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter amount of rounds 5-30");
        int amountOfRounds = myScanner.nextInt();
        while (amountOfRounds < 5 || amountOfRounds > 30) {
            System.out.println("Please enter a number between 5-30");
            amountOfRounds = myScanner.nextInt();
        }

        System.out.println("Enter amount of players 1-4");
        int amountOfPlayers = myScanner.nextInt();
        while (amountOfPlayers < 1 || amountOfPlayers > 4) {
            System.out.println("Please enter a number between 1-4");
            amountOfPlayers = myScanner.nextInt();
        }

        Player[] players = new Player[amountOfPlayers];
        for (int i = 0; i < amountOfPlayers; i++) {
            System.out.println("Enter player name");
            String inputName = myScanner.next();
            players[i] = new Player(inputName, 10000);
        }
        for (int i = 0; i < amountOfRounds; i++) {
            for (int x = 0; x < players.length; x++) {
                System.out.println(players[x].getPlayerName() + "'s turn.");
                System.out.println("Please choose one of the following: ");
                System.out.println("1. Buy animal  2. Buy food  3. Feed animals  4. Breed animals  5. Sell animals");
                int choice = myScanner.nextInt();
                if (choice == 1){
                    System.out.println("What animal do you want to buy?");
                    System.out.println("1. Cow  2. Dog  3. Horse  4. Lizard  5. Sheep");
                    int animalChoice = myScanner.nextInt();
                    int amountOfAnimal;
                    if (animalChoice == 1){
                        System.out.println("How many cows do you want to buy?");
                        amountOfAnimal = myScanner.nextInt();
                    } else if (animalChoice == 2) {
                        System.out.println("How many dogs do you want to buy?");
                        amountOfAnimal = myScanner.nextInt();
                    } else if (animalChoice == 3) {
                        System.out.println("How many horses do you want to buy?");
                        amountOfAnimal = myScanner.nextInt();
                    } else if (animalChoice == 4) {
                        System.out.println("How many Lizards do you want to buy?");
                        amountOfAnimal = myScanner.nextInt();
                    } else if (animalChoice == 5) {
                        System.out.println("How many sheep do you want to buy?");
                        amountOfAnimal = myScanner.nextInt();
                    } else {
                        System.out.println("Invalid choice");
                    }
                } else if (choice == 2) {
                    System.out.println("What food do you want to buy?");
                    System.out.println("1. Hay  2. Meat  3. Salad");
                    int foodChoice = myScanner.nextInt();
                    int amountOfFood;
                    if (foodChoice == 1) {
                        System.out.println("How many kg of hay do you want to buy?");
                        amountOfFood = myScanner.nextInt();
                    } else if (foodChoice == 2) {
                        System.out.println("How many kg of meat do you want to buy?");
                        amountOfFood = myScanner.nextInt();
                    } else if (foodChoice == 3) {
                        System.out.println("How many kg of salad do you want to buy?");
                        amountOfFood = myScanner.nextInt();
                    } else {
                        System.out.println("Invalid choice");
                    }
                } else if (choice == 3) {
                    System.out.println("you fed an animal");
                } else if (choice == 4) {
                    System.out.println("you bred an animal");
                } else if (choice == 5) {
                    System.out.println("you sold an animal");
                } else {
                    System.out.println("Invalid choice");
                }
            }
        }
    }

    }

