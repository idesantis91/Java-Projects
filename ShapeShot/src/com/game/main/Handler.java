package com.game.main;

import java.awt.Graphics;
import java.util.LinkedList;

//Maintain or update the objects in the game
public class Handler {
//Create a list of Game objects
	
	LinkedList<GameObject> object = new LinkedList<GameObject>();
	Game game;
	public void tick() {
		for(int i = 0; i < object.size(); i++) {
			GameObject tempObject = object.get(i);
			tempObject.tick();
		}
	}
	
	//Updates all the games Objects
	public void render(Graphics g){
		for(int i =0; i < object.size(); i++){
			GameObject tempObject = object.get(i);
			
			tempObject.render(g);
		}
	}
	//Add objects to list
	public void addObject(GameObject object){
		this.object.add(object);
	}
	
	//Removes objects from the list
	public void removeObject(GameObject object){
		this.object.remove(object);
	}
	
	public void clearEnemys() {
		for(int i =0; i < object.size(); i++){
			GameObject tempObject = object.get(i);
			
			if(tempObject.getID() == ID.Player) {
				object.clear();
				if(Game.gameState != Game.STATE.End)
				addObject(new Player((int)tempObject.getX(), (int)tempObject.getY(), ID.Player, this));
				//addObject(new PlayerDos((int)tempObject.getX(), (int)tempObject.getY(), ID.PlayerDos, this));
			}
		}
	}
	
	//Shooting Method for Player One
	public void shootPlayerOne() {
		--HUD.ENERGY;
		for(int i =0; i < object.size(); i++){
			GameObject tempObject = object.get(i);
			
			if(tempObject.getID() == ID.Player) {
				addObject(new PlayerOneBullet((int)tempObject.getX(), (int)tempObject.getY()+8, ID.PlayerOneBullet, this));
			}
		}
	}
	
	//Shooting Method for Player DOS
	public void shootPlayerDos() {
		--HUD.ENERGYDOS;
		for(int i =0; i < object.size(); i++){
			GameObject tempObject = object.get(i);
			if(tempObject.getID() == ID.PlayerDos) {
				if(HUD.ENERGYDOS >= 0) {
				addObject(new PlayerTwoBullet((int)tempObject.getX(), (int)tempObject.getY()+8, ID.PlayerTwoBullet, this));
				}
			}
		}
	}
	
	//Player One's shield Method
	public void playerOneShield() {
		for(int i =0; i < object.size(); i++){
			GameObject tempObject = object.get(i);
			if(tempObject.getID() == ID.Player) {
				addObject(new PlayerOneShield((int)tempObject.getX() + 33, (int)tempObject.getY(), ID.PlayerOneShield, this));
			}
		}
	}
	
	//Player One's shield Method
	public void playerTwoShield() {
		for(int i =0; i < object.size(); i++){
			GameObject tempObject = object.get(i);
			if(tempObject.getID() == ID.PlayerDos) {
				addObject(new PlayerTwoShield((int)tempObject.getX() -9, (int)tempObject.getY(), ID.PlayerTwoShield, this));
			}
		}
	}
	
}

