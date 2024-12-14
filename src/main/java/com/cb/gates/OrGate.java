package com.cb.gates;

/**
 * The OrGate class implements the LogicGate interface and provides
 * method to compute the output of an OR gate using NAND gate.
 */
public class OrGate implements LogicGate {

    private final NandGate nandGate;

    public OrGate() {
        nandGate = new NandGate();
    }

    /**
     * Computes the output of the OR gate for two boolean inputs.
     * The OR gate is implemented using three NAND gate operations.
     *
     * @param inputA the first input to the OR gate
     * @param inputB the second input to the OR gate
     * @return the result of the OR operation on the inputs
     */
    @Override
    public boolean compute(boolean inputA, boolean inputB) {

        // negating both inputs using NAND gate
        boolean nandOutput1 = nandGate.compute(inputA, inputA);
        boolean nandOutput2 = nandGate.compute(inputB, inputB);

        // applying NAND on negated input leads to OR operation
        return nandGate.compute(nandOutput1, nandOutput2);
    }
}
