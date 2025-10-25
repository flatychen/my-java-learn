package juc;

import java.util.LinkedHashMap;
import java.util.Map;

public class MyLruCache<K,V> extends LinkedHashMap<K,V> {

    private int size = 0;

    public MyLruCache(int size) {
        super(size,0.75F,true);
        this.size = size;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
        return this.size()>size;
    }

    public static void main(String[] args) {
        MyLruCache<String,Object> cache = new MyLruCache<String,Object>(3);

    }

}
