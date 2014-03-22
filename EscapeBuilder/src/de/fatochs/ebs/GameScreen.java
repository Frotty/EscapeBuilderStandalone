/**
 * 
 */
package de.fatochs.ebs;

import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenManager;
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
	TweenManager	tweenManager;
	Maze			testMaze;

	/**
	 * @param game
	 */
	public GameScreen(BaseGame game)
	{
		super(game);

		Tween.registerAccessor(Killer.class, new KillerAccessor());
		tweenManager = new TweenManager();
		testMaze = new Maze();
	}

	@Override
	public void render(float delta)
	{
		testMaze.update();

		game.batch.setProjectionMatrix(game.camera.combined);
		game.batch.begin();
		testMaze.render(game.batch);
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

}
