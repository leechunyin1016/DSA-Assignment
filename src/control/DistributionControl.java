/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;
import adt.SortedDoublyLinkedList;
import adt.SortedDoublyLinkedListInterface;
import boundary.DistributionUI;
import dao.DonorInitializer;
import entity.Donor;
import entity.Donee;
import entity.Distribution;
import utility.MessageUI;

/**
 *
 * @author Wei Lim
 */
public class DistributionControl {
    private SortedDoublyLinkedListInterface<Distribution> distributionList = new SortedDoublyLinkedList<>();
    private DistributionUI distributionUI = new DistributionUI();
    
    public DistributionControl(){
//        distributionList;
    }
    
    public void runDistributionMaintenance(){
        int distributionChoice = 0;
        do {
            distributionChoice = distributionUI.getMenuChoice();
            switch (distributionChoice) {
                case 1:
                    //add new donation distribution
                    addDistribution();
                    break;
                case 2:
                    //search donation distribution
                    searchDistribution();
                    break;
                case 3:
                    //remove donation distribuiton
                    removeDistribution();
                    break;
                case 4:
                    //monitor track distributed item
                    monitorDistribution();
                    break;
                case 5:
                    //generate summary reports
                    summaryDistribution();
                    break;
                case 6:
                    //analyse trend
                    trendDistribution();
                    break;
                case 0:
                    MessageUI.displayExitMessage();
                    break;
                default:
                    MessageUI.displayInvalidChoiceMessage();
            }
        } while (distributionChoice != 0);
    }
    
    public void addDistribution(){
        Distribution newDistribution = distributionUI.addDistribution();
        distributionList.add(newDistribution);
    }
    
    public void searchDistribution(){
        
    }
    
    public void removeDistribution(){
        
    }
    
    public void monitorDistribution(){
        
    }
    
    public void summaryDistribution(){
        
    }
    
    public void trendDistribution(){
        
    }
    
    public static void main(String[] args) {
        DistributionControl distributionControl = new DistributionControl();
        distributionControl.runDistributionMaintenance();
    }
}
