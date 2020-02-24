package com.funguscow.game.player;

/**
 * Game data for bag, money, etc. for the player
 * @author alpac
 *
 */
public class PlayerData {
	
	private int money;
	private Bag bag;
	
	public PlayerData() {
		money = 0;
		bag = new Bag();
	}
	
	/**
	 * 
	 * @return The Bag object containing the player's inventory
	 */
	public Bag getBag() {
		return bag;
	}
	
	/**
	 * Give or take amt from player's money
	 * @param amt Amount to give (or take, if negative)
	 * @return Whether the money was successfully given/taken
	 */
	public boolean addMoney(int amt) {
		if(-amt > money)
			return false;
		money += amt;
		return true;
	}
	
	/**
	 * 
	 * @return The player's current money
	 */
	public int getMoney() {
		return money;
	}

}
