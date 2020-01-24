/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fred
 */
public interface BagInterface<Car>{

    public int getCurrentSize();

    public boolean isEmpty();

    public boolean add(Car newEntry);

    public Car remove();

    public boolean remove(Car anEntry);

    public void clear();

    public int getFrequencyOf(Car anEntry);

    public boolean contains(Car anEntry);

    public Car[] toArray();
    
    public void display(Car car);
}
