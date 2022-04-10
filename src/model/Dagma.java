package model;

/** Dagma<p>
* class designed to create, get and set a Data base of Dagma type with allWetLands(WetLand[]) and allSpecies(Specie[]) attributes.
* */

public class Dagma {
	
	/**
	* MAX_WETLANDS is a constant of int type wich contains the max number of habitats that dagma can has
	* */
	private final int MAX_WETLANDS=80;
	
	/**
	* MAX_SPECIES is a constant of int type wich contains the max number of species that dagma can has
	* */
	private final int MAX_SPECIES = 300;
	
	/**
	* allWetLands is a attribute (global variable) of WetLand type which contains all the wetlands registered
	* */
	private WetLand[] allWetLands = new WetLand[MAX_WETLANDS];
	
	/**
	* allSpecies is a attribute (global variable) of Specie type which contains all the species registered
	* */
	private Specie[] allSpecies = new Specie[MAX_SPECIES];
	
	/**
	* newEvent is a attribute of Event type
	* */
	private Event newEvent;
	
	/**
	 * Constructor
	 */
	 
	public Dagma(){
		
		
		
	};
	
	/**
	* Description: travels the allSpecies array looking for the first empty specie
	* @return emptyIndex int contains the index of the first empty position
	*/
	
	public int EmptyIndexSpecie(){
		
		int emptyIndex=-1;
		
		for (int counter=0; counter < MAX_SPECIES&&emptyIndex==-1; counter++){
			
			if(allSpecies[counter]==null){
				emptyIndex=counter;
			}
		};
		
		return emptyIndex;
		
	}
	
	/**
	* Description: add a specie to the general data base
	* @param name String --> it must be initialized 
	* @param scientificName String --> it must be initialized 
	* @param migratory int --> it must be initialized 
	* @param type int --> it must be initialized 
	*/
	
	public void addSpecie(String name, String scientificName, int migratory, int type){
		
		
		String nameS="";
		
		String scientificNameS="";
		
		boolean migratoryS=true;
		
		Flora_Fauna typeS=null;
		
		nameS=name;
		scientificNameS=scientificName;
		
		if (migratory==1){
			
			migratoryS=true;
			
		}else{
			
			migratoryS=false;
			
		}
		
		switch (type){
			
			case 1:
				typeS=Flora_Fauna.FLORA_TERRESTRE;
				break;
			case 2:
				typeS=Flora_Fauna.FLORA_ACUATICA;
				break;
			case 3:
				typeS=Flora_Fauna.AVE;
				break;
			case 4:
				typeS=Flora_Fauna.MAMIFERO;
				break;
			case 5:
				typeS=Flora_Fauna.ESPECIE_ACUATICA;
				break;
		}
		
		allSpecies[EmptyIndexSpecie()]=new Specie(nameS, scientificNameS, migratoryS, typeS);
		
	}
	
	/**
	* Description: search in allSpecies if there's a specie with the same name that the user write
	* @param name String --> it must be initialized 
	* @return out boolean true if there are clones, false if it doesn't
	*/
	
	public boolean SameNameSpecie(String name){
		
		boolean out=false;
		
		for(int counter=0; counter<MAX_SPECIES; counter++){
			
			if(allSpecies[counter]!=null&&name.equals(allSpecies[counter].getName())){
				
				out=true;
				
			}
			
		}
		
		return out;
		
	}
	
	/**
	* Description: search in allSpecies if there's a specie with the same scientificName that the user write
	* @param scientificName String --> it must be initialized 
	* @return out boolean true if there are clones, false if it doesn't
	*/
	
	public boolean SameScientificNameSpecie(String scientificName){
		
		boolean out=false;
		
		for(int counter=0; counter<MAX_SPECIES; counter++){
			
			if(allSpecies[counter]!=null&&scientificName.equals(allSpecies[counter].getScientificName())){
				
				out=true;
				
			}
			
		}
		
		return out;
		
	}

	/**
	* Description: search in allSpecies if there's a specie with the same name that the user write to return it's index
	* @param name String --> it must be initialized 
	* @return index int wich contains the position were the specie is located of a -1 if the specie wasn't found
	*/
	
	public int FindSpecie(String name){
		
		int index =-1;
		
		for(int counter=0;counter<MAX_SPECIES&&index==-1;counter++){
			
			if(allSpecies[counter]!=null && allSpecies[counter].getName().equals(name)){
				
				index=counter;
				
			}
			
		}
		
		return index;
		
	}

	/**
	* Description: search for the habitats where a specie is located 
	* @param specieIndex int
	* @return habitatsWhereIsLocated String, returns the names of the wetlands where the specie lives
	*/
	
	public String SpecieHabitatSearcher(int specieIndex){
		
		String habitatsWhereIsLocated = allSpecies[specieIndex].HabitatSearcher();
		
		return habitatsWhereIsLocated;
	}
	
