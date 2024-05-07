package Notes;

import java.util.Stack;

public class Practice {

       public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int n = s.length();
        char sign = '+';
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                int val = 0;
                while(i < n && Character.isDigit(s.charAt(i))){
                    val = val * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i--;
                if(sign == '+'){
                    stack.push(val);
                }else if(sign == '-' ){
                    stack.push(-val);
                }else if(sign == '*'){
                    int a = stack.pop();
                    stack.push(a*val);
                }else if(sign == '/'){
                    int a = stack.pop();
                    stack.push(a/val);
                }
            }else if(ch != ' '){
                sign = ch;
            }
        }
        int sum = 0;
        while(stack.size() > 0) sum += stack.pop();
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(calculate("3+2*2"));
    }
}
