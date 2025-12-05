package exam.codewriting.q4;

/*
 * We wish to create a Car class. A Car has-a(n):
 * 
 * Odometer, which tracks how many miles the car has been driven.
 * Fuel efficiency, typically given as miles-per-gallon.
 * Fuel tank, which can hold some amount of fuel, in gallons.
 * Current amount of fuel.
 */

public class Car {

	// Declare your instance variables here:
	private double odometer;
	private double mpg;
	private double fuelTank;
	private double currentFuel;

	// Write the constructor for the Car class:
	// (For full credit the constructor should use only two parameters)
	public Car(double mpg, double fuelTank){
		this.odometer = 0;
		this.mpg = mpg;
		this.fuelTank = fuelTank;
		this.currentFuel = fuelTank;
	}
	
	/**
	* Drives the car at the given speed for the given amount of time or until out of fuel.
	* (Hint: Carefully consider the impact of driving to all instance variables).
	*/
	public void drive ( double milesPerHour , double hours ) {
		if (milesPerHour <= 0 || hours <= 0 || mpg <= 0 || currentFuel <= 0){
			return;
		}
    	double desiredDistance = milesPerHour * hours;
		double maxDistance = currentFuel * mpg;
		double actualDistance = Math.min(desiredDistance, maxDistance);

		double fuelUsed = actualDistance / mpg;
		odometer += actualDistance;
		currentFuel -= fuelUsed;

		if (currentFuel < 1e-12){
			currentFuel = 0;    // avoid tiny negative values due to rounding
		}
	}
	
	public double getMilesDriven () {
		return this.odometer; //FIXME
	}
	
	/**
	* Adds fuel to the tank as long as it does not exceed the tank�s capacity.
	* @return portion of fuel that couldn�t be added
	*/
	public double addFuel ( double gallons ) {
		if (gallons <= 0) return 0;
    		double space = fuelTank - currentFuel;
    	if (gallons > space) {
        	currentFuel = fuelTank;
        	return gallons - space; // overflow
    	} else {
        	currentFuel += gallons;
        return 0;
    }
	
}
}
