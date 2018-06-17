package com.apptrics.studentdetailswork.StudentHibernateWork;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 

{
    public static void main( String[] args )
    {
    	Scanner s = new Scanner(System.in); 
    	HibernateConfigaration.connectDB();
    	
        System.out.println("Enter the Option you want to operate");
        System.out.println(" 1:Insert Values\n 2: Update Details\n 3:Read From Table\n 4:Read Table\n 5:Delete From Table\n 6:Delete Table\n 7:Close Connection");
        for(;;){
    	switch(s.nextInt()){
    	case 1:
    		HibernateConfigaration.insertValues();
    		break;
    	case 2:
    		HibernateConfigaration.updateDetails();
    		break;
    	case 3:
    		HibernateConfigaration.readFromTable();
    		break;
    	case 4:
    		HibernateConfigaration.readTable();
    		break;
    	case 5:
    		HibernateConfigaration.deleteFromTable();
    		break;
    	case 6:
    		HibernateConfigaration.deleteTable();
    		break;
    	case 7:
    		HibernateConfigaration.closeSessionFactory();
    		break;
    	default :
    		System.exit(0);
    	}
    }
        }
}
