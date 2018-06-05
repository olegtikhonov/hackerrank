package test.twest.test.twest.hackerrank;

public class DesignerPdfViewer {

    public static int getIndex(char ch) {
        return "abcdefghijklmnopqrstuvwxyz".indexOf(ch);
    }


    public static int designerPdfViewer(int[] h, String word) {
        char[] input = word.toCharArray();
        int max = 0;
        for (char c : input) {
            int index = getIndex(c);
            max = Math.max(max, h[index]);
        }
        return max * word.length();
    }
}
