package com.kanghai.java8.apple.ApplePredicate;

import com.kanghai.java8.apple.Apple;

/**
 * @author likanghai
 * @version 1.0
 * @date 2019/11/17 14:22
 * @description
 */

public class AppleHeavyWeightPredicate implements ApplePredicate {

    @Override
    public boolean test(Apple apple) {
        return apple.getHeavy() > 150;
    }
}
