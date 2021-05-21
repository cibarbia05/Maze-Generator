package Model;

public class Zombie {
    private boolean isAlive = true;

    /*On instantiation creates a Zombie*/
    public Zombie(){
    }
    public boolean isAlive(){
        return isAlive;
    }
    public void kill(){
        isAlive = false;
    }

}
