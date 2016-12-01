/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package List;

/**
 *
 * @author Juan O'Hara
 */
public abstract class List<T> {

    protected Node head;
    protected int size;
    protected Node tail;

    public List() {
        this.head = null;
        this.size = 0;
        this.tail = null;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    abstract public void add(T val);

    abstract public T get(int pos);

    abstract public void insert(T val, int pos);

    abstract public void delete(int pos);
}
