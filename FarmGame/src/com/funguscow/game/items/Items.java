package com.funguscow.game.items;

/**
 * Container class for all items
 * @author alpac
 *
 */
public class Items {

	public static final Item test_seed = new Item("Seeds") {
		public boolean isSeed() {
			return true;
		}
	};
	public static final Item strawberry = new Item("Strawberry", 10);

}
