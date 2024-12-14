package com.cb.counters;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BinaryCounterNBitTest {

    BinaryCounterNBit counter;

    @BeforeAll
    void setup() {
        counter = new BinaryCounterNBit(4);
    }

    @ParameterizedTest
    @CsvSource({
            // clock, binary count,
            "true,0000",
            "false,0001",
            "true,0001",
            "false,0010",
            "true,0010",
            "false,0011",
    })
    void binaryCounterTogglesCorrectly(boolean clock, String binaryCount) {
        counter.setClock(clock);
        assertEquals(binaryCount, counter.getBinaryCount());
    }

    @Test
    void binaryCounterResetsCorrectly() {
        BinaryCounterNBit counter = new BinaryCounterNBit(4);
        counter.setClock(false);
        counter.setClock(true);
        counter.reset();
        assertEquals("0000", counter.getBinaryCount());
    }


    @Test
    void binaryCounterThrowsExceptionForInvalidBitCount() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new BinaryCounterNBit(0));
        assertTrue(exception.getMessage().contains("Number of bits out of range"));

        exception = assertThrows(IllegalArgumentException.class, () -> new BinaryCounterNBit(BinaryCounterNBit.COUNTER_MAX + 1));
        assertTrue(exception.getMessage().contains("Number of bits out of range"));
    }

    @Test
    void binaryCounterHandlesMaximumBitCount() {
        BinaryCounterNBit maxCounter = new BinaryCounterNBit(BinaryCounterNBit.COUNTER_MAX);
        assertEquals(BinaryCounterNBit.COUNTER_MAX, maxCounter.getBinaryCount().length());
    }

    @Test
    void binaryCounter4BitsCountsCorrectly() {
        BinaryCounterNBit counter = new BinaryCounterNBit(4);
        counter.reset();
        for (int i = 0; i < 16; i++) {
            assertEquals(i, counter.getCount());
            counter.setClock(true);
            counter.setClock(false);
        }
    }

    @Test
    void binaryCounterInitialStateIsZero() {
        BinaryCounterNBit counter = new BinaryCounterNBit(4);
        assertEquals("0000", counter.getBinaryCount());
    }
}
