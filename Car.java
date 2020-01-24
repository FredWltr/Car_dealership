/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fred
 */
import java.util.*;

public class Car {
    private String brand;
    private String type;
    private int year;
    private int price;
    private int serialNumber;

    public Car(){
	brand = " ";
	type = " ";
	year = 0;
        price = 0;
        serialNumber = 0;
    }//end default constructor

    public Car(String myBrand, String myType, int myYear, int myPrice, int mySerialNumber){
	brand = myBrand;
	type = myType;
	year = myYear;
        price = myPrice;
        serialNumber = mySerialNumber;
    }//end constructor
    
    public void Car(Car car){
        brand = car.getBrand();
        type = car.getType();
	year = car.getYear();
        price = car.getPrice();
        serialNumber = car.getSerialNumber();
    }

    public void setBrand(String myBrand){
	brand = myBrand;
    }//end setCourseCode
    
    public String getBrand(){
	return brand;
    }//end getCourseCode

    public void setType(String myType){
	type = myType;
    }//end setTask

    public String getType(){
	return type;
    }//end getTask

    public void setYear(int myYear){
	year = myYear;
    }//end setDueDate

    public int getYear(){
	return year;
    }//end getDueDate
    
    public void setPrice(int myPrice){
	price = myPrice;
    }//end setDueDate

    public int getPrice(){
	return price;
    }//end getDueDate
    
    public void setSerialNumber(int mySerialNumber){
	serialNumber = mySerialNumber;
    }//end setDueDate

    public int getSerialNumber(){
	return serialNumber;
    }//end getDueDate

    public String getCarInfo(){
	return brand + "\t" + type + "\t" +year+ "\t$" + price + "\t" + serialNumber;
    }

    /*public static void main(String[] args){
				
	Car car1 = new Car("Toyota", "SUV", 2015, 5500);
	System.out.println(car1.getCarInfo());
	Car car2 = new Car("Ford", "crossover", 2012, 3000);
	System.out.println(car2.getCarInfo());
        Car car3 = new Car("Chevi", "truck", 2017, 15000);
	System.out.println(car3.getCarInfo());
        Car car4 = new Car("BMW", "coupe", 2018, 13000);
	System.out.println(car4.getCarInfo());
	
    }//end main*/
}//end Car
