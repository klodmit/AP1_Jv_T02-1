package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PetListManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Animal> pets = new ArrayList<>();

        System.out.println("Enter the number of pets: ");
        int numberOfPets;
        try {
            numberOfPets = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Couldn't parse a number. Please, try again.");
            return;
        }

        for (int i = 0; i < numberOfPets; i++) {
            System.out.println("Enter the type of pet (dog/cat): ");
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
                i--;
                continue;
            }

            if (age <= 0) {
                System.out.println("Incorrect input. Age <= 0");
                continue;
            }

            if (type.equals("dog")) {
                pets.add(new Dog(name, age));
            } else if (type.equals("cat")) {
                pets.add(new Cat(name, age));
            }
        }

        System.out.println("Pet details:");
        for (Animal pet : pets) {
            System.out.println(pet);
        }
    }
}

abstract class Animal {
    private final String name;
    private final int age;

    Animal(String name,int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

}

class Dog extends Animal {
    Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public String toString(){
        return "Dog name = " + getName() + ", age = " + getAge();
    }
}

class Cat extends Animal {
    Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public String toString(){
        return "Cat name = " + getName() + ", age = " + getAge();
    }
}