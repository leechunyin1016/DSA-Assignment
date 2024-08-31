/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;

import adt.SortedDoublyLinkedListInterface;
import entity.Donation;
import entity.Donor;
import java.util.Scanner;

/**
 *
 * @author LEE CHUN YIN
 */
public class DonorUI {

    Scanner scanner = new Scanner(System.in);

    public int getDonorMenuChoice() {
        int choice = -1;
        while (choice < 0 || choice > 7) {
            System.out.println("\nDonor Management System");
            System.out.println("1. Add Donor");
            System.out.println("2. Remove Donor");
            System.out.println("3. Update Donor Details");
            System.out.println("4. Search Donor");
            System.out.println("5. List All Donor");
            System.out.println("6. Filter Donor");
            System.out.println("7. Generate Donor Summary Report");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
                if (choice < 0 || choice > 7) {
                    System.out.println("Invalid choice. Please enter a number between 0 and 7.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Consume invalid input
            }
        }
        return choice;
    }

    public void printDonorDetails(Donor donor) {
        System.out.println("Donor Details");
        System.out.println("=============");
        System.out.println("ID: " + donor.getDonorId());
        System.out.println("Name: " + donor.getDonorName());
        System.out.println("Category: " + donor.getDonorCategory());
        System.out.println("Type: " + donor.getDonorType());
        System.out.println("Phone No: " + donor.getPhoneNo());
        System.out.println("Email: " + donor.getEmail());
        System.out.println("DOB: " + donor.getDob());
    }

    public void printDonorDetailsWithDonation(Donor donor) {
        System.out.println("Donor Details");
        System.out.println("=============");
        System.out.println("ID: " + donor.getDonorId());
        System.out.println("Name: " + donor.getDonorName());
        System.out.println("Category: " + donor.getDonorCategory());
        System.out.println("Type: " + donor.getDonorType());
        System.out.println("Phone No: " + donor.getPhoneNo());
        System.out.println("Email: " + donor.getEmail());
        System.out.println("DOB: " + donor.getDob());

        System.out.println("\nDonations");
        System.out.println("=============================================");
        System.out.printf("%-15s %-20s %-10s %-15s %-15s\n", "Donation ID", "Item", "Quantity", "Date", "Donor Name");
        System.out.println("---------------------------------------------");

        // Get the donations list
        SortedDoublyLinkedListInterface<Donation> donations = donor.getDonations();

        // Check if there are donations
        if (donations.size() == 0) {
            System.out.printf("%-15s %-20s %-10s %-15s %-15s\n", "", "No donations", "", "", "");
        } else {
            // Print each donation
            for (int i = 0; i < donations.size(); i++) {
                Donation donation = donations.getEntry(i);
                System.out.printf("%-15s %-20s %-10d %-15s %-15s\n",
                        donation.getDonationId(),
                        donation.getDonationItem(),
                        donation.getDonationItemQty(),
                        donation.getDonationDate(),
                        donation.getDonationdDonorName());
            }
        }
    }

    public void printDonorList(SortedDoublyLinkedListInterface<Donor> donorList) {
        System.out.println("Donor List");
        System.out.println("==========");

        System.out.printf("%-15s %-20s %-10s %-15s %-30s %-10s\n",
                "Donor ID", "Name", "Category", "Type", "Phone No", "Email", "DOB");
        System.out.println("--------------------------------------------------------------------------------");

        for (int i = 0; i < donorList.size(); i++) {
            Donor donor = donorList.getEntry(i);
            System.out.printf("%-15s %-20s %-10s %-10s %-15s %-30s %-10s\n",
                    donor.getDonorId(),
                    donor.getDonorName(),
                    donor.getDonorCategory(),
                    donor.getDonorType(),
                    donor.getPhoneNo(),
                    donor.getEmail(),
                    donor.getDob());
        }

        System.out.println();
    }

    public Donor inputDonorDetails() {
        String donorName = inputDonorName();
        String donorCategory = inputDonorCategory();
        String donorType = inputDonorType(donorCategory);
        String donorPhoneNo = inputDonorPhoneNo();
        String donorEmail = inputDonorEmail();
        String donorDOB = inputDonorDOB();
        return new Donor(donorName, donorType, donorCategory, donorPhoneNo, donorEmail, donorDOB);
    }

    public Donor inputDonorDetails(Donor currentDonor) {
        String donorName = inputDonorName(currentDonor.getDonorName());
        String donorCategory = inputDonorCategory(currentDonor.getDonorCategory());
        String donorType = inputDonorType(donorCategory, currentDonor.getDonorType());
        String donorPhoneNo = inputDonorPhoneNo(currentDonor.getPhoneNo());
        String donorEmail = inputDonorEmail(currentDonor.getEmail());
        String donorDOB = inputDonorDOB(currentDonor.getDob());
        return new Donor(donorName, donorType, donorCategory, donorPhoneNo, donorEmail, donorDOB);
    }

    public String inputDonorName(String currentName) {
        String name;
        while (true) {
            System.out.print("Enter Donor Name (or type 'skip' to retain current name): ");
            name = scanner.nextLine().trim();

            if (name.equalsIgnoreCase("skip")) {
                name = currentName; // Retain the current name
                break;
            } else if (name.matches("[a-zA-Z ]+")) {
                break; // Valid name entered
            } else {
                System.out.println("Invalid name. Please enter a name with only letters and spaces.");
            }
        }
        return name;
    }

    public String inputDonorName() {
        String name;
        while (true) {
            System.out.print("Enter Donor Name: ");
            name = scanner.nextLine();

            if (name.matches("[a-zA-Z ]+")) {
                break;
            } else {
                System.out.println("Invalid name. Please enter a name with only letters and spaces.");
            }
        }
        return name;
    }

    public String inputDonorID() {
        String id;
        while (true) {
            System.out.print("Enter Donor ID (format DR####): ");
            id = scanner.nextLine().trim();

            // Validate the donor ID
            if (validateDonorID(id)) {
                break; // Valid ID, exit the loop
            } else {
                System.out.println("Invalid ID. Please enter an ID in the format DR#### where #### is exactly 4 digits.");
            }
        }
        return id;
    }

    // Method to validate the donor ID
    private boolean validateDonorID(String id) {
        // Regular expression to match "DR" followed by exactly 4 digits
        return id.matches("^DR\\d{4}$");
    }

    public String inputDonorType(String donorCategory) {
        String donorType = "";
        int choice = -1;

        // Display options based on the donor category
        switch (donorCategory) {
            case "Public":
                System.out.println("Select Donor Type:");
                System.out.println("1. Government");
                System.out.println("2. Foundation");

                while (true) {
                    System.out.print("Enter the number corresponding to the Donor Type: ");
                    if (scanner.hasNextInt()) {
                        choice = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character

                        switch (choice) {
                            case 1:
                                donorType = "Government";
                                break;
                            case 2:
                                donorType = "Foundation";
                                break;
                            default:
                                System.out.println("Invalid selection. Please choose 1 for Government or 2 for Foundation.");
                                continue; // Continue the loop if the input is invalid
                        }
                        break; // Exit the loop if a valid choice is made
                    } else {
                        System.out.println("Invalid input. Please enter a number.");
                        scanner.nextLine(); // Clear invalid input
                    }
                }
                break;

            case "Private":
                System.out.println("Select Donor Type:");
                System.out.println("1. Individual");
                System.out.println("2. Organization");

                while (true) {
                    System.out.print("Enter the number corresponding to the Donor Type: ");
                    if (scanner.hasNextInt()) {
                        choice = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character

                        switch (choice) {
                            case 1:
                                donorType = "Individual";
                                break;
                            case 2:
                                donorType = "Organization";
                                break;
                            default:
                                System.out.println("Invalid selection. Please choose 1 for Individual or 2 for Organization.");
                                continue; // Continue the loop if the input is invalid
                        }
                        break; // Exit the loop if a valid choice is made
                    } else {
                        System.out.println("Invalid input. Please enter a number.");
                        scanner.nextLine(); // Clear invalid input
                    }
                }
                break;

            default:
                System.out.println("Invalid Donor Category.");
                break;
        }

        return donorType;
    }

    public String inputDonorType(String donorCategory, String currentType) {
        String donorType = "";
        int choice = -1;

        // Display options based on the donor category
        switch (donorCategory) {
            case "Public":
                System.out.println("Select Donor Type (or type 'skip' to retain current type):");
                System.out.println("1. Government");
                System.out.println("2. Foundation");

                while (true) {
                    System.out.print("Enter the number corresponding to the Donor Type: ");
                    String input = scanner.nextLine().trim();

                    if (input.equalsIgnoreCase("skip")) {
                        donorType = currentType; // Retain the current type
                        break;
                    } else if (input.matches("\\d+")) { // Check if input is a number
                        choice = Integer.parseInt(input);

                        switch (choice) {
                            case 1:
                                donorType = "Government";
                                break;
                            case 2:
                                donorType = "Foundation";
                                break;
                            default:
                                System.out.println("Invalid selection. Please choose 1 for Government or 2 for Foundation.");
                                continue; // Continue the loop if the input is invalid
                        }
                        break; // Exit the loop if a valid choice is made
                    } else {
                        System.out.println("Invalid input. Please enter a number or 'skip'.");
                    }
                }
                break;

            case "Private":
                System.out.println("Select Donor Type (or type 'skip' to retain current type):");
                System.out.println("1. Individual");
                System.out.println("2. Organization");

                while (true) {
                    System.out.print("Enter the number corresponding to the Donor Type: ");
                    String input = scanner.nextLine().trim();

                    if (input.equalsIgnoreCase("skip")) {
                        donorType = currentType; // Retain the current type
                        break;
                    } else if (input.matches("\\d+")) { // Check if input is a number
                        choice = Integer.parseInt(input);

                        switch (choice) {
                            case 1:
                                donorType = "Individual";
                                break;
                            case 2:
                                donorType = "Organization";
                                break;
                            default:
                                System.out.println("Invalid selection. Please choose 1 for Individual or 2 for Organization.");
                                continue; // Continue the loop if the input is invalid
                        }
                        break; // Exit the loop if a valid choice is made
                    } else {
                        System.out.println("Invalid input. Please enter a number or 'skip'.");
                    }
                }
                break;

            default:
                System.out.println("Invalid Donor Category.");
                break;
        }

        return donorType;
    }

    public String inputDonorCategory(String currentCategory) {
        String donorCategory = "";
        int choice = -1;

        while (true) {
            System.out.println("Select Donor Category (or type 'skip' to retain current category):");
            System.out.println("1. Private");
            System.out.println("2. Public");

            System.out.print("Enter the number corresponding to the Donor Category: ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("skip")) {
                donorCategory = currentCategory; // Retain the current category
                break;
            } else if (input.matches("\\d+")) { // Check if input is a number
                choice = Integer.parseInt(input);

                switch (choice) {
                    case 1:
                        donorCategory = "Private";
                        break;
                    case 2:
                        donorCategory = "Public";
                        break;
                    default:
                        System.out.println("Invalid selection. Please choose 1 for Private or 2 for Public.");
                        continue; // Continue the loop if the input is invalid
                }
                break; // Exit the loop if a valid choice is made
            } else {
                System.out.println("Invalid input. Please enter a number or 'skip'.");
            }
        }

        return donorCategory;
    }

    public String inputDonorCategory() {
        String donorCategory = "";
        int choice = -1;

        while (true) {
            System.out.println("Select Donor Category:");
            System.out.println("1. Private");
            System.out.println("2. Public");

            System.out.print("Enter the number corresponding to the Donor Category: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1:
                        donorCategory = "Private";
                        break;
                    case 2:
                        donorCategory = "Public";
                        break;
                    default:
                        System.out.println("Invalid selection. Please choose 1 for Private or 2 for Public.");
                        continue; // Continue the loop if the input is invalid
                }
                break; // Exit the loop if a valid choice is made
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear invalid input
            }
        }

        return donorCategory;
    }

