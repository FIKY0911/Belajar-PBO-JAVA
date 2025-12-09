package pert8.Quiz.Fruits;

// Super Class
class Fruits {
    public void print_Fruits() {
        System.out.println("*Fruits*");
    }
}

// Sub Class 1
class Apple extends Fruits {
    public void print_Apple() {
        System.out.println("Apple");
    }
}

// Sub Class 2
class Banana extends Fruits {
    public void print_Banana() {
        System.out.println("Banana");
    }
}

// Sub Class 3
class Mango extends Fruits {
    public void print_Mango() {
        System.out.println("Mango");
    }
}

// Sub Class 4
class Orange extends Fruits {
    public void print_Orange() {
        System.out.println("Orange");
    }
}

// Main Class
class main {
    public static void main(String[] args) {
        // Buat objek dari setiap subclass
        Apple obj_Apple = new Apple();
        Banana obj_Banana = new Banana();
        Mango obj_Mango = new Mango();
        Orange obj_Orange = new Orange();

        // Panggil method dari superclass (inheritance)
        obj_Apple.print_Fruits();
        obj_Apple.print_Apple();
        obj_Banana.print_Fruits();
        obj_Banana.print_Banana();
        obj_Mango.print_Fruits();
        obj_Mango.print_Mango();
        obj_Orange.print_Fruits();
        obj_Orange.print_Orange();
    }
}
