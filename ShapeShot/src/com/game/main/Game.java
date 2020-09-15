package com.game.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

import com.game.main.Game.STATE;

public class Game extends Canvas implements Runnable{

	
		private static final long serialVersionUID = 1043820339707511843L;
		
		public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
		
		private Thread thread;
		private boolean running = false;
		
		public static boolean paused = false;
		
		public int diff = 0;
		//0 = normal
		//1 = hard
		
		
		private Random r;
		private Handler handler;
		private HUD hud;
		private Spawner spawner;
		private Menu menu;
		
		public enum STATE{
			Menu,
			Select,
			Help,
			End,
			SingleplayerGame,
			MultiplayerGame;
		}
		
		//Cast state that holds the enum values
		public static STATE gameState = STATE.Menu;
		
		public Game(){
			handler = new Handler();
			hud = new HUD();
			menu = new Menu(this, handler, hud);
			this.addMouseListener(menu);
			//Tells that we are using keys
			this.addKeyListener(new KeyInput(handler,this));
			
			//AudioPlayer.load();
			//AudioPlayer.getMusic("music").loop();
			
			new Window(WIDTH, HEIGHT, "SHAPE SHOT", this);
			r = new Random();
			spawner = new Spawner(handler, hud, this);
				if(gameState == STATE.MultiplayerGame) {
				handler.addObject(new Player(30, 100, ID.Player, handler));
				handler.addObject(new PlayerDos(400, 200, ID.PlayerDos, handler));
		  }else {
			  for(int i = 0; i <20; i++) {
				//handler.addObject(new MenuParticle(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.MenuParticle, handler));

			  }
		  }
		}
		//Initialize and start thread 
		public synchronized void start() {
			thread = new Thread(this);
			thread.start();
			running = true;
		}
		
		public synchronized void stop() {
			try {
				//thread.join is killing off the thread
				thread.join();
				running = false;
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		//game loop
		public void run() {
			//requestFocus allows us to not click on display to play
			this.requestFocus();
			long lastTime = System.nanoTime();
			double amountOfTicks = 60.0;
			double ns = 1000000000 / amountOfTicks;
			double delta = 0;
			long timer = System.currentTimeMillis();
			int frames = 0;
			while(running){
				long now = System.nanoTime();
				delta += (now - lastTime) / ns;
				lastTime = now;
				while(delta >= 1) {
					tick();
					delta--;
				}
				if(running)
					render();
				frames++;
				
				if(System.currentTimeMillis() - timer > 1000) {
					timer += 1000;
					System.out.println("FPS: " + frames);
					frames = 0;
				}
			}
			stop();
		}
		
		private void tick(){			
			if(gameState == STATE.MultiplayerGame) {
				if(!paused) {
					handler.tick();
					hud.tick();
					spawner.tick();
					if(HUD.HEALTH <= 0 || HUD.HEALTHDOS <=0) {
						HUD.HEALTH = 100;
						HUD.HEALTHDOS = 100;
						HUD.ENERGY = 100;
						HUD.ENERGYDOS = 100;
						HUD.SHIELD = 100;
						HUD.SHIELDDOS = 100;
						gameState = STATE.End;
						handler.clearEnemys();	
				}
			}else if(gameState == STATE.Menu || gameState == STATE.End || gameState == STATE.Select) {
				menu.tick();
				handler.tick();
			}
		} 
			if(gameState == STATE.SingleplayerGame) {
				if(!paused) {
					handler.tick();
					hud.tick();
					spawner.tick();
					if(HUD.HEALTH <= 0){
						HUD.HEALTH = 100;
						HUD.ENERGY = 100;
						HUD.SHIELD = 100;
						gameState = STATE.End;
						handler.clearEnemys();	
				}
			}else if(gameState == STATE.Menu || gameState == STATE.End || gameState == STATE.Select) {
				menu.tick();
				handler.tick();
			}
		}
	}
		
		private void render(){
			BufferStrategy bs = this.getBufferStrategy();
			if(bs == null) {
				this.createBufferStrategy(3);
				return;
			}
			
			Graphics g = bs.getDrawGraphics();
			
			g.setColor(Color.black);
			g.fillRect(0,0, WIDTH, HEIGHT);
			handler.render(g);
			
			if(paused) {
				g.setColor(Color.white);
				g.drawString("PAUSED", 100, 100);
			}
			
			if(gameState == STATE.MultiplayerGame || gameState == STATE.SingleplayerGame) {
			//Renders the handler class and hud class
			hud.render(g);
			}else if(gameState == STATE.Menu || gameState == STATE.Help || gameState == STATE.End || gameState == STATE.Select) {
				menu.render(g);
			}
			g.dispose();
			bs.show();
		}
		
		//Clamp Method: Keeps player from leaving window
		public static float clamp(float var, float min, float max){
			if(var >= max) {
				return var = max;
			}else if(var <= min) {
				return var = min;
			}else {
				return var;
			}
		}
		
		public static void main(String args[]) {
			new Game();
		}
}