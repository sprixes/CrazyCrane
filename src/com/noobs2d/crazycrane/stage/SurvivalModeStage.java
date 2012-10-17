package com.noobs2d.crazycrane.stage;

import java.util.ArrayList;

import javax.management.RuntimeErrorException;

import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.equations.Bounce;
import aurelienribon.tweenengine.equations.Cubic;
import aurelienribon.tweenengine.equations.Linear;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.math.Vector2;
import com.noobs2d.crazycrane.Art;
import com.noobs2d.crazycrane.Settings;
import com.noobs2d.crazycrane.Sounds;
import com.noobs2d.crazycrane.building.Building;
import com.noobs2d.crazycrane.building.Building.buildingState;
import com.noobs2d.crazycrane.building.BuildingBlue;
import com.noobs2d.crazycrane.building.BuildingGreen;
import com.noobs2d.crazycrane.building.BuildingRed;
import com.noobs2d.crazycrane.building.BuildingYellow;
import com.noobs2d.tweenengine.utils.DynamicDisplay.DynamicRegistration;

public class SurvivalModeStage extends CrazyCraneStage {

	public SurvivalModeStage(Game game, AssetManager assetManager) {
		super(game);
		initGridPoints();
		initBuilding();
		comboArt = Art.ComboArt;
		comboArt.setRegistration(DynamicRegistration.BOTTOM_LEFT);
		comboArt.visible = false;
		background = Art.BackgroundArt;
		background.setRegistration(DynamicRegistration.BOTTOM_LEFT);
		background.position.set(-10, 5);

		hud = new HeadsUpDisplay(this);
		if (Settings.musicEnabled == true) {
			Sounds.backgroundMusic.setLooping(true);
			Sounds.backgroundMusic.setVolume(100);
			Sounds.backgroundMusic.play();
		}
	}

	/**
	 * initializing Building
	 */
	private void initBuilding() {
		allArrayList.add(column1Array);
		allArrayList.add(column2Array);
		allArrayList.add(column3Array);
		allArrayList.get(0).add(getRandomBuilding());
		allArrayList.get(1).add(getRandomBuilding());
		allArrayList.get(2).add(getRandomBuilding());
		allArrayList.get(0).get(0).position.set(new Vector2(-240, topGridpoints[0].y));
		allArrayList.get(1).get(0).position.set(new Vector2(400, 1280));
		allArrayList.get(2).get(0).position.set(new Vector2(800, 1000));
		allArrayList.get(0).get(0).interpolateXY(topGridpoints[0], Cubic.INOUT, 800, true);
		allArrayList.get(1).get(0).interpolateXY(topGridpoints[1], Cubic.INOUT, 800, true);
		allArrayList.get(2).get(0).interpolateXY(topGridpoints[2], Cubic.INOUT, 800, true);
	}

	/**
	 * get BUilding object
	 * 
	 * @return
	 */
	public Building getRandomBuilding() {

		int randomNumber = random.nextInt(4) + 1;
		switch (randomNumber) {
			case 1:

				return new BuildingRed(this);
			case 2:
				return new BuildingBlue(this);
			case 3:

				return new BuildingYellow(this);
			case 4:
				return new BuildingGreen(this);
			default:
				throw new RuntimeErrorException(new Error("Invalid type for Building"));
		}

	}

	/**
	 * initializing Grid Points
	 */
	private void initGridPoints() {
		for (int topgridpointsIndex = 0; topgridpointsIndex < topGridpoints.length; topgridpointsIndex++) {
			topGridpoints[topgridpointsIndex] = new Vector2((53 + 240 * topgridpointsIndex), (float) 66 * 15);
		}

		for (int gridIndexColumn = 0; gridIndexColumn < gridPoints.length; gridIndexColumn++) {
			for (int gridIndexRow = 0; gridIndexRow < gridPoints[0].length; gridIndexRow++) {
				gridPoints[gridIndexColumn][gridIndexRow] = new Vector2((53 + 240 * gridIndexColumn), (0 + 66 * gridIndexRow));
			}

		}
	}

	@Override
	public void onTouchDown(float x, float y, int pointer) {
		System.out.println("X " + x + "\t" + y);
		Vector2 position = new Vector2(x, y);
		position.x *= (float) Settings.SCREEN_WIDTH / Gdx.graphics.getWidth();
		position.y = (Gdx.graphics.getHeight() * camera.zoom - position.y) * Settings.SCREEN_HEIGHT / Gdx.graphics.getHeight();
		positionTouch = position;
		System.out.println(position);

	}

