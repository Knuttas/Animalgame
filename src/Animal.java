public abstract class Animal {
    protected String name;
    protected int gender;
    protected int health;

    public Animal (String name, int gender, int health){
        this.name = name;
        this.gender = gender;
        this.health = health;
    }

    public String getName(){
        return this.name;
    }

    public int getGender(){
        return this.gender;
    }

    public int getHealth(){
        return this.health;
    }

    public void feedHealth(){
        this.health += 10;
    }

    public void depreciateHealth(int health){
        this.health -= (Math.random()*3+1)*10;
    }
}
