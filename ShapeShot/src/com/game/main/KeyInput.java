package com.game.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.game.main.Game.STATE;

public class KeyInput extends KeyAdapter{

	private Handler handler;
	private boolean[] keyDown = new boolean[4];
	
	Game game;
	Player player;
	
	public KeyInput(Handler handler, Game game) {
		this.handler = handler;
		this.game = game;
		keyDown[0] = false;//w
		keyDown[1] = false;//s
		keyDown[2] = false;//d
		keyDown[3] = false;//a
		
	}
	
	public void keyPressed(KeyEvent e) {
		//This shows the numeric value for the key pressed 
		int key = e.getKeyCode();
		
		//Key input for Players
		for(int i = 0; i< handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			//Finds PlayerOne
			if(tempObject.getID() == ID.Player) {
				//Key Events for player One
				if(key == KeyEvent.VK_W) {tempObject.setVelY(-5); keyDown[0] = true;}
				if(key == KeyEvent.VK_S) {tempObject.setVelY(5); keyDown[1] = true;}
				if(key == KeyEvent.VK_D) {tempObject.setVelX(5); keyDown[2] = true;} 
				if(key == KeyEvent.VK_A) {tempObject.setVelX(-5); keyDown[3] = true;}
				if(key == KeyEvent.VK_SPACE) {
					if(HUD.ENERGY > 0) {
					handler.shootPlayerOne();
					}
				}
				
				if(key == KeyEvent.VK_Q) {
					if(HUD.SHIELD > 0) {
					handler.playerOneShield();
					HUD.SHIELD = HUD.SHIELD - 34;
					}
				}
			}
			
				//Key Events for PlayerDos
				if(tempObject.getID() == ID.PlayerDos) {
					//Key Events for player One
					if(key == KeyEvent.VK_UP) {tempObject.setVelY(-5); keyDown[0] = true;}
					if(key == KeyEvent.VK_DOWN) {tempObject.setVelY(5); keyDown[1] = true;}
					if(key == KeyEvent.VK_RIGHT) {tempObject.setVelX(5); keyDown[2] = true;} 
					if(key == KeyEvent.VK_LEFT) {tempObject.setVelX(-5); keyDown[3] = true;}
					if(key == KeyEvent.VK_NUMPAD0) {
						if(HUD.ENERGYDOS > 0) {
						handler.shootPlayerDos();
						}
					}
					if(key == KeyEvent.VK_NUMPAD1) {
						if(HUD.SHIELDDOS > 0) {
							handler.playerTwoShield();
							HUD.SHIELDDOS = HUD.SHIELDDOS - 34;
						}
					}
				}
		}
		
		if(key == KeyEvent.VK_P) {
			if(game.gameState == STATE.MultiplayerGame || game.gameState == STATE.SingleplayerGame) {
				
			}
			if(Game.paused) {
				Game.paused = false;
			}else {
				Game.paused = true;
			}
		}
		
		if(key == KeyEvent.VK_ESCAPE) {
			System.exit(1);
		  }
		}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		for(int i = 0; i< handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			//Finds Player One
			if(tempObject.getID() == ID.Player) {
				//Key Events for Player One
				if(key == KeyEvent.VK_W) keyDown[0] = false; //tempObject.setVelY(0);
				if(key == KeyEvent.VK_S) keyDown[1] = false; //tempObject.setVelY(0);
				if(key == KeyEvent.VK_D) keyDown[2] = false; //tempObject.setVelX(0);
				if(key == KeyEvent.VK_A) keyDown[3] = false; //tempObject.setVelX(0);
				
				//Vertical Movement
				if(!keyDown[0] && !keyDown[1]) {
					tempObject.setVelY(0);
				}
				//Horizontal Movement
				if(!keyDown[2] && !keyDown[3]) {
					tempObject.setVelX(0);
				}
			}
			
			//Key Events for PlayerDos
			if(tempObject.getID() == ID.PlayerDos) {
				//Key Events for Player Dos
				if(key == KeyEvent.VK_UP) keyDown[0] = false; //tempObject.setVelY(0);
				if(key == KeyEvent.VK_DOWN) keyDown[1] = false; //tempObject.setVelY(0);
				if(key == KeyEvent.VK_RIGHT) keyDown[2] = false; //tempObject.setVelX(0);
				if(key == KeyEvent.VK_LEFT) keyDown[3] = false; //tempObject.setVelX(0);
				
				//Vertical Movement
				if(!keyDown[0] && !keyDown[1]) {
					tempObject.setVelY(0);
				}
				//Horizontal Movement
				if(!keyDown[2] && !keyDown[3]) {
					tempObject.setVelX(0);
				}
			}
		}
	}	
}
