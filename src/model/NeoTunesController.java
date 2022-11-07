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

    public Audio searchAudio(String aname){
        Audio audio = null;
        boolean isFound = false;
         for(int i=0;i<audios.size() && !isFound ;i++){
            if( audios.get(i).getName().equalsIgnoreCase(aname)){
                audio = audios.get(i);
                isFound = true;
            }
         }
        return audio;
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


    public String addFinalAudio(String name, int optionCode, String aname){
        String msj = "";
        Audio audio = searchAudio(aname);
        boolean isEmpty = false;
        for(int i = 0; i < audios.size() && !isEmpty; i++){
            if(audios.get(i).getName().equalsIgnoreCase(name)){
                if(users.get(i) instanceof Premium){
                    Premium premium = (Premium) users.get(i);
                    msj = premium.addAudio(name, optionCode, audio);
                }else{
                    if(users.get(i) instanceof Standard){
                        Standard standard = (Standard) users.get(i);
                        msj = standard.addAudio(name, optionCode, audio);
                    }
                }
                isEmpty = true;
            }else{
                msj = "El audio no existe.";
            }
        }
        return msj;
    }

    /**
     * removeAudio remove songs and podcast from a playlist.
     * @param name name of the audio to remove.
     * @return method validation message.
     */

    public String removeAudio(String aname){
        String msj = "";
        boolean isEmpty = false;
        for(int i = 0; i < users.size() && !isEmpty; i++){
            if(users.get(i) instanceof Premium){
                Premium premium = (Premium) users.get(i);
                msj = premium.removeAudioToPlaylistP(aname);
            }else{
                if(users.get(i) instanceof Standard){
                    Standard standard = (Standard) users.get(i);
                    msj = standard.removeAudioToPlaylistS(aname);
                }
                isEmpty = true;
            }
        }
        return msj;
    }
}