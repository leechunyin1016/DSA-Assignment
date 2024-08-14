/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import adt.SortedDoublyLinkedList;
import entity.Donor;

/**
 *
 * @author LEE CHUN YIN
 */
public class DonorControl {
    private SortedDoublyLinkedList<Donor> donorList;
    
    public DonorControl(){
        donorList = new SortedDoublyLinkedList<>();
    }
    
    public void addDonor(Donor donor){
        donorList.add(donor);
    }
    
    public void listAllDonors(){
        donorList.display();
    }
    
    public int donorSize(){
        return donorList.size();
    }
    
    public void clearDonor(){
        donorList.clear();
    }
    
}
