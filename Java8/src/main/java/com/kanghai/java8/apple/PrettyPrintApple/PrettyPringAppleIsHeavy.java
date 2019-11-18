package com.kanghai.java8.apple.PrettyPrintApple;

import com.kanghai.java8.apple.Apple;

/**
 * @author likanghai
 * @version 1.0
 * @date 2019/11/17 14:45
 * @description
 */

public class PrettyPringAppleIsHeavy implements PrettyPrintApple{
    @Override
    public String toString(Apple apple) {
        if(apple.getHeavy() > 140){
            return apple.getColor() + "is weight";
        }
        return apple.getColor() + "is light";
    }
}
