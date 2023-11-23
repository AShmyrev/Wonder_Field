package org.javaacadmey.wonder_field;

import java.util.Scanner;

// TODO: Экземпляр класса Game должен содержать в себе массив/ы с вопросами и ответами.
public class Game {
    private static final int PLAYERS_COUNT = 3;
    private static final int ROUNDS_COUNT = 4;
    private static final int GROUP_ROUNDS_COUNT = 3;
    private static final int FINAL_ROUND = 3;
    public static Scanner console = new Scanner(System.in);
    private String[] qAndA = {
            "1+1", "2",
            "2+2", "4",
            "3+3", "6",
            "4+4", "8",
            "5+5", "10"
    };
    private Tableau tableau;

    public static void init() {
        System.out.println("\"Запуск игры \"Поле Чудес\" - подготовка к игре. Вам нужно ввести вопросы и ответы для игры.\"\n\"Введите вопрос #1\"");
        // TODO: q&a initiation from user
        System.out.println("Инициализация закончена, игра начнется через 5 секунд");
        // TODO: sleep for 5 secs:    Thread.sleep(5000);
        for (int i = 0; i < 50; i++)
            System.out.println();
    }
}
