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
            if(playlistname.equalsIgnoreCase(playlists.get(i).getPlaylistname())){
                pos = i;
                isFound = true;
            }
        }
        return pos;
    }

    /**
     * sharePlaylist search for the playlist by the user who created it and its name.
     * @param nickname user nickname.
     * @param playlistname playlist name.
     * @return position in which the playlist is located.
     */

    public String sharePlaylist(String nickname, String playlistname){
        String msj = "";
        int posPlaylist = searchPlaylistByName(playlistname);
        int posUser = searchUserByNickname(nickname);
        if(posUser != -1){
            if(posPlaylist != -1){
                if(users.get(posUser) instanceof Consumer){
                    msj = ((Consumer)(users.get(posUser))).getPlaylists().get(posPlaylist).getCode();
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
     * playPremiumAudio play unrestricted audio for premium users.
     * @return message simulating playback.
     */

    public String playPremiumAudio(){
        String msj = "";
        int count = 0;
        for(int i = 0; i < audios.size(); i++){
            msj = audios.get(i).getName() + " del autor " +  audios.get(i).getOwner() + "\n" +
            "Reproduciendo.... \n";

            count++;
            count = audios.get(i).setNumberOfPlays()+1;
        }
        return msj;
    }

    /**
     * playStandardAudio play a song with ads for standard users.
     * @return simulation of reproduction with ads.
     */

    public String playStandardAudio(){
        String msj = "";
        int count = 0;
        for(int i = 0; i < audios.size(); i++){
            msj = audios.get(i).getName() + " del autor " +  audios.get(i).getOwner() + "\n" +
            "\nReproduciendo.... \n";
            count++;

            count = audios.get(i).setNumberOfPlays()+1;

            if(count%2 == 0){
                msj = "\nNike - Just Do It.\n" + "\nCoca-Cola - Open Happiness.\n" + "\nM&Ms - Melts in Your Mouth, Not in Your Hands\n" +
                "\n" + audios.get(i).getName() + " del autor " +  audios.get(i).getOwner() + "\n" +
                "\nReproduciendo.... \n";
                count++;

                count = audios.get(i).setNumberOfPlays();
            }
        }
        return msj;
    }

    /**
     * playSound play a song by instantiating the user to play.
     * @param nickname User who plays the song.
     * @param name song name.
     * @param owner song owner.
     * @return song playback.
     */

    public String playSound(String nickname, String name, String owner){
        String msj = ".";
        int posUser = searchUserByNickname(nickname);
        int posAudio = searchAudioByProducer(name, owner);
        if(posUser != -1){
            if(posAudio != -1){
                if(users.get(posUser) instanceof Premium){
                    msj = playPremiumAudio();
                }else if(users.get(posUser) instanceof Standard){
                    msj = playStandardAudio();
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
     * printGendersEnum prints the numbering of genre types in order.
     * @return listed song genres.
     */

    public String printGendersEnum(){
        String msj = "";
        Genres[] genres = Genres.values();
        for(int i = 0; i < genres.length; i++){
            msj += ((i+1) + ". " + genres[i] + "\n");
        }
        return msj;
    }

    /**
     * printAudios prints the audios from the audios arraylist.
     * @return audios.
     */

    public String printAudios(){
        String msj = "";
        for(int i = 0; i < audios.size(); i++){
            if(!audios.isEmpty()){
                msj += (audios.get(i)).toString() + "\n";
            }
        }
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
        Playlist newplaylist = new Playlist(playlistname, optionCode);
        int posUser = searchUserByNickname(nickname);
        if(posUser != -1){
            if(users.get(posUser) instanceof Premium){
                ((Consumer)(users.get(posUser))).getPlaylists().add(newplaylist);
                msj = "Playlist agregada.";
            }else{
                if(users.get(posUser) instanceof Standard){
                    ((Consumer)(users.get(posUser))).getPlaylists().add(newplaylist);
                    if(((Consumer)(users.get(posUser))).getPlaylists().add(newplaylist) == true){
                        msj = "Playlist agregada.";
                    }else if (((Consumer)(users.get(posUser))).getPlaylists().add(newplaylist) == false){
                        msj = "No se agrego la playlist.";
                    }
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