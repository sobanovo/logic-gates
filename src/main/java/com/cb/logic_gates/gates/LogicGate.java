package com.cb.logic_gates.gates;

/**
 * The LogicGate interface provides a method to compute the output
 * of a logic gate for two boolean inputs.
 */
public interface LogicGate {

    /**
     * Computes the output of the logic gate for two boolean inputs.
     *
     * @param inputA the first input to the logic gate
     * @param inputB the second input to the logic gate
     * @return the result of the logic gate operation on the inputs
     */
    boolean compute(boolean inputA, boolean inputB);
}
