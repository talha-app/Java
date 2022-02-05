package com.talha.app.collections;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class CircularQueue<T> {
    private static final int DEFAULT_SIZE = 10;
    private final T[] items;
    private int head;
    private int tail;
    private int size;

    @SuppressWarnings("unchecked")
    public CircularQueue()
    {
        items = (T[]) new Object[DEFAULT_SIZE];
    }

    @SuppressWarnings("unchecked")
    public CircularQueue(int count)
    {
        if (count <= 0)
            throw new IllegalArgumentException("count must be positive");

        items = (T[]) new Object[count];
    }

    public boolean putItem(T item)
    {
        if (items.length == size)
            return false;

        items[tail++] = item;
        tail %= items.length;
        size++;
        return true;
    }

    public Optional<T> getItem()
    {
        if (size == 0)
            return Optional.empty();

        var result = Optional.of(items[head]);
        items[head++] = null;
        head %= items.length;
        size--;
        return result;
    }

    public void clear()
    {
        IntStream.range(head, tail).forEach(i -> items[i] = null);
        head = tail = size = 0;
    }

    public int count()
    {
        return items.length;
    }

    public int size()
    {
        return size;
    }

    public void walk(Consumer<T> consumer)
    {
        IntStream.range(head, tail).forEach(i -> consumer.accept(items[i]));
    }

    public Optional<T> find(Predicate<T> predicate)
    {
        return Arrays.stream(items, head, tail).filter(predicate).findFirst();
    }

}
