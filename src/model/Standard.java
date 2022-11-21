package model;

import java.util.ArrayList;

public class Standard extends Consumer{

    public static final int PLAYLIST_SIZE = 20;
    public static final int SONGS_LIMIT = 100;
    private Playlist[] playlists;
    private ArrayList<Audio> audios;
 
    /**
     * Standard, constructor of the standard consumer class.
     * @param nickname consumer standard nickname.
     * @param cc consumer standard identifier document.
     */

    public Standard(String nickname, String cc){
        super(nickname, cc);
        playlists = new Playlist[PLAYLIST_SIZE];
        audios = new ArrayList<Audio>();
    }

}