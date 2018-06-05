package test.twest.test.twest.hackerrank;

import java.util.ArrayList;
import java.util.List;

public class MarsExploration {

    public static int marsExploration(String s) {
        int counter = 0;
        StringBuilder sb = new StringBuilder();
        List<String> separated = new ArrayList<>();
        char[] local = s.toCharArray();
        for(int i = 0; i < local.length; i+=3) {
            sb.append(local[i]);
            sb.append(local[i+1]);
            sb.append(local[i+2]);
            separated.add(sb.toString());
            sb.delete(0, sb.length());
        }

        for(String str : separated) {
            counter += countChanges("SOS", str);
        }


        return counter;
    }

    public static int countChanges(String pattern, String orig) {
        int counter = 0;

        for(int i = 0; i < pattern.length(); i++) {
            if(pattern.charAt(i) != orig.charAt(i)){
                ++counter;
            }
        }
        return counter;
    }

    public static int distance(String a, String b) {
        a = a.toLowerCase();
        b = b.toLowerCase();
        // i == 0
        int[] costs = new int[b.length() + 1];
        for (int j = 0; j < costs.length; j++)
            costs[j] = j;
        for (int i = 1; i <= a.length(); i++) {
            // j == 0; nw = lev(i - 1, j)
            costs[0] = i;
            int nw = i - 1;
            for (int j = 1; j <= b.length(); j++) {
                int cj = Math.min(1 + Math.min(costs[j], costs[j - 1]), a.charAt(i - 1) == b.charAt(j - 1) ? nw : nw + 1);
                nw = costs[j];
                costs[j] = cj;
            }
        }
        return costs[b.length()];
    }

    public static int damLevDist(String A, String B) {
        StringBuilder builder = new StringBuilder();
        builder.append("  ");
        A = A.toLowerCase();
        B = B.toLowerCase();
        int alen = A.length(), blen = B.length();
        int maxdist = alen + blen;
        int alphabet[] = new int[127];

        for (int i = 0; i < alphabet.length; ++i) {
            alphabet[i] = 0;
        }

        int H[][] = new int[alen + 2][blen + 2];
        H[0][0] = maxdist;

        for (int i = 0; i < alen; ++i) {
            H[i][0] = maxdist;
            H[i][1] = i;
        }

        for (int i = 0; i < blen; ++i) {
            H[0][i] = maxdist;
            H[1][i] = i;
            builder.append("  ");
            builder.append(B.charAt(i));
        }
        builder.append('\n');

        for (int a = 2; a < alen + 2; ++a) {
            int lastMatchIndex = 0;
            char ca = A.charAt(a - 2);
            builder.append(ca);
            builder.append(' ');
            for (int b = 2; b < blen + 2; ++b) {
                char cb = B.charAt(b - 2);
                int row = alphabet[cb];
                int col = lastMatchIndex;
                int cost = ca == cb ? 0 : 1;
                if (cost == 0) {
                    lastMatchIndex = b;
                }
                int w = min(
                        H[a - 1][b - 1] + cost,
                        H[a][b - 1] + 1,
                        H[a - 1][b] + 1,
                        H[row][col] + (a - 2 - row) + 1 + (b - 2 - col)
                );
                H[a][b] = w;
                if (w <= 9) {
                    builder.append(' ');
                }
                if (w <= 99) {
                    builder.append(' ');
                }
                builder.append(String.valueOf(w));
            }
            builder.append('\n');
            alphabet[ca] = a - 1;
        }
        System.out.println(builder);
        return H[alen + 1][blen + 1];
    }

    private static int min(int a, int b, int c, int d) {
        return Math.min(a, Math.min(b, Math.min(c, d)));
    }
}