	/**
	* Description: travels the allSpecies array and get the scientificName of each species to return them all in a string 
	* @return list String, returns the scientificName of the species registered on the general data base
	*/
	
	public String SpeciesAvailable(){
		
		String list="";
		
		for(int counter=0; counter<MAX_SPECIES; counter++){
			
			if(allSpecies[counter]!=null){
				
				list = list + (counter+1) + ")  " + allSpecies[counter].getScientificName() +"\n";
				
			}
			
		}
		
		if(list.equals("")){
			
			list = "No hay especies registradas aun, por favor ingrese 0 para salir e ingrese los datos de la especie en la opcion base de datos general";
			
		}
		
		return list;
		
	}
	
	/**
	* Description: travels the allWetLands array looking for the first empty specie
	* @return emptyIndex int contains the index of the first empty position
	*/
	
	public int EmptyIndexWetland(){
		
		int emptyIndex=-1;
		
		for (int counter=0; counter < MAX_WETLANDS&&emptyIndex==-1; counter++){
			
			if(allWetLands[counter]==null){
				emptyIndex=counter;
			}
		}
		
		return emptyIndex;
		
	}
	
	/**
	* Description: search in allWetLands if there's a wetland with the same name that the user write to return it's index
	* @param name String --> it must be initialized 
	* @return index int wich contains the position were the wetland is located of a -1 if the specie wasn't found
	*/
	
	public int FindWetland(String name){
		
		int index =-1;
		
		for(int counter=0;counter<MAX_WETLANDS&&index==-1;counter++){
			
			if(allWetLands[counter]!=null && allWetLands[counter].getName().equals(name)){
				
				index=counter;
				
			}
			
		}
		
		return index;
		
	}
	
	/**
	* Description: register a wetland in allWetLands array
	* @param name String --> it must be initialized 
	* @param urbanOrRural int --> it must be initialized 
	* @param publicOrPrivate int --> it must be initialized 
	* @param area double --> it must be initialized 
	* @param photoUrl String --> it must be initialized 
	* @param nameOfZone String --> it must be initialized 
	* @param protectedArea int --> it must be initialized 
	* @param description String --> it must be initialized 
	* @param percentageFilled double --> it must be initialized 
	*/
	
	public void addWetland(String name, int urbanOrRural, int publicOrPrivate, double area, String photoUrl, String nameOfZone, int protectedArea, String description, double percentageFilled){
		
		String nameW="";
		String urbanOrRuralW="";
		String publicOrPrivateW="";
		double areaW=-1;
		String photoUrlW="";
		String nameOfZoneW=""; 
		boolean protectedAreaW=true;
		String descriptionW="";
		double percentageFilledW=-1;
		
		nameW=name;
		
		switch (urbanOrRural){
		case 1:
			urbanOrRuralW="urban";
			break;
		case 2:
			urbanOrRuralW="rural";
			break;
		}
		switch (publicOrPrivate){
		case 1:
			publicOrPrivateW="public";
			break;
		case 2:
			publicOrPrivateW="private";
			break;
		}
		areaW=area;
		photoUrlW=photoUrl;
		nameOfZoneW=nameOfZone;
		switch (protectedArea){
		case 1:
			protectedAreaW=true;
			break;
		case 2:
			protectedAreaW=false;
			break;
		}
		
		descriptionW=description;
		percentageFilledW=percentageFilled;
		
		int emptyIndex = EmptyIndexWetland();
		
		allWetLands[emptyIndex]=new WetLand(nameW, urbanOrRuralW, publicOrPrivateW, areaW, photoUrlW, nameOfZoneW, protectedAreaW, descriptionW, percentageFilledW);
		
	}
	
	/**
	* Description: search in allWetLands if there's a wetland with the same name that the user write
	* @param name String --> it must be initialized 
	* @return out boolean true if there are clones, false if it doesn't
	*/
	
	public boolean SameNameWetland(String name){
		
		boolean out=false;
		
		for(int counter=0; counter<MAX_WETLANDS; counter++){
			
			if(allWetLands[counter]!=null&&name.equals(allWetLands[counter].getName())){
				
				out=true;
				
			}
			
		}
		
		return out;
		
	}
	
	/**
	* Description: travels the allSpecies array looking for the first empty position
	* @return emptyIndex int contains the index of the first empty position
	*/
	
	public int EmptyEventIndexForWetland(int index){
		
		int emptyIndex;
		
		emptyIndex=allWetLands[index].EmptyIndexEvent();
		
		return emptyIndex;
	}
	
	/**
	* Description: register an event in a wetland
	* @param dateOfEvent Date --> it must be initialized 
	* @param typeOfEvent String --> it must be initialized 
	* @param cost double --> it must be initialized 
	* @param description String --> it must be initialized 
	*/
	
