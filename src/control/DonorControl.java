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
                    filterDonors();
                    break;
                case 7:
                    generateDonorSummaryReport();
                    break;
                case 0:
                    MessageUI.displayExitMessage();
                    break;
                default:
                    MessageUI.displayInvalidChoiceMessage();
            }
        } while (choice != 0);
    }

    public void addNewDonor() {
        Donor newDonor = donorUI.inputDonorDetails();
        if (donorUI.confirmAddAction()) {
            donorList.add(newDonor);
        }
    }

    private void removeDonor() {
        String removeDonorInput = donorUI.inputRemoveDonor(); // Get the input from the user

        if (containsNumbers(removeDonorInput)) {
            // Remove by donor ID
            if (donorUI.confirmRemoveAction("ID", removeDonorInput)) {
                removeById(removeDonorInput);
            }
        } else {
            // Remove by donor name
            if (donorUI.confirmRemoveAction("Name", removeDonorInput)) {
                removeByName(removeDonorInput);
            }
        }
    }

    private void removeById(String idInput) {
        boolean removed = false;
        for (int i = 0; i < donorList.size(); i++) {
            Donor donor = donorList.getEntry(i);
            if (donor.getDonorId().equals(idInput)) {
                donorList.remove(donor);
                removed = true;
                System.out.println("Donor with ID " + idInput + " has been removed.");
                break; // Exit loop after removing the donor
            }
        }
        if (!removed) {
            System.out.println("Donor ID not found.");
        }
    }

    // Method to remove donor by name
    private void removeByName(String nameInput) {
        boolean removed = false;
        for (int i = 0; i < donorList.size(); i++) {
            Donor donor = donorList.getEntry(i);
            if (donor.getDonorName().equalsIgnoreCase(nameInput)) {
                donorList.remove(donor);
                removed = true;
                System.out.println("Donor with name " + nameInput + " has been removed.");
                break; // Exit loop after removing the donor
            }
        }
        if (!removed) {
            System.out.println("Donor name not found.");
        }
    }

    private void updateDonorDetails() {
        String updateDonorInput = donorUI.inputUpdateDonor(); // Get the input from the user

        // Determine if input is an ID or name
        boolean isId = containsNumbers(updateDonorInput);
        Donor donorToUpdate = null;

        // Find the donor based on ID or name
        for (int i = 0; i < donorList.size(); i++) {
            Donor donor = donorList.getEntry(i);
            if (isId && donor.getDonorId().equals(updateDonorInput)) {
                donorToUpdate = donor;
                break;
            } else if (!isId && donor.getDonorName().equalsIgnoreCase(updateDonorInput)) {
                donorToUpdate = donor;
                break;
            }
        }

        if (donorToUpdate != null) {
            donorUI.printDonorDetails(donorToUpdate); // Print current details
            Donor updatedDonor = donorUI.inputDonorDetails(donorToUpdate); // Get updated details with the option to skip
            updatedDonor.setDonorId(donorToUpdate.getDonorId()); // Maintain the same ID
            donorList.edit(donorToUpdate, updatedDonor); // Update donor in the list
            System.out.println("Donor details updated successfully.");
        } else {
            System.out.println("Donor not found.");
        }

    }

    private void searchDonor() {
        String searchInput = donorUI.inputSearchDonor(); // Reusing the input method

        if (containsNumbers(searchInput)) {
            // Search by donor ID
            searchById(searchInput);
        } else {
            // Search by donor name
            searchByName(searchInput);
        }
    }

    private boolean containsNumbers(String input) {
        return input.matches(".*\\d.*");
    }

    // Method to search by donor ID
    private void searchById(String idInput) {
        for (int i = 0; i < donorList.size(); i++) {
            Donor donor = donorList.getEntry(i);
            if (donor.getDonorId().equals(idInput)) {
                donorUI.printDonorDetailsWithDonation(donor);
                return; // Exit after finding the donor
            }
        }
        System.out.println("Donor ID not found.");
    }

    // Method to search by donor name
    private void searchByName(String nameInput) {
        boolean found = false;
        for (int i = 0; i < donorList.size(); i++) {
            Donor donor = donorList.getEntry(i);
            if (donor.getDonorName().endsWith(nameInput)) {
                donorUI.printDonorDetailsWithDonation(donor);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Donor name not found.");
        }
    }

    private void listAllDonors() {

        donorUI.printDonorList(donorList);
    }

    public static void main(String[] args) {
        DonorControl donorMaintenance = new DonorControl();
        donorMaintenance.runDonorMaintenance();
    }

    private void filterDonors() {
        switch (donorUI.filterDonorMenu()) {
            case 1:
                donorUI.printDonorList(filterDonorByID(donorUI.inputFilterDonorID()));
                break; // This break is missing
            case 2:
                int option = donorUI.inputFilterNameOption();
                donorUI.printDonorList(filterDonorByName(option,donorUI.inputFilterDonorName(option)));
                break;
            case 3:
                donorUI.printDonorList(filterDonorByCategory(donorUI.inputFilterDonorCategory()));
                break;
            case 4:
                donorUI.printDonorList(filterDonorByType(donorUI.inputFilterDonorType()));
                break;
            case 5:
                donorUI.printDonorList(filterDonorByPhoneNo(donorUI.inputFilterDonorPhoneNo()));
                break;
            case 6:
                donorUI.printDonorList(filterDonorByEmail(donorUI.inputFilterDonorEmail()));
                break;
            case 7:
                donorUI.printDonorList(filterDonorByDOB(donorUI.inputFilterDonorDOB()));
                break;
            default:
                System.out.println("Invalid choice. Please select a valid option.");
        }

    }

    public SortedDoublyLinkedListInterface<Donor> filterDonorByID(String idRange) {
        SortedDoublyLinkedListInterface<Donor> filteredDonorList = new SortedDoublyLinkedList<>();

        if (donorList.isEmpty()) {
            return filteredDonorList;
        }

        String[] parts = idRange.split("-");
        String startID = parts[0].trim();
        String endID = parts[1].trim();

        for (int i = 0; i < donorList.size(); i++) {
            String currentID = donorList.getEntry(i).getDonorId();
            if (currentID.compareTo(startID) >= 0 && currentID.compareTo(endID) <= 0) {
                filteredDonorList.add(donorList.getEntry(i));
            }
        }
        return filteredDonorList;
    }


    private SortedDoublyLinkedListInterface<Donor> filterDonorByName(int option, String filterCriteria) {
        SortedDoublyLinkedListInterface<Donor> filteredDonorList = new SortedDoublyLinkedList<>();

        if (donorList.isEmpty()) {
            return filteredDonorList; // Return an empty list if no donors
        }

        for (int i = 0; i < donorList.size(); i++) {
            Donor donor = donorList.getEntry(i);
            String donorName = donor.getDonorName().toLowerCase();

            switch (option) {
                case 1: // Starts with
                    if (donorName.startsWith(filterCriteria.toLowerCase())) {
                        filteredDonorList.add(donor);
                    }
                    break;
                case 2: // Ends with
                    if (donorName.endsWith(filterCriteria.toLowerCase())) {
                        filteredDonorList.add(donor);
                    }
                    break;
                case 3: // Contains
                    if (donorName.contains(filterCriteria.toLowerCase())) {
                        filteredDonorList.add(donor);
                    }
                    break;
            }
        }

        return filteredDonorList;
    }

    public SortedDoublyLinkedListInterface<Donor> filterDonorByCategory(String targetItem) {

        SortedDoublyLinkedListInterface<Donor> filteredDonorList = new SortedDoublyLinkedList<>();

        if (donorList.isEmpty()) {
            return null;
        }
        for (int i = 0; i < donorList.size(); i++) {
            if (donorList.getEntry(i).getDonorCategory().equalsIgnoreCase(targetItem)) {
                filteredDonorList.add(donorList.getEntry(i));
            }
        }
        return filteredDonorList;
    }

    public SortedDoublyLinkedListInterface<Donor> filterDonorByType(String targetItem) {

        SortedDoublyLinkedListInterface<Donor> filteredDonorList = new SortedDoublyLinkedList<>();

        if (donorList.isEmpty()) {
            return null;
        }
        for (int i = 0; i < donorList.size(); i++) {
            if (donorList.getEntry(i).getDonorType().equalsIgnoreCase(targetItem)) {
                filteredDonorList.add(donorList.getEntry(i));
            }
        }
        return filteredDonorList;
    }

    public SortedDoublyLinkedListInterface<Donor> filterDonorByPhoneNo(String targetItem) {

        SortedDoublyLinkedListInterface<Donor> filteredDonorList = new SortedDoublyLinkedList<>();

        if (donorList.isEmpty()) {
            return null;
        }
        for (int i = 0; i < donorList.size(); i++) {
            if (donorList.getEntry(i).getDonorType().equalsIgnoreCase(targetItem)) {
                filteredDonorList.add(donorList.getEntry(i));
            }
        }
        return filteredDonorList;
    }

    public SortedDoublyLinkedListInterface<Donor> filterDonorByEmail(String targetItem) {

        SortedDoublyLinkedListInterface<Donor> filteredDonorList = new SortedDoublyLinkedList<>();

        if (donorList.isEmpty()) {
            return null;
        }
        for (int i = 0; i < donorList.size(); i++) {
            if (donorList.getEntry(i).getDonorType().equalsIgnoreCase(targetItem)) {
                filteredDonorList.add(donorList.getEntry(i));
            }
        }
        return filteredDonorList;
    }

    public SortedDoublyLinkedListInterface<Donor> filterDonorByDOB(String targetItem) {

        SortedDoublyLinkedListInterface<Donor> filteredDonorList = new SortedDoublyLinkedList<>();

        if (donorList.isEmpty()) {
            return null;
        }
        for (int i = 0; i < donorList.size(); i++) {
            if (donorList.getEntry(i).getDonorType().equalsIgnoreCase(targetItem)) {
                filteredDonorList.add(donorList.getEntry(i));
            }
        }
        return filteredDonorList;
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
                donorTotal += donations.getEntry(j).getDonationItemQty();
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

        donorUI.displayDonorSummaryReport(totalDonors, totalDonations, donorTypes, typeTotals);

    }

}
