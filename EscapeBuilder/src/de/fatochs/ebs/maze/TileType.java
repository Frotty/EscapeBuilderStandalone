package de.fatochs.ebs.maze;

/**
 * Type a Tile can have
 * 
 * @author Frotty
 */
public enum TileType
{
	WALKABLE()
	{
		@Override
		public void test()
		{
			// TODO Auto-generated method stub

		}
	},
	UNWALKABLE()
	{
		@Override
		public void test()
		{
			// TODO Auto-generated method stub

		}
	},
	ICE()
	{
		@Override
		public void test()
		{
			// TODO Auto-generated method stub

		}
	};

	public abstract void test();
}
