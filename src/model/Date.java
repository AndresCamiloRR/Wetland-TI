package model;


/** Date<p>
* class designed to create, get, and set objects of date type with day(int), month(int), and year(int) attributes
* */

public class Date {
	
	/**
	* day is a attribute (global variable) of int type that contains the number of a day
	* */
	private int day;
	
	/**
	* month is a attribute (global variable) of int type that contains the number of a month
	* */
	private int month;
	
	/**
	* year is a attribute (global variable) of int type that contains the number of a year
	* */
	private int year;


//Constructor
	
	/**
	* Description: Constructor create a Date object 
	* <b> pos:</b> day, month and year got asign
	* @param day int, month int, year int
	*/
	
	public Date(int day, int month, int year){
		
		this.day=day;
		this.month=month;
		this.year=year;
	}
	
	
	//get
	
	public int getDay (){
		return day;
	}
	
	public int getMonth (){
		return month;
	}
	
	public int getYear (){
		return year;
	}
	
	
	//set
	
	public void setDay (int pDay){
		this.day=day;
	}
	
	public void setMonth (int pMonth){
		this.month=month;
	}
	
	public void setYear (int pYear){
		this.year=year;
	}

}