package test.twest.test.twest.hackerrank;

import org.junit.Test;

import static org.junit.Assert.*;

public class FlatlandSpaceStationsTest {

    @Test
    public void flatlandSpaceStations() {
        FlatlandSpaceStations.flatlandSpaceStations(6, new int[] {0, 1, 2, 4, 3, 5});

        FlatlandSpaceStations.flatlandSpaceStations(2, new int[] {0, 4});
    }
}