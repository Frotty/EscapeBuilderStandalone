package de.fatochs.ebs.units;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

import de.fatochs.ebs.maze.Maze;
import de.fatochs.ebs.maze.Tile;
import de.fatochs.engine.core.entities.SpriteEntity;

/**
 * Player-controlled Escaper that moves through the maze
 * 
 * @author Frotty
 */
public class Escaper extends SpriteEntity
{
	/**
	 * Current Maze the escaper is in.
	 */
	Maze	currentMaze;

	public Escaper(final Vector2 position)
	{
		super(new Sprite(), position); // FIXME add correct sprite
		// TODO Auto-generated constructor stub
	}

	/**
	 * Checks the current Tile the Escaper stands on and acts accordingly
	 */
	@Override
	public void update()
	{
		final Tile currentTile = currentMaze.getTileFromPos(position);
		switch (currentTile.info)
		{
		case CONTROLLABLE_ICE:
			//TODO
			break;
		case UNWALKABLE:
			kill();
		case WALKABLE:
			position.add(velocity);
		default:
			break;

		}
		super.update();

	}

	/**
	 * Kills the Escaper
	 */
	public void kill()
	{

	}

}
