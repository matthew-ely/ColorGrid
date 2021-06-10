package application;
	
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage stage) {
		try {
			
			VBox grid = new Grid();
			
			Scene scene = new Scene(grid, 500, 550);
			
			stage.setScene(scene);
			stage.show();
			stage.setResizable(false);
			stage.setTitle("Color Grid!");
						
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
