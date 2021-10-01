package com.animalgame.abstractmodels;

/**
 * @author tvoul
 * @author knuttas
 * com.animalgame.abstractmodels.Food abstract class
 */
public abstract class Food {
    protected int amountOwned;

    /**
     * Set amount food owned (abstract)
     * @param amount
     */
    public abstract void setAmountOwned(int amount);

    /**
     * Get amount food owned (abstract)
     * @return amount owned
     */
    public abstract int getAmountOwned();

    /**
     * Get food name (abstract)
     * @return food name
     */
    public abstract String getFoodName();

}
