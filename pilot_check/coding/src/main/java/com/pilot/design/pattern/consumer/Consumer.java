package com.pilot.design.pattern.consumer;

import java.util.List;
/**
 * Consumer class
 *
 * @author yuanyuanding
 * @date 2019/06/06
 */
public class Consumer implements Runnable {

    private List<String> stringList;

    public Consumer(List<String> stringList) {
        this.stringList = stringList;
    }

    public void run() {
        synchronized (stringList) {
            while (true) {
                while (stringList.size() > 0) {
                    String s = stringList.remove(0);
                    System.out.println(Thread.currentThread().getName() + "remove:" + s);
                }
                try {
                    stringList.notifyAll();
                    stringList.wait();
                    System.out.println(Thread.currentThread().getName() + "被唤醒了");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
