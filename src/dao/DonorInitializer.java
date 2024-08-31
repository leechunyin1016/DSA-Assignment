package dao;

import adt.SortedDoublyLinkedList;
import adt.SortedDoublyLinkedListInterface;
import entity.Donor;
import entity.Donation;

public class DonorInitializer {

    // Method to return a collection with hard-coded entity values
    public SortedDoublyLinkedListInterface<Donor> initializeDonors() {
        SortedDoublyLinkedListInterface<Donor> dList = new SortedDoublyLinkedList<>();

        dList.add(createDonor("Alice Smith", "Individual", "555-1001", "alice.smith@example.com", "01/01/1975", new Donation[] {
            new Donation("Books", 150.0, "2009-02-14"), // Example date as String
            new Donation("Toys", 75.0, "2010-01-01") // Example date as String
        }));

        dList.add(createDonor("Bob Johnson", "Corporate", "555-1002", "bob.johnson@example.com", "02/14/1980", new Donation[] {
            new Donation("Food", 500.0, "2010-09-10") // Example date as String
        }));

        dList.add(createDonor("Charlie Brown", "Foundation", "555-1003", "charlie.brown@example.com", "03/22/1965", new Donation[] {
            new Donation("Medical Supplies", 1000.0, "2011-09-21") // Example date as String
        }));

        dList.add(createDonor("Diana Prince", "Government", "555-1004", "diana.prince@example.com", "04/30/1970", new Donation[] {
            new Donation("Construction Materials", 2000.0, "2013-01-01"), // Example date as String
            new Donation("Books", 300.0, "2014-01-01") // Example date as String
        }));

        dList.add(createDonor("Evan Stone", "Individual", "555-1005", "evan.stone@example.com", "05/15/1985", new Donation[] {
            new Donation("Clothing", 250.0, "2015-06-15") // Example date as String
        }));

        dList.add(createDonor("Fiona Green", "Corporate", "555-1006", "fiona.green@example.com", "06/25/1990", new Donation[] {
            new Donation("Electronics", 750.0, "2015-11-25") // Example date as String
        }));

        dList.add(createDonor("George White", "Foundation", "555-1007", "george.white@example.com", "07/10/1955", new Donation[] {
            new Donation("Educational Materials", 1200.0, "2016-08-30") // Example date as String
        }));

        dList.add(createDonor("Hannah Black", "Government", "555-1008", "hannah.black@example.com", "08/20/1960", new Donation[] {
            new Donation("Food", 800.0, "2017-09-10"), // Example date as String
            new Donation("Medical Supplies", 400.0, "2018-01-15") // Example date as String
        }));

        dList.add(createDonor("Ian Grey", "Individual", "555-1009", "ian.grey@example.com", "09/30/1975", new Donation[] {
            new Donation("Furniture", 500.0, "2019-03-20") // Example date as String
        }));

        dList.add(createDonor("Jane Doe", "Corporate", "555-1010", "jane.doe@example.com", "10/05/1980", new Donation[] {
            new Donation("Toys", 400.0, "2020-02-14") // Example date as String
        }));

        return dList;
    }

    private Donor createDonor(String name, String donorType, String phoneNo, String email, String dob, Donation[] donations) {
        SortedDoublyLinkedListInterface<Donation> donationList = new SortedDoublyLinkedList<>();
        for (Donation donation : donations) {
            donationList.add(donation);
        }
        return new Donor(name, donorType, phoneNo, email, dob, donationList);
    }
}
