import java.util.Scanner;

public class Store {
    static Scanner scan = new Scanner(System.in);

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

    public static void sellAnimal(Player player){
        int dogValue = 75, horseValue = 150, lizardValue = 225, cowValue = 300, sheepValue = 375;

        if (player.animalsOwned.isEmpty() == true) {
            System.out.println("You don't own any animals, do you want to buy at the store or end your turn?");
            System.out.println("1. Go to store  2. End turn");
            int goToStore = scan.nextInt();
            if (goToStore == 1) {
                buyAnimal(player);
            }
        } else {
            System.out.println("These are your animals, which one would you like to sell for 75% of initial cost?");
            player.printAnimalList();
            int whichToSell = scan.nextInt();

            switch (player.animalsOwned.get(whichToSell - 1).getRace()){
                case "dog":
                    player.setPlayerMoney(dogValue);
                    System.out.println(player.animalsOwned.get(whichToSell - 1).getName() + " sold. Gained " + dogValue + "$");
                    break;
                case "horse":
                    player.setPlayerMoney(horseValue);
                    System.out.println(player.animalsOwned.get(whichToSell - 1).getName() + " sold. Gained " + horseValue + "$");
                    break;
                case "lizard":
                    player.setPlayerMoney(lizardValue);
                    System.out.println(player.animalsOwned.get(whichToSell - 1).getName() + " sold. Gained " + lizardValue + "$");
                    break;
                case "cow":
                    player.setPlayerMoney(cowValue);
                    System.out.println(player.animalsOwned.get(whichToSell - 1).getName() + " sold. Gained " + cowValue + "$");
                    break;
                case "sheep":
                    player.setPlayerMoney(sheepValue);
                    System.out.println(player.animalsOwned.get(whichToSell - 1).getName() + " sold. Gained " + sheepValue + "$");
                    break;
            }
            player.animalsOwned.remove(whichToSell - 1);
        }
    }


    public static void buyFood(Player player){
        int meatCost = 100, hayCost = 50, saladCost = 30;
        System.out.println("What food do you want? 1. Meat 100$/kg  2. Hay 50$/kg  3. Salad 30$/kg");
        int foodChosen = scan.nextInt();
        System.out.println("How much in kgs?");
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
            player.setMeat(amount);
        }
        else if (foodChosen == 2){
            player.setHay(amount);
        }
        else if (foodChosen == 3){
            player.setSalad(amount);
        }

    }
}
