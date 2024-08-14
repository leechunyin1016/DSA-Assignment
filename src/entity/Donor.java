/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author LEE CHUN YIN
 */
public class Donor implements Comparable<Donor> {

    private static int idCounter = 1;
    private String donorId;
    private String donorName;
    private String donorType;
//    private String phoneNo;
//    private String email;           
//    private String dob;
//    private int totalNumberOfDonation;
//    private String lastDonationDate;

    public Donor() {
        this.donorId = generateDonorId();
        this.donorName = "";
        this.donorType = "";
//        this.phoneNo = "";
//        this.email = "";
//        this.dob = "";
//        this.totalNumberOfDonation = 0;
//        this.lastDonationDate = null;
    }

    public Donor(String name, String donorType){// String phoneNo, String email, String dob, int totalNumberOfDonation, String lastDonationDate) {
        this.donorId = generateDonorId();
        this.donorName = name;
        this.donorType = donorType;
//        this.phoneNo = phoneNo;
//        this.email = email;
//        this.dob = dob;
//        this.totalNumberOfDonation = totalNumberOfDonation;
//        this.lastDonationDate = lastDonationDate;

    }

    private static String generateDonorId() {
        String id = String.format("D%04d", idCounter);
        idCounter++;
        return id;
    }

    public static void setIdCounter(int idCounter) {
        Donor.idCounter = idCounter;
    }

    public void setDonorId(String donorId) {
        this.donorId = donorId;
    }

    public void setDonorName(String donorName) {
        this.donorName = donorName;
    }

    public void setDonorType(String donorType) {
        this.donorType = donorType;
    }

//    public void setPhoneNo(String phoneNo) {
//        this.phoneNo = phoneNo;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public void setDob(String dob) {
//        this.dob = dob;
//    }
//
//    public void setTotalNumberOfDonation(int totalNumberOfDonation) {
//        this.totalNumberOfDonation = totalNumberOfDonation;
//    }
//
//    public void setLastDonationDate(String lastDonationDate) {
//        this.lastDonationDate = lastDonationDate;
//    }

    public static int getIdCounter() {
        return idCounter;
    }

    public String getDonorId() {
        return donorId;
    }

    public String getDonorName() {
        return donorName;
    }

    public String getDonorType() {
        return donorType;
    }

//    public String getPhoneNo() {
//        return phoneNo;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public String getDob() {
//        return dob;
//    }
//
//    public int getTotalNumberOfDonation() {
//        return totalNumberOfDonation;
//    }
//
//    public String getLastDonationDate() {
//        return lastDonationDate;
//    }

    @Override
    public int compareTo(Donor other) {
        return this.donorName.compareTo(other.donorName);
    }
    
    

//    @Override
//    public String toString() {
//        return "donorId=" + donorId + ", donorName=" + donorName + ", donorType=" + donorType + ", phoneNo=" + phoneNo + ", email=" + email + ", dob=" + dob + ", totalNumberOfDonation=" + totalNumberOfDonation + ", lastDonationDate=" + lastDonationDate;
//    }

    @Override
    public String toString() {
        return "Donor{" + "donorId=" + donorId + ", donorName=" + donorName + ", donorType=" + donorType + '}';
    }

}
