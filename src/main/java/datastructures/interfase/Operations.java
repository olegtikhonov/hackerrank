package datastructures.interfase;

/**
 * Defines basic data structure operations
 * add, remove, size, iterator(?), contains, indexAt,
 */
public interface Operations<T> {
    /**
     * Adds element T
     * @param element to be inserted
     */
    boolean add(T element);

    /**
     * Removes an element T from the array
     * @param element to be removed
     */
    boolean remove(T element);

    //Iterator<T> iterator();

    /**
     * Gets the element at index i.
     * @param index a references
     *
     * @return the element
     */
    T get(int index);

    /**
     * Sets an element at the index i.
     *
     * @param index where element will be added
     *
     * @return the element added at index
     */
    T set(int index);

    /**
     * Returns first occurrence of the first element.
     *
     * @param element to be looked at.
     *
     * @return index of -1
     */
    int indexAt(T element);
}
