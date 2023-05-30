package com.jojo.training.singlenton_training;

public class LazyMan {
    private LazyMan() {
    }

    private static LazyMan instance;

    public static LazyMan getInstance() {
        if (instance == null) {
            instance = new LazyMan();
        }
        return instance;
    }

}