    public String inputDonorPhoneNo() {
        String phoneNo = "";

        while (true) {
            System.out.print("Enter Donor Phone No: ");
            phoneNo = scanner.nextLine();

            // Validate phone number
            if (validatePhoneNo(phoneNo)) {
                break; // Valid phone number, exit the loop
            } else {
                System.out.println("Invalid phone number. Please enter a valid phone number.");
            }
        }

        return phoneNo;
    }

    private boolean validatePhoneNo(String phoneNo) {
        // Check if the phone number contains only digits or starts with a plus followed by digits
        if (phoneNo.matches("\\+?[0-9]{10,15}")) {
            return true; // Phone number is valid
        } else {
            return false; // Phone number is invalid
        }
    }

    public String inputDonorPhoneNo(String currentPhoneNo) {
        String phoneNo = "";

        while (true) {
            System.out.print("Enter Donor Phone No (or type 'skip' to retain current number): ");
            phoneNo = scanner.nextLine().trim();

            if (phoneNo.equalsIgnoreCase("skip")) {
                phoneNo = currentPhoneNo; // Retain the current phone number
                break;
            } else if (validatePhoneNo(phoneNo)) {
                break; // Valid phone number, exit the loop
            } else {
                System.out.println("Invalid phone number. Please enter a valid phone number.");
            }
        }

        return phoneNo;
    }

