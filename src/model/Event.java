package model;

/** Event<p>
* class designed to create, get, and set objects of Event type with dateOfEvent(Date), typeOfEvent(String), cost(int) and description(String) attributes
* */

public class Event {
	
	/**
	* typeOfEvent is a attribute (global variable) of String type which contains the type of the event
	* */
	private String typeOfEvent;
	
	/**
	* dateOfEvent is a attribute (global variable) of Date type which contains the date on which the event will happen
	* */
	private Date dateOfEvent;
	
	/**
	* owner is a attribute (global variable) of String type which contains the name of the owner of the event
	* */
	private String owner;
	
	/**
	* cost is a attribute (global variable) of int type which contains the total cost of the event
	* */
	private double cost;
	
	/**
	* description is a attribute (global variable) of String type which contains a description of what will happen in the event
	* */
	private String description;
	
	/**
	* Description: Constructor create a Event object 
	* <b> pos:</b> dateOfEvent --> got asign
	* <b> pos:</b> typeOfEvent --> got asign
	* <b> pos:</b> cost --> got asign
	* <b> pos:</b>description --> got asign
	* @param dateOfEvent Date --> it must be initialized 
	* @param typeOfEvent String --> it must be initialized 
	* @param cost double --> it must be initialized 
	* @param description String --> it must be initialized 
	*/
	
	public Event(String typeOfEvent, Date dateOfEvent, String owner, double cost, String description) {
		this.typeOfEvent=typeOfEvent;
		this.dateOfEvent=dateOfEvent;
		this.owner=owner;
		this.cost=cost;
		this.description=description;
	}
	
	//get
	
	public Date getDateOfEvent() {
		return dateOfEvent;
	}
	
	public String getTypeOfEvent() {
		return typeOfEvent;
	}

	public double getCost() {
		return cost;
	}

	public String getDescription() {
		return description;
	}
	
	
	//set
	

	public void setDateOfEvent(Date dateOfEvent) {
		this.dateOfEvent = dateOfEvent;
	}
	
	public void setTypeOfEvent(String typeOfEvent) {
		this.typeOfEvent = typeOfEvent;
	}


	public void setCost(double cost) {
		this.cost = cost;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

}