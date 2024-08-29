/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import adt.*;
import boundary.DonationUI;
import entity.*;
import java.util.Random;

/**
 *
 * @author junyi
 */
public class DonationControl {

    private Random random = new Random();

    private SortedDoublyLinkedListInterface<Donation> donationList = new SortedDoublyLinkedList<>();
    private DonationUI donationUI = new DonationUI();

    public void donationMainMenu() {
        Donation[] donations = new Donation[]{
            new Donation("D1001", "Books", 5, "Alice", "2024/08/01"),
            new Donation("D1002", "Toys", 10, "Bob", "2024/08/02"),
            new Donation("D1003", "Clothes", 20, "Charlie", "2024/08/03"),
            new Donation("D1004", "Food", 30, "David", "2024/08/04"),
            new Donation("D1005", "Furniture", 1, "Eve", "2024/08/05"),
            new Donation("D1006", "Electronics", 8, "Frank", "2024/08/06"),
            new Donation("D1007", "Stationery", 15, "Grace", "2024/08/07"),
            new Donation("D1008", "Medical Supplies", 7, "Heidi", "2024/08/08"),
            new Donation("D1009", "Sports Equipment", 3, "Ivan", "2024/08/09"),
            new Donation("D1010", "Cleaning Supplies", 12, "Judy", "2024/08/10")
        };

        for (Donation donation : donations) {
            donationList.add(donation);
        }

        int choice = 0;
        do {
            choice = donationUI.donationMenu();
            switch (choice) {
                case 0:
                    System.out.println("Error");
                    break;
                case 1:
                    addDonation();
                    break;
                case 2:
                    deleteDonation();
                    break;
                case 3:
                    amendDonation();
                    break;
                case 6:
                    donationList.display();
                    break;
                default:
                    System.out.println("Error");
            }
        } while (choice != 0);
    }

    public void addDonation() {
        Donation newDonation = donationUI.addDonation();
        donationList.add(newDonation);
    }

    public void deleteDonation() {
        // Get the ID of the donation to delete
        String pointedDonationId = donationUI.inputDonationDelete();

        // Create a dummy Donation object with only the ID
        Donation donationToRemove = new Donation(pointedDonationId);

        // Find and remove the donation
        Donation foundDonation = donationList.find(donationToRemove);
        System.out.println("Found donation: " + foundDonation);

        if (foundDonation != null) {
            donationList.remove(foundDonation);
            System.out.println("Donation with ID " + pointedDonationId + " has been removed.");
        } else {
            System.out.println("No donation found with ID " + pointedDonationId);
        }
    }
    
    public void amendDonation() {
        // Get the ID of the donation to delete
        String pointedDonationId = donationUI.inputDonationAmend();

        // Create a dummy Donation object with only the ID
        Donation donationToAmend = new Donation(pointedDonationId);

        // Find and remove the donation
        Donation foundDonation = donationList.find(donationToAmend);
        System.out.println("Found donation: " + foundDonation);
        
        Donation donationOld = new Donation();
        
        donationOld.setDonationId(foundDonation.getDonationId());
        donationOld.setDonationItem(foundDonation.getDonationItem());
        donationOld.setDonationdDonorName(foundDonation.getDonationdDonorName());
        donationOld.setDonationDate(foundDonation.getDonationDate());
        donationOld.setDonationItemQty(foundDonation.getDonationItemQty());
        

    }

    public String getRandomNumber() {

        // Generate a random number between 1000 and 9999
        int number = 1000 + random.nextInt(9000); // 9000 is the range to get numbers up to 9999
        return String.format("%04d", number); // Ensure it's a 4-digit number, pad with zeros if necessary
    }

    public static void main(String[] args) {
        DonationControl donationControl = new DonationControl();
        donationControl.donationMainMenu();
    }

}
