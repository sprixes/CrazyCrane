package com.noobs2d.crazycrane;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.TextureAtlasLoader;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.ResolutionFileResolver;
import com.badlogic.gdx.assets.loaders.resolvers.ResolutionFileResolver.Resolution;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class Settings {

	public static final int SCREEN_WIDTH = 800;
	public static final int SCREEN_HEIGHT = 1280;

	public static boolean musicEnabled = true;
	public static boolean soundEnabled = true;

	public static AssetManager getAssetManager() {

		Resolution[] resolutions = { new Resolution(480, 320, ".480320"), new Resolution(800, 480, ".800480"), new Resolution(856, 480, ".856480"), new Resolution(1280, 800, ".1280800") };
		ResolutionFileResolver resolver = new ResolutionFileResolver(new InternalFileHandleResolver(), resolutions);

		AssetManager assetManager = new AssetManager();
		assetManager.setLoader(TextureAtlas.class, new TextureAtlasLoader(resolver));

		Texture.setAssetManager(assetManager);

		return assetManager;
	}

}
