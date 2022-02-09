package com.ycourlee.explore.java8.java.lang;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yongjiang
 */
public class ThreadExp {

    public static final Character LOCK = 'L';

    public Object obj;

    public static void main(String[] args) {
        ThreadExp threadExp = new ThreadExp();

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 4000; i++) {
            threads.add(new AddThread(threadExp));
        }
        threads.forEach(Thread::start);

        threads.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    static class AddThread extends Thread {

        ThreadExp obj;

        public AddThread(ThreadExp obj) {
            this.obj = obj;
        }

        @Override
        public void run() {
            obj.add();
        }
    }

    private void add() {
        if (obj == null) {
            synchronized (LOCK) {
                if (obj == null) {
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    obj = new Object();
                }
            }
        }
        System.out.println("obj = " + obj);
    }
}
