package vue;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class ApprentiOrdonnateurApplication extends Application {
    public void start(Stage stage) {
        VBoxRoot root = new VBoxRoot();
        // VBox root = new VBoxRootOneMonth();
        Scene scene = new Scene(root, 1200, 680);
        stage.setScene(scene);
        // stage.setTitle("Calendrier du mois");
        stage.show();
    }
    public static void main (String[] args) {
        Application.launch(args);
    }
}