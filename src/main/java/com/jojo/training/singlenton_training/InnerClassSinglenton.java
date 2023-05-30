package com.jojo.training.singlenton_training;

public class InnerClassSinglenton {
    private InnerClassSinglenton() {
    }

    private static class InnerClassSinglentonHolder {
        public static InnerClassSinglenton innerClassSinglenton = new InnerClassSinglenton();
    }

    public static InnerClassSinglenton getInstance() {
        return InnerClassSinglenton.InnerClassSinglentonHolder.innerClassSinglenton;
    }

}