	public void addEvent(int index, int eventType, int day, int month, int year, String owner, double cost, String description){
		
		String event="";
		
		switch (eventType){
			
			case(1):
				event="mantenimiento";
				break;
			case(2):
				event="visitas de colegio";
				break;
			case(3):
				event="actividades de mejoramiento";
				break;
			case(4):
				event="celebraciones";
				break;
			case(5):
				event="otro tipo";
				break;
			
		}
		
		Date date = new Date(day, month, year);
		
		newEvent = new Event(event, date, owner, cost, description);
		
		allWetLands[index].addEvent(newEvent);
		
		if(event.equals("mantenimiento")){
			
			allWetLands[index].addNumOfMaintenance();
			
		}
	}
	
	/**
	* Description: returns the number of maintenance from a wetland
	* @param indexWetland int contains the index from the wetland selected by the user
	* @return numOfMaintenance int
	*/
	
	public int getMaintenanceFromWetland(int indexWetland){
		
		int	numOfMaintenance = allWetLands[indexWetland].getNumOfMaintenance();
		
		return numOfMaintenance;
		
	}
	
	/**
	* Description: travels the allWetLands array and get the name of each wetland to return them all in a string 
	* @return list String, returns the name of the wetlands registered
	*/
	
	public String WetlandsAvailable(){
		
		String list="";
		
		for(int counter=0; counter<MAX_WETLANDS; counter++){
			
			if(allWetLands[counter]!=null){
				
				list= list + (counter+1) + ") " + allWetLands[counter].getName() + "\n";
				
			}
			
		}
		
		if(list.equals("")){
			
			list = "No hay humedales registrados aun, por favor ingrese 0 para salir e ingrese los datos del humedal en la opcion registrar humedal";
			
		}
		
		return list;
		
	}
	
	
	/**
	* Description: add a specie selected by the user to a wetland that was also selected by the user
	* and vice versa to add the wetland as an habitat to a specie
	* @param name String --> it must be initialized 
	* @param specieName String --> it must be initialized 
	*/	
	
	public void addSpecieToWetland(String name, String specieName){
		
		int indexWetland=-1;
		indexWetland = FindWetland(name);
		
		int indexSpecie=-1;
		indexSpecie=FindSpecie(specieName);
			
			allWetLands[indexWetland].addSpecie(allSpecies[indexSpecie]);
			
			allSpecies[indexSpecie].addHabitat(allWetLands[indexWetland]);	
		
	}
	
	/**
	* Description: search for the wetland with less flora 
	* @return LessFlora WetLand, returns the wetland with less flora
	*/	
	
	public String WetLandLessFlora (){
		
		String lessFlora="";
		int wetlandLessFlora=-1;
		int actualFlora=-1;
		
		for(int counter=0; counter<MAX_WETLANDS; counter++){
			
			if(allWetLands[counter]!=null){
				
				if(allWetLands[counter].FloraCount()<actualFlora||actualFlora==-1){
					actualFlora=allWetLands[counter].FloraCount();
					wetlandLessFlora=counter;
					lessFlora="El humedal con menos flora es: " + allWetLands[counter].getName() + " con un total de: " + actualFlora + " flora";
				}
			}
			
		}
		
		if(lessFlora.equals("")){
			
			lessFlora="No hay ningun humedal registrado";
			
		}
		
		return lessFlora;
	}
	
	/**
	* Description: search for the wetland with most fauna 
	* @return LessFlora WetLand, returns the wetland with less flora
	*/
	public String WetLandMostFauna (){
		
		String mostFauna="";
		int wetlandFostFauna=-1;
		int actualFauna=-1;
		
		for(int counter=0; counter<MAX_WETLANDS; counter++){
			
			if(allWetLands[counter]!=null){
				
				if(allWetLands[counter].FaunaCount()<actualFauna||actualFauna==-1){
					actualFauna=allWetLands[counter].FaunaCount();
					wetlandFostFauna=counter;
					mostFauna="El humedal con mas fauna es: " + allWetLands[counter].getName() + " con un total de: " + actualFauna + " fauna";
				}
			}
			
		}
		
		if(mostFauna.equals("")){
			
			mostFauna="No hay ningun humedal registrado";
			
		}
		
		return mostFauna;
	}
	
	/**
	* Method that produces a String with the information of dagma
	* @return String with dagma info
	*/
	
	public String toString(){
		
		String msg="";
		
		for(int counter=0; counter<MAX_WETLANDS;counter++){
			
			if(allWetLands[counter]!=null){
				
				msg+=allWetLands[counter].toString() + "\n";
				
			}
			
		}
		
		if(msg.equals("")){
			
			msg="Todavia no hay informacion ingresada";
			
		}
		
		return msg;
		
	}
}