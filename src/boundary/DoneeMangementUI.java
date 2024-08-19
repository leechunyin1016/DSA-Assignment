/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;

import control.DoneeControl;
import entity.Donee;
import java.util.Scanner;

/**
 *
 * @author Dephnie
 */
public class DoneeMangementUI {
    Scanner scanner = new Scanner(System.in);
      
    public int getDoneeMenu() {
    System.out.println("\nDONEE MAIN MENU");
    System.out.println("1. Add New Donee");
    System.out.println("2. Remove Donee");
    System.out.println("3. Update Donee Details");
    System.out.println("4. Search Donee Details");
    System.out.println("5. List All Donee List");
    System.out.println("6. Filter Donee");
    System.out.println("7. Generate Donee Reports");
    System.out.println("0. Quit");
    System.out.print("Enter option: ");
    
    int option = scanner.nextInt();
    scanner.nextLine();
    System.out.println();
    return option;
  }

  public void listAllDonee(String outputStr) {
    System.out.println("\nList of Donee:\n" + outputStr);
  }

  public void displayDoneeDetails(Donee donee) {
    System.out.println("Donee Details");
    System.out.println("===============");
    System.out.println("Donee ID: " + donee.getDoneeID());
    System.out.println("Type: " + donee.getDoneeType());
    System.out.println("Donee Name: " + donee.getDoneeName());
    System.out.println("Gender: " + donee.getDoneeGender());
    System.out.println("Age: " + donee.getDoneeAge());
    System.out.println("Date of Birth: " + donee.getDateOfBirth());
    System.out.println("Income: " + donee.getDoneeIncome());
    System.out.println("Contact: " + donee.getDoneeContact());
    System.out.println("Address: " + donee.getDoneeAddress());
    System.out.println("Household Size: " + donee.getHouseholdSize());
    System.out.println("Priority Level: " + donee.getPriorityLevel());
    System.out.println("Donation Received: " + donee.getDonationReceived());
    System.out.println("Last Donation Received Date: " + donee.getLastDonationReceivedDate());
    System.out.println("Eligibility: " + donee.getEligibility());
    System.out.println();
  }

}
