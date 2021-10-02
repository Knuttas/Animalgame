package com.animalgame;

import com.animalgame.abstractmodels.Animal;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * @author tvoul
 * @author knuttas
 * com.animalgame.Game class
 */

public class Game {

    ArrayList<Player> players;
    public Game() {
        Scanner myScanner = new Scanner(System.in);
        players = new ArrayList<>();

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
        for (int i = 0; i < amountOfPlayers; i++){
            System.out.println("Enter player name");
            String inputName = myScanner.next();
            players.add(new Player(inputName, 10000));
        }

        for (int roundCounter = 0; roundCounter < amountOfRounds; roundCounter++) {
            for (int playerCounter = 0; playerCounter < players.size(); playerCounter++) {
                System.out.println("Round: " + (roundCounter+1));
                System.out.println(players.get(playerCounter).getPlayerName() + "'s turn. You have " + players.get(playerCounter).getPlayerMoney() + " dollars available.");
                for (int z = 0; z < players.get(playerCounter).getAnimalListSize(); z++) {
                    if (players.get(playerCounter).getAnimalFromList(z).getHealth() <= 0) {
                        System.out.println(players.get(playerCounter).getAnimalFromList(z).getName() + " has died");
                        players.get(playerCounter).removeAnimalFromList(z);
                        z -= 1;
                    }
                }
                if (players.get(playerCounter).getAnimalListSize() != 0){
                    players.get(playerCounter).printAnimalList();
                }
                System.out.println("Meat: " + players.get(playerCounter).getMeatOwned() + " kgs owned.");
                System.out.println("Hay: " + players.get(playerCounter).getHayOwned() + " kgs owned.");
                System.out.println("Salad: " + players.get(playerCounter).getSaladOwned() + " kgs owned.");
                System.out.println("Please choose one of the following: ");
                System.out.println("1. Buy animal  2. Buy food  3. Feed animals  4. Breed animals  5. Sell animals");
                int choice = myScanner.nextInt();
                if (choice == 1){
                    Store.buyAnimal(players.get(playerCounter));
                }
                else if (choice == 2) {
                    Store.buyFood(players.get(playerCounter));
                }
                else if (choice == 3) {
                    if (players.get(playerCounter).getAnimalListSize() == 0) {
                        System.out.println("You don't own any animals, do you want to buy at the store or end your turn?");
                        System.out.println("1. Go to store  2. End turn");
                        int goToStore = myScanner.nextInt();
                        if (goToStore == 1) {
                            Store.buyAnimal(players.get(playerCounter));
                        }
                    } else {
                        players.get(playerCounter).feedAnimal();
                    }

                } else if (choice == 4) {
                    if (players.get(playerCounter).getAnimalListSize() < 2) {
                        System.out.println("You don't have enough animals, do you want to go to the store and buy or end your turn?");
                        System.out.println("1. Go to store  2. End turn");
                        int goToStore = myScanner.nextInt();
                        if (goToStore == 1) {
                            Store.buyAnimal(players.get(playerCounter));
                        }
                    } else {
                        System.out.println("Please choose which 2 animals to pair");
                        players.get(playerCounter).printBreed();
                        System.out.println("Please pick your first animal");
                        int animal1 = myScanner.nextInt();
                        while (animal1 <= 0 || animal1 > players.get(playerCounter).getAnimalListSize()){
                            System.out.println("Please enter a valid number.");
                            animal1 = myScanner.nextInt();
                        }
                        System.out.println("Please pick your second animal");
                        int animal2 = myScanner.nextInt();
                        while (animal2 <= 0 || animal2 > players.get(playerCounter).getAnimalListSize() || animal2 == animal1) {
                            System.out.println("Please enter a valid number.");
                            animal2 = myScanner.nextInt();
                        }
                        Animal.pair(players.get(playerCounter), players.get(playerCounter).getAnimalFromList(animal1 -1), players.get(playerCounter).getAnimalFromList(animal2 -1));
                    }
                } else if (choice == 5) {
                    Store.sellAnimal(players.get(playerCounter));
                } else {
                    System.out.println("Invalid choice");
                }
                for (int p = 0; p < players.get(playerCounter).getAnimalListSize(); p++){
                    players.get(playerCounter).getAnimalFromList(p).depreciateHealth();
                }

                if (players.get(playerCounter).getPlayerMoney() < 100 && players.get(playerCounter).getAnimalListSize() == 0) {
                    System.out.println("Player " + players.get(playerCounter).getPlayerName() + " is out of money and animals and is removed from the game");
                    players.remove(playerCounter);
                    playerCounter -= 1;
                }
            }
            if (roundCounter == (amountOfRounds-1)){
                System.out.println("That was the last round! All animals will now sell.");
            }
        }
        for (int k = 0; k < players.size(); k++) {
            if (players.get(k).getAnimalListSize() != 1){
                for ( int j = 0; j < players.get(k).getAnimalListSize(); j++){
                    int dogValue = 100, horseValue = 200, lizardValue = 300, cowValue = 400, sheepValue = 500;
                    switch (players.get(k).getAnimalFromList(j).getRace()){
                        case "dog":
                            players.get(k).setPlayerMoney(players.get(k).getAnimalFromList(j).getHealth() * dogValue / 100);
                            break;
                        case "horse":
                            players.get(k).setPlayerMoney(players.get(k).getAnimalFromList(j).getHealth() * horseValue / 100);
                            break;
                        case "lizard":
                            players.get(k).setPlayerMoney(players.get(k).getAnimalFromList(j).getHealth() * lizardValue / 100);
                            break;
                        case "cow":
                            players.get(k).setPlayerMoney(players.get(k).getAnimalFromList(j).getHealth() * cowValue / 100);
                            break;
                        case "sheep":
                            players.get(k).setPlayerMoney(players.get(k).getAnimalFromList(j).getHealth() * sheepValue / 100);
                            break;
                    }
                }
            }
            System.out.println(players.get(k).getPlayerName() + "'s total amount of money is " + players.get(k).getPlayerMoney() + "$");
        }
        if (players.size() > 1) {
            int winner = 0;
            String nameWinner = "";
            for (int q = 0; q < players.size(); q++) {
                if (winner < players.get(q).getPlayerMoney()){
                    winner = players.get(q).getPlayerMoney();
                    nameWinner = players.get(q).getPlayerName();
                }
            }
            System.out.println("The winner is " + nameWinner + " with " + winner + "$!");
        }
        System.out.println("Game over! Thanks for playing.");
    }
    }

