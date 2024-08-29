/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;

import adt.SortedDoublyLinkedListInterface;
import entity.Donation;
import entity.Donor;
import java.util.Scanner;

/**
 *
 * @author LEE CHUN YIN
 */
public class DonorUI {

    Scanner scanner = new Scanner(System.in);

    public int getDonorMenuChoice() {

        System.out.println("\nDonor Management System");
        System.out.println("1. Add Donor");
        System.out.println("2. Remove Donor");
        System.out.println("3. Update Donor Details");
        System.out.println("4. Search Donor");
        System.out.println("5. List All Donors");
        System.out.println("6. Generate Donor Summary Report");
        System.out.println("7. Exit");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

public void printDonorDetails(Donor donor) {
    System.out.println("Donor Details");
    System.out.println("=============");
    System.out.println("ID: " + donor.getDonorId());
    System.out.println("Name: " + donor.getDonorName());
    System.out.println("Type: " + donor.getDonorType());
    System.out.println("Phone No: " + donor.getPhoneNo());
    System.out.println("Email: " + donor.getEmail());
    System.out.println("DOB: " + donor.getDob());

    System.out.println("\nDonations");
    System.out.println("================================");
    System.out.printf("%-20s %-10s %-15s\n", "Item", "Amount", "Date");
    System.out.println("--------------------------------");

    // Get the donations list
    SortedDoublyLinkedListInterface<Donation> donations = donor.getDonations();
    
    // Check if there are donations
    if (donations.size() == 0) {
        System.out.printf("%-20s %-10s %-15s\n", "No donations", "", "");
    } else {
        // Print each donation
        for (int i = 0; i < donations.size(); i++) {
            Donation donation = donations.getEntry(i);
            System.out.printf("%-20s %-10.2f %-15s\n",
                donation.getDonatedItem(),
                donation.getAmount(),
                donation.getDate()); // Assuming date is formatted as needed
        }
    }
}

public void printDonorList(SortedDoublyLinkedListInterface<Donor> donorList) {
System.out.println("Donor List");
    System.out.println("==========");

    // Print table header
    System.out.printf("%-15s %-20s %-10s %-15s %-30s %-10s\n", 
        "Donor ID", "Name", "Type", "Phone No", "Email", "DOB");
    System.out.println("--------------------------------------------------------------------------------");

    // Iterate through the donor list and print each donor's details
    for (int i = 0; i < donorList.size(); i++) {
        Donor donor = donorList.getEntry(i);
        System.out.printf("%-15s %-20s %-10s %-15s %-30s %-10s\n",
            donor.getDonorId(),
            donor.getDonorName(),
            donor.getDonorType(),
            donor.getPhoneNo(),
            donor.getEmail(),
            donor.getDob());
    }

    System.out.println(); // Print a blank line for readability
}


    public Donor inputDonorDetails() {
        String donorName = inputDonorName();
        String donorType = inputDonorType();
        String donorPhoneNo = inputDonorPhoneNo();
        String donorEmail = inputDonorEmail();
        String donorDOB = inputDonorDOB();
        return new Donor(donorName, donorType, donorPhoneNo, donorEmail, donorDOB);
    }

    public String inputDonorName() {
        System.out.print("Enter Donor Name: ");
        String name = scanner.nextLine();
        return name;
    }

    public String inputDonorType() {
        System.out.print("Enter Donor Type: ");
        String type = scanner.nextLine();
        return type;
    }

    public String inputDonorPhoneNo() {
        System.out.print("Enter Donor Phono No: ");
        String type = scanner.nextLine();
        return type;
    }

    public String inputDonorEmail() {
        System.out.print("Enter Donor Email: ");
        String type = scanner.nextLine();
        return type;
    }

    public String inputDonorDOB() {
        System.out.print("Enter Donor DOB: ");
        String type = scanner.nextLine();
        return type;
    }

}
