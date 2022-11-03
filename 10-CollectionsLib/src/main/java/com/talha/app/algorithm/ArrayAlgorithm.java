package com.talha.app.algorithm;

import com.talha.app.function.IComparator;

import java.util.Optional;

public final class ArrayAlgorithm {
    private ArrayAlgorithm()
    {
    }

    public static <T> int binarySearch(T[] a, int offset, int length, T key, IComparator<? super T> comparator)
    {
        int left = offset;
        int right = length - 1;
        int mid;

        while (left <= right)
        {
            mid = (left - offset + right) / 2;

            int compareResult = comparator.compare(a[mid], key);

            if (compareResult == 0)
            {
                return mid;
            }
            else if (compareResult < 0)
            {
                left = mid + 1;
            }
            right = mid + 1;
        }
        return -1;
    }

    public static <T> Optional<T> binarySearch(T[] a, T key, IComparator<? super T> comp)
    {
        var idx = binarySearch(a, 0, a.length, key, comp);

        return idx < 0 ? Optional.empty() : Optional.of(a[idx]);
    }

    public static <T> Optional<T> exponentialSearch(T[] a, T key, IComparator<? super T> comparator)
    {
        int i, left = 0;

        if (comparator.compare(key, a[0]) < 0)
        {
            return Optional.empty();
        }

        i = 1;
        while (i < a.length && comparator.compare(a[i], key) < 0)
            i *= 2;

        left = i / 2;

        var idx = binarySearch(a, left, i - left + 1, key, comparator);

        return idx < 0 ? Optional.empty() : Optional.of(a[idx]);
    }
}
