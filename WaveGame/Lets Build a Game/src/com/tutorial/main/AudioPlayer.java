package com.tutorial.main;

import java.util.Map;
import java.util.HashMap;

import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

public class AudioPlayer {

	public static Map<String, Sound> soundMap = new HashMap<String, Sound>();
	public static Map<String, Music> musicMap = new HashMap<String, Music>();
	
	public static void load() {
		
		try {
			musicMap.put("music", new Music("Res/Interplanetary Odyssey.ogg"));
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
	public static Music getMusic(String key) {
		return musicMap.get(key);
	}
	
}
