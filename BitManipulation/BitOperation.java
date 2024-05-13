package BitManipulation;

public class BitOperation {

    public static int getBit(int val, int i){
        int bitMask = 1 << i;
        if((bitMask & val) == 0) return 0;
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(getBit(10, 3));
    }
}
