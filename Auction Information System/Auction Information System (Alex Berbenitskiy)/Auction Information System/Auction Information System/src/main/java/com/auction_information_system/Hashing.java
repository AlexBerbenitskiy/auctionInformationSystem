package com.auction_information_system;

public class Hashing {

    /**
     * Hashing method using quadratic probing.
     * @param table Hash table.
     * @param tableSize The table size.
     * @param numArray The numbers to be hashed and stored in the hash table.
     * @param N The size of the hash table.
     * @return The hash table.
     */
    public static int[] quadraticProbing(int[] table, int tableSize, int[] numArray, int N) {
        for (int i=0; i<N; i++) {                                       //Loop N times.
            int hashValue = numArray[i] % tableSize;                    //Divide the current value by the tableSize and set hashValue as the difference.
            if(table[hashValue]==-1) table[hashValue] = numArray[i];    //If the space is empty (-1), set table[hashValue] to numArray[i].
            else {
                for (int j=0; j<tableSize; j++) {                       //Otherwise, loop through the table.
                    int newHashValue = (hashValue + j*j) % tableSize;   //Divide the current hashValue plus the value of j squared by the table size and set newHashValue as the difference.
                    if(table[newHashValue]==-1) {                       //If the space is empty (-1),
                        table[newHashValue] = numArray[i];              //Set table[newHashValue] to numArray[i].
                        break;
                    }
                }
            }
        }
        return table;
    }
}
