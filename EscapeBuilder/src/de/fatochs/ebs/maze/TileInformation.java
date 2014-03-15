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
	
	WALKABLE(EBGame.textureAtlas.findRegion("blub"))
	{
		
		@Override
		public void test()
		{
			// TODO Auto-generated method stub

		}
	},
	UNWALKABLE(EBGame.textureAtlas.findRegion("blub"))
	{
		@Override
		public void test()
		{
			// TODO Auto-generated method stub

		}
	},
	ICE(EBGame.textureAtlas.findRegion("blub"))
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
