package com.wbs;


/**
 * Window enumerator that specifies the dimensions of the window.
 *
 * @author Jean-Sebastien Prenovost
 * @version 07/03/2024
 * Acknowledgements: none.
 **/
public enum Window {

    // DEFINE max screen width
    _maxX(0.95f),

    // DEFINE minimum screen width
    _minX(0.04f),

    // DEFINE lower screen height bound for urchins
    _lowerY(0.1f),

    // DEFINE maximum screen height bound for urchins
    _maxY(0.72f),

    // DEFINE minimum screen height bound for urchins
    _minY(0.03f);

    // DEFINE value to be read by objects that need it
    public final float value;

    /* ***************** CONSTRUCTORS *********************** */

    /**
     * Constructor for Window enum.
     * @param p_value sets the value for the enum values.
     */
    Window(float p_value) {
        value = p_value;
    }
}
