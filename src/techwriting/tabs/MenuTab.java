
package techwriting.tabs;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

/** @author MaxIII */
public class MenuTab {
    private int Id;
    private String title;
    private String imageName;
    private Button button;
    private String cssId;
    private Node content;
    private boolean active = false;
    
    public MenuTab(int Id, String title, String imageName, Button button, String cssId, Node content){
        this.Id = Id;
        this.title = title;
        this.imageName = imageName;
        this.button = button;
        this.cssId = cssId;
        this.content = content;
        generateId();
    }
    public MenuTab(String title, Node content){
        this.title = title;
        this.cssId = generateId();
        this.button = new Button();
        this.button.setId(cssId);
        this.content = content;
    }
    public MenuTab(String title){
        this.title = title;
        this.cssId = generateId();
        this.button = new Button();
        this.button.setId(cssId);
        this.content = new VBox();
    }
    
    public int getId()                          { return Id; }
    public void setId(int Id)                   { this.Id = Id; }
    public String getTitle()                    { return title; }
    public void setTitle(String title)          { this.title = title; }
    public String getImageName()                { return imageName; }
    public void setImageName(String imageName)  { this.imageName = imageName; }
    public Button getButton()                   { return button; }
    public void setButton(Button button)        { this.button = button; }
    public String getCSSId()                    { return cssId; }
    public void setCSSId(String id)             { this.cssId = id; }
    public boolean isActive()                   { return active; }
    public void setActive(boolean active)       { this.active = active; }
    public Node getContent()                    { return content; }
    public void setContent(Node content)        { this.content = content; }

    public String generateId(){
        boolean titleWhitespace = this.title.matches("^\\s*$");
        if(this.cssId != null){
            boolean idWhiteSpace = this.cssId.matches("^\\s*$");
            if(!idWhiteSpace)
                return this.cssId;
        }
        else 
            this.cssId = (!titleWhitespace) ? this.title : this.cssId.replaceAll("\\s+","");
        return this.cssId;
    }
}