	@Override
	public void onSwipe(float velocityX, float velocityY) {
		if (Math.abs(velocityX) > Math.abs(velocityY)) {
			if (velocityX > 0) {
				if (Settings.soundEnabled = true) {
					Sounds.swipeSfx.play();
				}
				System.out.println("RIGHT");
				allArrayList.get(0).get(allArrayList.get(0).size() - 1).interpolateXY(topGridpoints[1], Linear.INOUT, 1000, true);
				allArrayList.get(1).get(allArrayList.get(1).size() - 1).interpolateXY(topGridpoints[2], Linear.INOUT, 1000, true);
				allArrayList.get(2).get(allArrayList.get(2).size() - 1).interpolateXY(topGridpoints[0], Linear.INOUT, 1000, true);

				BuildingTemp = allArrayList.get(0).get(allArrayList.get(0).size() - 1);
				allArrayList.get(0).set(allArrayList.get(0).size() - 1, allArrayList.get(2).get(allArrayList.get(2).size() - 1));
				allArrayList.get(2).set(allArrayList.get(2).size() - 1, allArrayList.get(1).get(allArrayList.get(1).size() - 1));
				allArrayList.get(1).set(allArrayList.get(1).size() - 1, BuildingTemp);

			} else {
				if (Settings.soundEnabled = true) {
					Sounds.swipeSfx.play();
				}
				System.out.println("Left");
				allArrayList.get(0).get(allArrayList.get(0).size() - 1).interpolateXY(topGridpoints[2], Linear.INOUT, 1000, true);
				allArrayList.get(1).get(allArrayList.get(1).size() - 1).interpolateXY(topGridpoints[0], Linear.INOUT, 1000, true);
				allArrayList.get(2).get(allArrayList.get(2).size() - 1).interpolateXY(topGridpoints[1], Linear.INOUT, 1000, true);

				BuildingTemp = allArrayList.get(0).get(allArrayList.get(0).size() - 1);
				allArrayList.get(0).set(allArrayList.get(0).size() - 1, allArrayList.get(1).get(allArrayList.get(1).size() - 1));
				allArrayList.get(1).set(allArrayList.get(1).size() - 1, allArrayList.get(2).get(allArrayList.get(2).size() - 1));
				allArrayList.get(2).set(allArrayList.get(2).size() - 1, BuildingTemp);
			}
		} else {
			if (velocityY > 0) {
				inputBuilding(positionTouch.x, positionTouch.y);
			} else {
				inputBuilding(positionTouch.x, positionTouch.y);
			}
		}

	}

	@Override
	public void render(float deltaTime) {

		stageSecondsElapsed += deltaTime;
		time -= deltaTime;
		if (time < 0) {
			game.setScreen(new ScoreStage(game, score, assetManager));

		}
		// spriteBatch.setProjectionMatrix();
		getCamera().update();
		background.update(deltaTime);
		comboArt.update(deltaTime);
		updateBuilding(deltaTime);
		updateBuildingCombo(deltaTime);
		hud.update(deltaTime);
		// updateBuildingCombo2(deltaTime);

		spriteBatch.begin();
		background.render(spriteBatch);

		for (int columnIndex = allArrayList.get(0).size() - 1; columnIndex > -1; columnIndex--) {
			allArrayList.get(0).get(columnIndex).render(spriteBatch);
		}
		for (int columnIndex = allArrayList.get(1).size() - 1; columnIndex > -1; columnIndex--) {
			allArrayList.get(1).get(columnIndex).render(spriteBatch);
		}
		for (int columnIndex = allArrayList.get(2).size() - 1; columnIndex > -1; columnIndex--) {
			allArrayList.get(2).get(columnIndex).render(spriteBatch);
		}
		comboArt.render(spriteBatch);
		hud.render(spriteBatch);

		spriteBatch.end();
		// System.out.print(Gdx.graphics.getFramesPerSecond());
		// System.out.println(" DeltaTime : " + Gdx.graphics.getDeltaTime());
	}

	@Override
	public void updateBuilding(float deltaTime) {
		for (int columnIndex = allArrayList.get(0).size() - 1; columnIndex > -1; columnIndex--) {
			allArrayList.get(0).get(columnIndex).update(deltaTime);

		}
		for (int columnIndex = allArrayList.get(1).size() - 1; columnIndex > -1; columnIndex--) {
			allArrayList.get(1).get(columnIndex).update(deltaTime);

		}
		for (int columnIndex = allArrayList.get(2).size() - 1; columnIndex > -1; columnIndex--) {
			allArrayList.get(2).get(columnIndex).update(deltaTime);

		}

	}

