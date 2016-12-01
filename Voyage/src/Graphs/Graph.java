package Graphs;

import List.LinkedList;

public class Graph<T> {
    private LinkedList<Vertex<T>> Vertices = new LinkedList();

    public void addV(T val){
        Vertex<T> temp = new Vertex(val);
        Vertices.add(temp);
    }
    
    public T getVertex(int d){
        return (T) Vertices.get(0).retVal();
    }
    
    public void addEdge(Vertex<T> A, Vertex<T> B, int weight){
        
    }
}
