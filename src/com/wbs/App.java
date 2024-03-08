package com.wbs;
///////////////////////////////////////////////////////////////////////////////////////////////////
// Notes:
// * Add code to this as necessary to produce your simulation.
// * Use comments to clearly highlight your code that has been added.
// * Acknowledge/cite appropriately any added code that is not your own.
///////////////////////////////////////////////////////////////////////////////////////////////////

import org.marcprice.jff.simulation.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;


/**
 * App is the top-level class for the Aquarium simulation.
 * @author Jean-Sebastien Prenovost and Marc Price
 * @version 07/03/2024
 *
 */
public class App {

    /***************** Program Entry-point ********************/
    public static void main(String[] args) throws Exception {
        App app = new App(new SceneMaker());
        app.run();
    }
    /**********************************************************/

    /***************** MEMBER CONSTANTS ***********************/
    // DECLARE & set an int to represent the key code for the ESC key, call it ESCAPE_KEY:
    private static final int ESCAPE_KEY = 256;


    /********************* MEMBER VARIABLES *******************/
    // DECLARE a Scene to store the scene, call it _scene:
    private Scene _scene;

    // DECLARE a float to store the aspect ratio of the window, call it _aspectRatio:
    private float _aspectRatio = 1.0f;

    // DECLARE an ArrayList to store all objects to be updated;, call it _updatables:
    private CopyOnWriteArrayList<IUpdatable> _updatables;

    // DECLARE a Pet Factory to create pets, call it _petFactory:
    private PetFactory _petFactory;

    // DECLARE a Bubble Factory to create pets, call it _bubbleFactory:
    private BubbleFactory _bubbleFactory;

    /* ***************** CONSTRUCTORS ************************* */

    /**
     * Constructor for top-level App class
     * @param sceneMaker used by JFF2 to make a Scene (window).
     * @throws Exception all exceptions are bubbled-up to the user.
     */
    public App(SceneMaker sceneMaker) throws Exception {
        // CREATE _scene:
        _scene = new Scene(sceneMaker);

        // SET the aspect ratio of the scene:
        _aspectRatio = _scene.getWindowHeight();
        _aspectRatio /= _scene.getWindowWidth();

        // CREATE new Pet Factory to create pets.
        _petFactory = new PetFactory();

        // CREATE new updatables list for all objects to be updated.
        _updatables = new CopyOnWriteArrayList<>();

        // CREATE new bubble factory for bubbles to be created by the JavaFish
        _bubbleFactory = new BubbleFactory(_scene, _updatables);
    }

    /****************** PUBLIC METHODS ************************/

    /**
     * METHOD: run the real-time loop.
     */
    public void run() throws Exception {

        populate();

        // RUN the real-time loop until the user has pressed the ESCAPE key...
        while (!_scene.isKeyPressed(ESCAPE_KEY)) {

            // LOOP over the updatable objects and update them.
            for(IUpdatable object : _updatables)
            {
                object.update();
            }

            // RENDER scene:
            _scene.render();
        }

        // CLOSE _scene:
        _scene.close();
    }

    /****************** PRIVATE METHODS *************************/

    /**
     * METHOD: Populate the Scene.
     */
    private void populate() throws Exception
    {
        // LOOP 5 times
        for(int i = 0; i < 5; i++)
        {
            // CREATE a JavaFish
            Pet javaFish = _petFactory.JavaFish(_bubbleFactory);
            // ADD display object to scene
            _scene.addDisplayObject(javaFish);
            // ADD to updatable list
            _updatables.add(javaFish);
        }
        // LOOP 5 times
        for(int i = 0; i < 5; i++)
        {
            // CREATE a Piranha
            Pet piranha = _petFactory.Piranha();
            // ADD display object to scene
            _scene.addDisplayObject(piranha);
            // ADD to updatable list
            _updatables.add(piranha);
        }
        // LOOP 5 times
        for(int i = 0; i < 5; i++)
        {
            // CREATE a Seahorse
            Pet seahorse = _petFactory.SeaHorse();
            // ADD display object to scene
            _scene.addDisplayObject(seahorse);
            // ADD to updatable list
            _updatables.add(seahorse);
        }
        // LOOP 5 times
        for(int i = 0; i < 5; i++)
        {
            // CREATE an Urchin
            Pet urchin = _petFactory.Urchin();
            // ADD display object to scene
            _scene.addDisplayObject(urchin);
            // ADD to updatable list
            _updatables.add(urchin);
        }
    }
}