package com.cb.gates;

/**
 * The NandGate class implements the LogicGate interface and provides
 * method to compute the output of a NAND gate.
 */
public class NandGate implements LogicGate {

    /**
     * Computes the output of the NAND gate for two boolean inputs.
     *
     * @param inputA the first input to the NAND gate
     * @param inputB the second input to the NAND gate
     * @return the result of the NAND operation on the inputs
     */
    @Override
    public boolean compute(boolean inputA, boolean inputB) {
        return !(inputA && inputB);
    }
}
