package com.game.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class EnergyRefill extends GameObject{

	private Handler handler;
	
	public EnergyRefill(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
	}

	public void tick() {
		collision();
	}
	
	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect((int)x, (int)y, 8, 32);
	}
	
	private void collision() {
		//Looping through all the objects in the game
		for(int i = 0; i < handler.object.size(); i++) {
			
			//Creating a tempOject that gets each instance of the for loop
			GameObject tempObject = handler.object.get(i);
			
			//if the object is the enemy run this code block 
			if(tempObject.getID() == ID.Player){
				//collision code
				if(getBounds().intersects(tempObject.getBounds())) {
					HUD.ENERGY +=1;
				}
			}
		}
	}

	public Rectangle getBounds() {
			return new Rectangle((int)x, (int)y, 8, 32);
		}
}
