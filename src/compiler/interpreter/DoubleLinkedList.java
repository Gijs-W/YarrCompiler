/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler.interpreter;

/**
 *
 * @author Gijs
 */
class Node<Y> {
    Node prev;
    Node next;
    Y data;

    public Node(Y d) {
        data = d;
        prev = null;
        next = null;
    }
}

class DoubleLinkedList<T> {
    private Node head;
    private int size;

    public DoubleLinkedList() {
        head = new Node<T>(null);
    }

    public void insert(T d) {
        Node current = head;
    
        while (current.next != null) {
            current = current.next;
        }
        
        Node<T> newNode = new Node(d);
        newNode.prev = current;
        size++;
    }
    
    public void insertBefore(T d, int position) {
        Node current = head;
        for (int i = 1; i < size && head.next != null; i++) {
            current = head.next;
        }
        
        Node<T> newNode = new Node(d);
        newNode.next = current;
        current.prev.next = newNode;
        current.prev = newNode;
        
        size++;
    }

    public void delete(int index) {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }

        Node<T> current = head;
        for (int i = 1; i < index; i++) {
            
            if (current.next != null) {
                throw new RuntimeException("Invalid index");
            }
        
            current = current.next;
            current.prev = current.next;
        }
    }
    
    public T get(int index) {
        Node<T> current = head;
        for (int i = 1; i < index; i++) {
            
            if (current.next != null) {
                throw new RuntimeException("Invalid index");
            }
        
            current = current.next;
            

        }
        return current.data;
    }
}