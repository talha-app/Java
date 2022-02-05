package com.talha.app.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<T> implements Iterable<T>, Cloneable {

    private static int DEFAULT_CAPACITY = 10;
    private T[] m_elems;
    private int m_index;

    public MyArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public MyArrayList(int initialCapacity) {
        checkForCapacity(initialCapacity, "Capacity error");
        m_elems = (T[]) new Object[initialCapacity];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int m_currentIndex;

            @Override
            public boolean hasNext() {
                return m_currentIndex <= m_index;
            }

            @Override
            public T next() {
                if (!hasNext())
                    throw new NoSuchElementException();

                return m_elems[m_currentIndex++];
            }
        };
    }

    private static <R> void copy(R[] src, R[] dest) {
        for (int i = 0; i < src.length; ++i)
            dest[i] = src[i];
    }

    public Object clone() {
        MyArrayList clone = new MyArrayList(m_elems.length);
        copy(m_elems, clone.m_elems);
        clone.m_index = m_index;
        return clone;
    }

    private static void checkForBounds(int index, int bound, String msg) {
        if (0 > index || index > bound)
            throw new IndexOutOfBoundsException(msg);
    }

    private static void checkForCapacity(int capacity, String msg) {
        if (capacity < 0) {
            throw new IllegalArgumentException(msg);
        }
    }

    public int capacity() {
        return m_elems.length;
    }

    public void add(int index, T object) {
        if (m_index == m_elems.length)
            ensureCapacity(m_elems.length + 1);

        for (int i = m_index; i > index; i--) {
            m_elems[i] = m_elems[i - 1];
        }
        m_index++;
        m_elems[index] = object;
    }

    public boolean add(T object) {
        if (m_index == m_elems.length)
            ensureCapacity(m_elems.length + 1);

        m_elems[m_index] = object;
        m_index++;

        return true;
    }

    public T remove(int index) {
        T temp = m_elems[index];
        for (int i = index; i < m_index - 1; i++) {
            m_elems[i] = m_elems[i + 1];
        }
        m_index--;
        return temp;

    }


    public void clear() {
        for (int i = 0; i < m_index; i++) {
            m_elems[i] = null;
        }
        m_index = 0;

    }

    public void trimToSize() {
        this.allocateCapacity(m_index == 0 ? DEFAULT_CAPACITY : m_index);

    }

    public int size() {
        return m_index;
    }

    public T get(int index) {
        checkForBounds(index, m_index - 1, "Index Out Of Bounds");
        return m_elems[index];
    }

    public int indexOf(T object) {
        if (object == null) {
            for (int i = 0; i < m_index; ++i)
                if (m_elems[i] == null)
                    return i;
        } else {
            for (int i = 0; i < m_index; i++) {
                if (object.equals(m_elems[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    private void allocateCapacity(int capacity) {
        T[] temp = (T[]) new Object[capacity];
        for (int i = 0; i < m_index; i++) {
            temp[i] = m_elems[i];

        }
        m_elems = temp;
    }

    public void ensureCapacity(int capacity) {
        checkForCapacity(capacity, "Capacity cannot be less than 0");

        if (capacity <= m_elems.length)
            return;

        if (capacity < m_elems.length * 2)
            this.allocateCapacity(m_elems.length * 2);

        else
            this.allocateCapacity(capacity);

    }

    public T set(int index, T object) {
        checkForBounds(index, m_index - 1, "Index Out Of Bounds");
        T temp = m_elems[index];
        m_elems[index] = object;
        return temp;

    }

    public String toString() {
        String str = "[";
        for (int i = 0; i < m_index; i++) {
            if (str.length() != 1)
                str += ", ";
            str += m_elems[i];
        }

        return str + "]";
    }
}
