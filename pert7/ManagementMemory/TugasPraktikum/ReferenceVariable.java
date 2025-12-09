package pert7.ManagementMemory.TugasPraktikum;

public class ReferenceVariable {
    private static void printAll(String s1, String s2, String s3) {
        System.out.println(s1.toString()); // print string s1
        System.out.println(s2.toString()); // print string s2
        System.out.println(s3.toString()); // print string s3
    }
    public static void main(String[] args) {
        String str1, str2, str3; // deklarasi 3 string variable
        str1 = new String("string 1"); // menambahkan 3 string object
        str2 = new String("string 2");
        str3 = new String("string 3");
        printAll(str1, str2, str3); // memanggil method printAll
    }
}
