package com.game.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class PlayerDos extends GameObject{

	Random r = new Random();
	Handler handler;
	public PlayerDos(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
	}

	public void tick() {
			//update Velocity
			x += velX;
			y += velY;
			
		    //Make sure Player stays in window
			x = Game.clamp(x, Game.WIDTH/2, Game.WIDTH -48);
			y = Game.clamp(y, 0, Game.HEIGHT -70);
			
			//Call collision Method
			collision();
			
			handler.addObject(new Trail(x, y, ID.Trail, Color.orange, 32, 32, 0.1f, handler));
	}

	private void collision() {
		//Looping through all the objects in the game
		for(int i = 0; i < handler.object.size(); i++) {
			
			//Creating a tempOject that gets each instance of the for loop
			GameObject tempObject = handler.object.get(i);
			
			//if the object is the enemy run this code block 
			if(tempObject.getID() == ID.PlayerOneBullet)//tempObject is now BasicEnemey {
				//collision code
				if(getBounds().intersects(tempObject.getBounds())) {
					HUD.HEALTHDOS -=2;
				}
			}
	}

	public void render(Graphics g){
		//Shows Collision Bounding 
		//Graphics2D g2d = (Graphics2D) g;
		//g.setColor(Color.green);
		//g2d.draw(getBounds());
		
		g.setColor(Color.orange);
		g.fillRect((int)x, (int)y, 32, 32);
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 32, 32);
	}

}
