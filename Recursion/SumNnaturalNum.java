public class SumNnaturalNum {

    public static int getSum(int n){
        if(n == 1){
            return 1;
        }
        int sum = n + getSum(n - 1);
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(getSum(5));
    }
}
