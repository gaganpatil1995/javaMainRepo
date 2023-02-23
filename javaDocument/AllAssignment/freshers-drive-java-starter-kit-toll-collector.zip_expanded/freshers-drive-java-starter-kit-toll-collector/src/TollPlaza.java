import java.util.HashMap;

public class TollPlaza {
	
	public void updateFasTagAmount(HashMap<String ,Integer> vehicleFastagInfo ,String amount , String vechicleDetail) {
		  
		int fastagAmount = Integer.parseInt(amount) ;
     	  
    	   vehicleFastagInfo.put(vechicleDetail, fastagAmount);
	}
	
	public void countNumberOfVehiclePasses(HashMap<String ,Integer> vehiclePasses , String vehicleDetails   ) {
		
		if(vehiclePasses.containsKey(vehicleDetails )) {
			  vehiclePasses.put(vehicleDetails , vehiclePasses.get(vehicleDetails )+1) ;
			 
		   }else {
			  vehiclePasses.put(vehicleDetails , 1);
		   }
	}
	
	public void tollCollectionForLightFourWheelVehicle(HashMap<String , Integer> vehicleJourneyInfo,String vehicleDetail,String vehicleName ,HashMap<String ,Integer> vehicleFastagInfo
			,HashMap<String ,Integer > vehicleCollection,int total ,int totalDiscount,int fastTagAmount,int cashAmount, int amount ,int remain) {
		
		
		  if(vehicleJourneyInfo.containsKey(vehicleDetail)) {
			   
			   
			   vehicleJourneyInfo.remove(vehicleDetail);
			   
			   if(amount >=50) {
				   
				   vehicleFastagInfo.put(vehicleDetail, amount-50) ;  
				   total += 50 ;
				   fastTagAmount += 50 ;
				   totalDiscount += 50 ;
				   
				   if(vehicleCollection.containsKey(vehicleName)) {
					   vehicleCollection.put(vehicleName, vehicleCollection.get(vehicleName)+50);
				   }else {
					   vehicleCollection.put(vehicleName, 50);
				   } 
				   
			   }else {
				   
				   remain = 90 - amount ;
				   total += 90 ;
				   fastTagAmount += amount ;
				   cashAmount += remain  ;
				   totalDiscount += 50 ;
				   
				   if(vehicleCollection.containsKey(vehicleName)) {
					   vehicleCollection.put(vehicleName, vehicleCollection.get(vehicleName)+90);
				   }else {
					   vehicleCollection.put(vehicleName, 90);
				   }
			   }
			   
			   
		   }else {
			   vehicleJourneyInfo.put(vehicleDetail,1) ;
			   
			   
			   if(amount>=100) {
				   vehicleFastagInfo.put(vehicleDetail, amount -100) ;
				   total += 100 ;
				   fastTagAmount +=100 ;
				   
				   if(vehicleCollection.containsKey(vehicleName)) {
					   vehicleCollection.put(vehicleName, vehicleCollection.get(vehicleName)+100);
				   }else {
					   vehicleCollection.put(vehicleName, 100);
				   }
				   
			   }else {
				    remain = 140 - amount ;
				   vehicleFastagInfo.put(vehicleDetail, 0) ;
				   total += 100 + 40 ;
				   fastTagAmount += amount ;
				   cashAmount += remain  ;
				   
				   if(vehicleCollection.containsKey(vehicleName)) {
					   vehicleCollection.put(vehicleName, vehicleCollection.get(vehicleName)+140);
				   }else {
					   vehicleCollection.put(vehicleName, 140);
				   }
			   }
			   
		   }
		
	}
	
	
	
