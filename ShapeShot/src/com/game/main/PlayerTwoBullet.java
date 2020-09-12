package com.game.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class PlayerTwoBullet extends GameObject{

	private Handler handler;
	private Random r = new Random();
	
	public PlayerTwoBullet(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		 velX = 5;
		 velY = 0;
	}

	public void tick() {
		x -= velX;
		y += velY; 
		
		/*if(y <= 0 || y >= Game.HEIGHT - 32) {
			velY *= -1;
		}
		if(x <= 0 || x >= Game.WIDTH - 16) {
			velX *= -1;
		}*/
		
		if(x <= 0) {
			handler.removeObject(this);
		}
		
		if(y >= Game.HEIGHT) {
			handler.removeObject(this);
		}
		
		
		handler.addObject(new Trail(x, y, ID.Trail, Color.orange, 16, 16, 0.1f, handler));
	}
	
	public void render(Graphics g) {
		g.setColor(Color.orange);
		g.fillRect((int)x, (int)y, 16, 16);
	}

	public Rectangle getBounds() {
			return new Rectangle((int)x, (int)y, 16, 16);
		}
}
