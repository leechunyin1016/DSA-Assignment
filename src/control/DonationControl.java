/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import adt.*;
import boundary.DonationUI;
import dao.donationAddProduct;
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
    private donationAddProduct dcp = new donationAddProduct();
    
    public DonationControl(){
        donationList = dcp.donationdata();
    }

    public void donationMainMenu() {
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
                case 4:
                    searchDonation();
                    break;
                case 5:
                    trackDonation();
                    break;
                case 6:
                    donationList.display();
                    break;
                case 7:
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

        int selectedItem = donationUI.selectDonationAmend();

        switch (selectedItem) {
            case 1:
                System.out.println("Please Select The Correct Donation Item : ");
                int donationItemName = donationUI.inputDonationItemName();
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
                donationOld.setDonationId(foundDonation.getDonationId());
                donationOld.setDonationItem(donationItemNames);
                donationOld.setDonationdDonorName(foundDonation.getDonationdDonorName());
                donationOld.setDonationDate(foundDonation.getDonationDate());
                donationOld.setDonationItemQty(foundDonation.getDonationItemQty());

                donationList.edit(donationToAmend, donationOld);

                System.out.println("Amend Donation Item Successfull");

                break;

            case 2:
                int newDonationQuantity = donationUI.amendCorrectQuantity();

                donationOld.setDonationId(foundDonation.getDonationId());
                donationOld.setDonationItem(foundDonation.getDonationItem());
                donationOld.setDonationdDonorName(foundDonation.getDonationdDonorName());
                donationOld.setDonationDate(foundDonation.getDonationDate());
                donationOld.setDonationItemQty(newDonationQuantity);

                donationList.edit(donationToAmend, donationOld);

                System.out.println("Amend Donation Quantity Successfull");
                break;

            case 3:
                String newDonorName = donationUI.amendCorrectDonorName();

                donationOld.setDonationId(foundDonation.getDonationId());
                donationOld.setDonationItem(foundDonation.getDonationItem());
                donationOld.setDonationdDonorName(newDonorName);
                donationOld.setDonationDate(foundDonation.getDonationDate());
                donationOld.setDonationItemQty(foundDonation.getDonationItemQty());

                donationList.edit(donationToAmend, donationOld);

                System.out.println("Amend Donation Quantity Successfull");
                break;

            case 4:
                String newDate = donationUI.amendCorrectDate();

                donationOld.setDonationId(foundDonation.getDonationId());
                donationOld.setDonationItem(foundDonation.getDonationItem());
                donationOld.setDonationdDonorName(foundDonation.getDonationdDonorName());
                donationOld.setDonationDate(newDate);
                donationOld.setDonationItemQty(foundDonation.getDonationItemQty());

                donationList.edit(donationToAmend, donationOld);

                System.out.println("Amend Donation Quantity Successfull");
                break;

            default:
                System.out.println("Error");
                break;

        };

    }

    public void searchDonation() {
        String searchTarget = donationUI.inputDonationSearch();

        // Create a dummy Donation object with only the ID
        Donation donationToAmend = new Donation(searchTarget);

        // Find and remove the donation
        Donation foundDonation = donationList.find(donationToAmend);
        System.out.println("Target Donation : " + foundDonation);

        donationUI.pressEnterContinue();
    }
    
    public void trackDonation(){
        System.out.println("Please Select The Donation Item Want To Track : ");
                int donationItemName = donationUI.inputDonationItemName();
                String donationItemNames = "";
                switch (donationItemName) {
                    case 0:
                        System.out.println("Error");
                        break;
                    case 1:
                        donationItemNames = "Food";
                        donationList.filter(donationItemNames);
                        break;
                    case 2:
                        donationItemNames = "Daily necessaries";
                        donationList.filter(donationItemNames);
                        break;
                    case 3:
                        donationItemNames = "Medical";
                        donationList.filter(donationItemNames);
                        break;
                    case 4:
                        donationItemNames = "Clothes";
                        donationList.filter(donationItemNames);
                        break;
                    case 5:
                        donationItemNames = "Stationary";
                        donationList.filter(donationItemNames);
                        break;
                    case 6:
                        donationItemNames = "Cash";
                        donationList.filter(donationItemNames);
                        break;
                    default:
                        System.out.println("Error");
                        break;                        
                }

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
