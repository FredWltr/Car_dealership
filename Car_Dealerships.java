/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fred
 */
import java.io.*;
import java.util.*;

public class Car_Dealerships {
    
    public static BagInterface<Car> aBag = new LinkedBag<>();
    public static ListInterface<Car> aList = new LinkedList<Car>();
    public static InsertionSort sortArray = new InsertionSort();
    public static Car[] BagArray;
    public static Car[] ListArray;
    public static int serialNumber = 10000;
    
    public static void main(String[] args){
        
        boolean check = true; //check if the user want to enter a car
  
        // data.txt => data enter previously
        //import the data into the bag
        try{
            BufferedReader br = new BufferedReader(new FileReader("data.txt"));
            
            while(check){
                String line = br.readLine();
                if(line == null){
                    break;
                }//if
                
                StringTokenizer line1 = new StringTokenizer(line); //read the first line
                String brand = line1.nextToken();//read the first word of the line
                String type = line1.nextToken();//read the second word of the line
                String yearS = line1.nextToken();//read the third word of the line
                String priceS = line1.nextToken();//read the fourth word of the line 
                String serialNumberS = line1.nextToken();//read the fifth word of the line
                int year = Integer.parseInt(yearS);//convert the String into an int
                int price = Integer.parseInt(priceS);
                serialNumber = Integer.parseInt(serialNumberS);
                addCar(brand, type, year, price, serialNumber);//add the car to the bag
                
            }//while
            }catch(IOException ioe)
        {System.err.println("Welcome to the car dealership program");}
        //display all the car
        System.out.println("Those are the car in your shop: ");
        
        //display the inside of the bag
        BagArray = aBag.toArray();
        for(int i = 0; i < aBag.getCurrentSize(); i++)
            aBag.display(BagArray[i]);
        System.out.println();
        
        while(check){
            //ask if the user want to add a car to the bag
            System.out.println("1 => add   || 2 => remove   || 3 => display   || 4 => classify   || 5 => contain a brand    || 6 => Exit");
            Scanner scan0 = new Scanner(System.in);
            int ans = scan0.nextInt();
        
            switch(ans){
                case 1: //add a car to the shop
                    System.out.print("Enter the brand of the car: ");
                    Scanner scan1 = new Scanner(System.in);
                    String brand = scan1.nextLine();
                    System.out.print("Enter the type of the car: ");
                    Scanner scan2 = new Scanner(System.in);
                    String type = scan2.nextLine();
                    System.out.print("Enter the year of the car: ");
                    Scanner scan3 = new Scanner(System.in);
                    int year = scan3.nextInt();
                    System.out.print("Enter the price of the car: ");
                    Scanner scan4 = new Scanner(System.in);
                    int price = scan4.nextInt();
                    serialNumber++;
                    addCar(brand, type, year, price, serialNumber);
                    break;
            
                case 2: //remove a car to the shop
                    BagArray = aBag.toArray();
                    System.out.print("Enter the serial number of the car: ");
                    Scanner scan5 = new Scanner(System.in);
                    int toRemove = scan5.nextInt();
                    remove(toRemove);
                    break;
                case 3: //display the car
                    System.out.println();
                    BagArray = aBag.toArray();
                    for(int i = 0; i < aBag.getCurrentSize(); i++)
                        aBag.display(BagArray[i]);
                    break;
                case 4: //classify
                    System.out.println("\t1 => classify by Brand || 2 => classify by Type || 3 => classify by Year  || 4 => classify by Price");
                    Scanner scan6 = new Scanner(System.in);
                    int action = scan6.nextInt();
                    BagArray = aBag.toArray();
                    
                    switch(action){
                        case 1://sort by brand
                            sortBrand(BagArray);
                            break;
                        case 2://sort by type
                            sortType(BagArray);
                            break;
                        case 3://sort by year
                            sortYear(BagArray);
                            break;
                        case 4://sort by price
                            sortPrice(BagArray);
                            break;
                        default:
                            System.out.println("Invalid input..");
                    }//end switch
                    break;
                case 5: //contains a specific brand
                    System.out.print("Enter the brand: ");
                    Scanner scan7 = new Scanner(System.in);
                    String toContain = scan7.nextLine();
                    contain(toContain);
                    break;
                case 6: // Exit
                    break;
                default://in case of a wrong input
                    System.out.println("Invalid input");
            }//end switch
            if(ans == 6){//ask if the user really wanna leave
                System.out.print("Do you really want to leave? (y/n) ");
                Scanner scan8 = new Scanner(System.in);
                char ans4 = scan8.next().charAt(0);
                check = ans4 == 'n' || ans4 == 'N';
            }//end if
            else{//ask if the user want to do something else
                System.out.print("\nDo you want to perform another action?(y/n) ");
                Scanner scan9 = new Scanner(System.in);
                char ans1 = scan9.next().charAt(0);
                check = ans1 == 'y' || ans1 == 'Y';
            }//end else
        }//end while
        
        //calculate the sum of the price of the car
        BagArray = aBag.toArray();
        int sum = 0;
        //find how much all the car represent
        for(int i = 0; i < BagArray.length; i++)
            sum = sum + BagArray[i].getPrice();
        
        //give some quick statistique after the user is done changing the inside of the bag
        System.out.println("\tThere is " + BagArray.length + " cars in your shop");
        System.out.println("\tYou have $" + sum + " invested in your shop");
        System.out.println("\tOn average, a car cost $" + sum/BagArray.length + " in your shop");
        
        
        //export the bag into a text file (the same bag will be reuse the next time)
        BufferedWriter writer = null;
            try {
                BagArray = aBag.toArray();
                sortSerialNumber(BagArray);
                writer = new BufferedWriter(new FileWriter("data.txt"));
                for(int i = 0; i < aBag.getCurrentSize(); i++)
                    writer.write(BagArray[i].getBrand() +"\t"+ BagArray[i].getType() + 
                            "\t" + BagArray[i].getYear() +"\t"+ BagArray[i].getPrice()+ 
                            "\t" + BagArray[i].getSerialNumber()+ "\n");
            } catch (IOException e) {
            System.err.println(e);
            } finally {
                if (writer != null) {
                    try {
                        writer.close();
                    } catch (IOException e) {
                    System.err.println(e);
                    }
                }
            }
        
    }//end main
    
