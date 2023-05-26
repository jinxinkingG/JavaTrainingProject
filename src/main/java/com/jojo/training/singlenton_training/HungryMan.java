package com.jojo.training.singlenton_training;

public class HungryMan {
    // private constructor
    private HungryMan() {
    }

    private static HungryMan hungryMan = new HungryMan();

    public static HungryMan getInstance() {
        return hungryMan;
    }
}
