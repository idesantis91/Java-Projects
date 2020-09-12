package com.game.main;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

//Extends takes methods of the class you are extending
public class Window extends Canvas{

	private static final long serialVersionUID = -240840600533728354L;
	
	public Window(int width, int height, String title, Game game) {
		JFrame frame = new JFrame(title);
		
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		
		//Closes the Window and exits the game  
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Resize window
		frame.setResizable(false);
		//Not needed but when added it sets the window to the middle
		frame.setLocationRelativeTo(null);
		//Adding game class into the frame
		frame.add(game);
		//We are able to see the frame 
		frame.setVisible(true);
		//Running the start method that was created 
		game.start();
	}

}