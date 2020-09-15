package com.game.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class SpaceShuttle extends GameObject{

	private Handler handler;
	
	public SpaceShuttle(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
	}

	public void tick() {
		collision();
	}
	
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect((int)x, (int)y, 30, 320);
	}
	
	private void collision() {
		//Looping through all the objects in the game
		for(int i = 0; i < handler.object.size(); i++) {
			
			//Creating a tempOject that gets each instance of the for loop
			GameObject tempObject = handler.object.get(i);
			
			//if the object is the enemy run this code block 
			if(tempObject.getID() == ID.BasicEnemy || tempObject.getID() == ID.HardEnemy || tempObject.getID() == ID.SmartEnemy) {
				//collision code
				if(getBounds().intersects(tempObject.getBounds())) {
					handler.removeObject(tempObject);
					if(tempObject.getID() == ID.BasicEnemy){HUD.HEALTH-=2;}
					else if(tempObject.getID() == ID.HardEnemy){HUD.HEALTH-=6;}
					else if(tempObject.getID() == ID.SmartEnemy){HUD.HEALTH-=10;}
				}
			}
		}
	}
	public Rectangle getBounds() {
			return new Rectangle((int)x, (int)y, 30, 320);
		}
}
