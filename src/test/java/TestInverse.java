import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestInverse {
    private Calculator calc = new Calculator();

    @Test
    public void testInverse1() {
        //Input
        String input ="-(1/4)";
        String expected = "-0.25";

        //When
        String actual = calc.calc(input);

        //Then
        assertEquals(expected,actual);
    }

    @Test
    public void testInverse2() {
        //Input
        String input ="(1/4)";
        String expected = "0.25";

        //When
        String actual = calc.calc(input);

        //Then
        assertEquals(expected,actual);
    }

    @Test
    public void testInverse3() {
        //Input
        String input ="1^(-1)";
        String expected = "1.0";

        //When
        String actual = calc.calc(input);

        //Then
        assertEquals(expected,actual);
    }
}