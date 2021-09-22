public class Salad extends Food{
    private int amountOwned;
    private String foodName = "salad";

    public void setAmountOwned(int amount){
        this.amountOwned += amount;
    }

    public int getAmountOwned(){
        return this.amountOwned;
    }

    public String getFoodName(){
        return this.foodName;
    }
}
