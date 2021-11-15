package test.twest.algorithms;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;


public class NQueensTest {
    private NQueens nQueens;

    @Before
    public void setUp() throws Exception {
        nQueens = new NQueens();
    }

    @Test
    public void NQueens() {
        List<List<String>> result = nQueens.solveNQueens(5);
        // Prints all solutions
        System.out.println(result);
    }
}