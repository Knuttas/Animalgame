public class Dog extends Animal{
    public Dog(String name, String race, int gender, int health) {
        super(name, race, gender, health);
    }


    public void feedHealth(){
        this.health += 10;
    }

}
