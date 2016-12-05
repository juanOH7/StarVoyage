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
        a.retVal().addStar(new Star("ta"));
        a.retVal().addStar(new Star("tad"));
        a.retVal().addStar(new Star("tafd"));
        a.retVal().addStar(new Star("tasd"));
        System.out.println(df.addEdge(b, c, 4));
        System.out.println(df.addEdge(a, c));
        System.out.println(df.addEdge(b, a, 3));

        System.out.println(df.getVertices());
        for (int i = 0; i < df.getSize(); i++) {
            System.out.println(df.print(i));
        }
        System.out.println(df.get_Val_at(2).getStars());
        System.out.println(((Const)(df.getVer(2).retVal())).getStars());
        Const d = df.get_Val_at(0);
        System.out.println(a.equals(df.getVer(0)));
    }

}
