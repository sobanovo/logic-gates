package com.cb.logic_gates.latches;

/**
 * The LogicGate interface provides a method to compute the output
 * of a logic gate for two boolean inputs.
 */
public interface Latch {

    /**
     * Sets the input for the latch.
     * The latch state is updated based on the enabled and data inputs.
     *
     * @param enabled the enable input for the latch
     * @param data    the data input for the latch
     */
    void setInput(boolean enabled, boolean data);

    /**
     * Resets the state of the latch to the default values.
     */
    void reset();

    /**
     * Returns the current state of the latch.
     *
     * @return the current state of the latch
     */
    boolean getState();

    /**
     * Returns the negated state of the latch.
     *
     * @return the negated state of the latch
     */
    boolean getStateNeg();
}
