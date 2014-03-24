/**
 * 
 */
package de.fatochs.engine.core.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

/**
 * A UI component factory.
 * <p>
 * This class provides methods to easily create UI components like buttons and
 * colors.
 * 
 * @author pinkie.swirl@mailbox.org
 */
public final class UiFactory
{
	/**
	 * The UI game skin.
	 */
	private static Skin		skin;

	/**
	 * TRUE if the factory got initialized, FALSE otherwise.
	 * <p>
	 * This field is used for assert checks.
	 */
	private static boolean	isInitialized	= false;

	/**
	 * 
	 */
	private UiFactory()
	{
		// Empty private constructor
	}

	protected static void initialize(final Skin skin)
	{
		assert !UiFactory.isInitialized : "UiFactory IS already initialized! Call this method only once!";

		UiFactory.skin = skin;
		UiFactory.isInitialized = true;
	}

	public static TextButton textButton(final String text)
	{
		assert UiFactory.isInitialized : "UiFactory is NOT initialized! Call UiFactory#initialize() first!";

		return new TextButton(text, UiFactory.skin);
	}
	
	public static TextField textField(final String text)
	{
		assert UiFactory.isInitialized : "UiFactory is NOT initialized! Call UiFactory#initialize() first!";

		return new TextField(text, UiFactory.skin);
	}
	
	public static Label label(final String text)
	{
		assert UiFactory.isInitialized : "UiFactory is NOT initialized! Call UiFactory#initialize() first!";

		return new Label(text, UiFactory.skin);
	}
	
	public static <T> SelectBox<T> selectBox()
	{
		assert UiFactory.isInitialized : "UiFactory is NOT initialized! Call UiFactory#initialize() first!";

		return new SelectBox<T>(UiFactory.skin);
	}

	public static Drawable drawable(final String name)
	{
		assert UiFactory.isInitialized : "UiFactory is NOT initialized! Call UiFactory#initialize() first!";

		return UiFactory.skin.getDrawable(name);
	}
	
	public static Drawable background(final String name)
	{
		assert UiFactory.isInitialized : "UiFactory is NOT initialized! Call UiFactory#initialize() first!";
		
		return UiFactory.skin.getDrawable(name);
	}

	public static Color color(final String name)
	{
		assert UiFactory.isInitialized : "UiFactory is NOT initialized! Call UiFactory#initialize() first!";

		return UiFactory.skin.getColor(name);
	}
}
