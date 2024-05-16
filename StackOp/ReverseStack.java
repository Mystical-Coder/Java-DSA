package StackOp;

import java.util.Stack;

public class ReverseStack {

    public static void pushAtButtom(Stack<Integer> stack, int val){
        if(stack.isEmpty()){
            stack.push(val);
            return;
        }
        int top = stack.pop();
        pushAtButtom(stack, val);
        stack.push(top);
    }

    public static void reverse(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }
        int top = stack.pop();
        reverse(stack);
        pushAtButtom(stack, top);
    }


    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        reverse(stack);
        while(!stack.isEmpty()){
            System.out.print(stack.peek()+" ");
            stack.pop();
        }
    }
}
