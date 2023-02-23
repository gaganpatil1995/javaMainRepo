import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class Geektrust {
	
	public static int total = 0 ;
	public static int totalDiscount =0 ;
	public static int fastTagAmount =0 ;
	public static int cashAmount =0 ;
	public static HashMap<String ,Integer> vehicleFastagInfo = new HashMap<>() ;   //vehicle Information along with fast tag amount information will store here 
	public static HashMap<String , Integer> vehicleJourneyInfo = new HashMap<>();  // vehicle number along with no of time it passes
	public static HashMap<String ,Integer> vehiclePasses = new HashMap<>() ;       // type of vehicle along with no of vehicle passes ;
	public static HashMap<String ,Integer > vehicleCollection = new HashMap<>();   // type of vehicle along with total collection form that type of vehicle ;
	
	
    public static void main(String[] args)  {
        try {
            // the file to be opened for reading
            FileInputStream fis = new FileInputStream(args[0]); 
            Scanner sc = new Scanner(fis); // file to be scanned //given
        	
            // returns true if there is another line to read
            while (sc.hasNextLine()) {
        	
            		
               String inputCommand = sc.nextLine();
               
               //Add your code here to process input commands.
               String[] input = inputCommand.trim().split(" ") ;
              
             TollPlaza tp = new TollPlaza() ;
               if(input[0].equals("FASTAG")) {
            	  
            	   tp.updateFasTagAmount(vehicleFastagInfo, input[2],input[1]);
            	   
//            	   int fastagAmount = Integer.parseInt(input[2]) ; Previous Code 
//            	  
//            	   vehicleFastagInfo.put(input[1], fastagAmount);
            	   
            	   
               }else if(input[0].equals("COLLECT_TOLL") ) {
            	   
            	   tp.countNumberOfVehiclePasses(vehiclePasses, input[1]);
            	   
//            	   if(vehiclePasses.containsKey(input[1])) {
//         			  vehiclePasses.put(input[1], vehiclePasses.get(input[1])+1) ;  Previous Code 
//         			 
//         		   }else {
//         			  vehiclePasses.put(input[1], 1);
//         		   }
            	   
            	 int amount ;
            	 
            	  if(vehicleFastagInfo.get(input[2])==null) {
            		  amount = 0 ;
            	  }
            	  else {
            		  amount = vehicleFastagInfo.get(input[2]) ;
            	  }
            	  
            	   
            	   int remain = 0 ;
            	   
            	   
            	   if(input[1].equals("CAR") || input[1].equals("VAN") || input[1].equals("RICKSHAW")) { 
            		   
            		
          tp.tollCollectionForLightFourWheelVehicle(vehicleJourneyInfo, input[2], input[1], vehicleFastagInfo, vehicleCollection, total, totalDiscount, fastTagAmount, cashAmount, amount, remain);  		   

		            		
            		   
            	   }else if(input[1].equals("TRUCK")||input[1].equals("BUS")) {
            		   
		  tp.tollCollectionForHeavyFourWheelVehicle(vehicleJourneyInfo, input[2], input[1], vehicleFastagInfo, vehicleCollection, total, totalDiscount, fastTagAmount, cashAmount, amount, remain);
		  
            		   
            	   }else if(input[1].equals("SCOOTER")||input[1].equals("MOTORBIKE")) {
            		   
            		   tp.tollCollectionForTwoWheelVehicle(vehicleJourneyInfo, input[2], input[1], vehicleFastagInfo, vehicleCollection, total, totalDiscount, fastTagAmount, cashAmount, amount, remain);                        
			            		   
			            	   }
            	   
            	   
               }
               else { // this is first if condition's else
            	   
            	
            	   
               }
            }// while loop ends
            	
            	
                  System.out.println("TOTAL_COLLECTION"+" "+total +" "+ totalDiscount);
            	  
            	  System.out.println("PAYMENT_SUMMARY"+" "+fastTagAmount + " "+cashAmount);
            	  System.out.println("VEHICLE_TYPE_SUMMARY");
            	  
            	  List<Map.Entry<String,Integer>> listOfVehicleCollection = new LinkedList<Map.Entry<String , Integer> >(vehicleCollection.entrySet());
            	  
            	  Collections.sort( listOfVehicleCollection , new Comparator<Map.Entry<String , Integer>>(){
            		  public int compare(Map.Entry<String , Integer> obj1 , Map.Entry<String , Integer> obj2) {
            			  return (obj2.getValue()).compareTo(obj1.getValue());
            		  }
            	  });
            	 
            	  for(Map.Entry<String ,Integer> entry : listOfVehicleCollection) {
            		
            		  System.out.println(entry.getKey() + " " + vehiclePasses.get(entry.getKey()) ) ;
            	  }
            sc.close(); // closes the scanner
        } catch (Exception e) {
        	System.out.println(e);
        }   
	}
}
