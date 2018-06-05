package test.twest.test.twest.hackerrank;

/**
 * An English text needs to be encrypted using the following encryption scheme.
 * First, the spaces are removed from the text. Let be the length of this text.
 * Then, characters are written into a grid, whose rows and columns have the following constraints:
 *
 */
public class Encryption {

    public static boolean isValidChar(char c) {
        if(c == '\u0000'){
            return false;
        }
        return true;
    }

    public static String encryption(String s) {
        // 1. remove all spaces
        String local = s.replace(" ", "").trim();
        int lowBound = (int) Math.floor(Math.sqrt(local.length()));
        int upperBound = (int) Math.ceil(Math.sqrt(local.length()));
        int counter = 0;
        StringBuffer sb = new StringBuffer();
        // here is a trick to keep a condition going
        if((lowBound * upperBound) < local.length()) {
            lowBound = upperBound;
        }

        char[][] holder = new char[lowBound][upperBound];

        for(int row = 0; row < lowBound; row++) {
            for(int col = 0; col < upperBound; col++) {
                if(counter < local.length()) {
                    holder[row][col] = local.charAt(counter);
                    counter++;
                }
            }
        }

        for(int jnx = 0; jnx < holder[0].length; jnx++) {
            for (int inx = 0; inx < holder.length; inx++) {
                if(isValidChar(holder[inx][jnx])) {
                    sb.append(holder[inx][jnx]);
                }

            }
            sb.append(" ");
        }

        return sb.toString().trim();
    }
}
