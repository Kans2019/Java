package com.kanghai.java8.buffered;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author likanghai
 * @version 1.0
 * @date 2019/11/17 17:58
 * @description
 */

public interface BufferedReaderProcessor {
    String process(BufferedReader b) throws IOException;
}
