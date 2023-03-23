package main.java.Entities.Impl;
import javafx.util.Pair;
import main.java.Entities.API.Entity;

public abstract class Ally implements Entity{

    private Pair<Integer, Integer> position;
    private int speed;
    private int hp;
    private int damage;
     
    @Override
    public Pair<Integer, Integer> getPosition() {
        return this.position;
    }
    
}
