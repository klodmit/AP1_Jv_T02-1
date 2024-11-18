package ru.klodmit;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of pets: ");
        int numberOfPets;
        try {
            numberOfPets = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Couldn't parse a number. Please, try again.");
            return;
        }

        List<Animal> pets = java.util.stream.IntStream.range(0, numberOfPets)
                .mapToObj(i -> {
                    System.out.print("Enter the type of pet (dog/cat): ");
                    String type = scanner.nextLine().trim().toLowerCase();

                    if (!type.equals("dog") && !type.equals("cat")) {
                        System.out.println("Incorrect input. Unsupported pet type");
                        return null;
                    }

                    System.out.print("Enter the name of the pet: ");
                    String name = scanner.nextLine().trim();

                    System.out.print("Enter the age of the pet: ");
                    int age;
                    try {
                        age = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Couldn't parse a number. Please, try again");
                        return null;
                    }

                    if (age <= 0) {
                        System.out.println("Incorrect input. Age <= 0");
                        return null;
                    }

                    return type.equals("dog") ? new Dog(name, age) : new Cat(name, age);
                })
                .filter(Objects::nonNull)
                .toList();

        List<Animal> updatedPets = pets.stream()
                .map(Animal::increaseAgeIfOlderThan10)
                .toList();

        updatedPets.forEach(System.out::println);
    }
}
