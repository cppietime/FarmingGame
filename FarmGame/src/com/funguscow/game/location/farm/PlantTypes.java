package com.funguscow.game.location.farm;

import com.funguscow.game.items.Items;

/**
 * Container class for all plant species
 * 
 * @author alpac
 *
 */
public class PlantTypes {

	public static final byte WINTER = 1, SPRING = 2, SUMMER = 4, FALL = 8;

	public static final PlantType strawberry = new PlantType("Strawberry", SPRING | SUMMER | FALL, 5, Items.strawberry);

}
