package model;

public class Song extends Audio{

    private String album;
    private double value;
    private int numberOfTimesSold;
    private int genders;

    /**
     * Song song class constructor.
     * @param name song name.
     * @param urlImage url of the identifying image of the song.
     * @param duration song duration.
     * @param album name of the album to which the song belongs.
     * @param value dollar value of the song.
     * @param genders song gender.
     */

    public Song(String name, String urlImage, double duration, String album, double value, int genders){
        super(name, urlImage, duration);
        this.album = album;
        this.value = value;
        this.genders = genders;
        numberOfTimesSold = 0;

        Genders sGender = null;
        switch(genders){
            case 1:
                sGender = Genders.ROCK;
                break;
            case 2:
                sGender = Genders.POP;
                break;
            case 3:
                sGender = Genders.TRAP;
                break;
            case 4:
                sGender = Genders.HOUSE;
                break;

            default:
                System.out.println("Opcion invalida.");
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

}