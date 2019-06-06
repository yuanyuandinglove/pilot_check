package com.pilot.design.pattern.consumer;

import java.util.ArrayList;
import java.util.List;

public class TestThread {
    public static void main(String args[]) {
        List<String> stringList = new ArrayList();
        new Thread(new Consumer(stringList)).start();
        new Thread(new Consumer(stringList)).start();
        new Thread(new Consumer(stringList)).start();
        new Thread(new Consumer(stringList)).start();
        new Thread(new Producer(stringList)).start();
        new Thread(new Producer(stringList)).start();
        new Thread(new Producer(stringList)).start();
        new Thread(new Producer(stringList)).start();
    }

}
