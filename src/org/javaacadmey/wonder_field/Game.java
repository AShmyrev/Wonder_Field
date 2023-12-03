package org.javaacadmey.wonder_field;

import java.util.Arrays;
import java.util.Scanner;

// TODO: Экземпляр класса Game должен содержать в себе массив/ы с вопросами и ответами от юзера
public class Game {
    private static final int PLAYERS_COUNT = 3;
    private static final int ROUNDS_COUNT = 4;
    private static final int GROUP_ROUNDS_COUNT = 3;
    public static final int FINAL_ROUND = 3;
    public static Scanner console = new Scanner(System.in);
    private static String[] qAndA = {
            "1+1", "2",
            "2+2", "4",
            "3+3", "6",
            "4+4", "8"
    };
    /* private static String[] qAndA = new String[8]; */
    private Tableau tableau;
    private Yakubovich yakubovich;

    public static String getQuestion(int questionNumber) {
        switch (questionNumber) {
            case 1 : return qAndA[0];
            case 2 : return qAndA[2];
            case 3 : return qAndA[4];
            case 4 : return qAndA[6];
        }
        return "Something went wrong in getQuestion()";
    }

    public static void init() {
        int questionOrAnswerNumber = 1;
        for (int i = 0; i < qAndA.length; i++) {
            if (i == 0) {
                System.out.println("\"Запуск игры \"Поле Чудес\" - подготовка к игре. Вам нужно ввести вопросы и ответы для игры.\"\n\"Введите вопрос #" + questionOrAnswerNumber + "\"");
            } else if (i % 2 == 0) {
                System.out.println("Введите вопрос #" + questionOrAnswerNumber); // 0 2 4 6 8 10 - 1 2 3 4 5 6
            } else {
                System.out.println("Введите ответ на вопрос #" + questionOrAnswerNumber);
                ++questionOrAnswerNumber;
            }
            qAndA[i] = console.nextLine();
        }
        System.out.println("Инициализация закончена, игра начнется через 5 секунд");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

//    public static void printQAndA() {
//        System.out.println(Arrays.toString(qAndA));
//    }
}
