package de.fatochs.ebs.maze;

import java.io.File;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Json;

/**
 * The "level" built from tiles and objects
 * @author Frotty
 *
 */
public class Maze 
{
	Tile[][] tileMap;
	int tileSize = 64;
	TileInformation startTile;
	
	public static Maze load(FileHandle fileHandle) 
	{
		Json json = new Json();
		return json.fromJson(Maze.class, fileHandle);
	}
	
	public void start()
	{
		
	}
	
	public void render(SpriteBatch batch) 
	{
		for(Tile[] ta : tileMap)
		{
			for(Tile tile : ta) 
			{
				tile.render(batch);
			}
		}
	}

	public Tile getTileFromPos(Vector2 position)
	{
		return tileMap[Math.round(position.x) / tileSize][ Math.round(position.y) / tileSize];
	}
	
}
