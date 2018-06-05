package test.twest.test.twest.hackerrank;

public class CatAndMouse {

    public static String catAndMouse(int x, int y, int z) {
        if (Math.abs(x - z) < Math.abs(y - z)) {
            return "Cat A";
        } else if (Math.abs(y - z) > Math.abs(x - z)) {
            return "Cat B";
        } else {
            return "Mouse C";
        }
    }
}
