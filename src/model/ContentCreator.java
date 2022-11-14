package model;

public class ContentCreator extends Producer{

    /**
     * ContentCreator
     * @param name content creator name.
     * @param url content creator signature image url.
     * @param nickname content creator nickname.
     * @param cc content creator identifier document.
     */

    public ContentCreator(String pname, String url, String nickname, String cc){
        super(pname, url, nickname, cc);
    }
}