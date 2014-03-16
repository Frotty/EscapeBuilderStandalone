/**
 * 
 */
package de.fatochs.ebs;

import de.fatochs.ebs.menu.MainMenu;
import de.fatochs.engine.core.ui.BaseScreen;
import de.fatochs.engine.core.ui.BaseGame;

/**
 * @author pinkie.swirl@mailbox.org
 */
public class GameScreen extends BaseScreen
{

	/**
	 * @param game
	 */
	public GameScreen(BaseGame game)
	{
		super(game);
		// TODO Auto-generated constructor stub
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
