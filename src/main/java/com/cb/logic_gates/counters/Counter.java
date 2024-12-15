package com.cb.logic_gates.counters;

/**
 * The Counter interface provides methods to control and query the state of a counter.
 */
public interface Counter {

    Integer BINARY_RADIX = 2;
    String BINARY_ZERO = "0";
    String BINARY_ONE = "1";

    /**
     * Sets the clock input for the counter.
     * The counter state is updated based on the clock input.
     *
     * @param clock the clock input for the counter
     */
    void setClock(boolean clock);

    /**
     * Resets the state of the counter to the default values.
     */
    void reset();

    /**
     * Returns the current count in of the counter in binary format as a string.
     *
     * @return the current binary count of the counter
     */
    String getBinaryCount();

    /**
     * Returns the current count of the counter as an integer.
     * The binary count is parsed to an integer.
     *
     * @return the current count of the counter
     */
    default Integer getCount() throws NumberFormatException  {
        return Integer.parseInt(getBinaryCount(), BINARY_RADIX);
    }
}
