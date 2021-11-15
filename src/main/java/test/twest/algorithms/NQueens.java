package test.twest.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Solves a problem to place Queens on the chess board
 * No one on the queens will cross the another.
 * <p>
 * It is a classical exe on backtracking.
 * We are going on rows, i.e. row by row
 * and check the columns, if a queen was placed previously.
 * <p>
 * We have to keep track on colSet, posDiagonal and negDiagonal
 * where a positive diagonal defined like this: row + cols, negative one: row - cols
 * <p>
 * Choose -> Explore -> Unchoose
 * 1) Start in the leftmost column
 * 2) If all queens are placed
 * return true
 * 3) Try all rows in the current column.
 * Do following for every tried row.
 * a) If the queen can be placed safely in this row
 * then mark this [row, column] as part of the
 * solution and recursively check if placing
 * queen here leads to a solution.
 * b) If placing the queen in [row, column] leads to
 * a solution then return true.
 * c) If placing queen doesn't lead to a solution then
 * unmark this [row, column] (Backtrack) and go to
 * step (a) to try other rows.
 * 3) If all rows have been tried and nothing worked,
 * return false to trigger backtracking.
 */
public class NQueens {
    /**
     * Driver function.
     * We have to define:
     * List of the results
     * columns boolean set
     * positive diagonal -> row + col as boolean set
     * negative diagonal -> row - col as boolean set
     *
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>(n);

        boolean[] colPosition = new boolean[n];
        boolean[] posDiagonal = new boolean[2 * n - 1];
        boolean[] negDiagonal = new boolean[2 * n - 1];

        backtrack(result, new ArrayList<String>(), 0, n, colPosition, posDiagonal, negDiagonal);

        return result;
    }

    private void backtrack(List<List<String>> result, ArrayList<String> middleRes, int row, int n, boolean[] colPosition, boolean[] posDiagonal, boolean[] negDiagonal) {
        // Base case, our Goal
        if (row == n) {
            result.add(new ArrayList<>(middleRes));
            return;

        } else {
            for (int currentCol = 0; currentCol < n; currentCol++) {
                // Check if a queen could be placed
                if (isSave(negDiagonal[row - currentCol + n - 1], colPosition[currentCol], posDiagonal[row + currentCol])) {
                    // Create a row in the board
                    char[] boardRow = new char[n];
                    Arrays.fill(boardRow, '.');
                    boardRow[currentCol] = 'Q';
                    String rowString = new String(boardRow);
                    middleRes.add(rowString);

                    // Choose
                    colPosition[currentCol] = true;
                    posDiagonal[row + currentCol] = true;
                    negDiagonal[row - currentCol + n - 1] = true;
                    // Explore
                    backtrack(result, middleRes, row + 1, n, colPosition, posDiagonal, negDiagonal);
                    // Un-choose
                    middleRes.remove(middleRes.size() - 1);
                    colPosition[currentCol] = false;
                    posDiagonal[row + currentCol] = false;
                    negDiagonal[row - currentCol + n - 1] = false;
                }
            }
        }
    }

    private boolean isSave(boolean colPosQueen, boolean posDiagPosQueen, boolean negDiagPosQueen) {
        return posDiagPosQueen == false && negDiagPosQueen == false && colPosQueen == false;
    }
}
