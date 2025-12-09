package pert10.Latihan2;

class Notification {
    public void send() {
        System.out.println("Sending a generic notification");
    }
}

class EmailNotification extends Notification {
    @Override
    public void send() {
        System.out.println("Sending an email notification");
    }
}

class SMSNotification extends Notification {
    @Override
    public void send() {
        System.out.println("Sending an SMS notification");
    }
}

class PushNotification extends Notification {
    @Override
    public void send() {
        System.out.println("Sending a push notification");
    }
}
