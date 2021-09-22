import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private String name;
    private int money;
    ArrayList<Animal> animalsOwned = new ArrayList<>();
    private int meatOwned = 0;
    private int saladOwned = 0;
    private int hayOwned = 0;

    Scanner scan = new Scanner(System.in);

    public Player(String name, int money){
        this.name = name;
        this.money = money;
    }

    public String getPlayerName(){
        return this.name;
    }

    public int getPlayerMoney() { return this.money; }

    public void setPlayerMoney(int amount) {
        this.money += amount;
    }

    public void addAnimalToList(Animal animal){
        animalsOwned.add(animal);
    }

    public void printBreed(){
        int counter =1;
        for (Animal x : animalsOwned){
            System.out.println(counter + ". " + x.getRace() + " " + x.getName());
            counter++;
        }
    }

    public void printAnimalList(){
        int counter = 1;
        for (Animal x : animalsOwned){
            System.out.println(counter + ". " + x.getName() + " " + x.getHealth() + "% health");
            counter++;
        }
    }

    public void feedAnimal(Player player){
        int counter = 1;
        for (Animal x : animalsOwned){
            System.out.println(counter + ". " + x.getName() + " " + x.getHealth() + "% health");
            counter++;
        }
        if (meatOwned == 0 && hayOwned == 0 && saladOwned == 0) {
            System.out.println("You have no food. Do you want to go to the store to buy?");
            System.out.println("1. Go to store  2. End turn");
            int goToStore = scan.nextInt();
            if (goToStore == 1) {
                Store.buyFood(player);
            }
        } else {
            // Needs improving, you must be able to choose which food to use etc
            System.out.println("Please choose which animal to feed");
            int animalToFeed = scan.nextInt();
            animalsOwned.get(animalToFeed - 1).feedHealth();
            System.out.println("You have fed " + animalsOwned.get(animalToFeed - 1).getName() + ". Health increased by 10%");

        }
    }
    public void killAnimal(Animal animal){
        animalsOwned.remove(animal);
    }

    public void setMeat(int amount){
        this.meatOwned += amount;
    }
    public void setSalad(int amount){
        this.saladOwned += amount;
    }
    public void setHay(int amount){
        this.hayOwned += amount;
    }
}
