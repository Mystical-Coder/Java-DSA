public class Tiling {
    // Given 2 * n board and tiles of size 2 * 1, count the number of ways of tile the given board using the 2 * 1 tiles.
    // A tile can be placed vertically or horizontally.   

    public static int tillingProb(int n){

        if(n == 0 || n == 1){
            return 1;
        }

        int vertical = tillingProb(n - 1);
        int horizontal = tillingProb(n - 2);
        int ans = vertical + horizontal;
        return ans;
    }



    public static void main(String[] args) {
        System.out.println(tillingProb(3));
    }
}
