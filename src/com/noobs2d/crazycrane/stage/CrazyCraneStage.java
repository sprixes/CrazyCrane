package com.noobs2d.crazycrane.stage;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.math.Vector2;
import com.noobs2d.crazycrane.building.Building;
import com.noobs2d.tweenengine.utils.DynamicAnimation;
import com.noobs2d.tweenengine.utils.DynamicScreen;
import com.noobs2d.tweenengine.utils.DynamicSprite;

public abstract class CrazyCraneStage extends DynamicScreen {

	protected ArrayList<Building> column1Array = new ArrayList<Building>();
	protected ArrayList<Building> column2Array = new ArrayList<Building>();
	protected ArrayList<Building> column3Array = new ArrayList<Building>();
	protected ArrayList<ArrayList<Building>> allArrayList = new ArrayList<ArrayList<Building>>();
	protected ArrayList<Vector2> temp;
	protected DynamicAnimation comboArt;
	protected DynamicSprite background;

	protected final Vector2[][] gridPoints = new Vector2[3][20];
	protected final Vector2[] topGridpoints = new Vector2[3];
	protected boolean Column0Ready = true;
	protected boolean Column1Ready = true;
	protected boolean Column2Ready = true;
	protected boolean firstCounter = false;
	protected HeadsUpDisplay hud;
	protected Random random = new Random();
	public float stageSecondsDuration = 30f;
	public float stageSecondsElapsed = 0;
	public Building BuildingTemp;
	public int score = 0;
	public float time = 120;
	public Vector2 positionTouch;

	public CrazyCraneStage(Game game) {
		super(game, 800, 1280);

	}

	protected abstract boolean inputBuilding(float x, float y);

	protected abstract void inputDrop(int Column);

	protected abstract void updateBuildingCombo(float deltatime);

	protected abstract void updateBuildingCombo2(float deltatime);

	protected abstract void updateBuilding(float delta);
}
