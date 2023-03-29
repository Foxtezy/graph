package ru.makhov.graph;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GraphTest {

    Graph<String> graph;

    List<Node<String>> nodeList;

    @BeforeEach
    void setup() {
        graph = new Graph<>();
        nodeList = List.of(new Node<>("0"), new Node<>("1"), new Node<>("2"),
            new Node<>("3"), new Node<>("4"));
        nodeList.forEach(graph::addNode);
    }

    @Test
    void cyclicGraphTest() {
        graph.addEdge(nodeList.get(0), nodeList.get(1));
        graph.addEdge(nodeList.get(1), nodeList.get(2));
        graph.addEdge(nodeList.get(2), nodeList.get(0));
        graph.addEdge(nodeList.get(2), nodeList.get(4));
        graph.addEdge(nodeList.get(0), nodeList.get(3));
        Assertions.assertTrue(graph.isCyclic());
    }

    @Test
    void nonCyclicGraphTest() {
        graph.addEdge(nodeList.get(0), nodeList.get(1));
        graph.addEdge(nodeList.get(1), nodeList.get(2));
        graph.addEdge(nodeList.get(0), nodeList.get(2));
        graph.addEdge(nodeList.get(2), nodeList.get(4));
        graph.addEdge(nodeList.get(0), nodeList.get(3));
        Assertions.assertFalse(graph.isCyclic());
    }

    @Test
    void cyclicNotConnectedGraphTest() {
        graph.addEdge(nodeList.get(0), nodeList.get(1));
        graph.addEdge(nodeList.get(1), nodeList.get(2));
        graph.addEdge(nodeList.get(2), nodeList.get(4));
        graph.addEdge(nodeList.get(4), nodeList.get(1));
        Assertions.assertTrue(graph.isCyclic());
    }

    @Test
    void emptyGraphTest() {
        Graph<String> g = new Graph<>();
        Assertions.assertFalse(g.isCyclic());
    }
}
