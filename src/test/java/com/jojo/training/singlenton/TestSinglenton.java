package com.jojo.training.singlenton;

import static org.junit.Assert.assertNotNull;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;

import com.jojo.training.singlenton_training.HungryMan;

public class TestSinglenton {
    AtomicInteger count = new AtomicInteger(0);

    @Test
    public void Test01() {
        // 线程不安全
        Set<HungryMan> storySet = new HashSet<>();
        // 建议使用
        // Set<HungryMan> storySet = Collections.synchronizedSet(new LinkedHashSet<>(16,
        // 0.75f));
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                System.out.println("The value of count is " + count.incrementAndGet());
                HungryMan instance = HungryMan.getInstance();
                System.out.println("Id of Thread is " + Thread.currentThread().getId());
                storySet.add(instance);
                System.out.println("The size of storySet is " + storySet.size());
            });
            thread.start();
        }
        assertNotNull(null, storySet);
        System.out.println("The size of storySet is " + storySet.size());
    }

}
