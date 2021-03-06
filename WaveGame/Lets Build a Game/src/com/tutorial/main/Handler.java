package com.tutorial.main;

import java.awt.Graphics;
import java.util.LinkedList;

//Maintain or update the objects in the game
public class Handler {
//Create a list of Game objects
	
	LinkedList<GameObject> object = new LinkedList<GameObject>();
	
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
			}
		}
	}
}
