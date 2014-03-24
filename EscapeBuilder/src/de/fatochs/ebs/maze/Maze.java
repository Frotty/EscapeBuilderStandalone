package de.fatochs.ebs.maze;

import static de.fatochs.ebs.maze.TileInformation.WALKABLE;

import java.util.Iterator;
import java.util.LinkedList;

import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.JsonWriter.OutputType;

import de.fatochs.ebs.EBGame;
import de.fatochs.ebs.units.Killer;

/**
 * The "level" built from tiles and objects
 * 
 * @author Frotty
 */
public class Maze extends TiledMap implements Json.Serializable
{
	private static final Json	json		= new Json();

	protected String			name;

	public int					tileSize	= 32;
	Tile						startTile;

	/**
	 * Objects that can collide with the Escaper
	 */
	LinkedList<Killer>			killers		= new LinkedList<Killer>();

	Maze()
	{
		System.out.println("Called from json??!!");
	}

	public Maze(String name)
	{
		this.name = name;
		final MapLayers layers = getLayers();

		final TiledMapTileLayer layer = new TiledMapTileLayer(5, 5, tileSize, tileSize);

		for (int x = 0; x < 5; x++)
		{
			for (int y = 0; y < 5; y++)
			{
				final Cell cell = new Cell();
				cell.setTile(new Tile(WALKABLE));
				layer.setCell(x, y, cell);
			}
		}

		name = "testName";

		layers.add(layer);
	}

	public void save()
	{
		long time = System.currentTimeMillis();
		json.setOutputType(OutputType.minimal);
		final String jsonString = json.toJson(this, this.getClass());
		System.out.println(System.currentTimeMillis() - time);

		//		ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
		//		OutputStream fileOut = Gdx.files.local(name + ".map").write(false);
		//		try
		//		{
		//			MazeZipOut mazeOut = new MazeZipOut(byteArrayOut);
		//
		//			mazeOut.write(jsonString.getBytes(Charset.forName("UTF-8")));
		//
		//			mazeOut.close();
		//
		//			mazeOut = new MazeZipOut(fileOut);
		//
		//			mazeOut.write(byteArrayOut.toByteArray());
		//
		//			mazeOut.close();
		//		} catch (IOException e)
		//		{
		//			e.printStackTrace();
		//		}

		time = System.currentTimeMillis();

		//		ByteArrayInputStream in = new ByteArrayInputStream(new byte[100]);
		//		GZIPInputStream gIn = new GZIPInputStream(in);
		//		gIn.
		final Maze testttt = json.fromJson(Maze.class, jsonString);
		System.out.println(System.currentTimeMillis() - time);
		System.out.println(testttt.name);
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

	@Override
	public void write(Json json)
	{
		json.writeValue("name", name);
		json.writeValue("tileSize", tileSize);
		final TiledMapTileLayer layer = (TiledMapTileLayer) getLayers().get(0);
		json.writeValue("layerWidth", layer.getWidth());
		json.writeValue("layerHeight", layer.getHeight());
		for (int x = 0; x < layer.getWidth(); x++)
		{
			for (int y = 0; y < layer.getHeight(); y++)
			{
				json.writeValue("cell " + x + " " + y, layer.getCell(x, y));
			}
		}
	}

	@Override
	public void read(Json json, JsonValue jsonData)
	{
		name = jsonData.getString(0);
		tileSize = jsonData.getInt(1);
		final TiledMapTileLayer layer = new TiledMapTileLayer(jsonData.getInt(2), jsonData.getInt(3), tileSize, tileSize);
		for (int x = 0; x < layer.getWidth(); x++)
		{
			for (int y = 0; y < layer.getHeight(); y++)
			{
				layer.setCell(x, y, json.fromJson(Cell.class, jsonData.get("cell " + x + " " + y).toString()));
			}
		}
		getLayers().add(layer);

	}
	
}
