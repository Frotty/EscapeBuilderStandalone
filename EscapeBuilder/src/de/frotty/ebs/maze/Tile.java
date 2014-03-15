package de.frotty.ebs.maze;

import com.badlogic.gdx.math.Vector2;

import de.fatochs.engine.core.entities.SpriteEntity;

/**
 * Basic TileClass from which a maze is built.
 * @author Frotty
 *
 */
public class Tile extends SpriteEntity
{
	TileType type;

	public Tile(Vector2 position) 
	{
		super(position);
	}

}
