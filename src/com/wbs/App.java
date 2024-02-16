package com.wbs;
///////////////////////////////////////////////////////////////////////////////////////////////////
// Notes:
// * Add code to this as necessary to produce your simulation.
// * Use comments to clearly highlight your code that has been added.
// * Acknowledge/cite appropriately any added code that is not your own.
///////////////////////////////////////////////////////////////////////////////////////////////////

import org.marcprice.jff.simulation.*;


/**
 * App is the top-level class for the Aquarium simulation.
 * @author (your name here) and Marc Price
 * @version (enter the date here)
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



    /****************** CONSTRUCTORS **************************/
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
    }

    /****************** PUBLIC METHODS ************************/

    /**
     * METHOD: run the real-time loop.
     */
    public void run() throws Exception {
        // ADD some display objects to scene:
        // (to do)

        // RUN the real-time loop until the user has pressed the ESCAPE key...
        while (!_scene.isKeyPressed(ESCAPE_KEY)) {
            // UPDATE assets:
            // (to do)

            // RENDER scene:
            _scene.render();
        }

        // CLOSE _scene:
        _scene.close();
    }

    /****************** PRIVATE METHODS *************************/

}

