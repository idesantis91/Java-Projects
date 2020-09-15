package com.game.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class HardEnemy extends GameObject{

	private Handler handler;
	
	private Random r = new Random();
	
	public HardEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		 velX = 5;
		 velY = 0;
	}

	public void tick() {
		x -= velX;
		y += velY; 
		
		if(x <= 0) {
			handler.removeObject(this);
			if(velY <0) {
				velY = -(r.nextInt(7) + 1)* -1;
			}else {
				velY = (r.nextInt(7) + 1)* -1;
			}
		}
		if(y >= Game.HEIGHT) {
			handler.removeObject(this);
			if(velX <0) {
				velX = -(r.nextInt(7) + 1)* -1;
			}else {
				velX = (r.nextInt(7) + 1)* -1;
			}
		}
		collision();
		handler.addObject(new Trail(x, y, ID.Trail, Color.yellow, 16, 16, 0.1f, handler));
	}
	
	public void render(Graphics g) {
		g.setColor(Color.yellow);
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
