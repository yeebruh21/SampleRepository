/**
* Name: Anthony
* Date: March 6, 2022
* Description: Creates CelestialBody superclass that defines all atributes of a celestial body 
* as variables. Also defines accessors/mutators that users can use to get/change certain variables.
*/

public class CelestialBody {
   /** identifier for celestial body */
   protected String name;
   
   /** average temperature on celestial body in celsius */
   protected double averageTemp;
   
   /** colour of moon */
   protected String colour;
   
   /** approximate mass of moon in kg*/
   protected double mass;
   
   /** diameter of planet in km */
   protected double diameter;
      
   /** orbital period of moon in days */
   protected double orbitalPeriod;
   
   /** number of rovers on moon */
   protected int roverNum;
   
   /**
   Default constructor
   */
   public CelestialBody() {
      this.name = "";
      this.averageTemp = 0;
      this.colour = "";
      this.diameter = 1;
      this.orbitalPeriod = 1;
      this.roverNum = 0;
   }
   
   /**
   Create a celestial body with listed attributes
   @param averageTemp average temperature on the planet
   @param colour colour of planet
   @param mass mass of planet
   @param diameter horizontal diameter of planet in km
   @param orbitalPeriod orbital period of planet
   @param roverNum number of rovers on planet
   */
   
   public CelestialBody(String name, double averageTemp, String colour, double mass, double diameter, double orbitalPeriod, int roverNum) {
      this.name = name;
      this.colour = colour;
      
      // Restricting user access to average temperature
      if (averageTemp < -273.15) {
         this.averageTemp = -273.15;
      }
      else {
         this.averageTemp = averageTemp;
      }
      
      // Restricting user access to mass
      if (mass <= 0) {
         this.mass = 1;
      }
      else {
         this.mass = mass;
      }
      
      // Restricting user access to diameter
      if (diameter <= 0) {
         this.diameter = 1;
      }
      else {
         this.diameter = diameter;
      }
      
      // Restricting user access to orbital period
      if (orbitalPeriod <= 0) {
         this.orbitalPeriod = 1;
      }
      else {
         this.orbitalPeriod = orbitalPeriod;
      }
      
      // Restricting user access to number of rovers
      if (roverNum < 0) {
         this.roverNum = 0;
      }
      else {
         this.roverNum = roverNum;
      }
   }
   
   /*
   Accessors
   */
   
   /*
   Gets the average temperature
   @return the average temperature on moon in celsius
   */
   public double getAverageTemp() {
      return this.averageTemp;
   }
   
   /*
   Gets the colour of moon
   @return the colour of the moon
   */
   public String getColour() {
      return this.colour;
   }
   
   /*
   Gets the mass of moon
   @return the mass of the moon
   */
   public double getMass() {
      return this.mass;
   }
   
   /*
   Gets the diameter of moon
   @return the diameter of the moon
   */
   public double getDiameter() {
      return this.diameter;
   }
   
   /*
   Gets the orbital period of moon
   @return the orbital period of the moon
   */
   public double getOrbitalPeriod() {
      return this.orbitalPeriod;
   }
   
   /*
   Gets the number of rovers on moon
   @return the number of rovers on the moon
   */
   public int getRoverNum() {
      return this.roverNum;
   }
   
   /**
   Returns all of the attributes of the celestial body in a string
   @return all attributes of instance
   */
   public String toString() {
      return ("Name: " + this.name + "\nColour: " + this.colour + "\nMass: " + this.mass + " kg\nDiameter: " + this.diameter + " km\nOrbital Period: " + this.orbitalPeriod + " days\nRover number: " + this.roverNum + "\n");
   }
   
   /*
   Mutators
   */
   
   /** 
   The celestial body travels a certain distance
   @param speed speed of celestial body in direction of travel in km/h
   @param time amount of time it travels in hours
   @return amount of distance celestial body travels in km
   */
   public double travel(double speed, double time) {
      // Restricting values for speed to positive and below lightspeed
      if (speed < 0) {
         speed = Math.abs(speed);
      }
      else if (speed > 1079000000) {
         speed = 1079000000;
      }
      
      // Restricting time value to positive
      if (time < 0) {
         time = 1;
      }
      
      // Apply d=vt formula
      return speed*time;
   }
   
   /** 
   The celestial body collides with another celestial body
   @param speed speed of named celestial body
   @param otherMass mass of other celestial body
   @param otherSpeed speed of other celestial body
   @return final speed of object after collision
   */
   public double collide (double speed, double otherMass, double otherSpeed) {
      // Restricting values for speed to positive and below lightspeed
      if (speed > 1079000000) {
         speed = 1079000000;
      }
      
      // Restricting values for speed of other celestial body in similar fashion
      if (otherSpeed > 1079000000) {
         speed = 1079000000;
      }
   
      // Restricting values to mass of other celestial body to positive
      if (otherMass < 0) {
         otherMass = 1;
      }
      
      // Calculating final momentum of object in inelastic collision
      return (this.mass + otherMass) / (this.mass*speed + otherMass*otherSpeed);
   }
}