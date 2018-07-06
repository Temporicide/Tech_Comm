
package techwriting.views;

import java.awt.image.BufferedImage;
import java.io.File;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.layout.FlowPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;

/** @author MaxIII */
public class Instruct_View extends BorderPane {
 
    private VBox Center;
    
    
    private HBox finalBox = new HBox();
    /*all under finalBox*/
    private VBox leftBox = new VBox();
    private VBox buttonsBox = new VBox(); //under leftBox
    private VBox middleBox = new VBox();
    private HBox keySectionBox = new HBox(); //under middleBox
    private VBox myKeyBox = new VBox(); //under keySectionBox
    private VBox rightBox = new VBox();
    private VBox resultKeyBox = new VBox(); //under rightBox
    
    /*all under buttonsBox*/
    private Slider accuracySlider = new Slider(); 
    private Button negationButton = new Button("Invert Image");
    private Button toGreyButton = new Button("Convert to Gray");
    private Button thresholdButton = new Button("Threshold Image");
    //private Button edgeDetectButton = new Button("Edge Detection");
    private Button doContourButton = new Button("Get Contour");
    
    
    private String ImageLink = "resources/images/def/";//
    
    /*all under keySectionBox*/
    /*all under myKeyBox*/
    private Image myKey_Image  = new Image(this.ImageLink + "defaultImage.png");
    private ImageView myKey_ImageView;
    private byte[][] myKey_ImageBytes;
    private BufferedImage myKey_BImage;
    private int myKey_width;
    private int myKey_height;
    private Mat myKey_ImageMat;
    private Button loadmyKey = new Button("Load Key");
    
    /*under resultKeyBox*/
    private Image resultKey_Image  = new Image(this.ImageLink + "defaultImage.png");
    private ImageView resultKey_ImageView;
    private byte[][] resultKey_ImageBytes;
    private Mat resultKey_ImageMat;
    private Label resultText = new Label();
    
    
    private VBox heading = new VBox();
    private Label Title = new Label("");
    private Label Info = new Label("");
    private Label Subtitle = new Label("");//
    
    private HBox finalInstructBox = new HBox();//
    private int PageNumber = 0;//
    /*Instruction Box*/
    private VBox leftTexttBox = new VBox();//
    private Label StepTexts = new Label("");//
    private VBox bulletFormat = new VBox();//
    
    /*Image Box*/
    private VBox rightImgBox = new VBox();
    private Image accomadateImg = new Image(this.ImageLink + "fall.png");   
    
    /*Button Box*/
    private HBox Bottom;
    private HBox localSwitch = new HBox();
    private Button nextButton = new Button(">> next");
    private Button prevButton = new Button("<< prev");
    private Button firstButton = new Button("<<< first");
    
    public Instruct_View(){
        this.setId("instructView");//was effectsView
        Center = new VBox();
        this.Center.setId("Center");
    }
    
