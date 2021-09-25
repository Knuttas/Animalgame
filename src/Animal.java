import java.util.Objects;
import java.util.Scanner;
/**
 * @author tvoul
 * @author knuttas
 * Animal abstract class
 */

public abstract class Animal {
    protected String name;
    protected int gender;
    protected int health;
    protected String race;
    static Scanner scan = new Scanner(System.in);


    public Animal (String name, String race, int gender, int health){
        this.name = name;
        this.race = race;
        this.gender = gender;
        this.health = health;
    }

    /**
     * Get animal name
     * @return get name
     */
    public String getName(){
        return this.name;
    }

    /**
     * Get animal gender
     * @return gender
     */
    public int getGender(){
        return this.gender;
    }

    /**
     * Get animal race
     * @return race
     */
    public String getRace(){
        return this.race;
    }

    /**
     * Get animal health
     * @return health
     */
    public int getHealth(){
        return this.health;
    }

    /**
     * Feed animals to increase their health
     * @param food receive different food types
     */
    public abstract void feedHealth(Food food);

    /**
     * Reduce health, random 10-30
     */
    public void depreciateHealth(){
        this.health -= (int) (Math.random()*(30-10)+10);
    }

    /**
     * Pair animals if they are of different gender, but same race
     * @param player receive player to be able to add to animal list
     * @param animal1 receive animal to check gender and race
     * @param animal2 receive animal to check gender and race
     */
    public static void pair(Player player, Animal animal1, Animal animal2){

        int pairChance = (int) (Math.random()*2+1);
        if (pairChance == 1 && (animal1.getGender() != animal2.getGender()) && (Objects.equals(animal1.getRace(), animal2.getRace()))) {
                int gender = (int) (Math.random()*2+1);
                String babyGender = "";
                if (gender == 1) {
                    babyGender = "male";
                } else if (gender == 2) {
                    babyGender = "female";
                }
                System.out.println("Breed successful, congratulations you have a new " + babyGender + "!");
                System.out.println("Please pick a name for your new animal!");
                String name = scan.next();
                if (animal1.getRace().equals("dog")) {
                    Dog dog = new Dog(name, "dog", gender, 100);
                    player.addAnimalToList(dog);
                } else if (animal1.getRace().equals("horse")) {
                    Horse horse = new Horse(name, "horse", gender, 100);
                    player.addAnimalToList(horse);
                } else if (animal1.getRace().equals("lizard")) {
                    Lizard lizard = new Lizard(name, "lizard", gender, 100);
                    player.addAnimalToList(lizard);
                } else if (animal1.getRace().equals("cow")) {
                    Cow cow = new Cow(name, "cow", gender, 100);
                    player.addAnimalToList(cow);
                } else if (animal1.getRace().equals("sheep")) {
                    Sheep sheep = new Sheep(name, "sheep", gender, 100);
                    player.addAnimalToList(sheep);
                }

            }
        else if (pairChance == 2 && (animal1.getGender() != animal2.getGender()) && (Objects.equals(animal1.getRace(), animal2.getRace()))) {
                System.out.println("Breed failed, better luck next time!");
            }
        else {
            System.out.println("Invalid breeding attempt!");
            }
        }

    }
