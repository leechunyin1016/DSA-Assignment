/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;

import control.DonorControl;
import entity.Donor;
import java.util.Scanner;

/**
 *
 * @author LEE CHUN YIN
 */
public class DonorUI {

    private DonorControl donorControl;
    private Scanner scanner;

    public DonorUI(DonorControl donorControl) {
        this.donorControl = donorControl;
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        int choice;
        do {
            System.out.println("\nDonor Management System");
            System.out.println("1. Add Donor");
            System.out.println("2. Remove Donor");
            System.out.println("3. Search Donor");
            System.out.println("4. Update Donor Details");
            System.out.println("5. List All Donors");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addDonor();
                    break;
                case 2:
                    System.out.println("Remove Donor");
                    //removeDonor();
                    break;
                case 3:
                    System.out.println("Search Donor");
                    //searchDonor();
                    break;
                case 4:
                    System.out.println("Update Donor");
                    //updateDonor();
                    break;
                case 5:
                    listDonors();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);
    }

    private void addDonor() {
        System.out.print("Enter Donor Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Contact Info: ");
        String type = scanner.nextLine();

        Donor donor = new Donor(name, type);
        donorControl.addDonor(donor);
    }

    private void listDonors() {
        donorControl.listAllDonors();
    }
}
