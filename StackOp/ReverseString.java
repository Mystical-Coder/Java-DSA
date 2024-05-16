package StackOp;

import java.util.Stack;

public class ReverseString {
    public static void main(String[] args) {
        String str = "abc";
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < str.length(); i++){
            stack.push(str.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }
}
