package simulator;

import java.util.ArrayList;
import java.util.Scanner;

public class HousingSimulator {
	public static MyQueue<Student> students = new MyQueue<>();
	public static ArrayList<Apartment> apartments = new ArrayList<>();
		
	//Functions for generating random double
    public static double randomDouble(int from, int to) {
        return Math.random() * to + from;
    }
    
    
    //Functions for generating random int 
    public static int randomInt(int from, int to) { 
    	return (int) Math.floor(Math.random() * (to-from+1) + from); 
    }


	//To be completed by you
    public static void runSimulation(int k, int N) {
    	
    	for (int i = 0; i < N; i++) {
    		apartments.add(new Apartment(randomDouble(0, 1), i, 0));
    	}
    	
    	for (int j = 0; j < k; j++) {
    		students.offer(new Student(randomDouble(0, 1), j));
    	}
    	
    	int year = 0;
        while (!allVacant() && students.size() > 0) {
        	int aptOccupied = 0;
        	
        	System.out.println();
        	System.out.println("--------------------------------------------------------");
        	System.out.println("YEAR " + year + ":");
        	System.out.println();
        	
        	
            for (Apartment apt : apartments) {
            	 if (students.size() > 0) {
                     Student student = students.peek();
                     if (apt.getQuality() > student.getQualityThreshold() && apt.getYearsLeft() == 0) {
                    	 apt.setYearsLeft(randomInt(1, 3));
                    	 System.out.println("Student " + student.getIDNum() 
                    	 + " accepted apartment " + apt.getIDNum() + " and will be occupied for " 
                    			 + apt.getYearsLeft() + " year(s).");
                    	 students.poll();
                    	 aptOccupied++;
                     } else {
                    	 System.out.println("Student " + student.getIDNum() 
                    	 + " rejected apartment " + apt.getIDNum());
                    	 student.addDesperation();
                    	 student.addYear();
                         students.offer(students.poll());
                     }
            	 }
                     
            }
        	
            System.out.println();
            listVacancies();
            System.out.println();
        	decrementYearsLeft();
        	System.out.println("Apartments newly filled this year: " + aptOccupied);
        	year += 1;
        }
        
        
  
    
    }
    
    //Checks whether apartments ArrayList is empty
    public static boolean allVacant() {

    	 int i = 0;
         while (i < apartments.size() && apartments.get(i).getYearsLeft() == 0)
             i++;
         return i == apartments.size() - 1;
    }
    
    //Returns all the apartments with vacancies
    public static void listVacancies() {
    	System.out.println("Vacant Apartments: ");
        for (int i = 0; i < apartments.size(); i++) {
        	if (apartments.get(i).getYearsLeft() == 0) {
        		System.out.println(apartments.get(i).getIDNum());
        	}
        }
    }
    
    
    //Decrements the years left in apartment occupancy
    public static void decrementYearsLeft() {
    	for (Apartment apt : apartments) {
    		int yearsLeft = apt.getYearsLeft();
    		if (yearsLeft > 0) {
        		apt.setYearsLeft(yearsLeft - 1);
    		}
    	}
    }
    
    //Main method for simulation
    public static void main (String[] args) {
    	
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students to run simulation with: ");
        int k = sc.nextInt();

        System.out.print("Enter number of apartments to run simulation with: ");
        int N = sc.nextInt();

        runSimulation(k, N);
        
        sc.close();
    }
}
