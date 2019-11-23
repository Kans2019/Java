package com.kanghai.java8.stream;

/**
 * @author likanghai
 * @version 1.0
 * @date 2019/11/23 19:13
 * @description
 */

public class Trader {
    private final String name;
    private final String city;

    public Trader(String n, String c){
        this.name = n;
        this.city = c;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Trader{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
