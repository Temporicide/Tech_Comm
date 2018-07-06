
package techwriting.controllers;

import techwriting.views.Instruct_View;
import java.awt.image.BufferedImage;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/** @author MaxIII */
public class Instruct_Controller {
    private Instruct_View View = new Instruct_View();
//    private Effects_Model Model = new Effects_Model();
    private String ImageLink = "resources/images/def/";
    
    public Instruct_Controller() {
        this.View = new Instruct_View();
//        this.Model = new Effects_Model();
        attachEvents();
    }

    private void attachEvents() {
        handlerEffectsView();
    }
    
    void handlerEffectsView() {
//        Effect_Gray grayKey = new Effect_Gray();
//        this.View.getToGreyButton().setOnAction(grayKey);
//        Effect_Threshold thresholdKey = new Effect_Threshold();
//        this.View.getThresholdButton().setOnAction(thresholdKey);
//        Effect_Negate negateKey = new Effect_Negate();
//        this.View.getNegationButton().setOnAction(negateKey);
//        Effect_Contour contourKey = new Effect_Contour();
//        this.View.getDoContourButton().setOnAction(contourKey);
        
        Instruct_Next nextKey = new Instruct_Next();
        this.View.getnextButton().setOnAction(nextKey);
        Instruct_Prev prevKey = new Instruct_Prev();
        this.View.getprevButton().setOnAction(prevKey);
        Instruct_First firstKey = new Instruct_First();
        this.View.getfirstButton().setOnAction(firstKey);
        
        this.View.updateView();
    }
    
    /*********************
    *Setters and Getters
    **********************/
    public Instruct_View getView()                  { return View; }
    public void setView(Instruct_View View)         { this.View = View; }
        
    /*************
    * Actions
    **************/
//    class Effect_Threshold implements EventHandler<ActionEvent> {    
//        @Override
//        public void handle(ActionEvent event) {
//            BufferedImage thresholedBImage = Instruct_Model.doThreshold(View.getMyKey_BImage(), View.getAccuracySlider().getValue());
//            Image thresholdedImage = SwingFXUtils.toFXImage(thresholedBImage, null);
//            View.getResultKey_ImageView().setImage(thresholdedImage);         
//        } 
//    }
//    class Effect_Negate implements EventHandler<ActionEvent> {
//        @Override
//        public void handle(ActionEvent event) {
//            BufferedImage negatedBImage = Effects_Model.doNegative(View.getMyKey_BImage());
//            Image negatedImage = SwingFXUtils.toFXImage(negatedBImage, null);
//            View.getResultKey_ImageView().setImage(negatedImage);         
//        }
//    }
//    class Effect_Contour implements EventHandler<ActionEvent> {
//        @Override
//        public void handle(ActionEvent event) {
//            BufferedImage contourBImage = Effects_Model.doContour(View.getMyKey_BImage(), View.getAccuracySlider().getValue());
//            Image contourImage = SwingFXUtils.toFXImage(contourBImage, null);
//            View.getResultKey_ImageView().setImage(contourImage);         
//        }
//    }
//    class Effect_Gray implements EventHandler<ActionEvent> {
//        @Override
//        public void handle(ActionEvent event) {
//            BufferedImage grayBImage = Effects_Model.doGray(View.getMyKey_BImage());
//            Image grayImage = SwingFXUtils.toFXImage(grayBImage, null);
//            View.getResultKey_ImageView().setImage(grayImage);
//        }
//    }
    
    
    class Instruct_Next implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            if(View.getPageNumber() < 4)    View.setPageNumber(View.getPageNumber()+1);
            else                            View.setPageNumber(0);
        }
    }
    class Instruct_Prev implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            if(View.getPageNumber() > 0)    View.setPageNumber(View.getPageNumber()-1);
            else                            View.setPageNumber(4);
        }
    }
    class Instruct_First implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            View.setPageNumber(0);
        }
    }
    
    
     
}