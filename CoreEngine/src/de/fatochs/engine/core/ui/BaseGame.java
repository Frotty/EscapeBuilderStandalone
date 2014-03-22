/**
 * 
 */
package de.fatochs.engine.core.ui;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

/**
 * @author pinkie.swirl@mailbox.org
 */
public abstract class BaseGame implements ApplicationListener
{
	/**
	 * The screen UI stage.
	 */
	private Stage					stage;
	/**
	 * The UI texture atlas.
	 */
	protected TextureAtlas			atlas;
	/**
	 * The UI skin.
	 */
	private Skin					skin;

	public Batch					batch;
	public Camera					camera;

	/**
	 * The input multiplexer.
	 * <p>
	 * As default only the stage is added as an {@linkplain InputProcessor input
	 * processor}.
	 */
	private static InputMultiplexer	inputs		= new InputMultiplexer();

	/**
	 * The screen width.
	 */
	public float					width;
	/**
	 * The screen height.
	 */
	public float					height;
	/**
	 * The screen density.
	 */
	public float					density;

	/**
	 * The currently rendered screen.
	 */
	private BaseScreen				currentScreen;
	/**
	 * The next rendered screen (for screen switching).
	 */
	private BaseScreen				nextScreen;

	/**
	 * The duration of the screen transitions.
	 */
	protected float					defaultDur	= 0.333f;
	/**
	 * The duration accumulator.
	 */
	private float					durAccum	= -420f;

	/**
	 * The color for clearing the screen.
	 * <p>
	 * The default color is black.
	 * <p>
	 * Because one can change the color values of a color object, the clear
	 * color is settable even if it is final!
	 */
	private static final Color		CLEAR_COLOR	= new Color(Color.BLACK);

	@Override
	public final void create()
	{
		density = Gdx.graphics.getDensity();

		// Sets the width and height, to have an easy access to them
		width = Gdx.graphics.getWidth() / density;
		height = Gdx.graphics.getHeight() / density;

		stage = new Stage(width, height, false);

		atlas = new TextureAtlas(atlasPath());

		skin = new Skin();
		skin.addRegions(atlas);

		// Adds all recourses from a skin file, if it exists.
		final String skinPath = skinPath();
		if (skinPath != null)
		{
			skin.load(Gdx.files.internal(skinPath));
		}
		styleSkin(skin, atlas);

		UiFactory.initialize(skin);

		Gdx.input.setInputProcessor(stage);
		Gdx.input.setCatchBackKey(true);
		stage.addListener(new InputListener()
		{
			@Override
			public boolean keyDown(final InputEvent event, final int keycode)
			{
				if (keycode == Keys.BACK)
				{
					currentScreen.onBackPress();
				}
				return false;
			}
		});
		currentScreen = getFirstScreen().show();
		stage.addActor(currentScreen);

		Gdx.input.setInputProcessor(BaseGame.inputs);

		BaseGame.inputs.addProcessor(stage);
		
		batch = new SpriteBatch();
		camera = new OrthographicCamera(width, height);

		createMe();
	}

	/**
	 * Override this method to add create code to the create call.
	 */
	protected abstract void createMe();

	/**
	 * Provide the path to the UI atlas file here.
	 * <p>
	 * This is <i>NOT</i> optional, the application will throw an exception if
	 * {@code NULL} is returned.
	 * 
	 * @return the atlas file path, <i>MUST</i> never return {@code NULL}!
	 */
	protected abstract String atlasPath();

	/**
	 * Provide the path to the skin file here.
	 * <p>
	 * This is optional. If no path is specified an empty skin file is created.
	 * 
	 * @return the skin file path, or {@code NULL} if no file exist
	 */
	protected abstract String skinPath();

	/**
	 * Add the skin styles here.
	 * <p>
	 * This is optional.
	 * 
	 * @param skin
	 *            the skin to style
	 * @param atlas
	 *            the texture atlas
	 */
	protected abstract void styleSkin(Skin skin, TextureAtlas atlas);

	/**
	 * Specifies the screen to be loaded in the beginning.
	 * <p>
	 * This should normally be the main menu screen.
	 * 
	 * @return the first screen
	 */
	protected abstract BaseScreen getFirstScreen();

	@Override
	public final void render()
	{
		final float delta = Gdx.graphics.getDeltaTime();

		if (durAccum > 0f)
		{
			durAccum -= delta;
			if (durAccum <= 0f)
			{
				currentScreen.hide();
				currentScreen.remove();
				currentScreen = nextScreen;
				currentScreen.setTouchable(Touchable.enabled);
				currentScreen.setPosition(0f, 0f);
				nextScreen = null;
			}
		}

		Gdx.gl.glClearColor(CLEAR_COLOR.r, CLEAR_COLOR.g, CLEAR_COLOR.b, CLEAR_COLOR.a);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

		if (currentScreen.isGameScreen())
		{
			batch.setProjectionMatrix(camera.combined);
			batch.begin();
			currentScreen.render(delta);
			batch.end();
		}

		stage.act(delta);
		stage.draw();
	}

	/**
	 * Sets the clear color.
	 * 
	 * @param color
	 *            the new color
	 */
	public void setClearColor(final Color color)
	{
		CLEAR_COLOR.set(color);
	}

	/**
	 * Switches the screen with a transition.
	 * 
	 * @param screen
	 *            the screen to switch to
	 */
	public void switchScreens(final BaseScreen screen)
	{
		durAccum = currentScreen.dur;
		nextScreen = screen;
		nextScreen.setTouchable(Touchable.disabled);
		nextScreen.show();
		stage.addActor(nextScreen);
		if (currentScreen != null)
		{
			currentScreen.screenOut();
			currentScreen.setTouchable(Touchable.disabled);
			currentScreen.toFront();
		}
	}

	@Override
	public void resize(final int width, final int height)
	{
		this.width = width / density;
		this.height = height / density;

		stage.setViewport(this.width, this.height, false);
	}

	@Override
	public void pause()
	{
		// Do nothing
	}

	@Override
	public void resume()
	{
		// Do nothing
	}

	@Override
	public void dispose()
	{
		stage.dispose();
		skin.dispose();
		atlas.dispose();
	}
}
