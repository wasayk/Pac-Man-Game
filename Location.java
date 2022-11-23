/*
 * This class represents the Location 
 * @author Abdul-Wasay Khan.
 */
public class Location {
	   /*
	    * This is the initial class so we will be
	    * initializing the member variables here
	    */	
	private int x;
	private int y;
	
	   /*
	    * Constructor Location
	    * @param x x coordinate of the Location
	    * @param y y coordinate of the Location
	    */
	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	   /*
	    * Get x of the Location
	    * @return x of the Location
	    */
	public int getx() {
		return this.x;
	}
	
	   /*
	    * Get y of the Location
	    * @return y of the Location
	    */
	public int gety() {
		return this.y;
	}
	
	   /*
	    * compares this x and y to p's x and y
	    * @return 1, 0 or -1 based on how they compare
	    */
	public int compareTo(Location p) {
		int value = 3;
		//value 1 constitutes if this y is greater than p's y OR if this y and p's y are equal and this x is greater than p's x
		if (this.gety() > p.gety() || (this.gety() == p.gety() && this.getx() > p.getx())) {
			value = 1;
		//value -1 constitutes if this y is less than p's y OR if this y and p's y are equal and this x is less than p's x
		} else if (this.gety() < p.gety() || (this.gety() == p.gety() && this.getx() < p.getx())) {
			value = -1;
		//value 0 constitutes if this y is equal to p's y  and this x is equal to p's x
		} else if (this.getx() == p.getx() && this.gety() == p.gety()){
			value = 0;
		}
		// we return the value
		return value;
		
	}
}










