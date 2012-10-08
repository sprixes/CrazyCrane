package com.noobs2d.crazycrane.building;

import com.noobs2d.crazycrane.Art;
import com.noobs2d.crazycrane.stage.CrazyCraneStage;

public class BuildingGreen extends Building {
	public BuildingGreen(CrazyCraneStage stage) {
		super.stage = stage;
		setRegistration(DynamicRegistration.BOTTOM_LEFT);
		BuildingColor = 2;
		initFalling();
		initIdle();
		initDestroyed();
	}

	private void initFalling() {
		fallingState = Art.BuildingGreenFallingState;
		fallingState.setRegistration(DynamicRegistration.BOTTOM_LEFT);
	}

	private void initIdle() {
		idleState = Art.BuildingGreenIdleState;
		idleState.setRegistration(DynamicRegistration.BOTTOM_LEFT);
	}

	private void initDestroyed() {
		destroyedState = Art.BuildingGreenDestroyedState;
		destroyedState.setRegistration(DynamicRegistration.BOTTOM_LEFT);
	}
}
