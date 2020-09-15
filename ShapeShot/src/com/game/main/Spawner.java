package com.game.main;

import java.util.Random;

import com.game.main.Game.STATE;

public class Spawner {
	
	private Handler handler;
	private HUD hud;
	private Game game;
	private int scoreKeep;
	private Random r = new Random();
	
	public Spawner(Handler handler, HUD hud, Game game) {
		this.handler = handler;
		this.hud = hud;
		this.game = game;
	}

	public void tick() {
		
		if(game.gameState ==STATE.SingleplayerGame) {
		scoreKeep++;
		
		if(scoreKeep >= 250) {
			scoreKeep = 0;
			hud.setLevel(hud.getLevel() + 1);
		
		if(hud.getLevel() == 2) {
			basicEnemy();
			hardEnemy();

		}else if(hud.getLevel() == 3) {
			basicEnemy();
			hardEnemy();
			basicEnemy();
			hardEnemy();
		}else if(hud.getLevel() == 4) {
			basicEnemy();
			hardEnemy();
			basicEnemy();
			smartEnemy();
			}
		}
	}
}
	
	public void basicEnemy() {
		handler.addObject(new BasicEnemy((int)640, (int)200, ID.BasicEnemy, handler));
	}
	
	public void hardEnemy() {
		handler.addObject(new HardEnemy((int)640, (int)250, ID.HardEnemy, handler));
	}
	
	public void smartEnemy() {
		handler.addObject(new SmartEnemy((int)500, (int)250, ID.SmartEnemy, handler));
	}
	
}
