import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestDivision {
    private Calculator calc = new Calculator();

    @Test
    public void testDivision1() {

        //Input,Given,Threshold
        String input = "4/2";
        double expected =  2.0;
        double threshold = .0001;

        //When
        double actual = Double.parseDouble(calc.calc(input));

        //Then
        assertEquals(expected, actual, threshold);

    }

    @Test
    public void TestDivision2() {

        //Input,Given,Threshold
        String input ="10/3";
        double expected = 3.3333;
        double threshold = .0001;

        //When
        double actual = Double.parseDouble(calc.calc(input));

        //Then
        assertEquals(expected, actual, threshold);
    }

    @Test
    public void TestDivision3() {

        //Input,Given,Threshold
        String input ="5/2";
        double expected = 2.5;
        double threshold = .0001;

        //When
        double actual = Double.parseDouble(calc.calc(input));

        //Then
        assertEquals(expected, actual, threshold);

    }

    @Test
    public void TestDivision4() {

        //Input,Given
        String input ="0/0";
        String expected = "NaN";

        //When
        String actual = calc.calc(input);

        //Then
        assertEquals(expected, actual);

    }
}