    public String inputDonorEmail(String currentEmail) {
        String email = "";

        while (true) {
            System.out.print("Enter Donor Email (or type 'skip' to retain current email): ");
            email = scanner.nextLine().trim();

            if (email.equalsIgnoreCase("skip")) {
                email = currentEmail; // Retain the current email
                break;
            } else if (validateEmail(email)) {
                break; // Valid email, exit the loop
            } else {
                System.out.println("Invalid email address. Please enter a valid email.");
            }
        }

        return email;
    }

    public String inputDonorEmail() {
        String email = "";

        while (true) {
            System.out.print("Enter Donor Email: ");
            email = scanner.nextLine();

            // Validate email address
            if (validateEmail(email)) {
                break; // Valid email, exit the loop
            } else {
                System.out.println("Invalid email address. Please enter a valid email.");
            }
        }

        return email;
    }

    // Method to validate the email address
    private boolean validateEmail(String email) {
        // Regular expression to validate email address
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return email.matches(emailRegex);
    }

    public String inputDonorDOB(String currentDOB) {
        String dob = "";

        while (true) {
            System.out.print("Enter Donor DOB (DD/MM/YYYY) (or type 'skip' to retain current DOB): ");
            dob = scanner.nextLine().trim();

            if (dob.equalsIgnoreCase("skip")) {
                dob = currentDOB; // Retain the current DOB
                break;
            } else if (validateDOB(dob)) {
                break; // Valid DOB, exit the loop
            } else {
                System.out.println("Invalid date of birth. Please enter in the format DD/MM/YYYY with numbers only.");
            }
        }

        return dob;
    }

