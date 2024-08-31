package dao;

import adt.SortedDoublyLinkedList;
import adt.SortedDoublyLinkedListInterface;
import entity.Donor;
import entity.Donation;

public class DonorInitializer {

    // Method to return a collection with hard-coded entity values
    public SortedDoublyLinkedListInterface<Donor> initializeDonors() {
        SortedDoublyLinkedListInterface<Donor> dList = new SortedDoublyLinkedList<>();

        dList.add(createDonor("Alice Smith", "Individual", "Private","555-1001", "alice.smith@example.com", "01/01/1975", new Donation[] {
            new Donation("D1001", "Books", 5, "Alice Smith", "2024/08/01"), // Example date as String
            new Donation("D1002", "Toys", 10, "Alice Smith", "2024/08/01") // Example date as String
        }));

        dList.add(createDonor("Bob Johnson", "Corporate","Private", "555-1002", "bob.johnson@example.com", "02/14/1980", new Donation[] {
            new Donation("D1003", "Books", 5, "Bob Johnson", "2024/08/01"), // Example date as String
            new Donation("D1004", "Toys", 10, "Bob Johnson", "2024/08/01")
        }));

        dList.add(createDonor("Charlie Brown", "Individual","Private", "555-1003", "charlie.brown@example.com", "03/22/1965", new Donation[] {
            new Donation("D1005", "Books",10,"Charlie Brown", "2011-09-21") // Example date as String
        }));

        dList.add(createDonor("Diana Prince", "Government","Public", "555-1004", "diana.prince@example.com", "04/30/1970", new Donation[] {
            new Donation("D1003", "Books", 5, "Diana Prince", "2024/08/01"), // Example date as String
            new Donation("D1003", "Toys", 5, "Diana Prince", "2024/08/01"), // Example date as String
        }));

        return dList;
    }

    private Donor createDonor(String name, String donorType,String donorCategory, String phoneNo, String email, String dob, Donation[] donations) {
        SortedDoublyLinkedListInterface<Donation> donationList = new SortedDoublyLinkedList<>();
        for (Donation donation : donations) {
            donationList.add(donation);
        }
        return new Donor(name, donorType,donorCategory, phoneNo, email, dob, donationList);
    }
}
