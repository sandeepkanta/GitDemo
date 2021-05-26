package com.practice.arrays;

import java.util.HashMap;
import java.util.Map;

class Node{
    Node left, right;
    int key;
    Node (int key){
        this.key = key;
    }
}

class CacheValue{
    int data;
    Node node;
    CacheValue(int data, Node node){
        this.data = data;
        this.node = node;

    }
}

public class LruCache {

        final int capacity;
        Map<Integer, CacheValue> cache;
        Node head, tail;

        public LruCache(int capacity) {
            this.capacity = capacity;
            this.cache = new HashMap<>();
            head = null;
            tail = null;
        }

        public void moveNodeToEndOfList(Node node)
        {

            if(tail == node)
                return;

            if(node.left==null)
                head = node.right;
            else
                node.left.right = node.right;

            node.right.left = node.left;
            node.left  = tail;
            tail.right = node;
            node.right = null;
            tail = node;
        }

        public void addNodeToTheList(Node node){
            if(head == null){
                head = node;
                tail = node;
            }else{
                tail.right = node;
                node.left = tail;
                node.right = null;
                tail = node;
            }

        }

        public int get(int key) {
            if(cache.containsKey(key)){
                CacheValue cacheValue = cache.get(key);
                moveNodeToEndOfList(cacheValue.node);
                return cacheValue.data;
            }
            return -1;
        }

        public void set(int key, int value)
        {
            if(cache.containsKey(key)){
                CacheValue cacheValue = cache.get(key);
                cacheValue.data = value;
                moveNodeToEndOfList(cacheValue.node);
            }else if(cache.size() >= capacity){
                cache.remove(head.key);
                head = head.right;
                if(head!=null)
                    head.left = null;
                Node node = new Node(key);
                CacheValue cacheValue = new CacheValue(value, node);
                cache.put(key, cacheValue);
                addNodeToTheList(node);

            }else{
                Node node = new Node(key);
                CacheValue cacheValue = new CacheValue(value, node);
                cache.put(key, cacheValue);
                addNodeToTheList(node);
            }
        }

    public static void main(String[] args) {
        LruCache cache = new LruCache(2);
        cache.set(2,1);
        cache.set(1,1);
        cache.set(2,3);
        cache.set(4,1);
        cache.get(1);
        cache.get(2);
    }



}
