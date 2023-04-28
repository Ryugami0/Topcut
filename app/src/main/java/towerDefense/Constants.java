package towerDefense;

import java.awt.Toolkit;

public interface Constants {
    
    //Grandezza schermo
    double width=Toolkit.getDefaultToolkit().getScreenSize().getWidth()/1.6;
    double height=Toolkit.getDefaultToolkit().getScreenSize().getHeight()/1.6;

    //Stringhe suoni
    String menuPanel="MenuPanel";
    String rulePanel="RulePanel";
    String gamePanel="GamePanel";
    String endPanel="EndPanel";
    String buttonSFX="ButtonSFX";
    String gameOverSFX="GameOverSFX";
}
