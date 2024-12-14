package com.cb.gates;

/**
 * The XorGate class implements the LogicGate interface and provides
 * methods to compute the output of an XOR gate using NAND gates.
 */
public class XorGate implements LogicGate {

    private final NandGate nandGate;

    public XorGate() {
        nandGate = new NandGate();
    }

    /**
     * Computes the output of the XOR gate for two boolean inputs.
     * The XOR gate is implemented using four NAND gate operations.
     *
     * @param inputA the first input to the XOR gate
     * @param inputB the second input to the XOR gate
     * @return the result of the XOR operation on the inputs
     */
    @Override
    public boolean compute(boolean inputA, boolean inputB) {

        boolean nandOutput1 = nandGate.compute(inputA, inputB);

        boolean nandOutput2 = nandGate.compute(inputA, nandOutput1);
        boolean nandOutput3 = nandGate.compute(inputB, nandOutput1);

        return nandGate.compute(nandOutput2, nandOutput3);
    }
}
