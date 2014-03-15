package de.fatochs.ebs.maze;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

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
	WALKABLE(EBGame.textureAtlas.findRegion("blub")),
	/**
	 * The Escaper dies when walking on here
	 */
	UNWALKABLE(EBGame.textureAtlas.findRegion("blub")),
	/**
	 * The escaper slides on here, but can control his momentum/rotation
	 */
	CONTROLLABLE_ICE(EBGame.textureAtlas.findRegion("blub")),
	/**
	 * The escaper slides on here and loses control until he enters another tile
	 */
	UNCONTROLLABLE_ICE(EBGame.textureAtlas.findRegion("blub"));
	TileInformation(final TextureRegion region)
	{
		this.region = region;
	}

	public final TextureRegion	region;
}
