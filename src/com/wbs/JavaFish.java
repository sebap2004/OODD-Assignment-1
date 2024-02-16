package com.wbs;

/**
 * Sets-up and controls JavaFish objects.
 *
 * @author (your name here), Marc Price and Brad Carwardine
 *  * @version (enter the date here)
 * Acknowledgements: none.
 **/
public class JavaFish extends Pet {

    /********************* MEMBER CONSTANTS *******************/



    /****************** CONSTRUCTORS ************************/
    /**
      Constructor for objects of class JavaFish.
     * @param posnX the x position of the JavaFish in the scene
     * @param posnY the y position of the JavaFish in the scene
     * @param size the scale-factor between 0.0 and 1.0 for the JavaFish
     * @throws Exception bubbled-up from lower-level operations in the JFF
     */
    public JavaFish(float posnX, float posnY, float size) throws Exception {
        // INSTANTIATE parent:
        super(TEXTURE_FILENAME, posnX, posnY, size);

        // ASSIGN posnX to _posnX:
        _posnX = posnX;

        // ASSIGN posnY to _posnY:
        _posnY = posnY;

        setPosition(_posnX, _posnY);

        setTextureFilename("./textures/JavaFish.png");
    }


    /****************** PUBLIC METHODS ************************/
    /**
     * METHOD: update the JavaFish - to be called on each cycle of the simulation.
     */
    public void update() {
        // UPDATE x position:
        this.setPositionX(_posnX += _direction * _speed);
    }


}
