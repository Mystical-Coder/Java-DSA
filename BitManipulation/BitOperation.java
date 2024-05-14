package BitManipulation;

public class BitOperation {

    public static int getBit(int val, int i){
        int bitMask = 1 << i;
        if((bitMask & val) == 0) return 0;
        return 1;
    }

    public static int setBit(int val, int i){
        int bitMask = 1 << i;
        return val | bitMask;
    }

    public static int clearIthBit(int val, int i){
        int bitMask = ~(1 << i);
        return bitMask & val;
    }

    public static int updateIthBit(int val, int i, int setBit){
        // if(setBit == 0){
        //     return clearIthBit(val, i);
        // }else{
        //     return setBit(val, i);
        // }
        val = clearIthBit(val, i);
        int bitMask = setBit << i;
        return bitMask | val;   
    }

    public static int clearBit(int val, int i){
        int bitMask = (~0) << i;
        return val & bitMask;
    }

    public static int clearRangeBit(int val, int i, int j){
        int a = ((~0) << (j + 1));
        int b = (i<<i) - 1;
        int bitMask = a | b;
        return bitMask & val;
    }

    public static boolean isPowerOfTwo(int val){
        return (val & (val - 1)) == 0;
    }

    public static int countSetBits(int val){
        int count = 0;
        while(val > 0){
            if((val & 1) !=0 ){
                count++;
            }
            val = val >>1;
        }
        return count;
    }

    public static int fastExpo(int val, int pow){
        int ans = 1;
        while(pow > 0){
            if((pow & 1) != 0){
                ans = ans * val;
            }
            val = val * val;
            pow = pow >> 1;
        }
        return ans;
    }

  public static void main(String[] args) {
        // System.out.println(getBit(10, 3));
        // System.out.println(setBit(10, 2));
        // System.out.println(clearIthBit(10, 1));
        // System.out.println(updateIthBit(10, 2, 1));
        // System.out.println(clearBit(15, 2));
        // System.out.println(clearRangeBit(10, 2, 4));
        // System.out.println(isPowerOfTwo(8));
        // System.out.println(countSetBits(15));
        System.out.println(fastExpo(5, 2));

    }
}
