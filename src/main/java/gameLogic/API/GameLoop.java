import java.time.Clock;

public class GameLoop implements Runnable{

    Clock clock;
    double previousTime = clock.millis();
    
    @Override
    public void run() {
        while (true /*!GameLogic.isGameEnd()*/) {
            double currentTime = clock.millis();
            double timeDifference = currentTime - previousTime;
            //inputs
            update(timeDifference);
            //output
            previousTime = currentTime;
        }
    }

    private void update(double timeDifference) {
        
    }



}