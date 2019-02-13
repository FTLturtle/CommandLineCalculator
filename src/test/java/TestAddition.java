import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestAddition {
    private Calculator calc = new Calculator();

    @Test
    public void testAddition() {

        //Input
        String input ="5+5";
        String expected = "10.0";

        //When
        String actual = calc.calc(input);

        //Then
        assertEquals(expected,actual);

    }

    @Test
    public void testAddition2() {

        //Input
        String input ="100+3";
        String expected = "103.0";

        //When
        String actual = calc.calc(input);

        //Then
        assertEquals(expected,actual);

    }

    @Test
    public void testAddition3() {

        //Input
        String input ="-100+3";
        String expected = "-97.0";

        //When
        String actual = calc.calc(input);

        //Then
        assertEquals(expected,actual);

    }


}