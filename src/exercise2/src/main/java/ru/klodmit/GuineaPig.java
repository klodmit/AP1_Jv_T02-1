package ru.klodmit;

public class GuineaPig extends Animal implements Herbivore {
    GuineaPig(String name, int age) {
        super(name, age);
    }

    @Override
    public String chill() {
        return "I can chill for 12 hours";
    }
    @Override
    public String toString() {
        return "GuineaPig name = %s, age = %d. " + chill();
    }
}
