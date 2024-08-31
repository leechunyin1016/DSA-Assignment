/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;

import adt.SortedDoublyLinkedListInterface;
import entity.Donee;
import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

/**
 *
 * @author Dephnie
 */
public class DoneeManagementUI {

    Scanner scanner = new Scanner(System.in);

    public int getDoneeMenu() {
        System.out.println("\nDONEE MAIN MENU");
        System.out.println("1. Add New Donee");
        System.out.println("2. Remove Donee");
        System.out.println("3. Update Donee Details");
        System.out.println("4. Search Donee Details");
        System.out.println("5. List All Donee List");
        System.out.println("6. Filter Donee Type");
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
    
    public boolean askConfirmation(String message) {
        System.out.print(message + " (Y/N): ");
        char confirmation = scanner.nextLine().toUpperCase().charAt(0);
        return confirmation == 'Y';
    }

    public void displayDoneeDetails(Donee donee) {
        if (donee != null) {
            System.out.println("Donee Details");
            System.out.println("==========================================");
            System.out.println("Donee ID: " + donee.getDoneeID());
            System.out.println("Type: " + donee.getDoneeType());
            System.out.println("Donee Name: " + donee.getDoneeName());
            System.out.println("Gender: " + donee.getDoneeGender());
            System.out.println("Age: " + donee.getDoneeAge());
            System.out.println("Date of Birth: " + donee.getDateOfBirth());
            System.out.println("Income:RM " + donee.getDoneeIncome());
            System.out.println("Contact: " + donee.getDoneeContact());
            System.out.println("Address: " + donee.getDoneeAddress());
            System.out.println("Household Size: " + donee.getHouseholdSize());
            System.out.println("Priority Level: " + donee.getPriorityLvl());
            System.out.println("Eligibility: " + donee.isEligibility());
            System.out.println();
        } else {
            System.out.println("Donee not Found ...");
        }
    }
    
    public int filterDoneeType(){
        System.out.println("Filter By:");
        System.out.println("1. Individual");
        System.out.println("2. Family");
        System.out.println("3. Organization");
        System.out.println("Select your choice:");
        
        int option = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        return option;
}

    public String inputDoneeID() {
        System.out.print("Enter Donee ID: ");
        String doneeID = scanner.nextLine().toUpperCase();
        return doneeID;
    }

    public Donee inputDoneeDetails() {
        System.out.println("Enter Donee Details:");

        // Automatically generate Donee ID
        String id = Donee.generateDoneeID();
        System.out.println("Donee ID: " + id);

        // Input details
        System.out.print("Name: ");
        String name = scanner.nextLine().toUpperCase(); 

        System.out.print("Contact: ");
        String contact = scanner.nextLine().toUpperCase(); 

        System.out.print("Address: ");
        String address = scanner.nextLine().toUpperCase(); 

        LocalDate dateOfBirth = null;
        while (dateOfBirth == null) {
            System.out.print("Date of Birth (YYYY-MM-DD): ");
            try {
                dateOfBirth = LocalDate.parse(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid date format. Please enter the date in YYYY-MM-DD format.");
            }
        }

        int householdSize = 0;
        while (householdSize <= 0) {
            System.out.print("Household Size: ");
            try {
                householdSize = Integer.parseInt(scanner.nextLine());
                if (householdSize <= 0) {
                    System.out.println("Household size must be a positive number.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }

        double income = 0;
        while (income <= 0) {
            System.out.print("Income: RM ");
            try {
                income = Double.parseDouble(scanner.nextLine());
                if (income <= 0) {
                    System.out.println("Income must be a positive number.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }

        char gender = '\0';
        while (gender != 'M' && gender != 'F') {
            System.out.print("Gender (Male - M / Female - F): ");
            gender = scanner.nextLine().toUpperCase().charAt(0);
            if (gender != 'M' && gender != 'F') {
                System.out.println("Invalid input. Please enter 'M' for Male or 'F' for Female.");
            }
        }

        char type = '\0';
        while (type != 'O' && type != 'F' && type != 'I') {
            System.out.print("Type (O - Organization, F - Family, I - Individual): ");
            type = scanner.nextLine().toUpperCase().charAt(0); 
            if (type != 'O' && type != 'F' && type != 'I') {
                System.out.println("Invalid input. Please enter 'O', 'F', or 'I'.");
            }
        }

        int doneeAge = Period.between(dateOfBirth, LocalDate.now()).getYears();

        Donee donee = new Donee(id, name, contact, address, dateOfBirth, doneeAge, householdSize, null, income, gender, type, false);
        donee.setEligibility(checkEligibility(donee));
        
        System.out.println("\nConfirm the Donee Details:");
        System.out.println("Donee ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Contact: " + contact);
        System.out.println("Address: " + address);
        System.out.println("Date of Birth: " + dateOfBirth);
        System.out.println("Household Size: " + householdSize);
        System.out.println("Income: RM " + income);
        System.out.println("Gender: " + (gender == 'M' ? "Male" : "Female"));
        System.out.println("Type: " + (type == 'O' ? "Organization" : type == 'F' ? "Family" : "Individual"));

        return donee;
    }

    public void updateDoneeInfo(Donee donee) {
        System.out.println("Update Donee Details:");
        System.out.println("==========================");

        System.out.print("Contact (" + donee.getDoneeContact() + "): ");
        String contact = scanner.nextLine();
        if (!contact.isEmpty()) {
            donee.setDoneeContact(contact);
        }

        System.out.print("Address (" + donee.getDoneeAddress() + "): ");
        String address = scanner.nextLine();
        if (!address.isEmpty()) {
            donee.setDoneeAddress(address);
        }

        System.out.print("Household Size (" + donee.getHouseholdSize() + "): ");
        String householdSizeInput = scanner.nextLine();
        if (!householdSizeInput.isEmpty()) {
            int householdSize = Integer.parseInt(householdSizeInput);
            donee.setHouseholdSize(householdSize);
        }

        System.out.print("Income (" + donee.getDoneeIncome() + "): RM ");
        String incomeInput = scanner.nextLine();
        if (!incomeInput.isEmpty()) {
            double income = Double.parseDouble(incomeInput);
            donee.setDoneeIncome(income);
        }

        System.out.print("Type (" + donee.getDoneeType() + ") (O - Organization, F - Family, I - Individual): ");
        String typeInput = scanner.nextLine();
        if (!typeInput.isEmpty()) {
            char type = typeInput.charAt(0);
            donee.setDoneeType(type);
        }

        donee.setEligibility(checkEligibility(donee));

        System.out.println("Donee details updated successfully!");
    }
    
 public void printFilteredList(SortedDoublyLinkedListInterface<Donee> doneeList) {
    // Print table header
    System.out.printf("%-6s %-20s %-12s %-15s %-10s \n", "ID", "Name", "Type", "Priority", "Income");
    System.out.println("--------------------------------------------------------------");

    for (int i = 0; i < doneeList.size(); i++) {
        Donee donee = doneeList.getEntry(i);
        System.out.printf("%-5s %-20s %-12s %-15s %-10.2f \n", 
                          donee.getDoneeID(), 
                          donee.getDoneeName(),
                          donee.getDoneeType(), 
                          donee.getPriorityLvl(), 
                          donee.getDoneeIncome());
    }
    System.out.println();
}


    private boolean checkEligibility(Donee donee) {
        return donee.getDoneeIncome() < 3000 && donee.getDoneeAge() > 18 && donee.getHouseholdSize() > 2; // Adjust this logic as needed
    }
}
