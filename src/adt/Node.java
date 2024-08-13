/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adt;

/**
 *
 * @author LEE CHUN YIN
 */
public class Node<T> {
    T data;
    Node<T> prev;
    Node<T> next;
    
    public Node(T data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
