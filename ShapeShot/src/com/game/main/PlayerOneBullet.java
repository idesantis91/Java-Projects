package com.game.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class PlayerOneBullet extends GameObject{

	private Handler handler;
	private Random r = new Random();
	Game game;

	public PlayerOneBullet(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.x = x;
		this.y = y;
		this.handler = handler;
		
		 velX = 5;
		 velY = 0;
	}
	
	public void tick() {
		x += velX;
		y += velY; 

		if(x >= Game.WIDTH) {
			handler.removeObject(this);
		}
		
		if(y >= Game.HEIGHT) {
			handler.removeObject(this);
		}
		
		handler.addObject(new Trail(x, y, ID.Trail, Color.white, 16, 16, 0.1f, handler));
	}
	
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect((int)x, (int)y, 16, 16);
	}

	public Rectangle getBounds() {
			return new Rectangle((int)x, (int)y, 16, 16);
		}
}
