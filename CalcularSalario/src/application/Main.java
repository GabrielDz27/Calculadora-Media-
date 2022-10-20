package application;
	
import com.ifsc.tds.controller.SalarioController;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;



public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			//loader fxml
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/ifsc/tds/view/ViewSalario.fxml"));
			Parent fxmlArchive = loader.load();
			
			//set css
			fxmlArchive.getStylesheets().add(getClass().getResource("/com/ifsc/tds/css/application.css").toExternalForm());
			
			//set fxml to scene
			Scene scene = new Scene(fxmlArchive);
			
			//stage configs
			primaryStage.setTitle("Calcular Salario");
			primaryStage.resizableProperty().setValue(Boolean.FALSE);
			primaryStage.setScene(scene);
			
			//controller
			SalarioController viewController = loader.getController();
			
			//set close request
			primaryStage.setOnCloseRequest(e->{
				if (viewController.onCloseQuery()) {
					System.exit(0);
				} else {
					e.consume();
				}
			});
			
			//show window
			primaryStage.show();
		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
