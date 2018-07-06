
package techwriting.env;
import techwriting.core.GUI;
import techwriting.core.Tools;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;

/** @author MaxIII
 */
public class TechWriting extends Application {
    
    Scene Mainscene;
    
    /** Major version of the application. */
    public final static int MAJOR = 0;
    /** Minor version of the application. */
    public final static int MINOR = 1;
    /** Stable build version of the application. */
    public final static int BUILD = 14;
    /** Version as string. */
    public static final String version = MAJOR + "." + MINOR + "." + BUILD;
    
    private String CSSLink = "resources/css/OB" + version + ".css";
    
//    private static ConfigurationManager     config;
//    private static Database                 database;
    private static GUI                      gui;
    private static Tools                    tools;
    
    @Override
    public void start(Stage primaryStage) {
        
        Mainscene = new Scene(gui.getrootNode());
        primaryStage.setScene(Mainscene);
        Mainscene.getStylesheets().add(CSSLink);
        primaryStage.setMaximized(true);
        primaryStage.setTitle("ENGL 3342-Summer01");
        /* Set Windows properties */
        primaryStage.show();
        
//        Button btn = new Button();
//        btn.setText("Say 'Hello World'");
//        btn.setOnAction(new EventHandler<ActionEvent>() {
//            
//            @Override
//            public void handle(ActionEvent event) {
//                System.out.println("Hello World!");
//            }
//        });
//        
//        StackPane root = new StackPane();
//        root.getChildren().add(btn);
//        
//        Scene scene = new Scene(root, 300, 250);
//        
//        primaryStage.setTitle("Hello World!");
//        primaryStage.setScene(scene);
//        primaryStage.show();
    }

    public static void main(String[] args) {
        try
        {  
//            System.loadLibrary("opencv_java341");
//            config = new ConfigurationManager("config.ini");
//            database = new Database(getConfig());
            tools = new Tools();
            gui = new GUI();
            System.out.println("Main Application -> START");
            launch(args);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
            
//    public static ConfigurationManager getConfig()  { return config; }
//    public static Database getDatabase()            { return database; }
    public static void prepareShutdown()            { System.exit(0); }    
    public static Tools getTools()                  { return tools; }
    public static void setTools(Tools Tools)        { tools = Tools; }
    
}
