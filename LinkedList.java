/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fred
 */
public class LinkedList<T> implements ListInterface<Car>{
    private Node firstNode; // Reference to first node of chain
    private int numberOfEntries;

    public LinkedList(){
        initializeDataFields();
    } // end default constructor

    public void clear(){
        initializeDataFields();
    } // end clear
    
    public int getLength(){
        return numberOfEntries;
    }
    
    public void add(Car newEntry){
        Node newNode = new Node(newEntry);
        if (isEmpty())
            firstNode = newNode;
        else{
            Node lastNode = getNodeAt(numberOfEntries);
            lastNode.setNextNode(newNode); // Make last node reference new node
        } // end if

        numberOfEntries++;
    } // end add

    public void add(int givenPosition, Car newEntry){
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries + 1)){
            Node newNode = new Node(newEntry);
            if (givenPosition == 1){
                newNode.setNextNode(firstNode);
                firstNode = newNode;
            }
        else { // and givenPosition > 1
            Node nodeBefore = getNodeAt(givenPosition - 1);
            Node nodeAfter = nodeBefore.getNextNode();
            newNode.setNextNode(nodeAfter);
            nodeBefore.setNextNode(newNode);
        } // end if
        numberOfEntries++;
        }
        else
            throw new IndexOutOfBoundsException(
            "Illegal position given to add operation.");
    } // end add
    
    public Car remove(int givenPosition){
        Car result = null; // Return value
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)){
            if (givenPosition == 1){
                result = firstNode.getData(); // Save entry to be removed
                firstNode = firstNode.getNextNode(); // Remove entry
            }
            else{
                Node nodeBefore = getNodeAt(givenPosition - 1);
                Node nodeToRemove = nodeBefore.getNextNode();
                result = nodeToRemove.getData(); // Save entry to be removed
                Node nodeAfter = nodeToRemove.getNextNode();
                nodeBefore.setNextNode(nodeAfter); // Remove entry
            } // end if
            numberOfEntries--; // Update count
            return result; // Return removed entry
        }
        else
            throw new IndexOutOfBoundsException(
            "Illegal position given to remove operation.");
    } // end remove
    
    public boolean isEmpty(){
        boolean result;

        if (numberOfEntries == 0){
            result = true;
        }
        else{
            result = false;
        } // end if

        return result;
    } // end isEmpty
    
    public Car[] toArray(){
    // The cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        Car[] result = (Car[])new Car[numberOfEntries];

        int index = 0;
        Node currentNode = firstNode;
        while ((index < numberOfEntries) && (currentNode != null)){
            result[index] = currentNode.getData();
            currentNode = currentNode.getNextNode();
            index++;
        } // end while

    return result;
    } // end toArray
    
    // Initializes the class's data fields to indicate an empty list.
    private void initializeDataFields(){
        firstNode = null;
        numberOfEntries = 0;
    } // end initializeDataFields
    
    private Node getNodeAt(int givenPosition){
        Node currentNode = firstNode;

        for (int counter = 1; counter < givenPosition; counter++)
            currentNode = currentNode.getNextNode();

        return currentNode;
    } // end getNodeAt

    @Override
    public Car replace(int givenPosition, Car newEntry) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Car getEntry(int givenPosition) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean contains(Car anEntry) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private class Node{
    // < Implementation of private inner class Node >
        private Car data; // Entry in stack
        private Node next; // Link to next node
    
        private Node(Car dataPortion){
            data = dataPortion;
            next = null;
        }//end default constructor
        
        private Node(Car dataPortion, Node nextNode){
            data = dataPortion;
            next = nextNode;
        }//end constructor
        
        public Car getData(){
            return data;
        }//end getData
        
        public void setNextNode(Node NextNode){
            next = NextNode; 
        }
        
        public Node getNextNode(){
            return next;
        }//end getNextNode
    } // end Node
} // end LList