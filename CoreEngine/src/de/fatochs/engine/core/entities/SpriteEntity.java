package de.fatochs.engine.core.entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class SpriteEntity extends Entity 
{
	public Sprite sprite;
	
	public SpriteEntity(Vector2 position) 
	{
		this.position = position;
	}
	
	public void render(SpriteBatch batch) 
	{
		sprite.draw(batch);
	}
	
	@Override
	public void update() 
	{
		// TODO Auto-generated method stub

	}

}
