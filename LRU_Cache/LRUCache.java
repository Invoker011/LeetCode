package LRU_Cache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private class Node{
        int key;
        int value;
        Node next;
        Node prev;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    Node head = new Node(-1,-1);
    Node tail = new Node(-1,-1);
    int cap;

    Map<Integer, Node> mp = new HashMap<>();

    public LRUCache(int capacity){
        this.cap = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public void addNode(Node newNode){
        Node temp = head.next;
        newNode.prev = head;
        head.next = newNode;
        newNode.next = temp;
    }
    public void delNode(Node delNode){
        Node delPrev = delNode.prev;
        Node delNext = delNode.next;
        delPrev.next = delNext;
        delNext.prev = delPrev;
    }
    public int get(int key){
        if(mp.containsKey(key)){
            Node resNode = mp.get(key);
            int res = resNode.value;
            mp.remove(key);
            delNode(resNode);
            addNode(resNode);
            mp.put(key,head.next);
            return res;

        }
        return -1;

    }

    public void put(int key, int value){
        if(mp.containsKey(key)){
            Node existingNode = mp.get(key);
            mp.remove(key);
            delNode(existingNode);
        }
        if(mp.size() == cap){
            mp.remove(tail.prev.key);
            delNode(tail.prev);
        }
        addNode(new Node(key,value));
        mp.put(key,head.next);

    }

    
}
