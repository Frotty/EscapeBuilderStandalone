package de.fatochs.ebs.units;

import com.badlogic.gdx.math.Vector2;

import de.fatochs.ebs.maze.Maze;
import de.fatochs.ebs.maze.Tile;
import de.fatochs.ebs.maze.TileInformation;
import de.fatochs.engine.core.entities.Entity2D;
import de.fatochs.engine.core.entities.SpriteEntity;

/**
 * Player-controlled Escaper that moves through the maze
 * 
 * @author Frotty
 * 
 */
public class Escaper extends SpriteEntity
{
	/**
	 * Current Maze the escaper is in.
	 */
	Maze	currentMaze;

	public Escaper(Vector2 position)
	{
		super(position);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Checks the current Tile the Escaper stands on and acts accordingly
	 */
	@Override
	public void update()
	{
		Tile currentTile = currentMaze.getTileFromPos(position);
		switch (currentTile.info)
		{
		case CONTROLLABLEICE:
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
