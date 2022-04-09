package model;


/** ManagementPlan<p>
* class designed to create, get, and set objects of ManagementPlan type with percentageFulfilled(double) and description(String) attributes
* */

public class ManagementPlan {

	/**
	* percentageFulfilled is a attribute (global variable) of double type that contains the percentage of progress of the plan
	* */
	private double percentageFulfilled;
	
	/**
	* description is a attribute (global variable) of String type that contains the objectives, parts and description of the plan
	* */
	private String description;
	
	//Constructor
	
	/**
	* Description: create a ManagementPlan object 
	* <b> pos:</b> percentageFulfilled and description got asign
	* @param percentageFulfilled double, description String
	*/
	
	public ManagementPlan(String description, double percentageFulfilled) {
		this.percentageFulfilled=percentageFulfilled;
		this.description=description;
	}


	//get
	
	public double getPercentageFulfilled() {
		return percentageFulfilled;
	}

	public String getDescription() {
		return description;
	}


	//set

	public void setPercentageFulfilled(double percentageFulfilled) {
		this.percentageFulfilled = percentageFulfilled;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}