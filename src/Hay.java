/**
 * @author tvoul
 * @author knuttas
 * Hay class extends Food
 */
public class Hay extends Food{
    private int amountOwned;
    private String foodName = "hay";

    /**
     * Adjust amount owned
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
