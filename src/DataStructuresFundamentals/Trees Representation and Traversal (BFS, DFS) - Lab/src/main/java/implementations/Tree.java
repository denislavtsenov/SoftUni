package implementations;

import interfaces.AbstractTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Tree<E> implements AbstractTree<E> {

    private E key;
    private Tree<E> parent;
    private List<Tree<E>> children;


    public Tree(E key, Tree<E>... children) {
        this.key = key;
        this.parent = null;
        this.children = new ArrayList<>();

        for (Tree<E> child : children) {
            this.children.add(child);
            child.parent = this;
        }
    }

    @Override
    public List<E> orderBfs() {
        List<E> result = new ArrayList<>();

        if (this.key == null) {
            return result;
        }

        Deque<Tree<E>> queue = new ArrayDeque<>();
        queue.offer(this);

        while (queue.size() > 0) {
            Tree<E> current = queue.poll();
            result.add(current.key);

            for (Tree<E> child : current.children) {
                queue.offer(child);
            }
        }
        return result;
    }

    @Override
    public List<E> orderDfs() {

        List<E> order = new ArrayList<>();

        this.dfs(this, order);
        return order;
    }

    private void dfs(Tree<E> tree, List<E> order) {
        for (Tree<E> child : tree.children) {
            this.dfs(child, order);
        }

        order.add(tree.key);
    }

    @Override
    public void addChild(E parentKey, Tree<E> child) {
        Deque<Tree<E>> queue = new ArrayDeque<>();
        queue.offer(this);

        while (queue.size() > 0) {
            Tree<E> current = queue.poll();

            for (Tree<E> c : current.children) {
                if (c.key.equals(parentKey)) {
                    c.children.add(child);
                    return;
                }
                queue.offer(c);
            }
        }
    }

    @Override
    public void removeNode(E nodeKey) {
        Tree<E> toRemove = findBfs(nodeKey);

        if (toRemove == null) {
            throw new IllegalArgumentException();
        }

        for (Tree<E> child : toRemove.children) {
            child.parent = null;
        }
        toRemove.children.clear();

        Tree<E> parent = toRemove.parent;

        if (parent != null) {
            parent.children.remove(toRemove);
        }

        toRemove.key = null;
    }

    private Tree<E> findBfs(E nodeKey) {
        Deque<Tree<E>> childrenQueue = new ArrayDeque<>();
        childrenQueue.offer(this);

        while (!childrenQueue.isEmpty()) {
            Tree<E> current = childrenQueue.poll();

            if (current.key.equals(nodeKey)) {
                return current;
            }

            for (Tree<E> child : current.children) {
                childrenQueue.offer(child);
            }
        }
        return null;
    }

    @Override
    public void swap(E firstKey, E secondKey) {

    }
}



