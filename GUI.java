package application;
import java.awt.event.ActionListener;
import java.util.List;

import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Transform;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GUI extends Application implements ActionListener {

	public static void main(String[] args) {
		launch();
		

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Pane pane = new Pane();
		pane.setStyle("-fx-background-color: green");
		
		//button 1
		 Button b1 = new Button("Button 1");
		 add(b1);
		 b1.addActionListener(this);
		 //button 2
		 Button b2 = new Button("Button 2");
		 b2.setLayoutX(200);
		 add(b2);
		 b2.addActionListener(this);
		 //button 3
		 Button b3 = new Button("Button 3");
		 b3.setLayoutX(400);
		 add(b3);
		 b3.addActionListener(this);
		 //button 4
		 Button b4 = new Button("Button 4");
		 b4.setLayoutX(600);
		 add(b4);
		 b4.addActionListener(this);
		 //add to container
		 pane.getChildren().addAll(b1,b2,b3,b4);
		
		//create Scene
				Scene mainScene = new Scene(pane, 800, 800);
				
		//add to Stage
		primaryStage.setScene(mainScene);
				
		//Show Stage
		primaryStage.show();
		
		 public void actionPerformed(ActionEvent e) {
		        System.out.println("This button has been click");
		    }
	}
}

