package implementations;

import interfaces.List;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayList<E> implements List<E> {

    private int initLength = 4;
    private int size = 0;
    private Object[] elements = new Object[initLength];

    @Override
    public boolean add(E element) {

        if (this.size == this.elements.length) {
            this.elements = grow();
        }
        this.elements[size++] = element;
        return true;
    }



    @Override
    public boolean add(int index, E element) {
        return false;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public int indexOf(E element) {
        return 0;
    }

    @Override
    public boolean contains(E element) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return this.size > 0;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    private Object[] grow() {
        return Arrays.copyOf(this.elements, this.elements.length * 2);
    }
}
