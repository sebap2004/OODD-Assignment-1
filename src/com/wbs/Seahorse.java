package com.wbs;

/**
 * Sets-up and controls Seahorse objects.
 *
 * @author Jean-Sebastien Prenovost, Marc Price and Brad Carwardine
 *  @version 07/03/2024
 * Acknowledgements: none.
 **/
public class Seahorse extends Pet {

    /* ***************** CONSTRUCTORS *********************** */

    /**
     Constructor for objects of class Seahorse.
     * @param posnX the x position of the Seahorse in the scene
     * @param posnY the y position of the Seahorse in the scene
     * @param size the scale-factor between 0.0 and 1.0 for the Seahorse
     * @param speed the speed of the Seahorse
     * @throws Exception bubbled-up from lower-level operations in the JFF
     */
    public Seahorse(float posnX, float posnY, float size, float speed) throws Exception {
        // INSTANTIATE parent:
        super(TEXTURE_FILENAME, posnX, posnY, size, speed);
    }


    /****************** PUBLIC METHODS ************************/

    @Override
    protected void start() throws Exception {
        setTextureFilename("Seahorse");
    }

    @Override
    protected void move() {
        this.setPositionX(_posnX += _xDirection * _speed);
        this.setPositionY(_posnY += _yDirection * _speed);
    }
}
