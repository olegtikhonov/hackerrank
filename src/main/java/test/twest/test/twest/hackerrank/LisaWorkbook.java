package test.twest.test.twest.hackerrank;

public class LisaWorkbook {
    static int workbook(int n, int k, int[] arr) {
        int pgnum = 0, sp = 0, temp = 0, m1 = 0, j = 0, i = 0;
        for (i = 0; i < n; i++)//i denotes chapter
        {
            pgnum++;//each chap. starts at new page
            temp = arr[i];/*a temporary copy.. you will understand later*/
            for (j = 1; j <= arr[i]; ) {
                if (temp < k)/*if no. of probs<k check like this..u can interpret easily.*/ {
                    for (m1 = 0; m1 < temp; m1++) {
                        if (j + m1 == pgnum) {
                            sp++;
                            break;
                        }
                    }
                } else {/*if> then check prob with all possible k elements*/
                    for (m1 = 0; m1 < k; m1++) {
                        if (j + m1 == pgnum) {
                            sp++;
                            break;
                        }
                    }
                }

                if (temp > k)/*if number of prob > k reduce them and increase a page.*/ {
                    temp = temp - k;
                    pgnum++;
                }

                j = j + k;/*iterate as j=j+k for next set of probs on same chap.*/
                if (j > arr[i]) {
                    break;
                }
            }
        }
        return sp;
    }
}
