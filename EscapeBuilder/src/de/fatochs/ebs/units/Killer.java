package de.fatochs.ebs.units;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

import de.fatochs.engine.core.entities.SpriteEntity;

public abstract class Killer extends SpriteEntity
{
	
	public Killer(final Sprite sprite, final Vector2 pos)
	{
		super(sprite, pos);
		// TODO Auto-generated constructor stub
	}

	boolean	terminated	= false;

	/**
	 * What to do when the Escaper collides. Standard is killing.
	 * 
	 * @param col2
	 */
	public void solveCollision(final Escaper escaper)
	{
		escaper.kill();
	}

	/**
	 * Needed for LinkedList removal
	 * 
	 * @return
	 */
	public boolean isTerminated()
	{
		return terminated;
	}

	/**
	 * Checks if the Killer collides with the escaper
	 * 
	 * @return Whether or not a collision is happening
	 */
	public abstract boolean checkCollision(Escaper escaper);

}
