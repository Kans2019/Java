package com.kanghai.java8.chapter7.spliterator;

import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * @author likanghai
 * @version 1.0
 * @date 2019/12/8 11:14
 * @description
 */

public class MySpliterator {

    public static void main(String[] args) {
        final String SENTENCE = "NEL  mezzo del  cammin di nostra vita " +
                "mi ritrovai in  una  selva  oscura " +
                "che la dritta via era  smarrita";

       // System.out.println("Found " + countWordsIteratively(SENTENCE));
//        Stream<Character> stream = IntStream.range(0, SENTENCE.length())
//                .mapToObj(SENTENCE::charAt);
       //System.out.println("Found " + countWords(stream.parallel()));
        Spliterator<Character> spliterator = new WordCounterSpliterator(SENTENCE);
        Stream<Character> stream = StreamSupport.stream(spliterator, true);
        System.out.println("Found " + countWords(stream) + " words");
    }


    private static int countWords(Stream<Character> stream){
        WordCounter wordCounter = stream.reduce(new WordCounter(0, true),
                WordCounter::accumulate,
                WordCounter::combine);
        return wordCounter.getCounter();
    }

    public static int countWordsIteratively(String s){
        int counter = 0;
        boolean lastSpace = true;
        for(char c : s.toCharArray()){
            if(Character.isWhitespace(c)){
                lastSpace = true;
            }else{
                //上一个字符是空格，当前字符不是空格的时候+1
                if(lastSpace) counter++;
                lastSpace = false;
            }
        }
        return counter;
    }

}

class WordCounter{
    private final int counter;
    private final boolean lastSpace;

    public WordCounter(int counter, boolean lastSpace) {
        this.counter = counter;
        this.lastSpace = lastSpace;
    }


    public WordCounter accumulate(Character c){
        if(Character.isWhitespace(c)){
            return lastSpace? this:new WordCounter(counter, true);
        }else{
            return lastSpace? new WordCounter(counter + 1, false) :
                    this;
        }
    }

    public WordCounter combine(WordCounter wordCounter){
        return new WordCounter(counter + wordCounter.counter,
                wordCounter.lastSpace);
    }

    public int getCounter(){
        return counter;
    }
}


class WordCounterSpliterator implements Spliterator<Character>{

    private final String string;
    private int currentChar = 0;

    WordCounterSpliterator(String string) {
        this.string = string;
    }

    @Override
    public boolean tryAdvance(Consumer<? super Character> action) {
        action.accept(string.charAt(currentChar++));
        return currentChar < string.length();
    }

    @Override
    public Spliterator<Character> trySplit() {
        int currentSize = string.length() - currentChar;
        if(currentSize < 10){
            return null;
        }

        for(int splitPos = currentSize / 2 + currentChar; splitPos < string.length(); splitPos++){
            if(Character.isWhitespace(string.charAt(splitPos))){
                Spliterator<Character> spliterator =
                        new WordCounterSpliterator(string.substring(currentChar,
                        splitPos));

                currentChar = splitPos;
                return spliterator;
            }
        }
        return null;

    }

    @Override
    public long estimateSize() {
        return string.length() - currentChar;
    }

    @Override
    public int characteristics() {
        return ORDERED + SIZED + SUBSIZED + NONNULL + IMMUTABLE;
    }
}