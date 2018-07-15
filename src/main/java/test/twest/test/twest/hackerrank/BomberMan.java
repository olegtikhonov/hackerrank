package test.twest.test.twest.hackerrank;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.hackerrank.com/challenges/bomber-man/problem
 * The . character denotes an empty cell, and the O character (ascii 79) denotes a bomb.
 * 1 sec - do nothing, i.e. return the original matrix
 * 2 sec - init all with O
 * 3 sec - exposes all original bombs
 * next, it will repeats steps 2 and three indefinitely according to n
 * Constrains:
 * 1 <= r, c <= 200
 * 1 <= n <= 10^9
 */
public class BomberMan {

    public static final String MINE = "O";

    enum STEPS {UP, DOWN, LEFT, RIGHT, ITSELF, UP_LEFT, UP_RIGHT, DOWN_LEFT, DOWN_RIGHT};

    public static String[] bomberMan(int n, String[] grid) {
        int start = 1;
        String[] orig = grid;
        String[] result = new String[]{};

        // what I need:
        // first second
        // second second
        // third second
        while (start <= n) {
            result = startTheGame(start, grid);
            start++;
        }

        return result;
    }

    private static String[] startTheGame(int n, String[] grid) {
        int action = n % 3;

        switch (action) {
            case 0:
                // TODO: blow up, keep the result, send origin with all bombs in it
                System.out.println("Third step, blow in matrix");
                return detonate(aggregate(grid), getFullCharged(grid));
            case 1:
                System.out.println("First step, do nothing, return the current");
                return getCurrent(grid);
            case 2:
                System.out.println("Second step, init a matrix with bombs. Only once is enough");
                return getFullCharged(grid);
        }

        return grid;
    }

    private static String[] getCurrent(String[] current) {
        return current;
    }

    private static String[] getFullCharged(String[] grid) {
        String[] result = new String[grid.length];
        for (int inx = 0; inx < grid.length; inx++) {
            result[inx] = grid[inx].replaceAll(".", MINE);
        }
        return result;
    }

    private static StringBuilder[] to(String[] grid) {
        StringBuilder[] result = new StringBuilder[grid.length];
        for (int i = 0; i < grid.length; i++) {
            result[i] = new StringBuilder(grid[i]);
        }
        return result;
    }

    //-------------------------------------------------------
    // Complete the bomberMan function below.
    // This code is commited, the rest garbage until fixed
    //-------------------------------------------------------
    static String[] bomberCommitedMan(int time, String[] grid) {
        StringBuilder[] input = to(grid);
        String[] result = null;
        if (time % 2 == 0) {
            plantAllBomb(input);
        } else {
            if(time >= 3){
                time = timeSequence(time);
            }
            int initTime = 3;
            while (initTime <= time) {
                for (int i = 0; i < input.length; i++) {
                    if (input[i].indexOf("O") != -1) {
                        int j = input[i].indexOf("O");
                        while (j != -1) {
                            if (j + 1 < input[i].length() && input[i].charAt(j + 1) != 'O') {
                                input[i].setCharAt(j + 1, '4');
                            }
                            if (j - 1 >= 0) {
                                input[i].setCharAt(j - 1, '4');
                            }
                            if (i + 1 < input.length && input[i + 1].charAt(j) != 'O') {
                                input[i + 1].setCharAt(j, '4');
                            }
                            if (i - 1 >= 0) {
                                input[i - 1].setCharAt(j, '4');
                            }
                            String sb = input[i].substring(j + 1);
                            if (sb.indexOf('O') != -1) {
                                j = j + 1;
                                j = j + sb.indexOf('O');
                            } else {
                                j = sb.indexOf('O');
                            }

                        }
                    }
                }
                // Change the input here
                for (int i = 0; i < input.length; i++) {
                    char[] arr = input[i].toString().toCharArray();
                    for (int j = 0; j < arr.length; j++) {
                        if (arr[j] == '4' || arr[j] == 'O') {
                            arr[j] = '.';
                        } else {
                            arr[j] = 'O';
                        }
                    }
                    String val = new String(arr);
                    input[i] = new StringBuilder(val);
                }
                initTime = initTime + 2;
            }
            result = displayArr(input);
        }
        return result;
    }

    private static int timeSequence(int time){
        int time3 = time - 3;
        int time5 = time - 5;
        if(time3 % 4 == 0 && time5 % 4 != 0){
            time = 3;
        }else if(time5 % 4 == 0 && time3 % 4 != 0){
            time = 5;
        }else if(time3 % 4 == 0 && time5 % 4 == 0){
            if(time3 <= time5){
                time = 3;
            }else{
                time = 5;
            }
        }
        return time;
    }

