/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import adt.SortedDoublyLinkedList;
import adt.SortedDoublyLinkedListInterface;
import boundary.DonorUI;
import dao.DonorInitializer;
import entity.Donation;
import entity.Donor;
import utility.MessageUI;

/**
 *
 * @author LEE CHUN YIN
 */
public class DonorControl {
    
    private SortedDoublyLinkedListInterface<Donor> donorList = new SortedDoublyLinkedList<>();
    private DonorInitializer donorDAO = new DonorInitializer();
    private DonorUI donorUI = new DonorUI();
    
    public DonorControl() {
        donorList = donorDAO.initializeDonors();
    }
    
    public void runDonorMaintenance() {
        int choice = 0;
        do {
            choice = donorUI.getDonorMenuChoice();
            switch (choice) {
                case 1:
                    addNewDonor();
                    break;
                case 2:
                    removeDonor();
                    break;
                case 3:
                    updateDonorDetails();
                    break;
                case 4:
                    searchDonor();
                    break;
                case 5:
                    listAllDonors();
                    break;
                case 6:
                    generateDonorSummaryReport();
                    break;
                case 7:
                    MessageUI.displayExitMessage();
                    break;
                default:
                    MessageUI.displayInvalidChoiceMessage();
            }
        } while (choice != 7);
    }
    
    public void addNewDonor() {
        Donor newDonor = donorUI.inputDonorDetails();
        donorList.add(newDonor);
    }
    
    private void removeDonor() {
        String donorName = donorUI.inputDonorName();
        for (int i = 0; i < donorList.size(); i++) {
            if (donorList.getEntry(i).getDonorName().endsWith(donorName)) {
                donorList.remove(donorList.getEntry(i));
            }
        }
    }
    
    private void updateDonorDetails() {
        String donorName = donorUI.inputDonorName();
        String donorId = null;
        for (int i = 0; i < donorList.size(); i++) {
            if (donorList.getEntry(i).getDonorName().endsWith(donorName)) {
                donorUI.printDonorDetails(donorList.getEntry(i));
                donorId = donorList.getEntry(i).getDonorId();
            }
        }
        Donor donor = donorUI.inputDonorDetails();
        donor.setDonorId(donorId); 
        for (int i = 0; i < donorList.size(); i++) {
            if (donorList.getEntry(i).getDonorName().endsWith(donorName)) {
                donorList.edit(donorList.getEntry(i), donor);
            }
        }
    }
    
    private void searchDonor() {
        String donorName = donorUI.inputDonorName();
        for (int i = 0; i < donorList.size(); i++) {
            if (donorList.getEntry(i).getDonorName().endsWith(donorName)) {
                donorUI.printDonorDetails(donorList.getEntry(i));
            }
        }
    }
    
    private void listAllDonors() {
        donorUI.printDonorList(donorList);
    }
    
    public static void main(String[] args) {
        DonorControl donorMaintenance = new DonorControl();
        donorMaintenance.runDonorMaintenance();
    }
    private void generateDonorSummaryReport() {
    // Define arrays to keep track of donor type indices and totals
    String[] donorTypes = {"Individual", "Corporate", "Foundation", "Government"};
    double[] typeTotals = new double[donorTypes.length];

    // Initialize variables for summary report
    int totalDonors = donorList.size();
    double totalDonations = 0.0;
    
    // Iterate through each donor and aggregate data
    for (int i = 0; i < donorList.size(); i++) {
        Donor donor = donorList.getEntry(i);
        String donorType = donor.getDonorType();
        SortedDoublyLinkedListInterface<Donation> donations = donor.getDonations();
        
        // Calculate total donations for this donor
        double donorTotal = 0.0;
        for (int j = 0; j < donations.size(); j++) {
            donorTotal += donations.getEntry(j).getAmount();
        }
        
        // Update total donations
        totalDonations += donorTotal;
        
        // Update the typeTotals array based on donorType
        for (int k = 0; k < donorTypes.length; k++) {
            if (donorTypes[k].equals(donorType)) {
                typeTotals[k] += donorTotal;
                break;
            }
        }
    }

    // Print summary report
    System.out.println("Donor Summary Report");
    System.out.println("====================");
    System.out.println("Total Donors: " + totalDonors);
    System.out.println("Total Donations: $" + String.format("%.2f", totalDonations));
    
    System.out.println("\nDonations by Donor Type");
    System.out.println("========================");
    for (int i = 0; i < donorTypes.length; i++) {
        System.out.printf("%-20s $%.2f\n", donorTypes[i], typeTotals[i]);
    }
}

}
