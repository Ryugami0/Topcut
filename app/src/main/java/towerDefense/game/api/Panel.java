package towerDefense.game.api;

import javax.swing.JPanel;

public abstract class Panel extends JPanel {

    Music music =new Music();
    Sfx SFX=new Sfx();

    public void update() {
        
    }

    public void startMusic(String typeOfSound){
        if(typeOfSound=="MenuPanel" || typeOfSound=="RulePanel"){
            music.startMusic("alexander-nakarada-adventure");
        }else if(typeOfSound=="GamePanel"){
            music.startMusic("WereBackToFight");
        }else if(typeOfSound=="EndPanel"){
            music.startMusic("Snowfall");
        }else if(typeOfSound=="Button"){
            SFX.startSFX("ButtonSound");
        }else if(typeOfSound=="GameOver"){
            SFX.startSFX("mixkit-funny-fail-low-tone-2876");
            //https://mixkit.co/free-sound-effects/game-over/
        }
    }

    public void stopMusic(){
        music.stopMusic();
    }
    
}
