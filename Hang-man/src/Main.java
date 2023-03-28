import java.util.Scanner;

public class Main {

    private static final String[] hangman_words = {"JAVA", "CPLUSPLUS", "HTML", "JAVASCRIPT","NODEJS", "CSS", "PYTHON"};
    private static final int user_tries = 6;

    private static String guessing_words;
    private static char[] guessed_letters;
    private static int remaining_tries;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("---------------------Welcome to Hangman Game---------------------");

        // System will select a random word from the hangman_words array.
        guessing_words = hangman_words[(int) (Math.random() * hangman_words.length)];
        guessed_letters = new char[guessing_words.length()];
        remaining_tries = user_tries;

        // Initialize the guessedLetters array with underscores
        for (int i = 0; i < guessed_letters.length; i++) {
            guessed_letters[i] = '_';
        }

        // Main game loop
        while (true) {
            System.out.println("Word to guess : " + new String(guessed_letters));
            System.out.println("You have " + remaining_tries + " tries left.");
            System.out.print("Please enter a letter : ");
            char letter = input.nextLine().toUpperCase().charAt(0);

            boolean foundLetter = false;
            for (int i = 0; i < guessing_words.length(); i++) {
                if (guessing_words.charAt(i) == letter) {
                    guessed_letters[i] = letter;
                    foundLetter = true;
                }
            }

            if (!foundLetter) {
                remaining_tries--;
                System.out.println("Sorry, " + letter + " is not in the word.");
            }

            if (remaining_tries == 0) {
                System.out.println("Game over! \n The word was " + guessing_words);
                break;
            }

            if (new String(guessed_letters).equals(guessing_words)) {
                System.out.println("Congratulations, you have guessed the word correctly!");
                break;
            }
        }

        input.close();
    }
}
