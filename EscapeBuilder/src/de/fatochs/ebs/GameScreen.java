/**
 * 
 */
package de.fatochs.ebs;

import java.io.IOException;
import java.io.Writer;

import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;

import de.fatochs.ebs.maze.Maze;
import de.fatochs.ebs.units.Killer;
import de.fatochs.ebs.units.KillerAccessor;
import de.fatochs.engine.core.ui.BaseGame;
import de.fatochs.engine.core.ui.BaseScreen;

/**
 * @author pinkie.swirl@mailbox.org
 */
public class GameScreen extends BaseScreen
{
	OrthogonalTiledMapRenderer	renderer;

	TweenManager				tweenManager;
	Maze						testMaze;

	/**
	 * @param game
	 */
	public GameScreen(BaseGame game)
	{
		super(game, true);

		Tween.registerAccessor(Killer.class, new KillerAccessor());
		tweenManager = new TweenManager();
		testMaze = new Maze();

		renderer = new OrthogonalTiledMapRenderer(testMaze, 3f, game.batch);
		game.camera.setToOrtho(false, game.width, game.height);
		game.camera.update();

		testMaze.save();
	}

	@Override
	public void render(float delta)
	{
		testMaze.update();

		game.camera.update();

		renderer.setView(game.camera);
		renderer.render();

		//		game.batch.setProjectionMatrix(game.camera.combined);
		//		game.batch.begin();
		//		testMaze.render(game.batch);
		//		game.batch.end();

		tweenManager.update(delta);
	}

	/*
	 * (non-Javadoc)
	 * @see de.fatochs.engine.core.ui.BaseScreen#onBackPress()
	 */
	@Override
	public void onBackPress()
	{
		game.switchScreens(new MainScreen(game));
	}

}
