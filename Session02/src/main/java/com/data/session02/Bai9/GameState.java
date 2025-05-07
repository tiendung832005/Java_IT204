package com.data.session02.Bai9;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GameState {
    private String secretWord;
    private char[] displayWord;
    private Set<Character> guessedLetters = new HashSet<>();
    private int remainingTries = 6;
    private boolean gameOver = false;
    private boolean win = false;

    public GameState(String secretWord) {
        this.secretWord = secretWord.toLowerCase();
        this.displayWord = new char[secretWord.length()];
        Arrays.fill(this.displayWord, '_');
    }

    public void guessLetter(String wordGuess) {
        if (gameOver) return;

        wordGuess = wordGuess.toLowerCase();
        boolean correct = false;

        for (char ch : wordGuess.toCharArray()) {
            if (secretWord.indexOf(ch) >= 0) {
                guessedLetters.add(ch);
                correct = true;
            }
        }

        updateDisplayWord();

        if (!correct) {
            remainingTries--;
        }

        if (String.valueOf(displayWord).equals(secretWord)) {
            win = true;
            gameOver = true;
        }

        if (remainingTries <= 0) {
            gameOver = true;
        }
    }

    private void updateDisplayWord() {
        for (int i = 0; i < secretWord.length(); i++) {
            if (guessedLetters.contains(secretWord.charAt(i))) {
                displayWord[i] = secretWord.charAt(i);
            }
        }
    }

    // Getters
    public String getDisplayWord() {
        return new String(displayWord).replaceAll("", " ").trim();
    }

    public int getRemainingTries() {
        return remainingTries;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public boolean isWin() {
        return win;
    }

    public String getSecretWord() {
        return secretWord;
    }
}
