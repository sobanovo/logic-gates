package com.cb.logic_gates.gates;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AndGateTest {

    @ParameterizedTest
    @CsvSource({
            "false,false,false",
            "false,true,false",
            "true,false,false",
            "true,true,true"
    })
    void andGateComputesCorrectly(boolean inputA, boolean inputB, boolean expectedOutput) {
        AndGate andGate = new AndGate();
        boolean output = andGate.compute(inputA, inputB);
        assertEquals(expectedOutput, output);
    }
}
