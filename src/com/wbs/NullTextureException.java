package com.wbs;


/**
 * Exception thrown if there is an error with texture assignment.
 */
public class NullTextureException extends NullPointerException {
    /**
     * Constructor for the NullTextureException
     */
    public NullTextureException ()
    {
        super("Texture is Null");
    }
}
