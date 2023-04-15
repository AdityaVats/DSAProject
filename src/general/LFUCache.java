package general;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by libsys on 11/11/2022.
 */
public class LFUCache {


    Map<Integer,Pair<Node,Integer>> keyToNodeFreqMap;
    int minFreq;
    int capacity;
    Map<Integer,Pair<Node,Node>> freqToLLMap;
    public LFUCache(int capacity){
        keyToNodeFreqMap = new HashMap<>();
        freqToLLMap = new HashMap<>();
        this.capacity = capacity;
        minFreq = 0;
    }
    public void put(int key,int value){
        if(capacity == 0)   return;
        if(keyToNodeFreqMap.containsKey(key)){
            keyToNodeFreqMap.get(key).first.data = value;
            Pair<Node,Integer> pair = keyToNodeFreqMap.get(key);
            removeNode(pair.first,pair.second);
            if(!freqToLLMap.containsKey(pair.second) && minFreq == pair.second) minFreq++;
            pair.second++;
            addNode(pair.first,pair.second);
            return;
        }
        Node node = new Node(value);
        node.key = key;
        if(keyToNodeFreqMap.size() == capacity){
            // remove LFU
            removeLFU();
        }
        int freq = 1;
        minFreq = freq;
        keyToNodeFreqMap.put(key,new Pair<>(node,freq));
        if(!freqToLLMap.containsKey(freq)){
            freqToLLMap.put(freq,new Pair<>(node,node));
        } else {
            Node head = freqToLLMap.get(freq).first;
            node.next = head;
            node.prev = null;
            head.prev = node;
            freqToLLMap.get(freq).first = node;
        }
    }
    public int get(int key){
        if(!keyToNodeFreqMap.containsKey(key))   return -1;

        Pair<Node,Integer> nodeFreqPair = keyToNodeFreqMap.get(key);
        Pair<Node,Node> freqLL = freqToLLMap.get(nodeFreqPair.second);
        removeNode(nodeFreqPair.first,nodeFreqPair.second);
        // current freq of node == min freq && after remvoing this node there are no more nodes in this freq  =====> new minFreq will be minFreq+1
        if(!freqToLLMap.containsKey(nodeFreqPair.second) && nodeFreqPair.second == minFreq) minFreq++;
        nodeFreqPair.second++;
        addNode(nodeFreqPair.first, nodeFreqPair.second);
        return nodeFreqPair.first.data;
    }
    private void removeNode(Node node,int freq){
        if(node.next == null && node.prev == null){
            freqToLLMap.remove(freq);
            return;
        }
        if(node.next == null){
            Node prev = node.prev;
            prev.next = null;
            node.prev = null;
            freqToLLMap.get(freq).second = prev;
            return;
        }
        if(node.prev == null){
            Node next = node.next;
            next.prev = null;
            node.next = null;
            freqToLLMap.get(freq).first = next;
            return;
        }

        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;

        node.next = null;
        node.prev = null;
    }

    private void addNode(Node node,int freq){

        if(!freqToLLMap.containsKey(freq)){
            freqToLLMap.put(freq,new Pair(node,node));
        } else {
            Pair<Node,Node> newFreqLL = freqToLLMap.get(freq);
            Node head = newFreqLL.first;
            node.next = head;
            head.prev = node;
            node.prev = null;
            newFreqLL.first = node;
        }
    }



    private void removeLFU(){
        Pair<Node,Node> pair = freqToLLMap.get(minFreq);
        Node head = pair.first;
        Node tail = pair.second;

        int key = tail.key;
        keyToNodeFreqMap.remove(key);

        if(head == tail){
            freqToLLMap.remove(minFreq);
        } else {
            Node prev = tail.prev;
            prev.next = null;
            tail.prev = null;
            freqToLLMap.get(minFreq).second = prev;
        }
    }
}

class Pair<X,Y>{
    X first;
    Y second;
    public Pair(X first,Y second){
        this.first = first;
        this.second = second;
    }
}
class Node{
    int data;
    int key;
    Node prev;
    Node next;
    public Node(int data){
        this.data = data;
    }
}