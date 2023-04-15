package general;

import lld.lru.LRUCache;

/**
 * Created by libsys on 11/11/2022.
 */
public class LRUDriver {
    public static void main(String[] args){
        LFUCache cache = new LFUCache(2);

        cache.put(1, 1);

        cache.put(2, 2);
        System.out.println(cache.get(1));

        cache.put(3, 3);
        System.out.println(cache.get(2));

        System.out.println(cache.get(3));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));

        System.out.println(cache.get(4));



    }
}
