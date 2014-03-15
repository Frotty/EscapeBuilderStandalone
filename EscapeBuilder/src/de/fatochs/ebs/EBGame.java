package de.fatochs.ebs;

import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenManager;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import de.fatochs.ebs.maze.Maze;
import de.fatochs.ebs.units.Escaper;
import de.fatochs.ebs.units.Killer;
import de.fatochs.ebs.units.KillerAccessor;
import de.fatochs.engine.core.entities.SpriteEntity;

public class EBGame implements ApplicationListener
{
	public static TextureAtlas	textureAtlas;
	private OrthographicCamera	camera;
	private SpriteBatch			batch;
	private Texture				texture;
	public static Escaper		escaper;
	SpriteEntity				se;
	TweenManager				tweenManager;
	Maze testMaze;

	@Override
	public void create()
	{
		final float w = Gdx.graphics.getWidth();
		final float h = Gdx.graphics.getHeight();

		camera = new OrthographicCamera(w, h);
		camera.setToOrtho(false, w, h);
		batch = new SpriteBatch();
		Tween.registerAccessor(Killer.class, new KillerAccessor());
		textureAtlas = new TextureAtlas(Gdx.files.internal("textures/tiles/packed/EBSPack.pack"));
		tweenManager = new TweenManager();
		testMaze = new Maze();

	}

	@Override
	public void dispose()
	{
		batch.dispose();
		texture.dispose();
	}

	@Override
	public void render()
	{
		testMaze.update();
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		testMaze.render(batch);
		batch.end();
		tweenManager.update(Gdx.graphics.getDeltaTime());

	}

	@Override
	public void resize(final int width, final int height)
	{
	}

	@Override
	public void pause()
	{
	}

	@Override
	public void resume()
	{
	}
}
