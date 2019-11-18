package com.kanghai.java8.dish;

/**
 * @author likanghai
 * @version 1.0
 * @date 2019/11/19 0:05
 * @description
 */

public class Dish {
    private String name;
    private int calories;
    private boolean vegetarian;
    private Type type;

    public enum Type{
        MEAT,
        FISH,
        OTHER
    }

    public Dish(String name, int calories) {
        this.name = name;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }
}
