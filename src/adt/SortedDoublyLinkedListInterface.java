/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package adt;

/**
 *
 * @author LEE CHUN YIN
 */
public interface SortedDoublyLinkedListInterface<T> {

    public void add(T object);

    public void edit(T target, T newValue);

    public void remove(T object);

    public boolean contain(T object);

    public T find(T object);

    public void display();

    public void clear();

    public int size();

    public boolean isEmpty();

    public void filter(String sortTarget, boolean asc);

    public void generateReport();

}
