package model;
import java.util.ArrayList;

public class NeoTunesController{

    private ArrayList<User> users;
    private ArrayList<Audio> audios;

    //arraylist initialization.

    public NeoTunesController(){
        users = new ArrayList<User>();
        audios = new ArrayList<Audio>();
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
        boolean isEmpty = false;
        for(int i = 0; i < audios.size() && !isEmpty; i++){
            msj += (audios.get(i));
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
     * addFinalPlaylist add a playlist for a specific user.
     * @param name playlist name.
     * @param nickname user nickname.
     * @param optionCode playlist type.
     * @return playlist creation validation message.
     */

    public String addFinalPlaylist(String name, String nickname, int optionCode){
        String msj = "";
        boolean isEmpty = false;
        for(int i = 0; i < users.size() && !isEmpty; i++){
            if(users.get(i).getNickname().equalsIgnoreCase(nickname)){
                if(users.get(i) instanceof Premium){
                    Premium premium = (Premium) users.get(i);
                    msj = premium.addPlaylistP(name, optionCode);
                }else{
                    if(users.get(i) instanceof Standard){
                        Standard standard = (Standard) users.get(i);
                        msj = standard.addPlaylistS(name, optionCode);
                    }
                }
                isEmpty = true;
            }else{
                msj = "El usuario no existe.";
            }
        }
        return msj;
    }

    /**
     * addOtherSong add other songs to the playlist.
     * @param name song name.
     * @param urlImage url of the identifying image of the song.
     * @param duration song duration.
     * @param album name of the album to which the song belongs.
     * @param value dollar value of the song.
     * @param genders song gender.
     * @return method validation message.
     */

    /**
     * removeAudio remove songs and podcast from a playlist.
     * @param name name of the audio to remove.
     * @return method validation message.
     */

    public String removeAudio(String name){
        String msj = "";
        boolean isEmpty = false;
        for(int i = 0; i < users.size() && !isEmpty; i++){
            if(users.get(i) instanceof Premium){
                Premium premium = (Premium) users.get(i);
                msj = premium.removeAudioToPlaylistP(name);
            }else{
                if(users.get(i) instanceof Standard){
                    Standard standard = (Standard) users.get(i);
                    msj = standard.removeAudioToPlaylistS(name);
                }
                isEmpty = true;
            }
        }
        return msj;
    }
}