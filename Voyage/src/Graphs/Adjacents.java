package Graphs;

import java.util.Objects;

public class Adjacents <T> {
    private T Val;
    private int weight;

    public Adjacents(T Val, int weight) {
        this.Val = Val;
        this.weight = weight;
    }

    public Adjacents(T Val) {
        this.Val = Val;
        this.weight = 1;
    }
    
    public T val() {
        return Val;
    }

    public int weight() {
        return weight;
    }
    
    public void set(T Val) {
        this.Val = Val;
    }

    public void setW(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return  " " + Val + ", " + weight + " ";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.Val);
        hash = 97 * hash + this.weight;
        return hash;
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
        final Adjacents other = (Adjacents) obj;
        if (!Objects.equals(this.Val, other.Val)) {
            return false;
        }
        return true;
    }
    
    
}
