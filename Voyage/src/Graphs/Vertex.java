package Graphs;

import List.LinkedList;
import java.util.Objects;

public class Vertex<T> {

    private LinkedList<Adjacents<Vertex<T>>> adjacents = new LinkedList();
    private T value;

    public Vertex(T value) {
        this.value = value;
    }

    public LinkedList<Adjacents<Vertex<T>>> getAdjacents() {
        return adjacents;
    }

    
    
    public void addEdge(Vertex val, int weight) {
        adjacents.add(new Adjacents<>(val, weight));
    }

    public T retVal() {
        return value;
    }

    public boolean hasAdj(Vertex val) {
        if (adjacents.isEmpty()) {
            return false;
        }
        return adjacents.contains(new Adjacents<>(val));
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.adjacents);
        hash = 11 * hash + Objects.hashCode(this.value);
        return hash;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vertex other = (Vertex) obj;
        if (!Objects.equals(this.value, other.value)) {
            return false;
        }
        return true;
    }

}
