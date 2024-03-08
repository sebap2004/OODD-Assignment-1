package com.wbs;

/**
 * Sets-up and controls Piranha objects.
 *
 * @author Jean-Sebastien Prenovost, Marc Price and Brad Carwardine
 *  @version 07/03/2024
 * Acknowledgements: none.
 **/
public class Piranha extends Pet {
    /* ***************** CONSTRUCTORS *********************** */

    /**
     Constructor for objects of class Piranha.
     * @param posnX the x position of the Piranha in the scene
     * @param posnY the y position of the Piranha in the scene
     * @param size the scale-factor between 0.0 and 1.0 for the Piranha
     * @param speed the speed of the Piranha
     * @throws Exception bubbled-up from lower-level operations in the JFF
     */
    public Piranha(float posnX, float posnY, float size, float speed) throws Exception {
        // INSTANTIATE parent:
        super(TEXTURE_FILENAME, posnX, posnY, size, speed);
    }


    /* ***************** PUBLIC METHODS *********************** */


    @Override
    protected void start() {
        try {
            setTextureFilename("PiranhaGreen");
        }
        catch (Exception e)
        {
            System.out.println("Error setting Piranha Texture");
        }
    }

    @Override
    protected void move() {
        this.setPositionX(_posnX += _xDirection * _speed);
    }
}
