package ru.klodmit;

class Cat extends Animal implements Omnivore {
    Cat(String name, int age) {
        super(name, age);
    }


    @Override
    public String toString() {
        return String.format("Cat name = %s, age = %d. " + hunt(),
                getName(), getAge());
    }


    @Override
    public String hunt() {
        return "I can hunt for mice";
    }
}