    public void updateView() 
    {
        this.getChildren().clear();
        this.leftTexttBox.getChildren().clear();
        this.rightImgBox.getChildren().clear();
        this.bulletFormat.getChildren().clear();
        
        Title.setText("Instruction Set");
        Title.setId("pageTitle");
        Info.setText("Instructions on how to properly deal with one who is serious need to be lifted");
        Info.setId("pageInfo");
        heading.getChildren().addAll(Title,Info);
        
        StepTexts.setId("stepTitle");
        /*LeftBox of Page*/
         switch(PageNumber){
            case 0: // First Things First
                StepTexts.setText("First Things First");
                FlowPane bulletUL1 = new FlowPane(); 
                Label bulletUL1_1 = new Label("Make sure person who has fallen is still breathing. ");
                Label bulletUL1_2 = new Label("If person is NOT breathing, call 911 immediately. ");
                bulletUL1_2.setId("redU");
                Label bulletUL1_3 = new Label("Check for bleeding, broken bones, and other injuries.");
                bulletUL1_3.setId("blackU");
                bulletUL1.getChildren().addAll(bulletUL1_1,bulletUL1_2);
                FlowPane bulletUL2 = new FlowPane(); 
                Label bulletUL2_1 = new Label("If the person has a broken bone ");
                Label bulletUL2_2 = new Label("DO NOT MOVE.");
                bulletUL2_2.setId("UL2_2black");
                bulletUL2.getChildren().addAll(bulletUL2_1,bulletUL2_2);
                FlowPane bulletUL3 = new FlowPane(); 
                Label bulletUL3_1 = new Label("After checking the person, remain calm, reassure "
                        + "person to remain calm as well, and ask to take deep breaths.");
                bulletUL3.getChildren().addAll(bulletUL3_1);
                FlowPane bulletUL4 = new FlowPane(); 
                Label bulletUL4_1 = new Label("Remove any objects around that can add injury "
                        + "like shoes, clothes, balls, rolling chairs, socks, bed sheets, Legos, etc.");
                bulletUL4.getChildren().addAll(bulletUL4_1);
                FlowPane bulletUL5 = new FlowPane(); 
                Label bulletUL5_1 = new Label("Bring two sturdy chairs capable of holding persons weight. ");
                Label bulletUL5_2 = new Label("Do not use flimsy, plastic, or damaged chairs.");
                bulletUL5_2.setId("UL5_2black");
                bulletUL5.getChildren().addAll(bulletUL5_1,bulletUL5_2);
                bulletFormat.getChildren().addAll(StepTexts,bulletUL1,bulletUL2,bulletUL3,bulletUL4,bulletUL5);
                break;
            case 1:
                StepTexts.setText("Case 1-3");
                FlowPane bulletPUL = new FlowPane();
                Label bulletPUL_1 = new Label("*Only follow these steps if person is not critically "
                        + "injured and is physically capable of following steps. ");
                Label bulletPUL_2 = new Label("If critically injured call 911.");
                bulletPUL_2.setId("bulletPUL_2U");
                bulletPUL.getChildren().addAll(bulletPUL_1, bulletPUL_2);
                FlowPane bullet1 = new FlowPane();
                Label bullet1_1 = new Label("1.) ");
                Label bullet1_2 = new Label("If critically injured call 911.");
                bullet1.getChildren().addAll(bullet1_1,bullet1_2);
                FlowPane bullet2 = new FlowPane();
                Label bullet2_1 = new Label("2.) ");
                Label bullet2_2 = new Label("After both knees are up, you will roll person to the "
                        + "right side. Place persons arm on chest before rolling.");
                bullet2.getChildren().addAll(bullet2_1,bullet2_2);
                FlowPane descript = new FlowPane();
                Label desc1 = new Label("Right side = Right arm");
                desc1.setId("desc1U");
                Label desc2 = new Label(" on chest (if rolled left, use left arm on chest).");
                descript.getChildren().addAll(desc1,desc2);
                FlowPane bullet3 = new FlowPane();
                Label bullet3_1 = new Label("3.) ");
                Label bullet3_2 = new Label("Place one hand on shoulder and one hand on hip. Begin "
                        + "to roll gently and slowly. Tell person to use left arm to hold still on side.");
                bullet3.getChildren().addAll(bullet3_1,bullet3_2);
                bulletFormat.getChildren().addAll(StepTexts, bulletPUL, bullet1, bullet2, descript, bullet3);
                break;
            case 2:
                StepTexts.setText("Case 4-6");
                FlowPane bullet4 = new FlowPane();
                Label bullet4_1 = new Label("4.) ");
                Label bullet4_2 = new Label("After person is on their side, squat on one knee and "
                        + "help bring the top leg out in front of lower leg.");
                bullet4.getChildren().addAll(bullet4_1,bullet4_2);
                FlowPane bullet5 = new FlowPane();
                Label bullet5_1 = new Label("5.) ");
                Label bullet5_2 = new Label("Come around to the back of the person and squat down "
                        + "on one knee. Place your hand under persons shoulder touching the floor "
                        + "and ask person to slowly use left arm to push on ground and release "
                        + "right arm in order to use both hands to hold still.");
                bullet5.getChildren().addAll(bullet5_1,bullet5_2);
                FlowPane bullet6 = new FlowPane();
                Label bullet6_1 = new Label("6.) ");
                Label bullet6_2 = new Label("Now place your hands on hip and help lift the person "
                        + "allowing them to be on their knees and eventually all fours. Perform "
                        + "this step squatting on one knee.");
                bullet6.getChildren().addAll(bullet6_1,bullet6_2);
                bulletFormat.getChildren().addAll(StepTexts,bullet4,bullet5,bullet6);
                break;
            case 3:
                StepTexts.setText("Case 7-9");
                FlowPane bullet7 = new FlowPane();
                Label bullet7_1 = new Label("7.) ");
                Label bullet7_2 = new Label("Once person is on all fours, help place one chair "
                        + "on each side of person. Allow person to place one arm or both arms "
                        + "on chair (if person is in a tight congested area, help patient crawl "
                        + "towards sturdy furniture and follow step 8).");
                bullet7.getChildren().addAll(bullet7_1,bullet7_2);
                FlowPane bullet8 = new FlowPane();
                Label bullet8_1 = new Label("8.) ");
                Label bullet8_2 = new Label("Once chairs are set bring forward the persons "
                        + "strongest foot by placing one hand on the ankle and the other "
                        + "on the knee. Squat down while doing this and gently bring "
                        + "forward knee in a 90 degree angle.");
                bullet8.getChildren().addAll(bullet8_1,bullet8_2);
                FlowPane bullet9 = new FlowPane();
                Label bullet9_1 = new Label("9.) ");
                Label bullet9_2 = new Label("After knee is in 90 degree angle, stand up and "
                        + "wrap the persons arm with yours (left or right arm) and begin to "
                        + "lift up on the count of 3. *Once person is standing, ");
                Label bullet9_3 = new Label("keep a hand on persons back in case of "
                        + "dizzyness andallow a couple minutes to pass.");
                bullet9_3.setId("bullet9U");
                bullet9.getChildren().addAll(bullet9_1,bullet9_2,bullet9_3);
                bulletFormat.getChildren().addAll(StepTexts,bullet7,bullet8,bullet9);
                break;
            case 4:
                StepTexts.setText("Sources");
                FlowPane bulletS1 = new FlowPane();
                Label bulletS1_1 = new Label("Falls Prevention Facts. (2018, June 04).\n" 
                        + "Retrieved from ");
                Label bulletS1_2 = new Label("https://www.ncoa.org/news/resources-for-"
                        + "reporters/get-the-facts/falls-prevention-facts/");
                bulletS1_2.setId("SRClink1");
                bulletS1.getChildren().addAll(bulletS1_1,bulletS1_2);
                FlowPane bulletS2 = new FlowPane();
                Label bulletS2_1 = new Label("A Grandma About To Fall Down The Ground "
                        + "Cartoon Clipart. (n.d.). Retrieved from");
                Label bulletS2_2 = new Label("https://vectortoons.com/product/a-grandma"
                        + "-about-to-fall-down-the-ground/");
                bulletS2_2.setId("SRClink2");
                bulletS2.getChildren().addAll(bulletS2_1,bulletS2_2);
                bulletFormat.getChildren().addAll(bulletS1,bulletS2);
                break;
            default:
                
        }
        /*RightBox of Page*/
        switch(PageNumber){
            case 0:
                
                break;
            case 1:
                
                break;
            case 2:
                
                break;
            case 3:
                
                break;
            case 4:                
                
                break;
            default:
        }
        
        
        
        
        
        /*LeftBox*/
////        Label actionsTitle = new Label("Actions");
////        actionsTitle.setId("actionsTittle");
////        buttonsBox.getChildren().add(getNegationButton());
////        buttonsBox.getChildren().add(getToGreyButton());
////        buttonsBox.getChildren().add(getThresholdButton());
//////        buttonsBox.getChildren().add(getEdgeDetectButton());
////        buttonsBox.getChildren().add(getDoContourButton());
////        getAccuracySlider().setShowTickLabels(true);
////        getAccuracySlider().setShowTickMarks(true);
////        getAccuracySlider().setMin(0);
////        getAccuracySlider().setMax(255);
////        getAccuracySlider().setValue(10);  
////        accuracySlider.setPrefWidth(300);
////        buttonsBox.getChildren().add(getAccuracySlider());
////        buttonsBox.setId("buttonsBox");
////        
////        leftBox.getChildren().add(buttonsBox);
////        leftBox.setId("leftBox");
////        
////        /*MiddleBox*/
////        Label myKeyTitle = new Label("Original Key");
////        myKeyTitle.setId("myKeyTitle");
////        myKeyBox.getChildren().add(myKeyTitle);
////        this.setMyKey_ImageView(new ImageView(this.getMyKey_Image()));
////        this.getMyKey_ImageView().setFitHeight(200);
////        this.getMyKey_ImageView().setFitWidth(200);
////        this.getMyKey_ImageView().setPreserveRatio(false);
////        myKeyBox.getChildren().add(this.getMyKey_ImageView());
////        myKeyBox.getChildren().add(loadmyKey);
////        loadmyKey.setOnAction(new Load_Image());
////        loadmyKey.setId("loadmyKey");
////        myKeyBox.setId("myKeyBox");
////        keySectionBox.getChildren().add(myKeyBox);
////        keySectionBox.setId("keySectionBox");
////        
////        middleBox.getChildren().add(keySectionBox);
////        middleBox.setId("middleBox");
////        
////        /*RightBox*/
////        Label resultKeyTitle = new Label("Modified Key");
////        resultKeyTitle.setId("resultKeyTitle");
////        resultKeyBox.getChildren().add(resultKeyTitle);
////        this.resultKey_ImageView = (new ImageView(this.resultKey_Image));
////        this.resultKey_ImageView.setFitHeight(200);
////        this.resultKey_ImageView.setFitWidth(200);
////        this.resultKey_ImageView.setPreserveRatio(false);
////        resultKeyBox.getChildren().add(this.resultKey_ImageView);
////        resultKeyBox.getChildren().add(this.resultText);
////        resultKeyBox.setId("resultKeyBox");
////        
////        rightBox.getChildren().add(resultKeyBox);
////        rightBox.setId("rightBox");
////        
////        /*FinalBox*/
////        finalBox.getChildren().add(leftBox);
////        finalBox.getChildren().add(middleBox);
////        finalBox.getChildren().add(rightBox);
////        finalBox.setId("finalBox");
////        
////        
////        this.Center.getChildren().add(Title);       
////        this.Center.getChildren().add(Info);
////        this.Center.getChildren().add(finalBox);
////        this.setCenter(Center);
        
        localSwitch.getChildren().addAll(prevButton,nextButton);//
        this.Bottom.getChildren().addAll(firstButton,localSwitch);//
        this.setBottom(Bottom);//
    }
    
    
    
