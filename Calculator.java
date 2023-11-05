import java.util.Scanner;
public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Display welcome message and instructions
        System.out.println("\nWelcome to the Calculator!\nType '?' to view the syntax and 'q' to quit the program.\n");
        String rules = "\nSYNTAX                                      \n" +
                       "[operand] [operator] [operand]                \n" +
                       "e.g. 5 x 2.9\n                                \n" +
                       "The available operations are: + addition      \n" +
                       "                              - subtraction   \n" +
                       "                              x multiplication\n" +
                       "                              / division      \n" +
                       "                              % modulus       \n" +
                       "                              ^ exponentiation\n";
        // Main calculator loop
        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();
            if (input.equals("?")) {
                // Display syntax rules when user enters '?'
                System.out.println(rules);
            } else if (input.equals("q")) {
                // Exit the program if user enters 'q'
                break;
            } else if (input.equals("")) {
                // Ignore empty input and continue the loop
                continue;
            } else {
                // Parse and evaluate the user input
                String[] equation = input.split(" ");
                try {
                    double firstOperand = Double.parseDouble(equation[0]);
                    double secondOperand = Double.parseDouble(equation[2]);
                    switch (equation[1]) {
                        case "+":
                            System.out.println(firstOperand + secondOperand + "\n");
                            break;
                        case "-":
                            System.out.println(firstOperand - secondOperand + "\n");
                            break;
                        case "x":
                        case "*":
                            System.out.println(firstOperand * secondOperand + "\n");
                            break;
                        case "/":
                            System.out.println(firstOperand / secondOperand + "\n");
                            break;
                        case "%":
                            System.out.println(firstOperand % secondOperand + "\n");
                            break;
                        case "^":
                        case "**":
                            double result = 1;
                            for (int i = 0; i < secondOperand; i++) {
                                result *= firstOperand;
                            }
                            System.out.println(result + "\n");
                            break;
                        default:
                            // Handle invalid operators
                            System.out.println("Invalid operator. Type '?' to view the available operations.\n");
                    }
                } catch (NumberFormatException e) {
                    // Handle non-numeric operands
                    System.out.println("Please enter only numeric operands.\n");
                } catch (ArrayIndexOutOfBoundsException a) {
                    // Handle invalid input format
                    System.out.println("Invalid input. Type '?' to read the syntax.\n");
                }
            }
        }
        scanner.close();
    }
}
