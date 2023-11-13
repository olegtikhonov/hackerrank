package test.twest.algorithms;

import org.junit.jupiter.api.Test;

public class TowerOfHanoiTest {

    @Test
    public void towerOfHanoi() {
        int disks = 4;
        char fromRod = 'A';
        char toRod = 'B';
        char auxRod = 'C';

        TowerOfHanoi.towerOfHanoi(disks, fromRod, toRod, auxRod);
    }
}