    private static String[] displayArr(StringBuilder[] arr) {
        String[] result = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            //System.out.println(arr[i]);
            result[i] = arr[i].toString();
        }
        return result;
    }

    private static void plantAllBomb(StringBuilder[] input) {
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length(); j++) {
                System.out.print("O");
            }
            System.out.println();
        }
    }
    // ------------ until this was commeted --------------------------

    private static List<Bomb> aggregate(String[] grid) {
        List<Bomb> result = new ArrayList<>();

        for (int inx = 0; inx < grid.length; inx++) {
            if(grid[inx].contains("O")) {
                int row = inx;
                int col = grid[inx].indexOf(MINE);
                result.add(new Bomb(row, col));
                // may be there are others . O . O . .
                for(int jnx = col+1; jnx < grid[inx].length(); jnx++) {
                    if(grid[inx].indexOf(MINE, jnx) > -1) {
                        result.add(new Bomb(row, jnx));
                    }
                }
            }
        }

        return result;
    }

    private static String[] detonate(List<Bomb> mines, String[] grid) {
        for(Bomb mine : mines) {
            grid = explose(mine, grid);
        }
        return grid;
    }

    private static String[] explose(Bomb mine, String[] grid) {
        grid = changeGrid(STEPS.ITSELF, grid, mine);
        grid = changeGrid(STEPS.UP, grid, mine);
        grid = changeGrid(STEPS.DOWN, grid, mine);
        grid = changeGrid(STEPS.LEFT, grid, mine);
        grid = changeGrid(STEPS.RIGHT, grid, mine);
//        grid = changeGrid(STEPS.UP_LEFT, grid, mine);
//        grid = changeGrid(STEPS.UP_RIGHT, grid, mine);
//        grid = changeGrid(STEPS.DOWN_LEFT, grid, mine);
//        grid = changeGrid(STEPS.DOWN_RIGHT, grid, mine);
        // now down_left, down_right

        return grid;
    }

    private static String[] changeGrid(STEPS direction, String[] grid, Bomb mine) {
        int row = mine.getRow(), column = mine.getCol(), toChange = 0, newRow = row - 1;
        int toChangeRow = -1, toChangeCol = -1;
        StringBuilder sb = new StringBuilder(grid[row]);

        switch (direction) {
            case ITSELF:
                sb.setCharAt(column, '.');
                grid[row] = sb.toString();
                break;

            case UP:
                toChange = row - 1;

                if(toChange >= 0 && grid.length > toChange) {
                    sb = new StringBuilder(grid[toChange]);
                    sb.setCharAt(column, '.');
                    grid[toChange] = sb.toString();
                }
                break;

            case DOWN:
                toChange = row + 1;

                if(grid.length > toChange) {
                    sb = new StringBuilder(grid[toChange]);
                    sb.setCharAt(column, '.');
                    grid[toChange] = sb.toString();
                }
                break;

            case LEFT:
                toChange = column - 1;

                if(toChange >= 0 && grid[0].length() > toChange) {
                    sb.setCharAt(toChange, '.');
                    grid[row] = sb.toString();
                }
                break;

            case RIGHT:
                toChange = column + 1;

                if(grid[0].length() > toChange) {
                    sb.setCharAt(toChange, '.');
                    grid[row] = sb.toString();
                }
                break;

            case UP_LEFT:
                toChange = column - 1;
                if((toChange >= 0) && (grid[0].length() > toChange) && (grid.length > toChange)) {
                    sb = new StringBuilder(grid[newRow]);
                    sb.setCharAt(toChange, '.');
                    grid[newRow] = sb.toString();
                }
                break;
            case UP_RIGHT:
                toChange = column + 1;

                if((grid[0].length() > toChange) && (grid.length > toChange)) {
                    sb = new StringBuilder(grid[newRow]);
                    sb.setCharAt(toChange, '.');
                    grid[newRow] = sb.toString();
                }
                break;

            case DOWN_LEFT:
                toChangeRow = row + 1;
                toChangeCol = column - 1;

                if((toChangeCol >= 0) && (grid[0].length() > toChangeCol) && (grid.length > toChangeRow)) {
                    sb = new StringBuilder(grid[toChangeRow]);
                    sb.setCharAt(toChangeCol, '.');
                    grid[toChangeRow] = sb.toString();
                }
                break;

            case DOWN_RIGHT:
                toChangeRow = row + 1;
                toChangeCol = column + 1;

                if((grid[0].length() > toChangeCol) && (grid.length > toChangeRow)) {
                    sb = new StringBuilder(grid[toChangeRow]);
                    sb.setCharAt(toChangeCol, '.');
                    grid[toChangeRow] = sb.toString();
                }
                break;
        }
        return grid;
    }



    static class Bomb {
        int row;
        int col;

        public Bomb(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public int getRow() {
            return row;
        }

        public void setRow(int row) {
            this.row = row;
        }

        public int getCol() {
            return col;
        }

        public void setCol(int col) {
            this.col = col;
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("Bomb{");
            sb.append("row=").append(row);
            sb.append(", col=").append(col);
            sb.append('}');
            return sb.toString();
        }

    }
}
