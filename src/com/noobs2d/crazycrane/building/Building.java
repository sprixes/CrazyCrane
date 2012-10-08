package com.noobs2d.crazycrane.building;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.noobs2d.crazycrane.stage.CrazyCraneStage;
import com.noobs2d.tweenengine.utils.DynamicAnimation;
import com.noobs2d.tweenengine.utils.DynamicDisplay;

public class Building extends DynamicDisplay {
	public enum buildingState {
		FALLING, IDLE, DESTROYED
	}

	public static final int BUILDING_RED = 101;
	public static final int BUILDING_BLUE = 102;
	public static final int BUILDING_YELLOW = 103;
	public static final int BUILDING_GREEN = 104;

	public buildingState state = buildingState.IDLE;
	public DynamicAnimation fallingState;
	public DynamicAnimation idleState;
	public DynamicAnimation destroyedState;
	public int BuildingColor;

	protected CrazyCraneStage stage;

	public boolean readyDestroyed = false;

	@Override
	public Rectangle getBounds() {
		return getStateAnimation().getBounds();
	}

	public DynamicAnimation getStateAnimation() {
		if (state == buildingState.IDLE) {
			return idleState;
		}
		if (state == buildingState.FALLING) {
			return fallingState;
		}
		if (state == buildingState.DESTROYED) {
			return destroyedState;
		}
		return null;
	}

	@Override
	public void render(SpriteBatch spriteBatch) {
		if (visible) {
			spriteBatch.setColor(color.r, color.g, color.b, color.a);
			getStateAnimation().color.set(color);
			getStateAnimation().position.add(position);
			getStateAnimation().render(spriteBatch);
			getStateAnimation().position.sub(position);
		}
	}

	@Override
	public void setRegistration(DynamicRegistration registration) {

	}

	@Override
	public void update(float deltaTime) {

		if (visible) {
			switch (state) {
				case IDLE:
					idleState.update(deltaTime);
					break;
				case FALLING:
					fallingState.update(deltaTime);
					break;
				case DESTROYED:
					destroyedState.update(deltaTime);
					break;

			}

		}
		updateTween();
	}

}
