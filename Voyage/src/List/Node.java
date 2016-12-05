package List;

import java.util.Objects;

public class Node <T> {
    private T val;
    private Node next;

    public Node(T val) {
        this.val = val;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.val);
        hash = 47 * hash + Objects.hashCode(this.next);
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
        final Node<?> other = (Node<?>) obj;
        if (!Objects.equals(this.val, other.val)) {
            return false;
        }
        return true;
    }
    
    
    
    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" + "val=" + val + '}';
    }
    
    
}
