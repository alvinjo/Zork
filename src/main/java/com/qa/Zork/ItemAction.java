package com.qa.Zork;

public class ItemAction {
	
	Map map;
	Gameplay game;
	
	public ItemAction(Map map, Gameplay game) {
		this.map = map;
		this.game = game;
	}
	
	
	public void useItem(int y, int x, String item) {

		switch (item) {
		case "Magic Mushrooms":
			if (y == 3 && x == 1) {
				System.out.println("You give the wizard mushrooms. The wizard smiles and gifts you his laser rifle.");
				game.addToInventory("Laser Rifle");
				map.updateLocationInfo(y, x, "It smells like weed here.");

			}
			
			
		case "Laser Rifle":
			if (y == 0 && x == 6) {
				System.out.println("The beam from the laser rifle rips through the ogres many layers of skin, boring a hole right through its torso.");
				System.out.println("It crashes to the ground with a heavy thud, its dark green entrails oozing outwards.");
			}

		}

	}
	
	
	
	public String takeItem(int y, int x) {

		if (y == 0 && x == 0) {
			return map.getItem(0);
		} else if (y == 0 && x == 2) {
			return map.getItem(2);
		} 

		return "nothing";
	}
	
	

}
