package test.twest.test.twest.hackerrank;

public class GradingStudents {
    // rules:
    // a. If the difference between the grade and the next multiple of 5 is less than 3, round up to the next multiple of 5.
    // b. If the value of grade is less than 38, no rounding occurs as the result will still be a failing grade.
    public static int[] gradingStudents(int[] grades) {

        for(int i = 0; i < grades.length; i++) {
            // rule b
            if(grades[i] < 38) {
                // do nothing
            } else {
                int tmp = roundToMultipleFive(grades[i]);
                if((tmp - grades[i]) < 3) {
                    grades[i] = tmp;
                }
            }
        }

        return grades;
    }

    public static int roundToMultipleFive(int number) {
        int divisor = number % 10;
        if(divisor < 5) {
            return number + (5 - divisor);
        } else {
            return number + (10 - divisor);
        }
    }
}
