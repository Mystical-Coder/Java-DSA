package Notes;

import java.util.Stack;

public class Practice {

        public static int missingNumber(int[] nums) {
            int len = nums.length;
            int sum = (len * (len - 1)) / 2;
            for(int val : nums){
                sum = sum - val;
            }
            return sum;
        }
    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{3, 0, 1}));
    }
}
