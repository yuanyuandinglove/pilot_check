package com.pilot.design.pattern.consumer;

import java.util.List;

/**
 * Producer class
 *
 * @author yuanyuanding
 * @date 2019/06/06
 */
public class Producer implements Runnable {
    private List<String> stringList;

    public Producer(List<String> stringList) {
        this.stringList = stringList;
    }


    public void run() {

        synchronized (stringList) {
            while (true) {
                while (stringList.size() < 5) {
                    String s = "this is" + stringList.size();
                    stringList.add(s);
                    System.out.println(Thread.currentThread().getName() + "add:" + s);
                }
                try {
                    stringList.notifyAll();
                    stringList.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
