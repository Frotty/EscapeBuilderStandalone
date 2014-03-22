/**
 * 
 */
package de.fatochs.engine.core.ui;

import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

/**
 * An abstract class for game screens.
 * <p>
 * Every game screen MUST extend this class. Most of the methods can be
 * overridden to change the default behavior.
 * <p>
 * The {@code BaseScreen} provides a screen transition method. Override this
 * method to change the screen transition behavior.
 * <p>
 * The {@code BaseScreen} provides an abstract method for handling the pressing
 * of the back button on a smart phone.
 * <p>
 * The {@code BaseScreen} provides a render methods for game screens and a
 * method to see if it is a game screen.
 * 
 * @author pinkie.swirl@mailbox.org
 */
public abstract class BaseScreen extends Table
{
	/**
	 * The reference to the game class.
	 */
	protected final BaseGame	game;

	/**
	 * Used to determine if this screen is a game screen.
	 * <p>
	 * TRUE if the screen is a game screen, FALSE otherwise.
	 */
	private final boolean		isGameScreen;

	/**
	 * The duration of the screen transition for the {@link #screenOut()}
	 * method.
	 */
	public float				dur;

	/**
	 * Constructor for creating a screen that is NOT a game screen.
	 * <p>
	 * This means that {@link #isGameScreen} is false!
	 * 
	 * @param game
	 *            the reference to the game class
	 */
	public BaseScreen(final BaseGame game)
	{
		this(game, false);
	}

	/**
	 * Constructor for creating a screen.
	 * 
	 * @param game
	 *            the reference to the game class
	 * @param isGameScreen
	 *            TRUE if the screen should be a game screen, FALSE otherwise
	 */
	public BaseScreen(final BaseGame game, boolean isGameScreen)
	{
		assert game != null : "The reference to the game class is NULL!";

		this.game = game;

		this.isGameScreen = isGameScreen;

		dur = game.defaultDur;

		defaults().pad(Math.round(Math.max(game.height, game.width) * .02f));

		setFillParent(true);
	}

	/**
	 * Can be used to recycle screens instead of creating new ones all the time.
	 * 
	 * @return this
	 */
	public BaseScreen show()
	{
		return this;
	}

	/**
	 * Override this method to change the screen transition.
	 */
	protected void screenOut()
	{
		final float xPos = -game.width;
		final MoveToAction action = Actions.moveTo(xPos, 0f, dur);
		addAction(action);
	}

	/**
	 * Override this method if you want to specify what should happen when the
	 * back button on a smart phone is pressed.
	 */
	public abstract void onBackPress();

	public void hide()
	{
	}

	/**
	 * Returns TRUE if the screen is a game screen, FALSE otherwise.
	 * 
	 * @return TRUE if the screen is a game screen, FALSE otherwise
	 */
	public final boolean isGameScreen()
	{
		return isGameScreen;
	}

	/**
	 * The render methods for the game screen.
	 * <p>
	 * Override this only in the game screen, other screens are not calling this
	 * method!
	 * 
	 * @param delta
	 *            the time of the last game loop.
	 */
	public void render(float delta)
	{
		// Override in game screen.
	}
}
