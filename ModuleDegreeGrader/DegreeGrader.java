/*
 * Programme that returns a 
 * masters degree classification
 * based on user inputs
 *
 * author: Anna A S Back
 * version: 14032020
 */

import java.util.Scanner;
public class DegreeGrader {

    Scanner sc = new Scanner(System.in);

    double avgModule; // to hold average module mark
    double avgISM; // to hold average independent study module mark
    double compFailedCred; // to hold number of comp failed credits
    int failedModules; // to hold number of outright failed modules
    String degreeClass = ""; //setting string to a default


    public void startDegreeGrading() {
        char reply;

        System.out.println("***** Degree Classification Program *****");

        do {
            // method to prompt user for details about degree 
            promptDetails();
            // method to calculate final classification with parameters
            gradeDegree(avgModule, avgISM, compFailedCred, failedModules);
            System.out.println("Degree Classification: " + degreeClass);

            // ask user if he/she would like to have another go
            System.out.println("\nWould you like to check another degree? (y/n)");
            reply = sc.next().charAt(0);
        } while ((reply == 'y') || (reply == 'Y'));
    }

    public void promptDetails() {
        // prompt user for their mean grade for all modules
        System.out.println("Please enter you average grade of all modules: ");
        avgModule = sc.nextDouble();
        // validate user input
        while ((avgModule < 0) || (avgModule > 100)) {
            // if invalid, try again until valid
            System.out.println("Please make sure your input is valid (0-100)");
            avgModule = sc.nextDouble();
        }

        // prompt user for their mean grade for the independent study modules
        System.out.println("Please enter you average grade of your independent study module: ");
        avgISM = sc.nextDouble();
        // validate user input
        while ((avgISM < 0) || (avgISM > 100)) {
            // if invalid, try again until valid
            System.out.println("Please make sure your input is valid (0-100)");
            avgISM = sc.nextDouble();
        }

        // prompt user for number of compensatory failed credits
        System.out.println("Please enter number of compensatory failed credits: ");
        compFailedCred = sc.nextDouble();
        // if invalid, try again until valid
        while ((compFailedCred < 0) || (compFailedCred > 180)) {
            // if not correct, try again
            System.out.println("Please make sure your input is valid (0-180)");
            compFailedCred = sc.nextDouble();
        }

        // prompt user for number of failed modules
        System.out.println("Please enter number of outright failed modules: ");
        failedModules = sc.nextInt();
        // if invalid, try again until valid
        while ((failedModules < 0) || (failedModules > 11)) {
            // if not correct, try again
            System.out.println("Please make sure your input is valid (0-11)");
            failedModules = sc.nextInt();
        }
    }

    public String gradeDegree(double avgModuleIn, double avgISMIn, double compFailedCredIn, int failedModulesIn) {
        // checking for distinction - if all marks are above 70 with no failed modules
        if ((avgModuleIn > 70) && (avgISMIn > 70) && (compFailedCredIn == 0) && (failedModulesIn == 0)) {
            //assigning variable to correct string classification
            degreeClass = "Distinction";
        }

        // checking for merit - if all marks are above 60 with a maximum of one compensatable failed module
        else if ((avgModuleIn > 60) && (avgISMIn > 60) && (compFailedCredIn <= 15) && (failedModulesIn == 0)) {
            degreeClass = "Merit";
        }

        //checking for pass - if all modules are passer (marks above 50) with a maximum of two compensatable failed modules
        else if ((avgModuleIn > 50) && (avgISMIn > 50) && (compFailedCredIn <= 30) && (failedModulesIn == 0)) {
            degreeClass = "Pass";
        }

        //if average mark has been below 50 or there has been more than two compensatable fails or at least one outright failed modules
        else {
            degreeClass = "Fail. No classification will be received.";
        }
        //returning classification
        return degreeClass;

    }

}
