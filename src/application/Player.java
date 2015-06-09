package application;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;


public class Player extends BorderPane{
	
	Media media;
	MediaPlayer player;
	MediaView view;
	Pane pane;
	MediaBar bar;
	
	public Player(String file, Stage primaryStage) {
		media = new Media(file);
		player = new MediaPlayer(media);
		view = new MediaView(player);
		pane = new Pane();
		
		pane.getChildren().add(view);
		
		setCenter(pane);
		
		bar = new MediaBar(player);
		setBottom(bar);
		
		setStyle("-fx-background-color: #bfc2c7");
		
		player.play();
		player.setOnReady(new Runnable() {

			@Override
			public void run() {
				int w = player.getMedia().getWidth();
				int h = player.getMedia().getHeight();
				
				primaryStage.setMinWidth(w);
				primaryStage.setMinHeight(h);
	}
		});

}
}
