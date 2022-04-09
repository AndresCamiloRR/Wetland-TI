package ui;
import java.util.Scanner;

import model.Dagma;

/** Main<p>
* class designed to be the user interace to interact with the user and fulfill it's requests
* */

public class Main{
	
	private Dagma dagma = new Dagma();
	
	private Scanner scan;
	
	public Main(){
		
		scan = new Scanner(System.in);
		
	}
	
	/**
	* Description: fulfill the user requests 
	*/
	
	public static void main (String[] args){
		
		Main userInterface= new Main();
		
		int option;
		
		do{
			option= userInterface.showMenu();
			userInterface.executeOption(option);
			
		}while (option!=0);
		
	}
	
	public int showMenu() {
		int option=0;

		System.out.println(" Bienvenido, que desea hacer? \n"+
		"(1) Crear un humedal \n"+
		"(2) Registrar una nueva especie en un humedal \n"+
		"(3) Registrar un evento en el humeda \n"+
		"(4) Cantidad de mantenimientos que recibieron los humedales en algun año \n"+
		"(5) Humedal con menos especies de flora \n"+
		"(6) Humedales en los que se encuentra una especie \n"+
		"(7) Informacion sobre los humedales \n"+
		"(8) Humedal con mayor cantidad de animales \n"+
		"(0) Salir"
				);
		option= scan.nextInt();
		return option;
	}
	
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
			
			break;
		default:
			System.out.println("Error, opción no válida");
		
		}
	}
	
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
		
			System.out.println("El humedal ha sido añadido");
			
		}else{
			
			System.out.println("Lo sentimos pero no hay espacio para mas humedales");
			
		}
	}
	
	public void createSpecie(){
		
		int wereToAdd;
		int indexSpecie;
		
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
			
			scan.next();
			wetlandName = scan.next();
				
			if(dagma.FindWetland(wetlandName)!=-1){
				
				System.out.println("Ingrese el numero de la especie que desea añadir");
					
				System.out.println(dagma.SpeciesAvailable());
					
				indexSpecie = scan.nextInt();
					
				indexSpecie--;
				
				if(dagma.SpecieExist(indexSpecie)==false){
					
					System.out.println("La especie no existe");
					
				}else{
					
					if(indexSpecie>=0&&dagma.EmptyIndexSpecie()!=-1){
						
						dagma.addSpecieToWetland(wetlandName, indexSpecie);
						
						System.out.println("La especie ha sido añadida");
						
					}else{
					
						System.out.println("No hay espacio para mas especies en el humedal");
						
					}
				}
					
			}else{
			
			System.out.println("El humedal no fue encontrado :c");
				
			}
			
			
			
			
		}	
	}
	
	
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
				System.out.println("Ingrese el año del evento ");
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
	
	
	public void NumOfMaintenanceForWetland(){
		
		String wetlandName;
			
		System.out.println("Ingrese el nombre del Wetland del que desea descubrir el numero de mantenimientos");
			
		System.out.println(dagma.WetlandsAvailable());
			
		wetlandName = scan.next();
		
		int index = dagma.FindWetland(wetlandName);
			
		if(index!=-1){
			
			System.out.println( wetlandName+ " ha tenido " + dagma.NumOfMaintenanceForWetland(index) + " mantenimientos");
			
		}else{
			
			System.out.println("El humedal no fue encontrado");
			
		}
		
	}
	
	public void WetLandLessFlora(){
		
		System.out.println(dagma.WetLandLessFlora());
		
	}
	
	public void HabitatSearcher(){
		
		int specieIndex=-1;
		
		System.out.println("Ingrese el numero de la especie que desea consultar sus habitats");
		
		System.out.println(dagma.SpeciesAvailable());
		
		specieIndex=scan.nextInt();
		
		specieIndex--;
		
		if(dagma.SpecieExist(specieIndex)){
			
			System.out.println(dagma.SpecieHabitatSearcher(specieIndex));
			
		}else{
			
			System.out.println("Lo sentimos pero la especie no existe");
			
		}
		
		
		
	}
	
	public void AllWetlandsInfo(){
		
		System.out.println(dagma.toString());
		
	}
}