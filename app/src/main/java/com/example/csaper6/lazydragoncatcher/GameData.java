package com.example.csaper6.lazydragoncatcher;

/**
 * Created by csaper6 on 10/13/16.
 */
public class GameData {

    private int numberOfDragons, dragonDollars;
    private int rateOfDragons, timeToNextDragon;

    public GameData(){
        numberOfDragons = 1;
        dragonDollars = 0;
        rateOfDragons = 1;
        timeToNextDragon = 10000;
        boolean[] h = {false, false, false, false, false, false, false, false};
        }

    public GameData(int numberOfDragons, int dragonDollars, int timeToNextDragon, int rateOfDragons, boolean[] a) {
        this.numberOfDragons = numberOfDragons;
        this.dragonDollars = dragonDollars;
        this.timeToNextDragon = timeToNextDragon;
        this.rateOfDragons = rateOfDragons;

    }

    public int getRateOfDragons() {
        return rateOfDragons;
    }

    public int getTimeToNextDragon() {
        return timeToNextDragon;
    }

    public int getDragonDollars() {
        return dragonDollars;
    }

    public int getNumberOfDragons() {
        return numberOfDragons;
    }


    public void setDragonDollars(int dragonDollars) {
        this.dragonDollars = dragonDollars;
    }

    public void setNumberOfDragons(int numberOfDragons) {
        this.numberOfDragons = numberOfDragons;
    }

    public void setRateOfDragons(int rateOfDragons) {
        this.rateOfDragons = rateOfDragons;
    }

    public void setTimeToNextDragon(int timeToNextDragon) {
        this.timeToNextDragon = timeToNextDragon;
    }
}
