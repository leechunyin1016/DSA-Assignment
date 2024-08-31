/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import adt.SortedDoublyLinkedListInterface;
import adt.SortedDoublyLinkedList;

/**
 *
 * @author LEE CHUN YIN
 */
public class Donor implements Comparable<Donor> {

    private static int idCounter = 1;
    private String donorId;
    private String donorName;
    private String donorType;
    private String donorCategory;
    private String phoneNo;
    private String email;
    private String dob;
    private SortedDoublyLinkedListInterface<Donation> donations;

    public Donor() {
        this.donorId = generateDonorId();
        this.donorName = "";
        this.donorType = "";
        this.donorCategory = "";
        this.phoneNo = "";
        this.email = "";
        this.dob = "";
        this.donations = new SortedDoublyLinkedList<>();
    }

    public Donor(String name, String donorType, String donorCategory, String phoneNo, String email, String dob, SortedDoublyLinkedListInterface<Donation> donations) {
        this.donorId = generateDonorId();
        this.donorName = name;
        this.donorType = donorType;
        this.donorCategory = donorCategory;
        this.phoneNo = phoneNo;
        this.email = email;
        this.dob = dob;
        this.donations = donations;
    }

    public Donor(String name, String donorType, String donorCategory, String phoneNo, String email, String dob) {
        this.donorId = generateDonorId();
        this.donorName = name;
        this.donorType = donorType;
        this.donorCategory = donorCategory;

        this.phoneNo = phoneNo;
        this.email = email;
        this.dob = dob;
        this.donations = new SortedDoublyLinkedList<>();
    }

    private static String generateDonorId() {
        String id = String.format("DR%04d", idCounter);
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

    public void setDonorCategory(String donorCategory) {
        this.donorCategory = donorCategory;
    }

    public String getDonorCategory() {
        return donorCategory;
    }

    public void setDonorType(String donorType) {
        this.donorType = donorType;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

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

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public String getDob() {
        return dob;
    }

    public SortedDoublyLinkedListInterface<Donation> getDonations() {
        return donations;
    }

    public void setDonations(SortedDoublyLinkedListInterface<Donation> donations) {
        this.donations = donations;
    }

    @Override
    public int compareTo(Donor other) {
        return this.donorId.compareTo(other.donorId);
    }

    @Override
    public String toString() {
        return "donorId=" + donorId + ", donorName=" + donorName + ", donorType=" + donorType + ", donorCategory=" + donorCategory + ", phoneNo=" + phoneNo + ", email=" + email + ", dob=" + dob;
    }

}
