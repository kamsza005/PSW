
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class main extends Application {
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("interfejs.fxml"));
        primaryStage.setTitle("Panel administratora");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
       launch(args);

    }
}
