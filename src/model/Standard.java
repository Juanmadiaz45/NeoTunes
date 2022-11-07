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

    /**
     * addPlaylistS the method adds playlist for the standard consumer.
     * @param name playlist name.
     * @param optionCode playlist type.
     * @return validation message for the creation of the new playlist.
     */

    public String addPlaylistS(String name, int optionCode){
        String msj = "Playlist agregada.";
        Playlist newPlaylist = new Playlist(name, optionCode);
        boolean isEmpty = false;
        for(int i = 0; i < PLAYLIST_SIZE && !isEmpty; i++){
            if(playlists[i] == null){
                playlists[i] = newPlaylist;
                isEmpty = true;
                msj = "Playlist agregada.";
            }
        }
        return msj;
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

    public String addAudio(String name, int optionCode, Audio audio){
        String msj = "";
        Playlist playlist = searchPlaylist(name);
        if(optionCode == 1){
            playlist.getAudios().add(audio);
            msj = "Audio agregado.";
        }else if(optionCode == 2){
            playlist.getAudios().add(audio);
            msj = "Audio agregado.";
        }else if(optionCode == 3){
            playlist.getAudios().add(audio);
            msj = "Audio agregado.";
        }
        return msj;
    }

    /**
     * removeAudioToPlaylistS remove a song or podcast from a playlist.
     * @param name playlist name.
     * @return validation message when removing an item.
     */
    public String removeAudioToPlaylistS(String aname){
        String msj = "";
        boolean isEmpty = false;
        for(int i = 0; i < PLAYLIST_SIZE && !isEmpty; i++){
            if(playlists[i].getName().equalsIgnoreCase(aname)){
                msj = playlists[i].remove(aname);
                isEmpty = true;
            }
        }
        return msj;
    }
}