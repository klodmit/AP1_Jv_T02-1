package ru.klodmit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ExecutorService;
import java.time.Instant;
import java.time.Duration;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Animal> pets = new ArrayList<>();
        ExecutorService executorService = Executors.newCachedThreadPool();
        Instant startTime = Instant.now();

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

        pets.forEach(pet -> executorService.submit(() -> {
            Instant walkStart = Instant.now();
            double walkDuration = pet.goToWalk();
            Instant walkEnd = Instant.now();
            double startTimeSeconds = Duration.between(startTime, walkStart).toMillis() / 1000.0;
            double endTimeSeconds = Duration.between(startTime, walkEnd).toMillis() / 1000.0;

            System.out.printf("%s, start time = %.2f, end time = %.2f%n",
                    pet, startTimeSeconds, endTimeSeconds);
        }));

        executorService.shutdown();
        try {
            executorService.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            System.err.println("Executor was interrupted");
        }
    }
}
