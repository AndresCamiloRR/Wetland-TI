package model;

/** Dagma<p>
* class designed to create, get and set a Data base of Dagma type with allWetLands(WetLand[]) and allSpecies(Specie[]) attributes.
* */

public class Dagma {
	
	private final int MAX_WETLANDS=80;
	private final int MAX_SPECIES = 300;
	
	/**
	* allWetLands is a attribute (global variable) of WetLand type which contains all the wetlands registered
	* */
	private WetLand[] allWetLands = new WetLand[MAX_WETLANDS];
	
	
	/**
	* allSpecies is a attribute (global variable) of Specie type which contains all the species registered
	* */
	private Specie[] allSpecies = new Specie[MAX_SPECIES];
	
	private Event newEvent;
	
	public Dagma(){
		
		
		
	};
	
	//EmptyIndexSpecie
	
	public int EmptyIndexSpecie(){
		
		int emptyIndex=-1;
		
		for (int counter=0; counter < MAX_SPECIES&&emptyIndex==-1; counter++){
			
			if(allSpecies[counter]==null){
				emptyIndex=counter;
			}
		};
		
		return emptyIndex;
		
	}
	
	//addSpecie
	
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
	
	//sameNameSpecie
	
	public boolean SameNameSpecie(String name){
		
		boolean out=false;
		
		for(int counter=0; counter<MAX_SPECIES; counter++){
			
			if(allSpecies[counter]!=null&&name.equals(allSpecies[counter].getName())){
				
				out=true;
				
			}
			
		}
		
		return out;
		
	}
	
	//sameScientificNameSpecie
	
	public boolean SameScientificNameSpecie(String scientificName){
		
		boolean out=false;
		
		for(int counter=0; counter<MAX_SPECIES; counter++){
			
			if(allSpecies[counter]!=null&&scientificName.equals(allSpecies[counter].getScientificName())){
				
				out=true;
				
			}
			
		}
		
		return out;
		
	}
	
	//SpecieExist
	
	public boolean SpecieExist(int specieIndex){
		
		boolean out=true;
		
		if(allSpecies[specieIndex]==null){
			
			out=false;
			
		}
		
		return out;
		
	}

	//FindSpecie
	
	public int FindSpecie(String name){
		
		int index =-1;
		
		for(int counter=0;counter<MAX_SPECIES&&index==-1;counter++){
			
			if(allSpecies[counter]!=null && allSpecies[counter].getName().equals(name)){
				
				index=counter;
				
			}
			
		}
		
		return index;
		
	}

	//Search habitat for specie
	
	public String SpecieHabitatSearcher(int specieIndex){
		
		String habitatsWhereIsLocated = "";
		
		for(int counter = 0; counter<MAX_SPECIES; counter++){
			
			if(allSpecies[counter]!=null){
				
				habitatsWhereIsLocated = allSpecies[counter].HabitatSearcher();
				
			}else{
				
				habitatsWhereIsLocated = "La especie no fue encontrada";
				
			}
			
		}
		
		return habitatsWhereIsLocated;
	}
	
	//SpeciesAvailable
	
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
	
	//EmptyIndexWetland
	
	public int EmptyIndexWetland(){
		
		int emptyIndex=-1;
		
		for (int counter=0; counter < MAX_WETLANDS&&emptyIndex==-1; counter++){
			
			if(allWetLands[counter]==null){
				emptyIndex=counter;
			}
		}
		
		return emptyIndex;
		
	}
	
	//FindWetland
	
	public int FindWetland(String name){
		
		int index =-1;
		
		for(int counter=0;counter<MAX_WETLANDS&&index==-1;counter++){
			
			if(allWetLands[counter]!=null && allWetLands[counter].getName().equals(name)){
				
				index=counter;
				
			}
			
		}
		
		return index;
		
	}
	
	//addWetland
	
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
	
	//SameNameWetland
	
	public boolean SameNameWetland(String name){
		
		boolean out=false;
		
		for(int counter=0; counter<MAX_WETLANDS; counter++){
			
			if(allWetLands[counter]!=null&&name.equals(allWetLands[counter].getName())){
				
				out=true;
				
			}
			
		}
		
		return out;
		
	}
	
	//EmptyIndexInArray
	
	public int EmptyEventIndexForWetland(int index){
		
		int emptyIndex;
		
		emptyIndex=allWetLands[index].EmptyIndexEvent();
		
		return emptyIndex;
	}
	
	//addEvent
	
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
	}
	
	//WetlandsAvailable
	
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
	
	
	//addSpecieToWetland
	
	public void addSpecieToWetland(String name, int specieIndex){
		
		int indexWetland;
		indexWetland = FindWetland(name);
		Specie newSpecieWetland = allSpecies[specieIndex];
			
			allWetLands[indexWetland].addSpecie(newSpecieWetland);
			
			allSpecies[specieIndex].addHabitat(allWetLands[indexWetland]);	
		
	}
	
	public int NumOfMaintenanceForWetland(int wetlandIndex){
		
		int numOfMaintenance=0;
		
		numOfMaintenance = allWetLands[wetlandIndex].NumOfMaintenance();
		
		return numOfMaintenance;
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
	
	
	/**
	* Description: search for the wetland with most fauna 
	* @return MostFauna WetLand, returns the wetland with most fauna
	*/
	
	
	/** To continue
	public WetLand WetLandMostFauna (){
		
		WetLand MostFauna;
		
		
		return MostFauna;
	}*/
}