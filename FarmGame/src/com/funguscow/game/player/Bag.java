package com.funguscow.game.player;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.funguscow.game.items.Item;
import com.funguscow.game.items.Items;
import com.funguscow.io.Console;

/**
 * The player's inventory. Keeps track of items and quantities
 * @author alpac
 *
 */
public class Bag {

	private static final int ITEMSPERLINE = 4;

	private Map<Item, Integer> bag;

	public Bag() {
		bag = new HashMap<Item, Integer>();
		bag.put(Items.test_seed, 2);
	}

	/**
	 * 
	 * @param item Item to check
	 * @return Number of item
	 */
	public int getBagCount(Item item) {
		return bag.getOrDefault(item, 0);
	}

	/**
	 * Player receives an item
	 * @param item
	 * @param amt Number of the item
	 */
	public void getItem(Item item, int amt) {
		bag.put(item, getBagCount(item) + amt);
	}

	/**
	 * 
	 * @param item
	 * @param amt
	 * @return Does player have at least amt of item
	 */
	public boolean hasItem(Item item, int amt) {
		return getBagCount(item) >= amt;
	}

	/**
	 * Take amt of item from player
	 * @param item
	 * @param amt
	 * @return Whether successful (i.e. they had enough)
	 */
	public boolean takeItem(Item item, int amt) {
		int amt_after = getBagCount(item) - amt;
		if (amt_after < 0)
			return false;
		else if (amt_after == 0)
			bag.remove(item);
		else
			bag.put(item, amt_after);
		return true;
	}

	/**
	 * 
	 * @return Set of all owned items
	 */
	public Set<Item> getItems() {
		return bag.keySet();
	}

	private void display(List<Item> items) {
		if (items.isEmpty()) {
			Console.putLine("Empty...");
			return;
		}
		int lines = (items.size() + ITEMSPERLINE - 1) / ITEMSPERLINE;
		for (int i = 0; i < lines; i++) {
			String line = "";
			for (int j = i * ITEMSPERLINE; j < (i + 1) * ITEMSPERLINE && j < items.size(); j++) {
				Item item = items.get(j);
				line += String.format(String.format("%%-%ds", Console.cols / ITEMSPERLINE),
						String.format("%d: %s x%d", j, item.getName(), bag.get(item)));
			}
			Console.putLine(line);
		}
	}

	/**
	 * Shows items, only those that follow selection
	 * @param selection
	 */
	public void showBag(Predicate<Item> selection) {
		List<Item> itemSet = bag.keySet().stream().filter(selection).collect(Collectors.toList());
		display(itemSet);
	}

	/**
	 * Get a user selection of an item following selection
	 * @param selection
	 * @return The selected Item
	 */
	public Item selectItem(Predicate<Item> selection) {
		List<Item> itemSet = bag.keySet().stream().filter(selection).collect(Collectors.toList());
		if (itemSet.isEmpty())
			return null;
		int choice = -1;
		while (choice < 0 || choice >= itemSet.size()) {
			Console.clearScreen();
			display(itemSet);
			Console.putLine("Type the number of your selection or c for CANCEL:");
			Console.updateScreen();
			String input = Console.getLine(true);
			if (input.equalsIgnoreCase("c"))
				return null;
			try {
				choice = Integer.parseInt(input);
			} catch (Exception e) {
				Console.putLine("Please enter a valid number!");
				Console.updateScreen();
				Console.getLine(false);
			}
		}
		return itemSet.get(choice);
	}

}
