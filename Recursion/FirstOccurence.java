public class FirstOccurence {

    public static int findNum(int arr[], int i, int num){
        if(i == arr.length){
            return -1;
        }
        if(arr[i] == num){
            return i;
        }
        return findNum(arr, i + 1, num);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(findNum(arr, 0, 8));
    }
}
