package ru.klodmit;

interface BaseIterator<T> {
    T next();

    boolean hasNext();

    void reset();
}
