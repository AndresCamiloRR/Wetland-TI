package ui;
import java.util.Scanner;

import model.Dagma;

/** Main<p>
* class designed to be the user interace to interact with the user and fulfill it's requests
* */

public class Main{
	
	/**
	* dagma is an object of the Dagma type to interact with the model controller and call their methods
	* */
	
	private Dagma dagma = new Dagma();
	
	/**
	* scan is an object of the Scanner type to read all inputs that are written by the user
	* */
	
	private Scanner scan;
	
	/**
	 * Constructor of main 
	 */
	
	public Main(){
		
		scan = new Scanner(System.in);
		
	}
	
	/**
	* Description: Method Main that will call the methods from de Main Class
	*/
	
	public static void main (String[] args){
		
		Main userInterface= new Main();
		
		int option;
		
		do{
			option= userInterface.showMenu();
			userInterface.executeOption(option);
			
		}while (option!=0);
		
	}
	
	/**
	* Description: Method that will show the menu and read the user input
	*/
	
	public int showMenu() {
		int option=0;

		System.out.println(" Bienvenido, que desea hacer? \n"+
		"(1) Crear un humedal \n"+
		"(2) Registrar una nueva especie en un humedal \n"+
		"(3) Registrar un evento en el humedal \n"+
		"(4) Cantidad de mantenimientos que recibieron los humedales en algun ano \n"+
		"(5) Humedal con menos especies de flora \n"+
		"(6) Humedales en los que se encuentra una especie \n"+
		"(7) Infromacion sobre los humedales \n"+
		"(8) Humedal con mayor cantidad de fauna \n"+
		"(0) Salir"
				);
		option= scan.nextInt();
		return option;
	}
	
	/**
	* Description: Method that will show the menu and read the user input and will call the method that can fulfill the request
	* @param option int that contains the choice made by the user
	*/
	
	public void executeOption(int option) {
		
		switch(option) {
		case 0:
			System.out.println("Hasta luego");
			break;
		case 1:
			createWetland();
			break;
		case 2:
			createSpecie();
			break;
		case 3:
			addEvent();
			break;
		case 4:
			NumOfMaintenanceForWetland();
			break;
		case 5:
			WetLandLessFlora();
			break;
		case 6:
			HabitatSearcher();
			break;
		case 7:
			AllWetlandsInfo();
			break;
		case 8:
			WetLandMostFauna();
			break;
		default:
			System.out.println("Error, opci??n no v??lida");
		
		}
	}
	
	/**
	* Description: Method that ask the user for the inputs needed to create an object of wetland type check that the data is rigth, 
	* to then call dagma and hiw method addWetland and tell the user if the request was fulfill or not
	*/
	
	public void createWetland(){
		
		if(dagma.EmptyIndexWetland()!=-1){
			String name;
			int urbanOrRural;
			int publicOrPrivate;
			double area;
			String photoUrl;
			String nameOfZone;
			int protectedArea;
			String description;
			double percentageFilled;
		
			do{	
				System.out.println("Ingrese el nombre del humedal");
				name = scan.next();
			}while(dagma.SameNameWetland(name));
		
			do{
				System.out.println("Ingrese el tipo de zona en que se ubica el humedal urbana(1) rural(2)");
				urbanOrRural=scan.nextInt();
			}while(urbanOrRural!=1 && urbanOrRural!=2);
		
			do{
				System.out.println("La zona es publica(1) o privada(2)?");
				publicOrPrivate=scan.nextInt();
			}while(publicOrPrivate!=1 && publicOrPrivate!=2);
		
			System.out.println("Ingrese el area del humedal en metros cuadrados");
			area=scan.nextDouble();
		
			System.out.println("Ingrese una url donde se encuentre una foto del humedal");
			photoUrl=scan.next();
		
			System.out.println("Ingrese el nombre del barrio o corregimiento en que se ubica");
			nameOfZone=scan.next();
		
			do{
				System.out.println("Es un area protegida? si(1) no(2)");
				protectedArea=scan.nextInt();
			}while(protectedArea!=1 && protectedArea!=2);
			
			System.out.println("Ingrese una breve descripcion del actual plan de manejo ambiental del humedal");
			description=scan.next();
			
			
			System.out.println("Ingrese el actual porcentaje de cumplimiento del plan de manejo");
			percentageFilled=scan.nextDouble();
			
			dagma.addWetland(name, urbanOrRural, publicOrPrivate, area, photoUrl, nameOfZone, protectedArea, description, percentageFilled);
		
			System.out.println("El humedal ha sido anadido");
			
		}else{
			
			System.out.println("Lo sentimos pero no hay espacio para mas humedales");
			
		}
	}
	
