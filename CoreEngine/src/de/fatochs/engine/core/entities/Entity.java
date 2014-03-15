/**
 * 
 */
package de.fatochs.engine.core.entities;

import com.badlogic.gdx.math.Vector;

/**
 * @author pinkie.swirl@mailbox.org
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
