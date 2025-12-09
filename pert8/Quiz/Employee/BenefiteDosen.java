package pert8.Quiz.Employee;

    // Super Class
class Employee {
    int salary = 8000000;
}

// Inherited or Sub Class
class Lecturer extends Employee {
    int benefits = 5000000;
}

// Subclass tambahan: Manager
class Bonus extends Employee {
    int bonus = 3000000;
}

class Jobs extends Employee{
    String job = "Dosen"; 
}

// Main Class
class main {
    public static void main(String args[]) {
        // Buat objek Lecturer
        Lecturer E1 = new Lecturer();
        Bonus E2 = new Bonus();
        Jobs E3 = new Jobs();

        System.out.println("Lecturer in UEU");
        System.out.println("Salary : " + E1.salary + "\nBonus : " + E2.bonus + "\nJob : " + E3.job);
        System.out.println();
    }
}

