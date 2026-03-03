import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class App {

    private static int MAX_GUESS_VALUE = 50;
    private static int MIN_GUESS_VALUE = 1;
    private static int NUMBER_OF_GUESSES = 4;
    private static int NUMBER_OF_ROUNDS = 3;

    // Get input from command line, check its in correct format, return it as int.
    private static int getGuess() {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter you guess:");
        String guessString = s.nextLine();
        int guessInt = 0;
        if (checkIfInteger(guessString)&&checkIfIsInRange(guessString)){
            guessInt = Integer.parseInt(guessString);
        }else{
            getGuess();
        }
        return guessInt;
    }

    private static boolean checkIfInteger(String guessString){
        boolean isInteger = false;
        try {
            Integer.parseInt(guessString);
            isInteger = true;
        } catch (Exception e) {
            System.out.println("You did not enter an integer. Please try again");
        }
        return isInteger;
    }

    private static boolean checkIfIsInRange(String guessString){
        boolean isInRange = false;
        int guessInt = Integer.parseInt(guessString);
        if (guessInt>=MIN_GUESS_VALUE && guessInt<=MAX_GUESS_VALUE){
            isInRange = true;
        } else {
        System.out.println("You did not enter a number between " + MIN_GUESS_VALUE + " and " + MAX_GUESS_VALUE + ". Please try again");
        }
        return isInRange;
    }

    private static boolean checkGuess(int guess, int randomNumber){
        if (guess == randomNumber) {
            return true;
        } else if (guess > randomNumber) {
            System.out.println("Incorrect! My number is lower than " + guess + ".");
            return false;
        } else {
            System.out.println("Incorrect! My number is higher than " + guess + ".");
            return false;
        }
    }

    public static void main() {
        //Initialise variables
        int currentGuess = 0;
        boolean winRound = false;
        int winGameCount = 0;
        boolean winGame = false;

        for (int j = 0; j < 3; j++) {
            if (winGameCount == 2) {
                winGame = true;
                break;
            } else if(j==2 && winGameCount<2) {
                break;
            }
            else {
                // reset variables
                currentGuess = 0;
                winRound = false;
                // generate number
                int randomNum = ThreadLocalRandom.current().nextInt(1, 51);
                System.out.println("Number has been generated.");
                // 4 guesses
                for (int i = 0; i < 4; i++) {
                    currentGuess = getGuess();
                    if (checkGuess(currentGuess,randomNum)){
                        winRound=true;
                        break;
                    }

                }

                //Print win or lose message at the end of the round.
                if (winRound) {
                    System.out.println("Correct! My number was " + randomNum + ". You win this round!");
                    winGameCount++;
                } else {
                    System.out.println("Incorrect! You've run out of guesses. You lose this round!");
                }


            }
        }
        if (winGame){
            System.out.println("Congratulations! You won! Would you like to play again?");
        } else {
            System.out.println("LOSER! Would you like to play again?");
        }

        Scanner s2 = new Scanner(System.in);
        System.out.println("Please enter Y or N");
        String playAgain = s2.nextLine();
        if (Objects.equals(playAgain, "Y")){
            main();
        }

    }

}
