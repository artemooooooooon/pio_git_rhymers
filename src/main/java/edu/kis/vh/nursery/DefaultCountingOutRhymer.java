package edu.kis.vh.nursery;

/**
 * The DefaultCountingOutRhymer class represents a simple container
 * that stores integer values and allows adding and removing them
 * in a LIFO (Last-In-First-Out) manner.
 *
 * <p>The class has a fixed capacity and does not allow adding elements
 * beyond its limit. It also provides methods to check whether the
 * structure is empty or full.</p>
 *
 * <p>This implementation uses an internal array to store elements
 * and a counter to track the current position.</p>
 */
public class DefaultCountingOutRhymer {

    /**
     * Initial value of the counter indicating that the structure is empty.
     */
    private static final int TOTAL = -1;

    /**
     * Default value returned when an operation cannot be performed
     * (e.g., removing from an empty structure).
     */
    private static final int DEFAULT_RETURN_VALUE = -1;

    /**
     * Maximum number of elements that can be stored.
     */
    private static final int ARRAY_LENGTH = 12;

    /**
     * Internal array used to store elements.
     */
    private int[] numbers = new int[ARRAY_LENGTH];

    /**
     * Index of the last inserted element.
     */
    private int total = TOTAL;

    /**
     * Returns the current index of the last element.
     *
     * @return the index of the last stored element,
     *         or -1 if the structure is empty
     */
    public int getTotal() {
        return total;
    }

    /**
     * Adds a new number to the structure if it is not full.
     *
     * @param in the number to be added
     */
    public void countIn(int in) {
        if (!isFull())
            numbers[++total] = in;
    }

    /**
     * Checks whether the structure is empty.
     *
     * @return true if empty, false otherwise
     */
    public boolean callCheck() {
        return total == TOTAL;
    }

    /**
     * Checks whether the structure is full.
     *
     * @return true if full, false otherwise
     */
    public boolean isFull() {
        return total == ARRAY_LENGTH - 1;
    }

    /**
     * Returns the last element without removing it.
     *
     * @return the last element, or -1 if the structure is empty
     */
    protected int peekaboo() {
        if (callCheck())
            return DEFAULT_RETURN_VALUE;
        return numbers[total];
    }

    /**
     * Removes and returns the last element from the structure.
     *
     * @return the removed element, or -1 if the structure is empty
     */
    public int countOut() {
        if (callCheck())
            return DEFAULT_RETURN_VALUE;
        return numbers[total--];
    }
}