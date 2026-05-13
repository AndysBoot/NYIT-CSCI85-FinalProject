package GameWindow;

public  class RandomEvents {
    //instance variables used to update important player values
    public String message;
    public double moneyChange;
    public double multiplier;
    public int clickChange;



    public RandomEvents(String message, double moneyChange, double multiplier, int clickChange) {
        this.message = message;
        this.moneyChange = moneyChange;
        this.multiplier = multiplier;
        this.clickChange = clickChange;
    }

    public String getRandomEventMessage(){
        return this.message;
    }

}
