package com.noobs2d.crazycrane.stage;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.BitmapFont.HAlignment;
import com.badlogic.gdx.math.Vector2;
import com.noobs2d.crazycrane.Fonts;
import com.noobs2d.crazycrane.Settings;
import com.noobs2d.tweenengine.utils.DynamicScreen;
import com.noobs2d.tweenengine.utils.DynamicText;

public class ScoreStage extends DynamicScreen {
	public int current_score;
	public List<DynamicText> textPool = new ArrayList<DynamicText>();
	public BitmapFont score;
	public AssetManager assetManager;

	public ScoreStage(Game game, int currentscore, AssetManager assetManager) {
		super(game, 800, 1280);
		this.assetManager = assetManager;
		current_score = currentscore;
		score = Fonts.akaDylanCollage64;
	}

	@Override
	public void render(float deltaTime) {
		for (int i = 0; i < textPool.size(); i++) {
			textPool.get(i).update(deltaTime);
		}
		spriteBatch.begin();
		score.drawWrapped(spriteBatch, "YOUR SCORE: " + current_score, 200, 640, 500, HAlignment.LEFT);
		for (int i = 0; i < textPool.size(); i++) {
			textPool.get(i).render(spriteBatch);
		}
		spriteBatch.end();

	}

	@Override
	public void onTouchDown(float x, float y, int pointer) {
		System.out.println("X " + x + "\t" + y);
		Vector2 position = new Vector2(x, y);
		position.x *= (float) Settings.SCREEN_WIDTH / Gdx.graphics.getWidth();
		position.y = (Gdx.graphics.getHeight() * camera.zoom - position.y) * Settings.SCREEN_HEIGHT / Gdx.graphics.getHeight();
		game.setScreen(new SurvivalModeStage(game, assetManager));
		System.out.println(position);
	}

	@Override
	public void dispose() {
		assetManager.clear();
	}
}
