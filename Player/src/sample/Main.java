package sample;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

import java.awt.*;
import java.beans.EventHandler;
import java.io.File;
import java.net.MalformedURLException;

import static javafx.scene.paint.Color.BLACK;


public class Main extends Application{

    Player player;
    FileChooser fileChooser;
    public void start(final Stage primaryStage)
    {
        MenuItem open = new MenuItem("Open");
        Menu file = new Menu("File");
        MenuBar menu = new MenuBar();

        file.getItems().add(open);
        menu.getMenus().add(file);
        fileChooser new FileChooser();

        open.setOnAction(new EventHandler<ActiveEvent>()
        {
            public void handle(ActionEvent event)
            {
                player.player.pause();
                File file = fileChooser.showOpenDialog(primaryStage);
                if(file != null)
                {
                    try
                    {
                        player = new Player(file.toURI().toURL().toExternalForm());
                        Scene scene = new Scene(player,720,535, BLACK);
                        primaryStage.setScene(scene);
                    }
                    catch (MalformedURLException e)
                    {
                        e.printStackTrace();
                    }
                }

            }
        })

      player = new Player("file///H:/Player/videoplayback_2.mp4");
      player.setTop(menu);
      Scene scene = new Scene(player,720,510, BLACK);
      primaryStage.setScene(scene);
      primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
