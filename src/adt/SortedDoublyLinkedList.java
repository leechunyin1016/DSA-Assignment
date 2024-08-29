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
    public void add(T object) {
        Node<T> newNode = new Node<>(object);

        // If the list is empty, initialize head and tail
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            Node<T> current = head;

            // Find the correct insertion point
            while (current != null && current.data.compareTo(object) <= 0) { // Changed '<' to '<='
                current = current.next;
            }

            // If current is null, object should be the new tail
            if (current == null) {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            } // If current is head, object should be the new head
            else if (current == head) {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            } // Insert in the middle
            else {
                newNode.prev = current.prev;
                newNode.next = current;
                current.prev.next = newNode;
                current.prev = newNode;
            }
        }

        size++;
    }

    // Edit the data of an existing node
    @Override
    public void edit(T target, T newValue) {
        Node<T> current = head;
        while (current != null && !current.data.equals(target)) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("The target donor is not found in the list.");
            return;
        }

        // Update the data of the current node
        current.data = newValue;

        // To maintain order in a sorted list, we need to remove and re-add the node
        // if the order might have changed
        if (current.prev != null && current.prev.data.compareTo(newValue) > 0) {
            // Node might have changed its position
            if (current.prev != null) {
                current.prev.next = current.next;
            } else {
                head = current.next;
            }

            if (current.next != null) {
                current.next.prev = current.prev;
            } else {
                tail = current.prev;
            }

            size--;
            add(newValue);
        }
    }

    @Override
    public void remove(T object) {
        if (head == null || object == null) {
            return;
        }

        Node<T> current = head;

        // Find the node to remove
        while (current != null && !current.data.equals(object)) { // Uses equals() method to compare
            current = current.next;
        }

        // If the node was not found
        if (current == null) {
            return;
        }

        // If it's the head node
        if (current == head) {
            head = current.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null;
            }
        } // If it's the tail node
        else if (current == tail) {
            tail = current.prev;
            if (tail != null) {
                tail.next = null;
            }
        } // If it's a middle node
        else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }

        size--;
    }

    @Override
    public boolean contain(T object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public T find(T object) {
        Node<T> current = head;

        while (current != null) {
            if (current.data.equals(object)) { // Uses equals() method to compare
                return current.data;
            }
            current = current.next;
        }

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

    @Override
    public T getEntry(int position) {
        // Check if position is valid
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException("Position out of bounds");
        }

        Node<T> current = head;
        int index = 0;

        // Traverse the list to the specified position
        while (index < position) {
            current = current.next;
            index++;
        }

        // Return the data of the node at the specified position
        return current.data;
    }

}
