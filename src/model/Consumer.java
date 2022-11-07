package model;

public abstract class Consumer extends User{

    /**
     * Consumer consumer class constructor.
     * @param nickname consumer nickname.
     * @param cc consumer identifier document.
     */

    public Consumer(String nickname, String cc){
        super(nickname, cc);
    }
}