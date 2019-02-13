import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestTrigFunctions {
    private Calculator calc = new Calculator();

    @Test
    public void TestTrigFunction1() {
        //Input
        String input = "sin(90)";
        double expected = 0.893996663600;
        double threshold = .0001;

        //When
        double actual = Double.parseDouble(calc.calc(input));

        //Then
        assertEquals(expected, actual, threshold);

    }

    @Test
    public void TestTrigFunction2() {
        //Input
        String input = "cos(90)";
        double expected = -0.44807361612;
        double threshold = .0001;

        //When
        double actual = Double.parseDouble(calc.calc(input));

        //Then
        assertEquals(expected, actual, threshold);

    }

    @Test
    public void TestTrigFunction3() {

        //Input,Given,Threshold
        String input = "tan(90)";
        double expected = -1.99520041220;
        double threshold = .0001;

        //When
        double actual = Double.parseDouble(calc.calc(input));

        //Then
        assertEquals(expected, actual, threshold);

    }

    @Test
    public void TestTrigFunction4() {
        //Input,Given,Threshold
        String input = "asin(90)";
        String expected = "NaN";

        //When
        String actual = calc.calc(input);

        //Then
        assertEquals(expected, actual);

    }

    @Test
    public void TestTrigFunction5() {
        //Input,Given,Threshold
        String input ="acos(90)";
        String expected = "NaN";

        //When
        String actual = calc.calc(input);

        //Then
        assertEquals(expected, actual);

    }

    @Test
    public void TestTrigFunction6() {
        String input = "atan(0)";
        double expected = 0.0;
        double threshold = .0001;

        //When
        double actual = Double.parseDouble(calc.calc(input));

        //Then
        assertEquals(expected, actual, threshold);

    }

    @Test
    public void TestTrigFunction7() {
        //Input
        String input = "asin(1)";
        double expected = 1.570796326794;
        double threshold = .0001;

        //When
        double actual = Double.parseDouble(calc.calc(input));

        //Then
        assertEquals(expected, actual, threshold);

    }

    @Test
    public void TestTrigFunction8() {
        //Input
        String input = "acos(1)";
        double expected = 0.0;
        double threshold = .0001;

        //When
        double actual = Double.parseDouble(calc.calc(input));

        //Then
        assertEquals(expected, actual, threshold);

    }

    @Test
    public void TestTrigFunction9() {

        //Input,Given,Threshold
        String input = "atan(10)";
        double expected = 1.4711276774303;
        double threshold = .0001;

        //When
        double actual = Double.parseDouble(calc.calc(input));

        //Then
        assertEquals(expected, actual, threshold);

    }
}