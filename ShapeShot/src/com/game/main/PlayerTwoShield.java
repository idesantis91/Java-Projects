package com.game.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class PlayerTwoShield extends GameObject{

	private Handler handler;
	
	public PlayerTwoShield(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		 velX = 5;
		 velY = 5;
	}

	public void tick() {
		shieldCollisionDos();
		}
		
	public void render(Graphics g) {
		g.setColor(Color.orange);
		g.fillRect((int)x, (int)y, 8, 32);
	}
	
	private void shieldCollisionDos() {
		//Looping through all the objects in the game
		for(int j =0; j < handler.object.size(); j++) {
			
			//Creating a tempOject that gets each instance of the for loop
			GameObject tempObject = handler.object.get(j);
			
			//if the object is the enemy run this code block 
			if(tempObject.getID() == ID.PlayerOneBullet)//tempObject is now BasicEnemey {
				//collision code
				if(getBounds().intersects(tempObject.getBounds())) {
					handler.removeObject(tempObject);
				}
		  }
	}

	public Rectangle getBounds() {
			return new Rectangle((int)x, (int)y, 8, 32);
		}
}