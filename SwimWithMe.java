/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assignment;
/**
 *
 * @author Kcube
 */
import java.util.Scanner;

public class SwimWithMe {
    Scanner s = new Scanner(System.in);    
    String [] enrollAthleName = {"Kyaw Soe", "Moe Moe", "Su Myat", "Zar Zar"};
    String athleName = "", athleTrainPlan = "", userWeightCat = "";
    double userTrainMonWeek = 0.00, userCurrentWeight = 0.00, totalPrivateEntryFee = 0.00,totalCompetitionEntryFee = 0.00, totalCost = 0.00;
    int userTrainSession = 0 , hourPrivateCoaching = 0,numOfCompetition =0; 
    
    public void function(){
        System.out.print("Enter Athlete Name: ");
        athleName = s.nextLine();
        System.out.print("Do you want to register? (Yes/No): ");
        String ask = s.nextLine();
        while(!(ask.equalsIgnoreCase("Yes")) && !(ask.equalsIgnoreCase("No"))){
            System.out.print("Please just enter yes or no to register: ");
            ask = s.nextLine();
        }
        if(ask.equalsIgnoreCase("Yes")){                            
            int reg = binarySearch(enrollAthleName,athleName);
            boolean name = false;
            while(!name){
                if(reg>-1) {
                    System.out.println("Sorry! "+athleName+", Your name is already Registered!");
                    System.out.println("1. Register again");
                    System.out.println("2. Show this athlete Information");
                    System.out.print("Enter number what you want to select: ");
                    int register = Integer.parseInt(s.nextLine());
                    while(register < 1 || register > 2){
                        System.out.print("Your choose number is wrong!!\nPlease enter number what you want to select again: ");
                        register = Integer.parseInt(s.nextLine());
                    }
                    switch(register){                    
                        case 1:
                            System.out.println("\nWelcome back! "+athleName+", Your name has been registered!\n");
                            trainingPlanFun();
                            name = true;
                            break;
                        case 2:
                            if(athleName.equalsIgnoreCase("Kyaw Soe")){
                                voucher("Kyaw Soe", "Intermediate", 140.00, 12, 80.00, "Light Middle Weight", 125.00, 126.00, 391.00);
                            }
                            else if(athleName.equalsIgnoreCase("Moe Moe")){

                                voucher("Moe", "Beginner", 80.00, 8, 60.00, "Fly Weight", 0.00, 84.00, 164.00);
                            }
                            else if(athleName.equalsIgnoreCase("Su Myat")){
                                voucher("Su Myat", "Elite", 200.00, 20, 90.00, "Middle Weight", 300.00, 210.00, 710.00);
                            }
                            else if(athleName.equalsIgnoreCase("Zar Zar")){

                                voucher("Zar Zar", "Beginner", 80.00, 8, 50.00, "Fly Weight", 0.00, 42.00, 122.00);
                            }
                            name = true;
                            break;
                    }
                }
                else{
                    System.out.println("\nWelcome! "+athleName+", Your name has been registered!\n");
                    trainingPlanFun();
                    name = true;
                }                   
            }                 
        }
        else if(ask.equalsIgnoreCase("No")){
                System.out.println("Thank you! See you again!");
        }                              
    }  
    
