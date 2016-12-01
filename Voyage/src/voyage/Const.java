package voyage;

import Graphs.Graph;
import java.util.Objects;

public class Const {
    private Graph Stars = new Graph();
    private String Name;
    public Const(String name) {
        this.Name = name;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.Stars);
        hash = 79 * hash + Objects.hashCode(this.Name);
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
        final Const other = (Const) obj;
        if (!Objects.equals(this.Name, other.Name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Const{" + "Name=" + Name + '}';
    }
    
    
}
