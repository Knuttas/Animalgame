import java.util.Scanner;

public class Store {

    public void buyAnimal(Player player) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Pick animal: 1.Dog 2.Horse 3.Lizard 4.Cow 5. Sheep");
        int animalPick = scan.nextInt();
        System.out.println("How many of chosen animal category do you want?");
        int amountOfAnimals = scan.nextInt();
        for (int i = 0; i < amountOfAnimals; i++) {
            System.out.println("Enter name");
            String name = scan.next();
            System.out.println("Pick gender - 1 male, 2 female");
            int gender = scan.nextInt();
            if (animalPick == 1) {
                Dog dog = new Dog(name, gender, 100);
                player.addAnimalToList(dog);
            } else if (animalPick == 2) {
                Horse horse = new Horse(name, gender, 100);
                player.addAnimalToList(horse);
            } else if (animalPick == 3) {
                Lizard lizard = new Lizard(name, gender, 100);
                player.addAnimalToList(lizard);
            } else if (animalPick == 4) {
                Cow cow = new Cow(name, gender, 100);
                player.addAnimalToList(cow);
            } else if (animalPick == 5) {
                Sheep sheep = new Sheep(name, gender, 100);
                player.addAnimalToList(sheep);
            }
        }
    }


    public void buyFood(){
        Scanner scan = new Scanner(System.in);
        System.out.println("What food do you want? 1.Meat 2.Hay 3.Salad");
        int foodType = scan.nextInt();
        System.out.println("How much food? (in kg's)");
        //this.amountOfFood = scan.nextInt();
    }
}
