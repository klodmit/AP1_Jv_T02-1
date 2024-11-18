package ru.klodmit;

class Dog extends Animal implements Omnivore {
    Dog(String name, int age) {
        super(name, age);
    }


    @Override
    public String toString() {
        return String.format("Dog name = %s, age = %d. "+ hunt(),
                getName(), getAge());
    }

    @Override
    public String hunt() {
        return "I can hunt for robbers";
    }
}
