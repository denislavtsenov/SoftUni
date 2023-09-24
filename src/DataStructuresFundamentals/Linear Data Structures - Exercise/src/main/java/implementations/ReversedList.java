package implementations;

import java.util.Iterator;
import java.util.function.Consumer;

public class ReversedList<E> implements Iterable<E> {

    private final int DEFAULT_CAPACITY = 2;

    private int head;
    private int tail;
    private int size;
    private Object[] elements;

    public ReversedList() {
        this.elements = new Object[DEFAULT_CAPACITY];
    }

    public void add(E element) {

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

    public E get(int index) {

        isValid(index);

        return (E) this.elements[index];

    }

    public E removeAt(int index) {

        if (this.size == 0) {
            return null;
        }

        isValid(index);

        E element = (E) this.elements[index];

        this.elements[index] = null;

        for (int i = index; i < this.size; i++) {
            this.elements[i] = this.elements[i + 1];
        }

        size--;
        return element;
    }

    public int size() {
        return this.size;
    }

    public int capacity() {
        return this.elements.length;
    }

    private void isValid(int index) {
        if (this.head < 0 || index > this.tail) {
            throw new IndexOutOfBoundsException();
        }
    }

    private Object[] grow() {
        int newCapacity = this.elements.length * 2;

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

    @Override
    public void forEach(Consumer<? super E> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            int index = 0;
            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public E next() {
                return (E) elements[index++];
            }
        };
    }
}
