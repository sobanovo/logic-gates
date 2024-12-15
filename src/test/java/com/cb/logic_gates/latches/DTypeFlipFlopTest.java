package com.cb.logic_gates.latches;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DTypeFlipFlopTest {

    DTypeFlipFlop flipFlop;

    @BeforeAll
    void setup() {
        flipFlop = new DTypeFlipFlop();
    }

    @ParameterizedTest
    @CsvSource({
            // clock, data, state, state negated
            "true,true,false,true", // clock high, data to master, initial state preserved
            "false,true,true,false", // falling edge, data propagated from master to slave
            "true,false,true,false", // clock high, data to master, previous state preserved
            "false,false,false,true",  // falling edge, data propagated from master to slave
    })
    void dtypeFlipFlopHandlesClockAndDataInputsCorrectly(boolean clock, boolean data, boolean state, boolean negState) {
        flipFlop.setInput(clock, data);

        assertEquals(state, flipFlop.getState());
        assertEquals(negState, flipFlop.getStateNeg());
    }

    @Test
    void dtypeFlipFlopResetsCorrectly() {
        DTypeFlipFlop flipFlop = new DTypeFlipFlop();

        flipFlop.setInput(false, true);
        flipFlop.setInput(true, false);
        flipFlop.reset();
        assertFalse(flipFlop.getState());
        assertTrue(flipFlop.getStateNeg());
    }

    @Test
    void dtypeFlipFlopInitialStateIsFalse() {
        DTypeFlipFlop flipFlop = new DTypeFlipFlop();

        assertFalse(flipFlop.getState());
        assertTrue(flipFlop.getStateNeg());
    }
}
