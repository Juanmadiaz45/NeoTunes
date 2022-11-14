package model;

public abstract class Producer extends User{

    private String pname;
    private String url;

    /**
     * Producer, 
     * @param pname producer name.
     * @param url url of the producer identifier image.
     * @param nickname producer nickname.
     * @param cc producer identifier document.
     */

    public Producer(String pname, String url, String nickname, String cc){
        super(nickname, cc);
        this.pname = pname;
        this.url = url;
    }

    public String getName(){
        return pname;
    }

    public void setName(String name){
        this.pname = name;
    }

    public String getUrl(){
        return url;
    }

    public void setUrl(String url){
        this.url = url;
    }
}