package application;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SliderDemo extends Application{
	@Override
	public void start(Stage stage) throws Exception {
		Text text = new Text(20, 20, "Programming is fun");
		
		//Slider horizontal
		Slider slH = new Slider();
		slH.setShowTickLabels(true);
		slH.setShowTickMarks(true);
		slH.setValue(100);
		
		//Slider vertical
		Slider slV = new Slider();
		slV.setShowTickLabels(true);
		slV.setShowTickMarks(true);
		slV.setOrientation(Orientation.VERTICAL);
		slV.setValue(100);
		
		//pane for text
		Pane paneText = new Pane();
		paneText.getChildren().add(text);
		
		//pane for sliders
		BorderPane pane = new BorderPane();
		pane.setCenter(paneText); //place pane for text in center
		pane.setBottom(slH); //horizontal slider
		pane.setRight(slV); //vertical slider
		
		//set up event handler
		slH.valueProperty().addListener(e -> {
			text.setX(slH.getValue() * paneText.getWidth() / slH.getMax());
		});
		
		slV.valueProperty().addListener(e -> {
			text.setY(slV.getHeight() - (slV.getValue() * paneText.getHeight() / slV.getMax()));
		});
		
		Scene scene = new Scene(pane, 450, 170);
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
