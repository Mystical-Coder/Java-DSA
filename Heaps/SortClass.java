package Heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SortClass {

    public static class Student implements Comparable<Student>{
        int rollno;
        String name;
        public Student(int rollno, String name){
            this.rollno = rollno;
            this.name = name;
        }

        @Override
        public int compareTo(Student s2){
            return this.rollno - s2.rollno;
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Student> pq = new PriorityQueue();
        pq.add(new Student(1, "B"));
        pq.add(new Student(3, "A"));
        pq.add(new Student(4, "C"));
        pq.add(new Student(9, "D"));
        pq.add(new Student(2, "E")); 
        while(!pq.isEmpty()){
            System.out.println(pq.peek().rollno+"->"+pq.peek().name);
            pq.remove();
        }
    }
}
