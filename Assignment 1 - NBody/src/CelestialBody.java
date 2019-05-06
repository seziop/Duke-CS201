

/**
 * Celestial Body class for NBody
 * Shivansh Mehta
 * sm682
 */

public class CelestialBody {

	private double myXPos;
	private double myYPos;
	private double myXVel;
	private double myYVel;
	private double myMass;
	private String myFileName;
	private double gravitationalConstant = 6.67e-11;

	/**
	 * Create a Body from parameters	
	 * @param xp initial x position
	 * @param yp initial y position
	 * @param xv initial x velocity
	 * @param yv initial y velocity
	 * @param mass of object
	 * @param filename of image for object animation
	 */

	public CelestialBody(double xp, double yp, double xv,
			             double yv, double mass, String filename){

		myXPos = xp;
		myYPos = yp;
		myXVel = xv;
		myYVel = yv;
		myMass = mass;
		myFileName = filename;
	}

	/**
	 * Copy constructor: copy instance variables from one
	 * body to this body
	 * @param b used to initialize this body
	 */

	public CelestialBody(CelestialBody b){

		myXPos = b.getX();
		myYPos = b.getY();
		myXVel = b.getXVel();
		myYVel = b.getYVel();
		myMass = b.getMass();
		myFileName = b.getName();
	}

	/**
	 * returns the initialized myXPos (position in x-axis) var when CelestialBody.getX() is called
	 * @return value of x-position.
	 */
	public double getX() {
		// TODO: complete method
		return myXPos;
	}
	/**
	 * returns the initialized myYPos (position in y-axis) var when CelestialBody.getY() is called
	 * @return value of y-position.
	 */
	public double getY() {
		// TODO: complete method
		return myYPos;
	}
	/**
	 * returns the initialized myXVel var when CelestialBody.getXVel() is called
	 * @return value of x-velocity.
	 */
	public double getXVel() {
		// TODO: complete method
		return myXVel;
	}
	/**
	 * Return y-velocity of this Body.
	 * @return value of y-velocity.
	 */
	public double getYVel() {
		// TODO: complete method
		return myYVel;
	}
	/**
	 * returns the initialized myMass var when CelestialBody.getMass() is called
	 * @return value of mass.
	 */
	public double getMass() {
		// TODO: complete method
		return myMass;
	}
	/**
	 * returns the initialized myFileName var when CelestialBody.getName() is called
	 * @return name of the file with image of the object.
	 */
	public String getName() {
		// TODO: complete method
		return myFileName;
	}

	/**
	 * Return the distance between this body and another
	 * @param b the other body to which distance is calculated
	 * @return distance between this body and b
	 */

	public double calcDistance(CelestialBody b) {
		// TODO: complete method
		return Math.sqrt(Math.pow(myXPos - b.getX(),2)+Math.pow(myYPos - b.getY(),2));
	}

	/**
	 * Return the force exerted on a body by another
	 * @param p the other body that is exerting the force
	 * @return force exerted on a body by another body
	 */
	public double calcForceExertedBy(CelestialBody p) {
		// TODO: complete method
		return gravitationalConstant * ((myMass * p.getMass())/(Math.pow(calcDistance(p),2)));
	}

	/**
	 * Return the x-axis force exerted on a body by another
	 * @param p the other body that is exerting the force
	 * @return x-axis force exerted on a body by another body
	 */
	public double calcForceExertedByX(CelestialBody p) {
		// TODO: complete method
		return calcForceExertedBy(p) * ((p.getX() - myXPos) /calcDistance(p));
	}
	/**
	 * Return the y-axis force exerted on a body by another
	 * @param p the other body that is exerting the force
	 * @return y-axis force exerted on a body by another body
	 */
	public double calcForceExertedByY(CelestialBody p) {
		// TODO: complete method
		return calcForceExertedBy(p) * ((p.getY() - myYPos) /calcDistance(p));
	}

	/**
	 * calculates the total x-axis force exerted on a body by an array of celestial bodies
	 * @param bodies the array of force exerting bodies
	 * @return Net x-axis force felt by the body
	 */
	public double calcNetForceExertedByX(CelestialBody[] bodies) {
		// TODO: complete method
		double ret = 0;
		for (CelestialBody b : bodies) {
			if (! b.equals(this)) {
				ret += calcForceExertedByX(b);
			}
		}
		return ret;
	}

	/**
	 * calculates the total y-axis force exerted on a body by an array of celestial bodies
	 * @param bodies the array of force exerting bodies
	 * @return Net y-axis force felt by the body
	 */
	public double calcNetForceExertedByY(CelestialBody[] bodies) {
		// TODO: complete method
		double ret = 0;
		for (CelestialBody b : bodies) {
			if (! b.equals(this)) {
				ret += calcForceExertedByY(b);
			}
		}
		return ret;
	}

	/**
	 * updates myXVel,myYVel,myXPos and myYPos based on deltaT
	 * @param deltaT small time steps
	 * @param xforce net x-axis force exerted on the body
	 * @param yforce net y-axis force exerted on the body
	 */
	public void update(double deltaT, 
			           double xforce, double yforce) {
		// TODO: complete method
		double xAccel = xforce/myMass;
		double yAccel = yforce/myMass;
		double nvx = myXVel + deltaT * xAccel;
		double nvy = myYVel + deltaT * yAccel;
		double nx = myXPos + deltaT * nvx;
		double ny = myYPos + deltaT * nvy;
		myXVel = nvx;
		myYVel = nvy;
		myXPos = nx;
		myYPos = ny;
	}

	/**
	 * StdDraw provides basic graphics capabilities. This method helps present the output animation
	 */
	public void draw() {
		// TODO: complete method
		StdDraw.picture(myXPos, myYPos, "images/"+myFileName);
	}
}
