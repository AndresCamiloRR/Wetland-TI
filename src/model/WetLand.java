package model;

/** WetLand<p>
* class designed to create, get and set objects of WetLand type with name(String), urbanOrRural(String), publicOrPrivate(String), area(double), photoUrl(String), nameOfZone(String), protectedArea(boolean) and speciesLiving (Specie[]) attributes.
* */

public class WetLand {

	/**
	* name is a attribute (global variable) of String type which contains the name of the WetLand
	* */
	private String name;
	
	/**
	* urbanOrRural is a attribute (global variable) of String type who will say if the zone is rural or urban
	* */
	private String urbanOrRural;
	
	/**
	* publicOrPrivate is a attribute (global variable) of String type who will say if the zone is public or private
	* */
	private String publicOrPrivate;
	
	/**
	* area is a attribute (global variable) of double type which contains the area of the WetLand
	* */
	private double area;
	
	/**
	* photoUrl is a attribute (global variable) of String type which contains the url of a photo from the WetLand
	* */
	private String photoUrl;
	
	/**
	* nameOfZone is a attribute (global variable) of String type which contains the name of the zone were the WetLand is located
	* */
	private String nameOfZone;
	
	/**
	* protectedArea is a attribute (global variable) of boolean type who will say if the zone is a protected area or not
	* */
	private boolean protectedArea;
	
	private final int MAX_EVENTS = 100;
	
	private Event[] events = new Event[MAX_EVENTS];
	
	private ManagementPlan plan;
	
	/**
	* speciesLiving is a attribute (global variable) of Specie[] type which contains the species that are living in the WetLand
	* */
	
	private final int MAX_SPECIES = 300;
	
	private Specie [] speciesLiving = new Specie[MAX_SPECIES];
	
	private int numOfMaintenance=0;
	

	//Constructor
	
	/**
	* Description: create a WetLand object 
	* <b> pos:</b> name, urbanOrRural, publicOrPrivate, area, photoUrl, nameOfZone, protectedArea and speciesLiving got asign
	* @param name String, urbanOrRural String, publicOrPrivate String, area double, photoUrl String, nameOfZone String, protectedArea boolean, speciesLiving Specie[]
	*/

	public WetLand(String name, String urbanOrRural, String publicOrPrivate, double area, String photoUrl, String nameOfZone, boolean protectedArea, String description, double percentageFilled) {
	
		this.name=name;
		this.urbanOrRural=urbanOrRural;
		this.publicOrPrivate=publicOrPrivate;
		this.area=area;
		this.photoUrl=photoUrl;
		this.nameOfZone=nameOfZone;
		this.protectedArea=protectedArea;
		plan = new ManagementPlan(description, percentageFilled);
	}
	
	
	//get
	
	public String getName() {
		return name;
	}

	public String getUrbanOrRural() {
		return urbanOrRural;
	}
	
	public String getPublicOrPrivate() {
		return publicOrPrivate;
	}

	public double getArea() {
		return area;
	}
	
	public String getPhotoUrl() {
		return photoUrl;
	}
	
	public String getNameOfZone() {
		return nameOfZone;
	}

	public boolean getProtectedArea() {
		return protectedArea;
	}
	
	
	//set
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setUrbanOrRural(String urbanOrRural) {
		this.urbanOrRural = urbanOrRural;
	}

	public void setPublicOrPrivate(String publicOrPrivate) {
		this.publicOrPrivate = publicOrPrivate;
	}
	
	public void setArea(double area) {
		this.area = area;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public void setNameOfZone(String nameOfZone) {
		this.nameOfZone = nameOfZone;
	}
	
	public void setProtectedArea(boolean protectedArea) {
		this.protectedArea = protectedArea;
	}
	
	
	//numOfSpeciesLiving
	
	public int NumOfSpeciesLiving(){
		
		int numOfSpeciesLiving=0;
		
		for(int counter=0; counter<MAX_SPECIES; counter++){
			
			if(speciesLiving[counter]!=null){
				
				numOfSpeciesLiving++;
				
			};
			
		}
		
		return numOfSpeciesLiving;
		
	}
	
	
	//EmptyIndexEvent
	public int EmptyIndexEvent(){
		
		int emptyIndex=-1;
		
		for (int counter=0; counter < MAX_EVENTS&&emptyIndex==-1; counter++){
			
			if(events[counter]==null){
				emptyIndex=counter;
			}
		}
		
		return emptyIndex;
		
	}
	
	
	//addEvent
	public void addEvent(Event newEvent){
		
		events[EmptyIndexEvent()]=newEvent;
		
	}
	
	//EmptyIndexSpecie
	public int EmptyIndexSpecie(){
		
		int emptyIndex=-1;
		
		for (int counter=0; counter < MAX_SPECIES&&emptyIndex==-1; counter++){
			
			if(speciesLiving[counter]==null){
				emptyIndex=counter;
			}
		};
		
		return emptyIndex;
		
	}
	
	//addSpecie
	
	public void addSpecie(Specie newSpecie){
		
		speciesLiving[EmptyIndexSpecie()]=newSpecie;
		
	}
	
	public int getNumOfMaintenance(){
		return numOfMaintenance;
		
	}
	
	public void addNumOfMaintenance(){
		numOfMaintenance++;
		
	}
	
	public int FloraCount(){
		
		int floraNum=0;
		
		for (int counter=0; counter<MAX_SPECIES; counter++){
			
			if(speciesLiving[counter]!=null){
				
			
				if (speciesLiving[counter].getType()==(Flora_Fauna.FLORA_TERRESTRE) || speciesLiving[counter].getType()==(Flora_Fauna.FLORA_ACUATICA)){
				
					floraNum++;
				}
			}
			
		}
		
		return floraNum;
		
	}
	
	public int FaunaCount(){
		
		int faunaNum=0;
		
		for (int counter=0; counter<MAX_SPECIES; counter++){
			
			if(speciesLiving[counter]!=null){
				
			
				if (speciesLiving[counter].getType()==(Flora_Fauna.AVE) || speciesLiving[counter].getType()==(Flora_Fauna.MAMIFERO)|| speciesLiving[counter].getType()==(Flora_Fauna.ESPECIE_ACUATICA)){
				
					faunaNum++;
				}
			}
			
		}
		
		return faunaNum;
		
	}
	
	//toString
	
	public String toString(){
		
		return "WetLand Info \n" + "Nombre: " + name + "\n Nombre de la zona en que se encuentra: " + nameOfZone + "\n La zona es " + urbanOrRural + "\n Es una zona " + publicOrPrivate + "\n Tiene un area de: " + area + "\n La URL de la foto es: " + photoUrl + "\n Es una zona protegida?: " + protectedArea + "\n Numero de flora: " + FloraCount() + "\n Numero de fauna: " + FaunaCount();
		
	}

}