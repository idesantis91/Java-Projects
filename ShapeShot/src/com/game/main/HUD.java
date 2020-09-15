package com.game.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.game.main.Game.STATE;

public class HUD {
	
	public static float HEALTH = 100;
	public static float HEALTHDOS = 100;
	public static float ENERGY = 100;
	public static float ENERGYDOS = 100;
	public static float SHIELD = 100;
	public static float SHIELDDOS = 100;
	private Game game;
	//private  float time = 5;
	//private  float minutes = time % 60;
	//private  float seconds = time / 60;
	
	private int greenValue = 255;
	private int greenValueDos = 255;

	private int score = 0;
	private int level = 1;

	public void tick() {
		
		HEALTH = Game.clamp(HEALTH, 0, 100);
		HEALTHDOS = Game.clamp(HEALTHDOS, 0, 100);
		ENERGY = Game.clamp(ENERGY, 0, 100);
		ENERGYDOS = Game.clamp(ENERGYDOS, 0, 100);
		SHIELD = Game.clamp(SHIELD, 0, 100);
		SHIELDDOS = Game.clamp(SHIELDDOS, 0, 100);

		//time -=1;
		//minutes = time % 60;
		//seconds = time / 60;
		
		//Clamps greenValue so it does not go under
		greenValue = (int)Game.clamp((int)greenValue, 0, 255);
		
		greenValue = (int)(HEALTH * 2);
		score++;
	}
	
	public void render(Graphics g) {
		//Timer for Match
		//Font fnt = new Font("ariel", 1, 50);
		//g.setFont(fnt);
		//g.setColor(Color.white);
		//g.drawString(minutes + ":" + seconds, 275, 50);
		
		if(game.gameState == STATE.MultiplayerGame) {
		//HealthBar for PlayerOne
		g.setColor(Color.gray);
		g.fillRect(15, 15, 200, 32);
		//Health that player has
		g.setColor(new Color(75, greenValue, 0));
		g.fillRect((int)15, (int)15, (int)HEALTH *2, 32);
		//Border for health bar
		g.setColor(Color.white);
		g.drawRect(15, 15, 200, 32);
		
		//EnergyBar for PlayerOne 
		g.setColor(Color.gray);
		g.fillRect(15, 50, 100, 15);
		//Health that player has
		g.setColor(Color.blue);
		g.fillRect((int)15, (int)50, (int)ENERGY, 15);
		//Border for health bar
		g.setColor(Color.white);
		g.drawRect(15, 50, 100, 15);
		
		//HealthBar for PlayerDos
		g.setColor(Color.gray);
		g.fillRect(410, 15, 200, 32);
		//Health that player has
		g.setColor(new Color(75, greenValueDos, 0));
		g.fillRect((int)410, (int)15, (int)HEALTHDOS *2, 32);
		//Border for health bar
		g.setColor(Color.white);
		g.drawRect(410, 15, 200, 32);
		
		//EnergyBar for PlayerDos
		g.setColor(Color.gray);
		g.fillRect(510, 50, 100, 15);
		//Health that PlayerDos has
		g.setColor(Color.blue);
		g.fillRect((int)510, (int)50, (int)ENERGYDOS, 15);
		//Border for health bar
		g.setColor(Color.white);
		g.drawRect(510, 50, 100, 15);
		
		//ShieldBar for PlayerDos
		g.setColor(Color.gray);
		g.fillRect(510, 70, 100, 15);
		//ShieldBar that PlayerDos has
		g.setColor(Color.orange);
		g.fillRect((int)510, (int)70, (int)SHIELDDOS, 15);
		//Border for Shield Bar
		g.setColor(Color.white);
		g.drawRect(510, 70, 100, 15);
		g.setColor(Color.black);
		g.drawRect(541, 70, 69, 15);
		g.setColor(Color.black);
		g.drawRect(576, 70, 34, 15);
		g.setColor(Color.white);
		g.drawRect(510, 70, 100, 15);
		
		//ShieldBar for PlayerOne
		g.setColor(Color.gray);
		g.fillRect(15, 70, 100, 15);
		//ShieldBar that PlayerOne has
		g.setColor(Color.white);
		g.fillRect((int)15, (int)70, (int)SHIELD, 15);
		//Border for Shield Bar
		g.setColor(Color.white);
		g.drawRect(15, 70, 100, 15);
		g.setColor(Color.black);
		g.drawRect(15, 70, 32, 15);
		g.setColor(Color.black);
		g.drawRect(15, 70, 65, 15);
		g.setColor(Color.white);
		g.drawRect(15, 70, 100, 15);
		}else if(game.gameState == STATE.SingleplayerGame) {
			//HealthBar for PlayerOne
			g.setColor(Color.gray);
			g.fillRect(15, 15, 200, 32);
			//Health that player has
			g.setColor(new Color(75, greenValue, 0));
			g.fillRect((int)15, (int)15, (int)HEALTH *2, 32);
			//Border for health bar
			g.setColor(Color.white);
			g.drawRect(15, 15, 200, 32);
			
			//EnergyBar for PlayerOne 
			g.setColor(Color.gray);
			g.fillRect(15, 50, 100, 15);
			//Health that player has
			g.setColor(Color.blue);
			g.fillRect((int)15, (int)50, (int)ENERGY, 15);
			//Border for health bar
			g.setColor(Color.white);
			g.drawRect(15, 50, 100, 15);
			//ShieldBar for PlayerOne
			g.setColor(Color.gray);
			g.fillRect(15, 70, 100, 15);
			//ShieldBar that PlayerOne has
			g.setColor(Color.white);
			g.fillRect((int)15, (int)70, (int)SHIELD, 15);
			//Border for Shield Bar
			g.setColor(Color.white);
			g.drawRect(15, 70, 100, 15);
			g.setColor(Color.black);
			g.drawRect(15, 70, 32, 15);
			g.setColor(Color.black);
			g.drawRect(15, 70, 65, 15);
			g.setColor(Color.white);
			g.drawRect(15, 70, 100, 15);
			g.drawString("Score: " + score, 15, 100);
			g.drawString("Level: " + level, 15, 120);
		}
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public int getScore() {
		return score;
	}
	
	public int getLevel() {
		return level;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	

}
