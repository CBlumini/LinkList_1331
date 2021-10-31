package com.LinkedList;

import com.List.List;
import com.Node.Node;

public class LinkedList<T> implements List {


    private Node<T> head;
    private Node<T> tail;
    private int size;

    public LinkedList(){
        head = null;
        tail = null;
    }

    @Override
    public void addAtIndex(Object data, int index) {

    }

    @Override
    public Object getAtIndex(int index) {
        return null;
    }

    @Override
    public Object removeAtIndex(int index) {
        return null;
    }

    @Override
    public Object remove(Object data) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }
}
