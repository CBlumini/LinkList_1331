package com.LinkedList;

import com.List.List;
import com.Node.Node;

import java.util.NoSuchElementException;

//https://stackoverflow.com/questions/15442508/interface-and-a-class-name-clash-same-erasure-yet-neither-overrides-other
//needed the above to avoid an erasure error
public class LinkedList<T> implements List<T> {


    private Node<T> head;
    private Node<T> tail;
    private int size;

    public LinkedList(){
        head = null;
        tail = null;
    }

    //https://farenda.com/algorithms/linked-list-insert-element-at-position/
    @Override
    public void addAtIndex(T data, int index) {
        if (index < 0 || index>size) {
            throw new IllegalArgumentException("You cannot add null data to the list");
        }

        //if the first element in the list
        if (size == 0) {
            head = new Node<T>(data);
            tail = head;
        }

        if (index == 0 && size > 0) {
            //add to the front once the first node is created
            head = new Node <T> (data, head);

        } else if (size > 0 && index != size) {
            //add to other locations
            //create a temporary node that equals the head
            Node<T> temp = head;
            //cycle through the list to get to the location
            //check this for fencepost errors
            while (--index>0) {
                temp = temp.getNext();
            }
            //add the data that was passed in to a newNode
            Node<T> newNode = new Node <T> (data);
            //point the new node to the value that the lookup node was pointing to
            newNode.setNext(temp.getNext());
            //set the pointer (the upstream part of the list to look at the new node
            temp.setNext(newNode);
            //if adding at the end (tail)
        } else if (index == size && size !=0){
            //create a new node for the data
            Node<T> newNode = new Node <T> (data);
            //point the existing tail to the new node
            tail.setNext(newNode);
            //set the new node as the tail
            tail = newNode;
        }

        //increment the size
        size++;

    }

    @Override
    public T getAtIndex(int index) {
        if (index < 0 || index > size-1) {
            throw new IllegalArgumentException("Your index is out of the list bounds");
        }

        //create a temporary node at the head
        Node<T> temp = head;

        //cycle through the list to get to the location
        //check this for fencepost errors
        while (--index>0) {
            temp = temp.getNext();
        }

        return temp.getData();
    }


//https://www.geeksforgeeks.org/delete-a-linked-list-node-at-a-given-position/?ref=lbp
    @Override
    public T removeAtIndex(int index) {
        if (index < 0 || index > size-1) {
            throw new IllegalArgumentException("Your index is out of bounds");
        }

        //create a temp node
        Node<T> temp = head;
        //if the requested node is the head
        if (index == 0) {
            T removedData = head.getData();
            head = head.getNext();
            size--;
            //set the tail to null if the list reaches size 0 after a remove operation
            if (size == 0) {
                tail = null;
            }
            return removedData;
        }

        //if the requested node isn't the head
        //cycle through the nodes
        for (int i = 0; i < index-1; i++) {
            temp = temp.getNext();
        }
        //creat another temp node
        Node<T> tempTemp = temp;
        //check for null data
        if (temp == null || temp.getNext() == null) {
            return null;
        }

        Node<T> next = temp.getNext().getNext();
        temp.setNext(next);
        size--;
        return tempTemp.getData();
    }

    @Override
    public T remove(T data) {
        if (data == null) {
            throw new IllegalArgumentException("You cannot remove null data from the list");
        }
        Node<T> temp = head;
        Node<T> prev = null;

        if (temp != null && temp.getData() == data) {
            prev = temp;
            temp = temp.getNext();
        }
        size--;
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