    public Button getnextButton()                               { return nextButton; }
    public Button getprevButton()                               { return prevButton; }
    public Button getfirstButton()                              { return firstButton; }
    public int getPageNumber()                                  { return PageNumber; }
    public void setPageNumber(int n)                             { this.PageNumber = n; }
    
    
    
    public byte[][] getMyKey_ImageBytes()                       { return myKey_ImageBytes; }
    public void setMyKey_ImageBytes(byte[][] myKey_ImageBytes)  { this.myKey_ImageBytes = myKey_ImageBytes; }
    public byte[][] getResultKey_ImageBytes()                   { return resultKey_ImageBytes; }
    public void setResultKey_ImageBytes(byte[][] resultKey_ImageBytes)  { this.resultKey_ImageBytes = resultKey_ImageBytes; }
    public Label getResultText()                                { return resultText; }
    public void setResultText(Label resultText)                 { this.resultText = resultText; }
    public Image getResultKey_Image()                           { return resultKey_Image; }
    public void setResultKey_Image(Image resultKey_Image)       { this.resultKey_Image = resultKey_Image; }
    public ImageView getResultKey_ImageView()                   { return resultKey_ImageView; }
    public void setResultKey_ImageView(ImageView resultKey_ImageView)   { this.resultKey_ImageView = resultKey_ImageView; }
    public Mat getResultKey_ImageMat()                          { return resultKey_ImageMat; }
    public void setResultKey_ImageMat(Mat resultKey_ImageMat)   { this.resultKey_ImageMat = resultKey_ImageMat; }
    public Image getMyKey_Image()                               { return myKey_Image; }
    public void setMyKey_Image(Image myKey_Image)               { this.myKey_Image = myKey_Image; }
    public ImageView getMyKey_ImageView()                       { return myKey_ImageView; }
    public void setMyKey_ImageView(ImageView myKey_ImageView)   { this.myKey_ImageView = myKey_ImageView; }
    public Mat getMyKey_ImageMat()                              { return myKey_ImageMat; }
    public void setMyKey_ImageMat(Mat myKey_ImageMat)           { this.myKey_ImageMat = myKey_ImageMat; }
    public BufferedImage getMyKey_BImage()                      { return myKey_BImage; }
    public void setMyKey_BImage(BufferedImage myKey_BImage)     { this.myKey_BImage = myKey_BImage; }
    public int getMyKey_width()                                 { return myKey_width; }
    public void setMyKey_width(int myKey_width)                 { this.myKey_width = myKey_width; }
    public int getMyKey_height()                                { return myKey_height; }
    public void setMyKey_height(int myKey_height)               { this.myKey_height = myKey_height; }
    public Button getNegationButton()                           { return negationButton; }
    public void setNegationButton(Button negationButton)        { this.negationButton = negationButton; }
    public Button getToGreyButton()                             { return toGreyButton; }
    public void setToGreyButton(Button toGreyButton)            { this.toGreyButton = toGreyButton; }
    public Button getThresholdButton()                          { return thresholdButton; }
    public void setThresholdButton(Button thresholdButton)      { this.thresholdButton = thresholdButton; }
    public Button getDoContourButton()                          { return doContourButton; }
    public void setDoContourButton(Button doContourButton)      { this.doContourButton = doContourButton; }
    public Slider getAccuracySlider()                           { return accuracySlider; }
    public void setAccuracySlider(Slider accuracySlider)        { this.accuracySlider = accuracySlider; }
    
    
    
    // ###########################
    // ########  ACTIONS  ########
    // ###########################
    class Load_Image implements EventHandler<ActionEvent> {
        final FileChooser fileChooser = new FileChooser();
        
        @Override
        public void handle(ActionEvent event) {
            // load an image....
            File file = fileChooser.showOpenDialog(null);
            FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("Image files", "*.JPG", "*.PNG");
            fileChooser.getExtensionFilters().addAll(extFilterJPG);
            
            try {
                setMyKey_BImage(ImageIO.read(file));
                BufferedImage bufferedImage2 = ImageIO_FX.toGray(getMyKey_BImage());
                
                setMyKey_width(myKey_BImage.getWidth());
                setMyKey_height(myKey_BImage.getHeight());
                        
                Image image = SwingFXUtils.toFXImage(myKey_BImage, null);
                myKey_Image = image;
                myKey_ImageView.setImage(image);
                        
                myKey_ImageBytes =(ImageIO_FX.getGrayByteImageArray2DFromBufferedImage(bufferedImage2));
                myKey_ImageMat = (FX_DIP.byteToGrayMat(myKey_ImageBytes, CV_8UC1)); 
            } catch (Exception e){ }             
        }
    }
    
    
    
}
