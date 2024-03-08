package com.wbs;

/**
 * Exception thrown if a pet is created outside the bounds of the window.
 */
public class OutOfBoundsException extends Exception {
    /**
     * Constructor for the exception.
     */
    public OutOfBoundsException()
    {
        super("Pet created out of bounds");
    }
}
