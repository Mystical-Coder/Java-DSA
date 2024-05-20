package QueueOp;

import java.util.LinkedList;
import java.util.Queue;

public class NonRepeatingChar {

    public static String getAns(String str){
        StringBuffer sb = new StringBuffer();
        int[] freq = new int[26];
        Queue<Character> queue = new LinkedList<>();
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            freq[ch - 'a']++;
            queue.add(ch);
            while (!queue.isEmpty() && freq[queue.peek() - 'a'] > 1) {
                queue.remove();
            }
            if(queue.isEmpty()){
                sb.append("-1");
            }else{
                sb.append(queue.peek());
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        String str = "aabccxb";
        System.out.println(getAns(str));
    }
}
