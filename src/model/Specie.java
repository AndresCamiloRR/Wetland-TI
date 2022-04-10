package model;


/** Specie<p>
* class designed to create, get and set objects of Specie type with name(String), scientificName(String), migratory(boolean), type(String) and habitats(WetLand[]) attributes.
* */

public class Specie {
	
	/**
	* name is a attribute (global variable) of String type which contains the name of the specie
	* */
	private String name;
	
	/**
	* scientificName is attribute (global variable) of String type which contains the scientificName of the specie
	* */
	private String scientificName;
	
	/**
	* migratory is a attribute (global variable) of boolean type which contains a boolean who will say if it is migratory or not
	* */
	private boolean migratory;
	
	/**
	* type is a attribute (global variable) of String type which contains a number based on the type of the specie 
	*( terrestrial flora,  aquatic flora,  bird,  mammal,  aquatic)
	* */
	private Flora_Fauna type;
	
	private final int MAX_WETLANDS=80;
	
	/**
	* habitat is a attribute (global variable) of WetLand[] type which contains the wetlands in which the species lives
	* */
	private WetLand[] habitats = new WetLand[MAX_WETLANDS];


	//Constructor
	
	/**
	* Description: create a Specie object 
	* <b> pos:</b> name, scientificName, migratory, type and habitats got asign
	* @param name String, scientificName String, migratory boolean, type String, habitats WetLand[]
	*/
	
	public Specie(String name, String scientificName, boolean migratory, Flora_Fauna type) {
		this.name=name;
		this.scientificName=scientificName;
		this.migratory=migratory;
		this.type=type;
	}
	
	
	//get

	public String getName() {
		return name;
	}

	public String getScientificName() {
		return scientificName;
	}

	public boolean getMigratory() {
		return migratory;
	}

	public Flora_Fauna getType() {
		return type;
	}
	
	public WetLand[] getHabitats() {
		return habitats;
	}
	
	
	//set
	
	public void setName(String name) {
		this.name=name;
	}

	public void setScientificName(String scientificName) {
		this.scientificName=scientificName;
	}

	public void setMigratory(boolean migratory) {
		this.migratory=migratory;
	}

	public void setType(Flora_Fauna type) {
		this.type=type;
	}
	
	public void setHabitats(WetLand[] habitats) {
		this.habitats=habitats;
	}
	
	
	/**
	* Description: search for the habitats where a specie is located 
	* @param specieScientificName String, that the specieScientificName exist in the allSpecies array
	* @return habitatsWhereIsLocated String, returns the names of the wetlands where the specie lives
	*/
	
	public String HabitatSearcher(){
		
		String habitatsWhereIsLocated = "";
		
		for(int counter = 0; counter<MAX_WETLANDS; counter++){
			
			if(habitats[counter]!=null){
				
				habitatsWhereIsLocated+= "\n" + habitats[counter].getName() + "\n";
				
			}
			
		}
		
		if(habitatsWhereIsLocated.equals("")){
			
			habitatsWhereIsLocated = "La especie no ha sido registrada en ningun humedal aun";
			
		}else{
			
			habitatsWhereIsLocated = "La especie puede ser encontrada en: \n" + habitatsWhereIsLocated;
		}
		
		return habitatsWhereIsLocated;
	}
	
	public int EmptyHabitatIndex(){
		
		int emptyIndex=-1;
		
		for(int counter = 0; counter<MAX_WETLANDS&&emptyIndex==-1;counter++){
			
			if(habitats[counter]==null){
				
				emptyIndex=counter;
				
			}
			
		}
		
		return emptyIndex;
		
	}
	
	public void addHabitat(WetLand newWetland){
		
		habitats[EmptyHabitatIndex()]=newWetland;
		
	}
	
}