/**
 * 
 */
package de.fatochs.engine.core.ui;

import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

/**
 * @author pinkie.swirl@mailbox.org
 */
public abstract class BaseScreen extends Table
{

	protected final BaseGame	game;

	private final boolean isGameScreen;
	
	/** the default padding of the mainTable */
	public static float		defaultPad;

	/** the duration of the screen transition for the screenOut method */
	public float			dur;

	public BaseScreen(final BaseGame game)
	{
		this(game, false);
	}
	
	public BaseScreen(final BaseGame game, boolean isGameScreen)
	{
		this.game = game;
		this.isGameScreen = isGameScreen;
		dur = game.defaultDur;
		BaseScreen.defaultPad = Math.round(Math.max(game.height, game.width) * .02f);
		defaults().pad(BaseScreen.defaultPad);
		setFillParent(true);
	}

	/**
	 * override if you want, good for if you keep your screens around instead of
	 * creating new ones each time
	 */
	public BaseScreen show()
	{
		return this;
	}

	/**
	 * override for custom screen transitions, otherwise current screen just
	 * slides to the left
	 */
	protected void screenOut()
	{
		final float xPos = -game.width;
		final MoveToAction action = Actions.moveTo(xPos, 0f, dur);
		addAction(action);
	}

	/** what happens when the back button is pressed on Android */
	public abstract void onBackPress();

	public void hide()
	{
	}

	/**
	 * @return the isGameScreen
	 */
	public boolean isGameScreen()
	{
		return isGameScreen;
	}
	
	public void render(float delta)
	{
		// Override in game screen.
	}
}
