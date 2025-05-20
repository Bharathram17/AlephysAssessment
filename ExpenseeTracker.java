package Module1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



/*
 * This Program take Dynamically user input
 * The Aim of The code is to calculate Monthly summaries includes income expenditures
 * 
 * 
 * Note : To Give the input choose one among income,expenditure and Monthly summary
 * 
 * In income section we can add salary and Business Incomes
 * In expenditure section we can add Food , HouseRent and Travel expenses.
 * Finally in Monthly summaries we can view our monthly expenses we have spent.
 * To exit from code we have exit option.
 * 
 * 
 * ********Thank you**********
 */
public class ExpenseeTracker {
	static Scanner sc=new Scanner(System.in);
	static int finalAmt=0;
	static int ExpAmt=0;
	static HashMap<String,Integer> income=new HashMap<>();
	static ArrayList<HashMap<String,Integer>> expenditure=new ArrayList<>();
	static boolean incomeCheck=true;
	static boolean expCheck=true;
	static int food=0;
	static int travel=0;
	static int house=0;
	
	
	public static void income()
	{
		if(incomeCheck)
		{
			System.out.println("Enter the salary Earned");
			int salary=sc.nextInt();
			finalAmt+=salary;
			income.put("salary",salary);
			
			System.out.println("Enter the Earnings in Business");
			int businessAmt=sc.nextInt();
			finalAmt+=businessAmt;
			income.put("business", businessAmt);
			
			incomeCheck=false;
			
			System.out.println("Your details are recorded Thank you");
		}
		else
		{
			System.out.println("You have already given your income details..\n*******Thank You******");
			System.out.println();
		}
		
	}
	
	public static void expenditure()
	{
		for(int i=0;i<3;i++)
		{
			expenditure.add(new HashMap<String,Integer>());
		}
		
		if(expCheck)
		{
			System.out.println("****food expenditures****");
			for(int i=0;i<3;i++)
			{
				System.out.println("Enter the Food Category Type Like Rice,Vegetables,Groceries....");
				String foodType=sc.next();
				System.out.println("Enter the Expenditure spent");
				int foodExp=sc.nextInt();
				 
				food+=foodExp;
				ExpAmt+=foodExp;
				
				expenditure.get(0).put(foodType, foodExp);
			}
			System.out.println();
			System.out.println("*****House Expenditure*****");
			System.out.println("Enter the House Rent Expenditure");
			house=sc.nextInt();
			ExpAmt+=house;
			
			expenditure.get(1).put("houseRent",house);
			System.out.println();
			System.out.println("******travel Expenditures*****");
		
			for(int i=0;i<3;i++)
			{
				System.out.println("Enter the Travel Category Like Trips ,Emergency ,Business");
				String travelType=sc.next();
				System.out.println("Enter  Amount spent");
				int travelAmt=sc.nextInt();
				travel+=travelAmt;
				ExpAmt+=travelAmt;
			
				expenditure.get(2).put(travelType, travelAmt);
			}
		
			expCheck=false;
		
			System.out.println("Your details are recorded Thank you");
		
		}
		else
		{
			System.out.println("You have already given your expenditure details ..\n*******Thank You******");
			System.out.println();
		}
		
		
	}
	
	public static void monthlySummary()
	{
		
		System.out.println();
		
		System.out.println("Your Incomes");
		System.out.println();
		
		for(Map.Entry<String, Integer> entry1 : income.entrySet())
		{
			System.out.println(entry1.getKey()+" : "+entry1.getValue());
		}
		
		System.out.println();
		System.out.println("Your Expenditures");
		System.out.println();
		for(int i = 0; i < 3; i++) {
		    HashMap<String, Integer> currentMap = expenditure.get(i);
		    for(Map.Entry<String, Integer> entry : currentMap.entrySet()) {
		        System.out.println(entry.getKey() + " : " + entry.getValue());
		    }
		}
		
		System.out.println();
		
		int savings=finalAmt-ExpAmt;
		
		System.out.println("***Your Monthly Expenditures***");
		System.out.println();
		System.out.println("Food Expenditures   : "+food);
		System.out.println("House Expenditures  : "+house);
		System.out.println("Travel Expenditures : "+travel);
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
	
	
	public static void main(String[] args) {
		
		System.out.println("************Welcome*************");
		
		
		boolean stop=true;
		while(stop)
		{
			System.out.println("1.Income\n2.Expenditure\n3.Monthly summary\n4.Exit");
			
			int n=sc.nextInt();
				switch(n)
				{
					case 1:
					{
						income();
						break;
					}
					case 2:
					{
						expenditure();
						break;
					}
					case 3:
					{
						monthlySummary();
						break;
						
					}
					case 4:
					{
						stop=false;
						break;
						
					}
					default:
					{
						System.out.println("Enter a valid choice");
					}
				
				}
		
		}
		
		
		System.out.println("*******Thank You******");
		System.out.println();
		
	}

}
