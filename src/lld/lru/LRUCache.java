package lld.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by libsys on 5/11/2022.
 */
/**
 * Using double ll to reduce delete LRU node in O(1)**/
public class LRUCache {
    int capacity;
    int cacheSize;
    Map<Integer,Integer> map;
    DoubleListNode cacheStart,cacheEnd;
    public LRUCache(int capacity){
        this.capacity = capacity;
        map = new HashMap<>();
        this.cacheStart = null;
        this.cacheEnd = null;
    }
    public void put(int key,int value){

        if(this.capacity<=0)
            return;

        if(map.containsKey(key)){
            updateCache(key);
            map.put(key,value);
            return;
        }
        if(this.cacheSize==this.capacity){
            deleteLRUNode();
        }
        DoubleListNode newNode = new DoubleListNode();
        newNode.val = key;
        newNode.next = this.cacheStart;
        newNode.prev = null;
        if(this.cacheStart != null)
            this.cacheStart.prev = newNode;
        this.cacheStart = newNode;
        map.put(key,value);
        this.cacheSize++;
    }
    public int get(int key){
        if(this.capacity<=0)
            return -1;
        if(!map.containsKey(key))
            return -1;
        updateCache(key);
        return map.get(key);

    }
    public void updateCache(int key){
        if(this.cacheSize==1 || this.cacheStart.val==key)
            return;
        DoubleListNode curr = this.cacheStart;
        while(curr.val!=key){
            curr = curr.next;
        }
        DoubleListNode temp = curr;
        curr.prev.next = curr.next;
        if(curr.next != null)
            curr.next.prev = curr.prev;
        else
            this.cacheEnd = curr.prev;
        curr.prev = null;
        curr.next = this.cacheStart;
        this.cacheStart.prev = curr;
        this.cacheStart = curr;

    }
    public void deleteLRUNode(){
        if(this.cacheEnd == null)
            return;
        map.remove(this.cacheEnd.val);
        this.cacheSize--;
        if(this.cacheEnd.prev ==null && capacity==1)
        {
            this.cacheEnd = null;
            this.cacheStart = null;
            return;
        }

        DoubleListNode newEnd = this.cacheEnd.prev;
        newEnd.next = null;
        this.cacheEnd = newEnd;

    }
}
class ListNode {
    public int val;
    public ListNode next;


    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode [val=" + val + ", " + (next != null ? "next=" + next : "") + "]";
    }

	/*public void addToList(int val) {
		while(this.next != null) {
			this.next = this.next.next;
		}
		head.next = new ListNode(val);
	}*/
}
class DoubleListNode{
    public int val;
    public DoubleListNode prev;
    public DoubleListNode next;
    @Override
    public String toString() {
        return "ListNode [val=" + val + ", "+(prev!=null ? "prev="+prev:""+", " + (next != null ? "next=" + next : "") + "]");
    }


}

