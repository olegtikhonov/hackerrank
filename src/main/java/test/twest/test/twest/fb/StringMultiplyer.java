package test.twest.test.twest.fb;

public class StringMultiplyer {

    public Double multiply(String firstNumber, String secondNumber) {
        if(firstNumber.isEmpty() || secondNumber.isEmpty()) {
            throw new IllegalArgumentException("The number should not be empty or null");
        }
        return Double.valueOf(toInt(firstNumber) * toInt(secondNumber));
    }

    boolean isNegative(String aNum) {
        char sign = aNum.charAt(0);
        return (sign == '-') ? true : false;
    }

    int toInt(String aNum) {
        int sum = 0;
        int lenOfNum = aNum.length(), digitInx = 0;
        for (int inx = lenOfNum - 1; inx >= 0; inx--) {
            char num = aNum.charAt(inx);

            if (inx == 0 && isNegative(aNum)) {
                return ~sum + 1;
            }
            // Optimisation 1: num1.charAt(i) - '0';
            int localNum = charToInt(num);
            int tmp;

            if(digitInx == 0) {
                tmp = localNum;
            } else {
                tmp = (int) ((Math.pow(10, digitInx)) * localNum);
            }

            sum += tmp;
            digitInx++;
        }
        return sum;
    }

    int charToInt(char aNum) {
        switch (aNum) {
            case '0':
                return 0;
            case '1':
                return 1;
            case '2':
                return 2;
            case '3':
                return 3;
            case '4':
                return 4;
            case '5':
                return 5;
            case '6':
                return 6;
            case '7':
                return 7;
            case '8':
                return 8;
            case '9':
                return 9;
            default:
                throw new IllegalArgumentException("Provided char is illegal");
        }
    }
}
