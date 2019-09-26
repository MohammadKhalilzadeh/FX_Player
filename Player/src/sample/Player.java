package sample;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;


// BorderPane Has Regions
public class Player extends BorderPane
{
    Media media;
    MediaPlayer player;
    MediaView view;
    Pane mpane;
    MediaBar bar;

    public Player(String file)
    {
        media = new Media(file);
        player = new MediaPlayer(media);
        view = new MediaView(player);
        mpane = new Pane();

        // Adding The View To The Pane
        mpane.getChildren().add(view);
        // Adding MediaPane to BorderPane
        setCenter(mpane);

        bar = new MediaBar(player);
        setBottom(bar);
        setStyle("-fx-background-color: #bfc2c7");
        player.play();

    }
}
