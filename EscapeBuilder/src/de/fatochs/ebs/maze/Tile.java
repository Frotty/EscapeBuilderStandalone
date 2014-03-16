package de.fatochs.ebs.maze;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import de.fatochs.engine.core.entities.SpriteEntity;

public class Tile extends SpriteEntity
{
	public TileInformation	info;

	public Tile(final Vector2 position, final TileInformation info)
	{
		super(createSprite(info.region, position), position);
		this.info = info;
	}
	
	private static Sprite createSprite(TextureRegion region, Vector2 position) {
		Sprite sprite = new Sprite(region);
		sprite.setPosition(position.x, position.y);
		sprite.setOrigin(position.x+sprite.getWidth()/2, position.y+sprite.getHeight()/2);
		return sprite;
	}

}
