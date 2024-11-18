package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class PetFeedingProgram {
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
                i--; // Повторить текущую итерацию
                continue;
            }

            if (age <= 0) {
                System.out.println("Incorrect input. Age <= 0");
                continue;
            }

            System.out.print("Enter the weight of the pet (in kg): ");
            double weight;
            try {
                weight = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Couldn't parse a number. Please, try again");
                i--; // Повторить текущую итерацию
                continue;
            }

            if (weight <= 0) {
                System.out.println("Incorrect input. Mass <= 0");
                continue;
            }

            // Создание объекта питомца в зависимости от типа
            if (type.equals("dog")) {
                pets.add(new Dog(name, age, weight));
            } else {
                pets.add(new Cat(name, age, weight));
            }
        }

        // Вывод информации о питомцах
        System.out.println("Pet details:");
        for (Animal pet : pets) {
            System.out.println(pet);
        }
    }
}

abstract class Animal {
    private final String name;
    private final int age;
    private final double weight;

    Animal(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    public double getWeight() {return weight;}
    public abstract double getFeedInfoKg();

}

class Dog extends Animal {
    Dog(String name, int age, double weight) {
        super(name, age,weight);
    }

    @Override
    public double getFeedInfoKg() {
        return getWeight() * 0.3;
    }

    @Override
    public String toString(){
        return String.format("Dog name = %s, age = %d, mass = %.2f, feed = %.2f",
                getName(), getAge(), getWeight(), getFeedInfoKg());
    }
}

class Cat extends Animal {
    Cat(String name, int age, double weight) {
        super(name, age, weight);
    }

    @Override
    public double getFeedInfoKg() {
        return getWeight() * 0.1;
    }

    @Override
    public String toString(){
        return String.format("Cat name = %s, age = %d, mass = %.2f, feed = %.2f",
                getName(), getAge(), getWeight(), getFeedInfoKg());
    }
}