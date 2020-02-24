package com.funguscow.game.location.farm;

/**
 * An instance of a crap
 * @author alpac
 *
 */
public class Plant {

	private PlantType species;
	private int growth;

	/**
	 * New crop of a certain species
	 * @param species
	 */
	public Plant(PlantType species) {
		this.species = species;
		this.growth = 0;
	}

	/**
	 * Advance growth one stage
	 */
	public void grow() {
		if (++growth > species.getStages())
			growth = species.getStages();
	}
	
	/**
	 * 
	 * @return This crop's species
	 */
	public PlantType getSpecies() {
		return species;
	}
	
	/**
	 * 
	 * @return The current growth stage
	 */
	public int getGrowth() {
		return growth;
	}
	
	/**
	 * 
	 * @return Is this crop mature
	 */
	public boolean isReady() {
		return growth == species.getStages();
	}

}
