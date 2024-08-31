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
import java.util.InputMismatchException;

/**
 *
 * @author junyi
 */
public class DonationUI {

    Scanner scanner = new Scanner(System.in);

    public int donationMenu() {
        int choice = -1; // Initialize choice to an invalid number

        while (choice < 1 || choice > 8) { // Loop until a valid choice is entered
            System.out.println("===========================================");
            System.out.println("            Donation Main Menu             ");
            System.out.println("===========================================");
            System.out.println("1.  Add Donation");
            System.out.println("2.  Remove Donation");
            System.out.println("3.  Amend Donation");
            System.out.println("4.  Search Donation");
            System.out.println("5.  Track Donated Item");
            System.out.println("6.  Donation List");
            System.out.println("7.  Generate Summary Report");
            System.out.println("8.  Exit");
            System.out.println("===========================================");
            System.out.print("Please Enter Your Choice (1-8): ");
            

            try {
                choice = scanner.nextInt(); // Read the user input as an integer
                scanner.nextLine(); // Consume the newline character

                if (choice < 1 || choice > 8) {
                    System.out.println("Invalid choice. Please enter a number between 1 and 8.");
                }
            } catch (InputMismatchException e) {
                // Catch non-integer input
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Clear the invalid input from the scanner
            }

            System.out.println(); // Add a blank line for readability
        }
        return choice;
    }

    public String inputDonationId() {
        DonationControl dc = new DonationControl();
        String donationId = "D" + dc.getRandomNumber();
        System.out.print("Donation ID: " + donationId + "\n");
        return donationId;
    }

    public int inputDonationItemName() {
        int donationItemNameList = -1; // Initialize choice to an invalid number
        while (donationItemNameList < 0 || donationItemNameList > 6) { // Loop until a valid choice is entered
            System.out.println("===========================================");
            System.out.println("Donation Item :");
            System.out.println("===========================================");
            System.out.println("1. Food");
            System.out.println("2. Daily necessaries");
            System.out.println("3. Medical");
            System.out.println("4. Clothes");
            System.out.println("5. Stationary");
            System.out.println("6. Cash");
            System.out.println("0. Go Back To Menu");
            System.out.println("===========================================");
            System.out.print("Plese Select The Donation Item (1-6): ");

            try {
                donationItemNameList = scanner.nextInt(); // Read the user input as an integer
                scanner.nextLine(); // Consume the newline character

                if (donationItemNameList < 0 || donationItemNameList > 6) {
                    System.out.println("Invalid choice. Please enter a number between 0 and 6.");
                }
            } catch (InputMismatchException e) {
                // Catch non-integer input
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Clear the invalid input from the scanner
            }

            System.out.println(); // Add a blank line for readability
        }

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
        System.out.print("Donation Date (YYYY/MM/DD) :");
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

    public String inputDonationSearch() {
        System.out.print("Please Enter The Donation ID That Need To Search (Dxxxx) : ");
        String searchDonationId = scanner.next();
        scanner.nextLine();
        return searchDonationId;
    }

    public int inputDonationList() {
        int donationList = -1; // Initialize choice to an invalid number
        while (donationList < 0 || donationList > 5) { // Loop until a valid choice is entered
            System.out.println("===========================================");
            System.out.println("Which One Type You Want To Display : ");
            System.out.println("===========================================");
            System.out.println("1. Display All");
            System.out.println("2. Display By Donor");
            System.out.println("3. Display By Donation Item");
            System.out.println("4. Display By Item Quantity");
            System.out.println("5. Display By Donation Date");
            System.out.println("0. Go Back Main Menu");
            System.out.println("===========================================");
            System.out.print("Please Select (1-5) : ");

            try {
                donationList = scanner.nextInt(); // Read the user input as an integer
                scanner.nextLine(); // Consume the newline character

                if (donationList < 0 || donationList > 5) {
                    System.out.println("Invalid choice. Please enter a number between 0 and 5.");
                }
            } catch (InputMismatchException e) {
                // Catch non-integer input
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Clear the invalid input from the scanner
            }

            System.out.println(); // Add a blank line for readability
        }
        return donationList;
    }

    public int selectDonationAmend() {
        int choice = -1; // Initialize choice to an invalid number
        while (choice < 0 || choice > 4) { // Loop until a valid choice is entered
            System.out.println("===========================================");
            System.out.println("Plese Select The Data Need To Amend :");
            System.out.println("===========================================");
            System.out.println("1. Donation Item");
            System.out.println("2. Donation Quantity");
            System.out.println("3. Donor Name");
            System.out.println("4. Donation Date");
            System.out.println("0. Go Back Main Menu");
            System.out.println("===========================================");
            System.out.print("Plese Select (1-4): ");
            try {
                choice = scanner.nextInt(); // Read the user input as an integer
                scanner.nextLine(); // Consume the newline character

                if (choice < 0 || choice > 4) {
                    System.out.println("Invalid choice. Please enter a number between 0 and 4.");
                }
            } catch (InputMismatchException e) {
                // Catch non-integer input
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Clear the invalid input from the scanner
            }

            System.out.println(); // Add a blank line for readability
        }
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

    public void printFilteredList(SortedDoublyLinkedListInterface<Donation> donationList) {
        for (int i = 0; i < donationList.size(); i++) {
            Donation donation = donationList.getEntry(i);
            System.out.printf("%-5s %-20s %-3d %-15s %s \n", donation.getDonationId(), donation.getDonationItem(),
                    donation.getDonationItemQty(), donation.getDonationdDonorName(), donation.getDonationDate());
        }
        System.out.println();

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

    public void getTitle() {
        System.out.println("==============================================================");
        System.out.printf(
                "%-5s %-20s %-3s %-15s %s \n",
                "ID", // Short label for donationId
                "Item", // Short label for donationItem
                "Qty", // Short label for donationItemQty
                "Donor Name", // Short label for donationdDonorName
                "Date" // Short label for donationDate
        );
        System.out.println("==============================================================");
    }

    public void pressEnterContinue() {
        System.out.println("Press Enter To Continue...");
        scanner.nextLine();
    }

}