	public void tollCollectionForHeavyFourWheelVehicle(HashMap<String , Integer> vehicleJourneyInfo,String vehicleDetail,String vehicleName ,HashMap<String ,Integer> vehicleFastagInfo
			,HashMap<String ,Integer > vehicleCollection,int total ,int totalDiscount,int fastTagAmount,int cashAmount, int amount ,int remain) {
		
		 if(vehicleJourneyInfo.containsKey(vehicleDetail)) {
			   
         	vehicleJourneyInfo.remove(vehicleDetail);
 			   
 			   if(amount >=100) {
 				   
 				   vehicleFastagInfo.put(vehicleDetail, amount-100) ;  
 				   total += 100 ;
 				   fastTagAmount += 100 ;
 				   totalDiscount += 100 ;
 				   
 				   if(vehicleCollection.containsKey(vehicleName)) {
 					   vehicleCollection.put(vehicleName, vehicleCollection.get(vehicleName)+100);
 				   }else {
 					   vehicleCollection.put(vehicleName, 100);
 				   }
 				   
 			   }else {
 				   
 				   remain = 140 - amount ;
 				   total += 140 ;
 				   fastTagAmount += amount ;
 				   cashAmount += remain  ;
 				   totalDiscount += 100 ;
 				   
 				   if(vehicleCollection.containsKey(vehicleName)) {
 					   vehicleCollection.put(vehicleName, vehicleCollection.get(vehicleName)+140);
 				   }else {
 					   vehicleCollection.put(vehicleName, 140);
 				   }
 			   }
		   
		   
	   }else {
			   vehicleJourneyInfo.put(vehicleDetail,1) ;
			   
			   
			   if(amount>=200) {
				   vehicleFastagInfo.put(vehicleDetail, amount -200) ;
				   total += 200 ;
				   fastTagAmount +=200 ;
				   
				   if(vehicleCollection.containsKey(vehicleName)) {
					   vehicleCollection.put(vehicleName, vehicleCollection.get(vehicleName)+200);
				   }else {
					   vehicleCollection.put(vehicleName, 200);
				   }
				   
			   }else {
				    remain = 240 - amount ;
				   vehicleFastagInfo.put(vehicleDetail, 0) ;
				   total += 240  ;
				   fastTagAmount += amount ;
				   cashAmount += remain  ;
				   if(vehicleCollection.containsKey(vehicleName)) {
					   vehicleCollection.put(vehicleName, vehicleCollection.get(vehicleName)+240);
				   }else {
					   vehicleCollection.put(vehicleName, 240);
				   }
			   }
		   
	   }
	}
	
	
	public void tollCollectionForTwoWheelVehicle(HashMap<String , Integer> vehicleJourneyInfo,String vehicleDetail,String vehicleName ,HashMap<String ,Integer> vehicleFastagInfo
			,HashMap<String ,Integer > vehicleCollection,int total ,int totalDiscount,int fastTagAmount,int cashAmount, int amount ,int remain) {
		
		
		if(vehicleJourneyInfo.containsKey(vehicleDetail)) {
			   
     	   vehicleJourneyInfo.remove(vehicleDetail);
 			   
 			   if(amount >=25) {
 				   
 				   vehicleFastagInfo.put(vehicleDetail, amount-25) ;  
 				   total += 25 ;
 				   fastTagAmount += 25 ;
 				   totalDiscount += 25 ;
 				   
 				   if(vehicleCollection.containsKey(vehicleName)) {
 					   vehicleCollection.put(vehicleName, vehicleCollection.get(vehicleName)+25);
 				   }else {
 					   vehicleCollection.put(vehicleName, 25);
 				   }
 				   
 			   }else {
 				   
 				   remain = 75 - amount ;
 				   total += 75 ;
 				   fastTagAmount += amount ;
 				   cashAmount += remain  ;
 				   totalDiscount += 25 ;
 				   
 				   if(vehicleCollection.containsKey(vehicleName)) {
 					   vehicleCollection.put(vehicleName, vehicleCollection.get(vehicleName)+75);
 				   }else {
 					   vehicleCollection.put(vehicleName, 75);
 				   }
 			   }
		   

		      }else {
     			   vehicleJourneyInfo.put(vehicleDetail,1) ;
     			   
     			   
     			   if(amount>=50) {
     				   vehicleFastagInfo.put(vehicleDetail, amount -50) ;
     				   total += 50 ;
     				   fastTagAmount +=50 ;
     				   
     				   if(vehicleCollection.containsKey(vehicleName)) {
     					   vehicleCollection.put(vehicleName, vehicleCollection.get(vehicleName)+50);
     				   }else {
     					   vehicleCollection.put(vehicleName, 50);
     				   }
     			   }else {
     				    remain = 90 - amount ;
     				   vehicleFastagInfo.put(vehicleDetail, 0) ;
     				   total += 90 ;
     				   fastTagAmount += amount ;
     				   cashAmount += remain  ;
     				   
     				   if(vehicleCollection.containsKey(vehicleName)) {
     					   vehicleCollection.put(vehicleName, vehicleCollection.get(vehicleName)+90);
     				   }else {
     					   vehicleCollection.put(vehicleName, 90);
     				   }
     			   }
			   
		            }
	}

}
