package com.talha.app.collections;

import java.io.Serializable;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class Vector<T> extends AbstractList<T> implements List<T>, RandomAccess, Cloneable, Serializable {
    private static final int DEFAULT_CAPASITY = 10;
    private T[] elems;
    private int index;

    private void validateIndexBound(int index) {
        if (index < 0 || index >= this.index) {
            throw new IndexOutOfBoundsException();
        }
    }

    @SuppressWarnings("unchecked")
    public Vector() {
        elems = (T[]) new Object[DEFAULT_CAPASITY];
    }


    public Vector(int initialCapasity, int capasityIncrement) {

    }


    public Vector(Collection<? extends T> collection) {
    }

    public int capasity() {
        return elems.length;
    }

    @Override
    public int size() {
        return index;
    }

    @Override
    public T get(int index) {
        return elems[index];
    }

    @Override
    public boolean add(T t) {
        return super.add(t);
    }

    @Override
    public T set(int index, T element) {
        validateIndexBound(index);
        T oldElem = elems[index];
        elems[index] = element;
        return oldElem;
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Spliterator<T> spliterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Stream<T> stream() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Stream<T> parallelStream() {
        throw new UnsupportedOperationException();
    }

    @Override
    public <T1> T1[] toArray(IntFunction<T1[]> generator) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeIf(Predicate<? super T> filter) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void replaceAll(UnaryOperator<T> operator) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void sort(Comparator<? super T> c) {
        throw new UnsupportedOperationException();
    }

}
