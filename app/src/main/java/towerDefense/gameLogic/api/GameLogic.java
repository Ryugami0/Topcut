package towerDefense.gameLogic.api;

import towerDefense.entities.api.Entity;
import towerDefense.entities.api.MovingEntity;

public interface GameLogic {

    /**
     * Checks if an entity is colliding with another
     * @param a
     *          the first entity to check
     * @param b
     *          the second entity to check
     */
    public <X extends MovingEntity> boolean checkCollision(X a, Entity b);

}
