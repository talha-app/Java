package com.talha.app.collections;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class ArrayStack<T> {
    private T[] items;
    private static final int DEFAULT_COUNT = 10;
    private int index;

    public ArrayStack()
    {
        this(DEFAULT_COUNT);
    }

    @SuppressWarnings("unchecked")
    public ArrayStack(int count)
    {
        if (count < 0)
            throw new IllegalArgumentException();

        this.items = (T[]) new Object[count];
        index = items.length;
    }

    public boolean push(T item)
    {
        if (index == 0)
            return false;


        items[--index] = item;
        return true;
    }

    public Optional<T> pop()
    {
        if (index == items.length)
            return Optional.empty();

        var item = items[index];
        items[index++] = null;
        return Optional.of(item);
    }

    public Optional<T> peek()
    {
        if (index == items.length)
            return Optional.empty();

        var item = items[index];
        return Optional.of(item);
    }

    public void clear()
    {
        IntStream.range(index, items.length).forEach(i -> items[i] = null);
        index = items.length;
    }

    public boolean isEmpty()
    {
        return index == items.length - 1;
    }

    public int count()
    {
        return items.length;
    }

    public int size()
    {
        return items.length - index + 1;
    }

    public void walk(Consumer<T> consumer)
    {
        Arrays.stream(items, index, items.length).forEach(consumer);
    }
}
