/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import adt.*;
import entity.Donee;


/**
 *
 * @author Dephnie
 */
public class DoneeControl {
    
private SortedDoublyLinkedList<Donee> doneeList;

    public DoneeControl() {
        doneeList = new SortedDoublyLinkedList<>();
    }

    public void addDonee(Donee donee) {
        doneeList.add(donee);
    }
    
    public void removeDonee(Donee donee) {
        doneeList.remove(donee);
    }
    
    public void updateDonee(Donee donee) {
        //doneeList.update(donee);
    }

    public void searchDonee(Donee donee) {
        //doneeList.search(donee);
    }
    public void listAllDonee() {
        doneeList.display();
    }

    public void filterDonee(Donee donee) {
        //doneeList.filter(donee);
    }
    
    public void generateDoneeReport(Donee donee) {
        //doneeList.generateDoneeReport(donee);
    }
    
    public int doneeSize() {
        return doneeList.size();
    }

    public void clearDonee() {
        doneeList.clear();
    }
}
