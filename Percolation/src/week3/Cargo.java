package week3;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.*;

/** A cargo module for holding Items. Items can be retrieved in various ways.
    @author Jeremy Hilliker @ Langara
    @author Edit By: Benjamin Chen
    @version 2017-05-16 15h00
    @see <a href="https://d2l.langara.bc.ca/d2l/le/content/88736/viewContent/1313159/View">a 03: Cargo</a>
*/
public class Cargo{

    private final int maxWeight;
    private final HashSet<Item> cargo;

    /** Create a new cargo module with a given weight capacity.
        @param aMaxWeight the maximum weight capacity of the cargo module before it becomes overweight.
    */
    public Cargo(int aMaxWeight) {
        maxWeight = -1;
        cargo = null;
    }

    /** Gets the maximum weight capacity of the cargo module.
        @return the maximum weight capacity of the cargo module.
    */
    public int getMaxWeight() {
        return maxWeight;
    }

    /** Gets the number of items currently stored.
        @return the number of items currently stored
    */
    public int getItemCount() {
        return -1;
    }

    /** Get the sum of the weights of all of the items currently stored.
        @return the sum of the weights of all of the items currently stored
    */
    public int getTotalWeight() {
        return -1;
    }

    /** Determines if the total weight of all of the stored items exceeds the weight capacity of the cargo module.
        @return true iff the total weight of all of the stored items exceeds the weight capacity of the cargo module.
    */
    public boolean isOverWeight() {
        return false;
    }

    /** Adds an item to the cargo module.
        @param item the item to add. It must not already be in the cargo module.
    */
    public void add(Item item) {

    }

    /** Determines if an item is stored in the cargo module.
        @param tracking the tracking number of the item to search for
        @return true iff an item with the given tracking umber is stored in the cargo module
    */
    public boolean contains(long tracking) {
        return false;
    }

    /** Removes an item from the cargo hold.
        @param tracking the tracking number of the item to remove from the cargo module
        @return true iff an item was removed
    */
    public boolean remove(long tracking) {
        return false;
    }

    /** Gets all items with the given name.
        @param name the name to filter items by
        @return the set of all items with the given name.
    */
    public HashSet<Item> getItems(String name) {
        return null;
    }

    /** Gets the heaviest item in the cargo module.
        @return the heaviest item in the cargo module; null if empty
    */
    public Item getHeaviest() {
        return null;
    }

    /** Gets the heaviest item with the given name.
        @param name the name with which to filter
        @return the heaviest item with the given name; null if no item matches the name
    */
    public Item getHeaviest(String name) {
        return null;
    }

    private Item getHeaviest(HashSet<Item> sub) {
        return null;
    }

    /** Gets the average weight of the items in the cargo module.
        @return the average weight of the items in the cargo module; NaN if empty
    */
    public double getAverageWeight() {
        return Double.NaN;
    }

    /** Gets the average weight of the items with the given name.
        @param name the name with which to filter
        @return the average weight of the items with the given name; NaN if no item matches the given name
    */
    public double getAverageWeight(String name) {
        return Double.NaN;
    }

    private double getAverageWeight(HashSet<Item> sub) {
        return Double.NaN;
    }

    /** Retrieves the items with the given tracking numbers.
        @param tracking the tracking numbers of the items to retrieve
        @return the items with the given tracking numbers
    */
    public HashSet<Item> getItems(long... tracking) {
        return null;
    }

    /** Retrieves the items with the given names.
        @param names the names of the items to retrieve
        @return a map from names to sets of items with that name. Names that have no items will get an empty set
    */
    public HashMap<String, HashSet<Item>> getItemsMap(String... names) {
        return null;
    }

    /** An item in the cargo module. Items are immutable.
    */
    public static class Item {
        public final long tracking;
        public final String name;
        public final int weight;

        private static long nextTrack = 101;

        /** An item for transport.
            @param aName the name of the item
            @param aWeight the weight of the item
            */
        public Item(String aName, int aWeight) {
            tracking = nextTrack++;
            name = aName;
            weight = aWeight;
        }
    }
}