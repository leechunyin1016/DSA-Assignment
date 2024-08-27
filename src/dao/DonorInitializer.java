package dao;

import adt.*;
import entity.Donor;

/**
 *
 * @author Kat Tan
 */
public class DonorInitializer {

//  Method to return a collection of with hard-coded entity values
    public SortedDoublyLinkedListInterface<Donor> initializeDonors() {
        SortedDoublyLinkedListInterface<Donor> dList = new SortedDoublyLinkedList<>();
        dList.add(new Donor("A1001", "Book"));
        dList.add(new Donor("A1002", "Pen"));
        dList.add(new Donor("A1003", "Pencil"));
        dList.add(new Donor("A1004", "Notepad"));
        dList.add(new Donor("A1005", "Ruler"));
        dList.add(new Donor("A1006", "Eraser"));
        return dList;
    }

}
