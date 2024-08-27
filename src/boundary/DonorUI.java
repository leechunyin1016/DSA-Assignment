/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;

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
        System.out.println("Donor ID:" + donor.getDonorId());
        System.out.println("Donor Name: " + donor.getDonorName());
        System.out.println("Donor Type: " + donor.getDonorType());
    }

    public Donor inputDonorDetails() {
        String donorName = inputDonorName();
        String donorType = inputDonorType();
        return new Donor(donorName, donorType);
    }

    public String inputDonorId() {
        System.out.print("Enter Donor ID: ");
        String id = scanner.nextLine();
        return id;
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

}
