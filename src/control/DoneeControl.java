/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import adt.*;
import entity.*;
import boundary.DoneeManagementUI;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Dephnie
 */
public class DoneeControl {

    private SortedDoublyLinkedList<Donee> doneeList = new SortedDoublyLinkedList<>();
    private DoneeManagementUI doneeUI = new DoneeManagementUI();
    private SortedDoublyLinkedListInterface<Distribution> distributionList;

    // Constructor to initialize doneeList and distributionList
    public DoneeControl(SortedDoublyLinkedListInterface<Donee> doneeList, SortedDoublyLinkedListInterface<Distribution> distributionList) {
        this.doneeList = (SortedDoublyLinkedList<Donee>) doneeList;
        this.distributionList = distributionList;
    }

    public void runDoneeManagement() {

        Donee[] donees = new Donee[]{
            new Donee("DN0001", "Alice Smith", "0123456789", "123 Main St", LocalDate.of(1985, 8, 15), 39, 3, "HIGH", 3000.0, 'F', 'F', true),
            new Donee("DN0002", "Bob Johnson", "0987654321", "456 Oak St", LocalDate.of(1970, 4, 22), 54, 5, "LOW", 15000.0, 'M', 'I', true),
            new Donee("DN0003", "Charlie Brown", "0123987654", "789 Pine St", LocalDate.of(1995, 12, 30), 28, 2, "MEDIUM", 8000.0, 'M', 'F', true),
            new Donee("DN0004", "David Wilson", "0192837465", "101 Maple St", LocalDate.of(2000, 2, 14), 24, 3, "HIGH", 500.0, 'M', 'I', true),
            new Donee("DN0005", "Eve Davis", "0293847561", "202 Birch St", LocalDate.of(1960, 11, 5), 63, 1, "HIGH", 20000.0, 'F', 'O', true),
            new Donee("DN0006", "Frank Miller", "0319283746", "303 Cedar St", LocalDate.of(1990, 6, 25), 34, 5, "HIGH", 3500.0, 'M', 'F', true),
            new Donee("DN0007", "Grace Lee", "0419283746", "404 Elm St", LocalDate.of(1988, 9, 9), 36, 4, "MEDIUM", 6000.0, 'F', 'I', true),
            new Donee("DN0008", "Heidi Moore", "0519283746", "505 Fir St", LocalDate.of(1975, 1, 18), 49, 2, "HIGH", 45000.0, 'F', 'O', true),
            new Donee("DN0009", "Ivan Garcia", "0619283746", "606 Spruce St", LocalDate.of(1980, 3, 3), 44, 1, "MEDIUM", 9000.0, 'M', 'F', true),
            new Donee("DN0010", "Judy Thompson", "0719283746", "707 Redwood St", LocalDate.of(2005, 7, 21), 19, 2, "LOW", 7000.0, 'F', 'I', true)
        };

        for (Donee donee : donees) {
            doneeList.add(donee);
        }

        int option = 0;

        do {
            option = doneeUI.getDoneeMenu();
            switch (option) {
                case 0:
                    System.out.println("Exiting Donee Management...");
                    break;
                case 1:
                    addDonee();
                    break;
                case 2:
                    removeDonee();
                    break;
                case 3:
                    updateDonee();
                    break;
                case 4:
                    searchDonee();
                    break;
                case 5:
                    listDoneesWithDonations();
                    break;
                case 6:
                    filterDoneeDetails();
                    break;
                case 7:
                    generateDoneeReport();
                    break;
                default:
                    System.out.println("This is an invalid option!!!");

            }
        } while (option != 0);
    }

    public void addDonee() {
        Donee newDonee = doneeUI.inputDoneeDetails();
        boolean isConfirmed = doneeUI.askConfirmation("Are you sure you want to add the donee with ID " + newDonee.getDoneeID());

        if (isConfirmed) {
            doneeList.add(newDonee);
            doneeUI.listAllDonee(displayDonee());
            System.out.println("Donee added successfully!");
        } else {
            System.out.println("Addition cancelled. Returning to menu.");
        }
    }

    public void removeDonee() {
        String deleteDoneeID = doneeUI.inputDoneeID();
        Donee doneeToDelete = new Donee(deleteDoneeID);

        Donee foundDonee = doneeList.find(doneeToDelete);
        System.out.println("Found donee: " + foundDonee);

        if (foundDonee != null) {
            boolean isConfirmed = doneeUI.askConfirmation("Are you sure you want to delete the donee with ID " + deleteDoneeID);

            if (isConfirmed) {
                doneeList.remove(foundDonee);
                System.out.println("Donee with ID " + deleteDoneeID + " has been removed.");
            } else {
                System.out.println("Deletion cancelled. Returning to menu.");
            }
        } else {
            System.out.println("No donee found with ID " + deleteDoneeID);
        }
    }

