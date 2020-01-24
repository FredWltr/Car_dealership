/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fred
 */
public interface ListInterface<Car>{
   
    public void add(Car newEntry);

    public void add(int newPosition, Car newEntry);

    public Car remove(int givenPosition);

    public void clear();

    public Car replace(int givenPosition, Car newEntry);

    public Car getEntry(int givenPosition);

    public Car[] toArray();

    public boolean contains(Car anEntry);

    public int getLength();

    public boolean isEmpty();
}//end ListInterface