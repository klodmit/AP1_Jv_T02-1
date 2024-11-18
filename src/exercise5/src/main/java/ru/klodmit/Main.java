package ru.klodmit;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
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
            System.out.print("Enter the type of pet (dog/cat): ");
            String type = scanner.nextLine().trim().toLowerCase();

            if (!type.equals("dog") && !type.equals("cat")) {
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
                continue;
            }

            if (age <= 0) {
                System.out.println("Incorrect input. Age <= 0");
                continue;
            }

            Animal pet = type.equals("dog") ? new Dog(name, age) : new Cat(name, age);
            pets.add(pet);
        }

        AnimalIterator<Animal> iterator = new AnimalIterator<>(pets);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
