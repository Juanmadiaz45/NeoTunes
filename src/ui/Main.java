package ui;

import model.*;
import java.util.Scanner;

public class Main{

	private Scanner reader;
	private NeoTunesController controller;

	public Main(){
		reader = new Scanner(System.in);
		controller = new NeoTunesController();
	}

	public NeoTunesController getNeoTunes(){
		return controller;
	}

	public Scanner getReader(){
		return reader;
	}

	public static void main(String[] args){
		Main main = new Main();
		int option = 0;
		do{
			option = main.getOptionShowMenu(); 
			main.executeOption(option);
		}
		while(option != 0);
		main.getReader().close();
	}

	public int getOptionShowMenu(){
		int option = 0; 
		System.out.println("\n" +
			"<<<<< Bienvenido a NeoTunes >>>>>");
		System.out.println(
				"1. Registrar usuarios productores, artistas y creadores de contenido.\n" +
				"2. Registrar usuarios consumidores, estandar y premium.\n" +
				"3. Registrar canciones y podcasts.\n" +
				"4. Crear una lista de reproduccion.\n" +
				"5. Editar una lista de reproduccion.\n" +
				"6. \n" +
				"7. \n" +
				"8. \n" +
				"9. \n" +
				"0. Exit. " +
				"\n");
		option = reader.nextInt(); 

		return option; 
	}

	public void executeOption(int option){

        String producerType = "";
        String consumerType = "";
        String nickname = "";
        String cc = "";
        String name = "";
        String url = "";
        String msj = "";

		switch(option){
			case 1: 

                System.out.println("Ingrese el tipo de productor a agregar. (Artista o Creador): ");
                producerType = reader.next();

                if(producerType.equals("Artista")){
                    System.out.println("Ingrese el nombre del artista: ");
                    name = reader.next();
                    System.out.println("Ingrese la cedula del artista: ");
                    cc = reader.next();
                    System.out.println("Ingrese el nickname del artista: ");
                    nickname = reader.next();
                    System.out.println("Ingrese el URL con la foto o imagen distintiva: ");
                    url = reader.next();

                    Producer artist = new Artist(name, cc, nickname, url);  

                    controller.addProducers(artist);

                    if(controller.addProducers(artist) == true){
                        msj = "Artista agregado.";
                        System.out.println(msj);
                    }else{
                        msj = "No se puedo agregar al artista.";
                        System.out.println(msj);
                    }
                }else{

                    if(producerType.equals("Creador")){
                        System.out.println("Ingrese el nombre del creador de contenido: ");
                        name = reader.next();
                        System.out.println("Ingrese la cedula del creador de contenido: ");
                        cc = reader.next();
                        System.out.println("Ingrese el nickname del creador de contenido: ");
                        nickname = reader.next();
                        System.out.println("Ingrese el URL con la foto o imagen distintiva: ");
                        url = reader.next();

                        Producer contentcreator = new ContentCreator(name, cc, nickname, url);  

                        controller.addProducers(contentcreator);

                        if(controller.addProducers(contentcreator) == true){
                            msj = "Creador de contenido agregado.";
                            System.out.println(msj);
                        }else{
                             msj = "No se puedo agregar al creador de contenido.";
                            System.out.println(msj);
                        }
                    }else{
                    System.out.println("El tipo de productor ingresado no es artista ni creador. Ingrese la letra inicial en mayuscula.");
                    }
                }
                
				break;

			case 2:

                System.out.println("Ingrese el tipo de consumidor a agregar. (Estandar o Premium): ");
                consumerType = reader.next();

                if(consumerType.equals("Estandar")){
                    System.out.println("Ingrese la cedula del consumidor estandar: ");
                    cc = reader.next();
                    System.out.println("Ingrese el nickname del consumidor estandar: ");
                    nickname = reader.next();

                    Consumer standard = new Standard(nickname, cc);

                    controller.addConsumers(standard);

                    if(controller.addConsumers(standard) == true){
                        msj = "Consumidor estandar agregado.";
                        System.out.println(msj);
                    }else{
                        msj = "No se puedo agregar al consumidor estandar.";
                        System.out.println(msj);
                    }
                }else{
                    if(consumerType.equals("Premium")){
                        System.out.println("Ingrese la cedula del consumidor premium: ");
                        cc = reader.next();
                        System.out.println("Ingrese el nickname del consumidor premium: ");
                        nickname = reader.next();

                        Consumer premium = new Premium(nickname, cc);

                        controller.addConsumers(premium);

                        if(controller.addConsumers(premium) == true){
                            msj = "Consumidor premium agregado.";
                            System.out.println(msj);
                        }else{
                            msj = "No se puedo agregar al consumidor premium.";
                            System.out.println(msj);
                        }
                    }else{
                        msj = "El tipo de consumidor ingresado no es estandar ni premium. Ingrese la letra inicial en mayuscula.";
                        System.out.println(msj);
                         }   
                }

				break; 

			case 3: 

				
				break; 

			case 4: 	

				break; 

			case 5: 

				break; 

			case 6:

				break;

			case 7:

				break;

			case 8:

				break;

			case 9:

				break;

			case 0:
				System.out.println("Exit program.");
				break; 

			default: 
				System.out.println("Invalid Option");
				break; 
		}
	}

}