
package techwriting.tabs;

import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.scene.Parent;
import javafx.scene.control.ContentDisplay;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import techwriting.controllers.About_Controller;
import techwriting.controllers.Intro_Controller;
import techwriting.controllers.Instruct_Controller;
import techwriting.controllers.Home_Controller;
import techwriting.controllers.FAQ_Controller;

/** @author MaxIII */
public class TabManager extends HBox{
    
    public static BorderPane root;
    public static VBox mainMenuTemplate;
    public static Object[][] mainMenu;
    
    /*Controllers*/
    public static About_Controller aboutTab = new About_Controller();
    public static Intro_Controller introTab = new Intro_Controller();
    public static Instruct_Controller instructTab = new Instruct_Controller();
    public static Home_Controller homeTab = new Home_Controller();
    public static FAQ_Controller faqTab = new FAQ_Controller();
    
    public static List<MenuTab> TabsMap = new ArrayList<MenuTab>();
    public static MenuTab currentMenu;
    String CSSLink = "resources/css/OB043020171832.css";
    public TabManager(BorderPane root) {
        mainMenuTemplate = new VBox();
        drawMenu();
        this.getChildren().add(mainMenuTemplate);
        this.root = root;
        this.root.setLeft(this);
        this.root.setCenter(new VBox());
    }
    
    private static void drawMenu(){
        mainMenuTemplate.setId("mainMenu");
//        int i = 0;
        //All Tabs
        TabManager.mainMenu = new Object[][]{
            {"Home", homeTab.getView()},
            {"Introduction", introTab.getView()},
            {"Instructions", instructTab.getView()},
            {"FAQ", faqTab.getView()},
            {"About", aboutTab.getView()}
        };
            
//            //{"Home", aboutTab.getView()}, useless?
//            {"Camera", cameraTab.getView()}, //Dr Q's version.
//            //{"Camera", cameraXTab.getView()},
//            {"Effects", effectsTab.getView()},
//            {"Keys", keysTab.getView()},
//            {"Comparison", analysisTab.getView()},
//            {"About", aboutTab.getView()}
//        };
        mainMenuTemplate.getChildren().clear();
        for (Object[] s : mainMenu) {
            loadTabs loadTabs = new loadTabs();
            MenuTab mTab = new MenuTab(s[0].toString(), (Parent) s[1]);
            TabsMap.add(mTab);
            drawMainButton(mTab);
            mTab.getButton().setOnAction(loadTabs);
        }
    }
    
    public static void drawMainButton(MenuTab _menuItem){
        _menuItem.getButton().setText(_menuItem.getTitle());
        _menuItem.getButton().setId(_menuItem.getCSSId());
        _menuItem.getButton().setContentDisplay(ContentDisplay.TOP);
        mainMenuTemplate.getChildren().add(_menuItem.getButton());
    }
    
    public static class loadTabs implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            for(MenuTab m : TabsMap)
                if(event.getSource().equals(m.getButton())) {
                    loadMenu(m);
                    TabManager.currentMenu = m;
                }
        }
    }
    
    public static void loadMenu(MenuTab Menu)
        { TabManager.root.setCenter(Menu.getContent()); }
    
}
