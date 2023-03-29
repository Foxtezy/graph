package ru.makhov.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph<T> {

    private final Set<Node<T>> nodes = new HashSet<>();

    private Long nextNodeId = 1L;

    public Long addNode(Node<T> newNode) {
        newNode.setId(nextNodeId);
        nodes.add(newNode);
        return nextNodeId++;
    }

    public boolean addEdge(Node<T> src, Node<T> dst) {
        if (!nodes.contains(src) || !nodes.contains(dst)) {
            return false;
        }
        src.getNodes().add(dst);
        return true;
    }


    private boolean bfsCycleSearch(Map<Long, Color> colorMap, Node<T> currNode) {
        if (colorMap.get(currNode.getId()) == Color.GRAY) {
            return true;
        }
        colorMap.replace(currNode.getId(), Color.GRAY);
        for (Node<T> nextNode : currNode.getNodes()) {
            if (bfsCycleSearch(colorMap, nextNode)) {
                return true;
            }
        }
        colorMap.replace(currNode.getId(), Color.BLACK);
        return false;
    }

    public boolean isCyclic() {
        Map<Long, Color> colorMap = new HashMap<>();
        nodes.forEach(n -> colorMap.put(n.getId(), Color.WHITE));
        for (Node<T> node : nodes) {
            if (colorMap.get(node.getId()) == Color.WHITE && bfsCycleSearch(colorMap, node)) {
                return true;
            }
        }
        return false;
    }
}