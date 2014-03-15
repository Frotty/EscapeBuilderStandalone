/**
 * 
 */
package de.fatochs.engine.core.entities;

import com.badlogic.gdx.math.Vector2;

/**
 * @author pinkie.swirl@mailbox.org
 *
 */
public abstract class Entity2D implements Entity {

	/**
	 * The 2D position vector.
	 */
	public Vector2 position;
	/**
	 * The 2D velocity vector.
	 */
	public Vector2 velocity;

	/**
	 * 
	 */
	public Entity2D() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see de.fatochs.engine.core.entities.Entity#update()
	 */
	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

}
