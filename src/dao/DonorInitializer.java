package dao;

import adt.SortedDoublyLinkedList;
import adt.SortedDoublyLinkedListInterface;
import entity.Donor;
import entity.Donation;

public class DonorInitializer {

   

    public SortedDoublyLinkedListInterface<Donor> initializeDonors() {
        SortedDoublyLinkedListInterface<Donor> dList = new SortedDoublyLinkedList<>();

        dList.add(createDonor("Alice Smith", "Individual", "Private", "555-1001", "alice.smith@example.com", "01/10/1975", new Donation[]{
            new Donation("D1001", "Books", 5, "Alice Smith", "2024/08/01"),
            new Donation("D1002", "Toys", 10, "Alice Smith", "2024/08/01")
        }));

        dList.add(createDonor("Bob Johnson", "Organization", "Private", "555-1002", "bob.johnson@example.com", "02/01/1980", new Donation[]{
            new Donation("D1003", "Books", 5, "Bob Johnson", "2024/08/01"),
            new Donation("D1004", "Toys", 10, "Bob Johnson", "2024/08/01")
        }));

        dList.add(createDonor("Charlie Brown", "Individual", "Private", "555-1003", "charlie.brown@example.com", "03/12/1965", new Donation[]{
            new Donation("D1005", "Books", 10, "Charlie Brown", "2011-09-21")
        }));

        dList.add(createDonor("Diana Prince", "Government", "Public", "555-1004", "diana.prince@example.com", "04/07/1970", new Donation[]{
            new Donation("D1006", "Books", 5, "Diana Prince", "2024/08/01"),
            new Donation("D1007", "Toys", 5, "Diana Prince", "2024/08/01")
        }));

        // Additional dummy data
        String[] names = {"John Doe", "Jane Roe", "Mark Twain", "Emily Davis", "Michael Scott", "Pam Beesly", "Jim Halpert", "Dwight Schrute", "Angela Martin", "Oscar Martinez"};
        String[] types = {"Individual", "Organization", "Foundation", "Government"};
        String[] categories = {"Private", "Public"};
        String[] phoneNumbers = {"555-2001", "555-2002", "555-2003", "555-2004", "555-2005", "555-2006", "555-2007", "555-2008", "555-2009", "555-2010"};
        String[] emails = {"john.doe@example.com", "jane.roe@example.com", "mark.twain@example.com", "emily.davis@example.com", "michael.scott@example.com", "pam.beesly@example.com", "jim.halpert@example.com", "dwight.schrute@example.com", "angela.martin@example.com", "oscar.martinez@example.com"};

        for (int i = 0; i < 90; i++) {
            String name = names[i % names.length];
            String type = types[i % types.length];
            String category = categories[i % categories.length];
            String phoneNumber = phoneNumbers[i % phoneNumbers.length];
            String email = emails[i % emails.length];
            String dob = String.format("%02d/%02d/%04d", (i % 31) + 1, (i % 12) + 1, 1950 + (i % 50));

            dList.add(createDonor(name, type, category, phoneNumber, email, dob, new Donation[]{
                new Donation("D" + (1000 + i), "Books", (i % 10) + 1, name, "2024/08/01"),
                new Donation("D" + (1001 + i), "Toys", (i % 10) + 1, name, "2024/08/01")
            }));
        }

        return dList;
    }

    private Donor createDonor(String name, String type, String category, String phone, String email, String dob, Donation[] donations) {
        SortedDoublyLinkedListInterface<Donation> donationList = new SortedDoublyLinkedList<>();
        for (Donation donation : donations) {
            donationList.add(donation);
        }
        return new Donor(name, type, category, phone, email, dob, donationList);
    }

}
