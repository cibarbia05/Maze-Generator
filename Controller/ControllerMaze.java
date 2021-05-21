package Controller;

import View.MazeView;
import View.StartView;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import Model.World;
import javafx.util.Duration;

public class ControllerMaze {
    private World w;
    private String eventCode;
    private static Timeline timeline;
    private static Timeline timeline2;
    private static Timeline timeline4;
    private static Timeline timeline6;
    private static Timeline timeline7;
    private static Timeline timeline8;
    private static Timeline timeline9;
    private static Timeline timeline10;
    private static KeyFrame kf3;
    private static int plays =0;

    private static Timeline timeline5;
    public static volatile boolean stop;
    private static Timeline timeline3;
    private static int timeSeconds;
    private static int timeSeconds2;
    private static int timeSeconds3;
    private static int timeSeconds4;
    private static int timeSeconds5;
    private static int timeSeconds6;
    private static int timeSeconds7;
    private static int timeSeconds8;
    private static int timeSeconds9;
    private static int timeSeconds10;
    public static double duration = 0.10;
    public static void setSlower(boolean slower) {
        ControllerMaze.slower = slower;
    }
    static boolean slower;
    public static boolean ready;

    /*Creates a Controller for the Player and Zombies in the Game*/
    public ControllerMaze() {
        w = new World();
        kf3 = new KeyFrame(Duration.seconds(duration));
        keyPressed();
        plays++;
        move();
        if(StartView.getInputZombies()>=2) {
            move2();
        }
        if(StartView.getInputZombies()>=3) {
            move3();
        }
        if(StartView.getInputZombies()>=4) {
            move4();
        }
        if(StartView.getInputZombies()>=5) {
            move5();
        }
        if(StartView.getInputZombies()>=6) {
            move6();
        }
        if(StartView.getInputZombies()>=7) {
            move7();
        }
        if(StartView.getInputZombies()>=8) {
            move8();
        }
        if(StartView.getInputZombies()>=9) {
            move9();
        }
        if(StartView.getInputZombies()>=10) {
            move10();
        }
    }
    /*Sets actions for when the user presses a key to move (arrow keys)*/
    public void keyPressed(){
            Scene scene = MazeView.getScene2();
            scene.setOnKeyPressed(event -> {
                if(ready) {
                    if (event.getCode() == KeyCode.RIGHT) {
                        eventCode = event.getCode().toString();
                        w.movePlayer(eventCode);
                    }
                    if (event.getCode() == KeyCode.LEFT) {
                        eventCode = event.getCode().toString();
                        w.movePlayer(eventCode);
                    }
                    if (event.getCode() == KeyCode.UP) {
                        eventCode = event.getCode().toString();
                        w.movePlayer(eventCode);
                    }
                    if (event.getCode() == KeyCode.DOWN) {
                        eventCode = event.getCode().toString();
                        w.movePlayer(eventCode);
                    }
                }
            });
    }
    /*Creates a separate timeline for the first Zombie in the game for it to move independently*/
        public void move() {
                timeline = new Timeline();
                timeline.setCycleCount(Timeline.INDEFINITE);
                timeline.getKeyFrames().add(
                        new KeyFrame(Duration.seconds(0.10),
                                (EventHandler) event -> {
                            if(ready) {
                                if (!MazeView.isPlayerDead() || MazeView.getZombie().isAlive()) {
                                    if (!slower) {
                                        if (timeSeconds % 2 != 1) {
                                            w.moveZombie();
                                            timeSeconds++;
                                        } else {

                                            timeSeconds++;
                                        }
                                    } else {
                                        if (timeSeconds % 10 == 0 && timeSeconds % 100 != 0) {
                                            w.moveZombie();
                                            timeSeconds++;
                                        }
                                        if (timeSeconds % 100 == 0) {
                                            slower = false;
                                        } else {

                                            timeSeconds++;
                                        }
                                    }
                                }
                            }

                                }));

                if ((!MazeView.isPlayerDead() || MazeView.getZombie().isAlive())&&!stop) {
                    timeline.playFromStart();
                }
                else{timeline.stop();}

        }
    /*Creates a separate timeline for the second Zombie in the game for it to move independently*/
        public void move2() {
         if (!MazeView.isPlayerDead()) {
                timeline2 = new Timeline();
                timeline2.setCycleCount(Timeline.INDEFINITE);
                timeline2.getKeyFrames().add(
                        new KeyFrame(Duration.seconds(duration),
                                (EventHandler) event -> {
                            if(ready) {
                                if (!MazeView.isPlayerDead() || MazeView.getZombie2().isAlive()) {
                                    if (!slower) {
                                        if (timeSeconds2 % 2 != 1) {
                                              w.moveZombie2();
                                            timeSeconds2++;
                                        } else {

                                            timeSeconds2++;
                                        }
                                    } else {
                                        if (timeSeconds2 % 10 == 0 && timeSeconds2 % 100 != 0) {
                                             w.moveZombie2();
                                            timeSeconds2++;
                                        }
                                        if (timeSeconds2 % 100 == 0) {
                                            slower = false;
                                        } else {

                                            timeSeconds2++;
                                        }
                                    }
                                }
                            }
                                }));
                if ((!MazeView.isPlayerDead() || MazeView.getZombie2().isAlive()) &&!stop) {
                    timeline2.playFromStart();
                }
                else{timeline2.stop();}
            }
        }
    /*Creates a separate timeline for the third Zombie in the game for it to move independently*/
        public void move3() {
            if (!MazeView.isPlayerDead()) {
                timeline3 = new Timeline();
                timeline3.setCycleCount(Timeline.INDEFINITE);
                timeline3.getKeyFrames().add(
                        new KeyFrame(Duration.seconds(duration),
                                (EventHandler) event -> {
                            if (ready) {
                                if (!MazeView.isPlayerDead() || MazeView.getZombie3().isAlive()) {
                                    if (!slower) {
                                        if (timeSeconds3 % 2 != 1) {
                                            w.moveZombie3();
                                            timeSeconds3++;
                                        } else {

                                            timeSeconds3++;
                                        }
                                    } else {
                                        if (timeSeconds3 % 10 == 0 && timeSeconds3 % 100 != 0) {
                                             w.moveZombie3();
                                            timeSeconds3++;
                                        }
                                        if (timeSeconds3 % 100== 0) {
                                            slower = false;
                                        } else {

                                            timeSeconds3++;
                                        }
                                    }
                                }
                            }
                                }));
                if ((!MazeView.isPlayerDead() || MazeView.getZombie3().isAlive())&&!stop) {
                  timeline3.playFromStart();
                }
                else{timeline3.stop();}

            }
        }
    /*Creates a separate timeline for the fourth Zombie in the game for it to move independently*/
    public void move4() {
        if (!MazeView.isPlayerDead()) {
            timeline4 = new Timeline();
            timeline4.setCycleCount(Timeline.INDEFINITE);
            timeline4.getKeyFrames().add(
                    new KeyFrame(Duration.seconds(duration),
                            (EventHandler) event -> {
                                if (ready) {
                                    if (!MazeView.isPlayerDead() || MazeView.getZombie4().isAlive()) {
                                        if (!slower) {
                                            if (timeSeconds4 % 2 != 1) {
                                               w.moveZombie4();
                                                timeSeconds4++;
                                            } else {

                                                timeSeconds4++;
                                            }
                                        } else {
                                            if (timeSeconds4 % 10 == 0 && timeSeconds4 % 100 != 0) {
                                                w.moveZombie4();
                                                timeSeconds4++;
                                            }
                                            if (timeSeconds4 % 100 == 0) {
                                                slower = false;
                                            } else {

                                                timeSeconds4++;
                                            }
                                        }
                                    }
                                }

                            }));
            if ((!MazeView.isPlayerDead() || MazeView.getZombie4().isAlive())&&!stop) {
                timeline4.playFromStart();
            }
            else{timeline4.stop();}

        }
    }
    /*Creates a separate timeline for the fifth Zombie in the game for it to move independently*/
    public void move5() {
        if (!MazeView.isPlayerDead()) {
            timeline5 = new Timeline();
            timeline5.setCycleCount(Timeline.INDEFINITE);
            timeline5.getKeyFrames().add(
                    new KeyFrame(Duration.seconds(duration),
                            (EventHandler) event -> {
                                if (ready) {
                                    if (!MazeView.isPlayerDead() || MazeView.getZombie5().isAlive()) {
                                        if (!slower) {
                                            if (timeSeconds5 % 2 != 1) {
                                               w.moveZombie5();
                                                timeSeconds5++;
                                            } else {

                                                timeSeconds5++;
                                            }
                                        } else {
                                            if (timeSeconds5 % 10 == 0 && timeSeconds5 % 100 != 0) {
                                                  w.moveZombie5();
                                                timeSeconds5++;
                                            }
                                            if (timeSeconds5 % 100 == 0) {
                                                slower = false;
                                            } else {

                                                timeSeconds5++;
                                            }
                                        }
                                    }
                                }

                            }));
            if ((!MazeView.isPlayerDead() || MazeView.getZombie5().isAlive())&&!stop) {
                timeline5.playFromStart();
            }
            else{timeline5.stop();}
        }
    }
    /*Creates a separate timeline for the sixth Zombie in the game for it to move independently*/
    public void move6() {
        if (!MazeView.isPlayerDead()) {
            timeline6 = new Timeline();
            timeline6.setCycleCount(Timeline.INDEFINITE);
            timeline6.getKeyFrames().add(
                    new KeyFrame(Duration.seconds(duration),
                            (EventHandler) event -> {
                                if (ready) {
                                    if (!MazeView.isPlayerDead() || MazeView.getZombie6().isAlive()) {
                                        if (!slower) {
                                            if (timeSeconds6 % 2 != 1) {
                                                w.moveZombie6();
                                                timeSeconds6++;
                                            } else {

                                                timeSeconds6++;
                                            }
                                        } else {
                                            if (timeSeconds6 % 10 == 0 && timeSeconds6 % 100 != 0) {
                                                w.moveZombie6();
                                                timeSeconds6++;
                                            }
                                            if (timeSeconds6 % 100 == 0) {
                                                slower = false;
                                            } else {

                                                timeSeconds6++;
                                            }
                                        }
                                    }
                                }

                            }));
            if ((!MazeView.isPlayerDead() || MazeView.getZombie6().isAlive())&&!stop) {
                timeline6.playFromStart();
            }
            else{timeline6.stop();}
        }
    }
    /*Creates a separate timeline for the seventh Zombie in the game for it to move independently*/
    public void move7() {
        if (!MazeView.isPlayerDead()) {
            timeline7 = new Timeline();
            timeline7.setCycleCount(Timeline.INDEFINITE);
            timeline7.getKeyFrames().add(
                    new KeyFrame(Duration.seconds(duration),
                            (EventHandler) event -> {
                                if (ready) {
                                    if (!MazeView.isPlayerDead() || MazeView.getZombie7().isAlive()) {
                                        if (!slower) {
                                            if (timeSeconds7 % 2 != 1) {
                                                w.moveZombie7();
                                                timeSeconds7++;
                                            } else {

                                                timeSeconds7++;
                                            }
                                        } else {
                                            if (timeSeconds7 % 10 == 0 && timeSeconds7 % 100 != 0) {
                                                w.moveZombie7();
                                                timeSeconds7++;
                                            }
                                            if (timeSeconds7 % 100 == 0) {
                                                slower = false;
                                            } else {

                                                timeSeconds7++;
                                            }
                                        }
                                    }
                                }

                            }));
            if ((!MazeView.isPlayerDead() || MazeView.getZombie7().isAlive())&&!stop) {
                timeline7.playFromStart();
            }
            else{timeline7.stop();}
        }
    }
    /*Creates a separate timeline for the eight Zombie in the game for it to move independently*/
    public void move8() {
        if (!MazeView.isPlayerDead()) {
            timeline8 = new Timeline();
            timeline8.setCycleCount(Timeline.INDEFINITE);
            timeline8.getKeyFrames().add(
                    new KeyFrame(Duration.seconds(duration),
                            (EventHandler) event -> {
                                if (ready) {
                                    if (!MazeView.isPlayerDead() || MazeView.getZombie8().isAlive()) {
                                        if (!slower) {
                                            if (timeSeconds8 % 2 != 1) {
                                                w.moveZombie8();
                                                timeSeconds8++;
                                            } else {

                                                timeSeconds8++;
                                            }
                                        } else {
                                            if (timeSeconds8 % 10 == 0 && timeSeconds8 % 100 != 0) {
                                                w.moveZombie8();
                                                timeSeconds8++;
                                            }
                                            if (timeSeconds8 % 100 == 0) {
                                                slower = false;
                                            } else {

                                                timeSeconds8++;
                                            }
                                        }
                                    }
                                }

                            }));
            if ((!MazeView.isPlayerDead() || MazeView.getZombie8().isAlive())&&!stop) {
                timeline8.playFromStart();
            }
            else{timeline8.stop();}
        }
    }
    /*Creates a separate timeline for the nine Zombie in the game for it to move independently*/
    public void move9() {
        if (!MazeView.isPlayerDead()) {
            timeline9 = new Timeline();
            timeline9.setCycleCount(Timeline.INDEFINITE);
            timeline9.getKeyFrames().add(
                    new KeyFrame(Duration.seconds(duration),
                            (EventHandler) event -> {
                                if (ready) {
                                    if (!MazeView.isPlayerDead() || MazeView.getZombie9().isAlive()) {
                                        if (!slower) {
                                            if (timeSeconds9 % 2 != 1) {
                                                w.moveZombie9();
                                                timeSeconds9++;
                                            } else {

                                                timeSeconds9++;
                                            }
                                        } else {
                                            if (timeSeconds9 % 10 == 0 && timeSeconds9 % 100 != 0) {
                                                w.moveZombie9();
                                                timeSeconds9++;
                                            }
                                            if (timeSeconds9 % 100 == 0) {
                                                slower = false;
                                            } else {

                                                timeSeconds9++;
                                            }
                                        }
                                    }
                                }

                            }));
            if ((!MazeView.isPlayerDead() || MazeView.getZombie9().isAlive())&&!stop) {
                timeline9.playFromStart();
            }
            else{timeline9.stop();}
        }
    }
    /*Creates a separate timeline for the tenth Zombie in the game for it to move independently*/
    public void move10() {
        if (!MazeView.isPlayerDead()) {
            timeline10 = new Timeline();
            timeline10.setCycleCount(Timeline.INDEFINITE);
            timeline10.getKeyFrames().add(
                    new KeyFrame(Duration.seconds(duration),
                            (EventHandler) event -> {
                                if (ready) {
                                    if (!MazeView.isPlayerDead() || MazeView.getZombie10().isAlive()) {
                                        if (!slower) {
                                            if (timeSeconds10 % 2 != 1) {
                                                w.moveZombie10();
                                                timeSeconds10++;
                                            } else {

                                                timeSeconds10++;
                                            }
                                        } else {
                                            if (timeSeconds10 % 10 == 0 && timeSeconds10 % 100 != 0) {
                                                w.moveZombie10();
                                                timeSeconds10++;
                                            }
                                            if (timeSeconds10 % 100 == 0) {
                                                slower = false;
                                            } else {

                                                timeSeconds10++;
                                            }
                                        }
                                    }
                                }

                            }));
            if ((!MazeView.isPlayerDead() || MazeView.getZombie10().isAlive())&&!stop) {
                timeline10.playFromStart();
            }
            else{timeline10.stop();}
        }
    }
}