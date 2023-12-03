package org.javaacadmey.wonder_field.Player;

import org.javaacadmey.wonder_field.Game;

public class Player {
    private String name;
    private String city;

    public String getName() {
        return name;
    }

    public char guessALetter() {
        System.out.println("Введите букву:");
        char userLetter = Game.console.next().charAt(0);
        while (!isRussianLetter(userLetter)) {
            System.out.println("Ошибка! это не русская буква, введите русскую букву");
            userLetter = Game.console.next().charAt(0);
        }
        System.out.println("Игрок " + this.name + ": буква " + userLetter);
        return userLetter;
    }
    private boolean isRussianLetter(char letter) {
        char[] russianLetters = {
                'а','б','в','г','д','е','ё','ж',
                'з','и','й','к','л','м','н','о',
                'п','р','с','т','у','ф','х','ц',
                'ч','ш','щ','ъ','ы','ь','э','ю','я'
        };
        letter = Character.toLowerCase(letter);
        for (int i = 0; i < russianLetters.length; i++) {
            if (russianLetters[i] == letter) {
                return true;
            }
        }
        return false;
    }
    public String guessAWord() {
        String userWord = Game.console.nextLine();
        System.out.println("Игрок " + this.name + ": слово " + userWord);
        return userWord;
    }
    public PlayerAnswer move() {
        System.out.println("Ход игрока " + this.name + ", " + this.city +
                "Если хотите букву нажмите 'б' и enter, если хотите слово нажмите 'c' и enter");
        char userAnswerType = Game.console.next().charAt(0);
        while (!isAnswerTypeCorrect(userAnswerType)) {
            System.out.println("Ошибка! Если хотите букву нажмите 'б' и enter, если хотите слово нажмите 'c' и enter");
            userAnswerType = Game.console.next().charAt(0);
        }
        String userAnswer = Game.console.nextLine();
        if ('б' == userAnswerType) {
            guessALetter();
        } else {
            guessAWord();
        }
        return new PlayerAnswer(userAnswerType, userAnswer);
    }
    private boolean isAnswerTypeCorrect(char userAnswerType) {
        return ('б' == userAnswerType || 'с' == userAnswerType);
    }
}
