/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dsa.assignment;
import adt.SortedDoublyLinkedList;
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
        SortedDoublyLinkedList<Donor> mainDonorList = new SortedDoublyLinkedList<>(); 
        
        Donor donor = new Donor();
        donor.setDonorName("Lee");
        mainDonorList.add(donor);
        
        Donor donor2=new Donor();
        
        donor2.setDonorName("Mu");
        mainDonorList.add(donor2);

        mainDonorList.display();
        System.out.println("size = "+mainDonorList.size());

        Donor donor1 = new Donor();
        donor1.setDonorId("D0000");
        donor1.setDonorName("Leessss");
        // Edit the list by replacing donor1 with donor2
        mainDonorList.edit(donor2,donor1);
        mainDonorList.display();
                System.out.println("size = "+mainDonorList.size());

        
    }
    
}
