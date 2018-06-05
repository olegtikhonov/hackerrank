package test.twest.test.twest.hackerrank;

import java.util.Arrays;

public class FormingAMagicSquare {

    /**
     * One rotation is 90 degree
     * @param m
     * @return
     */
    public static int[][] transpose(int[][] m) {
        for (int x = 0; x < m.length; x++) {
            for (int y = x; y < m[0].length; y++) {
                int temp = m[x][y];
                m[x][y] = m[y][x];
                m[y][x] = temp;
            }
        }
        return m;
    }

    public static int[][] generateMagicSquare(int n) {
        int[][] magicSquare = new int[n][n];
        // Initialize position for 1
        int i = n / 2;
        int j = n - 1;

        // One by one put all values in magic square
        for (int num = 1; num <= n * n; ) {
            if (i == -1 && j == n) //3rd condition
            {
                j = n - 2;
                i = 0;
            } else {
                //1st condition helper if next number
                // goes to out of square's right side
                if (j == n)
                    j = 0;

                //1st condition helper if next number is
                // goes to out of square's upper side
                if (i < 0)
                    i = n - 1;
            }

            //2nd condition
            if (magicSquare[i][j] != 0) {
                j -= 2;
                i++;
                continue;
            } else
                //set number
                magicSquare[i][j] = num++;

            //1st condition
            j++;
            i--;
        }

        // print magic square
        System.out.println("The Magic Square for " + n + ":");
        System.out.println("Sum of each row or column " + n * (n * n + 1) / 2 + ":");
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++)
                System.out.print(magicSquare[i][j] + " ");
            System.out.println();
        }

        return magicSquare;
    }


    public static int formingMagicSquare(int[][] s) {
        int cost[] = {0,0,0,0,0,0,0,0};
        int t[][] =
                {
                        {4,9,2,3,5,7,8,1,6},
                        {4,3,8,9,5,1,2,7,6},
                        {2,9,4,7,5,3,6,1,8},
                        {2,7,6,9,5,1,4,3,8},
                        {8,1,6,3,5,7,4,9,2},
                        {8,3,4,1,5,9,6,7,2},
                        {6,7,2,1,5,9,8,3,4},
                        {6,1,8,7,5,3,2,9,4},
                };

        for (int i = 0; i < 8; i++) {
            cost[i] = Math.abs(t[i][0] - s[0][0]) + Math.abs(t[i][1] - s[0][1]) + Math.abs(t[i][2] - s[0][2]);
            cost[i] = cost[i] + Math.abs(t[i][3] - s[1][0]) + Math.abs(t[i][4] - s[1][1]) + Math.abs(t[i][5] - s[1][2]);
            cost[i] = cost[i] + Math.abs(t[i][6] - s[2][0]) + Math.abs(t[i][7] - s[2][1]) + Math.abs(t[i][8] - s[2][2]);
        }

        Arrays.sort(cost);
        System.out.println(cost[0]);
        return cost[0];
    }
}
