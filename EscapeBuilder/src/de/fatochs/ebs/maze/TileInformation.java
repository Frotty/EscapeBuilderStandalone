package de.fatochs.ebs.maze;

import de.fatochs.ebs.EBGame;

/**
 * Type a Tile can have
 * 
 * @author Frotty
 */
public enum TileInformation
{
	/**
	 * The Escaper can walk normally on here
	 */
	WALKABLE(new TileSet(EBGame.textureAtlas.findRegion("TilePath")));
	// /**
	// * The Escaper dies when walking on here
	// */
	// UNWALKABLE(new TileSet(EBGame.textureAtlas.findRegion("Unwalkable"))),
	// /**
	// * The escaper slides on here, but can control his momentum/rotation
	// */
	// CONTROLLABLE_ICE(new TileSet(EBGame.textureAtlas.findRegion("Ice"))),
	// /**
	// * The escaper slides on here and loses control until he enters another
	// tile
	// */
	// UNCONTROLLABLE_ICE(new TileSet(EBGame.textureAtlas.findRegion("Ice")));

	TileInformation(final TileSet tileSet)
	{
		this.tileSet = tileSet;
	}

	public final TileSet	tileSet;
}
