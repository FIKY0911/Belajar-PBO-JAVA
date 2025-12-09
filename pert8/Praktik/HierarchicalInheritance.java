package pert8.Praktik;

class PBO {
    public void print_pbo() {
        System.out.println("Class PBO");
    }
}

class ControlStatement extends PBO {
    public void print_ControlStatement() {
        System.out.println("Class ControlStatement");
    }

    public static class Main {
        public static void main(String[] args) {
            ControlStatement obj_ControlStatement = new ControlStatement();
            obj_ControlStatement.print_pbo();
            obj_ControlStatement.print_ControlStatement();

            Encapsulation obj_Encapsulation = new Encapsulation();
            obj_Encapsulation.print_pbo();
            obj_Encapsulation.print_Encapsulation();

            Inheritance obj_Inheritance = new Inheritance();
            obj_Inheritance.print_pbo();
            obj_Inheritance.print_Inheritance();
        }
    }
}

class Encapsulation extends PBO { // ✅ Diperbaiki typo: "Encapculation" → "Encapsulation"
    public void print_Encapsulation() {
        System.out.println("Class Encapsulation");
    }
}

class Inheritance extends PBO {
    public void print_Inheritance() {
        System.out.println("Class Inheritance");
    }
}