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
	
	/**
	* MAX_EVENTS is a constant of int type wich contains the max number of events that a wetland can has
	* */
	private final int MAX_EVENTS = 100;
	
	/**
	* events is an attribute (global variable) of events[] type which contains the events that are registered in the WetLand
	* */
	private Event[] events = new Event[MAX_EVENTS];
	
	/**
	* plan is a attribute (global variable) of ManagementPlan type which contains the ManagementPlan from the wetland
	* */
	private ManagementPlan plan;
	
	/**
	* MAX_SPECIES is a constant of int type wich contains the max number of species that a wetland can has
	* */
	private final int MAX_SPECIES = 300;
	
	/**
	* speciesLiving is a attribute (global variable) of Specie[] type which contains the species that are living in the WetLand
	* */
	private Specie [] speciesLiving = new Specie[MAX_SPECIES];
	
	/**
	* numOfMaintenance is a attribute (global variable) of int type which contains the number of maintenance from the wetland
	* */
	private int numOfMaintenance=0;
	
	
	/**
	* Description: Constructor create a WetLand object 
	* <b> pos:</b> name --> got asign
	* <b> pos:</b> urbanOrRural --> got asign
	* <b> pos:</b> publicOrPrivate --> got asign
	* <b> pos:</b> area --> got asign
	* <b> pos:</b> photoUrl --> got asign
	* <b> pos:</b> nameOfZone --> got asign
	* <b> pos:</b> protectedArea --> got asign
	* <b> pos:</b> speciesLiving --> got asign
	* @param name String --> it must be initialized 
	* @param urbanOrRural String --> it must be initialized 
	* @param publicOrPrivate String --> it must be initialized 
	* @param area double --> it must be initialized 
	* @param photoUrl String --> it must be initialized 
	* @param nameOfZone String --> it must be initialized 
	* @param protectedArea boolean --> it must be initialized 
	* @param description String --> it must be initialized 
	* @param percentageFilled double --> it must be initialized 
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
	
	public int getNumOfMaintenance(){
		return numOfMaintenance;
		
	}
	
	/**
	* Description: sum 1 to numOfMaintenance everytime and event of maintenance type is added
	*/
	
	public void addNumOfMaintenance(){
		numOfMaintenance++;
		
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
	
	
	/**
	* Description: travels the events array and check if there's an empty position
	* @return emptyIndex int wich contains the first empty position in the events array
	*/
	public int EmptyIndexEvent(){
		
		int emptyIndex=-1;
		
		for (int counter=0; counter < MAX_EVENTS&&emptyIndex==-1; counter++){
			
			if(events[counter]==null){
				emptyIndex=counter;
			}
		}
		
		return emptyIndex;
		
	}
	
	
	/**
	* Description: method that will add newEvent in the events array
	* @param newEvent Event --> it must be initialized
	*/
	public void addEvent(Event newEvent){
		
		events[EmptyIndexEvent()]=newEvent;
		
	}
	
	/**
	* Description: travels the speciesLiving array and check if there's an empty position
	* @return emptyIndex int wich contains the first empty position in the speciesLiving array
	*/
	public int EmptyIndexSpecie(){
		
		int emptyIndex=-1;
		
		for (int counter=0; counter < MAX_SPECIES&&emptyIndex==-1; counter++){
			
			if(speciesLiving[counter]==null){
				emptyIndex=counter;
			}
		};
		
		return emptyIndex;
		
	}
	
	/**
	* Description: method that will add newSpecie in the speciesLiving array
	* @param speciesLiving Specie --> it must be initialized
	*/
	
	public void addSpecie(Specie newSpecie){
		
		speciesLiving[EmptyIndexSpecie()]=newSpecie;
		
	}
	
	
	/**
	* Method that travels the speciesLiving array, ask their type and check if the type is Flora_Fauna.FLORA_TERRESTRE or Flora_Fauna.FLORA_ACUATICA
	* to then sum 1 to floraNum wich is the number of flora that the wetland has
	* @return floraNum int wich contains the number of flora from a wetland
	*/
	
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
	
	/**
	* Method that travels the speciesLiving array, ask their type and check if the type is Flora_Fauna.MAMIFERO or Flora_Fauna.AVE or Flora_Fauna.ESPECIE_ACUATICA
	* to then sum 1 to faunaNum wich is the number of fauna that the wetland has
	* @return faunaNum int wich contains the number of fauna from a wetland
	*/
	
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
	
	/**
	* Method that produces a String with the information of a wetland
	* @return String with the wetland info
	*/
	
	public String toString(){
		
		return "WetLand Info \n" + "Nombre: " + name + "\n Nombre de la zona en que se encuentra: " + nameOfZone + "\n La zona es " + urbanOrRural + "\n Es una zona " + publicOrPrivate + "\n Tiene un area de: " + area + "\n La URL de la foto es: " + photoUrl + "\n Es una zona protegida?: " + protectedArea + "\n Numero de flora: " + FloraCount() + "\n Numero de fauna: " + FaunaCount() + plan.toString();
		
	}

}