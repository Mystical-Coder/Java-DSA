package BackTracking;

public class GridWays {

    


    // ------------------- Time complexity = O(2^n+m) -----------------------------------------
    public static int grid(int i, int j, int n, int m){ 
        if(i == n -1 && j == m -1){
            return 1;
        }else if(i == n || j == n){
            return 0;
        }
        int way1 = grid(i + 1, j, n, m);
        int way2 = grid(i, j + 1, n, m);
        return way1 + way2;
    }

    public static void main(String[] args) {
        int n = 3, m =3;
        System.out.println(grid(0 , 0, n, m));
    }
}
