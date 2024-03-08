package com.wbs;

import java.util.Random;


/**
 * Class for pet creation.
 *
 * @author Jean-Sebastien Prenovost
 *  * @version 07/03/2024
 * Acknowledgements: none.
 **/
public class PetFactory {

    // DECLARE new random object for determining the position and speed of the pet, name it _random:
    Random _random;


    /* ***************** CONSTRUCTORS *********************** */

    /**
     Constructor for objects of class JavaFish.
     */
    public PetFactory()
    {
        // SET random object to new
        _random = new Random();
    }


    /**
     * METHOD: Creates a JavaFish
     * @param bubbleEvent reference to the bubble event
     * @return JavaFish Object
     * @throws Exception
     */
    public Pet JavaFish(IBubbleEvent bubbleEvent) throws Exception {

        // SET Random x value in the bounds of the screen
        float _xPos = _random.nextFloat(Window._minX.value, Window._maxX.value);

        // SET Random Y value within the bounds of the screen
        float _yPos = _random.nextFloat(Window._minY.value, Window._maxY.value);

        // SET Random Speed that is within an acceptable speed range
        float speed = _random.nextFloat(0.0002f, 0.0010f);

        // RETURN Prepared JavaFish:
        return new JavaFish(_xPos, _yPos, 0.05f, speed, bubbleEvent);
    }


    /**
     * METHOD: Creates a Seahorse
     * @return Seahorse Object
     * @throws Exception
     */
    public Pet SeaHorse() throws Exception {

        // SET Random x value in the bounds of the screen
        float _xPos = _random.nextFloat(Window._minX.value, Window._maxX.value);

        // SET Random Y value within the bounds of the screen
        float _yPos = _random.nextFloat(Window._minY.value, Window._maxY.value);

        // SET Random Speed that is within an acceptable speed range
        float speed = _random.nextFloat(0.0002f, 0.0010f);

        // RETURN Prepared Seahorse:
        return new Seahorse(_xPos, _yPos, 0.05f, speed);
    }


    /**
     * METHOD: Creates an Urchin
     * @return Urchin Object
     * @throws Exception
     */
    public Pet Urchin() throws Exception {

        // SET Random x value in the bounds of the screen
        float _xPos = _random.nextFloat(Window._minX.value, Window._maxX.value);

        // SET Random Y value within the bounds of the screen
        float _yPos = _random.nextFloat(Window._minY.value, Window._lowerY.value);

        // SET Random Speed that is within an acceptable speed range
        float speed = _random.nextFloat(0.0002f, 0.0010f);

        // RETURN Prepared Urchin
        return new Urchin(_xPos, _yPos, 0.05f, speed);
    }


    /**
     * METHOD: Creates a Piranha
     * @return Piranha Object
     * @throws Exception
     */
    public Pet Piranha() throws Exception {

        // SET Random x value in the bounds of the screen
        float _xPos = _random.nextFloat(Window._minX.value, Window._maxX.value);

        // SET Random Y value within the bounds of the screen
        float _yPos = _random.nextFloat(Window._minY.value, Window._maxY.value);

        // SET Random Speed that is within an acceptable speed range
        float speed = _random.nextFloat(0.0002f, 0.0010f);

        // RETURN Prepared Piranha:
        return new Piranha(_xPos, _yPos, 0.05f, speed);
    }

}
