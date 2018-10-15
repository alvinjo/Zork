package com.qa.Zork;

import java.util.ArrayList;
import java.util.Scanner;

public class Zork {
	

	static boolean gameOver = false;
	static int yIndex = 2; 
	static int xIndex = 4;
	static Map map = new Map();
	
	static Scanner input = new Scanner(System.in);
	
	

	public static void main(String[] args) {
		
		map.addToInventory("Magic Compass");
		
		System.out.println("### - SPORK - ###"+ "\n");
		play();
		
	}
	
	
	
	public static void play() {
		
		
		while(!gameOver) {
			System.out.println("\n" + map.whereAmI(yIndex, xIndex));
			action();
		}
		
		
	}
	
	
	public static void useAction() {
		System.out.println("Select item number");
		System.out.println(showInventory());
		try {
			int itemIndex = input.nextInt();
			map.useItem(yIndex, xIndex, map.getFromInventory(itemIndex-1));
			
		}catch(Exception e) {
			System.out.println("You fumble around.");
			action();
		}
		
		System.out.println("end try");
	}
	
	
	
	public static void action() {
		System.out.println("#");
		String command = input.nextLine();
		
		switch(command) {
		case "use":
		case "u":
		case "U":
			useAction();
			System.out.println("here");
			break;
		case "take":
		case "t":
		case "T":
			String newItem = map.takeItem(yIndex, xIndex);
			System.out.println("You got " + newItem);
			if (!newItem.equals("nothing")) {
				map.addToInventory(newItem);
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
			//if x==? && y==? { activate trap door}
		}
		
		
		
		
	}
	
	
	
	public static String showInventory() {
		return map.inventory.toString();
	}
	

}
