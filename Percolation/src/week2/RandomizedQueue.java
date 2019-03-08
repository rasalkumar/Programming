package week2;

import java.util.Iterator;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] a;
    private int N;
    
    public RandomizedQueue() {               // construct an empty randomized queue
        a = (Item[]) new Object[2];
        N = 0;
    }
       
    public boolean isEmpty() {                // is the queue empty?
        return (N == 0);
    }
    
    public int size() {                       // return the number of items on the queue
        return N;
    }
    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for(int i = 0; i < N; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }
    public void enqueue(Item item) {          // add the item
        if(item == null) throw new java.lang.NullPointerException();
        if(N == a.length) resize(a.length * 2);
        a[N++] = item;
    }
    public Item dequeue() {                   // delete and return a random item
        if(N == 0) throw new java.util.NoSuchElementException();
        int index = (int)(StdRandom.uniform(N));
        Item temp = a[index];
        if(index != N-1) a[index] = a[N-1];
        a[N-1] = null;
        N--;
        if(N >=0 && N == a.length/4) resize(a.length/2);
        return temp;
    }
        
    public Item sample() {                    // return (but do not delete) a random item
       if(N == 0) throw new java.util.NoSuchElementException();
       int index = (int)(StdRandom.random() * N);
       return a[index];             
    }
    public Iterator<Item> iterator() {        // return an independent iterator over items in random order
        return new ReverseArrayIterator();
    }
    private class ReverseArrayIterator implements Iterator<Item> {
    private int index = 0;
    private Item[] r;
    public ReverseArrayIterator() {
        r = (Item[]) new Object[N];
        for(int i=0; i<N; i++)
            r[i] = a[i];
        StdRandom.shuffle(r);
    }
    public boolean hasNext() {
        return index < N;
    }
    public void remove() {
        throw new java.lang.UnsupportedOperationException();
    }
    public Item next() {
        if(!hasNext()) throw new java.util.NoSuchElementException();
        Item item = r[index++];
        return item;
    }
    }
    public static void main(String[] args) {   // unit testing
       RandomizedQueue<String> deque = new RandomizedQueue<String> ();
       deque.enqueue("aa");
       deque.enqueue("bb");
       deque.enqueue("cc");
       deque.enqueue("dd");
       deque.dequeue();
       deque.dequeue();
       deque.dequeue();
       deque.dequeue();
       //deque.dequeue();
       StdOut.print("size:"+deque.size());
    }
}