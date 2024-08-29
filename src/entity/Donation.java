/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author junyi
 */
public class Donation implements Comparable<Donation> {
    
    private String donationId;
    private String donationItem;
    private int donationItemQty;
    private String donationDate;
    
    public Donation(){
           this.donationId = "";
        this.donationItem = "";
        this.donationItemQty = 0;
        this.donationDate = "";
        this.donationdDonorName = "";     
    }
    public Donation(String donationId){
           this.donationId = donationId;    
    }

    public Donation(String donationId, String donationItem, int donationItemQty, String donationDate, String donationdDonorName) {
        this.donationId = donationId;
        this.donationItem = donationItem;
        this.donationItemQty = donationItemQty;
        this.donationDate = donationDate;
        this.donationdDonorName = donationdDonorName;
    }

    public String getDonationId() {
        return donationId;
    }

    public void setDonationId(String donationId) {
        this.donationId = donationId;
    }

    public String getDonationItem() {
        return donationItem;
    }

    public void setDonationItem(String donationItem) {
        this.donationItem = donationItem;
    }

    public int getDonationItemQty() {
        return donationItemQty;
    }

    public void setDonationItemQty(int donationItemQty) {
        this.donationItemQty = donationItemQty;
    }

    public String getDonationDate() {
        return donationDate;
    }

    public void setDonationDate(String donationDate) {
        this.donationDate = donationDate;
    }

    public String getDonationdDonorName() {
        return donationdDonorName;
    }

    public void setDonationdDonorName(String donationdDonorName) {
        this.donationdDonorName = donationdDonorName;
    }
    private String donationdDonorName;


     // Implement Comparable for sorting
    @Override
    public int compareTo(Donation other) {
        return this.donationId.compareTo(other.donationId);
    }

    // Override equals and hashCode
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Donation donation = (Donation) obj;
        return donationId.equals(donation.donationId);
    }


    
    @Override
    public String toString() {
        return "donationId=" + donationId + ", donationName=" + donationItem + ", donationQty=" + donationItemQty + ", Donorname=" + donationdDonorName + ", Date=" + donationDate + " . ";
    }


}
