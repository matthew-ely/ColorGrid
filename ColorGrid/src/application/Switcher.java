package application;

import java.util.Scanner;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Switcher extends HBox {

	static TextField x = new TextField();
	static TextField y = new TextField();
	static Button yellow = new Button("", new Rectangle(20, 20, Color.YELLOW));
	static Button red = new Button("", new Rectangle(20, 20, Color.RED));
	static Button blue = new Button("", new Rectangle(20, 20, Color.BLUE));
	static Button random = new Button("random!");
	static Button reset = new Button("reset!");
	
	public Switcher() {
		x.setPrefWidth(50);
		y.setPrefWidth(50);
		x.textProperty().addListener(new ChangeListener<String>() {
		    @Override
		    public void changed(ObservableValue<? extends String> observable, String oldValue, 
		        String newValue) {
		        if (!newValue.matches("\\d*")) {
		            x.setText(newValue.replaceAll("[^\\d]", ""));
		        }
		    }
		});
		y.textProperty().addListener(new ChangeListener<String>() {
		    @Override
		    public void changed(ObservableValue<? extends String> observable, String oldValue, 
		        String newValue) {
		        if (!newValue.matches("\\d*")) {
		            y.setText(newValue.replaceAll("[^\\d]", ""));
		        }
		    }
		});
		this.setAlignment(Pos.CENTER);
		this.setPadding(new Insets(8));
		this.getChildren().addAll(x, y, yellow, red, blue, random, reset);
	}
	
	public static int getValue() {
		Scanner s = new Scanner(x.getText());
		Scanner t = new Scanner(y.getText());
		return s.nextInt() + ((t.nextInt() - 1) * 10) - 1;
	}
	
}
