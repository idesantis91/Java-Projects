package com.game.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class SmartEnemy extends GameObject{

	private Handler handler;
	private GameObject player;
	
	public SmartEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		//Loops through objects 
		for(int i = 0; i < handler.object.size(); i++) {
			//if object is player id
			if(handler.object.get(i).getID() == ID.Player) {
				//player get object at i 
				player = handler.object.get(i);
			}
			
		}
		
		 velX = 5;
		 velY = 5;
	}

	public void tick() {
		x += velX;
		y += velY; 
		
		float diffX = x - player.getX() - 8;
		float diffY = y - player.getY() - 8;
		float distance = (float)Math.sqrt((x-player.getX()) * (x-player.getX()) + (y-player.getY()) * (y-player.getY()));
		
		velX = (float) ((-1.0/distance) * diffX);
		velY = (float) ((-1.0/distance) * diffY);
		
		if(y <= 0 || y >= Game.HEIGHT - 32) {
			velY *= -1;
		}
		if(x <= 0 || x >= Game.WIDTH - 16) {
			velX *= -1;
		}
		
		handler.addObject(new Trail(x, y, ID.Trail, Color.pink, 16, 16, 0.1f, handler));
	}
	
	public void render(Graphics g) {
		g.setColor(Color.pink);
		g.fillRect((int)x, (int)y, 16, 16);
	}

	public Rectangle getBounds() {
			return new Rectangle((int)x, (int)y, 16, 16);
		}
}
