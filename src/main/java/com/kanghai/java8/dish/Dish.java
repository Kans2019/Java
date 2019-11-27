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
    private CaloricLevel caloricLevel;

    public enum CaloricLevel{
        DIET,
        NORMAL,
        FAT
    }

    public enum Type{
        MEAT,
        FISH,
        OTHER
    }

    public Dish(String name, int calories) {
        this.name = name;
        this.calories = calories;
    }

    public Dish(String name, int calories, Type type,CaloricLevel caloricLevel) {
        this.name = name;
        this.calories = calories;
        this.type = type;
        this.caloricLevel = caloricLevel;
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

    public boolean isVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
