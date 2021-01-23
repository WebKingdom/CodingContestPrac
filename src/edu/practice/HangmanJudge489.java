package edu.practice;

import java.util.HashMap;
import java.util.Scanner;

public class HangmanJudge489 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        HashMap<Character, Boolean> hmWord = new HashMap<>();
        HashMap<Character, Boolean> hmGuess = new HashMap<>();

        int roundNum = scan.nextInt();

        while (roundNum != -1) {
            System.out.println("Round " + roundNum);

            String word = scan.next();
            for (int i = 0; i < word.length(); i++) {
                hmWord.put(word.charAt(i), false);
            }

            String guess = scan.next();
            for (int i = 0; i < guess.length(); i++) {
                hmGuess.put(guess.charAt(i), false);
            }

            int numGuessedLetters = 0;
            int strokeCount = 0;
            int i = 0;

            while (strokeCount < 7 && i < guess.length()) {

                Object guessPrevVal = hmGuess.replace(guess.charAt(i), true);

                if (guessPrevVal != null && guessPrevVal.equals(false)) {

                    Object wordPrevVal = hmWord.replace(guess.charAt(i), true);

                    if (wordPrevVal != null && wordPrevVal.equals(false)) {
                        numGuessedLetters++;
                    } else {
                        strokeCount++;
                    }
                } else if (guessPrevVal == null) {
                    strokeCount++;
                }

                if (numGuessedLetters == hmWord.size()) {
                    System.out.println("You win.");
                    break;
                }
                i++;
            }

            if (strokeCount >= 7) {
                System.out.println("You lose.");
            } else if (numGuessedLetters < hmWord.size()) {
                System.out.println("You chickened out.");
            }

            hmWord.clear();
            hmGuess.clear();
            roundNum = scan.nextInt();
        }
    }
}
