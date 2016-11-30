package Graphs;

import voyage.Const;

public class Adjacents {
    private Const Val;
    private int weight;

    public Adjacents(Const Val, int weight) {
        this.Val = Val;
        this.weight = weight;
    }

    public Adjacents(Const Val) {
        this.Val = Val;
        this.weight = 1;
    }
    
    public Const val() {
        return Val;
    }

    public int weight() {
        return weight;
    }
    
    public void set(Const Val) {
        this.Val = Val;
    }

    public void setW(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return  " " + Val + ", " + weight + " ";
    }
    
        
}
