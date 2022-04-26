package Calculator;
import java.text.DecimalFormat;
import java.util.List;

public class Calculator {
    private static final List<String> SUPPORTED_OPERATIONS = List.of("+", "/", "-", "*", "^");

    public String calculate(double firstNumber, double secondNumber, String operation) {
        System.out.println("Simple Calculator :)");
        while (SUPPORTED_OPERATIONS.contains(operation)) {
            try {
                double result = calculationStep(firstNumber, secondNumber, operation);
                return new DecimalFormat("#,##0.00").format(result);
            } catch (NumberFormatException er) {
                System.err.println("Wrong input data! You can use only numbers.");
            } catch (ArithmeticException et) {
                System.err.println("You can't divide by zero.");
            }
        }
        throw new IllegalStateException(String.format("Operation '%s' is not supported", operation));
    }


        public double calculationStep (double firstNumber, double secondNumber, String operation){

            return performOperation(firstNumber, secondNumber, operation);
        }


        private double performOperation (double firstNumber, double secondNumber, String operation) throws ArithmeticException {
            double result;
            switch (operation) {
                case "+":
                    result = plus(firstNumber, secondNumber);
                    break;
                case "-":
                    result = minus(firstNumber, secondNumber);
                    break;
                case "*":
                    result = multiply(firstNumber, secondNumber);
                    break;
                case "/":
                    if (secondNumber == 0) {
                        throw new ArithmeticException(String.format("Can't divide by zero", operation));
                    } else
                        result = divide(firstNumber, secondNumber);
                    break;
                case "^":
                    result = pow(firstNumber, secondNumber);
                    break;
                default:
                    result = 0;
                    break;
            }
            System.out.println("Good job! Result for " + firstNumber + " " + operation + " " + secondNumber + " is " + result);
            return result;
        }

        private double plus ( double firstNumber, double secondNumber){
            return firstNumber + secondNumber;
        }
        private double minus ( double firstNumber, double secondNumber){
            return firstNumber - secondNumber;
        }
        private double multiply ( double firstNumber, double secondNumber){
            return firstNumber * secondNumber;
        }
        private double divide ( double firstNumber, double secondNumber){
            return firstNumber / secondNumber;
        }
        private double pow ( double firstNumber, double secondNumber){
            return Math.pow(firstNumber, secondNumber);
        }
}




