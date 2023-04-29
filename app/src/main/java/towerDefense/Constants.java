package towerDefense;

public interface Constants {
    
    //Grandezza schermo
    double width=Calc.calcWidth();
    double height=Calc.calcHeight();

    //Stringhe suoni
    String menuPanel="MenuPanel";
    String rulePanel="RulePanel";
    String gamePanel="GamePanel";
    String endPanel="EndPanel";
    String buttonSFX="ButtonSFX";
    String gameOverSFX="GameOverSFX";

    //Stringhe nomi entità
    String barbarian="Barbarian";
    String knight="Knight";
    String goblin="Goblin";
    String archer="Archer";
    String turret="Turret";
    String arrow="Arrow";
    String boulder="Boulder";

    //Stringhe attività
    String walk= "Walk";
    String attack = "Attack";
}
