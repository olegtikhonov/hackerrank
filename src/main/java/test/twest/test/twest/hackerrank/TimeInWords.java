package test.twest.test.twest.hackerrank;

public class TimeInWords {
    static String[] numbers = {
                                "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
                                "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
                                "eighteen", "nineteen", "twenty", "twenty one", "twenty two", "twenty three", "twenty four",
                                "twenty five", "twenty six", "twenty seven", "twenty eight", "twenty nine"
                              };

    public static String timeInWords(int h, int m) {
        String currentTime  = "";
        // **** at hour ****
        if (m == 0) {
            currentTime = numbers[h] + " o' clock";
        }
        // **** at quarter past ****
        else if (m == 15) {
            currentTime = "quarter past " + numbers[h];
        }
        // **** at half hour ****
        else if (m == 30) {
            currentTime = "half past " + numbers[h];
        }
        // **** at quarter before ****
        else if (m == 45) {
            currentTime = "quarter to " + numbers[h + 1];
        }
        // **** before half hour ****
        else if (m < 30) {
            currentTime = numbers[m] + " minute" + (m <= 1 ? "" : "s") + " past " + numbers[h];
        }
        // **** past half hour ****
        else {
            currentTime = numbers[60 - m] + " minute" + ((60 - m) <= 1 ? "" : "s") + " to " + numbers[h + 1];
        }

        return currentTime;
    }
}
