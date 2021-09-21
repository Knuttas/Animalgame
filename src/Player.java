import java.util.ArrayList;

public class Player {
    private String name;
    private int money;
    ArrayList<Animal> animalsOwned = new ArrayList<>();

    public Player(String name, int money){
        this.name = name;
        this.money = money;
    }

    public String getPlayerName(){
        return this.name;
    }
}
