package module3;

public class FallingParticle {

	// Setting variables
	private final double m;
	private final double d;
	private double t;
	private double z;
	private double h;
	private double v;
	private static final double g = -9.81;

	// Creating constructor for the particle, setting the drag coefficient and the
	// mass of the particle
	public FallingParticle(double m, double d) throws Exception { // with an exception so the mass is always positive (a
																	// physical particle

		this.m = m;
		this.d = d;
		if (m < 0.0) { // sets unphysical condition
			throw new Exception("Fail to construct particle, input a positive mass"); // error statement for an
																						// unphysical particle
		}
		t = 0; // initialising the time for a particle (this could be done outside for the
				// constructor if there were multiple particles for instance
	}

	public void setH(double h) throws Exception { // creating the setter which initialises h, note that a void has no
													// return, with an exception so the drop height is always positive,
													// and accounts for any possible negative h, which would set a
													// negative z and hence be unphysical
		this.h = h;
		if (h < 0.0) { // sets unphysical condition
			throw new Exception("fail to set height, input a height greater than 0!"); // output for unphysical scenario
		}
		this.z = h;
	}

	public double getV() { // creating the getter which returns the current velocity
		return v;
	}

	public void setV(double v) { // creating the setter which sets the initial velocity, there is no exception as
									// a negative velocity could indicate the particle was thrown upwards initially
		this.v = v;
	}

	public double getT() { // creating the getter which returns the current time
		return t;
	}

	public double getZ() { // creating the getter which returns the current vertical position of the
							// falling ball
		return z;
	}

	public double doTimeStep(double deltaT) throws Exception { // creates the doTimeStep method which has the timestep
																// as the argument
		if (z > h) {
			throw new Exception("Error, the particle is falling upwards");
		}
		t += deltaT; // sets the current time by increasing the time by a set interval (the argument)
		double a = ((d * v * v / m) - g); // calculates the current acceleration with the given equation
		double deltaV = a * t; // calculates the change in velocity
		v = v + deltaV; // sets the current velocity by adding the previous velocity to the change in
						// velocity
		double deltaZ = v * t; // calculates the change in vertical position
		z = z - deltaZ; // sets the current vertical position by adding the previous vertical position
						// to the change in vertical position

		if (z < 0) { // creates an 'if' condition why adds realistic parameters (means the ball
						// doesn't travel through the floor! Also, lets us know that when the ball hits
						// the floor, it has stopped
			z = 0;
			v = 0;
		}
		return a;
	}

	public void drop(double deltaT) throws Exception { // effectively runs the 'doTimeStep' method, outputting the
														// current vertical position, the speed and the number of loops
		int runAmount = 0; // initialises the loop counter
		while (z > 0) { // Sets the condition for the loop
			doTimeStep(deltaT);
			System.out.println("we are now at : " + z + "m above the ground, going at " + v
					+ " m/s, the loop counter is: " + runAmount + " and " + t + " s has passed");
			runAmount++; // increases the loop counter by 1
		}
	}

}
