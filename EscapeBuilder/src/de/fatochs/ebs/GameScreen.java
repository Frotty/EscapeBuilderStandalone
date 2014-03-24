/**
 * 
 */
package de.fatochs.ebs;

import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenManager;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;

import de.fatochs.ebs.maze.Maze;
import de.fatochs.ebs.units.Escaper;
import de.fatochs.ebs.units.Killer;
import de.fatochs.ebs.units.KillerAccessor;
import de.fatochs.engine.core.ui.BaseGame;
import de.fatochs.engine.core.ui.BaseScreen;

/**
 * @author pinkie.swirl@mailbox.org
 */
public class GameScreen extends BaseScreen
{
	private final InputProcessor inputProcessor;
	
	OrthogonalTiledMapRenderer	renderer;

	static Escaper				escaper;

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
		testMaze = new Maze("test");

		renderer = new OrthogonalTiledMapRenderer(testMaze, 1f, game.batch);
		game.camera.setToOrtho(false, game.width, game.height);
		game.camera.update();

		testMaze.save();

		escaper = new Escaper(EBGame.textureAtlas.findRegion("TilePath"), new Vector2(), testMaze);
		inputProcessor = new GameInputProcessor(game, escaper);
		
		testMaze.setEscaper(escaper);
	}

	@Override
	public void render(float delta)
	{
		escaper.update();
		testMaze.update();

		game.camera.update();

		renderer.setView(game.camera);
		renderer.render();

		game.batch.setProjectionMatrix(game.camera.combined);
		game.batch.begin();
		{
			escaper.render(game.batch);
		}
		game.batch.end();

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

	public InputProcessor getInputProcessor()
	{
		return inputProcessor;
	}
}
