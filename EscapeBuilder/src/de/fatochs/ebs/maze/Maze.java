package de.fatochs.ebs.maze;

import static de.fatochs.ebs.maze.TileInformation.WALKABLE;

import java.util.Iterator;
import java.util.LinkedList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Json;

import de.fatochs.ebs.EBGame;
import de.fatochs.ebs.units.Killer;

/**
 * The "level" built from tiles and objects
 * 
 * @author Frotty
 */
public class Maze extends TiledMap
{
	private static final Json	json		= new Json();

	protected Texture			texture;

	public int					tileSize	= 32;
	Tile						startTile;
	
	public String name;
	
	/**
	 * Objects that can collide with the Escaper
	 */
	LinkedList<Killer>			killers		= new LinkedList<Killer>();

	public Maze(String name)
	{
		this.name = name;
		final MapLayers layers = getLayers();

		final TiledMapTileLayer layer = new TiledMapTileLayer(7, 3, tileSize, tileSize);

		for (int x = 0; x < 7; x++)
		{
			for (int y = 0; y < 3; y++)
			{
				final Cell cell = new Cell();
				cell.setTile(new Tile(WALKABLE));
				layer.setCell(x, y, cell);
			}
		}

		layers.add(layer);
	}

	public String save(final boolean prettyPrint)
	{
		String result = "";

		if (prettyPrint)
		{
			result = json.toJson(this, Maze.class);
		} else
		{
			result = json.prettyPrint(this);
		}

		return result;
	}

	public void start()
	{

	}

	public void update()
	{
		final Iterator<Killer> it = killers.iterator();
		while (it.hasNext())
		{
			final Killer col = it.next();
			if (col.isTerminated())
			{
				it.remove(); // FIXME - This will fail!
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
		return (Tile) ((TiledMapTileLayer) getLayers().get(0))
				.getCell((int) Math.rint(position.x) / tileSize, (int) Math.rint(position.y) / tileSize)
				.getTile();
	}

}
