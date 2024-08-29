/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;

import adt.SortedDoublyLinkedList;
import adt.SortedDoublyLinkedListInterface;
import entity.Donation;
import java.util.Scanner;
import control.DonationControl;

/**
 *
 * @author junyi
 */
public class DonationUI {

    Scanner scanner = new Scanner(System.in);
    SortedDoublyLinkedListInterface<Donation> donationList = new SortedDoublyLinkedList<>();

    public int donationMenu() {
        System.out.println("Donation Main Menu");
        System.out.println("1. Add Donation");
        System.out.println("2. Remove Donation");
        System.out.println("3. Amend Donation");
        System.out.println("4. Search Donation");
        System.out.println("5. Track Donated Item");
        System.out.println("6. Donation List");
        System.out.print("Pls Enter Your Choice (1-6) : ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        return choice;

    }

    public String inputDonationId() {
        DonationControl dc = new DonationControl();
        String donationId = "D" + dc.getRandomNumber();
        System.out.print("Donation ID: " + donationId + "\n");
        return donationId;
    }

    public String inputDonationItemName() {
        System.out.print("Donation Item Name :");
        String donationItemName = scanner.next();
        scanner.nextLine();
        return donationItemName;

    }

    public int inputDonationItemQty() {
        System.out.print("Donation Item Quantity :");
        int donationItemQty = scanner.nextInt();
        scanner.nextLine();
        return donationItemQty;

    }

    public String inputDonationDonorName() {
        System.out.print("Donor Name :");
        String donationItemDonor = scanner.next();
        scanner.nextLine();
        return donationItemDonor;

    }

    public String inputDonationDate() {
        System.out.print("Donation Date (YY/MM/DD) :");
        String donationDate = scanner.next();
        scanner.nextLine();
        return donationDate;

    }

    public String inputDonationDelete() {
        System.out.print("Plese Enter The Donation ID That Need To Delete(Dxxxx) : ");
        String deleteDonationId = scanner.next();
        scanner.nextLine();
        return deleteDonationId;
    }

    public Donation deleteDonation() {
        String deleteItem = inputDonationDelete();
        return new Donation(deleteItem);
    }
    
    public String inputDonationAmend() {
        System.out.print("Plese Enter The Donation ID That Need To Amend(Dxxxx) : ");
        String amendDonationId = scanner.next();
        scanner.nextLine();
        return amendDonationId;
    }

    public Donation addDonation() {
        String donationId = inputDonationId();
        String donationItemName = inputDonationItemName();
        int donationQty = inputDonationItemQty();
        String donationDonorName = inputDonationDonorName();
        String donationDate = inputDonationDate();
        System.out.println();
        return new Donation(donationId, donationItemName, donationQty, donationDonorName, donationDate);
    }

}
