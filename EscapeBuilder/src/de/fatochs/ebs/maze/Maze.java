package de.fatochs.ebs.maze;

import java.util.Iterator;
import java.util.LinkedList;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Json;

import de.fatochs.ebs.EBGame;
import de.fatochs.ebs.units.Killer;

/**
 * The "level" built from tiles and objects
 * 
 * @author Frotty
 */
public class Maze
{
	Tile[][]			tileMap;
	int					tileSize	= 32;
	TileInformation		startTile;
	/**
	 * Objects that can collide with the Escaper
	 */
	LinkedList<Killer>	killers		= new LinkedList<Killer>();
	
	public Maze() {
		tileMap = new Tile[7][3];
		for(int i = 0; i < tileMap.length; i++) {
			for(int j = 0; j < tileMap[0].length; j++) {
				tileMap[i][j] = new Tile(new Vector2(tileSize*i, tileSize*j), TileInformation.WALKABLE);
				tileMap[i][j].createSprite();
			}
		}
		
	}

	public static Maze load(final FileHandle fileHandle)
	{
		final Json json = new Json();
		return json.fromJson(Maze.class, fileHandle);
	}

	public String save(final boolean prettyPrint)
	{
		final Json json = new Json();
		if (prettyPrint)
			return json.toJson(this, Maze.class);
		else
			return json.prettyPrint(this);
	}

	public void start()
	{

	}

	public void render(final SpriteBatch batch)
	{
		for (final Tile[] ta : tileMap)
		{
			for (final Tile tile : ta)
			{
				tile.render(batch);
			}
		}
	}

	public void update()
	{
		final Iterator<Killer> it = killers.iterator();
		while (it.hasNext())
		{
			final Killer col = it.next();
			if (col.isTerminated())
			{
				it.remove();
			} else
			{
				if (col.checkCollision(EBGame.escaper))
				{
					col.solveCollision(EBGame.escaper);
				}
			}
		}
	}

	public Tile getTileFromPos(final Vector2 position)
	{
		return tileMap[Math.round(position.x) / tileSize][Math.round(position.y) / tileSize];
	}

}
