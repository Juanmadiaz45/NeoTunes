package model;

public class Standard extends Consumer{

    public static final int PLAYLIST_SIZE = 20;
    public static final int SONGS_LIMIT = 100;
    private Audio[] audios;
    private Playlist[] playlists;
 
    /**
     * Standard, constructor of the standard consumer class.
     * @param nickname consumer standard nickname.
     * @param cc consumer standard identifier document.
     */

    public Standard(String nickname, String cc){
        super(nickname, cc);
        audios = new Audio[SONGS_LIMIT];
        playlists = new Playlist[PLAYLIST_SIZE];

    }

    public Playlist searchPlaylist(String name){
        Playlist playlist =null;
        boolean isFound = false;
         for(int i = 0; i < PLAYLIST_SIZE && !isFound ;i++){
            if(playlists[i]!=null && playlists[i].getName().equals(name)){
                playlist=playlists[i];
                isFound = true;
            }
         }
    
        return playlist;
    }
    
}