package de.fatochs.ebs;

import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenManager;

<<<<<<< HEAD
=======
import com.badlogic.gdx.ApplicationListener;
>>>>>>> 26f1a774a99b5a835f4ba9d4aca32bd9fd8f6d8e
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
<<<<<<< HEAD
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
=======
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
>>>>>>> 26f1a774a99b5a835f4ba9d4aca32bd9fd8f6d8e

import de.fatochs.ebs.maze.Maze;
import de.fatochs.ebs.units.Escaper;
import de.fatochs.ebs.units.Killer;
import de.fatochs.ebs.units.KillerAccessor;
import de.fatochs.engine.core.entities.SpriteEntity;
import de.fatochs.engine.core.ui.BaseGame;
import de.fatochs.engine.core.ui.BaseScreen;

public class EBGame extends BaseGame
{
	public static TextureAtlas	textureAtlas;
	private OrthographicCamera	camera;
	private SpriteBatch			batch;
	public static Escaper		escaper;
	SpriteEntity				se;
	TweenManager				tweenManager;
	Maze testMaze;

	/*
	 * (non-Javadoc)
	 * @see de.fatochs.engine.core.ui.BaseGame#createMe()
	 */
	@Override
	protected void createMe()
	{
		camera = new OrthographicCamera(1, height / width);

<<<<<<< HEAD
		camera = new OrthographicCamera(width, height);
		camera.setToOrtho(false, width, height);
=======
		camera = new OrthographicCamera(w, h);
		camera.setToOrtho(false, w, h);
>>>>>>> 26f1a774a99b5a835f4ba9d4aca32bd9fd8f6d8e
		batch = new SpriteBatch();
		Tween.registerAccessor(Killer.class, new KillerAccessor());
		textureAtlas = new TextureAtlas(Gdx.files.internal("textures/tiles/packed/EBSPack.pack"));
		tweenManager = new TweenManager();
		testMaze = new Maze();
<<<<<<< HEAD
=======

>>>>>>> 26f1a774a99b5a835f4ba9d4aca32bd9fd8f6d8e
	}

	@Override
	public void dispose()
	{
		batch.dispose();
	}

	/*
	 * (non-Javadoc)
	 * @see de.fatochs.engine.core.ui.UiApp#atlasPath()
	 */
	@Override
	protected String atlasPath()
	{
<<<<<<< HEAD
		return "data/texture.atlas";
	}

	/*
	 * (non-Javadoc)
	 * @see de.fatochs.engine.core.ui.UiApp#skinPath()
	 */
	@Override
	protected String skinPath()
	{
		return null;
=======
		testMaze.update();
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		testMaze.render(batch);
		batch.end();
		tweenManager.update(Gdx.graphics.getDeltaTime());

>>>>>>> 26f1a774a99b5a835f4ba9d4aca32bd9fd8f6d8e
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * de.fatochs.engine.core.ui.UiApp#styleSkin(com.badlogic.gdx.scenes.scene2d
	 * .ui.Skin, com.badlogic.gdx.graphics.g2d.TextureAtlas)
	 */
	@Override
	protected void styleSkin(Skin skin, TextureAtlas atlas)
	{
		new Styles().styleSkin(skin, atlas);
	}

	/*
	 * (non-Javadoc)
	 * @see de.fatochs.engine.core.ui.UiApp#getFirstScreen()
	 */
	@Override
	protected BaseScreen getFirstScreen()
	{
		return new MainScreen(this);
	}

	/*
	 * (non-Javadoc)
	 * @see de.fatochs.engine.core.ui.BaseGame#renderMe(float)
	 */
	@Override
	protected void renderMe(float delta)
	{
		testMaze.update();
		
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		testMaze.render(batch);
		batch.end();
		tweenManager.update(Gdx.graphics.getDeltaTime());
	}
}
