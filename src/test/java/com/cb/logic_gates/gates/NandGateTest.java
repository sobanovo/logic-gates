package com.cb.logic_gates.gates;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NandGateTest {

    @ParameterizedTest
    @CsvSource({
            "false,false,true",
            "false,true,true",
            "true,false,true",
            "true,true,false"
    })
    void nandGateComputesCorrectly(boolean inputA, boolean inputB, boolean expectedOutput) {
        NandGate nandGate = new NandGate();
        boolean output = nandGate.compute(inputA, inputB);
        assertEquals(expectedOutput, output);
    }
}
