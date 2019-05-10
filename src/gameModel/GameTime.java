package gameModel;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class GameTime {
    private int seconds;
    private Label timerLabel;

    public GameTime()
    {
        seconds=0;
    }

    Timeline gameTime = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {

        @Override
        public void handle(ActionEvent event) {
            seconds++;
            timerLabel.setText(String.format("%02d:%02d", seconds%3600/60, seconds%60));
        }
    }));

    public void startTime()
    {
        timerLabel.setText("00:00");
        seconds=0;
        gameTime.setCycleCount(Timeline.INDEFINITE);
        gameTime.play();
    }

    public void stopTime()
    {
        gameTime.stop();
    }

    public Label getTimerLabel() {
        return timerLabel;
    }

    public void setTimerLabel(Label timerLabel) {
        this.timerLabel = timerLabel;
    }
}
