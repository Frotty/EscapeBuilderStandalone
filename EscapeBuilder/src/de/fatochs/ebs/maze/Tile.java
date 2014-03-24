package de.fatochs.ebs.maze;

import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;

public class Tile extends StaticTiledMapTile
{
	public TileInformation	info;

	public Tile()
	{
		super(TileInformation.WALKABLE.tileSet.getMid());
	}
	
	public Tile(final TileInformation info)
	{
		super(info.tileSet.getMid());

		this.info = info;
	}
}
