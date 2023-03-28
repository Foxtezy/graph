package ru.makhov.graph;

import java.util.List;

public class Node<T> {
    private T value;
    private List<Node<T>> nodes;

    int color;

    public List<Node<T>> getNodes() {
        return nodes;
    }

    int getColor() {
        return color;
    }

    void setColor(int color) {
        this.color = color;
    }
}
