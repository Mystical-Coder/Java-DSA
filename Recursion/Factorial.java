public class Factorial {

    public static int getFact(int n){
        if(n == 0){
            return 1;
        }
        int val = n * getFact(n - 1);
        return val;
    }

    public static void main(String[] args) {
        System.out.println(getFact(5));
    }
}