    public String inputDonorDOB() {
        String dob = "";
        while (true) {
            System.out.print("Enter Donor DOB (DD/MM/YYYY): ");
            dob = scanner.nextLine();

            // Validate date of birth
            if (validateDOB(dob)) {
                break; // Valid DOB, exit the loop
            } else {
                System.out.println("Invalid date of birth. Please enter in the format DD/MM/YYYY with numbers only.");
            }
        }
        return dob;
    }

    public String inputSearchDonor() {
        String searchInput = "";
        while (true) {
            System.out.print("Enter Name or ID To Search:");
            searchInput = scanner.nextLine();

            if (searchInput.matches("[a-zA-Z ]+") || validateDonorID(searchInput)) {
                break;
            }
            System.out.println("Invalid Input Enter Again.");
        }
        return searchInput;
    }

    public String inputRemoveDonor() {
        String removeInput = "";
        while (true) {
            System.out.print("Enter Name or ID To Remove:");
            removeInput = scanner.nextLine();

            if (removeInput.matches("[a-zA-Z ]+") || validateDonorID(removeInput)) {
                break;
            }
            System.out.println("Invalid Input Enter Again.");
        }
        return removeInput;
    }

    public String inputUpdateDonor() {
        String removeInput = "";
        while (true) {
            System.out.print("Enter Name or ID To Update:");
            removeInput = scanner.nextLine();

            if (removeInput.matches("[a-zA-Z ]+") || validateDonorID(removeInput)) {
                break;
            }
            System.out.println("Invalid Input Enter Again.");
        }
        return removeInput;
    }

