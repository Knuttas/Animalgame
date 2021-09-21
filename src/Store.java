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

        System.out.println("These are your animals, which one would you like to sell?");
        player.printAnimalList();
        System.out.println("Enter name of animal you wish to sell");
        //scan something
        //if list contains - remove
        //player.removeAnimalFromList();
    }


    public static void buyFood(Player player){
        System.out.println("What food do you want? 1.Meat 2.Hay 3.Salad");
        int foodChosen = scan.nextInt();
        System.out.println("How much in kgs?");
        int amount = scan.nextInt();
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
