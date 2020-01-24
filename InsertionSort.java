/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fred
 */
public class InsertionSort {
    //Function to sort array by Year
    void BrandSort(Car array[]){
    	int n = array.length;
    	for (int i = 1; i < n; i++){
 		String key = array[i].getBrand();
                Car ref = new Car(" " ," ",0 ,0, 0);
                ref.Car(array[i]);
 		int j = i-1;

 		/* Move elements of array1[0..i-1], that are
 		greater than key, to one position ahead
 		of their current position */
 		while (j >= 0 && array[j].getBrand().compareToIgnoreCase(key) > 0){
                        array[j+1].Car(array[j]);
 			j = j-1;
 		}
 		array[j+1].Car(ref);
 	}
    }//end BrandSort
    
    void TypeSort(Car array[]){
    	int n = array.length;
    	for (int i = 1; i < n; i++){
 		String key = array[i].getType();
                Car ref = new Car(" " ," ",0 ,0, 0);
                ref.Car(array[i]);
 		int j = i-1;

 		/* Move elements of array1[0..i-1], that are
 		greater than key, to one position ahead
 		of their current position */
 		while (j >= 0 && array[j].getType().compareToIgnoreCase(key) > 0){
                        array[j+1].Car(array[j]);
 			j = j-1;
 		}
 		array[j+1].Car(ref);
 	}
    }//end TypeSort
    
    //Function to sort array by Year
    void YearSort(Car array[]){
        
    	int n = array.length;
    	for (int i = 1; i < n; i++){
 		int key = array[i].getYear();
                Car ref = new Car(" " ," ",0 ,0, 0);
                ref.Car(array[i]);
 		int j = i-1;

 		/* Move elements of array1[0..i-1], that are
 		greater than key, to one position ahead
 		of their current position */
 		while (j >= 0 && array[j].getYear() > key){
                        array[j+1].Car(array[j]);
 			j = j-1;
 		}
 		array[j+1].Car(ref);
 	}
    }//end YearSort
    
    //Function to sort the array by Price
    void PriceSort(Car array[]){
        
    	int n = array.length;
    	for (int i = 1; i < n; i++){
 		int key = array[i].getPrice();
                Car ref = new Car(" " ," ",0 ,0, 0);
                ref.Car(array[i]);
 		int j = i-1;

 		/* Move elements of array1[0..i-1], that are
 		greater than key, to one position ahead
 		of their current position */
 		while (j >= 0 && array[j].getPrice() > key){
                        array[j+1].Car(array[j]);
 			j = j-1;
 		}
 		array[j+1].Car(ref);
 	}
    }//end PriceSort
    
    void SerialNumberSort(Car array[]){
    	int n = array.length;
    	for (int i = 1; i < n; i++){
 		int key = array[i].getSerialNumber();
                Car ref = new Car(" " ," ",0 ,0, 0);
                ref.Car(array[i]);
 		int j = i-1;

 		/* Move elements of array1[0..i-1], that are
 		greater than key, to one position ahead
 		of their current position */
 		while (j >= 0 && array[j].getSerialNumber()> key){
                        array[j+1].Car(array[j]);
 			j = j-1;
 		}
 		array[j+1].Car(ref);
 	}
    }//end SerialNumberSort

    /* A method to print the content of the array of size n*/
    static void printArray(Car array[]){
 	int n = array.length;
 	for (int i=0; i<n; i++)
 		System.out.println(array[i].getCarInfo());

 	System.out.println();
    }//end printArray
    
    /*public static void main(String[] args){
        Car car[] = new Car[5];
        car[0] = new Car("Toyota", "SUV", 2018, 5500);
        car[1] = new Car("Ford", "truck", 2017, 7500);
        car[2] = new Car("BMW", "sport car", 2015, 12500);
        car[3] = new Car("Audi", "SUV", 2016, 17500);
        car[4] = new Car("Jeep", "jeep", 2019, 8500);
        
        InsertionSort sortArray = new InsertionSort();
        sortArray.BrandSort(car);
        InsertionSort.printArray(car);
        sortArray.TypeSort(car);
        InsertionSort.printArray(car);
        sortArray.YearSort(car);
        InsertionSort.printArray(car);
        sortArray.PriceSort(car);
        InsertionSort.printArray(car);
    }//end main*/
    
}//end InsertionSort
