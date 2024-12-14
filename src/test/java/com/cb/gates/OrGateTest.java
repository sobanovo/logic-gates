package com.cb.gates;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrGateTest {

    @ParameterizedTest
    @CsvSource({
            "false,false,false",
            "false,true,true",
            "true,false,true",
            "true,true,true"
    })
    void orGateComputesCorrectly(boolean inputA, boolean inputB, boolean expectedOutput) {
        OrGate orGate = new OrGate();
        boolean output = orGate.compute(inputA, inputB);
        assertEquals(expectedOutput, output);
    }
}
