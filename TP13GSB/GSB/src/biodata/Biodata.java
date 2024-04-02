
package biodata;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Balbali
 * @version  1.5
 * @since 1.0
 */

//main class javafx
public class Biodata extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/biodata/view/Login.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Informations biographiques");
        stage.show();
    }

   
    public static void main(String[] args) {
        launch(args);
    }
    
}
