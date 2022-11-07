package model;

public class Audio{

    private String name;
    private String urlImage;
    private int numberOfPlays;
    private double duration;

    /**
     * Audio audio class constructor.
     * @param name audio name.
     * @param urlImage url of the audio identifier image.
     * @param duration audio duration.
     */

    public Audio(String name, String urlImage, double duration){
        this.name = name;
        this.urlImage = urlImage;
        this.duration = duration;
        numberOfPlays = 0;
    }

    public String getName(){
        return name;
    }

    public int getNumberOfPlays(){
        return numberOfPlays;
    }

    public String getUrlImage(){
        return urlImage;
    }

    public double getDuration(){
        return duration;
    }
}