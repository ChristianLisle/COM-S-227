package ships;

import projectiles.Projectile;
import utils.Position;

/**
 * @author Christian Lisle This class represents a ShooterShip. This is an
 *         extension of the SpaceShip class.
 */
public class ShooterShip extends InvaderShip {
	/**
	 * Constructs a ShooterShip
	 * 
	 * @param p     The initial position
	 * @param armor The initial armor level
	 */
	public ShooterShip(Position p, int armor) {
		super(p, armor);
	}

	/**
	 * Fires a single projectile
	 * 
	 * @return An array containing a single projectile
	 */
	public Projectile[] fire() {
		if (!canFire()) {
			return null;
		}
		Projectile[] a = new Projectile[1];
		a[0] = new Projectile(pos, 0.0, -PROJECTILE_SPEED, -Projectile.GRAVITY);
		return a;
	}

	@Override
	public String imgPath() {
		return "res/monster.png";

	}

	@Override
	public int getPoints() {
		return 50;
	}
}
