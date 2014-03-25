/**
 * 
 */
package de.fatochs.ebs;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TiledDrawable;

import de.fatochs.ebs.maze.Maze;
import de.fatochs.engine.core.ui.BaseGame;
import de.fatochs.engine.core.ui.BaseScreen;
import de.fatochs.engine.core.ui.UiFactory;

/**
 * @author pinkie.swirl@mailbox.org
 */
public class EditorScreen extends BaseScreen
{
	Maze newMaze;
	TiledDrawable grid;
	/**
	 * @param game
	 */
	public EditorScreen(final BaseGame game)
	{
		super(game, true);
		grid = new TiledDrawable(this.game.getAtlas().findRegion("Grid"));

	}
	
	@Override
	public void render(float delta)
	{
		game.camera.update();
		game.batch.begin();
		{
			grid.draw(game.batch, 0, 0, game.width,game.height);
		}
		game.batch.end();
		
		
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
