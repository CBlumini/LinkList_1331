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

    //https://farenda.com/algorithms/linked-list-insert-element-at-position/
    @Override
    public void addAtIndex(Object data, int index) {
        if (index < 0 || index<size-1) {
            throw new IllegalArgumentException();
        }

        //add to the front
        if (index ==0) {
            head = new Node <T> ((T) data, head);
            size++;
            /*
            Node<T> newNode = new Node <> ((T) data);
            newNode.setNext(head);
            head = newNode;
            */
        } else {
            Node<T> temp = head;
            while (--index>0) {
                temp = temp.getNext();
            }
            Node<T> newNode = new Node <T> ((T)data);
            newNode.setNext(temp.getNext());
            temp.setNext(newNode);
            size++;
            //newNode.setNext(head);
            //head = newNode;
        }

    }

    @Override
    public Object getAtIndex(int index) {
        Node<T> temp = head;
        int count = 0;
        if (index < 0 || index<size-1) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < index-1; i++) {
            temp = temp.getNext();
        }
        return temp.getData();

        /*while (temp != null) {
            if (count == index) {
                return temp.getData();
                }
                count++;
                temp = temp.getNext();
            }


        assert(false);
        return 0;
        */
    }


//https://www.geeksforgeeks.org/delete-a-linked-list-node-at-a-given-position/?ref=lbp
    @Override
    public Object removeAtIndex(int index) {
        Node<T> temp = head;
        if (index == 0) {
            T removedData = head.getData();
            head = head.getNext();
            return removedData;
        }
        for (int i = 0; i < index-1; i++) {
            temp = temp.getNext();
        }
        Node<T> tempTemp = temp;
        if (temp == null || temp.getNext() == null) {
            return null;
        }
        Node<T> next = temp.getNext().getNext();
        temp.setNext(next);
        size--;
        return tempTemp.getData();
    }

    @Override
    public Object remove(Object data) {
        Node<T> temp = head;
        Node<T> prev = null;

        if (temp != null && temp.getData() == data) {
            prev = temp;
            temp = temp.getNext();
        }

        return null;
    }

    @Override
    public void clear() {
        head = null;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public int size() {
        return size;
    }


    //getters
    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
    }

}
