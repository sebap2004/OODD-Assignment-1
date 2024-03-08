package com.wbs;

import java.util.Random;

/**
 * Sets-up and controls JavaFish objects.
 *
 * @author Jean-Sebastien Prenovost, Marc Price and Brad Carwardine
 *  @version 07/03/2024
 * Acknowledgements: none.
 **/
public class JavaFish extends Pet {

    /********************* MEMBER CONSTANTS *******************/
    private final Random _random;
    private int _bubbleInterval;
    private float _bubbleSpawnPoint = 0.05f;
    private int _currentFrame;
    private IBubbleEvent _bubbleSpawner;

    /* ***************** CONSTRUCTORS *********************** */

    /**
     Constructor for objects of class JavaFish.
     * @param posnX the x position of the JavaFish in the scene
     * @param posnY the y position of the JavaFish in the scene
     * @param size the scale-factor between 0.0 and 1.0 for the JavaFish
     * @param speed the speed of the JavaFish
     * @throws Exception bubbled-up from lower-level operations in the JFF
     */
    public JavaFish(float posnX, float posnY, float size, float speed, IBubbleEvent bubbleEvent) throws Exception {
        // INSTANTIATE parent:
        super(TEXTURE_FILENAME, posnX, posnY, size, speed);

        // INSTANTIATE new random class
        _random = new Random();

        // ADDS reference to the bubble factory
        addBubbleReference(bubbleEvent);

        // SETS random number for bubble interval.
        _bubbleInterval = _random.nextInt(150, 300);
    }


    /****************** PUBLIC METHODS ************************/

    @Override
    protected void start() {
        try {
            setTextureFilename("JavaFish");
        }
        catch (Exception e)
        {
            System.out.println("Error setting Piranha Texture");
        }
    }


    /**
     * METHOD: Adds reference to the bubble event handle
     * @param bubbleEvent reference to the bubble event handler.
     */
    private void addBubbleReference(IBubbleEvent bubbleEvent)
    {
        // SET _bubbleSpawner to the bubbleEvent parameter
        _bubbleSpawner = bubbleEvent;
    }

    @Override
    public void update() {
        // RUNS parent update function.
        super.update();
        // RUNS spawn bubble method.
        spawnBubbles();
    }

    @Override
    protected void move() {
        // MOVES JavaFish Horizontally.
        this.setPositionX(_posnX += _xDirection * _speed);
    }


    /**
     * METHOD: Spawns bubbles.
     */
    private void spawnBubbles()
    {
        // INCREMENT frame index
        _currentFrame++;

        // CHECKS if frame index is greater than the set interval
        if (_currentFrame >= _bubbleInterval)
        {
            // RESETS frame index to 0
            _currentFrame = 0;

            // CHANGES bubble interval to a new number
            _bubbleInterval = _random.nextInt(150, 300);

            // Checks if the bubble spawner is available (not null)
            try {
                // SPAWNS bubble at the JavaFish's mouth
                _bubbleSpawner.spawnBubble(this._posnX + (_bubbleSpawnPoint * _xDirection), this._posnY);
            } catch (Exception e){
                System.err.println("Bubble Spawner not available");
            }

        }
    }
}
