package de.fatochs.ebs;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import de.fatochs.ebs.units.Escaper;
import de.fatochs.engine.core.entities.SpriteEntity;

public class EBGame implements ApplicationListener 
{
	public static TextureAtlas textureAtlas;
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Texture texture;
	public static Escaper escaper;
	SpriteEntity se;
	@Override
	public void create() 
	{		
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		
		camera = new OrthographicCamera(1, h/w);
		batch = new SpriteBatch();
		
		texture = new Texture(Gdx.files.internal("data/libgdx.png"));
		texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		TextureRegion region = new TextureRegion(texture, 0, 0, 512, 275);
//		se = new SpriteEntity(new Vector2(0,0));
//		se.sprite = new Sprite(region);
//		se.sprite.setSize(0.9f, 0.9f * se.sprite.getHeight() / se.sprite.getWidth());
//		se.sprite.setOrigin(se.sprite.getWidth()/2, se.sprite.getHeight()/2);
//		se.sprite.setPosition(-se.sprite.getWidth()/2, -se.sprite.getHeight()/2);
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
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		se.render(batch);
		batch.end();
	}

	@Override
	public void resize(int width, int height) 
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
