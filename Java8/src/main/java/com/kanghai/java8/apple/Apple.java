package com.kanghai.java8.apple;

/**
 * @author likanghai
 * @version 1.0
 * @date 2019/11/17 0:07
 * @description
 */

public class Apple {
    private int heavy;
    private String color;

    public Apple(int heavy, String color) {
        this.heavy = heavy;
        this.color = color;
    }

    public int getHeavy() {
        return heavy;
    }

    public void setHeavy(int heavy) {
        this.heavy = heavy;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public static boolean isGreenApple(Apple apple){
        return "green".equals(apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple){
        return apple.getHeavy() > 150;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "heavy=" + heavy +
                ", color='" + color + '\'' +
                '}';
    }
}
