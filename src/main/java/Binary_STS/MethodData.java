package Binary_STS;

import java.util.Arrays;
import java.util.Collections;

/**
* File: MethodData.java
* Author: Kolger Hajati
* Date: February 22, 2019
* Purpose:This file holds node and classes for organization of input.
*/

class MethodData <T extends Comparable <T>> {

    //Variables
	//private StringBuffer result = new StringBuffer();
	private String result = "";
	private Node root;
    
    //The node and getter
    class Node {

        //Node variables
        private T value;
        private Node left;
        private Node right;

        public Node(T value) {
            this.value = value;
        }
        
        //Getter methods
        public Node getLeft() {
            return left;
        }
        public Node getRight() {
            return right;
        }
    }

    /*Handles creation of root and also calls
    method that handles recursion insertion*/
    void insertNode (T value) {
        if (root == null) {
            root = new Node(value);
            return;
        }
        else {
        	RecurNode(value, root);
        }
    }

    //Handles placment of values of either integer or fraction
    private void RecurNode(T value, Node node) {
        //Left side values
    	if (value.compareTo(node.value) <= 0) {
            if (node.left != null) {                    
            	RecurNode(value, node.left);  
            } 
            else {
                node.left = new Node(value);
            }
        } 
    	//Right side values
        else if (value.compareTo(node.value) > 0) {
            if (node.right !=null) {
            	RecurNode(value, node.right);
            } 
            else {
                node.right = new Node(value);
            }
        }
    }

    //Handles the creation of the string form binary tree
    private void placementMethod(Node root) {
        if (root.value != null) {
        	String outOrder;
        	
        	if (root.getLeft() != null)
        		placementMethod(root.getLeft());
        		outOrder = (root.value).toString();
	        	result+=(outOrder)+(" ");
        	
            if (root.getRight() != null) 
            	placementMethod(root.getRight()); // Checks for child on the right
        }
    }
    
    //Handles ascending order of the string
    String getAscending() {
    	placementMethod(root);
        return result.toString();
    }

    /**
    * Handles descending order of the string
    * by reversing the order using getAscending method
    */
    String getDescending() {
        
        String[] nums = getAscending().toString().split(" ");
        Collections.reverse(Arrays.asList(nums));
        result = Arrays.toString(nums).replace(",", "").replace("[", "").replace("]", "");  
        return result.toString();
    }
}