package de.fatochs.ebs.maze;

import com.badlogic.gdx.graphics.g2d.Sprite;
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
	WALKABLE(EBGame.textureAtlas.findRegion("blub"))
	{
		
		@Override
		public void test()
		{
			// TODO Auto-generated method stub

		}
	},
	/**
	 * The Escaper dies when walking on here
	 */
	UNWALKABLE(EBGame.textureAtlas.findRegion("blub"))
	{
		@Override
		public void test()
		{
			// TODO Auto-generated method stub

		}
	},
	/**
	 * The escaper slides on here, but can control his momentum/rotation
	 */
	CONTROLLABLEICE(EBGame.textureAtlas.findRegion("blub"))
	{
		@Override
		public void test()
		{
			// TODO Auto-generated method stub

		}
	},
	/**
	 * The escaper slides on here and loses control until he enters another tile
	 */
	UNCONTROLLABLEICE(EBGame.textureAtlas.findRegion("blub"))
	{
		@Override
		public void test()
		{
			// TODO Auto-generated method stub

		}
	};
	TileInformation(TextureRegion region)
	{
		this.region = region;
	}
	public final TextureRegion region;
	public abstract void test();
}
