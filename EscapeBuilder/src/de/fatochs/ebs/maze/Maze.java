package de.fatochs.ebs.maze;

import static de.fatochs.ebs.maze.TileInformation.PATH;

import java.lang.Character.UnicodeScript;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.JsonWriter.OutputType;

import de.fatochs.ebs.EBGame;
import de.fatochs.ebs.GameScreen;
import de.fatochs.ebs.units.Escaper;
import de.fatochs.ebs.units.Killer;

/**
 * The "level" built from tiles and objects
 * 
 * @author Frotty
 */
public class Maze extends TiledMap implements Json.Serializable
{
	private static final Json	json		= new Json();

	protected String			name		= "Default Name";

	public int					tileSize	= 32;
	Tile						startTile	= null;

	Escaper						escaper		= null;

	/**
	 * Objects that can collide with the Escaper
	 */
	LinkedList<Killer>			killers		= new LinkedList<Killer>();

	Maze()
	{
		// Empty default constructor.
	}

	public Maze(String name)
	{
		this.name = name;
		final MapLayers layers = getLayers();
		final Random	rand			= new Random();
		final TiledMapTileLayer layer = new TiledMapTileLayer(20, 20, tileSize, tileSize);

		for (int x = 0; x < layer.getWidth(); x++)
		{
			for (int y = 0; y < layer.getHeight(); y++)
			{
				System.out.println(rand.nextInt(2));
				System.out.println(rand.nextInt(2));
				System.out.println(rand.nextInt(2));
				System.out.println(rand.nextInt(2));
				System.out.println(rand.nextInt(2));
				System.out.println(rand.nextInt(2));
				System.out.println(rand.nextInt(2));
				System.out.println(rand.nextInt(2));
				switch (rand.nextInt(2))
				{
				case 0:
					final Cell cell = new Cell();
					cell.setTile(new Tile(PATH));
					layer.setCell(x, y, cell);
					break;
				case 1:
					final Cell cell2 = new Cell();
					cell2.setTile(new Tile(TileInformation.VOID));
					layer.setCell(x, y, cell2);
					break;
				default:
					throw new GdxRuntimeException("Invalid Random Value");
				}
				
			}
		}
		
		for (int x = 0; x < layer.getWidth(); x++)
		{
			for (int y = 0; y < layer.getHeight(); y++)
			{
				Cell c = layer.getCell(x, y);
				Tile t = (Tile) c.getTile();
				t.findCorrectTile(x<layer.getWidth()-1 ? ((Tile) layer.getCell(x+1, y).getTile()) : null
						, y>0 ? ((Tile) layer.getCell(x, y-1).getTile()) : null
						, x>0 ? ((Tile) layer.getCell(x-1, y).getTile()) : null
						, y<layer.getHeight()-1 ? ((Tile) layer.getCell(x, y+1).getTile()) : null);
				c.setTile(t);
				layer.setCell(x, y, c);
				
			}
		}
		layers.add(layer);
		name = "testName";

	}

	public void save()
	{
		//		long time = System.currentTimeMillis();
		//		json.setOutputType(OutputType.minimal);
		//		final String jsonString = json.toJson(this, this.getClass());
		//		System.out.println(System.currentTimeMillis() - time);

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

		//		time = System.currentTimeMillis();

		//		ByteArrayInputStream in = new ByteArrayInputStream(new byte[100]);
		//		GZIPInputStream gIn = new GZIPInputStream(in);
		//		gIn.
		//		final Maze testttt = json.fromJson(Maze.class, jsonString);
		//		System.out.println(System.currentTimeMillis() - time);
		//		System.out.println(testttt.name);
	}

	public void start()
	{

	}

	public void update()
	{
		assert escaper != null : "Set the escaper before updating the maze!";

		final Iterator<Killer> it = killers.iterator();
		while (it.hasNext())
		{
			final Killer killer = it.next();
			if (killer.isTerminated())
			{
				it.remove(); // FIXME - This will fail!
			} else
			{
				if (killer.checkCollision(escaper))
				{
					killer.solveCollision(escaper);
				}
			}
		}
	}

	public void setEscaper(Escaper escaper)
	{
		this.escaper = escaper;
	}

	public Tile getTileFromPos(final Vector2 position)
	{
		Cell cell = ((TiledMapTileLayer) getLayers().get(0))
				.getCell((int) (Math.round(position.x) / tileSize), (int) (Math.round(position.y) / tileSize));
		if (cell != null)
		{
			return (Tile) cell.getTile();
		}
		return null;
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
