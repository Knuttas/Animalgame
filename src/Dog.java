public class Dog extends Animal{
    public Dog(String name, String race, int gender, int health) {
        super(name, race, gender, health);
    }


    public void feedHealth(Food food) {
        if (food.getFoodName().equals("meat")) {
            System.out.println("I like meat! My health increased by 10!");
            this.health += 10;
            food.setAmountOwned(-1);
        }
        else if (food.getFoodName().equals("hay")){
            System.out.println("I do not like hay!");
        }
        else if (food.getFoodName().equals("salad")){
            System.out.println("I do not like salad!");
        }
    }
}
