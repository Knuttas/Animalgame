import java.util.Scanner;
/**
 * @author tvoul
 * @author knuttas
 * Store class
 */

public class Store {
    static Scanner scan = new Scanner(System.in);

    /**
     * Buy animal
     * @param player receive player to adjust animal list, food owned, money
     */
    public static void buyAnimal(Player player) {
        int dogCost = 100, horseCost = 200, lizardCost = 300, cowCost = 400, sheepCost = 500;
        System.out.println("Pick animal: 1. Dog 100$  2. Horse 200$  3. Lizard 300$  4. Cow 400$  5. Sheep 500$");
        int animalPick = scan.nextInt();
        System.out.println("How many of chosen animal category do you want?");
        int amountOfAnimals = scan.nextInt();

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
            System.out.println("Enter name");
            String name = scan.next();
            System.out.println("Pick gender - 1 male, 2 female");
            int gender = scan.nextInt();
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
    }

    /**
     * Sell animal
     * @param player receive player to adjust animal list and money
     */
    public static void sellAnimal(Player player){
        int dogValue = 100, horseValue = 150, lizardValue = 225, cowValue = 300, sheepValue = 375;

        if (player.animalsOwned.isEmpty()) {
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

            switch (player.animalsOwned.get(whichToSell - 1).getRace()){
                case "dog":
                    player.setPlayerMoney(player.animalsOwned.get(whichToSell - 1).getHealth() * dogValue / 100);
                    System.out.println(player.animalsOwned.get(whichToSell - 1).getName() + " sold. Gained " + player.animalsOwned.get(whichToSell - 1).getHealth() * dogValue / 100 + "$");
                    break;
                case "horse":
                    player.setPlayerMoney(player.animalsOwned.get(whichToSell - 1).getHealth() * horseValue / 100);
                    System.out.println(player.animalsOwned.get(whichToSell - 1).getName() + " sold. Gained " + player.animalsOwned.get(whichToSell - 1).getHealth() * horseValue / 100 + "$");
                    break;
                case "lizard":
                    player.setPlayerMoney(player.animalsOwned.get(whichToSell - 1).getHealth() * lizardValue / 100);
                    System.out.println(player.animalsOwned.get(whichToSell - 1).getName() + " sold. Gained " + player.animalsOwned.get(whichToSell - 1).getHealth() * lizardValue / 100 + "$");
                    break;
                case "cow":
                    player.setPlayerMoney(player.animalsOwned.get(whichToSell - 1).getHealth() * cowValue / 100);
                    System.out.println(player.animalsOwned.get(whichToSell - 1).getName() + " sold. Gained " + player.animalsOwned.get(whichToSell - 1).getHealth() * cowValue / 100 + "$");
                    break;
                case "sheep":
                    player.setPlayerMoney(player.animalsOwned.get(whichToSell - 1).getHealth() * sheepValue / 100);
                    System.out.println(player.animalsOwned.get(whichToSell - 1).getName() + " sold. Gained " + player.animalsOwned.get(whichToSell - 1).getHealth() * sheepValue / 100 + "$");
                    break;
            }
            player.animalsOwned.remove(whichToSell - 1);
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
        int meatCost = 100, hayCost = 50, saladCost = 30;
        System.out.println("What food do you want? 1. Meat 100$/portion  2. Hay 50$/portion  3. Salad 30$/portion");
        int foodChosen = scan.nextInt();
        System.out.println("How many portions?");
        int amount = scan.nextInt();

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
    }
}
