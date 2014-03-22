/**
 * 
 */
package de.fatochs.engine.core.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

/**
 * @author pinkie.swirl@mailbox.org
 */
public final class UiFactory
{
	private static Skin		skin;

	private static boolean	isInitialized	= false;

	/**
	 * 
	 */
	private UiFactory(final Skin skin)
	{
	}

	protected static void initialize(final Skin skin)
	{
		if (!UiFactory.isInitialized) {
			UiFactory.skin = skin;
			UiFactory.isInitialized = true;
		} else {
			System.err.println("UiFactory is already initialized! Please check your code!");
		}
	}

	public static TextButton textButton(final String text)
	{
		TextButton resultButton = null;

		if (UiFactory.isInitialized) {
			resultButton = new TextButton(text, UiFactory.skin);
		}

		return resultButton;
	}

	public static Drawable drawable(final String name)
	{
		Drawable resultDrawable = null;

		if (UiFactory.isInitialized) {
			resultDrawable = UiFactory.skin.getDrawable(name);
		}

		return resultDrawable;
	}

	public static Color color(final String name)
	{
		Color resultColor = null;

		if (UiFactory.isInitialized) {
			resultColor = UiFactory.skin.getColor(name);
		}

		return resultColor;
	}
}
