package com.cb.latches;

/**
 * The DTypeFlipFlop class implements the Latch interface and provides
 * methods to simulate a D-type flip-flop using two Gated D Latches.
 */
public class DTypeFlipFlop implements Latch {

    private final GatedDLatch dLatchMaster;
    private final GatedDLatch dLatchSlave;

    public DTypeFlipFlop() {
        this.dLatchMaster = new GatedDLatch();
        this.dLatchSlave = new GatedDLatch();
    }

    /**
     * Resets the state of both master and slave latches.
     */
    @Override
    public void reset() {
        this.dLatchMaster.reset();
        this.dLatchSlave.reset();
    }

    /**
     * Sets the input for the D-type flip-flop.
     * The master latch is set with the clock and data inputs.
     * The slave latch is set with the inverted clock and the state of the master latch.
     *
     * @param clock the clock input
     * @param data the data input
     */
    @Override
    public void setInput(boolean clock, boolean data) {
        dLatchMaster.setInput(clock, data);
        dLatchSlave.setInput(!clock, dLatchMaster.getState());
    }

    /**
     * Gets the current state of the D-type flip-flop.
     *
     * @return the state of the slave latch
     */
    @Override
    public boolean getState() {
        return dLatchSlave.getState();
    }

    /**
     * Gets the negated/complementary state of the D-type flip-flop.
     *
     * @return the negated/complementary state of the slave latch
     */
    @Override
    public boolean getStateNeg() {
        return dLatchSlave.getStateNeg();
    }
}
