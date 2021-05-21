package Model;

import Controller.ControllerMaze;
import View.StartView;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;
import View.MazeView;

public class World {
    private static Player p;
    private Maze m;
    private int updatedRow;
    private int updatedCol;
    private Rectangle[][] rect;
    private int updatedRowM;
    private int updatedColM;
    private static int potionC;
    private int updatedRowM2=-1;
    private int updatedColM2=-1;
    private int updatedRowM3=-1;
    private int updatedColM3=-1;
    private int updatedRowM4=-1;
    private int updatedColM4=-1;
    private int updatedRowM5=-1;
    private int updatedColM5=-1;
    private int updatedRowM6=-1;
    private int updatedColM6=-1;
    private int updatedRowM7=-1;
    private int updatedColM7=-1;
    private int updatedRowM8=-1;
    private int updatedColM8=-1;
    private int updatedRowM9=-1;
    private int updatedColM9=-1;
    private int updatedRowM10=-1;
    private int updatedColM10=-1;
    private boolean allReady;
    private int shieldBarsCreated;

    public static Player getP() {
        return p;
    }

    /*Creates a World that will have the player and zombies*/
    public World(){
        m = new Maze();
        p = new Player();
        rect = MazeView.getRect();
    }
    public void movePlayer(String eventCode){
        updatedRow = MazeView.getCurRow();
        updatedCol = MazeView.getCurCol();

        if(eventCode.equals("RIGHT")){
            updatedCol++;
            if ((updatedCol< MazeView.getRect()[0].length)&&(((!StartView.isIsImagePath()
                    && MazeView.getRect()[updatedRow][updatedCol].getFill().equals(StartView.getColorPath()))||(StartView.isIsImagePath()
                    &&MazeView.getRect()[updatedRow][updatedCol].getFill().equals(MazeView.getPathPattern())))||(MazeView.getRSquareImage()!=null && MazeView.getRect()[updatedRow][updatedCol].getFill().equals(MazeView.getRSquareImage())))) {
                MazeView.setImageRight(MazeView.getPlayerNoSword(), 0, 1);
                MazeView.winMessage();

            }

            if(!allReady) {
                if (!p.hasSword()) {
                    shieldPlayerMatch();
                }
                if (p.hasSword() || p.hasShield()) {
                    shieldSwordPlayerMatch();
                } else if (!p.hasShield()) {
                    swordPlayerMatch();
                }
            }
            potionPlayerMatch();
        }
        else if(eventCode.equals("LEFT")) {
            if (updatedCol > 0) {
                updatedCol--;
                if (updatedCol>=0 &&(((!StartView.isIsImagePath()
                        && MazeView.getRect()[updatedRow][updatedCol].getFill().equals(StartView.getColorPath()))||( StartView.isIsImagePath()
                        &&MazeView.getRect()[updatedRow][updatedCol].getFill().equals(MazeView.getPathPattern())))||(MazeView.getRSquareImage()!=null && MazeView.getRect()[updatedRow][updatedCol].getFill().equals(MazeView.getRSquareImage())))){
                    MazeView.setImageLeft(MazeView.getPlayerNoSword(), 0, 1);
                    MazeView.winMessage();
                }
            }
            if(!allReady) {
                if (!p.hasSword()) {
                    shieldPlayerMatch();
                }
                if (p.hasSword() || p.hasShield()) {
                    shieldSwordPlayerMatch();
                } else if (!p.hasShield()) {
                    swordPlayerMatch();
                }
            }
            potionPlayerMatch();
        }
        else if(eventCode.equals("UP")){

            if(updatedRow>0) {
                updatedRow--;
            }
            if(updatedRow>=0 &&(((!StartView.isIsImagePath()
                    && MazeView.getRect()[updatedRow][updatedCol].getFill().equals(StartView.getColorPath()))||( StartView.isIsImagePath()
                    &&MazeView.getRect()[updatedRow][updatedCol].getFill().equals(MazeView.getPathPattern())))||(MazeView.getRSquareImage()!=null && MazeView.getRect()[updatedRow][updatedCol].getFill().equals(MazeView.getRSquareImage())))){

                MazeView.setImageUp(MazeView.getPlayerNoSword(), 1, 0);
                MazeView.winMessage();
            }
            if(!allReady) {
                if (!p.hasSword()) {
                    shieldPlayerMatch();
                }
                if (p.hasSword() || p.hasShield()) {
                    shieldSwordPlayerMatch();
                } else if (!p.hasShield()) {
                    swordPlayerMatch();
                }
            }
                potionPlayerMatch();


        }
        else if(eventCode.equals("DOWN")){

            updatedRow++;
            if((updatedRow< MazeView.getRect().length) &&(((!StartView.isIsImagePath()
                    && MazeView.getRect()[updatedRow][updatedCol].getFill().equals(StartView.getColorPath()))||(StartView.isIsImagePath()
                    &&MazeView.getRect()[updatedRow][updatedCol].getFill().equals(MazeView.getPathPattern())))
                    ||(MazeView.getRSquareImage()!=null && MazeView.getRect()[updatedRow][updatedCol].getFill().equals(MazeView.getRSquareImage())))) {

                MazeView.setImageDown(MazeView.getPlayerNoSword(), 1, 0);
                MazeView.winMessage();
            }
            if(!allReady) {
                if (!p.hasSword()) {
                    shieldPlayerMatch();
                }
                if (p.hasSword() || p.hasShield()) {
                    shieldSwordPlayerMatch();
                } else if (!p.hasShield()) {
                    swordPlayerMatch();
                }
            }
            potionPlayerMatch();
        }
    }

