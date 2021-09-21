import java.util.Objects;

public abstract class Animal {
    protected String name;
    protected int gender;
    protected int health;
    protected String race;
    protected boolean alive = true;

    public Animal (String name, String race, int gender, int health){
        this.name = name;
        this.race = race;
        this.gender = gender;
        this.health = health;
    }

    public String getName(){
        return this.name;
    }

    public int getGender(){
        return this.gender;
    }

    public String getRace() { return this.race; }

    public int getHealth(){
        return this.health;
    }

    public void feedHealth(){
        this.health += 10;
    }

    public void depreciateHealth(){
        this.health -= (int) (Math.random()*(30-10)+10);
    }

    public void kill(){
        this.alive = false;
        //NEEDS TO ALSO REMOVE ANIMAL FROM PLAYER LIST
    }

    public void pair(Animal animal1, Animal animal2){
        if ((animal1.getGender() != animal2.getGender()) && (Objects.equals(animal1.getRace(), animal2.getRace()))){
            System.out.println("Breed successful");
        } else {
            System.out.println("Breed failed");
        }
    }
}
