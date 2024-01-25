package com.jojo.training.singlenton_training;

/*
 * 饿汉式单例模式
 */
public class HungryMan {
	// private constructor
	private HungryMan() {
	}

	private static HungryMan hungryMan = new HungryMan();

	public static HungryMan getInstance() {
		return hungryMan;
	}
}
