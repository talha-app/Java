package com.talha.app.collections;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class DoublyLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    private static class Node<T> {
        T item;
        Node<T> next;
        Node<T> prev;

        public Node(T elem)
        {
            this.item = elem;
        }
    }

    public void walkList(Consumer<T> con)
    {
        for (Node<T> node = head; node != null; node = node.next)
        {
            con.accept(node.item);
        }
    }

    /*
        public int indexOf(T item)
        {
            var curNode = head;
            for (int i = 0; curNode != null; curNode = curNode.next)
            {
                if (item == null && curNode.item == null)
                {
                    return i;
                }
                else if (item.equals(curNode.item))
                {
                    return i;
                }
            }
            return -1;
        }
    */
    public int indexOf(T item)
    {
        var curNode = head;
        if (item != null)
        {
            for (int i = 0; head != null; curNode = curNode.next, i++)
            {
                if (curNode.item.equals(item))
                {
                    return i;
                }
            }
        }
        else
        {
            for (int i = 0; head != null; curNode = curNode.next, i++)
            {
                if (curNode.item == null)
                {
                    return i;
                }
            }
        }
        return -1;
    }

    public void insertItem(int index, T item)
    {
        if (index > size || index < 0)
        {
            throw new IndexOutOfBoundsException();
        }

        else if (head == null || index == 0)
        {
            addItemHead(item);
            return;
        }

        else if (index == size)
        {
            addItemTail(item);
            return;
        }
        var curNode = head;
        for (int i = 0; i < index; curNode = curNode.next, i++) ;

        var newNode = new Node<T>(item);
        newNode.next = curNode.next;
        newNode.prev = curNode;
        curNode.next = newNode;
        newNode.next.prev = newNode;
        size++;
    }

    public T get(int index)
    {
        if (size == 0 || index < 0 || index >= size)
        {
            throw new IndexOutOfBoundsException();
        }
        var curNode = head;
        for (int i = 0; i < index; curNode = curNode.next, i++) ;
        return curNode.item;
    }

    public Optional<T> walkList(Predicate<T> pred)
    {
        for (Node<T> node = head; node != null; node = node.next)
        {
            if (pred.test(node.item))
            {
                return Optional.of(node.item);
            }
        }
        return Optional.empty();
    }

    public Optional<T> walkListRev(Predicate<T> pred)
    {
        for (Node<T> node = tail; node != null; node = node.prev)
        {
            if (pred.test(node.item))
            {
                return Optional.of(node.item);
            }
        }
        return Optional.empty();
    }

    public int size()
    {
        return size;
    }

    public void addItemHead(T elem)
    {
        var newNode = new Node<T>(elem);

        if (head != null)
        {
            head.prev = newNode;
        }
        else
        {
            head = newNode;
        }
        newNode.prev = tail;
        tail = newNode;
        size++;
    }

    public Optional<T> getItemHead()
    {
        if (isEmpty())
        {
            return Optional.empty();
        }

        return Optional.of(head.item);
    }

    public Optional<T> getItemTail()
    {
        if (isEmpty())
        {
            return Optional.empty();
        }

        return Optional.of(tail.item);
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public void addItemTail(T elem)
    {
        var newNode = new Node<T>(elem);

        if (head != null)
        {
            tail.next = newNode;
        }
        else
        {
            tail = newNode;
        }
        newNode.next = null;
        newNode.prev = null;
        head = newNode;
        size++;
    }

    public void deleteItemHead()
    {
        if (head == null)
        {
            return;
        }
        else if (head != tail)
        {
            head = head.next;
            head.prev = null;
        }
        else
        {
            head = tail = null;
        }
        size--;
    }

    public void deleteItem(int index)
    {
        if (index >= size || index < 0 || size == 0)
        {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0)
        {
            deleteItemHead();
            return;
        }
        else if (index == size - 1)
        {
            deleteItemTail();
            return;
        }
        Node<T> curNode = head;
        for (int i = 0; i < index; i++, curNode = curNode.next) ;

        curNode.prev.next = curNode.next;
        curNode.next.prev = curNode.prev;
        size--;
    }


    public void deleteItemTail()
    {
        if (tail == null)
        {
            return;
        }
        else if (head != tail)
        {
            tail = tail.prev;
            tail.next = null;
        }
        else
        {
            head = tail = null;
        }
        size--;
    }

    public void clear()
    {
        for (var curNode = head; curNode != null; curNode = curNode.next)
        {
            curNode.prev = null;
        }
        head = tail = null;
        size = 0;
    }

}
