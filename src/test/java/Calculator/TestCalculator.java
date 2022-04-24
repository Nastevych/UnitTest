package Calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.RepeatedTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class TestCalculator {
    private Calculator calculator;

    @Test
    @DisplayName("Test of sum")
    void testSum(){
        //GIVEN
        ByteArrayInputStream first = new ByteArrayInputStream("1".getBytes());
        System.setIn(first);
        ByteArrayInputStream second = new ByteArrayInputStream("1".getBytes());
        System.setIn(second);
        ByteArrayInputStream operation = new ByteArrayInputStream("+".getBytes());
        System.setIn(operation);
        String expectedResult = "2";
        //WHEN
        String actualResult = calculator.calculate();

        //THEN
        assertEquals(expectedResult, actualResult);
    }

}
