package de.fatochs.ebs.maze;

import static de.fatochs.ebs.maze.TileInformation.WALKABLE;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipOutputStream;

import org.xerial.snappy.Snappy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonWriter.OutputType;
import com.sun.nio.zipfs.ZipInfo;

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

	protected String			name;

	protected Texture			texture;

	public int					tileSize	= 32;
	Tile						startTile;

	/**
	 * Objects that can collide with the Escaper
	 */
	LinkedList<Killer>			killers		= new LinkedList<Killer>();

	public Maze()
	{
		final MapLayers layers = getLayers();

		final TiledMapTileLayer layer = new TiledMapTileLayer(200, 200, tileSize, tileSize);

		for (int x = 0; x < 200; x++)
		{
			for (int y = 0; y < 200; y++)
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
		String jsonString = json.toJson(this, this.getClass());
		

		ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
		OutputStream fileOut = Gdx.files.local(name + ".map").write(false);
		try
		{
			MazeZipOut mazeOut = new MazeZipOut(byteArrayOut);

			mazeOut.write(jsonString.getBytes(Charset.forName("UTF-8")));

			mazeOut.close();

			mazeOut = new MazeZipOut(fileOut);

			mazeOut.write(byteArrayOut.toByteArray());

			mazeOut.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		System.out.println((System.currentTimeMillis() - time));
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
