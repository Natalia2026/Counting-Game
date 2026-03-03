import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class App {

    // method to take input from command line and confirm that it's an integer.
    // allow new input if the wrong type is added.
    static int checkIsInt() {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter you guess:");
        String guessString = s.nextLine();
        int guessInt = 0;
        try {
            guessInt = Integer.parseInt(guessString);
        } catch (Exception e) {
            System.out.println("You did not enter an integer. Please try again");
        }
        return guessInt;
    }

    public static void main() {
        //Initialise variables
        int currentGuess = 0;
        boolean winRound = false;
        int winGameCount = 0;
        boolean winGame = false;

        for (int j = 0; j < 3; j++) {
            if (winGameCount >= 2) {
                winGame = true;
                break;
            } else {
                // reset variables
                currentGuess = 0;
                winRound = false;
                // generate number
                int randomNum = ThreadLocalRandom.current().nextInt(1, 51);
                System.out.println("Number has been generated.");
                // 4 guesses
                for (int i = 0; i < 4; i++) {
                    currentGuess = checkIsInt();
                    if (currentGuess == randomNum) {
                        winRound = true;
                        break;
                    } else if (currentGuess > randomNum && i < 3) {
                        System.out.println("Incorrect! My number is lower than " + currentGuess + ".");
                    } else if (currentGuess < randomNum && i < 3) {
                        System.out.println("Incorrect! My number is higher than " + currentGuess + ".");
                    }
                }

                //Print win or lose message at the end of the round.
                if (winRound) {
                    System.out.println("You win this round!");
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
