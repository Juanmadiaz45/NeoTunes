package model;

public abstract class Producer extends User{

    private String name;
    private String url;

    public Producer(String name, String url, String nickname, String cc){
        super(nickname, cc);
        this.name = name;
        this.url = url;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getUrl(){
        return url;
    }

    public void setUrl(String url){
        this.url = url;
    }
}