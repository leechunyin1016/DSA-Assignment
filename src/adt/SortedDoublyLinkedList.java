/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adt;

/**
 *
 * @author LEE CHUN YIN
 */
public class SortedDoublyLinkedList<T extends Comparable<T>> implements SortedDoublyLinkedListInterface<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    //initial the default value once create
    public SortedDoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    //add object to collection
    public void add(T object) {

        Node<T> newNode = new Node<>(object);

        //if head = null, that mean the collection is empty
        if (head == null) {

            head = newNode;
            tail = newNode;

        } else {

            Node<T> current = head;

            //because it is sorted so need to spot the correct place to add Node
            while (current != null && current.data.compareTo(object) < 0) {
                current = current.next;
            }

            //if current = null, that mean the data is bigger than everyone, so add to tail
            if (current == null) {

                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;

            } //if current = head, that mean the data is smaller than everyone, so add to head
            else if (current == head) {

                newNode.next = head;
                head.prev = newNode;
                head = newNode;

            } //Node add in middle
            else {

                newNode.prev = current.prev;
                newNode.next = current;
                current.prev.next = newNode;
                current.prev = newNode;

            }

        }
        
        size++;

    }

    @Override
    public void edit(T object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void remove(T object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean contain(T object) {
        Node<T> current = head;
        
        //if current != null, that mean the while loop havent reach to the end
        while (current != null) {
            //if compare To = 0, mean found the target 
            if (current.data.compareTo(object) == 0) {
                return true;
            }
            
            //if already past the target search location, return false due
            else if (current.data.compareTo(object) > 0) {
                return false;
            }
            
            //if not found then continue next
            current = current.next;
        }

        //if not found then return null
        return false;
    }

    @Override
    //find the object inside the collection and return the object
    public T find(T object) {

        Node<T> current = head;

        //if current != null, that mean the while loop havent reach to the end
        while (current != null) {
            //if compare To = 0, mean found the target 
            if (current.data.compareTo(object) == 0) {
                return current.data;
            }
            //if not found then continue next
            current = current.next;
        }

        //if not found then return null
        return null;

    }

    @Override
    //cincai display
    public void display() {

        Node<T> current = head;

        //if current != null, that mean the while loop havent reach to the end
        while (current != null) {
            //cincai display it out only
            System.out.println(current.data);
            current = current.next;
        }

    }

    @Override
    //clear the collection
    public void clear() {

        //disconnect head and tail pointer, and change the size to 0
        head = null;
        tail = null;
        size = 0;

    }

    @Override
    //return the size value
    public int size() {

        return size;

    }

    @Override
    //check the collection empty or not
    public boolean isEmpty() {

        //return true false base on the if size = 0
        return size == 0;

    }

    @Override
    public void filter(String sortTarget, boolean asc) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void generateReport() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
