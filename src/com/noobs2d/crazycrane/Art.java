package com.noobs2d.crazycrane;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.noobs2d.tweenengine.utils.DynamicAnimation;
import com.noobs2d.tweenengine.utils.DynamicSprite;

public class Art {
	public static TextureAtlas atlas;

	public static DynamicAnimation BuildingRedFallingState;
	public static DynamicAnimation BuildingRedIdleState;
	public static DynamicAnimation BuildingRedDestroyedState;

	public static DynamicAnimation BuildingYellowFallingState;
	public static DynamicAnimation BuildingYellowIdleState;
	public static DynamicAnimation BuildingYellowDestroyedState;

	public static DynamicAnimation BuildingBlueFallingState;
	public static DynamicAnimation BuildingBlueIdleState;
	public static DynamicAnimation BuildingBlueDestroyedState;

	public static DynamicAnimation BuildingGreenFallingState;
	public static DynamicAnimation BuildingGreenIdleState;
	public static DynamicAnimation BuildingGreenDestroyedState;

	public static DynamicAnimation ComboArt;
	public static DynamicSprite BackgroundArt;

	public static void load(AssetManager assetManager) {
		assetManager.load("data/gfx/gfxbuilding.pack", TextureAtlas.class);
	}

	private static void retrieveBuildingRed(AssetManager assetManager) {
		atlas = assetManager.get("data/gfx/gfxbuilding.pack", TextureAtlas.class);
		BuildingRedFallingState = new DynamicAnimation(0.1f, atlas.findRegion("Red"));
		BuildingRedIdleState = new DynamicAnimation(0.1f, atlas.findRegion("Red"));
		BuildingRedDestroyedState = new DynamicAnimation(0.1f, atlas.findRegion("Red"));
	}

	private static void retrieveBuildingBlue(AssetManager assetManager) {
		atlas = assetManager.get("data/gfx/gfxbuilding.pack", TextureAtlas.class);

		BuildingBlueFallingState = new DynamicAnimation(0.1f, atlas.findRegion("Blue"));
		BuildingBlueIdleState = new DynamicAnimation(0.1f, atlas.findRegion("Blue"));
		BuildingBlueDestroyedState = new DynamicAnimation(0.1f, atlas.findRegion("Blue"));
	}

	private static void retrieveBuildingYellow(AssetManager assetManager) {
		atlas = assetManager.get("data/gfx/gfxbuilding.pack", TextureAtlas.class);
		BuildingYellowFallingState = new DynamicAnimation(0.1f, atlas.findRegion("Yellow"));
		BuildingYellowIdleState = new DynamicAnimation(0.1f, atlas.findRegion("Yellow"));
		BuildingYellowDestroyedState = new DynamicAnimation(0.1f, atlas.findRegion("Yellow"));

	}

	private static void retrieveBuildingGreen(AssetManager assetManager) {
		atlas = assetManager.get("data/gfx/gfxbuilding.pack", TextureAtlas.class);
		BuildingGreenFallingState = new DynamicAnimation(0.1f, atlas.findRegion("Green"));
		BuildingGreenIdleState = new DynamicAnimation(0.1f, atlas.findRegion("Green"));
		BuildingGreenDestroyedState = new DynamicAnimation(0.1f, atlas.findRegion("Green"));
	}

	private static void retrieveComboArt(AssetManager assetManager) {
		atlas = assetManager.get("data/gfx/gfxbuilding.pack", TextureAtlas.class);
		ComboArt = new DynamicAnimation(0.1f, atlas.findRegion("combo"));
		BackgroundArt = new DynamicSprite(atlas.findRegion("bg"), 0, 0);

	}

	public static void retrieve(AssetManager assetManager) {
		retrieveBuildingRed(assetManager);
		retrieveBuildingYellow(assetManager);
		retrieveBuildingGreen(assetManager);
		retrieveBuildingBlue(assetManager);
		retrieveComboArt(assetManager);

	}

}
