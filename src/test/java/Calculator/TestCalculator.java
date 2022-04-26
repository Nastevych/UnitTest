package Calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.api.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
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
    @DisplayName("Test of operations")
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
    @DisplayName("Test of operations in Csv")
    @CsvFileSource (resources = "/testCalculatorData.csv", delimiter = ':')
    void testOperationsCsv(double firstNumber, double secondNumber, String operation,  String expectedResult){
        //WHEN
        String actualResult = calculator.calculate(firstNumber, secondNumber, operation);
        //THEN
        assertEquals(expectedResult, actualResult);
    }


}
