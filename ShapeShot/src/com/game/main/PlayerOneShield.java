package com.game.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class PlayerOneShield extends GameObject{

	private Handler handler;
	
	public PlayerOneShield(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		 velX = 5;
		 velY = 5;
	}

	public void tick() {
			velX = x;
			velY = y;
			shieldCollisionOne();
		}
		
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect((int)x, (int)y, 8, 32);
	}
	
	private void shieldCollisionOne() {
		//Looping through all the objects in the game
		for(int i = 0; i < handler.object.size(); i++) {
			
			//Creating a tempOject that gets each instance of the for loop
			GameObject tempObject = handler.object.get(i);
			
			//if the object is the enemy run this code block 
			if(tempObject.getID() == ID.PlayerTwoBullet)//tempObject is now BasicEnemey {
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