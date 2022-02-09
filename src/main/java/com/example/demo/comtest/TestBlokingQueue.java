package com.example.demo.comtest;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author linkun
 * @date 2021/10/29 14:31
 */
public class TestBlokingQueue {
    static ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(10);

    public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    System.out.println("生产:" + i);
                    arrayBlockingQueue.put(i);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();
        new Thread(() -> {
            while (true) {
                try {
                    Object take = arrayBlockingQueue.take();
                    System.out.println("消费：" + take);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();

    }
}
