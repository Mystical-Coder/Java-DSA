package BackTracking;

public class Nqueens {
    
    public static boolean isSafe(char[][] board, int row, int col){
        // vertical up
        for(int j = row - 1; j >=0 ; j--){
            if(board[j][col] == 'Q'){
                return false;
            }
        }
        // diag left up
        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        
        // dia right up
        for(int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        return true;
    }

    public static void getSolution(char[][] board, int row){
        if(row == board.length){
            printBoard(board);
            return;
        }
        // Add one queen in each row
        for(int i = 0; i < board.length; i++){
            if(isSafe(board, row, i)){  // Use to check the queen is safe in particular cell
                board[row][i] = 'Q';
                getSolution(board, row+1);
                board[row][i] = 'X';  // Backtracking
            }
        }
    }

    public static void printBoard(char[][] board){
        System.out.println("----------- Chess board ---------------");
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 4;
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j]='x';
            }
        }
        getSolution(board, 0);
    }
}
