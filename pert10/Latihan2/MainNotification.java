package pert10.Latihan2;

public class MainNotification {

    public static void broadcast(Notification n) {
        n.send();
    }

    public static void main(String[] args) {
        Notification n1 = new EmailNotification();
        Notification n2 = new SMSNotification();
        Notification n3 = new PushNotification();

        broadcast(n1);
        broadcast(n2);
        broadcast(n3);
    }
}
