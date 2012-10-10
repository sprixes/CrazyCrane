package com.noobs2d.crazycrane.stage;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.math.Vector2;
import com.noobs2d.crazycrane.building.Building;
import com.noobs2d.tweenengine.utils.DynamicScreen;

public abstract class CrazyCraneStage extends DynamicScreen {

	protected ArrayList<Building> column1Array = new ArrayList<Building>();
	protected ArrayList<Building> column2Array = new ArrayList<Building>();
	protected ArrayList<Building> column3Array = new ArrayList<Building>();
	protected ArrayList<ArrayList<Building>> allArrayList = new ArrayList<ArrayList<Building>>();
	protected ArrayList<Vector2> temp;

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

	public CrazyCraneStage(Game game) {
		super(game);

	}

	protected abstract boolean inputBuilding(float x, float y, int pointer);

	protected abstract void inputDrop(int Column);

	protected abstract void updateBuildingCombo(float deltatime);

	protected abstract void updateBuildingCombo2(float deltatime);

	protected abstract void updateBuilding(float delta);
}
