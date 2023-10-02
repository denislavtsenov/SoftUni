package implementations;

import interfaces.AbstractTree;

import java.util.*;

public class Tree<E> implements AbstractTree<E> {

    private E key;
    private Tree<E> parent;
    private List<Tree<E>> children;

    public Tree(E key) {
        this.key = key;
        this.children = new ArrayList<>();
    }


    @Override
    public void setParent(Tree<E> parent) {
        this.parent = parent;
    }

    @Override
    public void addChild(Tree<E> child) {
        this.children.add(child);
    }

    @Override
    public Tree<E> getParent() {
        return this.parent;
    }

    @Override
    public E getKey() {
        return this.key;
    }

    @Override
    public String getAsString() {
        StringBuilder builder = new StringBuilder();

        traverseTreeWithRecurrence(builder, 0, this);

        return builder.toString().trim();
    }

    @Override
    public List<E> getLeafKeys() {

        List<E> leafs = new ArrayList<>();
        this.findLeafKeys(this, leafs);

        return leafs;
    }

    @Override
    public List<E> getMiddleKeys() {

        List<E> middleKeys = new ArrayList<>();

        this.findMiddleNodes(this, middleKeys);

        return middleKeys;
    }

    @Override
    public Tree<E> getDeepestLeftmostNode() {

        List<E> leafs = new ArrayList<>();
        findLeafKeys(this, leafs);

        return new Tree<>(leafs.get(0));
    }

    @Override
    public List<E> getLongestPath() {
        return null;
    }

    @Override
    public List<List<E>> pathsWithGivenSum(int sum) {
        return null;
    }

    @Override
    public List<Tree<E>> subTreesWithGivenSum(int sum) {
        return null;
    }


    private void traverseTreeWithRecurrence(StringBuilder builder, int indent, Tree<E> tree) {

        builder
                .append(this.getPadding(indent))
                .append(tree.getKey())
                .append(System.lineSeparator());

        for (Tree<E> child : tree.children) {
            traverseTreeWithRecurrence(builder, indent + 2, child);
        }
    }

    private String getPadding(int size) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < size; i++) {
            builder.append(" ");
        }

        return builder.toString();
    }

    private void findLeafKeys(Tree<E> tree, List<E> order) {
        for (Tree<E> child : tree.children) {

            if (child.children.size() == 0) {
                order.add(child.key);
            }
            this.findLeafKeys(child, order);
        }
    }

    private void findMiddleNodes(Tree<E> tree, List<E> middleKeys) {

        for (Tree<E> child : tree.children) {
            if (child.parent != null && child.children.size() > 0) {
                middleKeys.add(child.key);
            }
            findMiddleNodes(child, middleKeys);
        }
    }
}



