package week2;

import java.util.Iterator;

import edu.princeton.cs.algs4.StdOut;

public class Deque<Item> implements Iterable<Item> {
    private class node {
        Item item;
        node prev;
        node next;
    }
    private node first;
    private node last;
    private int N;
    public Deque() {                          // construct an empty deque
        first = last = null;
        N = 0;
    }
    public boolean isEmpty() {                // is the deque empty?
        return (N == 0);
    }
    public int size() {                       // return the number of items on the deque
        return N;
   }
   public void addFirst(Item item)          // insert the item at the front
   {
       if(item == null) throw new NullPointerException();
       node oldfirst = first;
       first = new node();
       first.item = item;
       first.next = oldfirst;
       if(isEmpty()) last = first;
       else {
           oldfirst.prev = first;
       }
       N++;      
   }
   public void addLast(Item item)           // insert the item at the end
   {
       if(item == null) throw new java.lang.NullPointerException();
       node oldlast = last;
       last = new node();
       last.item = item;
       last.prev = oldlast;
       if(isEmpty()) first = last;
       else {
           oldlast.next = last;
       }
       N++;
   }
   public Item removeFirst() {               // delete and return the item at the front
       if(N == 0) throw new java.util.NoSuchElementException();
       Item temp = first.item;
       first = first.next;
       N--;
       if(isEmpty()) last = null;
       else
           first.prev = null;
       return temp;
   }
   public Item removeLast() {                // delete and return the item at the end
       if(N == 0) throw new java.util.NoSuchElementException();
       Item temp = last.item;
       last = last.prev;
       N--;
       if(isEmpty()) first = null;
       else
           last.next = null;
       return temp;    
   }
   private class ListIterator implements Iterator<Item> {
       private node current = first;
       public boolean hasNext() {
           return current != null;
       }
       public void remove() {
           throw new java.lang.UnsupportedOperationException();
       } 
       public Item next() {
           if(!hasNext())
               throw new java.util.NoSuchElementException();
           Item item = current.item;
           current = current.next;
           return item;
       }
   }
   public Iterator<Item> iterator() {        // return an iterator over items in order from front to end
       return new ListIterator();
       
   }
   public static void main(String[] args) {  // unit testing
       Deque<String> deque = new Deque<String> ();
       deque.addFirst("aa");
       deque.addFirst("bb");
       deque.addFirst("cc");
       deque.addLast("dd");
       StdOut.println(deque.removeFirst());
       StdOut.println(deque.removeFirst());
       StdOut.println(deque.removeFirst());
       StdOut.println(deque.removeLast());
       StdOut.print("size:"+deque.size());
   } 
  
}