    /*Directions for the first zombie to move*/
    public void moveZombie() {
        if(MazeView.getZombie().isAlive()) {
            updatedRowM = MazeView.getCurRowM();
            updatedColM = MazeView.getCurColM();


            int rDist = MazeView.getCurRow() - MazeView.getCurRowM();
            int cDist = MazeView.getCurCol() - MazeView.getCurColM();
            if (rDist < 0 && updatedRowM-1>=0&& (MazeView.isPath(rect[updatedRowM - 1][updatedColM]) || MazeView.isPlayerKilled(rect[updatedRowM - 1][updatedColM],p,updatedRowM-1,updatedColM))) {
                updatedRowM--;
                MazeView.changeZombieImage(MazeView.getZombieImage(), updatedRowM, updatedColM, updatedRowM+1, updatedColM);
            }
            else if (rDist > 0 && updatedRowM+1<rect.length && (MazeView.isPath(rect[updatedRowM + 1][updatedColM]) || MazeView.isPlayerKilled(rect[updatedRowM + 1][updatedColM],p,updatedRowM+1,updatedColM))) {
                updatedRowM++;
                MazeView.changeZombieImage(MazeView.getZombieImage(), updatedRowM, updatedColM, updatedRowM-1, updatedColM);
            }
            else if (cDist > 0 && updatedColM+1<rect[0].length && (MazeView.isPath(rect[updatedRowM][updatedColM + 1]) || MazeView.isPlayerKilled(rect[updatedRowM][updatedColM + 1],p,updatedRowM,updatedColM+1))) {
                updatedColM++;
                MazeView.changeZombieImage(MazeView.getZombieImage(), updatedRowM, updatedColM, updatedRowM, updatedColM-1);
            }
            else if (cDist < 0&& updatedColM-1>=0&&(MazeView.isPath(rect[updatedRowM][updatedColM - 1]) || MazeView.isPlayerKilled(rect[updatedRowM][updatedColM - 1],p,updatedRowM,updatedColM-1))) {
                updatedColM--;
                MazeView.changeZombieImage(MazeView.getZombieImage(), updatedRowM, updatedColM, updatedRowM, updatedColM+1);
            }
        }
        deadOrAlive();
    }
    /*Directions for the second zombie to move*/
    public void moveZombie2() {
        if(MazeView.getZombie2().isAlive()) {
            updatedRowM2 = MazeView.getCurRowM2();
            updatedColM2 = MazeView.getCurColM2();

            int rDist = MazeView.getCurRow() - MazeView.getCurRowM2();
            int cDist = MazeView.getCurCol() - MazeView.getCurColM2();
            if (rDist < 0 && updatedRowM2-1>=0&&(MazeView.isPath(rect[updatedRowM2 - 1][updatedColM2]) || MazeView.isPlayerKilled(rect[updatedRowM2 - 1][updatedColM2],p,updatedRowM2-1,updatedColM2))) {
                updatedRowM2--;
                MazeView.changeZombieImage2(MazeView.getZombieImage(), updatedRowM2, updatedColM2, ++updatedRowM2, updatedColM2);
            }
            else if (rDist > 0 && updatedRowM2+1<rect.length && (MazeView.isPath(rect[updatedRowM2 + 1][updatedColM2]) || MazeView.isPlayerKilled(rect[updatedRowM2 + 1][updatedColM2],p,updatedRowM2+1,updatedColM2))) {
                updatedRowM2++;
                MazeView.changeZombieImage2(MazeView.getZombieImage(), updatedRowM2, updatedColM2, --updatedRowM2, updatedColM2);
            }
            else if (cDist > 0 && updatedColM2+1<rect[0].length && (MazeView.isPath(rect[updatedRowM2][updatedColM2 + 1]) || MazeView.isPlayerKilled(rect[updatedRowM2][updatedColM2 + 1],p,updatedRowM2,updatedColM2+1))) {
                updatedColM2++;
                MazeView.changeZombieImage2(MazeView.getZombieImage(), updatedRowM2, updatedColM2, updatedRowM2, --updatedColM2);
            }
            else if (cDist < 0&& updatedColM2-1>=0&&(MazeView.isPath(rect[updatedRowM2][updatedColM2 - 1]) || MazeView.isPlayerKilled(rect[updatedRowM2][updatedColM2 - 1],p,updatedRowM2,updatedColM2-1))) {

                updatedColM2--;
                MazeView.changeZombieImage2(MazeView.getZombieImage(), updatedRowM2, updatedColM2, updatedRowM2, ++updatedColM2);
            }
        }
        deadOrAlive();
    }
    /*Directions for the third zombie to move*/
    public void moveZombie3(){
        if(MazeView.getZombie3().isAlive()) {
            updatedRowM3 = MazeView.getCurRowM3();
            updatedColM3 = MazeView.getCurColM3();


            int rDist = MazeView.getCurRow() - MazeView.getCurRowM3();
            int cDist = MazeView.getCurCol() - MazeView.getCurColM3();
            if (rDist < 0 && updatedRowM3-1>=0&&(MazeView.isPath(rect[updatedRowM3 - 1][updatedColM3]) || MazeView.isPlayerKilled(rect[updatedRowM3 - 1][updatedColM3],p,updatedRowM-1,updatedColM3))) {
                updatedRowM3--;
                MazeView.changeZombieImage3(MazeView.getZombieImage(), updatedRowM3, updatedColM3, ++updatedRowM3, updatedColM3);
            }
            else if (rDist > 0 && updatedRowM3+1<rect.length && (MazeView.isPath(rect[updatedRowM3 + 1][updatedColM3]) || MazeView.isPlayerKilled(rect[updatedRowM3 + 1][updatedColM3],p,updatedRowM3+1,updatedColM3))) {
                updatedRowM3++;
                MazeView.changeZombieImage3(MazeView.getZombieImage(), updatedRowM3, updatedColM3, --updatedRowM3, updatedColM3);
            }
            else if (cDist > 0 && updatedColM3+1<rect[0].length && (MazeView.isPath(rect[updatedRowM3][updatedColM3 + 1]) || MazeView.isPlayerKilled(rect[updatedRowM3][updatedColM3 + 1],p,updatedRowM3,updatedColM3+1))) {
                updatedColM3++;
                MazeView.changeZombieImage3(MazeView.getZombieImage(), updatedRowM3, updatedColM3, updatedRowM3, --updatedColM3);
            }
            else if (cDist < 0&& updatedColM3-1>=0&&(MazeView.isPath(rect[updatedRowM3][updatedColM3 - 1]) || MazeView.isPlayerKilled(rect[updatedRowM3][updatedColM3 - 1],p,updatedRowM3,updatedColM3-1))) {
                updatedColM3--;
                MazeView.changeZombieImage3(MazeView.getZombieImage(), updatedRowM3, updatedColM3, updatedRowM3, ++updatedColM3);
            }
        }
        deadOrAlive();
    }
    /*Directions for the fourth zombie to move*/
    public void moveZombie4(){
        if(MazeView.getZombie4().isAlive()) {
            updatedRowM4 = MazeView.getCurRowM4();
            updatedColM4 = MazeView.getCurColM4();

            int rDist = MazeView.getCurRow() - MazeView.getCurRowM4();
            int cDist = MazeView.getCurCol() - MazeView.getCurColM4();
            if (rDist < 0 && updatedRowM4-1>=0&&(MazeView.isPath(rect[updatedRowM4 - 1][updatedColM4]) || MazeView.isPlayerKilled(rect[updatedRowM4 - 1][updatedColM4],p,updatedRowM-1,updatedColM4))) {
                updatedRowM4--;
                MazeView.changeZombieImage4(MazeView.getZombieImage(), updatedRowM4, updatedColM4, ++updatedRowM4, updatedColM4);
            }
            else if (rDist > 0 && updatedRowM4+1<rect.length && (MazeView.isPath(rect[updatedRowM4 + 1][updatedColM4]) || MazeView.isPlayerKilled(rect[updatedRowM4 + 1][updatedColM4],p,updatedRowM4+1,updatedColM4))) {
                updatedRowM4++;
                MazeView.changeZombieImage4(MazeView.getZombieImage(), updatedRowM4, updatedColM4, --updatedRowM4, updatedColM4);
            }
            else if (cDist > 0 && updatedColM4+1<rect[0].length && (MazeView.isPath(rect[updatedRowM4][updatedColM4 + 1]) || MazeView.isPlayerKilled(rect[updatedRowM4][updatedColM4 + 1],p,updatedRowM4,updatedColM4+1))) {
                updatedColM4++;
                MazeView.changeZombieImage4(MazeView.getZombieImage(), updatedRowM4, updatedColM4, updatedRowM4, --updatedColM4);
            }
            else if (cDist < 0&& updatedColM4-1>=0&&(MazeView.isPath(rect[updatedRowM4][updatedColM4 - 1]) || MazeView.isPlayerKilled(rect[updatedRowM4][updatedColM4 - 1],p,updatedRowM4,updatedColM4-1))) {
                updatedColM4--;
                MazeView.changeZombieImage4(MazeView.getZombieImage(), updatedRowM4, updatedColM4, updatedRowM4, ++updatedColM4);
            }
        }
        deadOrAlive();
    }
    /*Directions for the fifth zombie to move*/
    public void moveZombie5(){
        if(MazeView.getZombie5().isAlive()) {
            updatedRowM5 = MazeView.getCurRowM5();
            updatedColM5 = MazeView.getCurColM5();

            int rDist = MazeView.getCurRow() - MazeView.getCurRowM5();
            int cDist = MazeView.getCurCol() - MazeView.getCurColM5();
            if (rDist < 0 && updatedRowM5-1>=0&&(MazeView.isPath(rect[updatedRowM5 - 1][updatedColM5]) || MazeView.isPlayerKilled(rect[updatedRowM5 - 1][updatedColM5],p,updatedRowM-1,updatedColM5))) {
                updatedRowM5--;
                MazeView.changeZombieImage5(MazeView.getZombieImage(), updatedRowM5, updatedColM5, ++updatedRowM5, updatedColM5);
            }
            else if (rDist > 0 && updatedRowM5+1<rect.length && (MazeView.isPath(rect[updatedRowM5 + 1][updatedColM5]) || MazeView.isPlayerKilled(rect[updatedRowM5+ 1][updatedColM5],p,updatedRowM5+1,updatedColM5))) {
                updatedRowM5++;
                MazeView.changeZombieImage5(MazeView.getZombieImage(), updatedRowM5, updatedColM5, --updatedRowM5, updatedColM5);
            }
            else if (cDist > 0 && updatedColM5+1<rect[0].length && (MazeView.isPath(rect[updatedRowM5][updatedColM5 + 1]) || MazeView.isPlayerKilled(rect[updatedRowM5][updatedColM5 + 1],p,updatedRowM5,updatedColM5+1))) {
                updatedColM5++;
                MazeView.changeZombieImage5(MazeView.getZombieImage(), updatedRowM5, updatedColM5, updatedRowM5, --updatedColM5);
            }
            else if (cDist < 0&& updatedColM5-1>=0&&(MazeView.isPath(rect[updatedRowM5][updatedColM5 - 1]) || MazeView.isPlayerKilled(rect[updatedRowM5][updatedColM5 - 1],p,updatedRowM5,updatedColM5-1))) {
                updatedColM5--;
                MazeView.changeZombieImage5(MazeView.getZombieImage(), updatedRowM5, updatedColM5, updatedRowM5, ++updatedColM5);
            }
        }
        deadOrAlive();
    }
    /*Directions for the sixth zombie to move*/
    public void moveZombie6(){
        if(MazeView.getZombie6().isAlive()) {
            updatedRowM6 = MazeView.getCurRowM6();
            updatedColM6 = MazeView.getCurColM6();

            int rDist = MazeView.getCurRow() - MazeView.getCurRowM6();
            int cDist = MazeView.getCurCol() - MazeView.getCurColM6();
            if (rDist < 0 && updatedRowM6-1>=0&&(MazeView.isPath(rect[updatedRowM6- 1][updatedColM6]) || MazeView.isPlayerKilled(rect[updatedRowM6 - 1][updatedColM6],p,updatedRowM-1,updatedColM6))) {
                updatedRowM6--;
                MazeView.changeZombieImage6(MazeView.getZombieImage(), updatedRowM6, updatedColM6, ++updatedRowM6, updatedColM6);
            }
            else if (rDist > 0 && updatedRowM6+1<rect.length && (MazeView.isPath(rect[updatedRowM6 + 1][updatedColM6]) || MazeView.isPlayerKilled(rect[updatedRowM6+ 1][updatedColM6],p,updatedRowM6+1,updatedColM6))) {
                updatedRowM6++;
                MazeView.changeZombieImage6(MazeView.getZombieImage(), updatedRowM6, updatedColM6, --updatedRowM6, updatedColM6);
            }
            else if (cDist > 0 && updatedColM6+1<rect[0].length && (MazeView.isPath(rect[updatedRowM6][updatedColM6 + 1]) || MazeView.isPlayerKilled(rect[updatedRowM6][updatedColM6 + 1],p,updatedRowM6,updatedColM6+1))) {
                updatedColM6++;
                MazeView.changeZombieImage6(MazeView.getZombieImage(), updatedRowM6, updatedColM6, updatedRowM6, --updatedColM6);
            }
            else if (cDist < 0&& updatedColM6-1>=0&&(MazeView.isPath(rect[updatedRowM6][updatedColM6 - 1]) || MazeView.isPlayerKilled(rect[updatedRowM6][updatedColM6 - 1],p,updatedRowM6,updatedColM6-1))) {
                updatedColM6--;
                MazeView.changeZombieImage6(MazeView.getZombieImage(), updatedRowM6, updatedColM6, updatedRowM6, ++updatedColM6);
            }
        }
        deadOrAlive();
    }
    /*Directions for the seven zombie to move*/
    public void moveZombie7(){
        if(MazeView.getZombie7().isAlive()) {
            updatedRowM7 = MazeView.getCurRowM7();
            updatedColM7 = MazeView.getCurColM7();

            int rDist = MazeView.getCurRow() - MazeView.getCurRowM7();
            int cDist = MazeView.getCurCol() - MazeView.getCurColM7();
            if (rDist < 0 && updatedRowM7-1>=0&&(MazeView.isPath(rect[updatedRowM7 - 1][updatedColM7]) || MazeView.isPlayerKilled(rect[updatedRowM7 - 1][updatedColM7],p,updatedRowM-1,updatedColM7))) {
                updatedRowM7--;
                MazeView.changeZombieImage7(MazeView.getZombieImage(), updatedRowM7, updatedColM7, ++updatedRowM7, updatedColM7);
            }
            else if (rDist > 0 && updatedRowM7+1<rect.length && (MazeView.isPath(rect[updatedRowM7 + 1][updatedColM7]) || MazeView.isPlayerKilled(rect[updatedRowM7+ 1][updatedColM7],p,updatedRowM7+1,updatedColM7))) {
                updatedRowM7++;
                MazeView.changeZombieImage7(MazeView.getZombieImage(), updatedRowM7, updatedColM7, --updatedRowM7, updatedColM7);
            }
            else if (cDist > 0 && updatedColM7+1<rect[0].length && (MazeView.isPath(rect[updatedRowM7][updatedColM7 + 1]) || MazeView.isPlayerKilled(rect[updatedRowM7][updatedColM7 + 1],p,updatedRowM7,updatedColM7+1))) {
                updatedColM7++;
                MazeView.changeZombieImage7(MazeView.getZombieImage(), updatedRowM7, updatedColM7, updatedRowM7, --updatedColM7);
            }
            else if (cDist < 0&& updatedColM7-1>=0&&(MazeView.isPath(rect[updatedRowM7][updatedColM7 - 1]) || MazeView.isPlayerKilled(rect[updatedRowM7][updatedColM7 - 1],p,updatedRowM7,updatedColM7-1))) {
                updatedColM7--;
                MazeView.changeZombieImage7(MazeView.getZombieImage(), updatedRowM7, updatedColM7, updatedRowM7, ++updatedColM7);
            }
        }
        deadOrAlive();
    }
    /*Directions for the eight zombie to move*/
    public void moveZombie8(){
        if(MazeView.getZombie8().isAlive()) {
            updatedRowM8 = MazeView.getCurRowM8();
            updatedColM8 = MazeView.getCurColM8();

            int rDist = MazeView.getCurRow() - MazeView.getCurRowM8();
            int cDist = MazeView.getCurCol() - MazeView.getCurColM8();
            if (rDist < 0 && updatedRowM8-1>=0&&(MazeView.isPath(rect[updatedRowM8 - 1][updatedColM8]) || MazeView.isPlayerKilled(rect[updatedRowM8 - 1][updatedColM8],p,updatedRowM-1,updatedColM8))) {
                updatedRowM8--;
                MazeView.changeZombieImage8(MazeView.getZombieImage(), updatedRowM8, updatedColM8, ++updatedRowM8, updatedColM8);
            }
            else if (rDist > 0 && updatedRowM8+1<rect.length && (MazeView.isPath(rect[updatedRowM8 + 1][updatedColM8]) || MazeView.isPlayerKilled(rect[updatedRowM8+ 1][updatedColM8],p,updatedRowM8+1,updatedColM8))) {
                updatedRowM8++;
                MazeView.changeZombieImage8(MazeView.getZombieImage(), updatedRowM8, updatedColM8, --updatedRowM8, updatedColM8);
            }
            else if (cDist > 0 && updatedColM8+1<rect[0].length && (MazeView.isPath(rect[updatedRowM8][updatedColM8 + 1]) || MazeView.isPlayerKilled(rect[updatedRowM8][updatedColM8 + 1],p,updatedRowM8,updatedColM8+1))) {
                updatedColM8++;
                MazeView.changeZombieImage8(MazeView.getZombieImage(), updatedRowM8, updatedColM8, updatedRowM8, --updatedColM8);
            }
            else if (cDist < 0&& updatedColM8-1>=0&&(MazeView.isPath(rect[updatedRowM8][updatedColM8 - 1]) || MazeView.isPlayerKilled(rect[updatedRowM8][updatedColM8 - 1],p,updatedRowM8,updatedColM8-1))) {
                updatedColM8--;
                MazeView.changeZombieImage8(MazeView.getZombieImage(), updatedRowM8, updatedColM8, updatedRowM8, ++updatedColM8);
            }
        }
        deadOrAlive();
    }
    /*Directions for the ninth zombie to move*/
    public void moveZombie9(){
        if(MazeView.getZombie9().isAlive()) {
            updatedRowM9 = MazeView.getCurRowM9();
            updatedColM9 = MazeView.getCurColM9();

            int rDist = MazeView.getCurRow() - MazeView.getCurRowM9();
            int cDist = MazeView.getCurCol() - MazeView.getCurColM9();
            if (rDist < 0 && updatedRowM9-1>=0&&(MazeView.isPath(rect[updatedRowM9 - 1][updatedColM9]) || MazeView.isPlayerKilled(rect[updatedRowM9 - 1][updatedColM9],p,updatedRowM-1,updatedColM9))) {
                updatedRowM9--;
                MazeView.changeZombieImage9(MazeView.getZombieImage(), updatedRowM9, updatedColM9, ++updatedRowM9, updatedColM9);
            }
            else if (rDist > 0 && updatedRowM9+1<rect.length && (MazeView.isPath(rect[updatedRowM9 + 1][updatedColM9]) || MazeView.isPlayerKilled(rect[updatedRowM9+ 1][updatedColM9],p,updatedRowM9+1,updatedColM9))) {
                updatedRowM9++;
                MazeView.changeZombieImage9(MazeView.getZombieImage(), updatedRowM9, updatedColM9, --updatedRowM9, updatedColM9);
            }
            else if (cDist > 0 && updatedColM9+1<rect[0].length && (MazeView.isPath(rect[updatedRowM9][updatedColM9 + 1]) || MazeView.isPlayerKilled(rect[updatedRowM9][updatedColM9 + 1],p,updatedRowM9,updatedColM9+1))) {
                updatedColM9++;
                MazeView.changeZombieImage9(MazeView.getZombieImage(), updatedRowM9, updatedColM9, updatedRowM9, --updatedColM9);
            }
            else if (cDist < 0&& updatedColM9-1>=0&&(MazeView.isPath(rect[updatedRowM9][updatedColM9- 1]) || MazeView.isPlayerKilled(rect[updatedRowM9][updatedColM9 - 1],p,updatedRowM9,updatedColM9-1))) {
                updatedColM9--;
                MazeView.changeZombieImage9(MazeView.getZombieImage(), updatedRowM9, updatedColM9, updatedRowM9, ++updatedColM9);
            }
        }
        deadOrAlive();
    }
    /*Directions for the tenth zombie to move*/
    public void moveZombie10(){
        if(MazeView.getZombie10().isAlive()) {
            updatedRowM10 = MazeView.getCurRowM10();
            updatedColM10 = MazeView.getCurColM10();

            int rDist = MazeView.getCurRow() - MazeView.getCurRowM10();
            int cDist = MazeView.getCurCol() - MazeView.getCurColM10();
            if (rDist < 0 && updatedRowM10-1>=0&&(MazeView.isPath(rect[updatedRowM10 - 1][updatedColM10]) || MazeView.isPlayerKilled(rect[updatedRowM10 - 1][updatedColM10],p,updatedRowM-1,updatedColM10))) {
                updatedRowM10--;
                MazeView.changeZombieImage10(MazeView.getZombieImage(), updatedRowM10, updatedColM10, ++updatedRowM10, updatedColM10);
            }
            else if (rDist > 0 && updatedRowM10+1<rect.length && (MazeView.isPath(rect[updatedRowM10 + 1][updatedColM10]) || MazeView.isPlayerKilled(rect[updatedRowM10+ 1][updatedColM10],p,updatedRowM10+1,updatedColM10))) {
                updatedRowM10++;
                MazeView.changeZombieImage10(MazeView.getZombieImage(), updatedRowM10, updatedColM10, --updatedRowM10, updatedColM10);
            }
            else if (cDist > 0 && updatedColM10+1<rect[0].length && (MazeView.isPath(rect[updatedRowM10][updatedColM10 + 1]) || MazeView.isPlayerKilled(rect[updatedRowM10][updatedColM10 + 1],p,updatedRowM10,updatedColM10+1))) {
                updatedColM10++;
                MazeView.changeZombieImage10(MazeView.getZombieImage(), updatedRowM10, updatedColM10, updatedRowM10, --updatedColM10);
            }
            else if (cDist < 0&& updatedColM10-1>=0&&(MazeView.isPath(rect[updatedRowM10][updatedColM10 - 1]) || MazeView.isPlayerKilled(rect[updatedRowM10][updatedColM10 - 1],p,updatedRowM10,updatedColM10-1))) {
                updatedColM10--;
                MazeView.changeZombieImage10(MazeView.getZombieImage(), updatedRowM10, updatedColM10, updatedRowM10, ++updatedColM10);
            }
        }
        deadOrAlive();
    }
    /*Gives the player the sword if his position matches that of the sword*/
    public void swordPlayerMatch(){
        if(updatedRow==MazeView.getFirstSwordLocation()[0] && updatedCol ==  MazeView.getFirstSwordLocation()[1]){
            MazeView.setPlayerWithSwordImage();
            p.giveSword();
        }

    }
    /*Gives the player the shield if his position matches that of the sword*/
    public void shieldPlayerMatch(){
        if(updatedRow==MazeView.getFirstShieldLocation()[0] && updatedCol ==  MazeView.getFirstShieldLocation()[1]){
            MazeView.setShieldImages();
            p.giveShield();
            if(shieldBarsCreated==0) {
                MazeView.createShieldBar();
                shieldBarsCreated++;
            }
        }

    }
    /*  /*Gives the player the sword or shield (depending on the players position and if he already has the shield or the sword)*/
    public void shieldSwordPlayerMatch(){
        if(updatedRow==MazeView.getFirstSwordLocation()[0] && updatedCol ==  MazeView.getFirstSwordLocation()[1] && p.hasShield()){
            MazeView.setSwordShieldImages();
            p.giveSword();
            allReady=true;
        }
        else if(updatedRow==MazeView.getFirstShieldLocation()[0] && updatedCol ==  MazeView.getFirstShieldLocation()[1] && p.hasSword()) {
            MazeView.setSwordShieldImages2();
            p.giveShield();
            allReady=true;
            if(shieldBarsCreated==0) {
                MazeView.createShieldBar();
                shieldBarsCreated++;
            }
        }
    }
    /*Gives the player the potion if his position matches that of the potion*/
    public void potionPlayerMatch(){
        if(updatedRow==MazeView.getFirstPotionLocation()[0]&& updatedCol == MazeView.getFirstPotionLocation()[1] && potionC==0){
            ControllerMaze.setSlower(true);
            MazeView.setPotionImages();
            potionC++;
        }
    }
    /*Checks if the position of any of the zombies matches that of the
     *player and if so the player is dead, else he is alive
     */
    public void deadOrAlive() {
        if(decreaseHealth()){
            MazeView.changeHealth();
        }
        if(killZombie()){
            MazeView.alive();
        }
        if(killZombie2()){
            MazeView.alive2();
        }
        if(killZombie3()){
            MazeView.alive3();
        }
        if(killZombie4()){
            MazeView.alive4();
        }
        if(killZombie5()){
            MazeView.alive5();
        }
        if(killZombie6()){
            MazeView.alive6();
        }
        if(killZombie7()){
            MazeView.alive7();
        }
        if(killZombie8()){
            MazeView.alive8();
        }
        if(killZombie9()){
            MazeView.alive9();
        }
        if(killZombie10()){
            MazeView.alive10();
        }
        if (death()) {
            MazeView.dead(p);
        }

    }
    /*Kills the first zombie if the position of
     *the player matches the zombie's position
     */
    public boolean killZombie(){
        if(updatedRow == updatedRowM &&
                updatedCol== updatedColM&& p.hasSword()) {
            MazeView.getZombie().kill();
            return true;
        }
        return false;
    }
    /*Kills the second zombie if the position of
     *the player matches the zombie's position
     */
    public boolean killZombie2(){
        if(updatedRow == updatedRowM2 &&
                updatedCol== updatedColM2&& p.hasSword()) {
            MazeView.getZombie2().kill();
            return true;
        }
        return false;
    }
    /*Kills the third zombie if the position of
     *the player matches the zombie's position
     */
    public boolean killZombie3(){
        if(updatedRow == updatedRowM3 &&
                updatedCol== updatedColM3&& p.hasSword()) {
            MazeView.getZombie3().kill();
            return true;
        }
        return false;
    }
    /*Kills the fourth zombie if the position of
     *the player matches the zombie's position
     */
    public boolean killZombie4(){
        if(updatedRow == updatedRowM4 &&
                updatedCol== updatedColM4&& p.hasSword()) {
            MazeView.getZombie4().kill();
            return true;
        }
        return false;
    }
    /*Kills the fifth zombie if the position of
     *the player matches the zombie's position
     */
    public boolean killZombie5(){
        if(updatedRow == updatedRowM5 &&
                updatedCol== updatedColM5&& p.hasSword()) {
            MazeView.getZombie5().kill();
            return true;
        }
        return false;
    }
    /*Kills the sixth zombie if the position of
     *the player matches the zombie's position
     */
    public boolean killZombie6(){
        if(updatedRow == updatedRowM6 &&
                updatedCol== updatedColM6&& p.hasSword()) {
            MazeView.getZombie6().kill();
            return true;
        }
        return false;
    }
    /*Kills the seventh zombie if the position of
     *the player matches the zombie's position
     */
    public boolean killZombie7(){
        if(updatedRow == updatedRowM7 &&
                updatedCol== updatedColM7&& p.hasSword()) {
            MazeView.getZombie7().kill();
            return true;
        }
        return false;
    }
    /*Kills the eight zombie if the position of
     *the player matches the zombie's position
     */
    public boolean killZombie8(){
        if(updatedRow == updatedRowM8 &&
                updatedCol== updatedColM8&& p.hasSword()) {
            MazeView.getZombie8().kill();
            return true;
        }
        return false;
    }
    /*Kills the ninth zombie if the position of
     *the player matches the zombie's position
     */
    public boolean killZombie9(){
        if(updatedRow == updatedRowM9 &&
                updatedCol== updatedColM9&& p.hasSword()) {
            MazeView.getZombie9().kill();
            return true;
        }
        return false;
    }
    /*Kills the tenth zombie if the position of
     *the player matches the zombie's position
     */
    public boolean killZombie10(){
        if(updatedRow == updatedRowM10 &&
                updatedCol== updatedColM10&& p.hasSword()) {
            MazeView.getZombie10().kill();
            return true;
        }
        return false;
    }
    /*Decreases the health and shield of the player if there
     *is a zombie one position to the right, left, up or down
     */
    public boolean decreaseHealth(){
        if(MazeView.getZombie()!=null) {
            if ((p.hasShield() || p.hasSword()) && Math.abs(updatedRowM - updatedRow) == 1 && updatedColM == updatedCol) {
                if (MazeView.getZombie().isAlive()) {
                    return true;
                }
            } else if ((p.hasShield() || p.hasSword()) && Math.abs(updatedColM - updatedCol) == 1 && updatedRowM == updatedRow) {
                if (MazeView.getZombie().isAlive()) {
                    return true;
                }
            }
        }
        //----------------------------------------------------------------------------
        if(MazeView.getZombie2()!=null) {
            if ((p.hasShield() || p.hasSword()) && Math.abs(updatedRowM2 - updatedRow) == 1 && updatedColM2 == updatedCol) {
                if (MazeView.getZombie2().isAlive()) {
                    return true;
                }
            } else if ((p.hasShield() || p.hasSword()) && Math.abs(updatedColM2 - updatedCol) == 1 && updatedRowM2 == updatedRow) {
                if (MazeView.getZombie2().isAlive()) {
                    return true;
                }
            }
        }
        //---------------------------------------------------------------------------------
        if(MazeView.getZombie3()!=null) {
            if ((p.hasShield() || p.hasSword()) && Math.abs(updatedRowM3 - updatedRow) == 1 && updatedColM3 == updatedCol) {
                if (MazeView.getZombie3().isAlive()) {
                    return true;
                }
            }  else if ((p.hasShield() || p.hasSword()) && Math.abs(updatedColM3 - updatedCol) == 1 && updatedRowM3 == updatedRow) {
                if (MazeView.getZombie3().isAlive()) {
                    return true;
                }
            }
        }
        //-------------------------------------------------------------------------
        if(MazeView.getZombie4()!=null) {
            if ((p.hasShield() || p.hasSword()) && Math.abs(updatedRowM4 - updatedRow) == 1 && updatedColM4 == updatedCol) {
                if (MazeView.getZombie4().isAlive()) {
                    return true;
                }
            }  else if ((p.hasShield() || p.hasSword()) && Math.abs(updatedColM4 - updatedCol) == 1 && updatedRowM4 == updatedRow) {
                if (MazeView.getZombie4().isAlive()) {
                    return true;
                }
            }
        }
        //------------------------------------------------------------------------------
        if(MazeView.getZombie5()!=null) {
            if ((p.hasShield() || p.hasSword()) && Math.abs(updatedRowM5 - updatedRow) == 1 && updatedColM5 == updatedCol) {
                if (MazeView.getZombie5().isAlive()) {
                    return true;
                }
            } else if ((p.hasShield() || p.hasSword()) && Math.abs(updatedColM5 - updatedCol) == 1 && updatedRowM5 == updatedRow) {
                if (MazeView.getZombie5().isAlive()) {
                    return true;
                }
            }
        }
        //-----------------------------------------------------------------------
        if(MazeView.getZombie6()!=null) {
            if ((p.hasShield() || p.hasSword()) && Math.abs(updatedRowM6 - updatedRow) == 1 && updatedColM6 == updatedCol) {
                if (MazeView.getZombie6().isAlive()) {
                    return true;
                }
            }  else if ((p.hasShield() || p.hasSword()) && Math.abs(updatedColM6 - updatedCol) == 1 && updatedRowM6 == updatedRow) {
                if (MazeView.getZombie6().isAlive()) {
                    return true;
                }
            }
        }
        //----------------------------------------------------------------------------
        if(MazeView.getZombie7()!=null) {
            if ((p.hasShield() || p.hasSword()) && Math.abs(updatedRowM7 - updatedRow) == 1 && updatedColM7 == updatedCol) {
                if (MazeView.getZombie7().isAlive()) {
                    return true;
                }
            } else if ((p.hasShield() || p.hasSword()) && Math.abs(updatedColM7 - updatedCol) == 1 && updatedRowM7 == updatedRow) {
                if (MazeView.getZombie7().isAlive()) {
                    return true;
                }
            }
        }
        //----------------------------------------------------------------------------
        if(MazeView.getZombie8()!=null) {
            if ((p.hasShield() || p.hasSword()) && Math.abs(updatedRowM8 - updatedRow) == 1 && updatedColM8 == updatedCol) {
                if (MazeView.getZombie8().isAlive()) {
                    return true;
                }
            }  else if ((p.hasShield() || p.hasSword()) && Math.abs(updatedColM8 - updatedCol) == 1 && updatedRowM8 == updatedRow) {
                if (MazeView.getZombie8().isAlive()) {
                    return true;
                }
            }
        }
        //---------------------------------------------------------------
        if(MazeView.getZombie9()!=null) {
            if ((p.hasShield() || p.hasSword()) && Math.abs(updatedRowM9 - updatedRow) == 1 && updatedColM9 == updatedCol) {
                if (MazeView.getZombie9().isAlive()) {
                    return true;
                }
            } else if ((p.hasShield() || p.hasSword()) && Math.abs(updatedColM9 - updatedCol) == 1 && updatedRowM9 == updatedRow) {
                if (MazeView.getZombie9().isAlive()) {
                    return true;
                }
            }
        }
        //----------------------------------------------------------------------------
        if(MazeView.getZombie10()!=null) {
            if ((p.hasShield() || p.hasSword()) && Math.abs(updatedRowM10 - updatedRow) == 1 && updatedColM == updatedCol) {
                if (MazeView.getZombie10().isAlive()) {
                    return true;
                }
            }  else if ((p.hasShield() || p.hasSword()) && Math.abs(updatedColM - updatedCol) == 1 && updatedRowM10 == updatedRow) {
                if (MazeView.getZombie10().isAlive()) {
                    return true;
                }
            }
        }
        return false;
    }
    /* Checks for the death of the player if the position of a zombie
    matches the player's position*/
    public boolean death() {
        if(((updatedRow == updatedRowM && updatedCol== updatedColM)||
                (updatedRow == updatedRowM2 && updatedCol== updatedColM2)||
                (updatedRow == updatedRowM3 && updatedCol== updatedColM3)||
                (updatedRow == updatedRowM4 && updatedCol== updatedColM4)||
                (updatedRow == updatedRowM5 && updatedCol== updatedColM5) ||
                (updatedRow == updatedRowM6 && updatedCol== updatedColM6) ||
                (updatedRow == updatedRowM7 && updatedCol== updatedColM7) ||
                (updatedRow == updatedRowM8 && updatedCol== updatedColM8) ||
                (updatedRow == updatedRowM9 && updatedCol== updatedColM9) ||
                (updatedRow == updatedRowM10 && updatedCol== updatedColM10)) && !p.hasSword() && !p.hasShield()) {
            return true;
        }
        return false;
    }
}