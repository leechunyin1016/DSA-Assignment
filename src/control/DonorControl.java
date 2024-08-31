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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import utility.MessageUI;

/**
 *
 * @author LEE CHUN YIN
 */
public class DonorControl {

    private SortedDoublyLinkedListInterface<Donor> donorList = new SortedDoublyLinkedList<>();
    private DonorInitializer donorDAO = new DonorInitializer();
    private DonorUI donorUI = new DonorUI();
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

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
                    generateReport();
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
        searchDonor(removeDonorInput);
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

    private void searchDonor(String searchInput) {
        if (containsNumbers(searchInput)) {
            // Search by donor ID
            searchById(searchInput);
        } else {
            // Search by donor name
            searchByName(searchInput);
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
                donorUI.printDonorList(filterDonorByName(option, donorUI.inputFilterDonorName(option)));
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

    public void filterDonorsByPhoneNo() {
        String filterCriteria = donorUI.inputFilterDonorPhoneNo();
        SortedDoublyLinkedListInterface<Donor> filteredDonorList = filterDonorByPhoneNo(filterCriteria);
        donorUI.printDonorList(filteredDonorList); // Assuming this method exists to display the list
    }

    private SortedDoublyLinkedListInterface<Donor> filterDonorByPhoneNo(String filterCriteria) {
        SortedDoublyLinkedListInterface<Donor> filteredDonorList = new SortedDoublyLinkedList<>();
        String filterType = filterCriteria.split(":")[0];
        String filterValue = filterCriteria.split(":")[1];

        if (donorList.isEmpty()) {
            return filteredDonorList; // Return empty list if no donors
        }

        for (int i = 0; i < donorList.size(); i++) {
            Donor donor = donorList.getEntry(i);
            String phoneNo = donor.getPhoneNo();

            switch (filterType) {
                case "start":
                    if (phoneNo.startsWith(filterValue)) {
                        filteredDonorList.add(donor);
                    }
                    break;
                case "end":
                    if (phoneNo.endsWith(filterValue)) {
                        filteredDonorList.add(donor);
                    }
                    break;
                default:
                    System.out.println("Invalid filter type.");
                    break;
            }
        }

        return filteredDonorList;
    }

    private SortedDoublyLinkedListInterface<Donor> filterDonorByEmail(String filterCriteria) {
        SortedDoublyLinkedListInterface<Donor> filteredDonorList = new SortedDoublyLinkedList<>();
        String filterType = filterCriteria.split(":")[0];
        String filterValue = filterCriteria.split(":")[1];

        if (donorList.isEmpty()) {
            return filteredDonorList; // Return empty list if no donors
        }

        for (int i = 0; i < donorList.size(); i++) {
            Donor donor = donorList.getEntry(i);
            String email = donor.getEmail();

            switch (filterType) {
                case "start":
                    if (email.startsWith(filterValue)) {
                        filteredDonorList.add(donor);
                    }
                    break;
                case "end":
                    if (email.endsWith(filterValue)) {
                        filteredDonorList.add(donor);
                    }
                    break;
                default:
                    System.out.println("Invalid filter type.");
                    break;
            }
        }

        return filteredDonorList;
    }

    public void filterDonorsByDOB() {
        String filterCriteria = donorUI.inputFilterDonorDOB();
        SortedDoublyLinkedListInterface<Donor> filteredDonorList = filterDonorByDOB(filterCriteria);
        donorUI.printDonorList(filteredDonorList); // Display the filtered donor list
    }

    private SortedDoublyLinkedListInterface<Donor> filterDonorByDOB(String filterCriteria) {
        SortedDoublyLinkedListInterface<Donor> filteredDonorList = new SortedDoublyLinkedList<>();
        String[] criteriaParts = filterCriteria.split(":");

        if (donorList.isEmpty()) {
            return filteredDonorList; // Return empty list if no donors
        }

        if (criteriaParts.length < 2) {
            System.out.println("Invalid filter criteria.");
            return filteredDonorList; // Return empty list if criteria are invalid
        }

        String filterType = criteriaParts[0];
        String filterValue1 = criteriaParts[1];
        String filterValue2 = criteriaParts.length > 2 ? criteriaParts[2] : null;

        // Validate date format
        if (filterType.equals("range") && (filterValue1 == null || filterValue2 == null || !isValidDate(filterValue1) || !isValidDate(filterValue2))) {
            System.out.println("One or both dates are invalid. Ensure dates are in the format DD/MM/YYYY.");
            return filteredDonorList; // Return empty list if dates are invalid
        }

        for (int i = 0; i < donorList.size(); i++) {
            Donor donor = donorList.getEntry(i);
            String dob = donor.getDob(); // Assume DOB is in DD/MM/YYYY format

            switch (filterType) {
                case "day":
                    if (dob.startsWith(filterValue1 + "/")) {
                        filteredDonorList.add(donor);
                    }
                    break;
                case "month":
                    if (dob.substring(3, 5).equalsIgnoreCase(filterValue1)) {
                        filteredDonorList.add(donor);
                    }
                    break;
                case "year":
                    if (dob.substring(6).equalsIgnoreCase(filterValue1)) {
                        filteredDonorList.add(donor);
                    }
                    break;
                case "range":
                    Date startDate = parseDate(filterValue1);
                    Date endDate = parseDate(filterValue2);
                    Date donorDate = parseDate(dob);

                    if (donorDate != null && startDate != null && endDate != null) {
                        if (!donorDate.before(startDate) && !donorDate.after(endDate)) {
                            filteredDonorList.add(donor);
                        }
                    }
                    break;
                default:
                    System.out.println("Invalid filter type.");
                    break;
            }
        }

        return filteredDonorList;
    }

    private boolean isValidDate(String dateStr) {
        try {
            DATE_FORMAT.setLenient(false);
            DATE_FORMAT.parse(dateStr);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    private Date parseDate(String dateStr) {
        try {
            DATE_FORMAT.setLenient(false);
            return DATE_FORMAT.parse(dateStr);
        } catch (ParseException e) {
            return null;
        }
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

    private void generateReport() {
        generateReport(donorUI.displayReportMenu());
    }

    private void generateReport(int choice) {
        switch (choice) {
            case 1:
                generateDonorOverviewReport();
                break;
            case 2:
                generateDonorDemographicsReport();
                break;
            case 3:
                generateDonorTypeBreakdown();
                break;
            case 4:
                generateYearlyDonorStatistics();
                break;
            case 5:
                System.out.println("Exiting report menu.");
                break;
            default:
                System.out.println("Invalid choice. Please select a valid option.");
        }
    }

    private void generateDonorOverviewReport() {
        // Implement your logic to generate Donor Overview Report
        System.out.println("Generating Donor Overview Report...");
        // Example output, replace with actual report generation logic
        System.out.println("Total Donors: " + donorList.size());
        // Add more details as needed
    }

    private void generateDonorDemographicsReport() {
        // Implement your logic to generate Donor Demographics Report
        System.out.println("Generating Donor Demographics Report...");
        // Example output, replace with actual report generation logic
    }

    private void generateDonorTypeBreakdown() {
 int individual = 0;
        int government = 0;
        int foundation = 0;
        int organization = 0;
        for (int i = 0; i < donorList.size(); i++) {
            if (donorList.getEntry(i).getDonorType().equalsIgnoreCase("Individual")) {
                individual++;
                continue;
            }
            if (donorList.getEntry(i).getDonorType().equalsIgnoreCase("Organization")) {
                organization++;
                continue;

            }
            if (donorList.getEntry(i).getDonorType().equalsIgnoreCase("Foundation")) {
                foundation++;
                continue;

            }
            if (donorList.getEntry(i).getDonorType().equalsIgnoreCase("Government")) {
                government++;
                continue;

            }
        }
        System.out.println(individual+" "+organization+" "+foundation+" "+government);

        System.out.println("Yearly Donor Statistic");
        System.out.println("======================");
        System.out.println("|  Individual  | "+repeatChar('*', individual));
        
        System.out.println("| Organization | "+repeatChar('*', organization));
        
        System.out.println("|  Foundation  | "+repeatChar('*', foundation));
        
        System.out.println("|  Government  | "+repeatChar('*', government));
        
        System.out.println();
    }

    private void generateYearlyDonorStatistics() {
       
    }

// Helper method to repeat a character
    private String repeatChar(char ch, int count) {
        StringBuilder sb = new StringBuilder(count);
        for (int i = 0; i < count; i++) {
            sb.append(ch);
        }
        return sb.toString();
    }

}
