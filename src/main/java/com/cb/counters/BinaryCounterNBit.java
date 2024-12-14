package com.cb.counters;

/**
 * The BinaryCounterNBit class implements the Counter interface for an N-bit binary counter.
 * It uses an array of BinaryCounter objects to represent each bit of the counter.
 */
public class BinaryCounterNBit implements Counter {
    // maximum number of bits for the counter
    public static final int COUNTER_MAX = 32;

    // number of bits (binary counters) for the counter
    private final int n;

    // array of binary counters
    private final BinaryCounter[] counters;

    /**
     * Constructs a new BinaryCounterNBit with the specified number of bits (internal BinaryCounters).
     *
     * @param n the number of bits for the counter
     * @throws IllegalArgumentException if the number of bits is out of range [1 - 128]
     */
    public BinaryCounterNBit(int n) {
        if (n < 1 || n > COUNTER_MAX) {
            throw new IllegalArgumentException("Number of bits out of range [ 1 - " + COUNTER_MAX + "]: " + n);
        }
        this.n = n;
        this.counters = new BinaryCounter[n];
        for (int i = 0; i < n; i++) {
            this.counters[i] = new BinaryCounter();
        }
    }

    /**
     * Simulates a clock pulse to toggle the binary counter.
     *
     * @param clock the clock input (true for HIGH, false for LOW)
     */
    @Override
    public void setClock(boolean clock) {
        // The first counter input is the clock
        boolean state = clock;
        for (BinaryCounter counter : counters) {
            counter.setClock(state);
            // input of next counter is the output of previous counter
            state = BINARY_ONE.equals(counter.getBinaryCount());
        }
    }

    /**
     * Resets the state of the counter to the default values.
     */
    @Override
    public void reset() {
        for (BinaryCounter counter : counters) {
            counter.reset();
        }
    }

    /**
     * Returns the current count of the counter in binary format as a string.
     *
     * @return the current binary count of the counter
     */
    @Override
    public String getBinaryCount() {
        StringBuilder sb = new StringBuilder();
        // interation in the inverse order, the first counter is the least significant bit
        for (int i = n - 1; i >= 0; i--) {
            sb.append(counters[i].getBinaryCount());
        }
        return sb.toString();
    }
}
