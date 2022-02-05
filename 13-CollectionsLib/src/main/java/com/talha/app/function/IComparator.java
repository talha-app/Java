package com.talha.app.function;

@FunctionalInterface
public interface IComparator<T> {
    int compare(T left, T right);
}
