package com.wbs;

import org.marcprice.jff.simulation.DisplayObject;

/**
 * Sets-up and controls Pet objects.
 *
 * @author Jean-Sebastien Prenovost, Marc Price and Brad Carwardine
 * @version 07/03/2024
 * Acknowledgements: none.
 **/
abstract class Pet extends DisplayObject implements IUpdatable{

    /* ******************** MEMBER CONSTANTS ****************** */

    // DECLARE a String and set it to the path and filename for the Pet image, call it TEXTURE_FILENAME:
    protected static String TEXTURE_FILENAME = "./textures/JavaFish.png";


    /********************* MEMBER VARIABLES *******************/
    // DECLARE a float to control the X position of this Pet, call it _posnX:
    protected float _posnX = 0;

    // DECLARE a float to control the Y position of this Pet, call it _posnY:
    protected float _posnY = 0;

    // DECLARE a float to control the speed of this Pet, call it _speed:
    protected float _speed = 0.0002f;

    // DECLARE an int to control the horizontal direction of this Pet, call it _xDirection:
    protected int _xDirection = 1;

    // DECLARE an int to control the vertical direction of this Pet, call it _yDirection:
    protected int _yDirection = 1;


    /****************** CONSTRUCTORS ************************/

    /**
      Constructor for objects of class Pet.
     * @param posnX the x position of the Pet in the scene
     * @param posnY the y position of the Pet in the scene
     * @param size the scale-factor between 0.0 and 1.0 for the Pet
     * @param speed the speed of the pet
     * @throws Exception bubbled-up from lower-level operations in the JFF
     */
    public Pet(String textureName, float posnX, float posnY, float size, float speed) throws Exception {
        // INSTANTIATE parent:
        super(TEXTURE_FILENAME, posnX, posnY, size);
        // ASSIGN posnX to _posnX:
        _posnX = posnX;
        // ASSIGN posnY to _posnY:
        _posnY = posnY;
        // ASSIGN speed to _speed:
        _speed = speed;

        // CHECKS if the fish is spawned out of bounds
        try {
            if (_posnX > Window._maxX.value || _posnX < Window._minX.value || _posnY > Window._maxY.value || _posnY < Window._minY.value) {
                throw new OutOfBoundsException();
            }
        }
        catch (OutOfBoundsException oobe)
        {
            // THROW error to console.
            System.err.println("Error with pet creation: " + oobe.getMessage());
        }

        // RUN start method to initialise class
        this.start();
    }


    /* ***************** PUBLIC METHODS *********************** */

    /**
     * METHOD: Sets pet texture.
     */
    protected void setTextureFilename(String name) throws Exception {
        setTexture("./textures/" + name + ".png");
    }


    /**
     * METHOD: Called once on pet creation, runs initial pet preparation.
     */
    protected void start() throws Exception {
        // RUN Initialisation Code for Pet
    }

    /**
     * METHOD: update the Pet - to be called on each cycle of the simulation.
     */
    public void update() {
        move();
        boundCheck();
        setFacing();
    }

    /**
     * METHOD: Pet moving logic. called in update.
     */
    protected void move() {

    }

    /**
     * METHOD: Checks if the pet is against the wall.
     */
    protected void boundCheck() {
        // CHECKS if the X position exceeds the values set by the window enum.
        if (_posnX > Window._maxX.value || _posnX < Window._minX.value)
        {
            // Switches direction
            _xDirection *= -1;
        }
        // CHECKS if the Y position exceeds the values set by the window enum.
        if (_posnY > Window._maxY.value || _posnY < Window._minY.value)
        {
            // Switches direction
            _yDirection *= -1;
        }
    }


    /**
     * METHOD: Changes pet direction based on the X Direction.
     */
    protected void setFacing()
    {
        try {
            // CHECKS which direction the pet is going.
            if (_xDirection == 1)
            {
                // SETS the pet facing right
                this.setRightFacing();
            }
            else {
                // SETS the pet facing left
                this.setLeftFacing();
            }
        }
        catch (NullPointerException npe){
            // THROWS a custom user-defined exception for unavailable textures.
            throw new NullTextureException();
        }
    }
}
