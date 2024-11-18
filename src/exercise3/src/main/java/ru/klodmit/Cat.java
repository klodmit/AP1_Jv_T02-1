package ru.klodmit;

class Cat extends Animal {
    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    protected Cat createWithIncreasedAge() {
        return new Cat(getName(), getAge() + 1);
    }

    @Override
    public String toString() {
        return String.format("Cat name = %s, age = %d", getName(), getAge());
    }
}
