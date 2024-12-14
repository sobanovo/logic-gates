package com.cb.gates;

/**
 * The NorGate class implements the LogicGate interface and provides
 * method to compute the output of a NOR gate using NAND gate.
 */
public class NorGate implements LogicGate {

    private final NandGate nandGate;

    public NorGate() {
        nandGate = new NandGate();
    }

    /**
     * Computes the output of the NOR gate for two boolean inputs.
     * The NOR gate is implemented using 4 NAND gate operations.
     *
     * @param inputA the first input to the NOR gate
     * @param inputB the second input to the NOR gate
     * @return the result of the NOR operation on the inputs
     */
    @Override
    public boolean compute(boolean inputA, boolean inputB) {

        // negating both inputs using NAND gate
        boolean nandOutput1 = nandGate.compute(inputA, inputA);
        boolean nandOutput2 = nandGate.compute(inputB, inputB);

        // applying NAND on negated input leads to OR operation
        boolean nandOutput3 = nandGate.compute(nandOutput1, nandOutput2);

        // negating OR leads to final NOR output
        return nandGate.compute(nandOutput3, nandOutput3);
    }
}
