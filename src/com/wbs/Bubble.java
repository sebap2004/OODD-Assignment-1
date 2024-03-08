package com.wbs;

import org.marcprice.jff.simulation.DisplayObject;

/**
 * Sets-up and controls Bubble objects.
 *
 * @author Jean-Sebastien Prenovost, Marc Price and Brad Carwardine
 *  @version 07/03/2024
 * Acknowledgements: none.
 **/
public class Bubble extends DisplayObject implements IUpdatable{

    /********************* MEMBER CONSTANTS *******************/
    // DECLARE a String and set it to the path and filename for the Bubble image, call it TEXTURE_FILENAME:
    private static String TEXTURE_FILENAME = "./textures/Bubble.png";


    /********************* MEMBER VARIABLES *******************/
    // DECLARE a float to control the X position of this Bubble, call it _posnX:
    private float _posnX = 0;

    // DECLARE a float to control the Y position of this Bubble, call it _posnY:
    private float _posnY = 0;

    // DECLARE a float to control the speed of this Bubble, call it _speed:
    private float _speed = 0.0002f;

    // DECLARE an int to control the vertical direction of this Bubble, call it _yDirection:
    private int _yDirection = 1;

    private IBubbleEvent _bubbleEvent;

    /****************** CONSTRUCTORS ************************/

    /**
      Constructor for objects of class Bubble.
     * @param posnX the x position of the Bubble in the scene
     * @param posnY the y position of the Bubble in the scene
     * @param size the scale-factor between 0.0 and 1.0 for the Bubble
     * @param speed the speed of the Bubble
     * @throws Exception bubbled-up from lower-level operations in the JFF
     */
    public Bubble(float posnX, float posnY, float speed, float size, IBubbleEvent bubbleEvent) throws Exception {
        // INSTANTIATE parent:
        super(TEXTURE_FILENAME, posnX, posnY, size);

        // ASSIGN posnX to _posnX:
        _posnX = posnX;

        // ASSIGN posnY to _posnY:
        _posnY = posnY;

        // ASSIGN speed to _speed:
        _speed = speed;

        _bubbleEvent = bubbleEvent;

        // RUN start method to initialise class
        this.start();
    }


    /* ***************** PUBLIC METHODS *********************** */

    /**
     * METHOD: Sets position of the bubble
     */
    public void setPosition(float x, float y)
    {
        this.setPositionX(x);
        this.setPositionY(y);
    }

    /**
     * METHOD: Called once on Bubble creation, runs initial Bubble preparation.
     */
    protected void start() {
        setPosition(_posnX, _posnY);
        System.out.println("bubble created at " + _posnX + " " + _posnY);
    }

    /**
     * METHOD: update the Bubble - to be called on each cycle of the simulation.
     */
    public void update() {
        move();
        boundCheck();
    }

    /**
     * METHOD: Bubble moving logic. called in update.
     */
    protected void move() {
        this.setPositionY(_posnY += _yDirection * _speed);
    }

    /**
     * METHOD: Checks if the Bubble is against the wall.
     */
    protected void boundCheck() {
        if (_posnY > Window._maxY.value)
        {
            _bubbleEvent.deleteBubble(this);
        }
    }
}
