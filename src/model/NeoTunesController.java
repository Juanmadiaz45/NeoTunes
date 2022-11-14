package model;
import java.util.ArrayList;

public class NeoTunesController{

    private ArrayList<User> users;
    private ArrayList<Audio> audios;
    private ArrayList<Playlist> playlists;

    //arraylist initialization.

    public NeoTunesController(){
        users = new ArrayList<User>();
        audios = new ArrayList<Audio>();
        playlists = new ArrayList<Playlist>();
    }

    /**
     * addProducers through the arraylist artists and content creators type producers are added.
     * @param user artists or content creators type producers.
     * @return creation boolean.
     */

    public boolean addUsers(User user){
        return users.add(user);
    }

    /**
     * addAudios through the arraylist songs and podcasts type audios are added.
     * @param audio songs or podcasts type audios.
     * @return creation boolean.
     */

    public boolean addAudios(Audio audio){
        return audios.add(audio);
    }

    /**
     * searchUserByNickname search for a user by name in the arraylist of users.
     * @param nickname user nickname.
     * @return position in which the searched user is located.
     */

    public int searchUserByNickname(String nickname){
        int pos = -1;
        boolean isFound = false;
        for(int i = 0; i < users.size() && !isFound; i++){
            if(nickname.equalsIgnoreCase(users.get(i).getNickname())){
                pos = i;
                isFound = true;
            }
        }
        return pos;
    }

    /**
     * searchAudioByProducer search for the position in which an audio of a specific author is found.
     * @param name audio name.
     * @param owner audio owner.
     * @return position in which the searched audio is located.
     */

    public int searchAudioByProducer(String name, String owner){
        int pos = -1;
        boolean isFound = false;
        for(int i = 0; i < audios.size() && !isFound; i++){
            if(name.equalsIgnoreCase(audios.get(i).getName())){
                if(owner.equalsIgnoreCase(audios.get(i).getOwner())){
                    pos = i;
                    isFound = true;
                }
            }
        }
        return pos;
    }

    /**
     * searchPlaylistByName search for a playlist by name in the arraylist of users.
     * @param playlistname playlist name.
     * @return position in which the searched playlist is located.
     */

    public int searchPlaylistByName(String playlistname){
        int pos = -1;
        boolean isFound = false;
        for(int i = 0; i < playlists.size() && !isFound; i++){
            if(playlistname.equalsIgnoreCase(playlists.get(i).getName())){
                pos = i;
                isFound = true;
            }
        }
        return pos;
    }

    /**
     * addNewAudio add previously recorded audio to a specified playlist.
     * @param name audio name.
     * @param owner audio owner.
     * @param playlistname playlist name.
     * @param nickname nickname of the user who owns the playlist.
     * @return validation message.
     */

    public String addNewAudio(String name, String owner, String playlistname, String nickname){
        String msj = "";
        int posAudio = searchAudioByProducer(name, owner);
        int posPlaylist = searchPlaylistByName(playlistname);
        int posUser = searchUserByNickname(nickname);
        Audio newAudio = audios.get(posAudio);
        if(posUser != -1){
            if(posAudio != -1){
                if(posPlaylist != -1){
                    if(audios.get(posAudio) instanceof Song){
                        ((Consumer)(users.get(posUser))).getPlaylists().get(posPlaylist).addSong(newAudio);
                        msj = "Cancion agregada.";
                    }else{
                        if(audios.get(posAudio) instanceof Podcast){
                            ((Consumer)(users.get(posUser))).getPlaylists().get(posPlaylist).addPodcast(newAudio);
                            msj = "Podcast agregado.";
                        }
                    }
                    }else{
                        msj = "No se encuentra la playlist.";
                    }
                }else{
                    msj = "No se encuentra el audio.";
                }
            }else{
                msj = "No se encuentra el usuario.";
            }
        return msj;
    }

    /**
     * removeAudio remove an audio from a specific playlist.
     * @param name audio name.
     * @param owner audio owner.
     * @param playlistname playlist name.
     * @param nickname nickname of the user who owns the playlist.
     * @return validation message.
     */

    public String removeAudio(String name, String owner, String playlistname, String nickname){
        String msj = "";
        int posAudio = searchAudioByProducer(name, owner);
        int posPlaylist = searchPlaylistByName(playlistname);
        int posUser = searchUserByNickname(nickname);
        if(posUser != -1){
            if(posPlaylist != -1){
                if(posAudio != -1){
                    if(audios.get(posAudio) instanceof Song){
                        ((Consumer)(users.get(posUser))).getPlaylists().get(posPlaylist).removeAudio(posAudio);
                        msj = "Cancion eliminada.";
                    }else{
                        if(audios.get(posAudio) instanceof Podcast){
                            ((Consumer)(users.get(posUser))).getPlaylists().get(posPlaylist).removeAudio(posAudio);
                            msj = "Podcast eliminado.";
                        }
                    }
                }else{
                    msj = "No se encuentra el audio.";
                }
            }else{
                msj = "No se encuentra la playlist.";
            }
        }else{
            msj = "No se encuentra el usuario.";
        }
        return msj;
    }

    /**
     * printGendersEnum prints the numbering of genre types in order.
     * @return listed song genres.
     */

    public String printGendersEnum(){
        String msj = "";
        Genders[] genders = Genders.values();
        for(int i = 0; i < genders.length; i++){
            msj += ((i+1) + ". " + genders[i] + "\n");
        }
        return msj;
    }

    public String printAudios(){
        String msj = "";
        return msj;
    }


    /**
     * printPodcastCategory prints the numbering of categorys types in order.
     * @return listed podcasts categorys.
     */

    public String printPodcastCategory(){
        String msj = "";
        PodcastCategory[] category = PodcastCategory.values();
        for(int i = 0; i < category.length; i++){
            msj += ((i+1) + ". " + category[i] + "\n");
        }
        return msj;
    }

    /**
     * addPlaylist adds a playlist depending on the type of user requesting it.
     * @param nickname nickname of the user who owns the playlist.
     * @param playlistname playlist name.
     * @param optionCode playlist type option.
     * @return validation message.
     */

    public String addPlaylist(String nickname, String playlistname, int optionCode){
        String msj = "";
        Playlist newPlaylist = new Playlist(playlistname, optionCode);
        int posUser = searchUserByNickname(nickname);
        if(posUser != -1){
            if(users.get(posUser) instanceof Premium){
                ((Consumer)(users.get(posUser))).getPlaylists().add(newPlaylist);
                msj = "Playlist agregada.";
            }else{
                if(users.get(posUser) instanceof Standard){
                    ((Consumer)(users.get(posUser))).getPlaylists().add(newPlaylist);
                    msj = "Playlist agregada.";
                }else{
                    msj = "Numero limite de playlist alcanzado.";
                }
                }
            }else{
                msj = "No se encuentra el usuario consumidor.";
        }
        return msj;
    }
}