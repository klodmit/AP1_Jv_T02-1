package ru.klodmit;

abstract class Animal {
    private final String name;
    private final int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Animal increaseAgeIfOlderThan10() {
        return age > 10 ? createWithIncreasedAge() : this;
    }

    protected abstract Animal createWithIncreasedAge();

    @Override
    public abstract String toString();
}
