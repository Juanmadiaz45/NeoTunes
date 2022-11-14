package model;

public class Artist extends Producer{

    /**
     * Artist artist class constructor.
     * @param name artist name.
     * @param url url artist identifier picture.
     * @param nickname artist nickname.
     * @param cc artiist identification document.
     */

    public Artist(String pname, String url, String nickname, String cc){
        super(pname, url, nickname, cc);
    }
}