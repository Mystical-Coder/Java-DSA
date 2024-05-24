package Notes.ComparableAndComparator;

import java.util.Arrays;
import java.util.Comparator;

public class SortClass {

    public static class Student {
        int rollnum;
        String name;

        public Student(int rollnum, String name) {
            this.rollnum = rollnum;
            this.name = name;
        }
    }

    public static void main(String[] args) {
        Student[] stud = {
                new Student(1, "temp1"),
                new Student(10, "temp10"),
                new Student(2, "temp14"),
                new Student(5, "temp16"),
                new Student(8, "temp11")
        };
        
        // Arrays.sort(stud, Comparator.comparing(s -> s.name)); // Ascending
        // Arrays.sort(stud, Comparator.comparing((Student s) -> s.name).reversed()); // Descending order

        // Arrays.sort(stud, Comparator.comparingInt(s -> s.rollnum));
        // Arrays.sort(stud, Comparator.comparingInt((Student s) -> s.rollnum).reversed());

        // Arrays.sort(stud, (a ,b) -> a.rollnum - b.rollnum); //Asc
        // Arrays.sort(stud, (a ,b) -> b.rollnum - a.rollnum); // Desc


        for (Student s : stud) {
            System.out.println(s.rollnum + " - " + s.name);
        }

    }

}
