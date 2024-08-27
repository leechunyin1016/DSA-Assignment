/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dsa.assignment;

import adt.SortedDoublyLinkedList;
import adt.SortedDoublyLinkedListInterface;
import entity.Donor;

/**
 *
 * @author LEE CHUN YIN
 */
public class DSAAssignment {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SortedDoublyLinkedListInterface<Donor> mainDonorList = new SortedDoublyLinkedList<>();

        Donor donor = new Donor();
        donor.setDonorName("Lee");
        mainDonorList.add(donor);
        mainDonorList.display();
        System.out.println("size = " + mainDonorList.size());
        mainDonorList.clear();
        mainDonorList.display();
        System.out.println("size = " + mainDonorList.size());
    }

}
