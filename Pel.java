/*
 * This class represents the Location 
 * @author Abdul-Wasay Khan.
 */
public class Pel {
	   /*
	    * This is the initial class so we will be
	    * initializing the member variables here
	    */	
	private int color;
	private Location p;
	
	   /*
	    * Constructor Location
	    * @param p Location Object of the Pel
	    * @param color color of the Pel
	    */
	public Pel(Location p, int color) {
		this.p = p;
		this.color = color;
	}
	
	   /*
	    * Get Locus of the Pel
	    * @return Location object of the Pel
	    */
	public Location getLocus() {
		return this.p;
	}
	   /*
	    * Get color of the Pel
	    * @return color of the Pel
	    */
	public int getColor() {
		return this.color;
	}

}
