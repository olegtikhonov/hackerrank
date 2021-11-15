package test.twest.algorithms;

import org.junit.Test;
import java.util.List;

public class HeapsGeneratorTest {

    @Test
    public void genPerms() {
        String orig = "ABCDE";
        List<String> result = HeapsGenerator.genPerms(orig, orig.length());
        System.out.println(result);
    }
}