
package techwriting.controllers;
import techwriting.views.About_View;

/** @author MaxIII */
public class About_Controller {
    private About_View View = new About_View();
    public About_Controller()               { this.View = new About_View(); }
    
    /*Set & Get*/
    public About_View getView()             { return View; }
    public void setView(About_View View)    { this.View = View; }
}
