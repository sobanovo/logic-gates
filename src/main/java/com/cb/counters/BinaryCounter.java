package com.cb.counters;

import com.cb.latches.DTypeFlipFlop;

/**
 * The BinaryCounter class implements the Counter interface using a D-type flip-flop.
 * It provides methods to simulate a binary counter.
 */
public class BinaryCounter implements Counter {

    private final DTypeFlipFlop flipFlop;

    public BinaryCounter() {
        this.flipFlop = new DTypeFlipFlop();
    }

    /**
     * Simulates a clock pulse to toggle the binary counter.
     * The change of state is triggered by falling edge of the clock input.
     *
     * @param clock the clock input (true for HIGH, false for LOW)
     */
    @Override
    public void setClock(boolean clock) {
        // input is always the inverse of previous state
        flipFlop.setInput(clock, this.flipFlop.getStateNeg());
    }

    /**
     * Resets the state of the counter to the default values.
     */
    @Override
    public void reset() {
        flipFlop.reset();
    }

    /**
     * Returns the current count of the counter in binary format as a string.
     *
     * @return the current binary count of the counter
     */
    @Override
    public String getBinaryCount() {
        return this.flipFlop.getState() ? BINARY_ONE : BINARY_ZERO;
    }
}
