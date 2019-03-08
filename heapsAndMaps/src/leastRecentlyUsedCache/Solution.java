package leastRecentlyUsedCache;

import java.util.*;


public class Solution {
	int capacity;
    HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    Node head=null;
    Node end=null;
 
    public Solution(int capacity) {
        this.capacity = capacity;
    }
 
    public int get(int key) {
        if(map.containsKey(key)){
            Node n = map.get(key);
            remove(n);
            setHead(n);
            return n.value;
        }
 
        return -1;
    }
 
    public void remove(Node n){
        if(n.pre!=null){
            n.pre.next = n.next;
        }else{
            head = n.next;
        }
 
        if(n.next!=null){
            n.next.pre = n.pre;
        }else{
            end = n.pre;
        }
 
    }
 
    public void setHead(Node n){
        n.next = head;
        n.pre = null;
 
        if(head!=null)
            head.pre = n;
 
        head = n;
 
        if(end ==null)
            end = head;
    }
 
    public void set(int key, int value) {
        if(map.containsKey(key)){
            Node old = map.get(key);
            old.value = value;
            remove(old);
            setHead(old);
        }else{
            Node created = new Node(key, value);
            if(map.size()>=capacity){
                map.remove(end.key);
                remove(end);
                setHead(created);
 
            }else{
                setHead(created);
            }    
 
            map.put(key, created);
        }
    }
    class Node{
        int key;
        int value;
        Node pre;
        Node next;
     
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    public static void main(String[] args){
        System.out.println("Main function");
        Solution l = new Solution(5);
        
        l.set(1, 10);
        l.set(5, 12);
        System.out.println(l.get(5));
        System.out.println(l.get(1));
        l.set(6, 14);
        
        l.set(7, 15);
        l.set(8, 16);
        l.set(9, 17);
        
        
        System.out.println(l.get(5));
    }
}
