package com.funguscow.game.location.farm;

import com.funguscow.game.items.Item;

/**
 * Species of crop
 * @author alpac
 *
 */
public class PlantType {

	private String name;
	private int seasons;
	private int stages;
	private Item item;

	/**
	 * 
	 * @param name Name of crop
	 * @param value Value in money for mature crop
	 * @param seasons In which seasons can it grow
	 * @param stages How many growth stages
	 */
	public PlantType(String name, int seasons, int stages, Item item) {
		this.name = name;
		this.seasons = seasons;
		this.stages = stages;
		this.item = item;
	}

	/**
	 * 
	 * @return Name of the crop
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @return What seasons this crop can grow in OR'd together
	 */
	public int getSeasons() {
		return seasons;
	}

	/**
	 * 
	 * @return Number of stages to maturity
	 */
	public int getStages() {
		return stages;
	}
	
	/**
	 * Check if this crop can grow in a certain season
	 * @param season Season to test
	 * @return true if this crop can grow in season
	 */
	public boolean canGrowIn(int season) {
		return (seasons & season) != 0;
	}
	
	/**
	 * 
	 * @return The item received when this crop is harvested
	 */
	public Item getItem() {
		return item;
	}

}
