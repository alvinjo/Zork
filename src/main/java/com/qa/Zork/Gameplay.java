package com.qa.Zork;

import java.util.ArrayList;
import java.util.Scanner;

public class Gameplay {

	Scanner input = new Scanner(System.in);
	int yIndex = 2; 
	int xIndex = 4;
	boolean gameOver = false;
	Map map = new Map();
	ItemAction itemAction = new ItemAction(map, this);
	ArrayList<String> inventory = new ArrayList<>();

	
	public Gameplay() {
		addToInventory("Magic Compass");
	}

	public void action() {
		System.out.println("#");
		String command = input.nextLine();

		switch (command) {
		case "use":
		case "u":
		case "U":
			useAction();
			System.out.println("here");
			break;
		case "take":
		case "t":
		case "T":
			String newItem = itemAction.takeItem(yIndex, xIndex);
			System.out.println("You got " + newItem);
			if (!newItem.equals("nothing")) {
				addToInventory(newItem);
			}
			break;
		case "inventory":
		case "inv":
		case "i":
		case "I":
			System.out.println(showInventory());
			break;
		case "north":
		case "n":
		case "N":
			yIndex++;
			break;
		case "south":
		case "s":
		case "S":
			yIndex--;
			break;
		case "east":
		case "e":
		case "E":
			xIndex++;
			break;
		case "west":
		case "w":
		case "W":
			xIndex--;
			break;
		default:
			System.out.println("You fall over");
			break;
		// if x==? && y==? { activate trap door}
		}

	}

	public void useAction() {
		System.out.println("Select item number");
		System.out.println(showInventory());
		try {
			int itemIndex = input.nextInt();
			useItem(yIndex, xIndex, getFromInventory(itemIndex - 1));

		} catch (Exception e) {
			System.out.println("You fumble around.");
			action();
		}

		System.out.println("end try");
	}
	
	
	public String showInventory() {
		return inventory.toString();
	}
	

	public String getFromInventory(int index) {
		return inventory.get(index);
	}

	
	
	
	public void addToInventory(String item) {
		inventory.add(item);
	}

	
	
	
	
	public String whereAmI() {
		return map.getLocationInfo()[yIndex][xIndex];
	}
	
	
	
	

	public String takeItem(int y, int x) {
		return itemAction.takeItem(y, x);
	}
	
	
	

	public void useItem(int y, int x, String item) {
		itemAction.useItem(y, x, item);
	}

}