	/**
	* Description: Method that ask the user if he wants to add a specie tho the general data base or add an existing specie to a wetland
	* if user picks the first choice the method will ask for the inputs needed to create an object of Specie type check that the data is rigth
	* to then call dagma and his method addSpecie, if the user picks the second choice the method will print the wetlands registered and ask the 
	* user to choose one, then it will shows the species registered on the general data base and ask the user to choose one, to then send the info
	* to the dagma method addSpecieToWetland and tell the user if the request was fulfill or not
	*/
	
	public void createSpecie(){
		
		int wereToAdd;
		String specieName;
		
		do{
			System.out.println("Elija una opcion\n (1) Anadir Especie a base de datos general \n (2) Anadir Especie a Wetland");
		
			wereToAdd = scan.nextInt();
			
		}while(wereToAdd!=1 && wereToAdd!=2);
		
		if(wereToAdd==1){
			
			if(dagma.EmptyIndexSpecie()!=-1){
				String name="";
				String scientificName="";
				int migratory;
				int type;
			
				do{	
					System.out.println("Ingrese el nombre de la especie");
					name = scan.next();
				}while(dagma.SameNameSpecie(name)||name.equals(""));
			
				do{	
					System.out.println("Ingrese el nombre cientifico de la especie");
					scientificName = scan.next();
				}while(dagma.SameScientificNameSpecie(scientificName)||scientificName.equals(""));
			
				do{
					System.out.println("La especie es migratoria Si(1) o No(2)?");
					migratory=scan.nextInt();
				}while(migratory!=1 && migratory!=2);
				
				do{
					System.out.println("La especie de que tipo es? \n Flora Terrestre(1) \n Flora acuatica(2) \n Ave(3) \n Mamifero(4) \n Especie acuatica(5)");
					type=scan.nextInt();
				}while(type<1 || type>5);
				
				dagma.addSpecie(name,scientificName,migratory, type);
				
				System.out.println("La especie ha sido anadida");
				
				name="";
				scientificName="";
				migratory=-1;
				type=-1;
				
			}else{
				
				System.out.println("Lo sentimos pero no hay espacio para mas especies");
			}	
			
		}else{
			
			String wetlandName;
			
			System.out.println("Ingrese el nombre del Wetland al que desea anadir la especie");
			
			System.out.println(dagma.WetlandsAvailable());

			wetlandName = scan.next();
				
			if(dagma.FindWetland(wetlandName)!=-1){
				
				System.out.println("Ingrese el nombre de la especie que desea anadir");
					
				System.out.println(dagma.SpeciesAvailable());
					
				specieName = scan.next();
				
				if(dagma.FindSpecie(specieName)==-1){
					
					System.out.println("La especie no existe");
					
				}else{
					
					if(dagma.EmptyIndexSpecie()!=-1){
						
						dagma.addSpecieToWetland(wetlandName, specieName);
						
						System.out.println("La especie ha sido anadida");
						
					}else{
					
						System.out.println("No hay espacio para mas especies en el humedal");
						
					}
				}
					
			}else{
			
			System.out.println("El humedal no fue encontrado :c");
				
			}
			
			
			
			
		}	
	}
	
