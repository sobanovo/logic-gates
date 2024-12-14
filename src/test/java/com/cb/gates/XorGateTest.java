package com.cb.gates;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class XorGateTest {

    @ParameterizedTest
    @CsvSource({
            "false,false,false",
            "false,true,true",
            "true,false,true",
            "true,true,false"
    })
    void xorGateComputesCorrectly(boolean inputA, boolean inputB, boolean expectedOutput) {
        XorGate xorGate = new XorGate();
        boolean output = xorGate.compute(inputA, inputB);
        assertEquals(expectedOutput, output);
    }
}
