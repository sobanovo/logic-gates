package com.cb.counters;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BinaryCounterTest {

    BinaryCounter counter;

    @BeforeAll
    void setup() {
        counter = new BinaryCounter();
    }

    @ParameterizedTest
    @CsvSource({
            // clock, binary count,
            "true,0", // clock high, initialized !state (1) to master, initial state preserved
            "false,1", // falling edge, data propagated from master to slave (output)
            "true,1", // clock high, !state (0) data to master, previous state preserved
            "false,0",  // falling edge, data propagated from master to slave
            "true,0", // clock high, !state (1) data to master, previous state preserved
            "false,1",  // falling edge, data propagated from master to slave
    })
    void binaryCounterTogglesCorrectly(boolean clock, String binaryCount) {
        counter.setClock(clock);
        assertEquals(binaryCount, counter.getBinaryCount());
    }

    @Test
    void binaryCounterResetsCorrectly() {
        counter.setClock(false);
        counter.setClock(true);
        counter.reset();
        assertEquals(Counter.BINARY_ZERO, counter.getBinaryCount());
    }

    @Test
    void binaryCounterInitialStateIsZero() {
        assertEquals(counter.getBinaryCount(), Counter.BINARY_ZERO);
    }
}
