package com.kanghai.java8.apple.PrettyPrintApple;

import com.kanghai.java8.apple.Apple;

/**
 * @author likanghai
 * @version 1.0
 * @date 2019/11/17 14:43
 * @description
 */

public class PrettyPringAppleHeavy implements PrettyPrintApple{
    @Override
    public String toString(Apple apple) {
         return apple.getColor() + "is" +apple.getHeavy();
    }
}
