/**
 * @author tvoul
 * @author knuttas
 * Salad class extends Food
 */

public class Salad extends Food{
    private String foodName = "salad";

    /**
     * Set amount owned
     * @param amount
     */
    public void setAmountOwned(int amount){
        this.amountOwned += amount;
    }

    /**
     * Get amount owned
     * @return amount owned
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
