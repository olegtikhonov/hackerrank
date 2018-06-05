package test.twest.test.twest.geeks4geeks;

public class Math {

    //Write a program to calculate pow(x,n)
    public static int pow(int x, int n) {
        if(n == 0) {
            return 1;
        } else if (n == 1) {
            return x;
        } else {
            return x * pow(x, n -1);
        }
    }
}
