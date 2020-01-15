package ships;

import projectiles.Projectile;
import utils.Position;

/**
 * 
 * @author Christian Lisle This class represents a MultiShooterShip. This is an
 *         extension of the SpaceShip class.
 */
public class MultiShooterShip extends ShooterShip {
	public static final int NUM_CANNONS = 5;
	public static final double SPREAD = 0.25;

	/**
	 * Constructs a MultiShooterShip
	 * 
	 * @param p     The initial position
	 * @param armor The initial armor level
	 */
	public MultiShooterShip(Position p, int armor) {
		super(p, armor);
	}

	/**
	 * Fires NUM_CANNONS projectiles, that spread out as they fall
	 * 
	 * @return An array of projectiles
	 */
	public Projectile[] fire() {
		/*
		 * Hint, to get a spread, second parameter to Projectile() should be something
		 * like (i - (NUM_CANNONS / 2)) * SPREAD
		 */
		if (!canFire()) {
			return null;
		}

		Projectile[] a = new Projectile[NUM_CANNONS];
		for (int i = 0; i < a.length; i++) {
			double xSpeed = (i - (NUM_CANNONS / 2)) * SPREAD;
			a[i] = new Projectile(pos, xSpeed, -PROJECTILE_SPEED, -Projectile.GRAVITY);
		}
		return a;
	}

	@Override
	public String imgPath() {
		return "res/monster3.png";
	}
}
