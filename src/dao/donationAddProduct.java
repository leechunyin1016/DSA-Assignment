/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import adt.*;
import entity.Donation;

/**
 *
 * @author junyi
 */
public class donationAddProduct {

    public SortedDoublyLinkedListInterface donationdata() {
        SortedDoublyLinkedListInterface<Donation> donationList = new SortedDoublyLinkedList<>();
        donationList.add(new Donation("D1001", "Books", 5, "2024/08/01", "Alice"));
        donationList.add(new Donation("D1002", "Food", 10, "2024/08/02", "Bob"));
        donationList.add(new Donation("D1003", "Clothes", 20, "2024/08/03", "Charlie"));
        donationList.add(new Donation("D1004", "Food", 30, "2024/08/04", "David"));
        
        
        return donationList;
    }

}
