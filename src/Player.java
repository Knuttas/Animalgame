import java.util.ArrayList;

public class Player {
    private String name;
    private int money;
    ArrayList<Animal> animalsOwned = new ArrayList<>();
    private int meatOwned;
    private int saladOwned;
    private int hayOwned;

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

    public void removeAnimalFromList(Animal animal){
        //NEEDS WORK
        animalsOwned.remove(animal);
    }
    public void printAnimalList(){
        for (Animal x : animalsOwned){
            System.out.println(x.getName());
        }
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
