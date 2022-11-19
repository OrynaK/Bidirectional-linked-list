package ua.nure.cpp.kasapova.practice3.list;

import ua.nure.cpp.kasapova.practice3.entity.Fabric;

/**
 * Any implementor of this interface MUST have constructor without parameters
 * and can have any other constructors if you want but them will not be tested.
 */
public interface FabricList extends Container { // Rename the class according to your domain
    /**
     * Inserts the specified element at the beginning.
     */
    void addFirst(Fabric element);

    /**
     * Appends the specified element at the end.
     */
    void addLast(Fabric element);

    /**
     * Removes the first element.
     */
    boolean removeFirst();

    /**
     * Removes the last element.
     */
    boolean removeLast();

    /**
     * Returns the first element.
     */
    Fabric getFirst();

    /**
     * Returns the last element.
     */
    Fabric getLast();

    /**
     * Returns the first occurrence of the specified element.
     * Returns null if no such element.
     * (use 'equals' method to check an occurrence)
     */
    Fabric get(Fabric element);

    /**
     * Removes the first occurrence of the specified element.
     * Returns true if this list contained the specified element.
     * (use 'equals' method to check an occurrence)
     */
    boolean remove(Fabric element);


}
