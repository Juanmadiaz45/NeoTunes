package model;

public class Song extends Audio{

    private String album;
    private double value;
    private int numberOfTimesSold;
    private int genres;

    /**
     * Song song class constructor.
     * @param name song name.
     * @param urlImage url of the identifying image of the song.
     * @param duration song duration.
     * @param album name of the album to which the song belongs.
     * @param value dollar value of the song.
     * @param owner song owner.
     * @param genres song gender.
     */

    public Song(String name, String owner, String urlImage, double duration, String album, double value, int genres){
        super(name, urlImage, duration, owner);
        this.album = album;
        this.value = value;
        this.genres = genres;
        numberOfTimesSold = 0;

        Genres sGenres = null;
        switch(genres){
            case 1:
                sGenres = Genres.ROCK;
                break;
            case 2:
                sGenres = Genres.POP;
                break;
            case 3:
                sGenres = Genres.TRAP;
                break;
            case 4:
                sGenres = Genres.HOUSE;
                break;

        }
    }

    public String getAlbum(){
        return album;
    }

    public double getValue(){
        return value;
    }

    public int getNumberOfTimesSold(){
        return numberOfTimesSold;
    }

    @Override
    public String toString(){
        return "\n**Datos del podcast**\n" +
        "Nombre: " +  name + "\n" +
        "Porpietario: " +  owner + "\n" + 
        "Url: " +  urlImage + "\n" + 
        "Duracion: " +  duration + "\n" + 
        "Album: " + album + "\n" +
        "Valor: " +  value + "\n" +
        "Genero: " +  genres;

    }

}