    public void updateDonee() {
        String doneeID = doneeUI.inputDoneeID();
        Donee existingDonee = doneeList.find(new Donee(doneeID));

        if (existingDonee != null) {
            System.out.println("Current Donee Details:");
            doneeUI.displayDoneeDetails(existingDonee);

            boolean isConfirmed = doneeUI.askConfirmation("Do you want to update these details? (Y/N)");

            if (isConfirmed) {
                doneeUI.updateDoneeInfo(existingDonee);
                System.out.println("Donee updated successfully!");
            } else {
                System.out.println("Update cancelled. Returning to menu.");
            }
        } else {
            System.out.println("Donee with ID " + doneeID + " not found.");
        }
    }

    public void searchDonee() {
        String doneeID = doneeUI.inputDoneeID();
        Donee searchKey = new Donee(doneeID);

        Donee foundDonee = doneeList.find(searchKey);

        if (foundDonee != null) {
            doneeUI.displayDoneeDetails(foundDonee);
        } else {
            System.out.println("Donee with ID " + doneeID + " not found.");
        }
    }

    public void listDoneesWithDonations() {
        System.out.println("Listing Donees with All Donations Made:");
        System.out.println("==========================================================================================================================================================================");
        System.out.printf("| %-5s | %-20s | %-15s | %-30s | %-10s | %-10s | %-3s | %-8s | %-10s | %-6s | %-6s | %-11s |\n",
                "ID", "Name", "Contact", "Address", "Priority", "DOB", "Age", "H.Size", "Income", "Gender", "Type", "Eligibility");

        for (int i = 0; i < doneeList.size(); i++) {
            Donee donee = doneeList.getEntry(i);

            System.out.println("==========================================================================================================================================================================");
            System.out.printf("| %-5s | %-20s | %-15s | %-30s | %-10s | %-10s | %-3d | %-8d | %-10.2f | %-6s | %-6s | %-11s |\n",
                    donee.getDoneeID(),
                    donee.getDoneeName(),
                    donee.getDoneeContact(),
                    donee.getDoneeAddress(),
                    donee.getPriorityLvl(),
                    donee.getDateOfBirth(),
                    donee.getDoneeAge(),
                    donee.getHouseholdSize(),
                    donee.getDoneeIncome(),
                    donee.getDoneeGender(),
                    donee.getDoneeType(),
                    donee.isEligibility() ? "Yes" : "No");
            System.out.println("==========================================================================================================================================================================");

            boolean hasDistributions = false;
            System.out.printf("| %-15s | %-12s | %-20s | %-10s |\n", "Distribution ID", "Date", "Donor", "Status");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

            for (int j = 0; j < distributionList.size(); j++) {
                Distribution distribution = distributionList.getEntry(j);
                if (distribution.getDonee().equals(donee)) {
                    System.out.printf("| %-15s | %-12s | %-20s | %-10s |\n",
                            distribution.getDistributionId(),
                            distribution.getDistributionDate(),
                            distribution.getDonor().getDonorName(),
                            distribution.getDistributionStatus());
                    hasDistributions = true;
                }
            }

            if (!hasDistributions) {
                System.out.println("| No distributions found.                                                                                                                                              |");
            }

            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println();
        }

        System.out.println("================================================================================================================================================================================");

    }

    public void filterDoneeDetails() {
        int choice = 0;
        choice = doneeUI.filterDoneeType();
        char typeOfDonee;
        switch (choice) {
            case 0:
                System.out.println("Exiting to menu...");
                break;
            case 1:
                typeOfDonee = 'I';
                doneeUI.printFilteredList(filter(typeOfDonee));
                break;
            case 2:
                typeOfDonee = 'F';
                doneeUI.printFilteredList(filter(typeOfDonee));
                break;
            case 3:
                typeOfDonee = 'O';
                doneeUI.printFilteredList(filter(typeOfDonee));
                break;
        }
    }