    public void trainingPlanFun(){
        System.out.println("Choose your training Plan!");
        System.out.println("1.Beginner");
        System.out.println("2.Intermediate");
        System.out.println("3.Elite");
        System.out.print("Enter your training plan: ");
        int trainingPlan = Integer.parseInt(s.nextLine());
        while(trainingPlan < 1 || trainingPlan > 3){
            System.out.print("Your choose training plan is wrong!!\nPlease enter your training plan again: ");
            trainingPlan = Integer.parseInt(s.nextLine());
        }
        if (trainingPlan==1) {
            userTrainMonWeek= 20 * 4;
            userTrainSession = 2 * 4;
            athleTrainPlan ="Beginner";
        }
        else if (trainingPlan==2) {
            userTrainMonWeek  = 35  * 4;
            userTrainSession=3 * 4;
            athleTrainPlan="Intermediate";
        }
        else if (trainingPlan==3) {
            userTrainMonWeek = 50 * 4;
            userTrainSession =5 * 4;
            athleTrainPlan="Elite";
        }
        //beginner
        if (trainingPlan==1) {           
            System.out.println("\nYou cannot enter competition!\n");
            System.out.print("Enter your current weight: ");
            userCurrentWeight=Integer.parseInt(s.nextLine());
            while(userCurrentWeight<30){
                System.out.print("The weight is too low! Please enter your current weight again: ");
                userCurrentWeight=Integer.parseInt(s.nextLine());   
            }
            //apply method
            weightCategory();
        }
        
        //intermediate and elite
        if (trainingPlan==2 || trainingPlan==3) {
            System.out.println("\nYou can enter competition!\n");
            System.out.print("Enter your current weight: ");
            userCurrentWeight=Integer.parseInt(s.nextLine());
            while(userCurrentWeight<30){
                System.out.print("The weight is too low! Please enter your current weight again: ");
                userCurrentWeight=Integer.parseInt(s.nextLine());   
            }
            //apply method
            weightCategory();
            System.out.println("\nCompetitions are held on the second Saturday of each month!");
            System.out.print("Do you want to compete?(Yes/No): ");
            String askCom = s.nextLine();                
            while(!(askCom.equalsIgnoreCase("Yes")) && !(askCom.equalsIgnoreCase("No"))){
                System.out.print("\nPlease just enter yes or no to compete: ");
                askCom = s.nextLine();
            }
            if(askCom.equalsIgnoreCase("Yes")){
                System.out.print("\nEnter number of competition per year: ");
                numOfCompetition = Integer.parseInt(s.nextLine());               
                while(numOfCompetition < 1 ||numOfCompetition> 12){                    
                    System.out.println("You can compete a maxinum of 12 competition per year!");
                    System.out.print("Enter number of competition per year again: ");
                    numOfCompetition= Integer.parseInt(s.nextLine());
                }                
            }
            else if(askCom.equalsIgnoreCase("No")){
                numOfCompetition=0;
            }
            totalCompetitionEntryFee=numOfCompetition*25;           
        }
        
        System.out.print("\nEnter hour of private coaching: ");
        hourPrivateCoaching = Integer.parseInt(s.nextLine());
        while(hourPrivateCoaching < 0 || hourPrivateCoaching > 5){
            System.out.println("The number you entered is wrong and you can receive a maxinum of five hours of private coaching a week!");
            System.out.print("Please enter hour of private coaching again: ");
            hourPrivateCoaching= Integer.parseInt(s.nextLine());
        }        
        totalPrivateEntryFee =(hourPrivateCoaching*10.5)*4;
        //calculate total cost
        totalCost= userTrainMonWeek + totalCompetitionEntryFee + totalPrivateEntryFee;        
        voucher(athleName, athleTrainPlan, userTrainMonWeek, userTrainSession, userCurrentWeight, userWeightCat, totalCompetitionEntryFee,totalPrivateEntryFee, totalCost);    
    } 
    
    // create method
    public void weightCategory () {
        if (userCurrentWeight>=30 && userCurrentWeight<=66) {
            userWeightCat="Fly Weight";
        }
        else if (userCurrentWeight >66&&userCurrentWeight<=73) {
            userWeightCat ="Light Weight";
        }
        else if (userCurrentWeight>73&&userCurrentWeight <=81) {
            userWeightCat="Light Middle Weight";
        }
        else if (userCurrentWeight >81&&userCurrentWeight<=90) {
            userWeightCat="Middle Weight";
        }
        else if (userCurrentWeight >90&&userCurrentWeight <=100) {
            userWeightCat="Light-Heavy Weight";
        }
        else if (userCurrentWeight>100) {
            userWeightCat="Heavy Weight";
        }
    }
    
    //searching for enroll athetele name
    public static int binarySearch(String [] name, String athName){
        int low = 0;
        int high = name.length-1;
        while(high >= low){
            int middle = (low+high) / 2;
            if(name[middle].compareToIgnoreCase(athName)==0){
                return middle;
            }
            else if(athName.compareToIgnoreCase(name[middle])>0){
                low = middle+1;
            }
            else{
                high = middle-1;
            }
        }
        return -1;
    }
    
    //sorting for enroll athetele name
    public static void bubbleSort(String[] enrollAthleName){       
    for(int i = 0; i < enrollAthleName.length-1; i++){
        for(int j = 0; j < enrollAthleName.length-i-1; j++)
            if(enrollAthleName[j].compareTo(enrollAthleName[j+1]) > 0){
                String temp = enrollAthleName[j];
                enrollAthleName[j] = enrollAthleName[j+1];
                enrollAthleName[j+1] = temp;
            }
        }
    }
    
    //output - voucher
    public void voucher(String athleName, String athleTrainPlan, double userTrainMonWeek, int userTrainSession, double userCurrentWeight, String userWeightCat, double totalCompetitionEntryFee,double totalPrivateEntryFee, double totalCost){   
        System.out.printf("\nYour Athtele name is %s.\n",athleName);
        System.out.println("****************************************************************");
        System.out.println("Your training plan is "+athleTrainPlan);
        System.out.printf("Your's training Monthly Fee is $%.2f\n", userTrainMonWeek);
        System.out.printf("Your's training Session is %d.\n", userTrainSession);
        System.out.printf("Your current weight is %.2f kg.\n",userCurrentWeight);
        System.out.println("Your weight category is "+ userWeightCat);
        System.out.printf("Your total competition Entry Fee per year is $%.2f\n",totalCompetitionEntryFee);
        System.out.printf("Your total Private monthly coaching Fee is $%.2f\n",totalPrivateEntryFee);  
        System.out.printf("Total cost of training and competition for the month is $%.2f\n",totalCost);
        System.out.println("****************************************************************"); 
        System.out.println("Thank you!");
    }
}
