public class LastOccurence {

    public static int lastOcc(int[] arr, int i, int num){
        if(i == arr.length){
            return -1;
        }
        int val = lastOcc(arr, i+1, num);
        if(val == -1 && arr[i] == num){
            return i;
        }
        return val;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 7};
        System.out.println(lastOcc(arr, 0, 7));
    }
}
