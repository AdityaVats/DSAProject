package lld.lru;

/**
 * Created by libsys on 5/11/2022.
 */
public class MainDriver {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.get(1);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.get(1);
        lruCache.put(2, 3);
        lruCache.get(2);
        lruCache.put(6,6);

    }
}