    public boolean confirmRemoveAction(String type, String input) {
        while (true) {
            System.out.print("Are you sure you want to remove the donor with " + type + " '" + input + "'? (yes/no): ");
            String confirmation = scanner.nextLine().trim().toLowerCase();

            if (confirmation.equals("yes") || confirmation.equals("y")) {
                return true; // User confirmed the action
            } else if (confirmation.equals("no") || confirmation.equals("n")) {
                return false; // User canceled the action
            } else {
                System.out.println("Invalid input. Please enter 'yes', 'y', 'no', or 'n'.");
            }
        }
    }

    // Method to validate the date of birth
    private boolean validateDOB(String dob) {
        // Regular expression to match DD/MM/YYYY format with numbers only
        String dobRegex = "^\\d{2}/\\d{2}/\\d{4}$";

        if (dob.matches(dobRegex)) {
            // Split the date into day, month, and year
            String[] parts = dob.split("/");
            int day = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]);
            int year = Integer.parseInt(parts[2]);

            // Check if the date is valid
            return isValidDate(day, month, year);
        } else {
            return false;
        }
    }

    // Method to check if the date is valid
    private boolean isValidDate(int day, int month, int year) {
        if (year < 1900 || year > 2100) {
            return false; // Year out of range
        }
        if (month < 1 || month > 12) {
            return false; // Month out of range
        }
        int[] daysInMonth = {31, (isLeapYear(year) ? 29 : 28), 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (day < 1 || day > daysInMonth[month - 1]) {
            return false; // Day out of range for the month
        }
        return true;
    }

    // Method to check if a year is a leap year
    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public void removeDonorIdSuccessfully(String idInput) {
        System.out.println("Donor with ID " + idInput + " has been removed.");
    }

    public void removeDonorNameSuccessfully(String nameInput) {
        System.out.println("Donor with Name " + nameInput + " has been removed.");
    }

    public int filterDonorMenu() {
        System.out.println("\nFilter Donor Menu");
        System.out.println("1. Filter by ID");
        System.out.println("2. Filter by Name");
        System.out.println("3. Filter by Category");
        System.out.println("4. Filter by Type");
        System.out.println("5. Filter by Phone Number");
        System.out.println("6. Filter by Email");
        System.out.println("7. Filter by Date of Birth");
        System.out.print("Enter your choice: ");

        int choice = -1;
        if (scanner.hasNextInt()) {
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline
        } else {
            scanner.nextLine(); // Consume the invalid input
        }
        return choice;
    }

    public void displayDonorSummaryReport(int totalDonors, double totalDonations, String[] donorTypes, double[] typeTotals) {
        // Print header
        System.out.println("Donor Summary Report");
        System.out.println("====================");

        // Print total donors and donations
        System.out.println("Total Donors: " + totalDonors);
        System.out.println("Total Donations: $" + String.format("%.2f", totalDonations));

        // Print donations by donor type
        System.out.println("\nDonations by Donor Type");
        System.out.println("========================");
        for (int i = 0; i < donorTypes.length; i++) {
            System.out.printf("%-20s $%.2f\n", donorTypes[i], typeTotals[i]);
        }
    }

    public boolean confirmAddAction() {
        System.out.print("Are you sure you want to add this donor? (yes/no): ");
        String input = scanner.nextLine().trim().toLowerCase();

        switch (input) {
            case "yes":
            case "y":
                return true;
            case "no":
            case "n":
                return false;
            default:
                System.out.println("Invalid input. Please enter 'yes', 'y', 'no', or 'n'.");
                return confirmAddAction(); // Re-prompt for confirmation
        }
    }

    public String inputFilterDonorID() {
        String start, end;

        do {
            System.out.println("Enter a range of Donor IDs to filter");
            System.out.println("===================================");
            System.out.print("Start From: ");
            start = scanner.nextLine().trim();
            if (!validateDonorID(start)) {
                System.out.println("Invalid Donor ID format. Please use the format DRXXXX (e.g., DR0001).");
            }
        } while (!validateDonorID(start));

        do {
            System.out.print("End To: ");
            end = scanner.nextLine().trim();
            if (!validateDonorID(end)) {
                System.out.println("Invalid Donor ID format. Please use the format DRXXXX (e.g., DR0001).");
            }
        } while (!validateDonorID(end));

        return start + "-" + end;
    }

    public int inputFilterNameOption() {
        System.out.println("Choose filtering option:");
        System.out.println("1. Starts with");
        System.out.println("2. Ends with");
        System.out.println("3. Contains");

        int option = -1;
        while (true) {
            System.out.print("Enter your choice (1/2/3): ");
            if (scanner.hasNextInt()) {
                option = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
                if (option >= 1 && option <= 3) {
                    return option;
                } else {
                    System.out.println("Invalid option. Please choose 1, 2, or 3.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear invalid input
            }
        }
    }

    public String inputFilterDonorName(int option) {
        switch (option) {
            case 1: // Starts with
                System.out.print("Enter The Starting Name: ");
                break;
            case 2: // Ends with
                System.out.println("Enter The Ending Name: ");
                break;
            case 3: // Contains
                System.out.println("Enter The Substring To Contain: ");
                break;
        }
        return scanner.nextLine().trim(); 
    }

public String inputFilterDonorCategory() {
        String donorCategory = "";
        int choice = -1;

        while (true) {
            System.out.println("Select Donor Category to filter by:");
            System.out.println("1. Public");
            System.out.println("2. Private");

            System.out.print("Enter the number corresponding to the Donor Category: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1:
                        donorCategory = "Public";
                        break;
                    case 2:
                        donorCategory = "Private";
                        break;
                    default:
                        System.out.println("Invalid selection. Please choose 1 for Private or 2 for Public.");
                        continue; // Continue the loop if the input is invalid
                }
                break; // Exit the loop if a valid choice is made
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear invalid input
            }
        }

        return donorCategory;
    }
    public String inputFilterDonorType() {
        System.out.print("Enter Donor Type to filter by (e.g., Government, Private, Organization): ");
        return scanner.nextLine().trim(); // Read and return the input type
    }

    public String inputFilterDonorPhoneNo() {
        System.out.print("Enter Donor Type to filter by (e.g., Government, Private, Organization): ");
        return scanner.nextLine().trim(); // Read and return the input type
    }

    public String inputFilterDonorEmail() {
        System.out.print("Enter Donor Type to filter by (e.g., Government, Private, Organization): ");
        return scanner.nextLine().trim(); // Read and return the input type
    }

    public String inputFilterDonorDOB() {
        System.out.print("Enter Donor Type to filter by (e.g., Government, Private, Organization): ");
        return scanner.nextLine().trim(); // Read and return the input type
    }
}
