package ru.makhov.graph;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Node<T> {

    private Long id;
    private final T value;
    private final Set<Node<T>> nodes = new HashSet<>();

    public Node(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public Set<Node<T>> getNodes() {
        return nodes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Node<?> node)) {
            return false;
        }
        return Objects.equals(getId(), node.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}