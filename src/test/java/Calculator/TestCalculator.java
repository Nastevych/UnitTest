package Calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.stream.Stream;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class TestCalculator {
    private Calculator calculator;

    @BeforeAll
    static void initBeforeAll() {
        System.out.println("Start");
    }

    @AfterAll
    static void initAfterAll() {
        System.out.println("Finish");
    }

    @BeforeEach
    void init() {
        calculator = new Calculator();
    }

    @ParameterizedTest
    @DisplayName("Positive Test of Operations using MethodSource")
    @MethodSource("provideValidData")
    void testOperations (double firstNumber, double secondNumber, String operation,  String expectedResult) {
        //WHEN
        String actualResult = calculator.calculate(firstNumber, secondNumber, operation);
        //THEN
        assertEquals(expectedResult, actualResult);
    }

    private static Stream<Arguments> provideValidData() {
        return Stream.of(
                Arguments.of(1, 2, "+", "3,00"),
                Arguments.of(2,2,"/","1,00"),
                Arguments.of(3,2,"-", "1,00"),
                Arguments.of(5,5,"*","25,00"),
                Arguments.of(4,4,"^","256,00")
        );
    }

    @ParameterizedTest
    @DisplayName("Positive Test of Operations using CSV")
    @CsvFileSource (resources = "/testCalculatorData.csv", delimiter = ':')
    void testOperationsCsv(double firstNumber, double secondNumber, String operation,  String expectedResult){
        //WHEN
        String actualResult = calculator.calculate(firstNumber, secondNumber, operation);
        //THEN
        assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest
    @DisplayName("Positive Test of Sum using ValueSource")
    @ValueSource(doubles = {1, 100, Integer.MAX_VALUE})
    void testSumValueSource(double firstNumber){
        //GIVEN
        double secondNumber = 55;
        String operation = "+";
        String expectedResult = prepareExpectedResult(firstNumber, secondNumber, operation);
        //WHEN
        String actualResult = calculator.calculate(firstNumber, secondNumber, operation);
        //THEN
        assertEquals(expectedResult, actualResult);
        }

    @ParameterizedTest
    @DisplayName("Positive Test of Minus using ValueSource")
    @ValueSource(doubles = {1, 100, Integer.MAX_VALUE})
    void testMinusValueSource(double firstNumber){
        //GIVEN
        double secondNumber = 55;
        String operation = "-";
        String expectedResult = prepareExpectedResult(firstNumber, secondNumber, operation);
        //WHEN
        String actualResult = calculator.calculate(firstNumber, secondNumber, operation);
        //THEN
        assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest
    @DisplayName("Positive Test of Multiply using ValueSource")
    @ValueSource(doubles = {1, 100, Integer.MAX_VALUE})
    void testMultiplyValueSource(double firstNumber){
        //GIVEN
        double secondNumber = 55;
        String operation = "*";
        String expectedResult = prepareExpectedResult(firstNumber, secondNumber, operation);
        //WHEN
        String actualResult = calculator.calculate(firstNumber, secondNumber, operation);
        //THEN
        assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest
    @DisplayName("Positive Test of Divide using ValueSource")
    @ValueSource(doubles = {1, 100, Integer.MAX_VALUE})
    void testDivideValueSource(double firstNumber){
        //GIVEN
        double secondNumber = 55;
        String operation = "/";
        String expectedResult = prepareExpectedResult(firstNumber, secondNumber, operation);
        //WHEN
        String actualResult = calculator.calculate(firstNumber, secondNumber, operation);
        //THEN
        assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest
    @DisplayName("Positive Test of Pow using ValueSource")
    @ValueSource(doubles = {1, 100, Integer.MAX_VALUE})
    void testPowValueSource(double firstNumber){
        //GIVEN
        double secondNumber = 5;
        String operation = "^";
        String expectedResult = prepareExpectedResult(firstNumber, secondNumber, operation);
        //WHEN
        String actualResult = calculator.calculate(firstNumber, secondNumber, operation);
        //THEN
        assertEquals(expectedResult, actualResult);
    }

    private String prepareExpectedResult(double firstNumber, double secondNumber, String operation) {
        double expectedResultDouble;
        switch (operation) {
            case "+":
                expectedResultDouble = firstNumber + secondNumber;
                break;
            case "-":
                expectedResultDouble = firstNumber - secondNumber;
                break;
            case "*":
                expectedResultDouble = firstNumber * secondNumber;
                break;
            case "/":
                    expectedResultDouble = firstNumber / secondNumber;
                break;
            case "^":
                expectedResultDouble = Math.pow(firstNumber, secondNumber);
                break;
            default:
                expectedResultDouble = 0;
                break;
        }
        String expectedResult = String.format("%1$,.2f", expectedResultDouble);
        return expectedResult;
    }


}
