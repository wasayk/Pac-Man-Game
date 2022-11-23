/*
 * This class represents the BinarySearchTree and it implements BinarySearchTreeADT
 * @author Abdul-Wasay Khan.
 */
public class BinarySearchTree implements BinarySearchTreeADT{
	   /*
	    * This is the initial class so we will be
	    * initializing the member variables here
	    */	
	private BNode root; //root object of the BNode class
	   /*
	    * Constructor BinarySearchTree
	    * root is initialized to a new onject of the BNode class
	    */
	public BinarySearchTree() {
		root = new BNode();
	}
	
	   /*
	    * private method find returns a BNode and takes in a BNode r (root) and Location key as the parameters
	    * @return the node object with they given key, if the key is stored in the tree, returns null otherwise
	    */
	private BNode find(BNode r, Location key) {
		//checks to see if the node object r is a leaf 
		if (r.isLeaf()) {
			//return r if it is
			return r;
		} else {
			//if it isnt then it compares it to the key to see if it equal to 0 (meaning we found the node object)
			if (r.getData().getLocus().compareTo(key) == 0) {
				//returns r if it is
				return r;
			} else {
				//else if it still isnt then compare it to the key to see if it is equal to 1 (meaning it is left of the current node)
				if (r.getData().getLocus().compareTo(key) == 1) {
					//if so then we traverse the left child of the current node recursively
					return find(r.leftChild(), key);
					//and if it is not equal to 1 then it is to the right of the current node
				} else {
					// so then we traverse the right child of the current node recursively
					return find(r.rightChild(), key);
				}
			}
		}	
	}
	
	   /*
	    * get returns a Pel Object and takes in a BNode r (root) and Location key as the parameters
	    * @return the node object with they given key, if the key is stored in the tree, returns null otherwise
	    */
	public Pel get(BNode r, Location key) {
		//checks to see if the node object r is a leaf 
		if (r.isLeaf()) {
			//return r's data if it is
			return r.getData();
		} else {
			//if it isnt then it compares it to the key to see if it equal to 0 (meaning we found the node object)
			if (r.getData().getLocus().compareTo(key) == 0) {
				//return r's data if it is
				return r.getData();
			//else if it still isnt then compare it to the key to see if it is equal to 1 (meaning it is left of the current node)
			} else if (r.getData().getLocus().compareTo(key) == 1) {
				//if so then we traverse the left child of the current node recursively
					return get(r.leftChild(), key);
				//and if it is not equal to 1 then it is to the right of the current node
				} else {
					// so then we traverse the right child of the current node recursively
					return get(r.rightChild(), key);
				}
		}
		
	}
	   /*
	    * put takes in a BNode r (root) and Pel newData as the parameters
	    * Inserts the newData into the tree if no data item with the same key is present
	    * if a node already stores the same key then we throw a DuplicatedKeyException
	    */
	public void put(BNode r, Pel newData) throws DuplicatedKeyException {
		//creating a BNode object called p and initialize it to r
		BNode p = r;
		//while p is not a leaf
		while(!p.isLeaf()) {
			// we compare its locus to newData's locus and see if it is equal to 1, 0 or -1
			//if it is 1
			if(p.getData().getLocus().compareTo(newData.getLocus()) == 1) {
				// we assign p to its left child
				p = p.leftChild();
				//if it is -1
			} else if (p.getData().getLocus().compareTo(newData.getLocus()) == -1) {
				//we assign p to its right child
				p = p.rightChild();
				//if it is 0
			} else if (p.getData().getLocus().compareTo(newData.getLocus()) == 0) {
				//it means the key exists so we throw an exception
				throw new DuplicatedKeyException("Key already exists");
			}
		}
		//once we have found a spot to put it in the tree
		//we set the content of p as newData
		p.setContent(newData);
		//we make BNode object for its right and left child
		BNode rightChild = new BNode();
		BNode leftChild = new BNode();
		// we set p's left and right children to the new BNode objects we just created
		p.setLeftChild(leftChild);
		p.setRightChild(rightChild);
		//we finally set the parent of the children we created to p
		rightChild.setParent(p);
		leftChild.setParent(p);

	}
	
	   /*
	    * remove takes in a BNode r (root) and Location key as the parameters
	    * removes the data item with the given key if it exists in the tree
	    * throws InexistentKeyException otherwise
	    */
	public void remove(BNode r, Location key) throws InexistentKeyException{
		//creating a BNode object called p 
		//finding the node with the given r and key and storing that into p
		BNode p = find(r, key);
		//we check to see if p is a leaf
		if (p.isLeaf()) {
			//if it is we throw an exception as the key does not exist
			throw new InexistentKeyException("Key does not exist");
		//otherwise
		} else {
			//if the leftChild of p is a leaf
			if (p.leftChild().isLeaf()) {
				//we create a BNode object child
				BNode child = new BNode();
				//and we set child to the right child of p
				child = p.rightChild();
				//then we check if p's parent is null
				if(p.parent() != null) {
					//if it isnt then we set the left child of p's parent to the child object we created
					p.parent().setLeftChild(child);
				// if it is null
				} else {
					// we set the child as the root of the tree
					root = child;
					// and set its parent to null
					child.setParent(null);
				}
			//if the right child of p is a leaf
			} else if (p.rightChild().isLeaf()) {
				//we create a BNode object child
				BNode child = new BNode();
				//and we set child to the left child of p
				child = p.leftChild();
				//then we check if p's parent is null
				if(p.parent() != null) {
					//if it isnt then we set the right child of p's parent to the child object we created
					p.parent().setRightChild(child);
				// if it is null
				} else {
					// we set the child as the root of the tree
					root = child;
					// and set its parent to null
					child.setParent(null);
				}
			//if neither child is a leaf
			} else {
				//we create a Pel object called s
				Pel s = null;
				// we get the smallest of p's right child and assign it to s
				try {
					s = smallest(p.rightChild());
				} catch (EmptyTreeException e) {
					e.printStackTrace();
				}
				//we set the content of p to s
				p.setContent(s);
				//we finally call remove recursively but with p's rightchild and s' Locus as the parameters
				remove(p.rightChild(), s.getLocus());				
			}
		}
	}
	
