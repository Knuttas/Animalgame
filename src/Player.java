import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author tvoul
 * @author knuttas
 * Player class
 */

public class Player {
    private String name;
    private int money;
    ArrayList<Animal> animalsOwned = new ArrayList<>();
    private Food hay = new Hay();
    private Food meat = new Meat();
    private Food salad = new Salad();

    Scanner scan = new Scanner(System.in);

    public Player(String name, int money){
        this.name = name;
        this.money = money;
    }

    /**
     * Get player name
     * @return player name
     */
    public String getPlayerName(){
        return this.name;
    }

    /**
     * Get player money
     * @return player money
     */
    public int getPlayerMoney() { return this.money; }

    /**
     * Set player money
     * @param amount
     */
    public void setPlayerMoney(int amount) {
        this.money += amount;
    }

    /**
     * Add animal to players animal list
     * @param animal
     */
    public void addAnimalToList(Animal animal){
        animalsOwned.add(animal);
    }

    /**
     * Print breed - used in pairing for example
     */
    public void printBreed(){
        int counter =1;
        for (Animal x : animalsOwned){
            System.out.println(counter + ". " + x.getRace() + " " + x.getName());
            counter++;
        }
    }

    /**
     * Print animal list
     */
    public void printAnimalList(){
        int counter = 1;
        for (Animal x : animalsOwned){
            System.out.println(counter + ". " + x.getName() + " " + x.getHealth() + "% health");
            counter++;
        }
    }

    /**
     * Feed animal
     * @param player
     */
    public void feedAnimal(Player player) {
        int counter = 1;
        for (Animal x : animalsOwned) {
            System.out.println(counter + ". " + x.getName() + " " + x.getHealth() + "% health");
            counter++;
        }
        if (meat.getAmountOwned() == 0 && hay.getAmountOwned() == 0 && salad.getAmountOwned() == 0) {
            System.out.println("You have no food. Do you want to go to the store to buy?");
            System.out.println("1. Go to store  2. End turn");
            int goToStore = scan.nextInt();
            if (goToStore == 1) {
                Store.buyFood(player);
            }
        } else {
            System.out.println("Please choose which animal to feed");
            int animalToFeed = scan.nextInt();
            System.out.println("Please choose which food:");
            System.out.println("1.Meat 2.Hay 3.Salad");
            int foodChosen = scan.nextInt();
            if (foodChosen == 1) {
                animalsOwned.get(animalToFeed - 1).feedHealth(meat);
            } else if (foodChosen == 2) {
                animalsOwned.get(animalToFeed - 1).feedHealth(hay);
            } else if (foodChosen == 3) {
                animalsOwned.get(animalToFeed - 1).feedHealth(salad);
            }
        }
    }

    /**
     * Adjust amount meat owned
     * @param amount
     */
    public void setMeatOwned(int amount){
        meat.setAmountOwned(amount);
    }

    /**
     * Adjust amount hay owned
     * @param amount
     */
    public void setHayOwned(int amount){
        hay.setAmountOwned(amount);
    }

    /**
     * Adjust amount salad owned
     * @param amount
     */
    public void setSaladOwned(int amount){
        salad.setAmountOwned(amount);
    }

}