    //see if you have one or more specific car in your shop
    public static void contain(String brandContain){
        boolean find = false;
        BagArray = aBag.toArray();
        
        for(int i = 0; i < BagArray.length; i++){
            if(BagArray[i].getBrand().compareToIgnoreCase(brandContain) == 0){
                System.out.println(BagArray[i].getCarInfo());
                find = true;
            }
        }//end for
        if(!find)
            System.out.println("There is no " + brandContain + " in your shop");
    }//end contain
    
    //remove a car by typing the serial number
    public static void remove(int serialNumberToRemove){
        sortSerialNumber(BagArray);
        BagArray = aBag.toArray();
        
        int i = 0;
        
        //empty the list
        aList.clear();
        
        //put the bag inside the list
        while(i < BagArray.length){
            aList.add(BagArray[i]);
            i++;
        }
        
        //create an array list from the list
        ListArray = aList.toArray();
        
        //binary search algorithm
        int givenIndex = -1;
        int numberOfEntries = ListArray.length;
        int first = 0;
        int last = 0;
        int mid = 0;
        boolean found = false;
        
        last = numberOfEntries;
        
        while(!found){
            mid = first + (last - first) / 2;
            if(first > last){
                System.out.println("Invalid input");
                break;
            }
            else if(serialNumberToRemove == ListArray[mid].getSerialNumber()){
                givenIndex = mid;
                found = true;
            }
            else if(serialNumberToRemove < ListArray[mid].getSerialNumber()){
                last = mid - 1;
                found = false;
            }
            else{
                first = mid + 1;
                found = false;
            }
        }
        
        //remove the corresponding car
        if(givenIndex>=0){
            aList.remove(givenIndex + 1);
        }
        ListArray = aList.toArray();
        
        //empty the bag
        aBag.clear();
        
        //put the list inside the bag
        for(int j = 0; j < aList.getLength(); j++){
            aBag.add(ListArray[j]);
        }//end while
        
    }//removeCar
    
    //add a car to the bag
    public static void addCar(Car newCar){
        aBag.add(newCar);
    }//end addCar
    
    //add a car to the bag
    public static void addCar(String myBrand, String myType, int myYear, int myPrice, int mySerialNumber){
        Car newCar = new Car(myBrand, myType, myYear, myPrice, mySerialNumber);
        addCar(newCar);
    }//end addCar
    
    //sort by brand
    public static void sortBrand(Car[] BagArray){
        System.out.println("    Ordered by Brand");
        System.out.println("Brand\tType\tYear\tPrice\tSerialNumber");
        sortArray.BrandSort(BagArray);
        InsertionSort.printArray(BagArray);
    }//end sortBrand
    
    //sort by type
    public static void sortType(Car[] BagArray){
        System.out.println("    Ordered by Type");
        System.out.println("Brand\tType\tYear\tPrice\tSerialNumber");
        sortArray.TypeSort(BagArray);
        InsertionSort.printArray(BagArray);
    }//end sortType
    
    //sort by year
    public static void sortYear(Car[] BagArray){
        System.out.println("    Ordered by Year");
        System.out.println("Brand\tType\tYear\tPrice\tSerialNumber");
        sortArray.YearSort(BagArray);
        InsertionSort.printArray(BagArray);
    }//end sortYear
    
    //sort by price
    public static void sortPrice(Car[] BagArray){
        System.out.println("    Ordered by Price");
        System.out.println("Brand\tType\tYear\tPrice\tSerialNumber");
        sortArray.PriceSort(BagArray);
        InsertionSort.printArray(BagArray);
    }//end sortPrice
    
    //sort by serial number (use before the binary search)
    public static void sortSerialNumber(Car[] BagArray){
        sortArray.SerialNumberSort(BagArray);
    }//end sortSerialNumber
} // end Car_Dealership