	@Override
	protected boolean inputBuilding(float x, float y) {
		// if (x < Settings.SCREEN_WIDTH / 3 && y < Settings.SCREEN_HEIGHT / 2 +
		// Settings.SCREEN_HEIGHT / 4) {
		if (x < Settings.SCREEN_WIDTH / 3) {
			if (Column0Ready == true) {
				inputDrop(0);
				firstCounter = true;
				if (Settings.soundEnabled == true) {
					Sounds.fallSfx.play();
				}
			}
			// } else if (x < (Settings.SCREEN_WIDTH / 3) * 2 && y <
			// Settings.SCREEN_HEIGHT / 2 + Settings.SCREEN_HEIGHT / 4) {
		} else if (x < (Settings.SCREEN_WIDTH / 3) * 2) {
			if (Column1Ready == true) {
				inputDrop(1);
				firstCounter = true;
				if (Settings.soundEnabled == true) {
					Sounds.fallSfx.play();
				}
			}

			// } else if (y < Gdx.graphics.getHeight() / 2 +
			// Settings.SCREEN_HEIGHT / 4) {
		} else {
			if (Column2Ready == true) {
				inputDrop(2);
				firstCounter = true;
				if (Settings.soundEnabled == true) {
					Sounds.fallSfx.play();
				}
			}

		}
		return true;
	}

	@Override
	protected void inputDrop(int Column) {
		switch (Column) {
			case 0:
				allArrayList.get(0).get(allArrayList.get(0).size() - 1).state = buildingState.FALLING;
				allArrayList.get(0).get(allArrayList.get(0).size() - 1).interpolateXY(gridPoints[0][allArrayList.get(0).size() - 1], Linear.INOUT, 1000, true);
				allArrayList.get(0).get(allArrayList.get(0).size() - 1).tween.setCallbackTriggers(TweenCallback.COMPLETE).setCallback(new TweenCallback() {
					@Override
					public void onEvent(int type, BaseTween<?> source) {
						if (type == TweenCallback.COMPLETE) {
							if (Settings.soundEnabled = true) {
								Sounds.dropSfx.play();
							}
							allArrayList.get(0).get(allArrayList.get(0).size() - 1).tween.start(allArrayList.get(0).get(allArrayList.get(0).size() - 1).tweenManager);
							Column0Ready = true;

						}
					}
				});
				allArrayList.get(0).add(getRandomBuilding());
				allArrayList.get(0).get(allArrayList.get(0).size() - 1).position.set(new Vector2(-240, topGridpoints[0].y));
				allArrayList.get(0).get(allArrayList.get(0).size() - 1).interpolateXY(topGridpoints[0], Bounce.INOUT, 800, false);
				Column0Ready = false;
				break;

			case 1:
				allArrayList.get(1).get(allArrayList.get(1).size() - 1).state = buildingState.FALLING;
				allArrayList.get(1).get(allArrayList.get(1).size() - 1).interpolateXY(gridPoints[1][allArrayList.get(1).size() - 1], Linear.INOUT, 1000, true);
				allArrayList.get(1).get(allArrayList.get(1).size() - 1).tween.setCallbackTriggers(TweenCallback.COMPLETE).setCallback(new TweenCallback() {
					@Override
					public void onEvent(int type, BaseTween<?> source) {
						if (type == TweenCallback.COMPLETE) {
							if (Settings.soundEnabled = true) {
								Sounds.dropSfx.play();
							}
							allArrayList.get(1).get(allArrayList.get(1).size() - 1).tween.start(allArrayList.get(1).get(allArrayList.get(1).size() - 1).tweenManager);
							Column1Ready = true;
						}
					}
				});
				allArrayList.get(1).add(getRandomBuilding());
				allArrayList.get(1).get(allArrayList.get(1).size() - 1).position.set(new Vector2(400, 1280));
				allArrayList.get(1).get(allArrayList.get(1).size() - 1).interpolateXY(topGridpoints[1], Bounce.INOUT, 800, false);
				Column1Ready = false;
				break;
			case 2:
				allArrayList.get(2).get(allArrayList.get(2).size() - 1).state = buildingState.FALLING;
				allArrayList.get(2).get(allArrayList.get(2).size() - 1).interpolateXY(gridPoints[2][allArrayList.get(2).size() - 1], Linear.INOUT, 1000, true);
				allArrayList.get(2).get(allArrayList.get(2).size() - 1).tween.setCallbackTriggers(TweenCallback.COMPLETE).setCallback(new TweenCallback() {
					@Override
					public void onEvent(int type, BaseTween<?> source) {
						if (type == TweenCallback.COMPLETE) {
							if (Settings.soundEnabled = true) {
								Sounds.dropSfx.play();
							}
							allArrayList.get(2).get(allArrayList.get(2).size() - 1).tween.start(allArrayList.get(2).get(allArrayList.get(2).size() - 1).tweenManager);
							Column2Ready = true;
						}
					}
				});
				allArrayList.get(2).add(getRandomBuilding());
				allArrayList.get(2).get(allArrayList.get(2).size() - 1).position.set(new Vector2(800, 1000));
				allArrayList.get(2).get(allArrayList.get(2).size() - 1).interpolateXY(topGridpoints[2], Bounce.INOUT, 800, false);
				Column2Ready = false;
				break;

			default:
				break;
		}

	}

