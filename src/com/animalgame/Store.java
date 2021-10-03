package com.animalgame;

import com.animalgame.animals.*;

import java.util.Scanner;

/**
 * A static store where players can can buy/sell animals and only buy food.
 * @author knuttas, tvoul
 */
public class Store {
    static Scanner scan = new Scanner(System.in);

    /**
     * Buy animal
     * @param player receive player to adjust animal list, food owned, money
     */
    public static void buyAnimal(Player player) {
        int dogCost = 100, horseCost = 200, lizardCost = 300, cowCost = 400, sheepCost = 500;
        System.out.println("Pick animal: 1.Dog 100$  2.Horse 200$  3.Lizard 300$  4.Cow 400$  5.Sheep 500$");
        int animalPick = scan.nextInt();
        while (animalPick <= 0 || animalPick > 5) {
            System.out.println("Please enter a number between 1 and 5.");
            animalPick = scan.nextInt();
        }
        System.out.println("How many of chosen animal category do you want?");
        int amountOfAnimals = scan.nextInt();
        while (amountOfAnimals < 1){
            System.out.println("Please input a number larger than 0");
            amountOfAnimals = scan.nextInt();
        }

        switch (animalPick) {
            case 1:
                if (dogCost * amountOfAnimals > player.getPlayerMoney()){
                    System.out.println("You can't afford that, try again");
                    buyAnimal(player);
                }
                break;
            case 2:
                if (horseCost * amountOfAnimals > player.getPlayerMoney()){
                    System.out.println("You can't afford that, try again");
                    buyAnimal(player);
                }
                break;
            case 3:
                if (lizardCost * amountOfAnimals > player.getPlayerMoney()){
                    System.out.println("You can't afford that, try again");
                    buyAnimal(player);
                }
                break;
            case 4:
                if (cowCost * amountOfAnimals > player.getPlayerMoney()){
                    System.out.println("You can't afford that, try again");
                    buyAnimal(player);
                }
                break;
            case 5:
                if (sheepCost * amountOfAnimals > player.getPlayerMoney()){
                    System.out.println("You can't afford that, try again");
                    buyAnimal(player);
                }
                break;

        }

        for (int i = 0; i < amountOfAnimals; i++) {
            System.out.println("Pick gender - 1 male, 2 female");
            int gender = scan.nextInt();
            while (gender <= 0 || gender > 2){
                System.out.println("Please enter 1 or 2.");
                gender = scan.nextInt();
            }
            System.out.println("Enter name");
            String name = scan.next();
            if (animalPick == 1) {
                Dog dog = new Dog(name, "dog", gender, 100);
                player.addAnimalToList(dog);
                player.setPlayerMoney(-dogCost);
            } else if (animalPick == 2) {
                Horse horse = new Horse(name, "horse", gender, 100);
                player.addAnimalToList(horse);
                player.setPlayerMoney(-horseCost);
            } else if (animalPick == 3) {
                Lizard lizard = new Lizard(name,"lizard", gender, 100);
                player.addAnimalToList(lizard);
                player.setPlayerMoney(-lizardCost);
            } else if (animalPick == 4) {
                Cow cow = new Cow(name, "cow", gender, 100);
                player.addAnimalToList(cow);
                player.setPlayerMoney(-cowCost);
            } else if (animalPick == 5) {
                Sheep sheep = new Sheep(name, "sheep", gender, 100);
                player.addAnimalToList(sheep);
                player.setPlayerMoney(-sheepCost);
            }
        }
        System.out.println("Do you want to buy more animals?");
        System.out.println("1. Buy more animals  2. End turn");
        int buyMore = scan.nextInt();
        if (buyMore == 1){
            buyAnimal(player);
        }
    }

