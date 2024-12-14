package com.cb.latches;

import com.cb.gates.NandGate;

/**
 * The GatedDLatch class implements the Latch interface and provides
 * methods to simulate a gated D latch using NAND gate operations.
 */
public class GatedDLatch implements Latch {

    private boolean state;
    private boolean stateNeg;

    private final NandGate nandGate;

    public GatedDLatch() {
        reset();
        this.nandGate = new NandGate();
    }

    /**
     * Resets the state of the latch to the default values.
     */
    @Override
    public void reset() {
        this.state = false;
        this.stateNeg = true;
    }

    /**
     * Sets the input for the gated D latch.
     * The latch state is updated based on the enabled and data inputs using NAND gate operations.
     *
     * @param enabled the enable input for the latch
     * @param data    the data input for the latch
     */
    @Override
    public void setInput(boolean enabled, boolean data) {
        boolean nandOutput1 = nandGate.compute(data, enabled);
        boolean nandOutput2 = nandGate.compute(nandOutput1, enabled);

        boolean newState = nandGate.compute(nandOutput1, stateNeg);

        this.stateNeg = nandGate.compute(nandOutput2, newState);
        this.state = nandGate.compute(nandOutput1, stateNeg);
    }


    /**
     * Returns the current state of the latch.
     *
     * @return the current state of the latch
     */
    @Override
    public boolean getState() {
        return state;
    }

    /**
     * Returns the negated state of the latch.
     *
     * @return the negated state of the latch
     */
    @Override
    public boolean getStateNeg() {
        return stateNeg;
    }
}
