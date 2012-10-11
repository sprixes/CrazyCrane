package com.noobs2d.crazycrane.stage;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.noobs2d.crazycrane.Art;
import com.noobs2d.crazycrane.Fonts;
import com.noobs2d.crazycrane.Settings;
import com.noobs2d.crazycrane.Sounds;
import com.noobs2d.tweenengine.utils.DynamicScreen;

public class StageLoadingScreen extends DynamicScreen {

	AssetManager assetManager;
	BitmapFont label;
	ShapeRenderer shapeRenderer;
	String text = "NOW LOADING...";
	SurvivalModeStage stageScreen;

	public StageLoadingScreen(Game game, AssetManager assetManager) {
		super(game);
		this.assetManager = assetManager;
		label = new BitmapFont(Gdx.files.internal("data/fonts/ARIAL_NARROW_32_ITALIC.fnt"), false);
		shapeRenderer = new ShapeRenderer();
		Art.load(assetManager);
		// AliensArt.load(assetManager);
		Fonts.load(assetManager);
		// Particles.load();
		Sounds.load(assetManager);

	}

	public StageLoadingScreen(Game game, SurvivalModeStage stageScreen, AssetManager assetManager) {
		super(game);
		this.assetManager = assetManager;
		label = new BitmapFont(Gdx.files.internal("data/fonts/ARIAL_NARROW_32_ITALIC.fnt"), false);
		shapeRenderer = new ShapeRenderer();
		this.stageScreen = stageScreen;
		Art.load(assetManager);
		// AliensArt.load(assetManager);
		Fonts.load(assetManager);
		// Particles.load();
		Sounds.load(assetManager);

	}

	@Override
	public void render(float delta) {
		updateAssets();
		spriteBatch.begin();
		label.draw(spriteBatch, text, 0, 100 + label.getCapHeight());
		spriteBatch.end();
		shapeRenderer.begin(ShapeType.FilledRectangle);
		shapeRenderer.filledRect(0, 20, Settings.SCREEN_WIDTH, 70, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE);
		shapeRenderer.filledRect(0, 25, Settings.SCREEN_WIDTH, 60, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK);
		shapeRenderer.filledRect(0, 30, Settings.SCREEN_WIDTH * assetManager.getProgress(), 50);
		shapeRenderer.end();
		if (text.equals("NOW LOADING")) {
			text = "NOW LOADING.";
		} else if (text.equals("NOW LOADING.")) {
			text = "NOW LOADING..";
		} else if (text.equals("NOW LOADING..")) {
			text = "NOW LOADING...";
		} else if (text.equals("NOW LOADING...")) {
			text = "NOW LOADING";
		}
	}

	@Override
	public void resume() {
		game.setScreen(new StageLoadingScreen(game, stageScreen, assetManager));
	}

	private void updateAssets() {
		assetManager.update();
		if (assetManager.getProgress() == 1.0) { // Loading is finished.
			Art.retrieve(assetManager);
			// AliensArt.retrieve(assetManager);
			Fonts.retrieve(assetManager);
			Sounds.retrieve(assetManager);
			label.dispose();

			if (stageScreen == null) {
				game.setScreen(new SurvivalModeStage(game, assetManager));
			} else {
				game.setScreen(stageScreen);
			}
		}
	}

}
