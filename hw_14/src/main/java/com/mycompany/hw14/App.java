/// @author Darby Vranek
/// I pledge my word of honor that I have abided
/// by the CSN Academic Integrity Policy while completing
/// this assignment.
/// @file darbyVranekcit130_Pa12.java
/// @version The date as 2022-05-03
/// @brief This program explores the use of the JavaFX UI tool

package com.mycompany.hw14;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Polygon;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
      FlowPane pane = new FlowPane(); // container to hold nodes
      // define difference between items in flow pane
      pane.setHgap(5);
      pane.setVgap(5);
      
      // define label and buttons
      Label firstLabel = new Label("first label");
      Label secondLabel = new Label("second label");
      Label thirdLabel = new Label("third label");
      Button firstButton = new Button("first button");
      Button secondButton = new Button("second button");
      Button thirdButton = new Button("third button");
      
      // define 2 red circles, 3 yellow ovals, 4 blue rectangles
      Circle red1 = new Circle();
      red1.setRadius(25);
      red1.setFill(Color.RED);
      Circle red2 = new Circle();
      red2.setRadius(10);
      red2.setFill(Color.RED);
      
      Ellipse yellowOval1 = new Ellipse(75, 25);
      yellowOval1.setFill(Color.YELLOW);
      Ellipse yellowOval2 = new Ellipse(50, 25);
      yellowOval2.setFill(Color.YELLOW);
      Ellipse yellowOval3 = new Ellipse(20, 25);
      yellowOval3.setFill(Color.YELLOW);
      
      Rectangle blueRect1 = new Rectangle(75, 25);
      blueRect1.setFill(Color.BLUE);
      Rectangle blueRect2 = new Rectangle(50, 25);
      blueRect2.setFill(Color.BLUE);
      Rectangle blueRect3 = new Rectangle(25, 25);
      blueRect3.setFill(Color.BLUE);
      Rectangle blueRect4 = new Rectangle(10, 25);
      blueRect4.setFill(Color.BLUE);
      
      Polygon octagon = new Polygon();
      octagon.setFill(Color.PURPLE);
      ObservableList<Double> list = octagon.getPoints();
      double radius = 20;
      
      // add 8 total points to make an octagon
      for (int i = 0; i < 8; i++) {
        list.add(radius * Math.cos(2 * i * Math.PI / 8)); // calculate point position based on formula
        list.add(- radius * Math.sin(2 * i * Math.PI / 8));
      }
      
      // if my included images don't work, these will get the images online
//      Image img1 = new Image("https://styles.redditmedia.com/t5_2qku9/styles/communityIcon_z5gbxg4feoe31.jpg");
//      Image img2 = new Image("https://is5-ssl.mzstatic.com/image/thumb/Purple4/v4/de/d2/b2/ded2b204-1457-84af-1019-0a1fceb9be4e/source/256x256bb.jpg");
//      Image img3 = new Image("https://b.thumbs.redditmedia.com/SELs2QOsHmxDk0Ody4ifLdRMPl7Ox2Dgcj6YMsCvSKI.png");
      
      Image img1 = new Image("mars.jpeg");
      Image img2 = new Image("jupiter.jpeg");
      Image img3 = new Image("saturn.png");
      
      // create ImageView for each to include in pane
      ImageView imgView1 = new ImageView(img1);
      ImageView imgView2 = new ImageView(img2);
      ImageView imgView3 = new ImageView(img3);
      
      // add all items to the view
      pane.getChildren().addAll(imgView1, imgView2, imgView3, red1, red2, yellowOval1, yellowOval2, yellowOval3, blueRect1, blueRect2, blueRect3, blueRect4, octagon, firstLabel, secondLabel, thirdLabel, firstButton, secondButton, thirdButton);
      
      // create new scene sized to fit the 3 256x256x images in a row
      Scene scene = new Scene(pane, 778, 500);
      primaryStage.setTitle("Darby Vranek - JavaFX Demo");
      primaryStage.setScene(scene);
      primaryStage.show();
    }

    public static void main(String[] args) {
        launch(); 
    }

}