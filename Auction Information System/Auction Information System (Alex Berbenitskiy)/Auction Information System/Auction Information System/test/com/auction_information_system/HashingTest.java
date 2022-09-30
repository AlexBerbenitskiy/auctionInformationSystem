package com.auction_information_system;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashingTest {
    int[] input = { 50, 700, 76, 85, 92, 73, 101 };
    int[] output = { 700, 50, 85, 73, 101, 92, 76 };
    int N = 7;
    int L = 7;
    int[] ht = new int[L];

    @BeforeEach
    void setUp() {
        for (int i = 0; i < L; i++) {
            ht[i] = -1;
        }
    }

    @AfterEach
    void tearDown() {
        for (int i = 0; i < L; i++) {
            ht[i] = -1;
        }
    }

    @Test
    void quadraticProbing() {
        assertArrayEquals(output, Hashing.quadraticProbing(ht, L, input, N));
    }
}