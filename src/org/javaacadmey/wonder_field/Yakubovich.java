package org.javaacadmey.wonder_field;

import org.javaacadmey.wonder_field.Player.Player;

public class Yakubovich {
    private final String name = "Якубович";
    public void startTheShow() {
        System.out.println(this.name + ": Здравствуйте, уважаемые дамы и господа! Пятница! В эфире капитал-шоу «Поле чудес»!");
    }
    public void endTheShow() {
        System.out.println(this.name + ": Мы прощаемся с вами ровно на одну неделю! Здоровья вам, до встречи!");
    }
//    public void welcomePlayers(Player[] players, int roundNumber) {
//        if (Game.FINAL_ROUND == roundNumber) {
//            System.out.println(this.name + ": приглашаю победителей групповых этапов:\n"
//            + players[0].getName() + ", " + players[1].getName() + ", " + players[2].getName());
//        } else {
//            System.out.println(this.name + ": приглашаю " + roundNumber + "-ю тройку игроков\n"
//                    + players[0].getName() + ", " + players[1].getName() + ", " + players[2].getName());
//        }
//    }
    public void welcomePlayers(String[] playerNames, int roundNumber) {
        if (Game.FINAL_ROUND == roundNumber) {
            System.out.println(this.name + ": приглашаю победителей групповых этапов:\n"
            + playerNames[0] + ", " + playerNames[1] + ", " + playerNames[2]);
        } else {
            System.out.println(this.name + ": приглашаю " + roundNumber + "-ю тройку игроков\n"
                    + playerNames[0] + ", " + playerNames[1] + ", " + playerNames[2]);
        }
    }
    public void askQuestion(int roundNumber) {
        switch (roundNumber) {
            case 1 : System.out.println(this.name + ": Внимание вопрос!\n" + Game.getQuestion(roundNumber)); break;
            case 2 : System.out.println(this.name + ": Внимание вопрос!\n" + Game.getQuestion(roundNumber)); break;
            case 3 : System.out.println(this.name + ": Внимание вопрос!\n" + Game.getQuestion(roundNumber)); break;
            case 4 : System.out.println(this.name + ": Внимание вопрос!\n" + Game.getQuestion(roundNumber)); break;
        }
    }
    public void shoutWin(String name, String city, boolean isRoundFinal) {
        if (isRoundFinal) {
            System.out.println(this.name + ": И перед нами победитель Капитал шоу поле чудес! Это "
                    + name + " из " + city + "!");
        } else {
            System.out.println(this.name + ": Молодец! "
                    + name + " из " + city + " проходит в финал!");
        }
    }
    public void checkPlayersAnswer(String playersAnswer, String correctAnswer, Tableau tableau) { // TODO: зачем передавать правильный ответ, если его можно запросить у табло?
        if (playersAnswer.length() == 1 && checkLetter(playersAnswer.charAt(0), tableau)) {
            System.out.println(this.name + ": Есть такая буква, откройте ее!");
            tableau.openALetter(playersAnswer.charAt(0));
        } else if (playersAnswer.length() == 1 && !(checkLetter(playersAnswer.charAt(0), tableau))){
            System.out.println(this.name + ": Нет такой буквы! Следующий игрок, крутите барабан!");
        } else if (!(playersAnswer.length() == 1) && checkWord(playersAnswer, tableau)) {
            System.out.println(this.name + ": " + playersAnswer + "! Абсолютно верно!");
        } else if (!(playersAnswer.length() == 1) && !(checkWord(playersAnswer, tableau))) {
            System.out.println(this.name + ": Неверно! Следующий игрок!");
        }
        System.out.println("__________________________________");
    }
    private boolean checkLetter(char letterToCheck, Tableau tableau) {
        for (char letter : tableau.getLetters()) {
            if (letter == letterToCheck) {
                return true;
            }
        }
        return false;
    }
    private boolean checkWord(String playersAnswer, Tableau tableau) {
        if (tableau.getCorrectAnswer().equals(playersAnswer)) {
            return true;
        } else {
            return false;
        }
    }
}
