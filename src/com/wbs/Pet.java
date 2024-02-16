package com.wbs;

import org.marcprice.jff.simulation.DisplayObject;

/**
 * Sets-up and controls JavaFish objects.
 *
 * @author (your name here), Marc Price and Brad Carwardine
 *  * @version (enter the date here)
 * Acknowledgements: none.
 **/
abstract class Pet extends DisplayObject implements IUpdatable{

    /********************* MEMBER CONSTANTS *******************/
    // DECLARE a String and set it to the path and filename for the JavaFish image, call it TEXTURE_FILENAME:
    protected static String TEXTURE_FILENAME = "./textures/JavaFish.png";


    /********************* MEMBER VARIABLES *******************/
    // DECLARE a float to control the x position of this JavaFish, call it _posnX:
    protected float _posnX = 0.1f;

    // DECLARE a float to control the y position of this JavaFish, call it _posnY:
    protected float _posnY = 0.1f;

    // DECLARE a float to control the speed of this JavaFish, call it _speed:
    protected float _speed = 0.0002f;

    // DECLARE an int to control the direction of this JavaFish, call it _direction:
    protected int _direction = 1;


    /****************** CONSTRUCTORS ************************/
    /**
      Constructor for objects of class JavaFish.
     * @param posnX the x position of the JavaFish in the scene
     * @param posnY the y position of the JavaFish in the scene
     * @param size the scale-factor between 0.0 and 1.0 for the JavaFish
     * @throws Exception bubbled-up from lower-level operations in the JFF
     */
    public Pet(String textureName, float posnX, float posnY, float size) throws Exception {
        // INSTANTIATE parent:
        super(TEXTURE_FILENAME, posnX, posnY, size);

        // ASSIGN posnX to _posnX:
        _posnX = posnX;

        // ASSIGN posnY to _posnY:
        _posnY = posnY;
    }


    /****************** PUBLIC METHODS ************************/
    /**
     * METHOD: update the JavaFish - to be called on each cycle of the simulation.
     */

    public void setPosition(float x, float y)
    {
        this.setPositionX(x);
        this.setPositionY(y);
    }

    public void setOrientation(float x, float y)
    {
        this.setOrientation(x);
    }

    public void setTextureFilename(String name) throws Exception {
        setTexture(name);
    }


    public void update() {

    }
}
