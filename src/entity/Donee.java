/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;
import java.util.Random;

/**
 *
 * @author Dephnie
 */
public class Donee implements Comparable<Donee> {

    private static final char ORGANIZATION_TYPE = 'O';
    private static final char FAMILY_TYPE = 'F';
    private static final char INDIVIDUAL_TYPE = 'I';

    private static final Random random = new Random();

    private String doneeID;
    private String doneeName;
    private String doneeContact;
    private String doneeAddress;
    private String priorityLvl;
    private LocalDate dateOfBirth;
    private static int idCounter = 0;
    private int doneeAge;
    private int householdSize;
    private double doneeIncome;
    private char doneeGender;
    private char doneeType;
    private boolean eligibility;

    public Donee(String doneeID, String doneeName, String doneeContact, String doneeAddress, LocalDate dateOfBirth, int doneeAge, int householdSize, String priorityLvl, double doneeIncome, char doneeGender, char doneeType, boolean eligibility) {
        this.doneeID = doneeID;
        this.doneeName = doneeName;
        this.doneeContact = doneeContact;
        this.doneeAddress = doneeAddress;
        this.dateOfBirth = dateOfBirth;
        this.doneeAge = doneeAge;
        this.householdSize = householdSize;
        this.priorityLvl = priorityLvl;
        this.doneeIncome = doneeIncome;
        this.doneeGender = doneeGender;
        this.doneeType = doneeType;
        this.eligibility = eligibility;
        setDeterminePriorityLevel();
    }

    // Constructor for searching by ID
    public Donee(String doneeID) {
        this.doneeID = doneeID;
    }

    public int getDoneeAge() {
        return doneeAge;
    }

    public String getDoneeID() {
        return doneeID;
    }

    public void setDoneeID(String doneeID) {
        this.doneeID = doneeID;
    }

    public String getDoneeName() {
        return doneeName;
    }

    public void setDoneeName(String doneeName) {
        this.doneeName = doneeName;
    }

    public String getDoneeContact() {
        return doneeContact;
    }

    public void setDoneeContact(String doneeContact) {
        this.doneeContact = doneeContact;
    }

    public String getDoneeAddress() {
        return doneeAddress;
    }

    public void setDoneeAddress(String doneeAddress) {
        this.doneeAddress = doneeAddress;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        this.doneeAge = calculateAge();//update age when the dof changes
    }

    public double getDoneeIncome() {
        return doneeIncome;
    }

    public void setDoneeIncome(double doneeIncome) {
        this.doneeIncome = doneeIncome;
        setDeterminePriorityLevel(); //update the prio lvl if income changes
    }

    public int getHouseholdSize() {
        return householdSize;
    }

    public void setHouseholdSize(int householdSize) {
        this.householdSize = householdSize;
    }

    public char getDoneeGender() {
        return doneeGender;
    }

    public void setDoneeGender(char doneeGender) {
        this.doneeGender = doneeGender;
    }

    public char getDoneeType() {
        return doneeType;
    }

    public void setDoneeType(char doneeType) {
        this.doneeType = doneeType;
    }

    public boolean isEligibility() {
        return eligibility;
    }

    public void setEligibility(boolean eligibility) {
        this.eligibility = eligibility;
    }

    public static synchronized String generateDoneeID() {
        int randomNum = random.nextInt(10000); 
        return String.format("DN%04d", randomNum); 
    }

    public String getPriorityLvl() {
        return priorityLvl;
    }

    private void setDeterminePriorityLevel() {
        switch (doneeType) {
            case 'O': // organization
                priorityLvl = doneeIncome > 10000000 ? "Low" : (doneeIncome < 1000000 ? "High" : "Medium");
                break;
            case 'F': // family
                priorityLvl = doneeIncome > 10000 ? "Low" : (doneeIncome < 4000 ? "High" : "Medium");
                break;
            case 'I': // individual
                priorityLvl = doneeIncome > 6000 ? "Low" : (doneeIncome < 2000 ? "High" : "Medium");
                break;
            default:
                priorityLvl = "Low";
        }
    }

    private int calculateAge() {
        if (dateOfBirth == null) {
            throw new IllegalArgumentException("Date Of Birth cannot be null");
        }
        LocalDate today = LocalDate.now();
        return Period.between(dateOfBirth, today).getYears();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Donee donee = (Donee) obj;
        return doneeID.equals(donee.doneeID);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.doneeID);
        return hash;
    }

    @Override
    public String toString() {
        return "Donee [doneeID=" + doneeID + ", doneeName=" + doneeName + ", doneeContact=" + doneeContact
                + ", doneeAddress=" + doneeAddress + ", priorityLevel=" + priorityLvl
                + ", dateOfBirth=" + dateOfBirth + ", doneeAge=" + doneeAge
                + ", householdSize=" + householdSize + ", doneeIncome=" + doneeIncome
                + ", doneeGender=" + doneeGender + ", doneeType=" + doneeType + ", eligibility=" + eligibility + "]";
    }

    @Override
    public int compareTo(Donee other) {
        return this.doneeID.compareTo(other.doneeID);
    }
}
