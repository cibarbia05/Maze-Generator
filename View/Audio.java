package View;

import javafx.scene.media.AudioClip;

public class Audio {
    private static AudioClip clip;
    static int plays;

    public static AudioClip getClip(){
        return clip;

    }
    /*Plays music when the user clicks the music button in the main menu*/
    public static void playMusic(String musicFile){
        clip = new AudioClip(Audio.class.getResource(musicFile).toString());
        clip.setCycleCount(AudioClip.INDEFINITE);
        clip.setVolume(0.7);
        clip.play();
    }
}