    public void generateDoneeReport() {
        int highOrgCount = 0;
        int highFamilyCount = 0;
        int highIndividualCount = 0;

        for (int i = 0; i < doneeList.size(); i++) {
            Donee donee = doneeList.get(i);

            if ("HIGH".equals(donee.getPriorityLvl())) {
                switch (donee.getDoneeType()) {
                    case 'O': // Organization
                        highOrgCount++;
                        break;
                    case 'F': // Family
                        highFamilyCount++;
                        break;
                    case 'I': // Individual
                        highIndividualCount++;
                        break;
                }
            }
        }

        System.out.println("=========================================================================================================================");
        System.out.printf("KUALA LUMPUR CHARITY MANAGEMENT SYSTEM\n");
        System.out.printf("HIGH PRIORITY DONEES BY TYPE REPORT\n");
        System.out.println("=========================================================================================================================");
        System.out.println();
        System.out.println("Generated at: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("EEEE, MMMM dd yyyy, hh:mm a")));
        System.out.println("**************************************************************************************************************************");
        System.out.println();

        // Display the counts
        System.out.println("High Priority Donees by Type:");
        System.out.println("===============================");
        System.out.printf("Organization  : %d%n", highOrgCount);
        System.out.printf("Family        : %d%n", highFamilyCount);
        System.out.printf("Individual    : %d%n", highIndividualCount);
        System.out.println();

        System.out.println("Bar Chart Representation:");
        System.out.println("=========================");

        int maxCount = Math.max(highOrgCount, Math.max(highFamilyCount, highIndividualCount));

        //y-axis
        for (int i = maxCount; i > 0; i--) {
            System.out.printf("%2d | ", i);
            System.out.print((highOrgCount >= i) ? " * " : "   ");
            System.out.print("   ");
            System.out.print((highFamilyCount >= i) ? " * " : "   ");
            System.out.print("   ");
            System.out.print((highIndividualCount >= i) ? " * " : "   ");
            System.out.println();
        }

        //x-axis
        System.out.println("   +-----+-----+-----+---->");
        System.out.println("     Org   Fam   Ind");

        String highestType = " ";
        if (maxCount == highOrgCount) {
            highestType = "Organization";
        } else if (maxCount == highFamilyCount) {
            highestType = "Family";
        } else if (maxCount == highIndividualCount) {
            highestType = "Individual";
        }

        System.out.printf("The DoneeType with the highest number of Donees is: %s%n", highestType);
        System.out.printf("Number of Donees with type %s: %d%n", highestType, maxCount);
    }

    public String displayDonee() {
        String outputStr = "";
        // Table header
        System.out.println("List of Donee:");
        System.out.println("+------------+-----------------+--------------+----------------------+----------------+--------------+------------+----------------+--------------+------------+------------+--------------+");
        System.out.println("| doneeID    | doneeName       | doneeContact | doneeAddress         | priorityLevel  | dateOfBirth  | doneeAge   | householdSize  |      Income  |   Gender   | doneeType  | eligibility  |");
        System.out.println("+------------+-----------------+--------------+----------------------+----------------+--------------+------------+----------------+--------------+------------+------------+--------------+");

        for (int i = 0; i < doneeList.size(); i++) {
            Donee donee = doneeList.getEntry(i);
            System.out.printf(
                    "| %-10s | %-15s | %-12s | %-20s | %-14s | %-12s | %-10d | %-14d | %12.2f | %-10s | %-10s | %-12s |\n",
                    donee.getDoneeID(),
                    donee.getDoneeName(),
                    donee.getDoneeContact(),
                    donee.getDoneeAddress(),
                    donee.getPriorityLvl(),
                    donee.getDateOfBirth(),
                    donee.getDoneeAge(),
                    donee.getHouseholdSize(),
                    donee.getDoneeIncome(),
                    donee.getDoneeGender(),
                    donee.getDoneeType(),
                    donee.isEligibility() ? "Eligible" : "Not Eligible"
            );
        }

        System.out.println("+------------+-----------------+--------------+----------------------+----------------+--------------+------------+----------------+--------------+------------+------------+--------------+");
        System.out.println("+------------+----------------+--------------+----------------------+----------------+--------------+------------+----------------+--------------+------------+------------+--------------+");
        return outputStr;
    }

    public SortedDoublyLinkedListInterface<Donee> filter(char targetType) {
        SortedDoublyLinkedListInterface<Donee> filteredDoneeList = new SortedDoublyLinkedList<>();
        if (doneeList.isEmpty()) {
            return null;
        }

        for (int i = 0; i < doneeList.size(); i++) {
            Donee donee = doneeList.getEntry(i);
            if (doneeList.getEntry(i).getDoneeType() == targetType) {
                filteredDoneeList.add(donee);
            }
        }

        return filteredDoneeList;
    }

    public static void main(String[] args) {
        SortedDoublyLinkedListInterface<Donee> doneeList = new SortedDoublyLinkedList<>();
        SortedDoublyLinkedListInterface<Distribution> distributionList = new SortedDoublyLinkedList<>();
        DoneeControl doneeControl = new DoneeControl(doneeList, distributionList);
        doneeControl.runDoneeManagement();
    }

}
