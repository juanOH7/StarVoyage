package Graphs;

import List.LinkedList;

public class Graph<T> {

    private LinkedList<Vertex<T>> Vertices = new LinkedList();

    public boolean addV(T val) {
        Vertex<T> temp = new Vertex(val);
        if (!Vertices.contains(temp)) {
            Vertices.add(val);
            return true;
        }
        return false;
    }

    public boolean addV(Vertex val) {
        if (!Vertices.contains(val)) {
            Vertices.add(val);
            return true;
        }
        return false;
    }

    public T get_Val_at(int pos) {
        return (T) Vertices.get(pos).retVal();
    }

    public Vertex first(Vertex val) {
        if (Vertices.contains(val)) {
            int index = Vertices.find(val);
            return Vertices.get(index).getAdjacents().get(0).val();
        }
        return null;
    }

    public Vertex next(Vertex val, int i) {
        if (Vertices.contains(val)) {
            int index = Vertices.find(val);
            return Vertices.get(index).getAdjacents().get(i + 1).val();
        }
        return null;
    }

    public Vertex vertex(Vertex val, int i) {
        if (Vertices.contains(val)) {
            int index = Vertices.find(val);
            return Vertices.get(index).getAdjacents().get(i).val();
        }
        return null;
    }

    public Vertex getVer(int pos) {
        return Vertices.get(pos);
    }

    public boolean addEdge(Vertex<T> A, Vertex<T> B, int weight) {
        if (Vertices.contains(B) && Vertices.contains(A)) {
            if (B.hasAdj(A)) {
                return false;
            }
            A.addEdge(B, weight);
            B.addEdge(A, weight);
            return true;
        }
        if (Vertices.contains(B) && !Vertices.contains(A)) {
            Vertices.add(A);
            A.addEdge(B, weight);
            B.addEdge(A, weight);
            return true;
        }
        if (!Vertices.contains(B) && Vertices.contains(A)) {
            Vertices.add(B);
            A.addEdge(B, weight);
            B.addEdge(A, weight);
            return true;
        }
        if (!Vertices.contains(B) && !Vertices.contains(A)) {
            Vertices.add(A);
            Vertices.add(B);
            A.addEdge(B, weight);
            B.addEdge(A, weight);
            return true;
        }
        return false;
    }

    public int getSize() {
        return Vertices.getSize();
    }

    public String print(int pos) {
        return getVer(pos).toString() + "-" + getVer(pos).getAdjacents();
    }

    public boolean addEdge(Vertex<T> A, Vertex<T> B) {
        if (Vertices.contains(B) && Vertices.contains(A)) {
            if (B.hasAdj(A)) {
                return false;
            }
            A.addEdge(B, 1);
            B.addEdge(A, 1);
            return true;
        }
        if (Vertices.contains(B) && !Vertices.contains(A)) {
            Vertices.add(A);
            A.addEdge(B, 1);
            B.addEdge(A, 1);
            return true;
        }
        if (!Vertices.contains(B) && Vertices.contains(A)) {
            Vertices.add(B);
            A.addEdge(B, 1);
            B.addEdge(A, 1);
            return true;
        }
        if (!Vertices.contains(B) && !Vertices.contains(A)) {
            Vertices.add(A);
            Vertices.add(B);
            A.addEdge(B, 1);
            B.addEdge(A, 1);
            return true;
        }
        return false;
    }

    public boolean contains(T val) {
        return Vertices.contains(new Vertex<>(val));
    }

    public LinkedList getVertices() {
        return Vertices;
    }

}
