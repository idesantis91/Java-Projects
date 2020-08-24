package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {
	
		public static float HEALTH = 100;
		
		private int greenValue = 255;
		
		private int score = 0;
		private int level = 1;

		public void tick() {
			HEALTH = Game.clamp(HEALTH, 0, 100);
			//Clamps greenValue so it does not go under
			greenValue = (int)Game.clamp((int)greenValue, 0, 255);
			
			greenValue = (int)(HEALTH * 2);
			score++;
		}
		
		public void render(Graphics g) {
			//HealthBar
			g.setColor(Color.gray);
			g.fillRect(15, 15, 200, 32);
			//Health that player has
			g.setColor(new Color(75, greenValue, 0));
			g.fillRect((int)15, (int)15, (int)HEALTH *2, 32);
			//Border for health bar
			g.setColor(Color.white);
			g.drawRect(15, 15, 200, 32);
			
			g.drawString("Score: " + score, 15, 64);
			g.drawString("Level: " + level, 15, 80);
		}
		
		public void score(int score) {
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
