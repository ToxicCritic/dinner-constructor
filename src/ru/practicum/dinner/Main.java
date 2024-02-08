package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static DinnerConstructor dc;
    static Scanner scanner;


    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    addNewDish();
                    break;
                case "2":
                    generateDishCombo();
                    break;
                case "3":
                    System.out.println("До свидания!");
                    return;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }

    private static void addNewDish() {
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine();

        dc.addDish(dishType, dishName);// добавьте новое блюдо
    }

    private static void generateDishCombo() {
        if (dc.dishesByType.keySet().isEmpty()) {
            System.out.println("Вы пока не добавили блюда. Используйте функцию добавления блюда в меню программы. ");
            return;
        }
        System.out.println("Начинаем конструировать обед...");

        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");
        String nextItem = scanner.nextLine();
        ArrayList<String> dishTypes = new ArrayList<>();

        while (!nextItem.isEmpty()) {
                if (dc.checkType(nextItem)) {
                    dishTypes.add(nextItem);
                } else {
                    System.out.println("Похоже, такого блюд такого типа не существует. \nВведите другой тип блюда. ");
                }
            nextItem = scanner.nextLine();
        }
        for (int i = 0; i < numberOfCombos; i++) {
            System.out.println("Комбинация №" + (i + 1));
            dc.createCombination(dishTypes);
        }
    }
}
