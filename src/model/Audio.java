package model;

public class Audio{

    private String name;
    private String owner;
    private String urlImage;
    private int numberOfPlays;
    private double duration;

    /**
     * Audio audio class constructor.
     * @param name audio name.
     * @param urlImage url of the audio identifier image.
     * @param duration audio duration.
     * @param owner audio owner.
     */

    public Audio(String name, String urlImage, double duration, String owner){
        this.name = name;
        this.urlImage = urlImage;
        this.duration = duration;
        this.owner = owner;
        numberOfPlays = 0;
    }

    public String getName(){
        return name;
    }

    public String getOwner(){
        return owner;
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