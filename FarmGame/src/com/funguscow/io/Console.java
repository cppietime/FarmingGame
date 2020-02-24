package com.funguscow.io;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.funguscow.game.Handler;

/**
 * A WIP class representing the UI window.
 * I may make this semi-graphical in the future
 * @author alpac
 *
 */
public class Console {
	
	public static final int rows = 20, cols = 80;
	private static Scanner scanner = new Scanner(System.in);
	private static List<char[]> buffer = new ArrayList<char[]>();
	private static int lineNum = 0;
	
	/**
	 * Draws the current buffer to the screen
	 */
	public static void updateScreen() {
		for(int i = 0; i < rows; i++)
			System.out.println();
		for(int i = 0; i < lineNum; i++) {
			for(int j = 0; j < cols; j ++) {
				char c = buffer.get(i)[j];
				if(c <= ' ')
					System.out.print(' ');
				else
					System.out.print(c);
			}
			System.out.println();
		}
	}
	
	/**
	 * Clears the buffer and resets the line number
	 */
	public static void clearScreen() {
		buffer.clear();
		lineNum = 0;
	}
	
	/**
	 * Receive line of input from user
	 * @param required If false, this can be empty
	 * @return Input line
	 */
	public static String getLine(boolean required) {
		String line = "";
		do {
			line = scanner.nextLine();
		}while(line.length() == 0 && required);
		return line;
	}
	
	/**
	 * Put a string w/o a newline
	 * @param line Line to put
	 */
	public static void put(String line) {
		int col = 0;
		for(int i = 0; i < line.length(); i++) {
			if(lineNum >= buffer.size())
				buffer.add(new char[cols]);
			if(line.charAt(i) == '\n') {
				col = 0;
				lineNum++;
				continue;
			}
			buffer.get(lineNum)[col] = line.charAt(i);
			col++;
			if(col == cols && i + 1 < line.length()) {
				col = 0;
				lineNum++;
			}
		}
	}
	
	/**
	 * Same as put, but with a newline
	 * @param line
	 */
	public static void putLine(String line) {
		put(line);
		lineNum++;
		buffer.add(new char[cols]);
	}
	
	public static void main(String[] argv) {
		while(true) {
			Handler.curHandler.gameLoop();
		}
	}

}
