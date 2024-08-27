/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import adt.SortedDoublyLinkedList;
import adt.SortedDoublyLinkedListInterface;
import boundary.DonorUI;
import dao.DonorInitializer;
import entity.Donor;
import utility.MessageUI;

/**
 *
 * @author LEE CHUN YIN
 */
public class DonorControl {

    private SortedDoublyLinkedListInterface<Donor> donorList = new SortedDoublyLinkedList<>();
    private DonorInitializer donorDAO = new DonorInitializer();
    private DonorUI donorUI = new DonorUI();

    public DonorControl() {
        donorList = donorDAO.initializeDonors();
    }

    public void runDonorMaintenance() {
        int choice = 0;
        do {
            choice = donorUI.getDonorMenuChoice();
            switch (choice) {
                case 1:
                    addNewDonor();
                    break;
                case 2:
                    removeDonor();
                    break;
                case 3:
                    updateDonorDetails();
                    break;
                case 4:
                    searchDonor();
                    break;
                case 5:
                    listAllDonors();
                    break;
                case 6:
                    generateDonorSummaryReport();
                    break;
                case 7:
                    MessageUI.displayExitMessage();
                    break;
                default:
                    MessageUI.displayInvalidChoiceMessage();
            }
        } while (choice != 7);
    }

    public void addNewDonor() {
        Donor newDonor = donorUI.inputDonorDetails();
        donorList.add(newDonor);
    }

    private void removeDonor() {
        String donorName = donorUI.inputDonorName();
        for (int i = 0; i < donorList.size(); i++) {
            if (donorList.getEntry(i).getDonorName().endsWith(donorName)) {
                donorList.remove(donorList.getEntry(i));
            }
        }
    }

    private void updateDonorDetails() {
        String donorName = donorUI.inputDonorName();
        String donorId = null;
        for (int i = 0; i < donorList.size(); i++) {
            if (donorList.getEntry(i).getDonorName().endsWith(donorName)) {
                donorUI.printDonorDetails(donorList.getEntry(i));
                donorId = donorList.getEntry(i).getDonorId();
            }
        }
        Donor donor = donorUI.inputDonorDetails();
        donor.setDonorId(donorId);
        for (int i = 0; i < donorList.size(); i++) {
            if (donorList.getEntry(i).getDonorName().endsWith(donorName)) {
                donorList.edit(donorList.getEntry(i),donor);
            }
        }
    }

    private void searchDonor() {
        String donorName = donorUI.inputDonorName();
        for (int i = 0; i < donorList.size(); i++) {
            if (donorList.getEntry(i).getDonorName().endsWith(donorName)) {
                donorUI.printDonorDetails(donorList.getEntry(i));
            }
        }
    }

    private void listAllDonors() {
        System.out.println("Donor List");
        System.out.println("==========");
        donorList.display();
    }

    private void generateDonorSummaryReport() {

    }

    public static void main(String[] args) {
        DonorControl donorMaintenance = new DonorControl();
        donorMaintenance.runDonorMaintenance();
    }

}
