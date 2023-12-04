package org.javaacadmey.wonder_field;

import java.util.Arrays;

public class Tableau {
    private String correctAnswer;
    private char[] letters;
    Tableau(String correctAnswer) {
        this.correctAnswer = correctAnswer;
        this.letters = new char[correctAnswer.length()];
        Arrays.fill(letters, '_');
    }

    public void printLetters() {
        if (!areAttributesNotEmpty()) {
            System.out.println("Attributes are empty!");
            return;
        }
        System.out.print(" ");
        for (char letter : letters) {
            if (' ' == letter) {
                System.out.print("_ ");
            } else {
                System.out.print(letter + " ");
            }
        }
        System.out.println();
    }
    public void openALetter(int position) {
        if (!areAttributesNotEmpty()) {
            System.out.println("Attributes are empty!");
            return;
        }
        if (position > 0 && position <= letters.length) {
            letters[position - 1] = correctAnswer.charAt(position);
        }
        printLetters();
    }
    public void openWholeWord() {
        letters = correctAnswer.toCharArray();
        printLetters();
    }
    private boolean isThereAnyUnknownLetters() {
        for (char letter : letters) {
            if ('_' == letter) {
                return true;
            }
        }
        return false;
    }
    // todo: "здесь выкидывается эксепшн"
    private boolean areAttributesNotEmpty() {
        return !correctAnswer.isEmpty() && letters.length != 0;
    }
}
