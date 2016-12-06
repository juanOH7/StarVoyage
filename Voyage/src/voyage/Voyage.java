package voyage;

import Graphs.Graph;
import Graphs.Vertex;
import List.LinkedList;

public class Voyage {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Graph<Const> df = new Graph();
        Vertex<Const> a = new Vertex<>(new Const("a")), b = new Vertex<>(new Const("b")), c = new Vertex<>(new Const("c"));
        Vertex<Const> d = new Vertex<>(new Const("d")), e = new Vertex<>(new Const("e")), f = new Vertex<>(new Const("f"));
        a.retVal().addStar(new Star("ta"));
        a.retVal().addStar(new Star("tad"));
        a.retVal().addStar(new Star("tafd"));
        a.retVal().addStar(new Star("tasd"));
        System.out.println(df.addEdge(b, c, 4));
        System.out.println(df.addEdge(a, c, 3));
        System.out.println(df.addEdge(b, a, 6));
        df.addV(d);
        df.addEdge(a, d, 4);
        df.addEdge(d, b, 1);
        df.addV(e);
        df.addV(f);
        System.out.println(df.getVertices());
        for (int i = 0; i < df.getSize(); i++) {
            System.out.println(df.print(i));
        }
        Simulation s = new Simulation();
        s.setVisible(true);
        df.Prim();

        System.out.println("Dijkstra " +df.Dijkstra(b, a));
}
    


}
