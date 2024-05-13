package BitManipulation;

public class OddOrEven {

    public static void check(int num){
        int bitMask = 1;
        if((num & bitMask) == 0){
            System.out.println(num+ " is even");
        }else{
            System.out.println(num+ " is odd");
        }
    }

    public static void main(String[] args) {
        check(10);
        check(11);
        check(15);
    }
}