    /**
     * Sell animal
     * @param player receive player to adjust animal list and money
     */
    public static void sellAnimal(Player player){
        int dogValue = 100, horseValue = 150, lizardValue = 225, cowValue = 300, sheepValue = 375;

        if (player.getAnimalListSize() == 0) {
            System.out.println("You don't own any animals, do you want to buy at the store or end your turn?");
            System.out.println("1. Go to store  2. End turn");
            int goToStore = scan.nextInt();
            if (goToStore == 1) {
                buyAnimal(player);
            }
        } else {
            System.out.println("These are your animals, which one would you like to sell?");
            player.printAnimalList();
            int whichToSell = scan.nextInt();
            while (whichToSell <= 0 || whichToSell > player.getAnimalListSize()){
                System.out.println("Please enter a valid number.");
                whichToSell = scan.nextInt();
            }

            switch (player.getAnimalFromList(whichToSell -1).getRace()){
                case "dog":
                    player.setPlayerMoney(player.getAnimalFromList(whichToSell - 1).getHealth() * dogValue / 100);
                    System.out.println(player.getAnimalFromList(whichToSell - 1).getName() + " sold. Gained" + player.getAnimalFromList(whichToSell - 1).getHealth() * dogValue / 100 + "$");
                    break;
                case "horse":
                    player.setPlayerMoney(player.getAnimalFromList(whichToSell - 1).getHealth() * horseValue / 100);
                    System.out.println(player.getAnimalFromList(whichToSell - 1).getName() + " sold. Gained" + player.getAnimalFromList(whichToSell - 1).getHealth() * horseValue / 100 + "$");
                    break;
                case "lizard":
                    player.setPlayerMoney(player.getAnimalFromList(whichToSell - 1).getHealth() * lizardValue / 100);
                    System.out.println(player.getAnimalFromList(whichToSell - 1).getName() + " sold. Gained" + player.getAnimalFromList(whichToSell - 1).getHealth() * lizardValue / 100 + "$");
                    break;
                case "cow":
                    player.setPlayerMoney(player.getAnimalFromList(whichToSell - 1).getHealth() * cowValue / 100);
                    System.out.println(player.getAnimalFromList(whichToSell - 1).getName() + " sold. Gained" + player.getAnimalFromList(whichToSell - 1).getHealth() * cowValue / 100 + "$");
                    break;
                case "sheep":
                    player.setPlayerMoney(player.getAnimalFromList(whichToSell - 1).getHealth() * sheepValue / 100);
                    System.out.println(player.getAnimalFromList(whichToSell - 1).getName() + " sold. Gained" + player.getAnimalFromList(whichToSell - 1).getHealth() * sheepValue / 100 + "$");
                    break;
            }
            player.removeAnimalFromList(whichToSell -1);
            System.out.println("Do you wish to sell another animal?");
            System.out.println("1. Sell animal  2. End turn");
            int sellAgain = scan.nextInt();
            if (sellAgain == 1) {
                sellAnimal(player);
            }
        }
    }

    /**
     * Buy food
     * @param player receive player to adjust food owned and money
     */
    public static void buyFood(Player player){
        if (player.getPlayerMoney() < 30) {
            System.out.println("You can't afford any food. Ending turn.");
        } else {
            int buyMoreFood = 0;
            int meatCost = 100, hayCost = 50, saladCost = 30;
            System.out.println("What food do you want? 1.Meat 100$/kg  2.Hay 50$/kg  3.Salad 30$/kg");
            int foodChosen = scan.nextInt();
            while (foodChosen != 1 && foodChosen != 2 && foodChosen != 3){
                System.out.println("Please choose a number between 1 and 3.");
                foodChosen = scan.nextInt();
            }
            System.out.println("How many kgs?");
            int amount = scan.nextInt();
            while (amount < 1){
                System.out.println("Please enter a number larger than 1");
                amount = scan.nextInt();
            }

            switch (foodChosen) {
                case 1:
                    if (meatCost * amount > player.getPlayerMoney()) {
                        System.out.println("You can't afford that, try again");
                        buyFood(player);
                    }
                    break;
                case 2:
                    if (hayCost * amount > player.getPlayerMoney()) {
                        System.out.println("You can't afford that, try again");
                        buyFood(player);
                    }
                    break;
                case 3:
                    if (saladCost * amount > player.getPlayerMoney()) {
                        System.out.println("You can't afford that, try again");
                        buyFood(player);
                    }
                    break;
            }
            if (foodChosen == 1){
                player.setMeatOwned(amount);
                player.setPlayerMoney(-amount*meatCost);
            }
            else if (foodChosen == 2){
                player.setHayOwned(amount);
                player.setPlayerMoney(-amount*hayCost);
            }
            else if (foodChosen == 3){
                player.setSaladOwned(amount);
                player.setPlayerMoney(-amount*saladCost);
            }
            System.out.println("Do you want to buy more food?");
            System.out.println("1. Buy more food  2. End turn");
            buyMoreFood = scan.nextInt();
            if (buyMoreFood == 1){
                buyFood(player);
            }
        }
    }
}
