package com.auction_information_system;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilitiesTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void validPhone() {
        assertTrue(Utilities.validPhone("0987654321"));
        assertTrue(Utilities.validPhone("1234567890"));
        assertFalse(Utilities.validPhone("09876543211"));
        assertFalse(Utilities.validPhone("09"));
    }

    @Test
    void validTime() {
        assertTrue(Utilities.validTime(("12:12"))); // normal
        assertTrue(Utilities.validTime(("01:01"))); //normal
        assertFalse(Utilities.validTime(("ab:ab")));
        assertFalse(Utilities.validTime(("1:123")));
        assertFalse(Utilities.validTime(("123:1")));
        assertFalse(Utilities.validTime(("12;12")));
        assertFalse(Utilities.validTime(("12.12")));
        assertFalse(Utilities.validTime(("")));
        assertFalse(Utilities.validTime(("123a5")));
        assertFalse(Utilities.validTime(("12345")));
        assertFalse(Utilities.validTime(("abcdef")));
        assertFalse(Utilities.validTime(("123:123")));
        assertFalse(Utilities.validTime(("1:1")));
    }

    @Test
    void max100Chars() {
        assertFalse(Utilities.max100Chars("12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901"));  //abnormal
        assertTrue(Utilities.max100Chars("123456789012345678901234567890-123123456789012345678901234567890")); //normal
        assertTrue(Utilities.max100Chars(""));  //normal but unusual
    }

    @Test
    void max50Chars() {
        assertTrue(Utilities.max50Chars("12345678901234567890123456789012345678901234567890"));  //normal
        assertFalse(Utilities.max50Chars("123456789012345678901234567890-123123456789012345678901234567890"));  //abnormal
        assertTrue(Utilities.max50Chars(""));  //normal but unusual
    }

    @Test
    void max30Chars() {
        assertTrue(Utilities.max30Chars("123456789012345678901234567890"));  //normal
        assertFalse(Utilities.max30Chars("123456789012345678901234567890-123"));  //abnormal
        assertTrue(Utilities.max30Chars(""));  //normal but unusual
    }
}