public class PrintDecNum {

    public static void printDec(int num){
        if(num == 1){
            System.out.println(num);
            return;
        }
        System.out.println(num);
        printDec(num - 1);
    }

    public static void main(String[] args) {
        printDec(10);
    }
}
