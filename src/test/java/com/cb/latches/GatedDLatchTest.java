package com.cb.latches;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class GatedDLatchTest {

    GatedDLatch gatedDLatch;

    @BeforeAll
    void setup() {
        gatedDLatch = new GatedDLatch();
    }

    @ParameterizedTest
    @CsvSource({
            // enabled, data, state, state negated
            "true, true, true, false", // enabled, data propagated
            "true, false, false, true", // enabled, data propagated
            "true, false, false, true", // enabled, data propagated
            "false, true, false, true", // disabled, previous state preserved
            "true, true, true, false", // enabled, data propagated
            "false, false, true, false", // disabled, previous state preserved
            "false, false, true, false", // disabled, previous state preserved
            "false, true, true, false", // disabled, previous state preserved
    })
    void gatedDLatchHandlesEnableAndDataInputsCorrectly(boolean enabled, boolean data, boolean state, boolean stateNeg) {
        gatedDLatch.setInput(enabled, data);

        assertEquals(gatedDLatch.getState(), state);
        assertEquals(gatedDLatch.getStateNeg(), stateNeg);
    }

    @Test
    void gatedDLatchResetsCorrectly() {
        GatedDLatch gatedDLatch = new GatedDLatch();

        gatedDLatch.setInput(true, true);
        gatedDLatch.reset();
        assertFalse(gatedDLatch.getState());
        assertTrue(gatedDLatch.getStateNeg());
    }

    @Test
    void gatedDLatchInitialStateIsFalse() {
        GatedDLatch gatedDLatch = new GatedDLatch();

        assertFalse(gatedDLatch.getState());
        assertTrue(gatedDLatch.getStateNeg());
    }

}
