/*
 * This program makes use of the mXparser package developed by Mariusz Gromada
 * URL: http://mathparser.org/api/org/mariuszgromada/math/mxparser/package-summary.html
 *
 * To get the code to run, you need to add the library MathParser.org-mXparser-v.4.2.0-jdk.1.8.jar
 * which is already included in the lib folder.
 */

import org.mariuszgromada.math.mxparser.Expression;
import org.mariuszgromada.math.mxparser.mXparser;

import java.util.ArrayList;

class Calculator {
    private int base; // current base of calculator. The base controls how the calculator interprets input and output valid bases are 1 to 36, but default is 10
    private String trigUnits; // current trig units, degrees or radians. Controls how trig functions work (sin(), cos(), etc.)
    private double memory; // double value stored in memory
    private double currentValue; // most recent value


    /*
     *  Constructor. Defaults to base 10, radians as trig units, and 0 for the memory and currentValue
     */
    Calculator() {
        base = 10;
        trigUnits = "radians";
        memory = 0;
        currentValue = 0;
    }


    // PACKAGE PRIVATE METHODS:
    /*
     * This is the main method of the calculator object. This method takes a String as input (e.g., "(2 * 3) / 2"),
     * interprets the string as a mathematical expression, calculates the value of the expression,
     * and returns the value as a String (e.g., "2.5"). If the input is not a valid mathematical expression, the
     * method will return the string "NaN".
     */
    String calc(String input) {
        String convertedInput = convertExpressionToBase10IfNotInBase10(input, this.base); // If the user has changed the base, the expression needs to be converted to decimal before it will work.

        Expression expression = new Expression(convertedInput); // Declaring and initializing a new Expression object

        this.currentValue = expression.calculate(); // Calculating the value of the expression

        return getCurrentValueAsString(); // returns the value of the expression in the correct base
    }


    /*
     * Accesses the currentValue and returns it as a string
     */
    String getCurrentValueAsString() {
        return valueAsStringInCorrectBase(this.currentValue);
    }


    /*
     * resets currentValue to 0.
     */
    void resetCurrentValue() {
        this.currentValue = 0;
    }


    /*
     * inverts current value
     */
    void invertCurrentValue() {
        this.currentValue = this.currentValue * -1;
    }


    /*
     * Accesses the memory and returns it as a string.
     */
    String getMemoryAsString() {
        return valueAsStringInCorrectBase(this.memory);
    }


    /*
     * adds the currentValue to memory.
     */
    void addCurrentValueToMemory() {
        this.memory = this.memory + this.currentValue;
    }


    /*
     * Resets memory to 0.
     */
    void resetMemory() {
        this.memory = 0;
    }


    /*
     * Accesses the current base of the calculator and returns it as an int.
     */
    int getBase() {
        return base;
    }


    /*
     * Sets the current base of the calculator. Valid bases are 1 to 36. If a valid number is not entered, then no
     * change occurs.
     */
    void setBase(int newBase) {
        if (newBase >= 1 && newBase <= 36) {
            this.base = newBase;
        }
    }


    /*
     * Accesses the current trigUnits being used for trig functions.
     */
    String getTrigUnits() {
        return trigUnits;
    }


    /*
     * Sets the current trigUnits being used. Valid input is "degrees" or "radians". If a valid input is not entered,
     * then no change occurs.
     */
    void setTrigUnits(String newTrigUnits) {
        if (newTrigUnits.equals("degrees") || newTrigUnits.equals("radians")) {
            this.trigUnits = newTrigUnits;

            if (trigUnits.equals("degrees")) {
                mXparser.setDegreesMode();
            } else {
                mXparser.setRadiansMode();
            }

        }
    }


    // PRIVATE METHODS:

    /*
     * This method takes a string, expressionToConvert (e.g., "1010 + 0011101", in base originalBase (e.g., base 2)
     * and turns it into an expression in base 10 (10.0 + 29.9) and returns that. This is essential, because the
     * mXparser library only supports parsing strings as mathematical expressions in decimal. Before an expression
     * in another base can be properly evaluated, it needs to be converted into decimal.
     */
    private static String convertExpressionToBase10IfNotInBase10(String expressionToConvert, int originalBase) {
        if (originalBase == 10) { // if the base is already 10, then the expression does not need to be changed.
            return expressionToConvert;
        }

        ArrayList<String> arrayListExpression = convertExpressionToArrayList(expressionToConvert); // splitting expression up into array of strings to isolate the numbers

        return convertArrayListExpressionToExpressionInBase10(arrayListExpression, originalBase); // converting the numbers in the expression to the correct base and reconstructing it as a string
    }


    /*
     * This method takes an ArrayList of an expression and returns a string with that expression converted into base 10
     */
    private static String convertArrayListExpressionToExpressionInBase10(ArrayList<String> arrayListExpression, int base) {
        StringBuilder expressionInBase10 = new StringBuilder();

        // The following for each loop converts all the numbers from their original base into decimal, and then reconstructs the string
        for (String s : arrayListExpression) {
            if (Character.isDigit(s.charAt(0)) || Character.isUpperCase(s.charAt(0))) {
                expressionInBase10.append(mXparser.convOthBase2Decimal(s, base));
            } else {
                expressionInBase10.append(s);
            }
        }

        return expressionInBase10.toString();
    }


    /*
     * This method takes a string math expression as an argument and returns that string math expression as an
     * ArrayList that has split the expression up so that each number is in its own string. For example (12 + 24) * 38
     * would become an arrayList with the elements {"(", "12", " + ", "24", ") * ", "38"}.
     * NOTE: for bases 11 to 36, uppercase characters are used as digits.
     */
    private static ArrayList<String> convertExpressionToArrayList(String expressionToConvert) {
        // in every case, but base 10, the expression needs to be converted to decimal
        StringBuilder tempString = new StringBuilder();
        ArrayList<String> expressionConvertedToArrayList = new ArrayList<>();

        /*
         * The following for loop splits up the expressionToConvert string into multiple pieces in an arrayList
         * it looks for the numbers and splits it up so each number is in its own string.
         * NOTE: for bases 11 to 36, uppercase characters are used as digits.
         */
        for (int i = 0; i < expressionToConvert.length(); i++) {
            if (Character.isDigit(expressionToConvert.charAt(i)) || Character.isUpperCase(expressionToConvert.charAt(i))) {
                tempString.append(expressionToConvert.charAt(i));
                if (i + 1 == expressionToConvert.length() || !(Character.isDigit(expressionToConvert.charAt(i + 1)) || Character.isUpperCase(expressionToConvert.charAt(i + 1)))) {
                    expressionConvertedToArrayList.add(tempString.toString());
                    tempString = new StringBuilder();
                }
            } else {
                tempString.append(expressionToConvert.charAt(i));
                if (i + 1 == expressionToConvert.length() || Character.isDigit(expressionToConvert.charAt(i + 1)) || Character.isUpperCase(expressionToConvert.charAt(i + 1))) {
                    expressionConvertedToArrayList.add(tempString.toString());
                    tempString = new StringBuilder();
                }
            }
        }

        return expressionConvertedToArrayList;
    }


    private String valueAsStringInCorrectBase(double value) {
        if (this.base == 10) {
            return "" + value;
        }
        return mXparser.convDecimal2OthBase(value, this.base);
    }

}