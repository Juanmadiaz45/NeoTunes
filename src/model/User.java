package model;
import java.util.Date;

public abstract class User{

    private String nickname;
    private String cc;
    private Date bondingDate;

    public User(String nickname, String cc){
        this.nickname = nickname;
        this.cc = cc;
        this.bondingDate = bondingDate;
    }

    public String getNickname(){
        return nickname;
    }

    public void setNickname(String nickname){
        this.nickname = nickname;
    }

    public String getCC(){
        return cc;
    }

    public void setCC(String cc){
        this.cc = cc;
    }
}