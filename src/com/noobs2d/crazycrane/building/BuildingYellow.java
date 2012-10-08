package com.noobs2d.crazycrane.building;

import com.noobs2d.crazycrane.Art;
import com.noobs2d.crazycrane.stage.CrazyCraneStage;

public class BuildingYellow extends Building {

	public BuildingYellow(CrazyCraneStage stage) {
		super.stage = stage;
		setRegistration(DynamicRegistration.BOTTOM_LEFT);
		BuildingColor = 4;
		initFalling();
		initIdle();
		initDestroyed();
	}

	private void initFalling() {
		fallingState = Art.BuildingYellowFallingState;
		fallingState.setRegistration(DynamicRegistration.BOTTOM_LEFT);
	}

	private void initIdle() {
		idleState = Art.BuildingYellowIdleState;
		idleState.setRegistration(DynamicRegistration.BOTTOM_LEFT);
	}

	private void initDestroyed() {
		destroyedState = Art.BuildingYellowDestroyedState;
		destroyedState.setRegistration(DynamicRegistration.BOTTOM_LEFT);
	}
}
