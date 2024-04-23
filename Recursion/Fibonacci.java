public class Fibonacci {

    public static int fab(int n){
        if(n == 0 || n == 1){
            return n;
        }
        int sum = fab(n -1) + fab(n - 2);
        return sum;
    }

    
    public static void main(String[] args) {
        System.out.println(fab(3));
    }
}
