/**
 * Programme with menu 
 * to set and display
 * specifications of any computer
 * 
 * author: Anna A S Back
 * version: 17032020
 */
import java.util.Scanner;

public class System {
	
	// set class attributes 
	String make; 
	String model;
	int speed; //in MHz
	int memorySize; //in MB
	double hardDiskSize; //in GB
	double purchaseCost;
	Scanner sc = new Scanner(java.lang.System.in); //using java.lang to not confuse with our System class
	

	public System(String makeIn,String modelIn,int speedIn) //constructor
	{
		// take user input for values of attributes
		make = makeIn;
		model = modelIn;
		speed = speedIn;
	}
	
	//get methods to return different attribute values 
	
	public String getMake()
	{
		return make;
	}
	
	public String getModel()
	{
		return model;
	}
	
	public int getProcessorSpeed()
	{
		return speed; 
	}
	
	// set methods to set new values to the different attributes
	
	public void setMemory(int memorySizeIn)
	{
		memorySize = memorySizeIn;
	}
	
	public void setHardDisk(double hardDiskSizeIn)
	{
		hardDiskSize = hardDiskSizeIn;
	}
	
	public void setPurchaseCost(double purchaseCostIn)
	{
		purchaseCost = purchaseCostIn; 
	}
	
	public String displayDetails()
	{
		//all details of system, returned output as string as string
		// create string
		String systemDetails;
		//set string values
		systemDetails = "Make = " + make +"\nModel = " + model + "\nProcessor Speed = " + speed + "MHz" + "\nMemory Size = " + memorySize 
				+ "MB" + "\nHard Disk Size = " + hardDiskSize + "GB" + "\nPrice = " + purchaseCost;
		//return string
		return systemDetails;
	}
	
	public String checkHDStatus()
	{
		//check hard disk size
		//if below 2 GB return "low"
		if (hardDiskSize < 2)
		{
			return "low";
		}
		//if 2 or above return "OK"
		else
		{
			return "OK";
		}
	}
	
	public boolean goodMemorySize()
	{
		//check if ram memory size is below 128 GB
		//if yes return true
		if (memorySize >= 128)
		{
			return true;
		}
		//if false return false
		else return false;
	}
	
	public String diagnoseSystem()
	{
		//return checkHDStatus() and goodMemorySize() values as strings
		//create string
		String systemDiagnosis;
		//set string values
		systemDiagnosis = "Hard disk size = " + checkHDStatus() +"\nMemory size OK = " + goodMemorySize();
		//return string
		return systemDiagnosis;
	}
	
	public String displaySystemProperties()
	{
		//create strings
		String systemProperties;
		String message;
		
		//output if windows 10 a positive message, linux a negative message, other OS a neutral message
		if (java.lang.System.getProperty("os.name").equalsIgnoreCase("Windows 10"))
		{
			message = "The very best operating system!"; //positive message
		}
		else if (java.lang.System.getProperty("os.name").equalsIgnoreCase("Linux"))
		{
			message = "Hmm, you could get a better operating system than that!"; //negative message
		}
		else 
		{
			message = "OK operating system. Could be better, could be worse."; //neutral message
		}
		
		//setting string with all details we want to include
		systemProperties = "Operating System Architecture = " + java.lang.System.getProperty("os.arch") + "\nOperating System Name = " 
				+ java.lang.System.getProperty("os.name") + "\nOperating System Version = " + java.lang.System.getProperty("os.version") 
				+ "\nUser Account Name = " + java.lang.System.getProperty("user.name") + "\nJava Version = " + java.lang.System.getProperty("java.version") + "\n" + message;
		
		//return string 
		return systemProperties;
	}

	public void startMenu()
	{
		java.lang.System.out.println("System Menu");
		int choice; //to hold user input

		// print menu with choices
		java.lang.System.out.println("Choice [1] - Print System Details \nChoice [2] - Display System Properties "
				+ "\nChoice [3] - Diagnose System \nChoice [4] - Set Details \nChoice [5] - Set Purchase Price"
				+ "\nChoice [6] - Check Hard Drive Status \nChoice [7] - Check if Good Memory Size "
				+ "\nChoice [8] - Quit the Program"); 
		java.lang.System.out.println("Please press a number between 1-8"); //prompt for user input
		choice = sc.nextInt(); //take user input
		
		do // do while loop to ensure repetition until user quits
		{
		
			if (choice == 1) //print system details
			{
				java.lang.System.out.println(displayDetails());
			}
			
			else if (choice == 2) //display system properties
			{
				java.lang.System.out.println(displaySystemProperties());
			}
			
			else if (choice == 3) //diagnose system
			{
				java.lang.System.out.println(diagnoseSystem());
			}
			
			else if (choice == 4) //set details
			{
				java.lang.System.out.println("Set Memory Size in MB: "); //prompt for user input
				setMemory(sc.nextInt()); //take user input as method attribute
				java.lang.System.out.println("Set Hard Disk Size in GB: ");
				setHardDisk(sc.nextDouble());
				java.lang.System.out.println("Details set successfully");
			}
			
			else if (choice == 5) //set purchase price
			{
				java.lang.System.out.println("Set Purchase Price in GBP: ");
				setPurchaseCost(sc.nextDouble());
				java.lang.System.out.println("Price set successfully");
			}
			else if (choice == 6) //check hard drive status only
			{
				java.lang.System.out.println("Hard drive status = " + checkHDStatus());
			}
			
			else if (choice == 7) // check memory size only
			{
				java.lang.System.out.println("Memory size = " + goodMemorySize());
			}
			
			// wrong user input
			else java.lang.System.out.println("Please press a number between 1-8 only");
			
			//repeat menu and take another user input
			java.lang.System.out.println();
			java.lang.System.out.println("Choice [1] - Print System Details \nChoice [2] - Display System Properties "
					+ "\nChoice [3] - Diagnose System \nChoice [4] - Set Details \nChoice [5] - Set Purchase Price"
					+ "\nChoice [6] - Check Hard Drive Status \nChoice [7] - Check if Good Memory Size "
					+ "\nChoice [8] - Quit the Program"); 
			java.lang.System.out.println("Please press a number between 1-8"); //prompt for user input
			choice = sc.nextInt();
			
		} while (choice!=8); //program exits if input is 8
	}
}	
