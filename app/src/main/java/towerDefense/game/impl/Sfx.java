package towerDefense.game.impl;

import javax.sound.sampled.*;

public class Sfx {

    private static AudioInputStream audioStream;
    private static Clip SFX=null;
    
    public void startSFX(String sfx){
        try {
            //Takes the input track
            audioStream = AudioSystem.getAudioInputStream(this.getClass().getResource("../../music/SFX/"+sfx+".wav"));
            SFX = AudioSystem.getClip();
            SFX.open(audioStream);
            SFX.setFramePosition(0);

            //Plays the sound once
            SFX.start();
        } catch (Exception e) { 
            System.out.println(e);    
        }
    }

}
