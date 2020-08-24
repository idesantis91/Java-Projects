package com.tutorial.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import com.tutorial.main.Game.STATE;

public class Menu extends MouseAdapter{
	
	private Game game;
	private Handler handler;
	private Random r = new Random();
	
	public Menu(Game game, Handler handler) {
		this.game = game;
		this.handler = handler;
	}
	
	
	public void mousePressed(MouseEvent e) {
		//Storing x and y in mx and my
		int mx = e.getX();
		int my = e.getY();
		
		if(game.gameState == STATE.Menu) {
		//Play Button
		if(mouseOver(mx, my, 210, 150, 200, 64)) {
			game.gameState = STATE.Game;
			handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player, handler));
			handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.BasicEnemy, handler));
		}
		
		//Help Button
		if(mouseOver(mx, my, 210, 250, 200, 64)) {
			game.gameState = STATE.Help;
		  } 
		
	    //Quit Button
		if(mouseOver(mx, my, 210, 350, 200, 64)) {
			System.exit(0);
		}
	}
		//Back Button for Help
				if(mouseOver(mx, my, 210, 350, 200, 64)) {
					game.gameState = STATE.Menu;
					return;
				}
}
	
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
		if(mx > x && mx  < x + width) {
			if(my > y && my  < y + height) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
	
	public void mouseReleased(MouseEvent e) {
		
	}
	

	public void render(Graphics g) {
		if(game.gameState == STATE.Menu) {
		Font fnt = new Font("ariel", 1, 50);
		Font fntdos = new Font("ariel", 1, 30);

		g.setFont(fnt);
		g.setColor(Color.white);
		g.drawString("Menu", 250, 75);
		
		g.setFont(fntdos);
		g.drawRect(210, 150, 200, 64);
		g.drawString("Play", 280, 190);
		
		g.drawRect(210, 250, 200, 64);
		g.drawString("Help", 280, 290);

		g.drawRect(210, 350, 200, 64);
		g.drawString("Quit", 280, 390);
		}else if(game.gameState == STATE.Help) {
			Font fnt = new Font("ariel", 1, 50);
			Font fntdos = new Font("ariel", 1, 30);
			Font fnttres = new Font("ariel", 1, 20);

			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Help", 250, 75);
			
			g.setFont(fnttres);
			g.drawString("Use WASD keys to move player and dodge enemies!", 70, 200);
			
			//Back Button
			g.setFont(fntdos);
			g.drawRect(210, 350, 200, 64);
			g.drawString("Back", 270, 390);

		}

	}
	
	public void tick() {
		
	}
}
