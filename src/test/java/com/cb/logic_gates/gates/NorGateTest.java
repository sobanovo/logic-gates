package com.cb.logic_gates.gates;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NorGateTest {

    @ParameterizedTest
    @CsvSource({
            "false,false,true",
            "false,true,false",
            "true,false,false",
            "true,true,false"
    })
    void norGateComputesCorrectly(boolean inputA, boolean inputB, boolean expectedOutput) {
        NorGate norGate = new NorGate();
        boolean output = norGate.compute(inputA, inputB);
        assertEquals(expectedOutput, output);
    }
}
