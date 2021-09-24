import java.util.ArrayList;
import java.util.Scanner;
/**
 * @author tvoul
 * @author knuttas
 * Game class
 */

public class Game {
    public Game() {
        Scanner myScanner = new Scanner(System.in);

        System.out.println("Enter amount of players 1-4");
        int amountOfPlayers = myScanner.nextInt();
        while (amountOfPlayers < 1 || amountOfPlayers > 4) {
            System.out.println("Please enter a number between 1-4");
            amountOfPlayers = myScanner.nextInt();
        }
        ArrayList<Player> players = new ArrayList<>();
        for (int i = 0; i < amountOfPlayers; i++){
            System.out.println("Enter player name");
            String inputName = myScanner.next();
            players.add(new Player(inputName, 10000));
        }

        System.out.println("Enter amount of rounds 5-30");
        int amountOfRounds = myScanner.nextInt();
        while (amountOfRounds < 5 || amountOfRounds > 30) {
            System.out.println("Please enter a number between 5-30");
            amountOfRounds = myScanner.nextInt();
        }

        for (int i = 0; i < amountOfRounds; i++) {
            for (int x = 0; x < players.size(); x++) {

                System.out.println(players.get(x).getPlayerName() + "'s turn. You have " + players.get(x).getPlayerMoney() + " dollars available.");
                for ( int z = 0; z < players.get(x).animalsOwned.size(); z++) {
                    if (players.get(x).animalsOwned.get(z).getHealth() <= 0) {
                        System.out.println(players.get(x).animalsOwned.get(z).getName() + " has died");
                        players.get(x).animalsOwned.remove(z);
                    }
                }
                if (!players.get(x).animalsOwned.isEmpty()){
                    players.get(x).printAnimalList();
                }
                System.out.println("Meat: " + players.get(x).getMeatOwned() + " portions owned.");
                System.out.println("Hay: " + players.get(x).getHayOwned() + " portions owned.");
                System.out.println("Salad: " + players.get(x).getSaladOwned() + " portions owned.");
                System.out.println("Please choose one of the following: ");
                System.out.println("1. Buy animal  2. Buy food  3. Feed animals  4. Breed animals  5. Sell animals");
                int choice = myScanner.nextInt();
                if (choice == 1){
                    Store.buyAnimal(players.get(x));
                }
                else if (choice == 2) {
                    Store.buyFood(players.get(x));
                }
                else if (choice == 3) {
                    if (players.get(x).animalsOwned.isEmpty()) {
                        System.out.println("You don't own any animals, do you want to buy at the store or end your turn?");
                        System.out.println("1. Go to store  2. End turn");
                        int goToStore = myScanner.nextInt();
                        if (goToStore == 1) {
                            Store.buyAnimal(players.get(x));
                        }
                    } else {
                        players.get(x).feedAnimal(players.get(x));
                    }

                } else if (choice == 4) {
                    if (players.get(x).animalsOwned.size() < 2) {
                        System.out.println("You don't have enough animals, do you want to go to the store and buy or end your turn?");
                        System.out.println("1. Go to store  2. End turn");
                        int goToStore = myScanner.nextInt();
                        if (goToStore == 1) {
                            Store.buyAnimal(players.get(x));
                        }
                    } else {
                        System.out.println("Please choose which 2 animals to pair");
                        players.get(x).printBreed();
                        System.out.println("Please pick your first animal");
                        int animal1 = myScanner.nextInt();
                        System.out.println("Please pick your second animal");
                        int animal2 = myScanner.nextInt();
                        Animal.pair(players.get(x) , players.get(x).animalsOwned.get(animal1 -1), players.get(x).animalsOwned.get(animal2 -1));
                    }
                } else if (choice == 5) {
                    Store.sellAnimal(players.get(x));
                } else {
                    System.out.println("Invalid choice");
                }
                for (Animal y : players.get(x).animalsOwned){
                    y.depreciateHealth();
                }


                if (players.get(x).getPlayerMoney() < 100 && players.get(x).animalsOwned.isEmpty()) {
                    System.out.println("Player " + players.get(x).getPlayerName() + " is out of money and animals and is removed from the game");
                    players.remove(x);
                }
            }
        }
        for (int k = 0; k < players.size(); k++) {
            if (!players.get(k).animalsOwned.isEmpty()){
                for ( int j = 0; j < players.get(k).animalsOwned.size(); j++){
                    int dogValue = 100, horseValue = 200, lizardValue = 300, cowValue = 400, sheepValue = 500;
                    switch (players.get(k).animalsOwned.get(j).getRace()){
                        case "dog":
                            players.get(k).setPlayerMoney(players.get(k).animalsOwned.get(j).getHealth() * dogValue / 100);
                            break;
                        case "horse":
                            players.get(k).setPlayerMoney(players.get(k).animalsOwned.get(j).getHealth() * horseValue / 100);
                            break;
                        case "lizard":
                            players.get(k).setPlayerMoney(players.get(k).animalsOwned.get(j).getHealth() * lizardValue / 100);
                            break;
                        case "cow":
                            players.get(k).setPlayerMoney(players.get(k).animalsOwned.get(j).getHealth() * cowValue / 100);
                            break;
                        case "sheep":
                            players.get(k).setPlayerMoney(players.get(k).animalsOwned.get(j).getHealth() * sheepValue / 100);
                            break;
                    }
                }
            }
            System.out.println(players.get(k).getPlayerName() + "'s total amount of money is " + players.get(k).getPlayerMoney() + "$");
        }
        System.out.println("Game over! Thanks for playing.");
    }
    }

