package com.game.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class MenuParticle extends GameObject{

	private Handler handler;
	Random r = new Random();
	
	private Color col;
	
	int dir = 0;
	
	public MenuParticle(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		dir = r.nextInt(2);
		if(dir == 0) {
			velX = 2;
			velY = 10;
		}else if(dir == 1) {
			velX = 10;
			velY = 2;
		}
		 
		 col = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
	}

	public void tick() {
		x += velX;
		y += velY; 
		
		if(y <= 0 || y >= Game.HEIGHT - 32) {
			velY *= -1;
		}
		if(x <= 0 || x >= Game.WIDTH - 16) {
			velX *= -1;
		}
		
		handler.addObject(new Trail(x, y, ID.Trail, col, 16, 16, 0.1f, handler));
	}
	
	public void render(Graphics g) {
		g.setColor(col);
		g.fillRect((int)x, (int)y, 16, 16);
	}

	public Rectangle getBounds() {
			return new Rectangle((int)x, (int)y, 16, 16);
		}
}
