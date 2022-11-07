package model;

import java.util.Random;
import java.util.ArrayList;

public class Playlist {

    public static final int ROWS = 5;
    public static final int COLUMS = 5;
    private int[][] codes; 
    private Random random;
    private ArrayList<Audio> audios; 

    private String name;
    private int optionCode;

    /**
     * Playlist playlist class constructor.
     * @param name playlist name.
     * @param codes playlist  matrix code.
     * @param optionCode playlist code type option.
     */

    public Playlist(String name, int optionCode){
        this.name = name;
        random =  new Random();
        codes = new int[ROWS][COLUMS];
        audios = new ArrayList<Audio>();

        String codesMsj = null;
        switch(optionCode){
            case 1:
                codesMsj = getSongCode();
                break;
            case 2:
                codesMsj = getPodcastCode();
            case 3:
                codesMsj = getPodcastAndSongsCode();
            default:
                System.out.println("Opcion invalida.");
        }
    }

    public String getName(){
        return name;
    }

    public ArrayList<Audio> getAudios() {
        return audios;
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

    /**
     * remove remove items from an audio array.
     * @param name audio name.
     * @return validation message when removing the item.
     */

    public String remove(String name){
        String msj = "";
        boolean exist = false;
        for(int i = 0; i < audios.size() && !exist; i++){
            if(audios.get(i).getName().equalsIgnoreCase(name)){
                audios.remove(i);
                exist = true;
                msj = "Item removido.";
            }
        }
        return msj;
    }

    /**
     * getPodcastAndSongsCode, the matrix is traversed from bottom to top and from right to left, when the sum of two values is an odd number greater than 1.
     * @return message with the resulting code.
     */

    public String getPodcastAndSongsCode(){
        String msj = "";
        for(int i = codes.length; i >= 0; i--){
            for(int j = codes.length; j >=0; j--){
                if(((i+j)/2) != 0){
                    if(((i+j)/2) != 1){
                        msj += codes[i][j];
                    }
                }
            }
        }
        return msj;
    }
}