	/**
	* Description: Method that ask the user for the wetland were he wants to add the event to ask for the inputs needed to create an object of Event type and send the inputs as parameters for the dagma method add event and tell the user if the request was fulfill or not
	*/
	
	public void addEvent(){
		
		String wetlandName;
		
		System.out.println("Ingrese el nombre del Wetland al que desea anadir el evento");
		
		System.out.println(dagma.WetlandsAvailable());
		
		wetlandName = scan.next();
		
		if(dagma.FindWetland(wetlandName)!=-1){
				
			int index = dagma.FindWetland(wetlandName);
				
			if(dagma.EmptyEventIndexForWetland(index)!=-1){
				
				
				int eventType;
				int day;
				int month;
				int year;
				String owner;
				double cost;
				String description;
			
				do{	System.out.println("Ingrese el tipo del evento \n(1) Mantenimientos \n(2) Visitas de colegio \n(3) Actividades de Mejoramiento \n(4) Celebraciones \n(5) Otro tipo de evento");
					
					eventType = scan.nextInt();
					
				}while(eventType<1 || eventType>5);
				
				System.out.println("Ingrese la fecha del evento ");
				System.out.println("Ingrese el dia del evento ");
				day = scan.nextInt();
				System.out.println("Ingrese el mes del evento ");
				month = scan.nextInt();
				System.out.println("Ingrese el a??o del evento ");
				year = scan.nextInt();
		
				System.out.println("Quien realiza el evento?");
				owner = scan.next();
			
				System.out.println("Cual es el costo?");
				cost = scan.nextDouble();
			
				System.out.println("Ingrese una descripcion");
				description = scan.next();
				
				dagma.addEvent(index, eventType, day, month, year, owner, cost, description);
			
			}else{
			
				System.out.println("No hay mas espacios para eventos");
				
			}
		}else{
			
				System.out.println("El humedal no fue encontrado :c");
				
			}
	}
	
	/**
	* Description: Method that ask the user for the wetland that we wants to consult to call the method getMaintenanceFromWetland from dagma and print his result
	*/
	
	public void NumOfMaintenanceForWetland(){
		
		String wetlandName;
			
		System.out.println("Ingrese el nombre del Wetland del que desea descubrir el numero de mantenimientos");
			
		System.out.println(dagma.WetlandsAvailable());
			
		wetlandName = scan.next();
		
		int index = dagma.FindWetland(wetlandName);
			
		if(index!=-1){
			
			System.out.println( wetlandName+ " ha tenido " + dagma.getMaintenanceFromWetland(index) + " mantenimientos");
			
		}else{
			
			System.out.println("El humedal no fue encontrado");
			
		}
		
	}
	
	/**
	* Description: Method that will call the method WetLandLessFlora from dagma and print his result
	*/
	
	public void WetLandLessFlora(){
		
		System.out.println(dagma.WetLandLessFlora());
		
	}
	
	/**
	* Description: Method that will print the species that are registered on the data base, ask the user to choose one and
	* call the method SpecieHabitatSearcher from dagma and print his result
	*/
	
	public void HabitatSearcher(){
		
		String specieName;
		
		System.out.println("Ingrese el nombre de la especie que desea consultar sus habitats");
		
		System.out.println(dagma.SpeciesAvailable());
		
		specieName=scan.next();
		
		if(dagma.FindSpecie(specieName)!=-1){
			
			System.out.println(dagma.SpecieHabitatSearcher(dagma.FindSpecie(specieName)));
			
		}else{
			
			System.out.println("La especie no ha sido encontrado");
			
		}
		
		
		
	}
	
	/**
	* Description: Method that will call the method WetLandMostFauna from dagma and print his result
	*/
	
	public void WetLandMostFauna(){
		
		System.out.println(dagma.WetLandMostFauna());
		
	}
	
	/**
	* Description: Method that will call the method toString from dagma and print his result
	*/
	
	public void AllWetlandsInfo(){
		
		System.out.println(dagma.toString());
		
	}
}