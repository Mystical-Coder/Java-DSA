package StackOp;

import java.util.Stack;

public class DuplicateParanthesis {

    public static boolean isValid(String str){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(ch != ')'){
                stack.push(ch);
            }else{
                int count = 0;
                while(stack.pop() != '('){
                    count++;
                }
                if(count < 1){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "((a + b) + (c + d))";
        if(isValid(str)){
            System.out.println("duplicate exist");;
        }else{
            System.out.println("No Duplicate");
        }
    }
}
