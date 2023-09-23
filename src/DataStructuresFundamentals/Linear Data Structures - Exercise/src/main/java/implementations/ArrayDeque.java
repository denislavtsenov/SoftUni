package implementations;

import interfaces.Deque;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayDeque<E> implements Deque<E> {

    private final int DEFAULT_CAPACITY = 7;
    private int head;
    private int tail;
    private int size;
    private Object[] elements;

    public ArrayDeque() {
        this.elements = new Object[DEFAULT_CAPACITY];
        int middle = this.elements.length / 2;
        this.head = this.tail = middle;
    }

    @Override
    public void add(E element) {

        if (this.size == 0) {
            this.elements[tail] = element;
        } else {

            if (this.tail == this.elements.length - 1) {
                this.elements = grow();
            }

            this.elements[++tail] = element;
        }
        size++;
    }

    @Override
    public void offer(E element) {
        this.add(element);
    }

    @Override
    public void addFirst(E element) {

        if (this.size == 0) {
            this.elements[head] = element;
        } else {
        } else {

            if (this.head == 0) {
                this.elements = grow();
            }
            this.elements[--this.head] = element;
        }

        size++;
    }

    @Override
    public void addLast(E element) {
        this.add(element);
    }

    @Override
    public void push(E element) {
        this.addFirst(element);
    }

    @Override
    public void insert(int index, E element) {

    }

    @Override
    public void set(int index, E element) {

    }

    @Override
    public E peek() {
        return (E) this.elements[this.head];
    }

    @Override
    public E poll() {
        return this.removeFirst();
    }

    @Override
    public E pop() {
        return this.removeLast();
    }

    @Override
    public E get(int index) {

        isValid(index);

        return (E) this.elements[index];
    }


    @Override
    public E get(Object object) {
        return null;
    }

    @Override
    public E remove(int index) {
        isValid(index);

        return null;
    }

    @Override
    public E remove(Object object) {
        return null;
    }

    @Override
    public E removeFirst() {

        E elementToReturn = (E) this.elements[this.head];
        this.head = this.head + 1;
        this.size--;
        return elementToReturn;
    }

    @Override
    public E removeLast() {
        E elementToReturn = (E) this.elements[this.tail];

        this.tail = this.tail - 1;
        this.size--;
        return elementToReturn;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public int capacity() {
        return this.elements.length;
    }

    @Override
    public void trimToSize() {
        Object[] newElements = new Object[size];

        for (int i = 0; i < elements.length; i++) {
            newElements[i] = this.elements[this.head++];
        }

        this.elements = newElements;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    private Object[] grow() {
        int newCapacity = this.elements.length * 2 + 1;

        Object[] newElements = new Object[newCapacity];

        int middle = newCapacity / 2;
        int begin = middle - this.size / 2;

        int index = this.head;

        for (int i = begin; index <= this.tail; i++) {
            newElements[i] = this.elements[index++];
        }

        this.head = begin;
        this.tail = this.head + this.size - 1;

        return newElements;
    }

    private void isValid(int index) {
        if (index < 0 || index >= this.elements.length) {
            throw new IndexOutOfBoundsException();
        }
    }
}
