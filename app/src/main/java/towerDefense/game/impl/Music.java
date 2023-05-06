package towerDefense.game.impl;

import javax.sound.sampled.*;

public class Music {
    
    private static AudioInputStream audioStream;
    private static Clip music=null;

    public void startMusic(String song){
        try {
            //Takes the input track
            audioStream = AudioSystem.getAudioInputStream(this.getClass().getResource("../../music/"+song+".wav"));
            music = AudioSystem.getClip();
            music.open(audioStream);
            music.setFramePosition(0);
            
            //Plays music 100 times in a row
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
