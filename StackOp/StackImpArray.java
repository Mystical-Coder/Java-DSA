package StackOp;

import java.util.ArrayList;

public class StackImpArray {

    public static class Stack {
        public static ArrayList<Integer> list = new ArrayList<>();

        public static boolean isEmpty(){
            return list.isEmpty();
        }

        public static void push(int data){
            list.add(data);
        }

        public static int pop(){
            if(list.size() == 0){
                return -1;
            }
            int val = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return val;
        }

        public static int peek(){
            if(list.size() == 0){
                return -1;
            }
            return list.get(list.size() - 1);
        }

    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        while(!stack.isEmpty()){
            System.out.print(stack.peek()+" ");
            stack.pop();
        }
    }
}
