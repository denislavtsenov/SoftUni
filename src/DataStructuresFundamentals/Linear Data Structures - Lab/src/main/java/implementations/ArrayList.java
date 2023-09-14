package implementations;

import interfaces.List;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayList<E> implements List<E> {

    private Object[] elements;
    private final int initLength = 4;
    private int size;


    public ArrayList() {
        this.elements = new Object[initLength];
    }


    @Override
    public boolean add(E element) {

        checkCapacity();

        this.elements[size++] = element;
        return true;
    }

    @Override
    public boolean add(int index, E element) {

        checkCapacity();

        checkIndex(index);

        E lastElement = this.getElement(size - 1);

        for (int i = this.size - 1; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        this.elements[this.size] = lastElement;
        this.elements[index] = element;
        size++;

        return true;
    }


    @Override
    public E get(int index) {
        checkIndex(index);

        return this.getElement(index);
    }

    @Override
    public E set(int index, E element) {

        checkIndex(index);

        E oldElement = this.getElement(index);
        this.elements[index] = element;

        return oldElement;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);

       Object existing = this.elements[index];
        shift(index);
        this.size--;
        checkCapacity();
        return (E) existing;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public int indexOf(E element) {

        if (this.size > 0) {
            for (int i = 0; i < elements.length; i++) {

                if (this.elements[i].equals(element)) {
                    return i;
                }
            }
        }

        return -1;
    }

    @Override
    public boolean contains(E element) {

        if (size == 0) {
            return false;
        }

        for (int i = 0; i < elements.length; i++) {

            if (elements[i].equals(element)) {
                return true;
            }
        }
        return false;
    }


    @Override
    public boolean isEmpty() {
        return this.size <= 0;
    }

    @Override
    public Iterator<E> iterator() {

        return new Iterator<E>() {

            private int index = 0;

            @Override
            public boolean hasNext() {
                return this.index < size();
            }

            @Override
            public E next() {
                return get(index++);
            }
        };
    }

    private Object[] grow() {
        return Arrays.copyOf(this.elements, this.elements.length * 2);
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException(String.format("Index out of bounds: %d for size: %d", index, this.size));
        }
    }

    private void checkCapacity() {
        if (this.size == this.elements.length) {
            this.elements = grow();
        }

        if (this.size < this.elements.length / 3) {
            this.elements = shrink();
        }
    }

    private E getElement(int index) {
        return (E) this.elements[index];
    }

    private Object[] shrink() {
        return Arrays.copyOf(this.elements, this.elements.length / 2);
    }

    private void shift(int index) {

        for (int i = index; i < this.size - 1; i++) {
            this.elements[i] = this.elements[i + 1];
        }
    }
}
