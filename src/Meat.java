/**
 * @author tvoul
 * @author knuttas
 * Player class extends Food
 */

public class Meat extends Food{

    private int amountOwned;
    private String foodName = "meat";

    /**
     * Adjust meat amount owned
     * @param amount
     */
    public void setAmountOwned(int amount){
        this.amountOwned += amount;
    }

    /**
     * Get amount meat owned
     * @return amount meat owned
     */
    public int getAmountOwned(){
        return this.amountOwned;
    }

    /**
     * Get food name
     * @return food name
     */
    public String getFoodName(){
        return this.foodName;
    }
}
