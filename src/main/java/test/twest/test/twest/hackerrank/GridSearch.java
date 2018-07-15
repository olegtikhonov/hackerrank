package test.twest.test.twest.hackerrank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://www.hackerrank.com/challenges/the-grid-search/problem
 */
public class GridSearch {

    public static Map<String, List<int[]>> holder = new HashMap<>();

    // row, indexOf
    private static int[] pair = new int[2];

    public static int[] beginsWith(String[] G, String pattern, int startWith) {
        for(int inx = startWith; inx < G.length; inx++) {
            if(G[inx].contains(pattern)) {
                pair[0] = inx;
                pair[1] = G[inx].indexOf(pattern);
                return pair;
            }
        }
        pair[0] = -1;
        pair[1] = -1;

        return pair;
    }

    public static void fillDict(String[] G, String pattern, int raw) {
        List<int[]> local = new ArrayList<>();

        for(int i = 0; i < G.length; i++) {
            if(G[i].contains(pattern)) {
                // first match
                int[] tmp = new int[2];
                tmp[0] = i;
                tmp[1] = G[i].indexOf(pattern);

                if(tmp[1] > -1) {
                    local.add(tmp);
                    int index = tmp[1] + 1;
                    while (index < G[i].length()) {
                        int var = G[i].indexOf(pattern, index);
                        if(var > -1) {
                            int[] tmp2 = new int[2];
                            tmp2[0] = i;
                            tmp2[1] = var;
                            local.add(tmp2);
                            // add to the places where is located
                            System.out.println("Found also here:=" + var);
                            index = var + 1;
                        }else {
                            break;
                        }
                    }
                }

            }
        }

        if(!local.isEmpty()) {
            holder.put(pattern + "_" + raw, local);
        }
    }



    public static boolean contains(String[] G, String[] pattern, int[] coordinates) {
        if(pair[0] > -1 && pair[1] > -1) {
            // for patterns starts with second raw
            int next = coordinates[0] + 1;
            for(int inxP = 1; inxP < pattern.length; inxP++) {
                if(next < G.length) {
                    int index = G[next].indexOf(pattern[inxP]);
                    if(index > -1) {
                        next++;
                        continue;
                    }else {
                        return Boolean.FALSE;
                    }
                }
            }
            return Boolean.TRUE;

        } else {
            return Boolean.FALSE;
        }
    }


    /**
     *
     * @param G a grid
     * @param P a pattern
     * @return either YES or NO
     */
    public static String gridSearch(String[] G, String[] P) {
        char[][] gridArr = new char[G.length][G[0].length()];
        char[][] patternArr = new char[P.length][P[0].length()];

        for (int i = 0; i < G.length; i++) {
            gridArr[i] = G[i].toCharArray();
        }

        for (int i = 0; i < P.length; i++) {
            patternArr[i] = P[i].toCharArray();
        }
        boolean matchFlag = true;

        for (int i = 0; i < gridArr.length - patternArr.length + 1; i++) {
            for (int j = 0; j < gridArr[0].length - patternArr[0].length + 1; j++) {
                matchFlag = true;
                if (gridArr[i][j] == patternArr[0][0]) {
                    for (int k = 0; k < patternArr.length; k++) {
                        if (matchFlag) {
                            for (int l = 0; l < patternArr[0].length; l++) {
                                if (gridArr[i + k][j + l] != patternArr[k][l]) {
                                    matchFlag = false;
                                    break;
                                }

                            }
                        }
                    }
                    if (matchFlag == true)
                        return "YES";

                } else
                    continue;
            }
        }
        return "NO";
    }

    private static boolean search(int[][] grid, int[][] pattern) {
        int hGrid = grid.length;
        int wGrid = grid[0].length;
        int hPat = pattern.length;
        int wPat = pattern[0].length;

        int wG = 0;
        boolean patternCompletelyFound = false;
        while (wG + wPat <= wGrid && patternCompletelyFound == false) {
            boolean matching = false;
            int hp = 0;
            for (int hG = 0; hG < hGrid; hG++) {
                if (!matching && hGrid - hG < hPat) {
                    break;
                }
                if (hPat == hp) {
                    break;
                }
                if (match(grid[hG], pattern[hp], wG) || match(grid[hG], pattern[0], wG) ) {
                    hp++;
                    matching = true;
                } else {
                    matching = false;
                    hp = 0;
                }
            }
            if (matching == true && hPat == hp) {
                patternCompletelyFound = true;
            }
            wG++;
        }
        return patternCompletelyFound;
    }

    private static boolean match( int[] gridLine, int[] patLine, int wG) {
        boolean matched = true;
        for (int i = 0; i<patLine.length; i++) {
            if (patLine[i] != gridLine[i + wG]) {
                matched = false;
                break;
            }
        }
        return matched;
    }


    private static Boolean test(String[] G, String[] P){
        for( int i = 0; i < P.length; i ++ ){
            int res = -1;
            while(true) {
                res = G[i].indexOf(P[0], res + 1);

                if( res == -1 ) {
                    break;
                }

                if (check(G, P, i, res)) {
                    return Boolean.TRUE;
                }
            }
        }

        return Boolean.FALSE;
    }


    private static Boolean check(String[] G, String[] P,int row, int col){
        for( int checkRow = 1; checkRow < P.length; checkRow ++) {
            int res = G[row + checkRow].indexOf(P[checkRow], col);
            if (res == col) {
                continue;
            } else {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }
}
