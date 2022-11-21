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
				"6. Compartir una lista de reproduccion.\n" +
				"7. Simular la reproduccion de una cancion o podcast (estandar y premium).\n" +
				"8. Comprar una cancion.\n" +
				"9. Generar informes con los datos registrados.\n" +
				"0. Exit. " +
				"\n");
		option = reader.nextInt(); 

		return option; 
	}

	public void executeOption(int option){

        String producerType = "";
        String owner = "";
        String playlistname = "";
        int optionCode = 0;
        int option2 = 0;
        String pname = "";
        int genres = 0;
        int category = 0;
        String description = "";
        String consumerType = "";
        String audioType = "";
        String urlImage = "";
        String album = "";
        double value = 0;
        double duration = 0;
        String nickname = "";
        String cc = "";
        String name = "";
        String url = "";
        String msj = "";

		switch(option){
			case 1: 

                System.out.println("Ingrese el tipo de productor a agregar. (Artista o Creador): ");
                producerType = reader.next();

                if(producerType.equalsIgnoreCase("Artista")){
                    System.out.println("\nIngrese el nombre del artista: ");
                    pname = reader.next();
                    reader.nextLine();
                    System.out.println("\nIngrese la cedula del artista: ");
                    cc = reader.next();
                    reader.nextLine();
                    System.out.println("\nIngrese el nickname del artista: ");
                    nickname = reader.next();
                    reader.nextLine();
                    System.out.println("\nIngrese el URL con la foto o imagen distintiva: ");
                    url = reader.next();
                    reader.nextLine();

                    User artist = new Artist(pname, cc, nickname, url);  

                    controller.addUsers(artist);

                    if(controller.addUsers(artist) == true){
                        msj = "\nArtista agregado.";
                        System.out.println(msj);
                    }else{
                        msj = "No se puedo agregar al artista.";
                        System.out.println(msj);
                    }
                }else{

                    if(producerType.equalsIgnoreCase("Creador")){
                        System.out.println("\nIngrese el nombre del creador de contenido: ");
                        pname = reader.next();
                        reader.nextLine();
                        System.out.println("\nIngrese la cedula del creador de contenido: ");
                        cc = reader.next();
                        reader.nextLine();
                        System.out.println("\nIngrese el nickname del creador de contenido: ");
                        nickname = reader.next();
                        reader.nextLine();
                        System.out.println("\nIngrese el URL con la foto o imagen distintiva: ");
                        url = reader.next();
                        reader.nextLine();

                        User contentcreator = new ContentCreator(pname, cc, nickname, url);  

                        controller.addUsers(contentcreator);

                        if(controller.addUsers(contentcreator) == true){
                            msj = "\nCreador de contenido agregado.";
                            System.out.println(msj);
                        }else{
                             msj = "No se puedo agregar al creador de contenido.";
                            System.out.println(msj);
                        }
                    }else{
                    System.out.println("\nEl tipo de productor ingresado no es artista ni creador.");
                    }
                }
                
				break;

			case 2:

                System.out.println("\nIngrese el tipo de consumidor a agregar. (Estandar o Premium): ");
                consumerType = reader.next();

                if(consumerType.equalsIgnoreCase("Estandar")){
                    System.out.println("\nIngrese la cedula del consumidor estandar: ");
                    cc = reader.next();
                    reader.nextLine();
                    System.out.println("\nIngrese el nickname del consumidor estandar: ");
                    nickname = reader.next();

                    Consumer standard = new Standard(cc, nickname);

                    controller.addUsers(standard);

                    if(controller.addUsers(standard) == true){
                        msj = "\nConsumidor estandar agregado.";
                        System.out.println(msj);
                    }else{
                        msj = "No se puedo agregar al consumidor estandar.";
                        System.out.println(msj);
                    }
                }else{
                    if(consumerType.equalsIgnoreCase("Premium")){
                        System.out.println("\nIngrese la cedula del consumidor premium: ");
                        cc = reader.next();
                        reader.nextLine();
                        System.out.println("\nIngrese el nickname del consumidor premium: ");
                        nickname = reader.next();

                        User premium = new Premium(nickname, cc);

                        controller.addUsers(premium);

                        if(controller.addUsers(premium) == true){
                            msj = "\nConsumidor premium agregado.";
                            System.out.println(msj);
                        }else{
                            msj = "No se puedo agregar al consumidor premium.";
                            System.out.println(msj);
                        }
                    }else{
                        msj = "\nEl tipo de consumidor ingresado no es estandar ni premium.";
                        System.out.println(msj);
                        }   
                }

				break; 

			case 3: 

                System.out.println("\nIngrese el tipo de audio a agregar. (Cancion o Podcast): ");
                audioType = reader.next();

                if(audioType.equalsIgnoreCase("Cancion")){
                    System.out.println("\nIngres el nombre de la cancion: ");
                    name = reader.next();
                    reader.nextLine();
                    System.out.println("\nIngrese el url de la imagen representativa: ");
                    urlImage = reader.next();
                    reader.nextLine();
                    System.out.println("\nIngrese el nombre del propietario de la cancion: ");
                    owner = reader.next();
                    reader.nextLine();
                    System.out.println("\nIngrese la duracion (en segundos) de la cancion: ");
                    duration = reader.nextDouble();
                    System.out.println("\nIngrese el nombre del album: ");
                    album = reader.next();
                    reader.nextLine();
                    System.out.println("\nIngrese el precio de la cancion: ");
                    value = reader.nextDouble();

                    do{
                        System.out.println("\nIngrese el tipo de genero de la cancion: ");
                        msj = controller.printGendersEnum();
                        System.out.println(msj);
                        genres = reader.nextInt();
                    }while(genres != 1 && genres != 2 && genres != 3 && genres != 4);

                    Audio song = new Song(name, owner, urlImage, duration, album, value, genres);

                    controller.addAudios(song);

                    if(controller.addAudios(song) == true){
                        msj = "\nCancion agregada.";
                        System.out.println(msj);
                    }else{
                        msj = "No se puedo agregar la cancion.";
                        System.out.println(msj);
                    }
                }else{
                    if(audioType.equalsIgnoreCase("Podcast")){
                        System.out.println("\nIngres el nombre del podcast: ");
                        name = reader.next();
                        reader.nextLine();
                        System.out.println("\nIngrese el url de la imagen representativa: ");
                        urlImage = reader.next();
                        reader.nextLine();
                        System.out.println("\nIngrese el nombre del propietario de la cancion: ");
                        owner = reader.next();
                        reader.nextLine();
                        System.out.println("\nIngrese la duracion (en segundos) del podcast: ");
                        duration = reader.nextDouble();
                        System.out.println("\nIngrese la descripcion del podcast: ");
                        description = reader.next();
                        reader.nextLine();

                        do{

                            System.out.println("\nIngrese la categoria del podcast: ");
                            msj = controller.printPodcastCategory();
                            System.out.println(msj);
                            category = reader.nextInt();

                        }while(category != 1 && category != 2 && category != 3 && category != 4);

                        Audio podcast = new Podcast(name, owner, urlImage, duration, description, category);

                        controller.addAudios(podcast);

                        if(controller.addAudios(podcast) == true){
                            msj = "\nPodcast agregado.";
                            System.out.println(msj);
                        }else{
                            msj = "\nNo se puedo agregar el podcast.";
                            System.out.println(msj);
                        }
                    }else{
                        msj = "\nEl tipo de audio ingresado no es una cancion ni un podcast.";
                        System.out.println(msj);
                        }   
                }
				
				break; 

			case 4: 

                System.out.println("\nIngrese el usuario a agregar la playlist: ");
                nickname = reader.next();
                reader.nextLine();

                System.out.println("\nIngrese el nombre de la playlist: ");
                playlistname = reader.next();
                reader.nextLine();

                do{
                    System.out.println("\nIngrese el tipo de playlist: \n1. Solo canciones. \n2. Solo podcast. \n3. Canciones y podcast.");
                    optionCode = reader.nextInt();
                    
                }while(optionCode != 1 && optionCode != 2 && optionCode != 3);

                msj = controller.addPlaylist(nickname, playlistname, optionCode);
                System.out.println(msj);

				break; 

			case 5: 

                System.out.println("\nIngrese la accion que desea realizar. \n1. Agregar una cancion. \n2. Eliminar una cancion.");
                option2 = reader.nextInt();

                msj = controller.printAudios();
                System.out.println(msj);
                
                System.out.println("\nIngrese el nickname del usuario propietario de la playlist: ");
                nickname = reader.next();
                reader.nextLine();
                System.out.println("\nIngrese el nombre de la playlist: ");
                playlistname = reader.next();
                reader.nextLine();

                if(option2 == 1){
                    System.out.println("\nIngrese el nombre del audio a agregar a la playlist: ");
                    name = reader.next();
                    reader.nextLine();
                    System.out.println("\nIngrese el nombre del autor del audio: ");
                    owner = reader.next();
                    reader.nextLine();

                    msj = controller.addNewAudio(name, owner, playlistname, nickname);
                    System.out.println(msj);

                } else if(option2 == 2){
                    System.out.println("\nIngrese el nombre del audio a remover de la playlist: ");
                    name = reader.next();
                    reader.nextLine();
                    System.out.println("\nIngrese el nombre del autor del audio: ");
                    owner = reader.next();
                    reader.nextLine();

                    msj = controller.removeAudio(name, owner, playlistname, nickname);
                    System.out.println(msj);   
                }else{
                    System.out.println("\nOpcion invalida.");
                }            

				break; 

			case 6:

                System.out.println("\nIngrese el nickname del usuario propietario de la playlist: ");
                nickname = reader.next();
                System.out.println("\nIngrese el nombre de la playlist: ");
                playlistname = reader.next();

                msj = controller.sharePlaylist(nickname, playlistname);
                System.out.println(msj);

				break;

			case 7:

                System.out.println("\nIngrese su nickname de usuario: ");
                nickname = reader.next();
                reader.nextLine();
                System.out.println("\nIngrese el nombre del audio: ");
                name = reader.next();
                reader.nextLine();
                System.out.println("\nIngrese el nombre del propietario del audio: ");
                owner = reader.next();
                reader.nextLine();

                msj = controller.playSound(nickname, name, owner);
                System.out.println(msj);

				break;

			case 8:

                System.out.println("\nIngrese el nickname del usuario: ");
                nickname = reader.next();
                reader.nextLine();
                System.out.println("\nIngrese el nombre de la cancion: ");
                name = reader.next();
                reader.nextLine();
                System.out.println("\nIngrese el nombre del propietario de la cancion: ");
                owner = reader.next();
                reader.nextLine();

                msj = controller.buySong(nickname, name, owner);
                System.out.println(msj);

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