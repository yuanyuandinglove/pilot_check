package com.pilot.design.pattern.subject;

import java.util.ArrayList;
import java.util.List;
/**
 *  SubjectTopic class
 *
 * @author yuanyuanding
 * @date 2019/06/06
 */
public class SubjectTopic implements Subject {
    public static int i = 5;

    static {
        System.out.println(5);
    }

    List<Observer> list = new ArrayList<Observer>();

    public void add(Observer observerUser) {
        list.add(observerUser);
    }


    public void delete(Observer observerUser) {
        list.remove(observerUser);

    }

    public void notifyInfo(String s) {
        for (Observer observerUser : list) {
            observerUser.update(s);
        }
    }
}
