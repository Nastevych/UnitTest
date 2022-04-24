package Calculator;
import java.text.DecimalFormat;
import java.util.Scanner;
public class Calculator {
    private String operation;
    private Scanner scanner;

    public Calculator() {
        this.scanner = new Scanner(System.in);
    }

    public String calculate() {
        System.out.println("Simple Calculator :)");
        System.out.println("How it works: number + <Enter> + number + <Enter> + operation.");
        while (!"q".equals(operation)) {
            try {
                double result = calculationStep();
                return new DecimalFormat("#,##0.00").format(result);
            } catch (NumberFormatException er) {
                System.err.println("Wrong input data! You can use only numbers.");
            } catch (UnsupportedOperationException ex) {
                System.err.println("The operation is not supported! Only '+, -, *, /, ^' is available.");
            } catch (ArithmeticException et){
                System.err.println("You can't divide by zero.");
            }
        }
    }

    private double calculationStep () throws NumberFormatException {

        System.out.println("Enter first number:");
        double firstNumber = Double.parseDouble(scanner.nextLine());

        System.out.println("Enter second number:");
        double secondNumber = Double.parseDouble(scanner.nextLine());

        System.out.println("Enter operation to perform or q for Quit. (only '+, -, *, /, ^' is available):");
        operation = scanner.nextLine();

        return performOperation(firstNumber, secondNumber);
    }


    private double performOperation (double firstNumber, double secondNumber) {
        double result;
        switch (operation){
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
                if (secondNumber == 0){throw new ArithmeticException(String.format("Can't divide by zero", operation));
                } else
                    result = divide(firstNumber, secondNumber);
                break;
            case "^":
                result = pow(firstNumber, secondNumber);
                break;
            case "q":
                System.out.println("You quit! Bye ;)");
                System.exit(0);
            default:
                throw new UnsupportedOperationException(String.format("The operation '%s' is not supported", operation));
        }
        System.out.println("Good job! Result for " + firstNumber + " " + operation + " " + secondNumber + " is");
        return  result;
    }

    private double plus(double firstNumber, double secondNumber){
        return firstNumber + secondNumber;
    }
    private  double minus(double firstNumber, double secondNumber){
        return  firstNumber - secondNumber;
    }
    private  double multiply(double firstNumber, double secondNumber){
        return  firstNumber * secondNumber;
    }
    private  double divide(double firstNumber, double secondNumber){
        return  firstNumber / secondNumber;
    }
    private double pow (double firstNumber, double secondNumber){
        return Math.pow(firstNumber,secondNumber);
    }
}
