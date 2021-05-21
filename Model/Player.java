package Model;


public class Player {
    private boolean isAlive = true;
    private boolean sword;
    private boolean shield;

    /*On instantiation, creates a player*/
    public Player(){
    }
    public boolean hasSword(){return sword;}
    public void giveSword(){sword = true;}
    public void takeSword(){sword = false;}
    public boolean hasShield(){return shield;}
    public void giveShield(){shield = true;}
    public void kill(){
        isAlive = false;
    }
}