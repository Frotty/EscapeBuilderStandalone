/**
 * 
 */
package de.fatochs.engine.core.entities;

import com.badlogic.gdx.math.Vector;

/**
 * An {@code Entity} is the basic game object.
 * <p>
 * The {@code Entity} interface provides a method {@code update} for updating
 * the entity.
 * <p>
 * The {@code Entity} interface provides the methods {@code getPos},
 * {@code addPos}, {@code setPos}, {@code getVel}, {@code addVel} and
 * {@code setVel} for position and velocity manipulation. These methods always
 * return the update position/velocity.
 * 
 * @param <VECTOR>
 *            the {@link com.badlogic.gdx.math.Vector Vector} implementation for
 *            the position and velocity
 * @author pinkie.swirl@mailbox.org
 * @see {@link com.badlogic.gdx.math.Vector2 Vector2} (a {@code Vector})
 * @see {@link com.badlogic.gdx.math.Vector3 Vector3} (a {@code Vector})
 */
public interface Entity<VECTOR extends Vector<? extends Vector<?>>>
{

	/**
	 * Updates the entity.
	 */
	public void update();

	/**
	 * Returns the current position of the entity.
	 * 
	 * @return the current position of the entity
	 */
	public VECTOR getPos();

	/**
	 * Returns the position of the entity after adding it.
	 * 
	 * @return the position of the entity after adding it
	 */
	public VECTOR addPos(VECTOR add);

	/**
	 * Returns the position of the entity after setting it.
	 * 
	 * @return the position of the entity after setting it
	 */
	public VECTOR setPos(VECTOR pos);

	/**
	 * Returns the current velocity of the entity.
	 * 
	 * @return the current velocity of the entity
	 */
	public VECTOR getVel();

	/**
	 * Returns the velocity of the entity after adding it.
	 * 
	 * @return the velocity of the entity after adding it
	 */
	public VECTOR addVel(VECTOR add);

	/**
	 * Returns the velocity of the entity after setting it.
	 * 
	 * @return the velocity of the entity after setting it
	 */
	public VECTOR setVel(VECTOR vel);
}
