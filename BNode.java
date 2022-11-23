/*
 * This class represents the BinaryNode 
 * @author Abdul-Wasay Khan.
 */
public class BNode {
	   /*
	    * This is the initial class so we will be
	    * initializing the member variables here
	    */	
	private BNode right;
	private Pel value;
	private BNode left;
	private BNode parent;
	
	   /*
	    * Constructor BNode sets left, right and parent to specified values and stores Pel value in Node
	    * @param value Pel object of the BNode
	    * @param left BNode object
	    * @param right BNode object 
	    * @param parent BNode object
	    */
	public BNode(Pel value, BNode left, BNode right, BNode parent) {
		this.right = right;
		this.left = left;
		this.parent = parent;
		this.value = value;
	}
	   /*
	    * Constructor BNode initializes a leaf node where the data children and parent attributes are null
	    * @param value Pel object of the BNode
	    * @param left BNode object
	    * @param right BNode object 
	    * @param parent BNode object
	    */
	public BNode() {
		value = null;
		parent = null;
		right =  null;
		left = null;
		
		
	}
	   /*
	    * parent of the Node
	    * @return parent of the Node
	    */
	public BNode parent() {
		return parent;
	}
	   /*
	    * set parent of the Node to the parameter newParent
	    */
	public void setParent(BNode newParent) {
		parent = newParent;
	}
	   /*
	    * set left child of the Node to the parameter p
	    */
	public void setLeftChild (BNode p) {
		left = p;
	}
	   /*
	    * set right child of the Node to the parameter p
	    */
	public void setRightChild (BNode p) {
		right = p;
	}
	   /*
	    * set content of the Node to the parameter value
	    */
	public void setContent (Pel value) {
		this.value = value;
	}
	   /*
	    * check to see if node is a leaf
	    * @return value is null
	    */
	public boolean isLeaf() {
		return value ==  null ;
	}
	   /*
	    * get data of the Node
	    * @return value of the Node
	    */
	public Pel getData() {
		return value;
	}
	
	   /*
	    * get leftChild  of the Node
	    * @return left of the Node
	    */
	public BNode leftChild() {
		return left;
		
	}
	   /*
	    * get rightChild of the Node
	    * @return right of the Node
	    */
	public BNode rightChild() {
		return right;
		
	}
	

}
