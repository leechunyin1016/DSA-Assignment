/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;

import java.util.Scanner;
import entity.Donor;
import entity.Distribution;
import entity.Donee;

/**
 *
 * @author Wei Lim
 */
public class DistributionUI {
    Scanner scanner = new Scanner(System.in);

    public int getMenuChoice() {
        System.out.println("\nMAIN MENU");
        System.out.println("1. Add new donation distribution");
        System.out.println("2. Search Donation Distribution");
        System.out.println("3. Remove donation distribution");
        System.out.println("4. Monitor/track distributed items");
        System.out.println("5. Generate summary reports ");
        System.out.println("6. Analyse trend");
        System.out.println("0. Quit");
        System.out.print("Enter choice: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        return choice;
    }
    
    //Add new distribution
    
    
    public String findDonorName(){
        System.out.print("Enter Donor ID: ");
        String donorId = scanner.nextLine();
        return donorId;
    }
    
    public void displayDistributionId(Distribution distribution){
        System.out.println("Distribution ID: " + distribution.getDistributionId());
    }
    
    public String findDonatedItems(){
        System.out.print("Search an item: ");
        String donorItem = scanner.nextLine();
        return donorItem;
    }
    public Distribution addDistribution(){
        Distribution distribution = new Distribution();
        String distributionId = "Distribution ID: " + distribution.getDistributionId();
        String donorName = findDonorName();
        
        return null;
    }
    
    //Search Distribution
    public String getSearchId(){
        System.out.println("Enter Distribution ID to search (Press X/x to ret)");
        return "testing";
    }
    
    public String getContinueChoice() {
        System.out.println("Search distribution again? (Y/N)");
        String choice = scanner.nextLine();
        scanner.nextLine();
        System.out.println();
        return choice;
    }
    
    //Remove Distribution
    public String getRemoveDistributionConfirmation(){
        System.out.println("Are you sure that you want to remove? (Y/N)");
        String choice = scanner.nextLine();
        scanner.nextLine();
        System.out.println();
        return choice;
    }   
    
    //Monitor distributed items
    public int getMonitorAllOrSelect(){
        System.out.println("\nMonitor");
        System.out.println("1. All");
        System.out.println("2. Specific");
        System.out.println("0. Quit");
        System.out.print("Enter choice: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        return choice;
    }
}
