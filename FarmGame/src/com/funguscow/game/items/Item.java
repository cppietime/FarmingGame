package com.funguscow.game.items;

/**
 * All items are or extends this
 * @author alpac
 *
 */
public class Item {

	private String name;
	private int value;
	
	/**
	 * Item that can be sold
	 * @param name Name of item
	 * @param value Value when sold
	 */
	public Item(String name, int value) {
		this.name = name;
		this.value = value;
	}
	
	/**
	 * Constructor for non-sellable item
	 * @param name Name of this item
	 */
	public Item(String name) {
		this(name, 0);
	}
	
	/**
	 * 
	 * @return Item name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 
	 * @return Is this a crop seed?
	 */
	public boolean isSeed() {
		return false;
	}
	
	/**
	 * 
	 * @return The item's value, or 0 if not sellable
	 */
	public int getValue() {
		return value;
	}
	
	public int hashCode() {
		return name.hashCode();
	}
	
}
