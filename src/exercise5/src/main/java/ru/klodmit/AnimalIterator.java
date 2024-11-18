package ru.klodmit;

import java.util.List;

class AnimalIterator<Animal> implements BaseIterator<Animal> {
    private List<Animal> animals;
    private int currentIndex;

    public AnimalIterator(List<Animal> animals) {
        this.animals = animals;
        this.currentIndex = 0;
    }

    @Override
    public Animal next() {
        if (!hasNext()) {
            throw new IllegalStateException("No more elements");
        }
        return animals.get(currentIndex++);
    }

    @Override
    public boolean hasNext() {
        return currentIndex < animals.size();
    }

    @Override
    public void reset() {
        currentIndex = 0;
    }
}
