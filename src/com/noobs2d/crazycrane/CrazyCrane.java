package com.noobs2d.crazycrane;

import aurelienribon.tweenengine.Tween;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.noobs2d.crazycrane.stage.StageLoadingScreen;
import com.noobs2d.tweenengine.utils.DynamicDisplay;
import com.noobs2d.tweenengine.utils.DynamicScreen.DynamicCamera;

public class CrazyCrane extends Game {

	private float timeElapsed = 0f;

	@Override
	public void create() {
		Gdx.graphics.setVSync(true);
		initTween();
		init();
	}

	@Override
	public void render() {
		timeElapsed += Gdx.graphics.getDeltaTime();
		while (timeElapsed > 1.0f / 60.0f) {
			timeElapsed -= 1.0f / 60.0f;
		}

		if (getScreen() != null) {
			Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
			getScreen().render(Gdx.graphics.getDeltaTime());
		}
	}

	@Override
	public void resume() {
		timeElapsed = 1.0f / 60.f + Gdx.graphics.getDeltaTime();
		if (getScreen() != null) {
			getScreen().resume();
		}
	}

	private void init() {
		setScreen(new StageLoadingScreen(this, Settings.getAssetManager()));
	}

	private void initTween() {
		Tween.ensurePoolCapacity(15);
		Tween.registerAccessor(DynamicCamera.class, new DynamicCamera());
		Tween.registerAccessor(DynamicDisplay.class, new DynamicDisplay() {

			@Override
			public Rectangle getBounds() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public int getValues(DynamicDisplay arg0, int arg1, float[] arg2) {
				return 0;
			}

			@Override
			public void render(SpriteBatch spriteBatch) {
				// TODO Auto-generated method stub

			}

			@Override
			public void setRegistration(DynamicRegistration registration) {
				// TODO Auto-generated method stub

			}

			@Override
			public void setValues(DynamicDisplay arg0, int arg1, float[] arg2) {
				// TODO Auto-generated method stub

			}

			@Override
			public void update(float deltaTime) {
				// TODO Auto-generated method stub

			}
		});
	}

}
