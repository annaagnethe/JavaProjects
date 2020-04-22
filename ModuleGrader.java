/*
 * Programme that returns grade 
 * received for a particular module
 */


import java.util.Scanner;

public class ModuleGrader {
		
		Scanner sc = new Scanner(System.in);
		double markReceived; // to store mark received
		String finalMark; // final mark
	
		public void startModuleGrading()
		{
			
		char reply;
		System.out.println("***** Module Grading Program *****");
		
		do
			{	
			// method to get input from user
			getValidMark();
			// method to grade the module
			gradeModule();

			System.out.println("Your final mark for this module is = " + markReceived + ", " + finalMark );
			
			// ask user if he/she would like to continue grading
			System.out.println("\nWould you like to check another grade? (y/n)");
			reply = sc.next().charAt(0);
			
			} while ((reply == 'y') || (reply == 'Y'));
			
			
		}
		
		public void getValidMark()
		{
			// prompt for user to input mark
			System.out.println("Please insert the mark received for this module");
			markReceived = sc.nextDouble();
			// checking that it's a valid mark 0-100
			while ((markReceived > 100) || (markReceived < 0))
			{
				// re-enter mark
				System.out.println("Please make sure you insert a valid mark (0-100)");
				markReceived = sc.nextDouble();
			}
		}
		
		public void gradeModule()
		{
			// grading modules correctly according to university guidelines
			if (markReceived >= 70)
			{
			//assigning string to right variable to present result with
			finalMark = "Excellent";
			}
			
			else if ((markReceived >= 60) && (markReceived < 70))
			{
			finalMark = "Good";
			}
				
			else if ((markReceived >= 50) && (markReceived < 60))
			{
			finalMark = "Satisfactory";
			}
			
			else if ((markReceived >= 40) && (markReceived < 50))
			{
			finalMark = "Compensatable fail";
			}
			
			else
			{
			finalMark = "Outright fail";
					}
				
		}
}
