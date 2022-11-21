package model;

public abstract class Audio{

    protected String name;
    protected String owner;
    protected String urlImage;
    protected int numberOfPlays;
    protected double duration;

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
        this.numberOfPlays = numberOfPlays;
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

    public int setNumberOfPlays(){
        return numberOfPlays;
    }

    public String getUrlImage(){
        return urlImage;
    }

    public double getDuration(){
        return duration;
    }

    public abstract String toString();
}