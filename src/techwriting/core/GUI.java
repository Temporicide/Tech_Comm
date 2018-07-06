
package techwriting.core;
import techwriting.tabs.TabManager;

import javafx.scene.layout.BorderPane;
import javafx.scene.Parent;

/** @author MaxIII */
public class GUI extends BorderPane {
    TabManager _tabs;
    
    public Parent getrootNode()             { return this; }
    public BorderPane getRoot()             { return this; }
    public TabManager getTabs()             { return _tabs; }
    public void setTabs(TabManager Tabs)    { this._tabs = Tabs; }
    
}
