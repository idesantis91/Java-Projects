package com.game.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class BasicEnemy extends GameObject{

	private Handler handler;
	
	public BasicEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		 velX = 2;
		 velY = 0;
	}

	public void tick() {
		x -= velX;
		y += velY; 
		
		if(x <= 0) {
			handler.removeObject(this);
		}
		
		if(y >= Game.HEIGHT) {
			handler.removeObject(this);
		}
		collision();
		handler.addObject(new Trail(x, y, ID.Trail, Color.red, 16, 16, 0.1f, handler));
	}
	
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int)x, (int)y, 16, 16);
	}
	
	private void collision() {
		//Looping through all the objects in the game
		for(int i = 0; i < handler.object.size(); i++) {
			
			//Creating a tempOject that gets each instance of the for loop
			GameObject tempObject = handler.object.get(i);
			
			//if the object is the enemy run this code block 
			if(tempObject.getID() == ID.PlayerOneBullet || tempObject.getID() == ID.PlayerOneShield)//tempObject is now BasicEnemey {
				//collision code
				if(getBounds().intersects(tempObject.getBounds())) {
					handler.removeObject(this);
					handler.removeObject(tempObject);
				}
		  }
	}

	public Rectangle getBounds() {
			return new Rectangle((int)x, (int)y, 16, 16);
		}
}
