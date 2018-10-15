package com.qa.Zork;

import java.util.ArrayList;

public class Map {
	
	String[][] locationInfo = new String[][] {
		{ "00 A fallen tree sits quietly in a clearing. The tree trunk has been hollowed out with a shiny green object buried within.", 
			"01 Smells like ogre over here.", 
			"02 Tall thorned bushes surround you. There are paths east and west.", 
			"03 Huge footprints have flattened the nearby fauna.", 
			"04 A thick fog leeks from the ground.", 
			"05 The swamp air suffocates you.", 
			"06 You see a green ogre crouched over a dead donkey. It hasn't noticed you.", 
			"07", 
			"08"},
		{ "10", "11", "12", "13", "14 The swamp is greyer over here.", "15", "16", "17", "18"},
		{ "20", "21", "22", "23", "24 A grey swamp surrounds you.", "25", "26", "27", "28"},
		{ "30", "31 You encounter a pale eyed wizard. He looks through you.", "32", "33", "34", "35", "36", "37", "38"},
		{ "40", "41", "42", "43", "44", "45", "46", "47", "48"}
		
	};
	
	String[] items = new String[] {"Ogre Knife", "Laser Rifle", "Magic Mushrooms"};
	ArrayList<String> inventory = new ArrayList<>();
	

	
	public Map() {
		
	}
	
	
	public String getFromInventory(int index) {
		return inventory.get(index);
	}
	
	public void addToInventory(String item) {
		inventory.add(item);
	}
	
	
	public String whereAmI(int y, int x) {
		
		return locationInfo[y][x];
		
	}
	
	public String takeItem(int y, int x) {
		
		if(y == 0 && x == 0) {
			return items[0];
		} else if (y == 0 && x == 2) {
			return items[2];
		}
		
		
		return "nothing";
	}
	
	
	public void useItem(int y, int x, String item) {
		
		switch(item) {
		case "Magic Mushrooms":
			if(y == 3 && x == 1) {
				System.out.println("You give the wizard mushrooms. The wizard smiles and gifts you his laser rifle.");
				locationInfo[3][1] = "It smells like weed here.";
			}
			
		}
		
	}
	
}
