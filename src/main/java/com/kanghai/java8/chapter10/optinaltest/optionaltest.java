package com.kanghai.java8.chapter10.optinaltest;

import java.util.Optional;
import java.util.Properties;

/**
 * @author likanghai
 * @version 1.0
 * @date 2019/12/11 0:30
 * @description
 */

public class optionaltest {

    public static void main(String[] args) {
        Properties props = new Properties();
        props.setProperty("a", "5");
        props.setProperty("b", "true");
        props.setProperty("c", "-3");

    }

    public static Optional<Integer> stringToInt(String s) {
        try {
            return Optional.of(Integer.parseInt(s));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    public int readDuration(Properties props, String name) {
        String value = props.getProperty(name);
        if (value != null) {
            try {
                int i = Integer.parseInt(value);
                if (i > 0) {
                    return i;
                }
            } catch (NumberFormatException e) {
            }
        }

        return 0;
    }

    public int readDuration2(Properties props, String name){
        //
        return 0;
    }
}
