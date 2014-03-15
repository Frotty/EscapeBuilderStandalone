package de.fatochs.ebs.maze;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

import de.fatochs.engine.core.entities.SpriteEntity;

public class Tile extends SpriteEntity
{
	public TileInformation info;
	public Tile(Vector2 position, TileInformation info)
	{
		super(position);
		this.info = info;
		sprite = new Sprite(info.region);
	}
	
	
	

	
	
}
