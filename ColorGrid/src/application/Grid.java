package application;

import java.util.Random;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Grid extends VBox {

	public static Rectangle[] squares = new Rectangle[62500];
	TilePane tiles;
	HBox switcher;
	
	public Grid() {
		tiles = new TilePane();
		tiles.setPrefColumns(250);
		switcher = new Switcher();
		application.Switcher.yellow.setOnAction(this::changeYellow);
		application.Switcher.red.setOnAction(this::changeRed);
		application.Switcher.blue.setOnAction(this::changeBlue);
		application.Switcher.random.setOnAction(this::changeRandom);
		application.Switcher.reset.setOnAction(this::changeReset);
		for (int i = 0; i < squares.length; i++) {
			squares[i] = new Rectangle(2, 2, Color.WHITE);
		}
		for (Rectangle s : squares) {
			tiles.getChildren().add(s);
		}
		
		this.getChildren().addAll(tiles, switcher);
	}
	
	public void changeRed(ActionEvent e) {
		try {
			squares[application.Switcher.getValue()].setFill(Color.RED);
		} catch (ArrayIndexOutOfBoundsException oob) {
			application.Switcher.x.setText("");
			application.Switcher.y.setText("");
			Alert alert = new Alert(AlertType.WARNING, "Not a valid input");
			alert.show();
		}
	}
	
	public void changeYellow(ActionEvent e) {
		try {
			squares[application.Switcher.getValue()].setFill(Color.YELLOW);
		} catch (ArrayIndexOutOfBoundsException oob) {
			application.Switcher.x.setText("");
			application.Switcher.y.setText("");
			Alert alert = new Alert(AlertType.WARNING, "Not a valid input");
			alert.show();
		}
	}
	
	public void changeBlue(ActionEvent e) {
		try {
			squares[application.Switcher.getValue()].setFill(Color.BLUE);
		} catch (ArrayIndexOutOfBoundsException oob) {
			application.Switcher.x.setText("");
			application.Switcher.y.setText("");
			Alert alert = new Alert(AlertType.WARNING, "Not a valid input");
			alert.show();
		}
	}
	
	public void changeRandom(ActionEvent e) {
		Random r = new Random();
		for (int i = 0; i < 187500; i++) {
			squares[r.nextInt(62500)].setFill(Color.BLUE);
			squares[r.nextInt(62500)].setFill(Color.YELLOW);
			squares[r.nextInt(62500)].setFill(Color.RED);
		}
	}
	
	public void changeReset(ActionEvent e) {
		for (int i = 0; i < squares.length; i++) {
			squares[i].setFill(Color.WHITE);
		}
	}

}
