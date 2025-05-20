package Module1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * In this code It take the user Input in the File format
 * If we want to add Any Thing in Income section or expenditure section we can edit the file in respective sections
 * The Aim of the program is to calculate final Monthly summaries and check saving of the month
 * 
 * 
 * **************Thank you****************
 */

public class ExpenseTrackerFileFormat {
	
	
	static HashMap<String,Integer> income=new HashMap<>();
	static HashMap<String,Integer> food=new HashMap<>();
	static HashMap<String,Integer> houseRent=new HashMap<>();
	static HashMap<String,Integer> travel=new HashMap<>();
	static ArrayList<HashMap<String,Integer>> expenditure=new ArrayList<>();
	static int finalAmt=0;
	static int foodAmt=0;
	static int houseAmt=0;
	static int travelAmt=0;
	
	
	public static void main(String[] args) {
		
		System.out.println("****Welcome*****");
		String currentSection="";
		try(BufferedReader br=new BufferedReader(new FileReader("src/expense_tracker.text")))
		{
			
			while(br.ready())
			{
				String line=br.readLine().toLowerCase().trim();
				
				if(line.isEmpty())
					continue;
				
				switch(line)
				{
				case "income details":
				{
					currentSection="income";
					break;
					
				}
				case "expenditure details":
				{
					currentSection="expenditure";
					break;
					
				}
				case "food details":
				{
					currentSection="food";
					break;
					
				}
				case "travel details":
				{
					currentSection="travel";
					break;
					
				}
				case "houserent details":
				{
					currentSection="houserent";
					break;
					
				}
				}
				
				String[] parts=line.split("=");
				
				if(parts.length!=2)
					continue;
				
				
				switch(currentSection)
				{
				case "income":
				{
					income.put(parts[0].trim(),Integer.parseInt(parts[1].trim()));
					finalAmt+=Integer.parseInt(parts[1].trim());
					break;
				}
				case "food":
				{
					food.put(parts[0].trim(),Integer.parseInt(parts[1].trim()));
					foodAmt+=Integer.parseInt(parts[1].trim());
					break;
				}
				case "houserent":
				{
					houseRent.put(parts[0].trim(),Integer.parseInt(parts[1].trim()));
					houseAmt+=Integer.parseInt(parts[1].trim());
					break;
				}
				case "travel":
				{
					travel.put(parts[0].trim(),Integer.parseInt(parts[1].trim()));
					travelAmt+=Integer.parseInt(parts[1].trim());
					break;
				}
				}
				
				
				
				
				
			}
			
			expenditure.add(food);
			expenditure.add(houseRent);
			expenditure.add(travel);
			
			
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
		
		
		System.out.println();
		
		System.out.println("Your Monthly Income details");
		System.out.println();
		
		for(Map.Entry<String, Integer> entry1 : income.entrySet())
		{
			System.out.println(entry1.getKey()+" : "+entry1.getValue());
		}
		
		System.out.println();
		System.out.println("Your Expenditure");
		System.out.println();
		for(int i = 0; i < 3; i++) {
		    HashMap<String, Integer> currentMap = expenditure.get(i);
		    for(Map.Entry<String, Integer> entry : currentMap.entrySet()) {
		        System.out.println(entry.getKey() + " : " + entry.getValue());
		    }
		}
		
		System.out.println();
		
		int ExpAmt=foodAmt+houseAmt+travelAmt;
		int savings=finalAmt-ExpAmt;
		
		System.out.println("***Your Monthly Expenditures***");
		System.out.println();
		System.out.println("Food Expenditures   : "+foodAmt);
		System.out.println("House Expenditures  : "+houseAmt);
		System.out.println("Travel Expenditures : "+travelAmt);
		System.out.println("Total Expenditures  : "+ExpAmt);
		System.out.println();
		if(savings>0)
		{
			System.out.println("congratulations Your saving are "+savings);
		}
		else
		{
			System.out.println("Sorry You are with negative savings "+savings);
		}
		System.out.println();
		
		System.out.println("*******Thank You******");
		System.out.println();
	}

}
