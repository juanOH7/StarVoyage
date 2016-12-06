package Graphs;

import List.LinkedList;
import voyage.Const;

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

    public LinkedList Dijkstra(Vertex A, Vertex B) {
        int Origin = Vertices.find(A);
        int Target = Vertices.find(B);
        int[] D = new int[Vertices.getSize()];
        boolean[] visitado = new boolean[Vertices.getSize()];
        LinkedList<Vertex<T>> S = new LinkedList<>();
        LinkedList<Vertex<T>> O = new LinkedList<>();
        LinkedList<Adjacents<T>> Camino = new LinkedList<>();

        for (int i = 0; i < Vertices.getSize(); i++) {
            if (Vertices.get(i) != A) {
                O.add(Vertices.get(i));
            }
        }
        S.add(A);
        D[Origin] = 0;
        visitado[Origin] = true;
        int pos;
        //init distancias
        for (int i = 0; i < Vertices.getSize(); i++) {
            for (int j = 0; j < A.getAdjacents().getSize(); j++) {
                if (Vertices.get(i) == A.retAdjVertex(j)) {
                    pos = Vertices.find(A.retAdjVertex(j));
                    D[pos] = A.getWeight(j);
                    visitado[pos] = false;
                }
                if (!A.hasAdj(Vertices.get(i)) && i != Origin) {
                    D[i] = 9999;
                    visitado[i] = false;
                }
            }
        }
        for (int i = 0; i < D.length; i++) {
            System.out.print(visitado[i] + ",");
        }
        System.out.println("");
        System.out.println("--------------");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {

            }
        }
        System.out.println(Vertices);
        for (int i = 0; i < D.length; i++) {
            System.out.print(D[i] + ",");
        }
        System.out.println("");
        System.out.println("-----------");
        Camino.add(new Adjacents<>(Vertices.get(Origin), D[Origin]));
        for (int i = 0; i < D.length - 1; i++) {
            pos = min(D, visitado);
            System.out.println("pos: " + pos);
            int tem = O.find(Vertices.get(pos));
            S.add(O.get(tem));
            O.delete(tem);
            System.out.println("S-" + S);
            System.out.println("O-" + O);
            for (int j = 0; j < O.getSize(); j++) {
                System.out.println("D[POS]" + D[pos]);
                System.out.println("Costo: " + costo(Vertices.get(pos), Vertices.get(j)));
                System.out.println("Suma" + (D[pos] + costo(Vertices.get(pos), Vertices.get(j))));
                int temp = D[j];
                D[j] = min(D[j], D[pos] + costo(Vertices.get(pos), Vertices.get(j)));
                if (j == Target && D[j] < temp) {
                    Camino.add(new Adjacents<>(Vertices.get(pos), D[j]));
                }
            }
        }
        int tempd = B.posAdj(A);
        Camino.add(new Adjacents<>(Vertices.get(Target), B.getWeight(tempd)));
        System.out.println("-----");
        for (int i = 0; i < D.length; i++) {
            System.out.print(visitado[i] + ",");
        }
        System.out.println("");
        System.out.println("--------------");
        System.out.println("Dista");
        for (int i = 0; i < D.length; i++) {
            System.out.println(D[i]);
        }
        System.out.println("-----");
        System.out.println("Camino");
        System.out.println(Camino);
        System.out.println("-----");
        for (int i = 0; i < D.length; i++) {
            System.out.println(costo(A, Vertices.get(i)));
        }
        return Camino;
    }

    public int min(int[] distance, boolean[] visit) {
        int min = Integer.MAX_VALUE;
        int pos = -1;
        for (int i = 0; i < distance.length; i++) {
            if (!visit[i]) {
                if (distance[i] <= min) {
                    min = distance[i];
                    pos = i;
                }
            }
            if (i == distance.length - 1 && pos >= 0) {
                visit[pos] = true;
            }
        }
        return pos;
    }

    public int min(int current, int tentative) {
        System.out.println("current : " + current);
        System.out.println("tentative : " + tentative);

        if (tentative < current) {
            System.out.println("Tenta");
            return tentative;
        }
        System.out.println("Current" + current);
        return current;
    }

    public int costo(Vertex Beginning, Vertex End) {
        if (Beginning.hasAdj(End)) {
            int pos = Beginning.posAdj(End);
            return Beginning.getWeight(pos);
        }
        return 9999;
    }
}
