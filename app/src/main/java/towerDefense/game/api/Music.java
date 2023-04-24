package towerDefense.game.api;

import javax.sound.sampled.*;

public class Music {
    
    private static AudioInputStream audioStream;
    private static Clip music=null;

    public void startMusic(String song){
        try {
            audioStream = AudioSystem.getAudioInputStream(this.getClass().getResource("../../music/"+song+".wav"));
            music = AudioSystem.getClip();
            music.open(audioStream);
            music.setFramePosition(0);
            music.start();
            music.loop(100);
        } catch (Exception e) { 
            System.out.println(e);    
        }
    }

    public void stopMusic() {
        music.stop();
    }

}
