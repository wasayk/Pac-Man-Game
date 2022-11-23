/*
 * This class represents the MyObject and it implements MyObjectADT
 * @author Abdul-Wasay Khan.
 */
public class MyObject implements MyObjectADT {
	   /*
	    * This is the initial class so we will be
	    * initializing the member variables here
	    */	
	int id;
	int width;
	int height;
	String type;
	Location pos;
	BinarySearchTree tree; //creating a tree of type BinarySearchTree
	
	   /*
	    * Constructor MyObject sets id, width, height, pos and type to specified values and initializes the tree
	    * @param id int containing the id
	    * @param width int containing the width
	    * @param height int containing the height
	    * @param type string that contains the type
	    * @param pos Location object
	    */
	public MyObject (int id, int width, int height, String type, Location pos) {
		this.id = id;
		this.width = width;
		this.height = height;
		this.type = type;
		this.pos = pos;
		this.tree = new BinarySearchTree();
	}
	   /*
	    * Get width of MyObject
	    * @return width of MyObject
	    */
	public int getWidth() {
		return width;
	}

	   /*
	    * Get height of MyObject
	    * @return height of MyObject
	    */
	public int getHeight() {
		return height;
	}

	   /*
	    * Get type of MyObject
	    * @return type of MyObject
	    */
	public String getType() {
		return type;
	}

	   /*
	    * Get id of MyObject
	    * @return id of MyObject
	    */
	public int getId() {
		return id;
	}

	   /*
	    * Get Locus of MyObject
	    * @return pos of MyObject
	    */
	public Location getLocus() {
		return pos;
	}

	   /*
	    * Set locus of MyObject
	    * assign pos to the given value
	    */
	public void setLocus(Location value) {
		pos = value;
		
	}

	   /*
	    * set type of MyObject
	    * set type to the given type
	    */
	public void setType(String type) {
		this.type = type;
		
	}

	   /*
	    * add Pel to the tree with pix as the Data
	    * throws Exception if given Pel already exists in tree
	    */
	public void addPel(Pel pix) throws DuplicatedKeyException {
		tree.put(tree.getRoot(),pix);
		
	}

	   /*
	    * checks intersections of this object and otherObject
	    * @return true if this object intersects otherObject
	    * @return false otherwise
	    */
	public boolean intersects(MyObject otherObject) {
		// we create a pel object
		Pel p = null;
		//then set it to the tree's smallest with the tree's root as parameters
		try {
			p = tree.smallest(tree.getRoot());
		} catch (EmptyTreeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//we make it so that while p is not null
		while (p != null) {
			// x prime is equal to the x of p's locus + the x of this Object's locus - the x of the other objects locus
			int xPrime = (p.getLocus().getx() + this.getLocus().getx() - otherObject.getLocus().getx());
			// y prime is equal to the y of p's locus + the y of this Object's locus - the y of the other objects locus
			int yPrime = (p.getLocus().gety() + this.getLocus().gety() - otherObject.getLocus().gety());;
			//we create a Location called other location with x prime and y prime as it's x and y position
			Location otherLocation = new Location(xPrime, yPrime);
			// we check if the other object has a Pel with the other objects root and the other location as parameters, which does not equal null
			// which mean they intersect
			if (otherObject.tree.get(otherObject.tree.getRoot(), otherLocation ) != null) {
				// we return true
				return true;
			}
			// if it is null, then we call successor with the tree's root and p's locus as its parameters
			p = tree.successor(tree.getRoot(), p.getLocus());	
		}
		// then when p is null (does not intersect), we return false
		return false;
	}

}