	@Override
	protected void updateBuildingCombo2(float deltatime) {
		if (Column0Ready || Column1Ready || Column2Ready) {
			if (firstCounter) {
				if (allArrayList.get(0).size() <= allArrayList.get(1).size() && allArrayList.get(0).size() <= allArrayList.get(2).size()) {
					if (Column0Ready) {
						checkHorizontal(allArrayList.get(0).size() - 1);
					}
				}
				if (allArrayList.get(1).size() <= allArrayList.get(2).size() && allArrayList.get(1).size() <= allArrayList.get(0).size()) {
					if (Column1Ready) {
						checkHorizontal(allArrayList.get(1).size() - 1);
					}
				}
				if (allArrayList.get(2).size() <= allArrayList.get(0).size() && allArrayList.get(2).size() <= allArrayList.get(1).size()) {
					if (Column2Ready) {
						checkHorizontal(allArrayList.get(2).size() - 1);
					}

				}

			}

		}
	}

	public void checkHorizontal(int row) {
		temp = new ArrayList<Vector2>();
		for (int i = 0; i < 3; i++) {
			System.out.println(row);
			temp.add(new Vector2(i, row));

		}
		checkTempCombo(temp);
	}

	@Override
	protected void updateBuildingCombo(float deltatime) {
		if (Column0Ready || Column1Ready || Column2Ready) {
			if (Column0Ready) {
				if (allArrayList.get(0).size() - 1 >= 3) {
					checkTempCombo(checkVertical(0, allArrayList.get(0).size() - 1));
				}

			}
			if (Column1Ready) {
				if (allArrayList.get(1).size() - 1 >= 3) {
					checkTempCombo(checkVertical(1, allArrayList.get(1).size() - 1));
				}

			}
			if (Column2Ready) {
				if (allArrayList.get(2).size() - 1 >= 3) {
					checkTempCombo(checkVertical(2, allArrayList.get(2).size() - 1));
				}
			}
		}
	}

	public ArrayList<Vector2> checkVertical(int col, int row) {
		temp = new ArrayList<Vector2>();

		for (int index = row - 1; index >= row - 3; index--) {

			temp.add(new Vector2(col, index));
		}

		return temp;

	}

	public void checkTempCombo(ArrayList<Vector2> temp) {

		if (allArrayList.get((int) temp.get(1).x).get((int) temp.get(1).y) != null && allArrayList.get((int) temp.get(2).x).get((int) temp.get(2).y) != null
				&& allArrayList.get((int) temp.get(0).x).get((int) temp.get(0).y) != null) {
			int tempColor = allArrayList.get((int) temp.get(0).x).get((int) temp.get(0).y).BuildingColor;

			if (allArrayList.get((int) temp.get(1).x).get((int) temp.get(1).y).state == buildingState.FALLING
					&& allArrayList.get((int) temp.get(2).x).get((int) temp.get(2).y).state == buildingState.FALLING
					&& allArrayList.get((int) temp.get(0).x).get((int) temp.get(0).y).state == buildingState.FALLING) {

				if (allArrayList.get((int) temp.get(1).x).get((int) temp.get(1).y).BuildingColor == tempColor
						&& allArrayList.get((int) temp.get(2).x).get((int) temp.get(2).y).BuildingColor == tempColor) {
					if (Settings.soundEnabled = true) {
						Sounds.destroySfx.play();
					}

					camera.shake();

					comboArt.visible = true;
					comboArt.color.a = 1;
					comboArt.position.set(allArrayList.get((int) temp.get(1).x).get((int) temp.get(1).y).position);
					comboArt.interpolateAlpha(0, Bounce.INOUT, 1000, true).setCallbackTriggers(TweenCallback.COMPLETE).setCallback(new TweenCallback() {
						@Override
						public void onEvent(int type, BaseTween<?> source) {
							comboArt.visible = false;

						}
					});
					allArrayList.get((int) temp.get(0).x).get((int) temp.get(0).y).state = buildingState.DESTROYED;
					allArrayList.get((int) temp.get(1).x).get((int) temp.get(1).y).state = buildingState.DESTROYED;
					allArrayList.get((int) temp.get(2).x).get((int) temp.get(2).y).state = buildingState.DESTROYED;
					allArrayList.get((int) temp.get(0).x).remove((int) temp.get(0).y);
					allArrayList.get((int) temp.get(1).x).remove((int) temp.get(1).y);
					allArrayList.get((int) temp.get(2).x).remove((int) temp.get(2).y);
					score += 3;
				}
			}
		}

	}

	@Override
	public void dispose() {
		assetManager.clear();
	}

	@Override
	public void resume() {
		game.setScreen(new StageLoadingScreen(game, this, Settings.getAssetManager()));
	}

}
