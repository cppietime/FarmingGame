package com.funguscow.game.location;

/**
 * The places or screens in the world the player can be at/on
 * @author alpac
 *
 */
public abstract class Location {

	/**
	 * The game loop function to call when this location is active
	 */
	public abstract void gameLoop();

	/**
	 * Called when this location is entered
	 */
	public void enter() {
	}

	/**
	 * Called when this location is left
	 */
	public void leave() {
	}

}
