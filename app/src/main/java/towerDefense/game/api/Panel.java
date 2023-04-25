package towerDefense.game.api;

import javax.swing.JPanel;

import towerDefense.Constants;

public abstract class Panel extends JPanel {

    Music music =new Music();
    Sfx SFX=new Sfx();

    public void update() {
        
    }

    public void startSound(String typeOfSound){
        if(typeOfSound==Constants.menuPanel || typeOfSound==Constants.rulePanel){
            music.startMusic("alexander-nakarada-adventure");
        }else if(typeOfSound==Constants.gamePanel){
            music.startMusic("WereBackToFight");
        }else if(typeOfSound==Constants.endPanel){
            music.startMusic("Snowfall");
        }else if(typeOfSound==Constants.buttonSFX){
            SFX.startSFX("ButtonSound");
        }else if(typeOfSound==Constants.gameOverSFX){
            SFX.startSFX("mixkit-funny-fail-low-tone-2876");
        }
    }

    public void stopMusic(){
        music.stopMusic();
    }
    
}
