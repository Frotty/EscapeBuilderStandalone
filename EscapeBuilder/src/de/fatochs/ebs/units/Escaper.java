package de.fatochs.ebs.units;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
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

	boolean	isMoving	= false;

	Vector2	movement	= new Vector2();

	public Escaper(TextureRegion region, final Vector2 position, Maze maze)
	{
		super(new Sprite(region), position); // FIXME add correct sprite

		currentMaze = maze;
	}

	public void move(int x, int y)
	{
		movement.set(0, 0);

		if (x - 10 > position.x)
		{
			movement.add(1, 0);
		} else if (x + 10 < position.x)
		{
			movement.add(-1, 0);
		}

		if (y - 10 > position.y)
		{
			movement.add(0, 1);
		} else if (y + 10 < position.y)
		{
			movement.add(0, -1);
		}

		movement.nor();
	}

	public void startMoving()
	{
		isMoving = true;
	}

	public void stopMoving()
	{
		isMoving = false;
	}

	/**
	 * Checks the current Tile the Escaper stands on and acts accordingly
	 */
	@Override
	public void update()
	{

		final Tile currentTile = currentMaze.getTileFromPos(position);

		if (currentTile != null)
		{
			switch (currentTile.info)
			{
			// case CONTROLLABLE_ICE:
			// //TODO
			// break;
			// case UNWALKABLE:
			// kill();
			case PATH:
				if (isMoving)
				{
					move((int) (Gdx.input.getX() / 0.6), (int) (Gdx.graphics.getHeight() / 0.6 - Gdx.input.getY() / 0.6));
					addVel(movement);
				}
				break;

			default:

				break;

			}
		} else
		{
			kill();
		}

		super.update();

	}

	/**
	 * Kills the Escaper
	 */
	public void kill()
	{
		Gdx.app.debug("Escaper", "DEAD");
	}

}
