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
    public int donationMenu() {
        System.out.println("Donation Main Menu");
        System.out.println("1. Add Donation");
        System.out.println("2. Remove Donation");
        System.out.println("3. Amend Donation");
        System.out.println("4. Search Donation");
        System.out.println("5. Track Donated Item");
        System.out.println("6. Donation List");
        System.out.println("7. Exit");
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

    public int inputDonationItemName() {
        System.out.println("Donation Item :");
        System.out.println("1. Food");
        System.out.println("2. Daily necessaries");
        System.out.println("3. Medical");
        System.out.println("4. Clothes");
        System.out.println("5. Stationary");
        System.out.println("6. Cash");
        System.out.print("Plese Select The Donation Item (1-6): ");
        int donationItemNameList = scanner.nextInt();
        scanner.nextLine();
        return donationItemNameList;

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
    
    public String inputDonationSearch(){
        System.out.print("Plese Enter The Donation ID That Need To Search (Dxxxx) : ");
        String searchDonationId = scanner.next();
        scanner.nextLine();
        return searchDonationId;
    }

    public int selectDonationAmend() {
        System.out.println("Plese Select The Data Need To Amend :");
        System.out.println("1. Donation Item");
        System.out.println("2. Donation Quantity");
        System.out.println("3. Donor Name");
        System.out.println("4. Donation Date");
        System.out.print("Plese Select (1-4): ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;

    }

    public int amendCorrectQuantity() {
        System.out.print("Please Enter The Correct Quantity : ");
        int newQuantity = scanner.nextInt();
        scanner.nextLine();
        return newQuantity;
    }

    public String amendCorrectDonorName() {
        System.out.print("Please Enter The Correct Donor Name : ");
        String newDonorName = scanner.next();
        scanner.nextLine();
        return newDonorName;
    }
    
    public String amendCorrectDate() {
        System.out.print("Please Enter The Correct Donation Date (YYYY/MM/DD) : ");
        String newDate = scanner.next();
        scanner.nextLine();
        return newDate;
    }

    public Donation addDonation() {
        Donation donation = new Donation();
        String donationId = inputDonationId();
        int donationItemName = inputDonationItemName();
        String donationItemNames = "";
        switch (donationItemName) {
            case 0:
                System.out.println("Error");
                break;
            case 1:
                donationItemNames = "Food";
                break;
            case 2:
                donationItemNames = "Daily necessaries";
                break;
            case 3:
                donationItemNames = "Medical";
                break;
            case 4:
                donationItemNames = "Clothes";
                break;
            case 5:
                donationItemNames = "Stationary";
                break;
            case 6:
                donationItemNames = "Cash";
                break;
            default:
                System.out.println("Error");
                break;
        }
        int donationQty = inputDonationItemQty();
        String donationDonorName = inputDonationDonorName();
        String donationDate = inputDonationDate();
        System.out.println();
        return new Donation(donationId, donationItemNames, donationQty, donationDate, donationDonorName);
    }
    
    public void pressEnterContinue(){
        System.out.println("Press Enter To Continue...");
        scanner.nextLine();
    }

}
