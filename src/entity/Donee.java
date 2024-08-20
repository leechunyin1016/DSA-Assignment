/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;
import java.time.LocalDate;
import java.time.Period;
/**
 *
 * @author Dephnie
 */
public class Donee implements Comparable<Donee>{
    private String doneeID;
    private String doneeName;
    private String doneeContact;
    private String doneeAddress;
    private String priorityLevel;
    private String donationReceived;
    private LocalDate dateOfBirth;
    private LocalDate lastDonationReceivedDate;
    private static int idCounter = 0;
    private int doneeAge;
    private int householdSize;
    private double doneeIncome;
    private char doneeGender;
    private char doneeType;
    private char eligibility;

    public Donee(String doneeName, String doneeContact, String doneeAddress, String donationReceived, LocalDate dateOfBirth, LocalDate lastDonationReceivedDate, int householdSize, double doneeIncome, char doneeGender, char doneeType, char eligibility) {
        this.doneeID = generateDoneeID();
        this.doneeName = doneeName;
        this.doneeContact = doneeContact;
        this.doneeAddress = doneeAddress;
        this.donationReceived = donationReceived;
        this.dateOfBirth = dateOfBirth;
        this.lastDonationReceivedDate = lastDonationReceivedDate;
        this.householdSize = householdSize;
        this.doneeIncome = doneeIncome;
        this.doneeGender = doneeGender;
        this.doneeType = doneeType;
        this.eligibility = eligibility;
        this.doneeAge = calculateAge();
        setDeterminePriorityLevel(); // Set priority level based on doneeIncome and doneeType
    }
    
    public int getDoneeAge() {
        return doneeAge;
    }

    public String getDoneeID() {
        return doneeID;
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

    public String getPriorityLevel() {
        return priorityLevel;
    }

    public String getDonationReceived() {
        return donationReceived;
    }

    public void setDonationReceived(String donationReceived) {
        this.donationReceived = donationReceived;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        this.doneeAge = calculateAge();//update age when the dog changes
    }

    public LocalDate getLastDonationReceivedDate() {
        return lastDonationReceivedDate;
    }

    public void setLastDonationReceivedDate(LocalDate lastDonationReceivedDate) {
        this.lastDonationReceivedDate = lastDonationReceivedDate;
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

    public char getEligibility() {
        return eligibility;
    }

    public void setEligibility(char eligibility) {
        this.eligibility = eligibility;
    }
    
    private static synchronized String generateDoneeID(){
        idCounter++;
        return String.format("DN%04d", idCounter);
    }
    
    public void setDeterminePriorityLevel(){
        switch(doneeType){
            case 'O': //organization
            if(doneeIncome < 1000000){ //RM1 million
                priorityLevel = "Low Priority";
            }else if(doneeIncome > 10000000 ){ //RM10 million
                priorityLevel = "High Priority";
            }else{
                priorityLevel = "Medium Priority";
            }
            break;
            
            case 'F': //family
            if(doneeIncome < 4000){
                priorityLevel = "Low Priority";
            }else if(doneeIncome > 10000 ){ 
                priorityLevel = "High Priority";
            }else{
                priorityLevel = "Medium Priority";
            } 
            break;
            
            case 'I': //individual
            if(doneeIncome < 2000){ 
                priorityLevel = "Low Priority";
            }else if(doneeIncome > 6000 ){ 
                priorityLevel = "High Priority";
            }else{
                priorityLevel = "Medium Priority";
            } 
            break;   
        }
    }
    
    private int calculateAge(){
        if(dateOfBirth == null){
            throw new IllegalArgumentException("Date Of Birth cannot be null");
        }
        LocalDate today = LocalDate.now();
        return Period.between(dateOfBirth, today).getYears();
    }
    
    @Override
    public int compareTo(Donee other) {
        // Example: Compare based on priority level or doneeID
        return this.doneeID.compareTo(other.getDoneeID());
    }
    
}
