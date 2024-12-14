package com.cb.gates;

/**
 * The AndGate class implements the LogicGate interface and provides
 * methods to compute the output of an AND gate using a NAND gate.
 */
public class AndGate implements LogicGate {

    private final NandGate nandGate;

    public AndGate() {
        nandGate = new NandGate();
    }

    /**
     * Computes the output of the AND gate for two boolean inputs.
     * The AND gate is implemented using two sequential NAND gate operations.
     *
     * @param inputA the first input to the AND gate
     * @param inputB the second input to the AND gate
     * @return the result of the AND operation on the inputs
     */
    @Override
    public boolean compute(boolean inputA, boolean inputB) {
        boolean nandOutput = nandGate.compute(inputA, inputB);
        return nandGate.compute(nandOutput, nandOutput);
    }
}
