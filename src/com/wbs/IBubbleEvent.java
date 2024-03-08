package com.wbs;


/**
 * Interface: Allows objects to communicate with the bubble factory to spawn bubbles.
 */
public interface IBubbleEvent {

    /**
     * METHOD: Spawns a bubble.
     * @param xPos X position of the bubble to be spawned
     * @param yPos Y position of the bubble to be spawned
     */
    void spawnBubble(float xPos, float yPos);

    /**
     * METHOD: Deletes a bubble.
     * @param bubble reference to the bubble
     */
    void deleteBubble(Bubble bubble);
}
