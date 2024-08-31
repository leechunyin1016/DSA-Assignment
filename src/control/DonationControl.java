/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import adt.*;
import boundary.DonationUI;
import dao.donationAddProduct;
import entity.*;
import java.util.Comparator;
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

    public DonationControl() {
        donationList = dcp.donationdata();
    }

    public void donationMainMenu() {

        Donation donation = new Donation();
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
                    listDonation();
                    break;
                case 7:
                    generateReport();
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
        donationUI.getTitle();
        System.out.println(foundDonation);
        donationUI.pressEnterContinue();
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
        
        if(foundDonation == null){
            System.out.println("No donation found with ID " + pointedDonationId);
            donationMainMenu();
        }
        
        donationUI.getTitle();
        System.out.println(foundDonation);

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
                        donationUI.pressEnterContinue();
                        donationUI.donationMenu();
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
        donationUI.getTitle();
        System.out.println("Target Donation : " + foundDonation);

        donationUI.pressEnterContinue();
    }

    public SortedDoublyLinkedListInterface<Donation> filter(String targetItem) {

        SortedDoublyLinkedListInterface<Donation> filteredDonationList = new SortedDoublyLinkedList<>();

        if (donationList.isEmpty()) {
            return null;
        }
        // Output information about the donations
        for (int i = 0; i < donationList.size(); i++) {
            if (donationList.getEntry(i).getDonationItem().equalsIgnoreCase(targetItem)) {
                filteredDonationList.add(donationList.getEntry(i));
            }
        }
        return filteredDonationList;
    }

    public void trackDonation() {
        System.out.println("Please Select The Donation Item Want To Track : ");
        int donationItemName = donationUI.inputDonationItemName();
        String donationItemNames = "";
        switch (donationItemName) {
            case 0:
                System.out.println("Error");
                break;
            case 1:
                donationItemNames = "Food";
                donationUI.getTitle();
                donationUI.printFilteredList(filter(donationItemNames));
                donationUI.pressEnterContinue();

                break;
            case 2:
                donationItemNames = "Daily necessaries";
                donationUI.getTitle();
                donationUI.printFilteredList(filter(donationItemNames));
                donationUI.pressEnterContinue();
                break;
            case 3:
                donationItemNames = "Medical";
                donationUI.getTitle();
                donationUI.printFilteredList(filter(donationItemNames));
                donationUI.pressEnterContinue();
                break;
            case 4:
                donationItemNames = "Clothes";
                donationUI.getTitle();
                donationUI.printFilteredList(filter(donationItemNames));
                donationUI.pressEnterContinue();
                break;
            case 5:
                donationItemNames = "Stationary";
                donationUI.getTitle();
                donationUI.printFilteredList(filter(donationItemNames));
                donationUI.pressEnterContinue();
                break;
            case 6:
                donationItemNames = "Cash";
                donationUI.getTitle();
                donationUI.printFilteredList(filter(donationItemNames));
                donationUI.pressEnterContinue();
                break;
            default:
                System.out.println("Error");
                break;
        }

    }

    public void listDonation() {
        int donationListShow = donationUI.inputDonationList();

        switch (donationListShow) {
            case 1:
                donationUI.getTitle();
                donationList.display();
                donationUI.pressEnterContinue();
                break;
            case 2:
                donationShowByDonor();
                donationUI.pressEnterContinue();
                break;
            case 3:
                donationShowByItem();
                donationUI.pressEnterContinue();
                break;
            case 4:
                donationShowByQty();
                donationUI.pressEnterContinue();
                break;
            case 5:
                donationShowByDate();
                donationUI.pressEnterContinue();
                break;
            default:
                break;
        }
    }

    public void donationShowByDonor() {
        donationList.sort(Comparator.comparing(Donation::getDonationdDonorName));
        donationUI.getTitle();
        donationList.display();
        donationList.sort(Comparator.comparing(Donation::getDonationId));
    }

    public void donationShowByItem() {
        donationList.sort(Comparator.comparing(Donation::getDonationItem));
        donationUI.getTitle();
        donationList.display();
        donationList.sort(Comparator.comparing(Donation::getDonationId));
    }

    public void donationShowByQty() {
        donationList.sort(Comparator.comparingInt(Donation::getDonationItemQty));
        donationUI.getTitle();
        donationList.display();
        donationList.sort(Comparator.comparing(Donation::getDonationId));
    }

    public void donationShowByDate() {
        donationList.sort(Comparator.comparing(Donation::getDonationDate));
        donationUI.getTitle();
        donationList.display();
        donationList.sort(Comparator.comparing(Donation::getDonationId));
    }

    public void generateReport() {
        // Arrays to store donation types and their total quantities
        final int maxTypes = 100; // Adjust size as needed
        String[] types = new String[maxTypes];
        int[] quantities = new int[maxTypes];
        int count = 0;

        // Traverse the list to aggregate donation data
        int size = donationList.size();
        for (int i = 0; i < size; i++) {
            Donation donation = donationList.getEntry(i);
            String type = donation.getDonationItem();
            int quantity = donation.getDonationItemQty();

            int index = findTypeIndex(types, type, count);

            if (index != -1) {
                // Type already exists in the array
                quantities[index] += quantity;
            } else if (count < maxTypes) {
                // New type
                types[count] = type;
                quantities[count] = quantity;
                count++;
            }
        }

        // Print the report
        printReport(types, quantities, count);
        donationUI.pressEnterContinue();
    }

    private static int findTypeIndex(String[] types, String type, int count) {
        for (int i = 0; i < count; i++) {
            if (types[i].equals(type)) {
                return i;
            }
        }
        return -1;
    }

    private static void printReport(String[] types, int[] quantities, int count) {
        System.out.println("============================================");
        System.out.println("Donation Report:");
        System.out.println("============================================");
        for (int i = 0; i < count; i++) {
            System.out.println("Type: " + types[i] + " | Total Quantity: " + quantities[i]);
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
