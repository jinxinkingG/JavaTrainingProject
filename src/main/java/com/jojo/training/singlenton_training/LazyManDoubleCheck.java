package com.jojo.training.singlenton_training;

public class LazyManDoubleCheck {
    private LazyManDoubleCheck() {
    };

    private static LazyManDoubleCheck lazyManDoubleCheck;

    public static LazyManDoubleCheck getInstance() {
        LazyManDoubleCheck result = lazyManDoubleCheck;
        if (result == null) {
            synchronized (LazyManDoubleCheck.class) {
                result = lazyManDoubleCheck;
                if (result == null) {
                    result = new LazyManDoubleCheck();
                    lazyManDoubleCheck = result;
                }
                return lazyManDoubleCheck;
            }
        }
        return lazyManDoubleCheck;
    }

}
