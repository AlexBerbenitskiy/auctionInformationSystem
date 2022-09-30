package com.auction_information_system;

import javafx.scene.control.ListView;

public class Sorting {

    // QUICK SORT //
    /**
     * Utility method to swap two elements in the same array.
     * @param numArray the number array.
     * @param low the low number.
     * @param pivot the pivot point.
     */
    static void swap(ListView<Bid> numArray, int low, int pivot){
        Bid temp = numArray.getItems().get(low);                        //Set temp to the object at low.
        numArray.getItems().set(low, numArray.getItems().get(pivot));   //Swap the object at low for the object at pivot.
        numArray.getItems().set(pivot, temp);                           //Swap the object at pivot for the object at temp.
    }

    /**
     * Method used to partition an array of numbers with the intention of sorting from lowest to highest.
     * @param numArray The number array.
     * @param low The starting index.
     * @param high The ending index.
     * @return The partitioned number array.
     */
    static int partitionLow(ListView<Bid> numArray, int low, int high){
        int p = low, j;                     //Set p to low.
        for (j=low+1; j <= high; j++)       //Loop through the numArray until high.
            if (Integer.parseInt(numArray.getItems().get(j).getAmountBid()) < Integer.parseInt(numArray.getItems().get(low).getAmountBid())) //If the bid amount at j is lower than the bid amount of low
                swap(numArray, ++p, j);     //Swap j with p (and increment p after).
        swap(numArray, low, p);             //Swap low with p.
        return p;                           //Return p.
    }

    /**
     * Recursive Quick Sort method for sorting from lowest to highest.
     * @param numArray the regular array of numbers to be sorted.
     * @param low the starting index.
     * @param high the ending index.
     *
     */
    public static void quicksortLow(ListView<Bid> numArray, int low, int high){
        if (low < high) {                                   //If low is less than high.
            int p = partitionLow(numArray, low, high);      //Set p to the result of partitionLow
            quicksortLow(numArray, low, p-1);          //Recursively sort the low side.
            quicksortLow(numArray, p+1, high);          //Recursively sort the high side.
        }
    }

    /**
     * Method used to partition an array of numbers with the intention of sorting from highest to lowest.
     * @param numArray The number array.
     * @param low The starting index.
     * @param high The ending index.
     * @return The partitioned number array.
     */
    static int partitionHigh(ListView<Bid> numArray, int low, int high){
        int p = low, j;
        for (j=low+1; j <= high; j++)
            if (Integer.parseInt(numArray.getItems().get(j).getAmountBid()) > Integer.parseInt(numArray.getItems().get(low).getAmountBid()))
                swap(numArray, ++p, j);
        swap(numArray, low, p);
        return p;
    }

    /**
     * Recursive Quick Sort method for sorting from highest to lowest.
     * @param numArray the regular array of numbers to be sorted.
     * @param low the starting index.
     * @param high the ending index.
     *
     */
    public static void quicksortHigh(ListView<Bid> numArray, int low, int high){
        if (low < high) {
            int p = partitionHigh(numArray, low, high);
            quicksortHigh(numArray, low, p-1);
            quicksortHigh(numArray, p+1, high);
        }
    }
}
