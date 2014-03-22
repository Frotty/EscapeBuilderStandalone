/**
 * 
 */
package de.fatochs.ebs;

import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenManager;

import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
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
	TiledMap					map	= new TiledMap();
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

		MapLayers layers = map.getLayers();

		TiledMapTileLayer layer = new TiledMapTileLayer(testMaze.tileMap[0].length, testMaze.tileMap.length, testMaze.tileSize,
				testMaze.tileSize);

		for (int x = 0; x < testMaze.tileMap[0].length; x++)
		{
			for (int y = 0; y < testMaze.tileMap.length; y++)
			{

				Cell cell = new Cell();
				cell.setTile(new StaticTiledMapTile(testMaze.tileMap[y][x].getSprite()));
				layer.setCell(x, y, cell);
			}
		}
		layers.add(layer);

		renderer = new OrthogonalTiledMapRenderer(map, 4f, game.batch);
		game.camera.setToOrtho(false, game.width, game.height);
		game.camera.update();
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
