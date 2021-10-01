package com.animalgame.food;

import com.animalgame.abstractmodels.Food;

/**
 * @author tvoul
 * @author knuttas
 * com.animalgame.Player class extends com.animalgame.abstractmodels.Food
 */

public class Meat extends Food {
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
