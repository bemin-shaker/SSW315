package simulator;

public class Student {
    //Instance variables for Student
    private double qualityThreshold;
    private int IDNum;
    private int yearsOnList;

    //Constructor for Student, to be completed by you
    public Student (double qual, int ID) { 
    	IDNum = ID;
    	qualityThreshold = qual;
    	yearsOnList = 0;
    }

    //Returns quality threshold for student
    public double getQualityThreshold () {
        return this.qualityThreshold;
    }

    //Returns ID number for student
    public int getIDNum () {
        return this.IDNum;
    }

    public int getYearsOnList () {
        return this.yearsOnList;
    }

    //Lowers quality threshold after cycle of simulation, to be completed by you
    //If no match, use this to lower quality threshold of student
    public void addDesperation() {  
    	this.qualityThreshold *= 0.9;
    }

    //Adds a year to elapsed waiting time, to be completed by you
    //Every year, increase waiting time for students remaining on list
    public void addYear () {  
    	this.yearsOnList++;
    }
}
