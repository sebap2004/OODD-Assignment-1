package com.wbs;

import org.marcprice.jff.simulation.Scene;

import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
/**
 * Factory that creates bubbles for any class that has a reference to BubbleEvent.
 *
 * @author Jean-Sebastien Prenovost
 *  @version 07/03/2024
 * Acknowledgements: none.
 **/
public class BubbleFactory implements IBubbleEvent {

    // DEFINE a random object for speed and size generation.
    private final Random _random;


    /**
     * Constructor for top-level App class
     * @param p_scene reference to the app scene to create DisplayObjects.
     * @param p_updatables reference to the updatables list to add bubbles to it.
     */
    public BubbleFactory(Scene p_scene, CopyOnWriteArrayList<IUpdatable> p_updatables)
    {
        // SET _updatable to p_updatables
        _updatables = p_updatables;
        // SET _scene to p_scene
        _scene = p_scene;
        // SET _random to a new random object
        _random = new Random();
    }

    // DEFINE reference to the app updatables list, name it _updatables:
    private final CopyOnWriteArrayList<IUpdatable> _updatables;

    // DEFINE reference to the app scene, name it _scene:
    private final Scene _scene;

    @Override
    public void spawnBubble(float xPos, float yPos){

        // RANDOMIZES speed and size.
        float speed = _random.nextFloat(0.0002f, 0.0010f);
        float size = _random.nextFloat(0.005f, 0.010f);

        // TRIES to instantiate and add a bubble into the scene.
        try {
            Bubble bubble = new Bubble(xPos, yPos, speed, size, this);
            _scene.addDisplayObject(bubble);
            _updatables.add(bubble);
        }
        // THROWS error if there are any problems.
        catch (Exception e)
        {
            System.out.println("Error with creating bubble.");
        }

    }

    @Override
    public void deleteBubble(Bubble bubble){
        // TRY to delete a bubble
        try {
            _scene.removeDisplayObject(bubble);
        }
        // IF bubble is null throw an exception.
        catch (Exception e){
            System.err.println("Bubble is null, can't delete anything.");
        }
    }
}
