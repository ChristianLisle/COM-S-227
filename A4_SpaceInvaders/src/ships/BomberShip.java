package ships;

import projectiles.Bomb;
import projectiles.Projectile;
import utils.Position;

/**
 * @author Christian Lisle This class represents a BomberShip. This is an
 *         extension of the SpaceShip class.
 */
public class BomberShip extends InvaderShip {
	public static final double EXPLOSION_RADIUS = 10;

	/**
	 * Constructs a BomberShip
	 * 
	 * @param p     The initial position
	 * @param armor The initial armor level
	 */
	public BomberShip(Position p, int armor) {
		super(p, armor);
	}

	/**
	 * Drops a single bomb
	 * 
	 * @return An array containing a single bomb
	 */
	public Projectile[] fire() {
		if (!canFire()) {
			return null;
		}
		Projectile[] a = new Projectile[1];
		a[0] = new Bomb(pos, 0.0, -PROJECTILE_SPEED, -Projectile.GRAVITY, EXPLOSION_RADIUS);
		return a;
	}

	@Override
	public String imgPath() {
		return "res/monster2.png";
	}

	@Override
	public int getPoints() {
		return 100;
	}
}
