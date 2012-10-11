package com.noobs2d.crazycrane;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Fonts {

	public static BitmapFont akaDylanCollage64;

	public static void load(AssetManager assetManager) {
		assetManager.load("data/fonts/AKA_DYLAN_COLLAGE_64.png", Texture.class);

	}

	public static void retrieve(AssetManager assetManager) {
		Texture texture;

		texture = assetManager.get("data/fonts/AKA_DYLAN_COLLAGE_64.png", Texture.class);
		texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		akaDylanCollage64 = new BitmapFont(Gdx.files.internal("data/fonts/AKA_DYLAN_COLLAGE_64.fnt"), new TextureRegion(texture), false);

	}
}
