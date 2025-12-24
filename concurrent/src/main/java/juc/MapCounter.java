package juc;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class MapCounter {

    private ConcurrentMap<String, Integer> counter = new ConcurrentHashMap<>();


    public void putWord(String word) {
        counter.compute(word, (k, v) -> v == null ? 1 : v + 1);
    }

    public static void main(String[] args) {

    }

}
