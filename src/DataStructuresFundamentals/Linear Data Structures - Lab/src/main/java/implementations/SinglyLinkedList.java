package implementations;

import interfaces.LinkedList;

import java.util.Iterator;

public class SinglyLinkedList<E> implements LinkedList<E> {
    private Node<E> head;
    private int size;

    private static class Node<E> {
        private E element;
        private Node<E> next;

        Node(E element) {
            this.element = element;
        }
    }

    public SinglyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    @Override
    public void addFirst(E element) {

        Node<E> nextElement = new Node<>(element);

        nextElement.next = this.head;
        this.head = nextElement;

        this.size++;
    }

    @Override
    public void addLast(E element)   {
        Node<E> lastElement = new Node<>(element);

        if (this.isEmpty()) {
            this.head = lastElement;
        } else {
            Node<E> current = this.head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = lastElement;

        }
        this.size++;
    }

    @Override
    public E removeFirst() {
        ensureNonEmpty();

        E element = this.head.element;

        this.head = this.head.next;
        this.size--;

        return element;
    }

    @Override
    public E removeLast() {
        return null;
    }

    @Override
    public E getFirst() {
        ensureNonEmpty();

        return this.head.element;
    }

    @Override
    public E getLast() {
        return null;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }


    private void ensureNonEmpty() {
        if (this.isEmpty()) {
            throw new IllegalStateException();
        }
    }
}
