package com.tutorial.main;

import java.awt.Graphics;
import java.awt.Rectangle;

//All the game objects
public abstract class GameObject {

	//Will be used in other classes and protects them 
	protected float x, y;
	protected ID id;
	protected float velX, velY;
	
	//What is set in the constructor is what sets the variables above it
	public GameObject(float x, float y, ID id) {
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	//Using intersect method to calculate collision
	public abstract Rectangle getBounds();
	
	public void setX(int x){
		this.x = x; 
	}
	
	public void setY(int y){
		this.y = y;
	}
	
	public float getX(){
		return x;
	}
	
	public float getY(){
		return y;
	}
	
	public void setID(ID id){
		this.id = id;
	}
	
	public ID getID(){
		return id;
	}
	public void setVelX(int velX){
		this.velX = velX;
	}
	
	public void setVelY(int velY){
		this.velY = velY;
	}
	
	public float getVelY(){
		return velY;
	}
	
	public float getVelX(){
		return velX;
	}
}
