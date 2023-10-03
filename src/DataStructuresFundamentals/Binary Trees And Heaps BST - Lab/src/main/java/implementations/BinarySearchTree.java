package implementations;

import interfaces.AbstractBinarySearchTree;

public class BinarySearchTree<E extends Comparable<E>> implements AbstractBinarySearchTree<E> {

    private Node<E> root;
    private Node<E> leftChild;
    private Node<E> rightChild;
    private E value;

    public BinarySearchTree() {

    }

    @Override
    public void insert(E element) {

    }

    @Override
    public boolean contains(E element) {
        return false;
    }

    @Override
    public AbstractBinarySearchTree<E> search(E element) {
        return null;
    }

    @Override
    public Node<E> getRoot() {
        return this.root;
    }

    @Override
    public Node<E> getLeft() {
        return this.leftChild;
    }

    @Override
    public Node<E> getRight() {
        return this.rightChild;
    }

    @Override
    public E getValue() {
        return this.value;
    }
}
