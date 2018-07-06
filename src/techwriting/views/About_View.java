
package techwriting.views;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/** @author MaxIII */
public class About_View extends BorderPane{
    private VBox Center;
    private Label Title = new Label("");
    private Label Info = new Label("");
    
    public About_View() {
        this.setId("aboutView");
        Center = new VBox();
        this.Center.setId("Center");
        updateView();        
    }
    public void updateView() {
        this.getChildren().clear();
        Title.setText("Our Team");
        Title.setId("pageTitle");
        Info.setText("Michael Hinojosa"
                + "\n"
                + "\nMaximino Reyna"
                + "\n"
                + "\nMyra Alvarado"
                );
        Info.setId("pageInfo");
        this.Center.getChildren().add(Title);       
        this.Center.getChildren().add(Info); 
        this.setCenter(Center);
    }
}
