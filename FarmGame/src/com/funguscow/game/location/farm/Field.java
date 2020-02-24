package com.funguscow.game.location.farm;

import com.funguscow.game.location.Location;
import com.funguscow.io.Console;

/**
 * The location where crops are grown, harvested, etc.
 * @author alpac
 *
 */
public class Field extends Location {

	public static Field Instance = new Field();

	private static final int MAXFIELDS = 24, FIELDSPERLINE = 3;

	private int fields;
	private Plant crops[];

	public Field() {
		fields = 24;
		crops = new Plant[MAXFIELDS];
		crops[0] = new Plant(PlantTypes.strawberry);
	}

	private void showCrops() {
		int lines = (fields + FIELDSPERLINE - 1) / FIELDSPERLINE;
		for (int i = 0; i < lines; i++) {
			String line = "";
			for (int j = i * FIELDSPERLINE; j < fields && j < (i + 1) * FIELDSPERLINE; j++) {
				String desc = "Empty";
				Plant crop = crops[j];
				if (crop != null) {
					String name = crop.getSpecies().getName();
					if (crop.isReady())
						desc = String.format("%s (%s!)", name, "Mature");
					else
						desc = String.format("%s (%d/%d)", name, crop.getGrowth() + 1,
								crop.getSpecies().getStages() + 1);
				}
				line += String.format(String.format("%%-%ds", Console.cols / FIELDSPERLINE),
						String.format("%-3d: %s", j, desc));
			}
			Console.putLine(line);
		}
	}

	public void gameLoop() {
		boolean running = true;
		while (running) {
			Console.clearScreen();
			showCrops();
			Console.updateScreen();
			String input = Console.getLine(true);
			if (input.equals("grow")) {
				for (int i = 0; i < fields; i++) {
					if (crops[i] != null)
						crops[i].grow();
				}
			}
		}
	}

}
