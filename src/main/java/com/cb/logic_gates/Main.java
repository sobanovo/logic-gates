package com.cb.logic_gates;

import com.cb.logic_gates.counters.BinaryCounterNBit;

public class Main {
    public static void main(String[] args) {
        BinaryCounterNBit counter = new BinaryCounterNBit(4);
        counter.reset();
        for (int i = 0; i < 16; i++) {
            System.out.println(counter.getCount());
            counter.setClock(true);
            counter.setClock(false);
        }
    }
}