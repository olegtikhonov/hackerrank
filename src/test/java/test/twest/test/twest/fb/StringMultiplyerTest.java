package test.twest.test.twest.fb;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StringMultiplyerTest {
    private StringMultiplyer stringMultiplyer;

    @BeforeEach
    public void setUp() throws Exception {
        stringMultiplyer = new StringMultiplyer();
    }

    @Test
    public void multiply() {
        String s1 = "33", s2 = "2";
        System.out.println(stringMultiplyer.multiply(s1, s2));
        System.out.println(stringMultiplyer.multiply("-234", "-55"));
    }
}