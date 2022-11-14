package model;
import java.util.ArrayList;

public class Premium extends Consumer{

    private ArrayList<Song> songs;
    private ArrayList<Podcast> podcasts;

    /**
     * Premium premium consumer constructor.
     * @param nickname premium consumer nickname.
     * @param cc premium consumer identifier document.
     */

    public Premium(String cc, String nickname){
        super(nickname, cc);

        songs = new ArrayList<Song>();
        podcasts = new ArrayList<Podcast>();
    }

}