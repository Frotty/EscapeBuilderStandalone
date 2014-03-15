package de.fatochs.ebs.maze;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

import de.fatochs.engine.core.entities.SpriteEntity;

public class Tile extends SpriteEntity
{
	public TileInformation	info;

	public Tile(final Vector2 position, final TileInformation info)
	{
		super(new Sprite(info.region), position);
		this.info = info;
	}

}
