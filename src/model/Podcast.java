package model;

public class Podcast extends Audio{

    private String description;
    private int category;

    /**
     * Podcast podcast class constructor.
     * @param name podcast name.
     * @param urlImage url of the identifying image of the podcast.
     * @param duration podcast duration.
     * @param description podcast description.
     * @param owner podcast owner.
     * @param category podcast category.
     */

    public Podcast(String name, String owner, String urlImage, double duration, String description, int category){
        super(name, urlImage, duration, owner);
        this.description = description;
        this.category = category;

        PodcastCategory pCategory = null;
        switch(category){
            case 1:
                pCategory = PodcastCategory.POLITICA;
            case 2:
                pCategory = PodcastCategory.ENTRETENIMIENTO;
            case 3:
                pCategory = PodcastCategory.VIDEOJUEGOS;
            case 4:
                pCategory = PodcastCategory.MODA;
            default:
                System.out.println("Opcion invalida.");
        }
    }

    public String getDescription(){
        return description;
    }

    @Override
    public String toString(){
        return "\n**Datos del podcast**\n" +
        "Nombre: " +  name + "\n" +
        "Porpietario: " +  owner + "\n" + 
        "Url: " +  urlImage + "\n" + 
        "Duracion: " +  duration + "\n" + 
        "Descripcion: " + description + "\n" +
        "Categoria: " +  category + "\n";

    }
}