package com.kanghai.java8.chapter9.defaultest;

/**
 * @author likanghai
 * @version 1.0
 * @date 2019/12/10 0:44
 * @description
 */

public interface A {
    default void hello(){
        System.out.println("Hello from A");
    }
}


