package pert8.Quiz.Person;

// Superclass
class Person {
    String name;
    int age;

    void introduce() {
        System.out.println("Nama: " + name + ", Umur: " + age + " tahun.");
    }
}

// Subclass 1: Student (inheritance dari Person)
class Student extends Person {
    String studentId;
    String major;

    void showStudent() {
        introduce();
        System.out.println("NIM: " + studentId);
        System.out.println("Jurusan: " + major);
    }
}

// Subclass 2: Employee (inheritance dari Person)
class Employee extends Person {
    String employeeId;
    String department;

    void showEmployee() {
        introduce();
        System.out.println("ID Karyawan: " + employeeId);
        System.out.println("Departemen: " + department);
    }
}

// Subclass 3: WorkingStudent (turunan dari Student → multilevel)
// Meski namanya "Working", kita tidak bisa extends Employee juga → tapi kita tambahkan atribut karyawan
class WorkingStudent extends Student {
    String workplace;    // tempat kerja (simulasi peran karyawan)
    String jobRole;      // peran pekerjaan

    void showWorkingStudent() {
        introduce();
        System.out.println("NIM: " + studentId);
        System.out.println("Jurusan: " + major);
        System.out.println("Bekerja di: " + workplace);
        System.out.println("Sebagai: " + jobRole);
    }
}

// Main Class
public class HybridInheritanceDemo {
    public static void main(String[] args) {
        // Objek Student
        Student s = new Student();
        s.name = "Fiky";
        s.age = 20;
        s.studentId = "S12345";
        s.major = "Informatika";
        System.out.println("=== Mahasiswa ===");
        s.showStudent();
        System.out.println();

        // Objek Employee
        Employee e = new Employee();
        e.name = "Fiky";
        e.age = 20;
        e.employeeId = "E67890";
        e.department = "IT";
        System.out.println("=== Karyawan ===");
        e.showEmployee();
        System.out.println();

        // Objek WorkingStudent (mahasiswa yang kerja)
        WorkingStudent ws = new WorkingStudent();
        ws.name = "Fiky";
        ws.age = 20;
        ws.studentId = "S54321";
        ws.major = "Manajemen";
        ws.workplace = "PT Maju Jaya";
        ws.jobRole = "Intern IT";
        System.out.println("=== Mahasiswa Pekerja ===");
        ws.showWorkingStudent();
    }
}
