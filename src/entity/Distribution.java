/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.time.LocalDate;

/**
 *
 * @author Wei Lim
 */
public class Distribution implements Comparable<Distribution>{
    private String distributionId;
    private LocalDate distributionDate;
    private Donee donee;
    private Donor donor;
    private String distributionStatus;
    private static int distributionCounter = 0;
    
    public Distribution() {
        this.distributionId = generateDistributionId();
        this.distributionDate = null;
        this.donee = donee;
        this.donor = donor;
        this.distributionStatus = "";
    }

    public Distribution(String distributionId, LocalDate distributionDate, Donee donee, Donor donor, String distributionStatus) {
        this.distributionId = generateDistributionId();
        this.distributionDate = distributionDate;
        this.donee = donee;
        this.donor = donor;
        this.distributionStatus = distributionStatus;
    }

    public String getDistributionId() {
        return distributionId;
    }

    public void setDistributionId(String distributionId) {
        this.distributionId = distributionId;
    }

    public LocalDate getDistributionDate() {
        return distributionDate;
    }

    public void setDistributionDate(LocalDate distributionDate) {
        this.distributionDate = distributionDate;
    }

    public Donee getDonee() {
        return donee;
    }

    public void setDonee(Donee donee) {
        this.donee = donee;
    }

    public Donor getDonor() {
        return donor;
    }

    public void setDonor(Donor donor) {
        this.donor = donor;
    }

    public String getDistributionStatus() {
        return distributionStatus;
    }

    public void setDistributionStatus(String distributionStatus) {
        this.distributionStatus = distributionStatus;
    }

    public static int getDistributionCounter() {
        return distributionCounter;
    }

    public static void setDistributionCounter(int distributionCounter) {
        Distribution.distributionCounter = distributionCounter;
    }
    
    @Override
    public int compareTo(Distribution other) {
        return this.distributionId.compareTo(other.distributionId);
    }
    
    
    private static synchronized String generateDistributionId(){
        distributionCounter++;
        return String.format("DT%04d", distributionCounter);
    }
}
