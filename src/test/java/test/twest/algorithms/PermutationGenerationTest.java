package test.twest.algorithms;

import org.junit.jupiter.api.Test;

import java.util.List;

public class PermutationGenerationTest {
    @Test
    public void genPermutationHorowitzBook() {
        String abc = "01";
        int len = 2;
        List<String> result = PermutationGeneration.genPermutationHorowitzBook(abc, 0, len - 1);
        System.out.println(result);
    }
}