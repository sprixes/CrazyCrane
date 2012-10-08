package com.noobs2d.crazycrane.building;

import com.noobs2d.crazycrane.Art;
import com.noobs2d.crazycrane.stage.CrazyCraneStage;

public class BuildingRed extends Building {
	public BuildingRed(CrazyCraneStage stage) {
		super.stage = stage;
		setRegistration(DynamicRegistration.BOTTOM_LEFT);
		BuildingColor = 3;
		initFalling();
		initIdle();
		initDestroyed();
	}

	private void initFalling() {
		fallingState = Art.BuildingRedFallingState;
		fallingState.setRegistration(DynamicRegistration.BOTTOM_LEFT);
	}

	private void initIdle() {
		idleState = Art.BuildingRedIdleState;
		idleState.setRegistration(DynamicRegistration.BOTTOM_LEFT);
	}

	private void initDestroyed() {
		destroyedState = Art.BuildingRedDestroyedState;
		destroyedState.setRegistration(DynamicRegistration.BOTTOM_LEFT);
	}
}
