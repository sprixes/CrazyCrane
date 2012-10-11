package com.noobs2d.crazycrane;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

public class Sounds {

	public static Sound destroySfx;
	public static Sound dropSfx;
	public static Sound fallSfx;
	public static Sound swipeSfx;
	public static Music backgroundMusic;

	public static void dispose() {
		backgroundMusic.dispose();
		dropSfx.dispose();
		fallSfx.dispose();
		swipeSfx.dispose();
		destroySfx.dispose();
	}

	public static void load(AssetManager assetManager) {
		assetManager.load("data/sfx/backgroundMusic.mp3", Music.class);
		assetManager.load("data/sfx/destroy.mp3", Sound.class);
		assetManager.load("data/sfx/drop.mp3", Sound.class);
		assetManager.load("data/sfx/fall.mp3", Sound.class);
		assetManager.load("data/sfx/swipe.mp3", Sound.class);

	}

	public static void retrieve(AssetManager assetManager) {
		backgroundMusic = assetManager.get("data/sfx/backgroundMusic.mp3", Music.class);
		dropSfx = assetManager.get("data/sfx/drop.mp3", Sound.class);
		fallSfx = assetManager.get("data/sfx/fall.mp3", Sound.class);
		swipeSfx = assetManager.get("data/sfx/swipe.mp3", Sound.class);
		destroySfx = assetManager.get("data/sfx/destroy.mp3", Sound.class);
	}
}
