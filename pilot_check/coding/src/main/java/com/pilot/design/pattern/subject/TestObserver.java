package com.pilot.design.pattern.subject;

public class TestObserver {
    public static void main(String[] args) {

        try {
            Class c = Class.forName("com.pilot.design.pattern.subject.SubjectTopic");
            System.out.println(c.getName());


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Observer observerUser = new ObserverUser("one");
        Observer observerUser1 = new ObserverUser("one1");
        Observer observerUser2 = new ObserverUser("one2");
        Observer observerUser3 = new ObserverUser("one3");

        System.out.println(observerUser.getClass());

        Subject subject = new SubjectTopic();
        subject.add(observerUser);
        subject.add(observerUser1);
        subject.add(observerUser2);
        subject.add(observerUser3);

        ((SubjectTopic) subject).notifyInfo("test");
        subject.delete(observerUser1);
        ((SubjectTopic) subject).notifyInfo("dierci");
    }
}
