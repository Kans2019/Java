package com.kanghai.java8.buffered;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author likanghai
 * @version 1.0
 * @date 2019/11/17 18:03
 * @description
 */

public class ProcessFileRead {
    public static void main(String[] args) throws IOException {
        String oneLine = processFile((BufferedReader br) -> br.readLine());
        String twoLine = processFile((BufferedReader br) -> br.readLine() + br.readLine());
        System.out.println(oneLine);
        System.out.println(twoLine);
    }

    public static String processFile(BufferedReaderProcessor p) throws IOException{
        try(BufferedReader br = new BufferedReader(new FileReader("src\\main\\resources\\data.txt"))){
            return p.process(br);
        }
    }
}
