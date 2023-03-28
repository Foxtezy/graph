package ru.makhov.graph;

import java.util.ArrayList;
import java.util.Collection;

public class Graph<T> {

    private Collection<Node<T>> nodes = new ArrayList<>();


    private boolean coloring(Node<T> rootNode) {
        if (rootNode.getColor() == 1) {
            return false;
        }
        rootNode.setColor(1);
        for (Node<T> node : rootNode.getNodes()) {
            if (coloring(node) == false) {
                return false;
            }
        }
        return true;
    }

    public boolean isCycle() {
        for (Node<T> node : nodes) {
            if (node.getColor() == 1) {
                continue;
            }
            if (coloring(node) == false) {
                return false;
            }
        }
        return false;
    }

}
