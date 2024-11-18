package ru.klodmit;

class Dog extends Animal {
    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    protected Dog createWithIncreasedAge() {
        return new Dog(getName(), getAge() + 1);
    }

    @Override
    public String toString() {
        return String.format("Dog name = %s, age = %d", getName(), getAge());
    }
}
