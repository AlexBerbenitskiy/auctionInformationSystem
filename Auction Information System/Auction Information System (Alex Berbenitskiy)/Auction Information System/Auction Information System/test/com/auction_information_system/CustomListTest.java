package com.auction_information_system;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomListTest {
    CustomList<AuctionLot> lots;
    AuctionLot lot1 = new AuctionLot("Car1", "Four wheels", "Sporty", "2022", "20000", "");
    AuctionLot lot2 = new AuctionLot("Car2", "Four wheels", "Slow", "2010", "10000", "");
    AuctionLot lot3 = new AuctionLot("Car3", "Four wheels", "Broken", "1987", "500", "");
    AuctionLot lot4 = new AuctionLot("Car4", "Four wheels", "Fixed", "1999", "1500", "");

    @BeforeEach
    void setUp() {
        lots = new CustomList<>();
        lots.add(lot2);
        lots.add(lot1);
    }

    @AfterEach
    void tearDown() {
        lots.head = null;
    }

    @Test
    void addFirstTest() {
        assertEquals(lots.get(0), lot1);
        lots.addFirst(lot3);
        assertEquals(lots.get(0), lot3);
    }

    @Test
    void addLastTest() {
        assertEquals(lots.get(1), lot2);
        lots.addLast(lot3);
        assertEquals(lots.get(2), lot3);
        lots.addFirst(lot4);
        assertEquals(lots.get(3), lot3);
    }

    @Test
    void sizeTest() {
        assertEquals(2, lots.size());
        lots.add(lot3);
        assertEquals(3, lots.size());
        lots.add(lot4);
        assertEquals(4, lots.size());
        lots.remove(lot4);
        assertEquals(3, lots.size());
        lots.remove(lot3);
        lots.remove(lot2);
        lots.remove(lot1);
        assertEquals(0, lots.size());
    }

    @Test
    void isEmptyTest() {
        assertFalse(lots.isEmpty());
    }

    @Test
    void containsTest() {
        assertFalse(lots.contains(lot3));
        lots.add(lot3);
        assertTrue(lots.contains(lot3));
    }

    @Test
    void removeTest() {
        assertEquals(lots.get(0), lot1);
        lots.addFirst(lot3);
        assertEquals(lots.get(0), lot3);
        assertTrue(lots.remove(lot3));
        assertFalse(lots.contains(lot3));
        lots.addLast(lot4);
        assertTrue(lots.contains(lot4));
        assertTrue(lots.remove(lot4));
        assertFalse(lots.contains(lot4));
        lots.remove(lot1);
        lots.remove(lot2);
        lots.remove(lot3);
        lots.remove(lot4);
        assertEquals(0, lots.size());

        lots.addFirst(lot3);
        lots.addFirst(lot2);
        lots.addFirst(lot1);
        assertEquals(3, lots.size());
        assertEquals(lots.get(2), lot3);
        assertEquals(lots.get(1), lots.remove(1));
        assertEquals(2, lots.size());
        assertFalse(lots.contains(lot2));
        lots.addFirst(lot2);
        assertEquals(3, lots.size());
        assertEquals(lots.get(0), lots.remove(0));
        assertEquals(2, lots.size());
        assertFalse(lots.contains(lot2));
        assertEquals(lots.get(1), lots.remove(1));
        assertEquals(1, lots.size());
        assertEquals(lots.get(0), lots.remove(0));
        assertEquals(0, lots.size());
    }


    @Test
    void clearTest() {
        assertEquals(2, lots.size());
        lots.add(lot3);
        assertEquals(3, lots.size());
        lots.add(lot4);
        assertEquals(4, lots.size());
        lots.clear();
        assertEquals(0, lots.size());
    }

    @Test
    void getTest() {
        assertEquals(lot1,lots.get(0));
        assertEquals(lot2, lots.get(1));
        lots.add(lot3);
        assertEquals(lot3,lots.get(0));
    }

    @Test
    void setTest() {
        assertEquals(lot1, lots.get(0));
        assertEquals(lot2, lots.get(1));
        assertEquals(lot3, lots.set(0,lot3));
        assertEquals(lot4, lots.set(1,lot4));
        assertEquals(lot3, lots.get(0));
        assertEquals(lot4, lots.get(1));
        assertFalse(lots.contains(lot1));
        assertFalse(lots.contains(lot2));
    }

    @Test
    void addTest() {
        assertEquals(lots.get(0), lot1);
        lots.add(0, lot3);
        lots.add(1, lot4);
        assertEquals(lots.get(0), lot3);
        assertEquals(lots.get(1), lot4);
        assertEquals(lots.get(2), lot1);
        assertEquals(lots.get(3), lot2);
        assertNull(lots.get(4));
    }


    @Test
    void indexOfTest() {
        lots.add(0, lot3);
        lots.add(1, lot4);
        assertEquals(0,lots.indexOf(lot3));
        assertEquals(1,lots.indexOf(lot4));
        lots.clear();
        assertEquals(-1,lots.indexOf(lot3));
        lots.add(lot4);
        lots.add(lot3);
        lots.add(lot2);
        lots.add(lot1);
        assertEquals(0,lots.indexOf(lot1));
        assertEquals(1,lots.indexOf(lot2));
        assertEquals(2,lots.indexOf(lot3));
        assertEquals(3,lots.indexOf(lot4));
    }

    @Test
    void lastIndexOf() {
    }

    @Test
    void retainAll() {
    }

    @Test
    void removeAll() {
    }

    @Test
    void containsAll() {
    }

    @Test
    void addAll() {
    }

    @Test
    void testAddAll() {
    }

    @Test
    void iterator() {
    }

    @Test
    void listIterator() {
    }

    @Test
    void testListIterator() {
    }

    @Test
    void subList() {
    }

    @Test
    void toArray() {
    }

    @Test
    void testToArray() {
    }
}