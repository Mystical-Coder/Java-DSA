package StackOp;

import java.util.Stack;

public class ValidParentheses {

    public static boolean isValid(String str){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(ch == '(' || ch == '{' || ch == '['){
                stack.push(ch);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                if((ch == ')' && stack.peek()== '(') 
                || (ch == '}' && stack.peek() == '{') 
                || (ch == ']' && stack.peek() == '[')){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "[][][][[[]]]";
        if(isValid(str)){
            System.out.println("Parentheses is valid");
        }else{
            System.out.println("Not valid");
        }
    }
}
