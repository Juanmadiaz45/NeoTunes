package model;

import java.util.Random;
import java.util.ArrayList;

public class Playlist {

    public static final int ROWS = 5;
    public static final int COLUMS = 5;
    private int[][] codes; 
    private Random random;
    private ArrayList<Audio> audios;
    private String code;

    private String playlistname;
    private int optionCode;

    /**
     * Playlist playlist class constructor.
     * @param playlistname playlist name.
     * @param optionCode playlist code type option.
     */

    public Playlist(String playlistname, int optionCode){
        this.playlistname = playlistname;
        random =  new Random();
        codes = new int[ROWS][COLUMS];
        audios = new ArrayList<Audio>();
        this.optionCode = optionCode;
        this.code = code;

    
        switch(optionCode){
            case 1:
                this.code = getSongCode();
                break;
            case 2:
               this.code =  getPodcastCode();
                break;
            case 3:
                this.code = getPodcastAndSongsCode();
                break;
        }
    }

    public String getPlaylistname(){
        return playlistname;
    }

    public String getCode(){
        return code;
    }

    /**
     * fillMatrixNumber, the method fills the array with random values between 0 and 9.
     */

    public void fillMatrixNumbers(){
        for(int i = 0; i < codes.length; i++){
            for(int j =0; j< codes.length; j++){
                codes[i][j] = random.nextInt(9-0+1)+0;
            }
        }
    }

    /**
     * getSongCode, the method makes the pertinent traversals to return the values of the matrix in the form of the letter "N".
     * @return message with the resulting code.
     */

    public String getSongCode(){
        String msj = "";
        for(int i = codes.length -1; i >= 0; i--){
            msj += codes[i][0];

        }
        
        for(int j = 1; j < codes.length; j++){
            msj += codes[j][j];
        }
        for(int z = codes.length -2; z >=0; z--){
            msj += codes[z][codes.length-1];
        }
        return msj;
    }

    /**
     * getPodcastCode, the method makes the pertinent traversals to return the values of the matrix in the form of the letter "T".
     * @return message with the resulting code.
     */

    public String getPodcastCode(){
        String msj = "";
        for(int i = 0; i < 2; i++){
            msj += codes[0][i];
        }

        for(int j = 1; j < codes.length; j++){
            msj += codes[j][2];
        }

        for(int z = codes.length; z < 0; z--){
            msj += codes[z][3];
        }

        for(int x = 3; x > codes.length; x++){
            msj += codes[0][x];
        }
        return msj;
    }

    public void addPodcast(Audio podcast){
        audios.add(podcast);
    }

    public void removeAudio(int posAudio){
        audios.remove(posAudio);
    }

    /**
     * getPodcastAndSongsCode, the matrix is traversed from bottom to top and from right to left, when the sum of two values is an odd number greater than 1.
     * @return message with the resulting code.
     */

    public String getPodcastAndSongsCode(){
        String msj = "";
        for(int i = codes.length -1; i >= 0; i--){
            for(int j = codes.length -1; j >=0; j--){
                if(((i+j)/2) != 0){
                    if(((i+j)/2) != 1){
                        msj += codes[i][j];
                    }
                }
            }
        }
        return msj;
    }

    public void addSong(Audio song){
        audios.add(song);
    }
}
