/**
 * 
 */
package de.fatochs.engine.core.entities;

import com.badlogic.gdx.math.Vector2;

/**
 * @author pinkie.swirl@mailbox.org
 */
public abstract class Entity2D implements Entity<Vector2>
{
	/**
	 * The 2D position vector.
	 */
	protected final Vector2	position	= new Vector2();
	/**
	 * The 2D velocity vector.
	 */
	protected final Vector2	velocity	= new Vector2();

	/**
	 * Creates an entity with a position and velocity of (0, 0).
	 */
	protected Entity2D()
	{
		// Do nothing, because position and velocity are both initialized with (0, 0).
	}

	/**
	 * Creates an entity with the given position and a velocity of (0, 0).
	 * <p>
	 * Note: there is no constructor for setting the velocity alone!
	 * 
	 * @param pos
	 *            the position
	 */
	protected Entity2D(final Vector2 pos)
	{
		position.add(pos);
	}

	/**
	 * Creates an entity with the given position and velocity.
	 * 
	 * @param pos
	 *            the position
	 * @param vel
	 *            the velocity
	 */
	protected Entity2D(final Vector2 pos, final Vector2 vel)
	{
		position.add(pos);
		velocity.add(vel);
	}

	/**
	 * Updates the entity and recomputes the position and velocity.
	 */
	@Override
	public void update()
	{
		// TODO implement the position and velocity update (?)

		addPos(velocity);
		velocity.scl(0.5f);
	}

	/*
	 * (non-Javadoc)
	 * @see de.fatochs.engine.core.entities.Entity#getPos()
	 */
	@Override
	public Vector2 getPos()
	{
		return position;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * de.fatochs.engine.core.entities.Entity#addPos(com.badlogic.gdx.math.Vector
	 * )
	 */
	@Override
	public Vector2 addPos(final Vector2 add)
	{
		return position.add(add);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * de.fatochs.engine.core.entities.Entity#setPos(com.badlogic.gdx.math.Vector
	 * )
	 */
	@Override
	public Vector2 setPos(final Vector2 pos)
	{
		return position.sub(position).add(pos);
	}
	
	@Override
	public void setX(final float x)
	{
		position.x = x;
	}
	
	@Override
	public void setY(final float y)
	{
		position.y = y;
	}

	/*
	 * (non-Javadoc)
	 * @see de.fatochs.engine.core.entities.Entity#getVel()
	 */
	@Override
	public Vector2 getVel()
	{
		return velocity;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * de.fatochs.engine.core.entities.Entity#addVel(com.badlogic.gdx.math.Vector
	 * )
	 */
	@Override
	public Vector2 addVel(final Vector2 add)
	{
		return velocity.add(velocity);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * de.fatochs.engine.core.entities.Entity#setVel(com.badlogic.gdx.math.Vector
	 * )
	 */
	@Override
	public Vector2 setVel(final Vector2 vel)
	{
		return velocity.sub(velocity).add(vel);
	}

}
