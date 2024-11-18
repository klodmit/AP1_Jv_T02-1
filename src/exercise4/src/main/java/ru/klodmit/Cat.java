package ru.klodmit;

import java.util.concurrent.TimeUnit;

class Cat extends Animal {
    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public double goToWalk() {
        double walkTime = getAge() * 0.25;
        try {
            TimeUnit.SECONDS.sleep((long) walkTime);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Walk was interrupted for " + getName());
        }
        return walkTime;
    }

    @Override
    public String toString() {
        return String.format("Cat name = %s, age = %d", getName(), getAge());
    }
}
