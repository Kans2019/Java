package com.kanghai.java8.stream;

/**
 * @author likanghai
 * @version 1.0
 * @date 2019/11/23 19:15
 * @description
 */

public class Transactions {

    private final Trader trader;
    private final int year;
    private final int value;

    public Transactions(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    public Trader getTrader() {
        return trader;
    }

    public int getYear() {
        return year;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Transactions{" +
                "trader=" + trader +
                ", year=" + year +
                ", value=" + value +
                '}';
    }
}
