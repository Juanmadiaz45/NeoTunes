package model;
import java.util.ArrayList;

public class Premium extends Consumer{

    private ArrayList<Playlist> playlists;
    private ArrayList<Song> songs;
    private ArrayList<Podcast> podcasts;

    /**
     * Premium premium consumer constructor.
     * @param nickname premium consumer nickname.
     * @param cc premium consumer identifier document.
     */

    public Premium(String cc, String nickname){
        super(nickname, cc);
        playlists = new ArrayList<Playlist>();
        songs = new ArrayList<Song>();
        podcasts = new ArrayList<Podcast>();
    }

    /**
     * addPlaylistP the method adds playlist for the premium consumer.
     * @param name playlist name.
     * @param optionCode playlist type.
     * @return validation message for the creation of the new playlist.
     */

    public String addPlaylistP(String name, int optionCode){
        String msj = "Playlist agregada.";
        boolean isEmpty = true;
        for(int i = 0; i < playlists.size() && !isEmpty; i++){
            if(playlists.get(i).getName().equalsIgnoreCase(name)){
                msj = "La lista de reproduccion ya existe!!";
            }else{
                playlists.add(new Playlist(name, optionCode));
                msj = "Playlist agregada.";
                isEmpty = false;
            }
        }
        return msj;
    }

    public Playlist searchPlaylist(String name){
        Playlist playlist =null;
        boolean isFound = false;
         for(int i=0;i<playlists.size() && !isFound ;i++){
            if( playlists.get(i).getName().equalsIgnoreCase(name)){
                playlist = playlists.get(i);
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
     * removeAudioToPlaylistP remove a song or podcast from a playlist.
     * @param name playlist name.
     * @return validation message when removing an item.
     */

    public String removeAudioToPlaylistP(String aname){
        String msj = "";
        boolean isEmpty = false;
        for(int i = 0; i < playlists.size() && !isEmpty; i++){
            if(playlists.get(i).getName().equalsIgnoreCase(aname)){
                msj = playlists.get(i).remove(aname);
                isEmpty = true;
            }
        }
        return msj;
    }

}