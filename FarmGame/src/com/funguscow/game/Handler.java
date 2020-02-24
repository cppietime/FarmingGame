package com.funguscow.game;

import com.funguscow.game.location.Location;
import com.funguscow.game.location.farm.Field;
import com.funguscow.game.player.PlayerData;

/**
 * Class of static common-use items
 * @author alpac
 *
 */
public class Handler {
	
	public static Location curHandler = Field.Instance;
	public static PlayerData player = new PlayerData();

}
