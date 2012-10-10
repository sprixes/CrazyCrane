package com.noobs2d.crazycrane.stage;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.BitmapFont.HAlignment;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.noobs2d.crazycrane.Fonts;
import com.noobs2d.tweenengine.utils.DynamicText;

public class HeadsUpDisplay {

	public SurvivalModeStage stage;

	public List<DynamicText> textPool = new ArrayList<DynamicText>();

	public BitmapFont fps;
	public BitmapFont score;
	public BitmapFont timeElapsed;
	public BitmapFont appearanceRate;
	public BitmapFont appearanceDelay;

	public HeadsUpDisplay(SurvivalModeStage stage) {
		this.stage = stage;

		fps = new BitmapFont();

		timeElapsed = new BitmapFont();
		appearanceDelay = new BitmapFont();
		appearanceRate = new BitmapFont();
		score = Fonts.akaDylanCollage64;
	}

	public void render(SpriteBatch spriteBatch) {
		renderTexts(spriteBatch);
	}

	public void update(float deltaTime) {
		updateTexts(deltaTime);
	}

	private void renderTexts(SpriteBatch spriteBatch) {
		score.drawWrapped(spriteBatch, "" + stage.score, 500, 1200, 250, HAlignment.RIGHT);
		fps.drawWrapped(spriteBatch, "GAME FPS: " + Gdx.graphics.getFramesPerSecond() + " fps", 0, 48, 200, HAlignment.LEFT);
		timeElapsed.drawWrapped(spriteBatch, "TIME ELAPSED: " + stage.stageSecondsElapsed, 0, 36, 200, HAlignment.LEFT);

		for (int i = 0; i < textPool.size(); i++) {
			textPool.get(i).render(spriteBatch);
		}
	}

	private void updateTexts(float deltaTime) {
		for (int i = 0; i < textPool.size(); i++) {
			textPool.get(i).update(deltaTime);
		}
	}
}
