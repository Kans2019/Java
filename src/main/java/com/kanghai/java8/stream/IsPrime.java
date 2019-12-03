package com.kanghai.java8.stream;

import java.util.List;
import java.util.function.Predicate;

/**
 * @author likanghai
 * @version 1.0
 * @date 2019/12/4 0:13
 * @description
 */

public class IsPrime {


    public static <A> List<A> takeWhile(List<A> list, Predicate<A> p){
        int i = 0;
        for(A item : list){
            if(!p.test(item)){
                return list.subList(0, i);
            }
            i++;
        }
        return list;
    }



}

