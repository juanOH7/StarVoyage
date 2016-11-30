package List;

public class Stack extends LinkedList {

    public Stack() {
        super();
    }

    public void Push(Object x) {
        insert(x, 0);
    }

    public Object Pop() {
        if (size == 0) {
            return null;
        }
        if (size == 1) {
            Node tm = head;
            head = null;
            size--;
            return tm.getVal();
        }
        Node tmp = head;
        head = head.getNext();
        size--;
        return tmp.getVal();
    }

    public Object Peek() {
        return head.getVal();
    }
}
