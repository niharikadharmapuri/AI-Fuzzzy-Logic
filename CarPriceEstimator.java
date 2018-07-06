// alias: Jasmine
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import nrc.fuzzy.*;

public class CarPriceEstimator {
	
	public static void main(String args[]) throws FuzzyException, IOException
	{
		
		RightLinearFunction rlf = new RightLinearFunction();
		LeftLinearFunction llf = new LeftLinearFunction();
		FuzzyValue car=null;
		FuzzyValueVector fvv = null;
		
		FuzzyVariable carAge = new FuzzyVariable("carAge",0.0,10.0, "Car Age");
		  carAge.addTerm("Old", new LFuzzySet(0.0,4.0,llf));
		  carAge.addTerm("Average", new TriangleFuzzySet(4.0,6.0,7.0));	 
		  carAge.addTerm("New", new RFuzzySet(7.0, 10.0,rlf));  
		 System.out.println(carAge);
		  
		  
		  FuzzyVariable mileage = new FuzzyVariable("mileage",0.0,10.0, "Car mileage");
		  mileage.addTerm("Low", new LFuzzySet(0.0,4.0,llf));
		  mileage.addTerm("Medium", new TriangleFuzzySet(4.0,6.0,7.0));
		  mileage.addTerm("High", new RFuzzySet(7.0, 10.0,rlf));    
		 // System.out.println(mileage);
		  
		  FuzzyVariable features = new FuzzyVariable("features",0.0,10.0, "Car Features");
		  features.addTerm("Light", new LFuzzySet(0.0,4.0,llf));
		  features.addTerm("Average", new TriangleFuzzySet(4.0,6.0,7.0));	 
		  features.addTerm("Heavy", new RFuzzySet(7.0, 10.0,rlf));  
		  //System.out.println(features);
		  
		  FuzzyVariable price = new FuzzyVariable("price",0.0,10.0, "Possible price of car");
		  price.addTerm("Low", new LFuzzySet(0.0,4.0,llf));
		  price.addTerm("Medium", new TriangleFuzzySet(4.0,6.0,7.0));
		  price.addTerm("High", new RFuzzySet(7.0, 10.0,rlf));  
		 // System.out.println(price);


		  FuzzyRule rul[] = new FuzzyRule[30];
			 int i = 0;
			 rul[i] = new FuzzyRule();
			 rul[i].addAntecedent(new FuzzyValue(carAge,"New"));
			 rul[i].addAntecedent(new FuzzyValue(mileage,"Low"));
			 rul[i].addAntecedent(new FuzzyValue(features,"Light"));
			 rul[i++].addConclusion(new FuzzyValue(price,"Low"));
			 
			 rul[i] = new FuzzyRule();
			 rul[i].addAntecedent(new FuzzyValue(carAge,"New"));
			 rul[i].addAntecedent(new FuzzyValue(mileage,"Low"));
			 rul[i].addAntecedent(new FuzzyValue(features,"Average"));
			 rul[i++].addConclusion(new FuzzyValue(price,"Medium"));
			 
			 rul[i] = new FuzzyRule();
			 rul[i].addAntecedent(new FuzzyValue(carAge,"New"));
			 rul[i].addAntecedent(new FuzzyValue(mileage,"Low"));
			 rul[i].addAntecedent(new FuzzyValue(features,"Heavy"));
			 rul[i++].addConclusion(new FuzzyValue(price,"High"));
			 
			 rul[i] = new FuzzyRule();
			 rul[i].addAntecedent(new FuzzyValue(carAge,"New"));
			 rul[i].addAntecedent(new FuzzyValue(mileage,"Medium"));
			 rul[i].addAntecedent(new FuzzyValue(features,"Heavy"));
			 rul[i++].addConclusion(new FuzzyValue(price,"High"));
			 
			 rul[i] = new FuzzyRule();
			 rul[i].addAntecedent(new FuzzyValue(carAge,"New"));
			 rul[i].addAntecedent(new FuzzyValue(mileage,"Medium"));
			 rul[i].addAntecedent(new FuzzyValue(features,"Light"));
			 rul[i++].addConclusion(new FuzzyValue(price,"Low"));
			 
			 rul[i] = new FuzzyRule();
			 rul[i].addAntecedent(new FuzzyValue(carAge,"New"));
			 rul[i].addAntecedent(new FuzzyValue(mileage,"Medium"));
			 rul[i].addAntecedent(new FuzzyValue(features,"Average"));
			 rul[i++].addConclusion(new FuzzyValue(price,"Medium"));
			 
			 rul[i] = new FuzzyRule();
			 rul[i].addAntecedent(new FuzzyValue(carAge,"New"));
			 rul[i].addAntecedent(new FuzzyValue(mileage,"High"));
			 rul[i].addAntecedent(new FuzzyValue(features,"Average"));
			 rul[i++].addConclusion(new FuzzyValue(price,"Low"));
			 
			 rul[i] = new FuzzyRule();
			 rul[i].addAntecedent(new FuzzyValue(carAge,"New"));
			 rul[i].addAntecedent(new FuzzyValue(mileage,"High"));
			 rul[i].addAntecedent(new FuzzyValue(features,"Light"));
			 rul[i++].addConclusion(new FuzzyValue(price,"Low"));
			 
			 rul[i] = new FuzzyRule();
			 rul[i].addAntecedent(new FuzzyValue(carAge,"New"));
			 rul[i].addAntecedent(new FuzzyValue(mileage,"High"));
			 rul[i].addAntecedent(new FuzzyValue(features,"Heavy"));
			 rul[i++].addConclusion(new FuzzyValue(price,"Medium"));
		  
		  
			 rul[i] = new FuzzyRule();
			 rul[i].addAntecedent(new FuzzyValue(carAge,"Average"));
			 rul[i].addAntecedent(new FuzzyValue(mileage,"Medium"));
			 rul[i].addAntecedent(new FuzzyValue(features,"Heavy"));
			 rul[i++].addConclusion(new FuzzyValue(price,"Medium"));
			 
			 rul[i] = new FuzzyRule();
			 rul[i].addAntecedent(new FuzzyValue(carAge,"Average"));
			 rul[i].addAntecedent(new FuzzyValue(mileage,"Medium"));
			 rul[i].addAntecedent(new FuzzyValue(features,"Average"));
			 rul[i++].addConclusion(new FuzzyValue(price,"Medium"));
			 
			 rul[i] = new FuzzyRule();
			 rul[i].addAntecedent(new FuzzyValue(carAge,"Average"));
			 rul[i].addAntecedent(new FuzzyValue(mileage,"Medium"));
			 rul[i].addAntecedent(new FuzzyValue(features,"Light"));
			 rul[i++].addConclusion(new FuzzyValue(price,"Low"));

			 rul[i] = new FuzzyRule();
			 rul[i].addAntecedent(new FuzzyValue(carAge,"Average"));
			 rul[i].addAntecedent(new FuzzyValue(mileage,"Low"));
			 rul[i].addAntecedent(new FuzzyValue(features,"Light"));
			 rul[i++].addConclusion(new FuzzyValue(price,"Medium"));
			 
			 rul[i] = new FuzzyRule();
			 rul[i].addAntecedent(new FuzzyValue(carAge,"Average"));
			 rul[i].addAntecedent(new FuzzyValue(mileage,"Low"));
			 rul[i].addAntecedent(new FuzzyValue(features,"Average"));
			 rul[i++].addConclusion(new FuzzyValue(price,"Medium"));
			 
			 rul[i] = new FuzzyRule();
			 rul[i].addAntecedent(new FuzzyValue(carAge,"Average"));
			 rul[i].addAntecedent(new FuzzyValue(mileage,"Low"));
			 rul[i].addAntecedent(new FuzzyValue(features,"Heavy"));
			 rul[i++].addConclusion(new FuzzyValue(price,"High"));
			 
			 rul[i] = new FuzzyRule();
			 rul[i].addAntecedent(new FuzzyValue(carAge,"Average"));
			 rul[i].addAntecedent(new FuzzyValue(mileage,"High"));
			 rul[i].addAntecedent(new FuzzyValue(features,"Heavy"));
			 rul[i++].addConclusion(new FuzzyValue(price,"Medium"));
			 
			 rul[i] = new FuzzyRule();
			 rul[i].addAntecedent(new FuzzyValue(carAge,"Average"));
			 rul[i].addAntecedent(new FuzzyValue(mileage,"High"));
			 rul[i].addAntecedent(new FuzzyValue(features,"Light"));
			 rul[i++].addConclusion(new FuzzyValue(price,"Low"));
			 
			 rul[i] = new FuzzyRule();
			 rul[i].addAntecedent(new FuzzyValue(carAge,"Average"));
			 rul[i].addAntecedent(new FuzzyValue(mileage,"High"));
			 rul[i].addAntecedent(new FuzzyValue(features,"Average"));
			 rul[i++].addConclusion(new FuzzyValue(price,"Low"));
			 
			 rul[i] = new FuzzyRule();
			 rul[i].addAntecedent(new FuzzyValue(carAge,"Old"));
			 rul[i].addAntecedent(new FuzzyValue(mileage,"High"));
			 rul[i].addAntecedent(new FuzzyValue(features,"Average"));
			 rul[i++].addConclusion(new FuzzyValue(price,"Medium"));
			
			 rul[i] = new FuzzyRule();
			 rul[i].addAntecedent(new FuzzyValue(carAge,"Old"));
			 rul[i].addAntecedent(new FuzzyValue(mileage,"High"));
			 rul[i].addAntecedent(new FuzzyValue(features,"Light"));
			 rul[i++].addConclusion(new FuzzyValue(price,"Low"));
			 
			 rul[i] = new FuzzyRule();
			 rul[i].addAntecedent(new FuzzyValue(carAge,"Old"));
			 rul[i].addAntecedent(new FuzzyValue(mileage,"High"));
			 rul[i].addAntecedent(new FuzzyValue(features,"Heavy"));
			 rul[i++].addConclusion(new FuzzyValue(price,"Medium"));
			 
			 rul[i] = new FuzzyRule();
			 rul[i].addAntecedent(new FuzzyValue(carAge,"Old"));
			 rul[i].addAntecedent(new FuzzyValue(mileage,"Low"));
			 rul[i].addAntecedent(new FuzzyValue(features,"Heavy"));
			 rul[i++].addConclusion(new FuzzyValue(price,"Medium"));
			 
			 rul[i] = new FuzzyRule();
			 rul[i].addAntecedent(new FuzzyValue(carAge,"Old"));
			 rul[i].addAntecedent(new FuzzyValue(mileage,"Low"));
			 rul[i].addAntecedent(new FuzzyValue(features,"Average"));
			 rul[i++].addConclusion(new FuzzyValue(price,"Medium"));
			 
			 rul[i] = new FuzzyRule();
			 rul[i].addAntecedent(new FuzzyValue(carAge,"Old"));
			 rul[i].addAntecedent(new FuzzyValue(mileage,"Low"));
			 rul[i].addAntecedent(new FuzzyValue(features,"Light"));
			 rul[i++].addConclusion(new FuzzyValue(price,"Low"));
			
			 rul[i] = new FuzzyRule();
			 rul[i].addAntecedent(new FuzzyValue(carAge,"Old"));
			 rul[i].addAntecedent(new FuzzyValue(mileage,"Medium"));
			 rul[i].addAntecedent(new FuzzyValue(features,"Heavy"));
			 rul[i++].addConclusion(new FuzzyValue(price,"Medium"));
			 
			 rul[i] = new FuzzyRule();
			 rul[i].addAntecedent(new FuzzyValue(carAge,"Old"));
			 rul[i].addAntecedent(new FuzzyValue(mileage,"Medium"));
			 rul[i].addAntecedent(new FuzzyValue(features,"Average"));
			 rul[i++].addConclusion(new FuzzyValue(price,"Medium"));
			 
			 
			 rul[i] = new FuzzyRule();
			 rul[i].addAntecedent(new FuzzyValue(carAge,"Old"));
			 rul[i].addAntecedent(new FuzzyValue(mileage,"Medium"));
			 rul[i].addAntecedent(new FuzzyValue(features,"light"));
			 rul[i++].addConclusion(new FuzzyValue(price,"Low"));
			 
			 
			 
			 
			 

			 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
				double vType,vType2,vType3;
					System.out.println("Please enter Car Age- a number from 0.0 to 10.0");
				  	System.out.println("0.0-4.0 => Old :: 4.0-7.0 => Average :: 7.0-10.0 => New");
				  	vType= Double.parseDouble(br.readLine());
				  	
				  	System.out.println("Please enter Car mileage-a number from 0.0 to 10.0");
				  	System.out.println("0.0-4.0 =>Low  :: 4.0-7.0 => Medium :: 7.0-10.0 =>High ");
				  	vType2= Double.parseDouble(br.readLine());
	

				  	System.out.println("Please enter Car Features-a number from 0.0 to 10.0");
				  	System.out.println("0.0-4.0 =>Light :: 4.0-7.0 => Average :: 7.0-10.0 => Heavy");
				  	vType3= Double.parseDouble(br.readLine());
	
					

			     FuzzyValue vfType =  new FuzzyValue(carAge, new TriangleFuzzySet((vType-2.5)>0.0?vType-2.5:vType, 
			    		 vType, (vType+2.5)<10.0?vType+2.5:vType));
			
			     FuzzyValue vfType2 =  new FuzzyValue(mileage, new TriangleFuzzySet((vType2-2.5)>0.0?vType2-2.5:vType2,
			    		 vType2, (vType2+2.5)<10.0?vType2+2.5:vType2));
			     
			     FuzzyValue vfType3 =  new FuzzyValue(features, new TriangleFuzzySet((vType3-2.5)>0.0?vType3-2.5:vType3,
			    		 vType3, (vType3+2.5)<10.0?vType3+2.5:vType3));
			     
			     
		     for(int j=0;j<i;j++)
		    	 rul[j].removeAllInputs();
			
	

		     int rule = 0; 
		     for(int j=0;j<i;j++)
		     {
		    	 rul[j].addInput(vfType);
		    	 rul[j].addInput(vfType2);
		    	 rul[j].addInput(vfType3);
		    	 rule=j;
		    	 
		    	 if (rul[j].testRuleMatching())
		    	 {
		    		 fvv = rul[j].execute();
		    		 if (car == null)
		    			 car = fvv.fuzzyValueAt(0);
		    		 else
		    			 car = car.fuzzyUnion(fvv.fuzzyValueAt(0));
		    	 }
		     }
		  
		     
		     double growthVal = car.momentDefuzzify();
		     System.out.println("\nSummary:\n\n" + rul[rule].getConclusions());
		   //  System.out.println("\nRate of price value is : " +
		   // 		 growthVal+ "");
		     System.out.println("\nRESULT");
		   
		     if(growthVal>0.0&&growthVal<4.0)
		     {
		    	 System.out.println("The price will be Low");
		     }
		     else  if(growthVal>4.0&&growthVal<5.5)
		     {
		    	 System.out.println("The price will be Medium");
		    	 }
		     else  if(growthVal>5.50&&growthVal<10.0)
		     {
		    	 System.out.println("The price will be High");}
		     
		   
		    
		  
		
	}
}
