package com.kanghai.java8.comparator;

import java.util.function.Function;

/**
 * @author likanghai
 * @version 1.0
 * @date 2019/11/18 1:11
 * @description
 */

public class Letter {
    public static void main(String[] args) {
        Function<String ,String> addHeader = Letter::addHeader;
        Function<String, String> transformationPipeline =
                addHeader.andThen(Letter::checkSpelling)
                        .andThen(Letter::addFooter);

        String result = transformationPipeline.apply("abclab");
        System.out.println(result);
    }


    public static String addHeader(String text){
        return "Dear jiaozi:" + text;
    }

    public static String addFooter(String text){
        return text + " King regards";
    }

    public static String checkSpelling(String text){
        return text.replaceAll("lab", "lam");
    }
}
