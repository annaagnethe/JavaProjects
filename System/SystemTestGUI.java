/**
 * Programme with GUI interface 
 * menu to set and display
 * specifications of any computer
 * 
 * author: Anna A S Back
 * version: 21032020
 *
 */

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene; 
import javafx.scene.control.Button; 
import javafx.scene.control.Label; 
import javafx.scene.control.TextArea; 
import javafx.scene.control.TextField; 
import javafx.scene.layout.HBox; 
import javafx.scene.layout.VBox; 
import javafx.scene.paint.Color; 
import javafx.scene.text.Font; 
import javafx.stage.Stage; 

public class SystemTestGUI extends Application
{
	//creating System class object to later call methods
	private System testSystem = new System("Apple","Macbook Pro 2019",3900);
	
	//declare scenes for later use
	Scene startScene, setDetailsScene, viewDetailsScene, overallPictureScene; 

	@Override
	public void start(Stage stage)
	{
		//create text fields for user inputs
		TextField memorySizeField = new TextField();         
		memorySizeField.setMaxWidth(50);         
		TextField hardDiskSizeField = new TextField();         
		hardDiskSizeField.setMaxWidth(50); 
		TextField purchaseCostField = new TextField();         
		purchaseCostField.setMaxWidth(50); 
		
		// create and configure labels for each text field      
		Label memorySizeLabel = new Label("Memory Size");         
		memorySizeLabel.setTextFill(Color.BLACK);         
		memorySizeLabel.setFont(Font.font("Calibri", 12));         
		Label hardDiskSizeLabel= new Label("Hard Disk Size");         
		hardDiskSizeLabel.setTextFill(Color.BLACK);         
		hardDiskSizeLabel.setFont(Font.font("Calibri", 12));
		Label purchaseCostLabel = new Label("Purchase Cost");         
		purchaseCostLabel.setTextFill(Color.BLACK);         
		purchaseCostLabel.setFont(Font.font("Calibri", 12));
		
		// create text areas to display any results for each scene     
		TextArea display1 = new TextArea();        
		display1.setEditable(false);         
		display1.setMinSize(210,50);         
		display1.setMaxSize(400,50); 
		
		TextArea display2 = new TextArea();        
		display2.setEditable(false);         
		display2.setMinSize(210,50);         
		display2.setMaxSize(400,125); 
		
		//create any labels needed throughout 
		Label promptSetDets = new Label("Please start by providing any missing details");
		Label labelSetDetails = new Label("Please insert missing values below and click the button below when ready \nYou can come back and change these values at any time");
		Label promptViewDetails = new Label("Then view system properties separately");
		Label viewDetailsSeparately = new Label("Here you can view each property one at a time");
		Label promptOverview = new Label("Or get a quick overview");
		Label overviewLabel = new Label("Here you have different options to get an overview of your system");
		Label promptExit = new Label("When you're done...");
		
		//create button to open 'set details' window
		Button setDetailsButton = new Button();         
		setDetailsButton.setText("Set missing details");        				
		setDetailsButton.setOnAction( e -> stage.setScene(setDetailsScene));
		
		//create button to open 'set details' window
		Button viewDetailsButton = new Button();         
		viewDetailsButton.setText("View details separarately");        				
		viewDetailsButton.setOnAction( e -> stage.setScene(viewDetailsScene));
		
		//create button to open 'set details' window
		Button overviewButton = new Button();         
		overviewButton.setText("System overview");        				
		overviewButton.setOnAction( e -> stage.setScene(overallPictureScene));
		
		//create set button for set details scene that returns to 'start scene'
		Button setButton = new Button();
		setButton.setText("Set"); 
		setButton.setOnAction(e -> stage.setScene(startScene));
				
		//create buttons to return to 'start' scene for the two remaining scenes
		Button backButton1 = new Button();
		backButton1.setText("Back to menu"); 
		backButton1.setOnAction(e -> stage.setScene(startScene));
		
		Button backButton2 = new Button();
		backButton2.setText("Back to menu"); 
		backButton2.setOnAction(e -> stage.setScene(startScene));
		
		//create button to exit programme
		Button exitButton = new Button();
		exitButton.setText("Exit program"); 
		exitButton.setOnAction(e -> stage.close());
		
		//create button for getMake() method
		Button getMakeButton = new Button();         
		getMakeButton.setText("View Make");        				
		getMakeButton.setOnAction( e ->                     
							{    
								//import method from System class
								display1.setText(testSystem.getMake());                                                                  
								}                                     
							);
		
		//create button for getModel() method
		Button getModelButton = new Button();         
		getModelButton.setText("View Model");        				
		getModelButton.setOnAction( e ->                     
							{    
								//import method from System class
								display1.setText(testSystem.getModel());                                                                  
								}                                     
							);
		
		//create button for getProcessorSpeed() method
		Button getProcessorSpeedButton = new Button();         
		getProcessorSpeedButton.setText("View Processor Speed");        				
		getProcessorSpeedButton.setOnAction( e ->                     
							{    
								//import method from System class 
								//convert integer to string to display result
								display1.setText(Integer.toString(testSystem.getProcessorSpeed()) + " MHz");                                                                  
								}                                     
							);
		
		
		// create display details button          
			Button displayDetailsButton = new Button();         
			displayDetailsButton.setText("Display Details");        				
			displayDetailsButton.setOnAction( e ->                     
			{
				//check if fields are empty
				if(memorySizeField.getText().isEmpty()||hardDiskSizeField.getText().isEmpty() || purchaseCostField.getText().isEmpty() )
				{
					//prompt user to set missing details
					display2.setText("Make sure you have set your missing details!");
				}
				else {
				//return all details of system as string
				// create string
				String systemDetails;
				//convert text input to integer and doubles to ensure they can be called in our System class methods
				testSystem.setMemory(Integer.parseInt(memorySizeField.getText()));
				testSystem.setHardDisk(Double.parseDouble(hardDiskSizeField.getText()));
				testSystem.setPurchaseCost(Double.parseDouble(purchaseCostField.getText()));
				//piece together string with all system details
				systemDetails = "Make = " + testSystem.make +"\nModel = " + testSystem.model + "\nProcessor Speed = " + testSystem.speed + " MHz" + "\nMemory Size = " + testSystem.memorySize 
						+ " MB" + "\nHard Disk Size = " + testSystem.hardDiskSize + " GB" + "\nPrice = " + testSystem.purchaseCost;
				//return string
				display2.setText(systemDetails);
				}
			}                                  
								); 			
			
			//create display system properties button
			Button displaySystemPropertiesButton = new Button();         
			displaySystemPropertiesButton.setText("Display System Properties");        				
			displaySystemPropertiesButton.setOnAction( e ->                     
			{
				//create strings for final output and for individual message
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
				display2.setText(systemProperties);
			}                                     
								);
			
			
			//create check HD status button
			Button checkHDStatusButton = new Button();         
			checkHDStatusButton.setText("Check Hard Drive Status");        				
			checkHDStatusButton.setOnAction( e ->                     
			{
				//convert string (user input) to a number that is comparable
				double hardDiskSizeTemp = Double.parseDouble(hardDiskSizeField.getText());
				
				//check if value has been entered
				if (hardDiskSizeField.getText().isEmpty())
				{
					//prompt user to set missing details
					display1.setText("Make sure you have set your missing details!");
				}
				//check hard disk size
				//if below 2 GB return "low"
				else if (hardDiskSizeTemp < 2)
			    {
					display1.setText("Hard drive status = low");
				}
				//if 2 or above return "OK"
				else
				{
					display1.setText("Hard drive status = OK");
				}
			}                                    
					);
			
			//create good memory size button
			Button goodMemorySizeButton = new Button();         
			goodMemorySizeButton.setText("Check Good Memory");        				
			goodMemorySizeButton.setOnAction( e ->                     
			{
				//convert string (user input) to a number that is comparable
				int memorySizeTemp = Integer.parseInt(memorySizeField.getText());
				
				//check if value has been entered
				if (memorySizeField.getText().isEmpty())
				{
					//prompt user to set missing details
					display1.setText("Make sure you have set your missing details!");
				}
			
				//check if ram memory size is below 128 GB
				//if yes return true
				else if (memorySizeTemp >= 128)
				{
					display1.setText("Good memory size = " + true);
				}
				//if false return false
				else display1.setText("Good memory size = " + false);
			}                                   
								);
			
			//create diagnose system button
			Button diagnoseSystemButton = new Button();         
			diagnoseSystemButton.setText("Diagnose System");        				
			diagnoseSystemButton.setOnAction( e ->                     
			{
				//check if values have been entered
				if (memorySizeField.getText().isEmpty()||hardDiskSizeField.getText().isEmpty())
				{
					//prompt user to set missing details
					display1.setText("Make sure you have set your missing details!");
				}
				//return checkHDStatus() and goodMemorySize() values as strings
				//create string
				else {
					String systemDiagnosis;

					//set string values
					systemDiagnosis = "Hard disk size = " + testSystem.checkHDStatus() +"\nMemory size OK = " + testSystem.goodMemorySize();
					//return string
					display2.setText(systemDiagnosis);
				}
			}                                
								);
				
		// create horizontal box to hold get buttons
		HBox getBox = new HBox(20);         
		getBox.setAlignment(Pos.BASELINE_CENTER);        
		getBox.getChildren().addAll(getMakeButton, getModelButton, getProcessorSpeedButton); 
		
		// create horizontal box to hold display details/properties buttons
		HBox displayDetailsBox = new HBox(25);         
		displayDetailsBox.setAlignment(Pos.CENTER);        
		displayDetailsBox.getChildren().addAll(displayDetailsButton, displaySystemPropertiesButton); 
			
		// create and configure a vertical container to hold all the components         
		VBox root = new VBox(25);         
		root.setAlignment(Pos.CENTER);        
		root.getChildren().addAll(promptSetDets, setDetailsButton, promptViewDetails, viewDetailsButton, promptOverview, overviewButton, promptExit, exitButton); 
					
		
		// add start scene to the stage         			
		startScene = new Scene(root, 300, 400);         
		stage.setScene(startScene);         
		stage.setTitle("System");        
		stage.show(); 
		
				
		// 'set details' create HBox for the user text inputs                       
		HBox setDetailsBox = new HBox(10);
		setDetailsBox.setAlignment(Pos.CENTER);        
		setDetailsBox.getChildren().addAll(memorySizeLabel, memorySizeField, hardDiskSizeLabel, hardDiskSizeField, purchaseCostLabel, purchaseCostField);  
				
		// 'set details' create vbox to hold all components
		VBox setSceneRoot = new VBox(20);
		setSceneRoot.setAlignment(Pos.CENTER);
		setSceneRoot.getChildren().addAll(labelSetDetails, setDetailsBox, setButton);
		
		// 'set details' set size of scene
		setDetailsScene = new Scene(setSceneRoot,500,200); 
		
		// 'separately view details' create box                        
		HBox HDMemoryBox = new HBox(10);
		HDMemoryBox.setAlignment(Pos.CENTER);        
		HDMemoryBox.getChildren().addAll(checkHDStatusButton, goodMemorySizeButton);  
		
		// 'separately view details' create box to hold all components
		VBox viewDetailsRoot = new VBox(20);
		viewDetailsRoot.setAlignment(Pos.CENTER);
		viewDetailsRoot.getChildren().addAll(viewDetailsSeparately, getBox, HDMemoryBox, display1, backButton1);
		
		// 'separately view details' set size of scene
		viewDetailsScene = new Scene(viewDetailsRoot,450,300); 
				
		// 'overview of details' create box to hold all components
		VBox overallPictureRoot = new VBox(20);
		overallPictureRoot.setAlignment(Pos.CENTER);
		overallPictureRoot.getChildren().addAll(overviewLabel, displayDetailsBox, diagnoseSystemButton, display2, backButton2);
						
		// 'overview of details' set size of scene
		overallPictureScene = new Scene(overallPictureRoot,500,350); 
					
				
	}
  
	
	
	public static void main(String[] args) 
	{
		launch(args);
	}
	
	
}
