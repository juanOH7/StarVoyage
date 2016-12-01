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
        df.addV(new Const("d"));
        System.out.println(df.getVertex(0));
        Const d = df.getVertex(0);
        System.out.println(d);
    }
    
}
