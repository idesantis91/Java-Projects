package com.game.main;

import java.util.Random;

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
		scoreKeep++;
		
		if(scoreKeep >= 250) {
			scoreKeep = 0;
			hud.setLevel(hud.getLevel() + 1);
		}
	}
	
}
