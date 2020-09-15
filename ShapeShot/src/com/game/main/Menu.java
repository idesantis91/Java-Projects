package com.game.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import com.game.main.Game.STATE;

public class Menu extends MouseAdapter{
	
	private Game game;
	private Handler handler;
	private HUD hud;
	private Random r = new Random();
	
	public Menu(Game game, Handler handler, HUD hud) {
		this.game = game;
		this.handler = handler;
		this.hud = hud;
	}
	
	
	public void mousePressed(MouseEvent e) {
		//Storing x and y in mx and my
		int mx = e.getX();
		int my = e.getY();
		
		if(game.gameState == STATE.Menu) {
		//Play Button
		if(mouseOver(mx, my, 210, 150, 200, 64)) {
			//game.gameState = STATE.Game;
			//handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player, handler));
			//handler.clearEnemys();
			//handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.BasicEnemy, handler));
			game.gameState = STATE.Select;
			return;
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
		if(game.gameState == STATE.Select) {
			//Multiplayer Button
			if(mouseOver(mx, my, 210, 150, 200, 64)) {
				game.gameState = STATE.MultiplayerGame;
				handler.clearEnemys();
				handler.addObject(new Player(30, 200, ID.Player, handler));
				handler.addObject(new PlayerDos(565, 200, ID.PlayerDos, handler));
			}
			
			//Single Player Button
			if(mouseOver(mx, my, 210, 250, 200, 64)) {
				game.gameState = STATE.SingleplayerGame;
				handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player, handler));
				handler.addObject(new SpaceShuttle(0, 124, ID.SpaceShuttle, handler));
				handler.addObject(new EnergyRefill(0, 180, ID.EnergyRefill, handler));
				handler.addObject(new ShieldRefill(0, 300, ID.ShieldRefill, handler));
				//handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.BasicEnemy, handler));
				game.diff = 1;
			  } 
			
		    //Back Button for Select Menu
			if(mouseOver(mx, my, 210, 350, 200, 64)) {
				game.gameState = STATE.Menu;
				return;			}
		}
		
		//Back Button for Help
				if(mouseOver(mx, my, 210, 350, 200, 64)) {
					game.gameState = STATE.Menu;
					return;
				}
				//Back Button for End
				if(mouseOver(mx, my, 210, 350, 200, 64)) {
					game.gameState = STATE.Menu;
					hud.setLevel(1);
					hud.setScore(0);				
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
		g.drawString("SHAPE SHOT", 150, 75);
		
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
			g.drawString("Help", 250, 60);
			
			//HealthBar for PlayerOne
			g.setColor(Color.gray);
			g.fillRect(200, 100, 200, 32);
			//Health that player has
			g.setColor(Color.green);
			g.fillRect((int)200, (int)100, 200, 32);
			//Border for health bar
			g.setColor(Color.white);
			g.drawRect(200, 100, 200, 32);
			//Health instructions
			g.setFont(fnttres);
			g.drawString("Health Bar: Make sure you have more helath than your opponent!", 1, 160);
			
			//EnergyBar for PlayerOne 
			g.setColor(Color.gray);
			g.fillRect(250, 175, 100, 15);
			//Health that player has
			g.setColor(Color.blue);
			g.fillRect((int)250, (int)175, 100, 15);
			//Border for health bar
			g.setColor(Color.white);
			g.drawRect(250, 175, 100, 15);
			
			g.setFont(fnttres);
			g.drawString("Energy Bar: When you shoot it takes up energy... So don't spam.", 5, 220);
			
			g.setFont(fnttres);
			g.drawString("WASD keys to move player one and space to shoot the opponent!", 0, 260);
			
			g.setFont(fnttres);
			g.drawString("Arrow keys to move player two and numpad0 to shoot the opppent!", 15, 300);
			
			//Back Button
			g.setFont(fntdos);
			g.drawRect(210, 350, 200, 64);
			g.drawString("Back", 270, 390);

		}else if(game.gameState == STATE.End) {
			Font fnt = new Font("ariel", 1, 50);
			Font fntdos = new Font("ariel", 1, 30);
			Font fnttres = new Font("ariel", 1, 20);

			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("GAME OVER", 160, 75);
			
			//Back Button
			g.setFont(fntdos);
			g.drawRect(210, 350, 200, 64);
			g.drawString("Try Again", 240, 390);
		} else if(game.gameState == STATE.Select) {
			Font fnt = new Font("ariel", 1, 50);
			Font fntdos = new Font("ariel", 1, 30);

			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("SELECT GAME MODE", 55, 75);
			
			g.setFont(fntdos);
			g.drawRect(210, 150, 200, 64);
			g.drawString("Multiplayer", 235, 190);
			
			g.drawRect(210, 250, 200, 64);
			g.drawString("Single Player", 217, 290);

			g.drawRect(210, 350, 200, 64);
			g.drawString("Back", 270, 390);
			
			}

	}
	
	public void tick() {
		
	}
}
