package ua.nure.cpp.kasapova.practice3.list;

import ua.nure.cpp.kasapova.practice3.entity.Fabric;

public interface Container extends Iterable<Fabric> {
    /**
     * Removes all elements.
     */
    void clear();

    /**
     * Returns the number of elements.
     */
    int size();

    /**
     * Returns a string representation of this container.
     */
    String toString();

    /**
     * Returns an array containing all elements of this container.
     */
    Object toArray();
}
