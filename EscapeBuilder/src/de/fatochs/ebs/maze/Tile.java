package de.fatochs.ebs.maze;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

import de.fatochs.engine.core.entities.SpriteEntity;

public class Tile extends SpriteEntity
{
	public TileInformation	info;

	public Tile(final Vector2 position, final TileInformation info)
	{
		super(position);
		this.info = info;
	}

	public void createSprite()
	{
		// TODO Find correct TextureRegion from TileSet
		sprite = new Sprite(info.tileSet.getMid());
		sprite.setPosition(position.x, position.y);
		sprite.setOrigin(position.x + sprite.getWidth() / 2, position.y + sprite.getHeight() / 2);
	}

	public Sprite getSprite()
	{
		return sprite;
	}
}
