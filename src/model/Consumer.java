package model;
import java.util.ArrayList;

public abstract class Consumer extends User{

    private ArrayList<Playlist> playlists;
    private ArrayList<Audio> audios;

    /**
     * Consumer consumer class constructor.
     * @param nickname consumer nickname.
     * @param cc consumer identifier document.
     */

    public Consumer(String nickname, String cc){
        super(nickname, cc);
        playlists = new ArrayList<Playlist>();
        audios = new ArrayList<Audio>();
    }

    /**
     * getPlaylist get the arraylist of playlists
     * @return array of playlists
     */

    public ArrayList<Playlist> getPlaylists(){
        return playlists;
    }

}