	   /*
	    * Successor takes in a BNode r (root) and Location key as the parameters
	    * @returns the Pel object with the smallest key larger than the given one
	    * @return null if the given key has no successor
	    */
	public Pel successor(BNode r, Location key) {
		// we check to see if r is a leaf
        if (r.isLeaf()) {
        	// if it is then we return null
            return null;
        //else if it is not
        } else {
        	// we find the node with the given r and key
        	// and assign it to a BNode object that we create called p
            BNode p = find(r, key);
            //we check to see if p and p's rightChild are leaves
            if (!p.isLeaf() && !p.rightChild().isLeaf()) {
            	// if they arent then we return the smallest of p's right child
                try {
                    return smallest(p.rightChild());
                } catch (EmptyTreeException e) {
                    e.printStackTrace();
                }
            //if one or both of them is a leaf
            } else {
            	// we assign p to its own parent
                p = p.parent();
                //and we make it so that while p is not null and while p's locus in comparison to the key is -1
                while (p != null && (p.getData().getLocus().compareTo(key) == -1 )) {
                	// we continue to assign p to its own parent
                    p = p.parent();
                //once those conditions are not true
                // we check to see if p is null
                } if (p == null) {
                	//if so we return null
                    return null;
                // if it is not null
                } else {
                	// we return the data of p
                    return p.getData();
                }
            }
        }
		return null;
		
	}
	   /*
	    * Predecessor takes in a BNode r (root) and Location key as the parameters
	    * @returns the Pel object with the largest key smaller than the given one
	    * @return null if the given key has no predecessor
	    */
	public Pel predecessor(BNode r, Location key) {
		// we check to see if r is a leaf
        if (r.isLeaf()) {
        	// if it is then we return null
            return null;
        //else if it is not
        } else {
        	// we find the node with the given r and key
        	// and assign it to a BNode object that we create called p
            BNode p = find(r, key);
          //we check to see if p and p's leftchild are leaves
            if (!p.isLeaf() && !p.leftChild().isLeaf()) {
            	// if they arent then we return the largest of p's left child
                try {
                    return largest(p.leftChild());
                } catch (EmptyTreeException e) {
                    e.printStackTrace();
                }
             //if one or both of them is a leaf
            } else {
            	// we assign p to its own parent
                p = p.parent();
              //and we make it so that while p is not null and while p's locus in comparison to the key is 1
                while (p != null && (p.getData().getLocus().compareTo(key) == 1 )) {
                	// we continue to assign p to its own parent
                    p = p.parent();
                //once those conditions are not true
                // we check to see if p is null
                } if (p == null) {
                	//if so we return null
                    return null;
                // if it is not null
                } else {
                	// we return the data of p
                    return p.getData();
                }
            }
        }
        return null;
		
	}
	   /*
	    * smallest takes in a BNode r (root) as the parameter
	    * @returns the Pel object in the tree with the smallest key
	    * throws EmptyTreeException if tree dies not contain data
	    */
	public Pel smallest(BNode r) throws EmptyTreeException {
		// we check to see if r is a leaf
		if (r.isLeaf()) {
			// if it is then we throw an Exception since the tree is empty
			throw new EmptyTreeException("Tree is empty");
		//otherwise
		} else {
			//we create a BNode object and assign it to r
			BNode p = r;
			// we make it so that while p is not a leaf
			while (!p.isLeaf()) {
				//p is assign to its leftChild
				p = p.leftChild();
			}
			//once we have found it, we return p's parent's data (since p would have became an empty Leaf)
			return p.parent().getData();
		}
	}

	   /*
	    * largest takes in a BNode r (root) as the parameter
	    * @returns the Pel object in the tree with the largest key
	    * throws EmptyTreeException if tree dies not contain data
	    */
	public Pel largest(BNode r) throws EmptyTreeException {
		// we check to see if r is a leaf
		if (r.isLeaf()) {
			// if it is then we throw an Exception since the tree is empty
			throw new EmptyTreeException("Tree is empty");
		//otherwise
		} else {
			//we create a BNode object and assign it to r
			BNode p = r;
			// we make it so that while p is not a leaf
			while (!p.isLeaf()) {
				//p is assign to its rightChild
				p = p.rightChild();
			}
			//once we have found it, we return p's parent's data (since p would have became an empty Leaf)
			return p.parent().getData();
		}
	}
	   /*
	    * getRoot is of type BNode
	    * @returns root of the tree
	    */
	public BNode getRoot() {
		return root;
	}
	

}
