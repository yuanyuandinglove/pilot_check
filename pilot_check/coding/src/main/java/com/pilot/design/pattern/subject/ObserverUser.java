package com.pilot.design.pattern.subject;
/**
 * ObserverUser class
 *
 * @author yuanyuanding
 * @date 2019/06/06
 */
public class ObserverUser implements Observer {

    private String name;

    public ObserverUser(String name) {
        this.name = name;
    }

    public void update(String content) {
        System.out.println("name:" + name + "-receive :" + content);
    }
}
