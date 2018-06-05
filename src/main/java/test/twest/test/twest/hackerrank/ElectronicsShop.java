package test.twest.test.twest.hackerrank;

/**
 * Monica wants to buy a keyboard and a USB drive from her favorite electronics store. The store has several models of each.
 * Monica wants to spend as much as possible for the items, given her budget.
 * Given the price lists for the store's keyboards and USB drives, and Monica's budget, find and print the amount of money
 * Monica will spend. If she doesn't have enough money to both a keyboard and a USB drive, print -1 instead. She will buy
 * only the two required items.
 */
public class ElectronicsShop {

    public static int getMoneySpent(int[] keyboards, int[] drives, int budget) {
        int localMaximum = -1, localSum = 0;

        for(int keyIndex = 0; keyIndex < keyboards.length; keyIndex++) {
            for(int driveIndex = 0; driveIndex < drives.length; driveIndex++) {
                localSum = keyboards[keyIndex] + drives[driveIndex];
                if((localMaximum < localSum) && (localSum <= budget)) {
                    localMaximum = localSum;
                }
                localSum = 0;
            }
        }

        return (localMaximum <= budget) ? localMaximum : -1;
    }
}
