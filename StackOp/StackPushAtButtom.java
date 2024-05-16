package StackOp;

import java.util.Stack;

public class StackPushAtButtom {

    public static void pushAtButtom(int val, Stack<Integer> stack){
        if(stack.isEmpty()){
            stack.push(val);
            return;
        }
        int temp = stack.pop();
        pushAtButtom(val, stack);
        stack.push(temp);
    }


    public static void main(String[] args) {
        Stack<Integer>  stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        pushAtButtom(40, stack);
        System.out.println(stack); 
    }
}
