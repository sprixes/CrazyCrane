package com.noobs2d.crazycrane.building;

import com.noobs2d.crazycrane.Art;
import com.noobs2d.crazycrane.stage.CrazyCraneStage;

public class BuildingBlue extends Building {
	public BuildingBlue(CrazyCraneStage stage) {
		super.stage = stage;
		setRegistration(DynamicRegistration.BOTTOM_LEFT);
		BuildingColor = 1;
		initFalling();
		initIdle();
		initDestroyed();
	}

	private void initFalling() {
		fallingState = Art.BuildingBlueFallingState;
		fallingState.setRegistration(DynamicRegistration.BOTTOM_LEFT);
	}

	private void initIdle() {
		idleState = Art.BuildingBlueIdleState;
		idleState.setRegistration(DynamicRegistration.BOTTOM_LEFT);
	}

	private void initDestroyed() {
		destroyedState = Art.BuildingBlueDestroyedState;
		destroyedState.setRegistration(DynamicRegistration.BOTTOM_LEFT);
	}
}
