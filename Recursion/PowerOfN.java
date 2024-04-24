/**
 * PowerOfN
 */
public class PowerOfN {

    public static int power(int num, int n){ // O(n)
        if(n == 0){
            return 1;
        }
        return num * power(num, n - 1);
    }

    public static int optimizedPower(int num, int n){ // o(nlogn)
        if (n==0) {
            return 1;
        }
        int val = optimizedPower(num, n/2);
        int halfPower = val * val;
        if(n % 2 != 0){
            halfPower = num * halfPower;
        }
        return halfPower;
    }

    public static void main(String[] args) {
        // System.out.println(power(1000, 10));
        System.out.println(optimizedPower(1000, 10));
    }
    
}