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
        int realIndex = this.head + index;
        this.isValid(realIndex);

        if (realIndex - this.head < this.tail - realIndex) {
            insertAndShiftLeft(realIndex - 1, element);
        } else {
            insertAndShiftRight(realIndex, element);
        }
    }

    private void insertAndShiftRight(int index, E element) {

        E lastElement = (E) this.elements[this.tail];

        for (int i = this.tail; i > index; i++) {
            this.elements[i] = this.elements[i - 1];
        }

        this.elements[index] = element;
        this.addLast(lastElement);
    }

    private void insertAndShiftLeft(int index, E element) {

        E firstElement = (E) this.elements[this.head];

        for (int i = this.head; i < index; i++) {
            this.elements[i] = this.elements[i + 1];
        }

        this.elements[index] = element;
        this.addFirst(firstElement);

    }

    @Override
    public void set(int index, E element) {
        int realIndex = this.head + index;
        this.isValid(realIndex);

        this.elements[realIndex] = element;
    }

    @Override
    public E peek() {
        if (this.size != 0) {
            return (E) this.elements[this.head];
        }
        return null;
    }

    @Override
    public E poll() {
        return this.removeFirst();
    }

    @Override
    public E pop() {
        return this.removeFirst();
    }

    @Override
    public E get(int index) {

        int realIndex = this.head + index;
        isValid(realIndex);

        return (E) this.elements[realIndex];
    }


    @Override
    public E get(Object object) {

        if (isEmpty()) {
            return null;
        }

        for (int i = this.head; i <= this.tail; i++) {
            if (this.elements[i].equals(object)) {
                return (E) this.elements[i];
            }
        }
        return null;
    }

    @Override
    public E remove(int index) {

        int realIndex = this.head + index;
        this.isValid(realIndex);

        return (E) this.elements[realIndex];
    }

    @Override
    public E remove(Object object) {

        if (isEmpty()) {
            return null;
        }

        for (int i = this.head; i <= this.tail; i++) {
            if (this.elements[i].equals(object)) {
                E element = (E) this.elements[i];

                this.elements[i] = null;

                for (int j = i; j < this.tail; j++) {
                    this.elements[j] = this.elements[j + 1];
                }
                this.removeLast();

                return element;
            }
        }
        return null;
    }

    @Override
    public E removeFirst() {
        if (!isEmpty()) {
            E elementToReturn = (E) this.elements[this.head];
            this.elements[this.head] = null;
            this.head++;
            this.size--;
            return elementToReturn;
        }
        return null;
    }

    @Override
    public E removeLast() {
        if (!isEmpty()) {
            E elementToReturn = (E) this.elements[this.tail];
            this.elements[this.tail] = null;
            this.tail--;
            this.size--;
            return elementToReturn;
        }
        return null;
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
        Object[] newElements = new Object[this.size];

        int index = 0;

        for (int i = this.head; i <= this.tail; i++) {
            newElements[index++] = this.elements[i];
        }

        this.elements = newElements;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = head;

            @Override
            public boolean hasNext() {
                return index <= tail;
            }

            @Override
            public E next() {
                return (E) elements[index++];
            }
        };
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
        if (this.tail < 0 || index > this.tail) {
            throw new IndexOutOfBoundsException();
        }
    }
}
