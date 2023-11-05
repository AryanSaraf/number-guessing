import java.util.Scanner;
public class NumberGuessingGame {
    // ANSI escape codes for text formatting
    public static final String ITALIC = "\033[3m";
    public static final String BOLD = "\033[1m";
    public static final String RED = "\033[0;31m";
    public static final String ORANGE = "\033[0;33m";
    public static final String YELLOW = "\033[0;93m";
    public static final String PURPLE = "\033[0;35m";
    public static final String RESET = "\033[0m";
    // Main method to run the game
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n" + BOLD + "Welcome to the Number Guessing Game!" + RESET + "\n" +
                           "\nClick ENTER to start. Type '?' to view the guide.");
        // Main game loop
        while (true) {
            System.out.print("> ");
            String start = scanner.nextLine();
            // Check user input to start game, view guide, or quit
            if (start.equals("")) {
				// Start the game
                play(scanner);
                System.out.println("\nClick ENTER to play again.");
            } else if (start.equalsIgnoreCase("?")) {
                // Display the game guide
                System.out.println("\n GUIDE\n" +
                                   "-------\n" +
                                   "  [↵] -> Start the Number Guessing Game.\n" +
                                   "   ?  -> Print this guide.\n" +
                                   "   q  -> Quit the program.\n\n" +
                                   "- When the game starts, a random number is generated between 1 and 100 (including both).\n" +
                                   "- A prompt appears with the " + ITALIC + "N" + RESET + "th attempt (guess) shown in brackets.\n" +
                                   "- Here, the user must enter their guess i.e. a number between 1 and 100.\n" +
                                   "- On entering a guess, the first indicator describes it as being either 'Too high!' or 'Too low!'.\n" +
                                   "- This indicates that the guess is either higher or lower than the generated number and must be adjusted.\n" +
                                   "- A third option might also appear: 'Nearly there!'. This only occurs when the guess is very close to\n" +
                                   "- the generated number and does not indicate whether it is higher or lower than it.\n" +
                                   "- Below the first indicator is the second indicator which indicates the accuracy.\n" +
                                   "- An accuracy of 'Low' means that the guess is quite far from the generated number, 'Medium' indicates\n" +
                                   "  medium accuracy, and 'High' indicates that the guess is close to the number. Additionally, the\n" +
                                   "  accuracy can be 'Super High' when the guess is indeed very close to the generated number.\n");
            } else if (start.equalsIgnoreCase("q")) {
				// Exit the program
                break;
            } else {
                System.out.println("Invalid input. Try again.");
            }
        }
        scanner.close();
    }
    // Method to handle the game logic
    public static void play(Scanner scanner) {
        // Generate a random number between 1 and 100
        int randomNumber = (int)(Math.random() * 100.0) + 1;
        int numberOfAttempts = 1;
        // Print the initial message
        System.out.println("A random number has been generated.\nAre you ready? Let's go!");
        // Game loop for guessing the number
        while (true) {
            // Prompt user for input
            System.out.print("guess [" + numberOfAttempts  + "]: ");
            String input = scanner.nextLine();
            try {
                // Parse user input as an integer guess
                int guess = Integer.parseInt(input);
                // Validate user input (between 1 and 100)
                if (guess < 1 || guess > 100) {
                    throw new NumberFormatException();
                }
                // Compare user's guess with the random number and provide feedback
                if (guess > (randomNumber + 20)) {
                    System.out.println(BOLD + "Too high!" + RESET + "\nAccuracy: " + YELLOW + "Low" + RESET);
                } else if (guess > (randomNumber + 10)) {
                    System.out.println(BOLD + "Too high!" + RESET + "\nAccuracy: " + ORANGE + "Medium" + RESET);
                } else if (guess > (randomNumber + 2)) {
                    System.out.println(BOLD + "Too high!" + RESET + "\nAccuracy: " + RED + "High" + RESET);
                } else if (guess < (randomNumber - 20)) {
                    System.out.println(BOLD + "Too low!" + RESET + "\nAccuracy: " + YELLOW + "Low" + RESET);
                } else if (guess < (randomNumber - 10)) {
                    System.out.println(BOLD + "Too low!" + RESET + "\nAccuracy: " + ORANGE + "Medium" + RESET);
                } else if (guess < (randomNumber - 2)) {
                    System.out.println(BOLD + "Too low!" + RESET + "\nAccuracy: " + RED + "High" + RESET);
                } else if (guess == randomNumber) {
                    // Print success message and exit the loop
                    System.out.println("Congratulations! You found the number in " + numberOfAttempts + " attempts");
                    break;
                } else {
                    System.out.println(BOLD + "Nearly there!" + RESET + "\nAccuracy: " + PURPLE + "Super High" + RESET);
                }
                // Increment the number of attempts
                numberOfAttempts++;
            } catch (NumberFormatException e) {
	            // Invalid input error message
                System.out.println("Enteronly numbers between 1 and 100.");
            }
        }
    }
}
