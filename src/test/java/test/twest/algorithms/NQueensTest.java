package test.twest.algorithms;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class NQueensTest {
    private NQueens nQueens;

    @BeforeEach
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