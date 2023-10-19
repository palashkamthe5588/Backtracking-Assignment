/*

Q5. The n-queens puzzle is the problem of placing n queens on an n xn chessboard such that  no two queens attack each other.Given aninteger n, return the number of distinct solutions to  the n-queenspuzzle. 

Input:  
n = 4 
Output:  
2 

Explanation:  
There are two distinct solutions to the 4-queens puzzle asshown. 

Input: 
 n = 1 
Output: 
 1 
 */





public class NQueens {
    public int totalNQueens(int n) {
        int[] columnPlacement = new int[n];
        return solveNQueens(0, n, columnPlacement);
    }

    private int solveNQueens(int row, int n, int[] columnPlacement) {
        if (row == n) {
            return 1; // Found a valid solution.
        }

        int totalSolutions = 0;
        for (int col = 0; col < n; col++) {
            if (isValidPlacement(row, col, columnPlacement)) {
                columnPlacement[row] = col;
                totalSolutions += solveNQueens(row + 1, n, columnPlacement);
            }
        }

        return totalSolutions;
    }

    private boolean isValidPlacement(int row, int col, int[] columnPlacement) {
        for (int prevRow = 0; prevRow < row; prevRow++) {
            int diff = Math.abs(columnPlacement[prevRow] - col);
            if (diff == 0 || diff == row - prevRow) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        int n1 = 4;
        int n2 = 1;

        System.out.println("Number of distinct solutions for n = 4: " + nQueens.totalNQueens(n1));
        System.out.println("Number of distinct solutions for n = 1: " + nQueens.totalNQueens(n2));
    }
}

