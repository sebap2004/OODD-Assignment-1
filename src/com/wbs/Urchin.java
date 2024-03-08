package com.wbs;


/**
 * Sets-up and controls urchin objects.
 *
 * @author Jean-Sebastien Prenovost, Marc Price and Brad Carwardine
 *  @version 07/03/2024
 * Acknowledgements: none.
 **/
public class Urchin extends Pet {


    /* ***************** CONSTRUCTORS *********************** */

    /**
     Constructor for objects of class Urchin.
     * @param posnX the x position of the Urchin in the scene
     * @param posnY the y position of the Urchin in the scene
     * @param size the scale-factor between 0.0 and 1.0 for the Urchin
     * @param speed the speed of the Urchin
     * @throws Exception bubbled-up from lower-level operations in the JFF
     */
    public Urchin(float posnX, float posnY, float size, float speed) throws Exception {
        super(TEXTURE_FILENAME, posnX, posnY, size, speed);
        // SET texture name to Urchin
        setTextureFilename("Urchin");
    }

    @Override
    protected void move() {
        this.setPositionX(_posnX += _xDirection * _speed);
    }
}
