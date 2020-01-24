/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fred
 */
public class LinkedBag<T> implements BagInterface<Car> {
    private Node firstNode;
    private int numberOfEntries;
    
    public LinkedBag(){
        firstNode = null;
        numberOfEntries = 0;
    }//end default constructor

    private class Node{
        private Car data;
        private Node next;
        
        private Node(Car dataPortion){
            data = dataPortion;
            next = null;
        }//end default constructor
        
        private Node(Car dataPortion, Node nextNode){
            data = dataPortion;
            next = nextNode;
        }//end constructor
    }//end Node
    
    public boolean add(Car newEntry){
        Node newNode = new Node(newEntry);
        newNode.next = firstNode;
        firstNode = newNode;
        numberOfEntries++;
        return true;
    }//end add
    
    public Car[] toArray(){
        @SuppressWarnings("unchecked")
        Car[] result = (Car[]) new Car[numberOfEntries];
        
        int index = 0;
        Node currentNode = firstNode;
        while((index < numberOfEntries) && (currentNode != null)){
            result[index] = currentNode.data;
            index++;
            currentNode = currentNode.next;
        }//end while
        
        return result;
    }//end toArray
    
    public int getFrequencyOf(Car anEntry){
        int frequency = 0;
        
        int loopCounter = 0;
        Node currentNode = firstNode;
        
        while((loopCounter < numberOfEntries) && (currentNode != null)){
            if(anEntry.equals(currentNode.data)){
                frequency++;
            }//end fi
            
            loopCounter++;
            currentNode = currentNode.next;
        }//end while
        
        return frequency;
            }//end getFrequencyOf
    
    public boolean contains(Car anEntry){
        boolean found = false;
        Node currentNode = firstNode;
        
        while(!found && (currentNode != null)){
            if(anEntry.equals(currentNode.data)){
                found = true;
            }
            else
                currentNode = currentNode.next;
        }
        return found;
    }
    
    private Node getReferenceTo(Car anEntry){
        boolean found = false;
        Node currentNode = firstNode;
        
        while(!found && (currentNode != null)){
            if(anEntry.equals(currentNode.data))
                found = true;
            else
                currentNode = currentNode.next;
        }//end while
        return currentNode;
    }
    
    public Car remove(){
        Car result = null;
        if(firstNode != null){
            result = firstNode.data;
            firstNode = firstNode.next;
            numberOfEntries--;
        }
        return result;
    }
    
    public boolean remove(Car anEntry){
        boolean result = false;
        Node nodeN = getReferenceTo(anEntry);
        if(nodeN != null){
            nodeN.data = firstNode.data;
            firstNode = firstNode.next;
            numberOfEntries--;
            result = true;
        }
        return result;
    }
    
    public void clear(){
        while(!isEmpty())
            remove();
    }
    
    public boolean isEmpty(){
        return numberOfEntries == 0;
    }
    
    public int getCurrentSize() {
        return numberOfEntries;
    }
    
    public void display(Car car){
            System.out.println(car.getCarInfo());
    }
    
}//end LinkedBag
