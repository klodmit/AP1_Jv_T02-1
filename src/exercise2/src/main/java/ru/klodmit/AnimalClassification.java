package ru.klodmit;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class AnimalClassification {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Scanner scanner = new Scanner(System.in);
        List<Animal> pets = new ArrayList<>();

        System.out.print("Enter the number of pets: ");
        int numberOfPets;
        try {
            numberOfPets = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Couldn't parse a number. Please, try again.");
            return;
        }

        for (int i = 0; i < numberOfPets; i++) {
            System.out.print("Enter the type of pet (dog/cat/hamster/guinea): ");
            String type = scanner.nextLine().trim().toLowerCase();

            if (!type.equals("dog") && !type.equals("cat") && !type.equals("hamster") && !type.equals("guinea")) {
                System.out.println("Incorrect input. Unsupported pet type");
                continue;
            }

            System.out.print("Enter the name of the pet: ");
            String name = scanner.nextLine().trim();

            System.out.print("Enter the age of the pet: ");
            int age;
            try {
                age = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Couldn't parse a number. Please, try again");
                i--; // Повторить текущую итерацию
                continue;
            }

            if (age <= 0) {
                System.out.println("Incorrect input. Age <= 0");
                continue;
            }

            // Создание объекта питомца в зависимости от типа
            switch (type) {
                case "dog":
                    pets.add(new Dog(name, age));
                    break;
                case "cat":
                    pets.add(new Cat(name, age));
                    break;
                case "hamster":
                    pets.add(new Hamster(name, age));
                    break;
                case "guinea":
                    pets.add(new GuineaPig(name, age));
                    break;
            }
        }

        // Вывод информации о травоядных питомцах
        System.out.println("Herbivores:");
        for (Animal pet : pets) {
            if (pet instanceof Herbivore) {
                System.out.println(pet);
            }
        }

        // Вывод информации о всеядных питомцах
        System.out.println("Omnivores:");
        for (Animal pet : pets) {
            if (pet instanceof Omnivore) {
                System.out.println(pet);
            }
        }
    }
}

