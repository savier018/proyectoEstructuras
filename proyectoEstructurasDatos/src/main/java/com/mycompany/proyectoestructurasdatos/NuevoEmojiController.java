package com.mycompany.proyectoestructurasdatos;

import Modelo.Emoji;
import Modelo.EmojiImage;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.io.IOException;
import java.net.URL;
import TDA.ArrayList;
import TDA.LinkedList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import Modelo.Usuario;
import static com.mycompany.proyectoestructurasdatos.PantallaUsuario1Controller.nombreUsuario;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Stack;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;


/**
 * FXML Controller class
 *
 * @author fnand PROYECTO
 */
public class NuevoEmojiController implements Initializable {

   //FXML
       //FXML
    @FXML
    private AnchorPane ap;
    @FXML
    private VBox Container;
    @FXML
    private HBox ListFaces;
    @FXML
    private HBox ListEyes;
    @FXML
    private HBox ListMouth;
    @FXML
    private HBox ListEyebrows;
    @FXML
    private HBox ListAccessories;
    //Buttons
    @FXML
    private Button resetbtn;
    @FXML
    private Button acceptbtn;
    @FXML
    private Button volverbtn;
    @FXML
    private Button nextF;
    @FXML
    private Button prevF;
    @FXML
    private Button nextE;
    @FXML
    private Button prevE;
    @FXML
    private Button nextM;
    @FXML
    private Button prevM;
    @FXML
    private Button nextEb;
    @FXML
    private Button prevEb;
    @FXML
    private Button nextA;
    @FXML
    private Button prevA;
    @FXML
    private Button eliminarC;
    
    @FXML
    static ImageView FaceS;
    @FXML
     static ImageView EyesS;
    @FXML
     static ImageView MouthS;
    @FXML
     static ImageView EyebrowsS;
    @FXML
    static ImageView AccessoriesS;
    static boolean f=false;
    
    @FXML
    private Pane EmojiSet;
    @FXML
    private ImageView FaceM;
    @FXML
    private ImageView EyesM;
    @FXML
    private ImageView MouthM;
    @FXML
    private ImageView EyebrowsM;
    @FXML
    private ImageView AccessoriesM;
    @FXML
    private ImageView FaceP;
    @FXML
    private ImageView EyesP;
    @FXML
    private ImageView MouthP;
    @FXML
    private ImageView EyebrowsP;
    @FXML
    private ImageView AccessoriesP;
    @FXML
    private ImageView FaceN;
    @FXML
    private ImageView EyesN;
    @FXML
    private ImageView MouthN;
    @FXML
    private ImageView EyebrowsN;
    @FXML
    private ImageView AccessoriesN;
    //Variables and Lists

    static String nombreUsuario;
    private LinkedList<EmojiImage> lFaces;
    private LinkedList<EmojiImage> lEyes;
    private LinkedList<EmojiImage> lMouth;
    private LinkedList<EmojiImage> lEyebrows;
    private LinkedList<EmojiImage> lAccessories;
    private EmojiImage PreviousNodeF;
    private EmojiImage PreviousNodeE;
    private EmojiImage PreviousNodeM;
    private EmojiImage PreviousNodeEb;
    private EmojiImage PreviousNodeA;
    private EmojiImage CurrentNodeF;
    private EmojiImage CurrentNodeE;
    private EmojiImage CurrentNodeM;
    private EmojiImage CurrentNodeEb;
    private EmojiImage CurrentNodeA;
    private EmojiImage NextNodeF;
    private EmojiImage NextNodeE;
    private EmojiImage NextNodeM;
    private EmojiImage NextNodeEb;
    private EmojiImage NextNodeA;
    private String deleteNode;
    private LinkedList<ImageView> Emoji = new LinkedList();
    
    
    
    
    
@Override
    public void initialize(URL url, ResourceBundle rb) {
        loadLFaces();
        loadLEyes();
        loadLMouth();
        loadLEyebrows();
        loadLAccessories();
        if(f){
        setAllStartingNode();
        }
        Emoji.add(FaceM,0);
        Emoji.add(EyesM,1);
        Emoji.add(MouthM,2);
        Emoji.add(EyebrowsM,4);
        Emoji.add(AccessoriesM,5);
        loadToFFHBoxFirst3();
        loadToEFHBoxFirst3();
        loadToMFHBoxFirst3();
        loadToEbFHBoxFirst3();
        loadToAFHBoxFirst3();
    }    
    
    public void setAllStartingNode(){
        FaceM=FaceS;
        EyesM=EyesS;
        MouthM=MouthS;
    }
    
    @FXML
    public void setHboxDelete(MouseEvent e){
        System.out.println(deleteNode);
        if(deleteNode.equals("ListFaces")){
        eliminarC.setText("eliminarFaces");
        }
        if(deleteNode.equals("ListEyes")){
        eliminarC.setText("eliminarEyes");
        }
        if(deleteNode.equals("ListMouth")){
        eliminarC.setText("eliminarMouth");
        }
        if(deleteNode.equals("ListAccessories")){
        eliminarC.setText("eliminarAccessories");
        }
        if(deleteNode.equals("ListEyebrows")){
        eliminarC.setText("eliminarEyebrows");
        }
    }
    @FXML
    public void DeleteFromHBox(){
        String l=eliminarC.getText().substring(8);
        System.out.println(l);
        if(l.equals("Faces")){          
        for(int i=0;lFaces.size()>i;i++){
        if(lFaces.get(i).equals(CurrentNodeF)){
        String e = lFaces.get(i).getName();
        System.out.println(e);
        DeleteFromTXT("faces.txt",e);
        lFaces.remove(i);
        loadToFDHBox();
        }}
        }
        if(l.equals("Eyes")){
        for(int i=0;lEyes.size()>i;i++){
        if(lEyes.get(i).equals(CurrentNodeE)){
        String e = lEyes.get(i).getName();
        System.out.println(e);
        DeleteFromTXT("eyes.txt",e);
        lEyes.remove(i);
        loadToEDHBox();
        }
        }
        }
        if(l.equals("Mouth")){
        for(int i=0;lMouth.size()>i;i++){
        if(lMouth.get(i).equals(CurrentNodeM)){
        String e = lMouth.get(i).getName();
        System.out.println(e);
        DeleteFromTXT("mouth.txt",e);
        lMouth.remove(i); 
        loadToMDHBox();
        }}
        }
        if(l.equals("Eyebrows")){
        for(int i=0;lEyebrows.size()>i;i++){
        if(lEyebrows.get(i).equals(CurrentNodeEb)){
        String e = lEyebrows.get(i).getName();
        System.out.println(e);
        DeleteFromTXT("eyebrows.txt",e);
        lEyebrows.remove(i);
        loadToEbDHBox();
        }}    
        }
        if(l.equals("Accessories")){
        for(int i=0;lAccessories.size()>i;i++){
        if(lAccessories.get(i).equals(CurrentNodeA)){
        String e = lAccessories.get(i).getName();
        System.out.println(e);
        DeleteFromTXT("accessories.txt",e);
        lAccessories.remove(i);
        loadToADHBox();
        }}
        }
    }
    
    public void DeleteFromTXT(String archivo,String elemento){
    ArrayList<String> d= new ArrayList();
    
    try (BufferedReader br = new BufferedReader(new FileReader(String.format("src/main/resources/text/"+archivo)));){
            String linea;
            while ((linea = br.readLine())!=null){
                if(!linea.equals(elemento)){
                d.addLast(linea);
                System.out.println(linea);
                }
            }
        }catch (IOException e){
            System.out.print(e);
        }
    try (BufferedWriter br = new BufferedWriter(new FileWriter(String.format("src/main/resources/text/"+archivo)));){
            for (int i=0; d.size()>i;i++){  
            br.write(d.get(i));
            br.newLine();
            }         
        }catch (IOException e){
            System.out.print(e);
        }
    
    };
    
    @FXML
    public void mouseFClicked(MouseEvent e) {
        System.out.println(e.getSource().toString());
        System.out.println(e.getTarget().toString());
        String s=e.getSource().toString().substring(8);
        deleteNode=s.substring(0,s.length()-1);
        if(e.getTarget().equals(FaceM)){
        loadToEmojiSetF();
        }
        if(e.getTarget().equals(FaceN)){
        loadToFFHBox();
        loadToEmojiSetF();
        }
        if(e.getTarget().equals(FaceP)){
        loadToFPHBox();
        loadToEmojiSetF();
        }
    }
    @FXML
    public void mouseEClicked(MouseEvent e) {
        System.out.println(e.getSource().toString());
        System.out.println(e.getTarget().toString());
        String s=e.getSource().toString().substring(8);
        deleteNode=s.substring(0,s.length()-1);
        if(e.getTarget().equals(EyesM)){
        loadToEmojiSetE();
        }
        if(e.getTarget().equals(EyesN)){
        loadToEFHBox();    
        loadToEmojiSetE();
        }
        if(e.getTarget().equals(EyesP)){
        loadToEPHBox();
        loadToEmojiSetE();
        }
    }
    @FXML
    public void mouseMClicked(MouseEvent e) {
        System.out.println(e.getSource().toString());
        System.out.println(e.getTarget().toString());
        String s=e.getSource().toString().substring(8);
        deleteNode=s.substring(0,s.length()-1);
        if(e.getTarget().equals(MouthM)){
        loadToEmojiSetM();
        }
        if(e.getTarget().equals(MouthN)){
        loadToMFHBox();
        loadToEmojiSetM();
        }
        if(e.getTarget().equals(MouthP)){
        loadToMPHBox();
        loadToEmojiSetM();
        }
    }
    @FXML
    public void mouseEbClicked(MouseEvent e) {
        System.out.println(e.getSource().toString());
        System.out.println(e.getTarget().toString());
        String s=e.getSource().toString().substring(8);
        deleteNode=s.substring(0,s.length()-1);
        if(e.getTarget().equals(EyebrowsM)){
        loadToEmojiSetEb();
        }
        if(e.getTarget().equals(EyebrowsN)){
        loadToEbFHBox();
        loadToEmojiSetEb();
        }
        if(e.getTarget().equals(EyebrowsP)){
        loadToEbPHBox();
        loadToEmojiSetEb();
        }
    }
    @FXML
    public void mouseAClicked(MouseEvent e) {
        System.out.println(e.getSource().toString());
        System.out.println(e.getTarget().toString());
        String s=e.getSource().toString().substring(8);
        deleteNode=s.substring(0,s.length()-1);
        if(e.getTarget().equals(AccessoriesM)){
        loadToEmojiSetA();
        }
        if(e.getTarget().equals(AccessoriesN)){
        loadToAFHBox();
        loadToEmojiSetA();
        }
        if(e.getTarget().equals(AccessoriesP)){
        loadToAPHBox();
        loadToEmojiSetA();
        }
    }
    
    @FXML
    public void registrar(){
        registrarEmoji(SeguirController.cargarEmojis());
    }
    public void registrarEmoji(ArrayList<LinkedList> listadeEmojis){
        LinkedList<EmojiImage> listaFaces = listadeEmojis.get(0);
        LinkedList<EmojiImage> listaEyes = listadeEmojis.get(1);
        LinkedList<EmojiImage> listaMouth = listadeEmojis.get(2);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(String.format("src/main/resources/text/%s.txt",nombreUsuario)));){
           bw.write("Cara,Ojos,Boca");
           for(int i = 0;i<listaFaces.size();i++){             
                bw.newLine();
                bw.write(listaFaces.get(i).getName()+","+listaEyes.get(i).getName()+","+listaMouth.get(i).getName());
            }
            bw.newLine();
            bw.write(CurrentNodeF.getName()+","+CurrentNodeE.getName()+","+CurrentNodeM.getName());
        }catch (IOException e){
            System.out.println("error");
        }
    }
    
    //Verificar la clase clickeada
    //Depedendiendo cual sea la clase dependiendo donde la ponemos
    //
    //
    //
    //
    
    public LinkedList<EmojiImage> loadImages(String Type){
    LinkedList<EmojiImage> images= new LinkedList();
    try{
    BufferedReader br = new BufferedReader(new FileReader("src/main/resources/text/"+Type+".txt"));
     String linea;
     while((linea=br.readLine())!=null){
     System.out.println("Images/"+Type+"/"+linea+".png");
     Image img= new Image("Images/"+Type+"/"+linea+".png",50,50,true,true);       
     EmojiImage f= new EmojiImage(linea,img);
     images.addLast(f);
     }
    }
    catch(Exception e){
    System.err.println(e);
    } 
    return images;
 }
    
    public void loadLFaces(){
        lFaces=loadImages("faces");
    }
    public void loadLEyes(){
        lEyes=loadImages("eyes");
    }
    public void loadLMouth(){
        lMouth=loadImages("mouth");
    }   
    public void loadLEyebrows(){
        lEyebrows=loadImages("eyebrows");
    }
    public void loadLAccessories(){
        lAccessories=loadImages("accessories");
    }
    public void refreshEmojiSet(){
       EmojiSet.getChildren().clear();
       EmojiSet.getChildren().add(0,Emoji.get(0));
       EmojiSet.getChildren().add(1,Emoji.get(1));
       EmojiSet.getChildren().add(2,Emoji.get(2));
       EmojiSet.getChildren().add(3,Emoji.get(3));
       EmojiSet.getChildren().add(4,Emoji.get(4));
    }
    //Face
public void loadToFFHBoxFirst3(){
        EmojiImage p = lFaces.get(lFaces.size()-1);
        EmojiImage m = lFaces.get(0);
        CurrentNodeF=m;
        EmojiImage n = moveFListFoward();
        FaceP= new ImageView(p.getImage());
        FaceM= new ImageView(m.getImage());
        FaceN= new ImageView(n.getImage());
        ListFaces.getChildren().set(1, FaceP);
        ListFaces.getChildren().set(2, FaceM);
        ListFaces.getChildren().set(3, FaceN);
    }
    
    public void loadToEmojiSetF(){
       Image i= CurrentNodeF.getImage();
       ImageView d= new ImageView(i);
       d.setId(CurrentNodeF.getName());
       ImageView e=Emoji.get(1);
       ImageView m=Emoji.get(2);
       Emoji.set(0, d);
       refreshEmojiSet();
    }
    
    public void loadToFFHBox(){
       PreviousNodeF=CurrentNodeF;
       CurrentNodeF=moveFListFoward();  
       NextNodeF=moveFListFoward();
       ImageView c= new ImageView(CurrentNodeF.getImage());
       c.setId(CurrentNodeF.getName());
       FaceM=c;
       ImageView p= new ImageView(PreviousNodeF.getImage());
       p.setId(PreviousNodeF.getName());
       FaceP=p;
       ImageView n= new ImageView(NextNodeF.getImage());
       n.setId(NextNodeF.getName());
       FaceN=n;
       ListFaces.getChildren().set(1, FaceP);
       ListFaces.getChildren().set(2, FaceM);
       ListFaces.getChildren().set(3, FaceN); 
       System.out.println(CurrentNodeF.getName());
    }
    
    public void loadToFDHBox(){
       CurrentNodeF=PreviousNodeF;
       NextNodeF=moveFListFoward();
       PreviousNodeF=moveFListBack();
       ImageView c= new ImageView(CurrentNodeF.getImage());
       c.setId(CurrentNodeF.getName());
       FaceM=c;
       ImageView p= new ImageView(PreviousNodeF.getImage());
       p.setId(PreviousNodeF.getName());
       FaceP=p;
       ImageView n= new ImageView(NextNodeF.getImage());
       n.setId(NextNodeF.getName());
       FaceN=n;
       ListFaces.getChildren().set(1, FaceP);
       ListFaces.getChildren().set(2, FaceM);
       ListFaces.getChildren().set(3, FaceN); 
       System.out.println(CurrentNodeF.getName());
    }
    
    public EmojiImage moveFListFoward(){  
        for(int i=0;lFaces.size()>i;i++){       
        if(lFaces.get(i).equals(CurrentNodeF)){
        if(i+1==lFaces.size()){
        return lFaces.get(0);
        }
        return lFaces.get(i+1);
        }
        }
        return lFaces.get(0);
    }
    public EmojiImage moveFListBack(){  
        for(int i=lFaces.size()-1;i>0;i--){
        if(lFaces.get(i).equals(CurrentNodeF)){
        if(i-1==lFaces.size()){
        return lFaces.get(lFaces.size()-1);
        }
        return lFaces.get(i-1);
        }
        }
        return lFaces.get(lFaces.size()-1);
    }
    
       public void loadToFPHBox(){
       NextNodeF=CurrentNodeF;
       CurrentNodeF=moveFListBack();  
       PreviousNodeF=moveFListBack();
       ImageView c= new ImageView(CurrentNodeF.getImage());
       c.setId(CurrentNodeF.getName());
       FaceM=c;
       ImageView p= new ImageView(PreviousNodeF.getImage());
       p.setId(PreviousNodeF.getName());
       FaceP=p;
       ImageView n= new ImageView(NextNodeF.getImage());
       n.setId(NextNodeF.getName());
       FaceN=n;
       ListFaces.getChildren().set(1, FaceP);
       ListFaces.getChildren().set(2, FaceM);
       ListFaces.getChildren().set(3, FaceN); 
       System.out.println(CurrentNodeF.getName());
    }
    
    @FXML
    public void moveNFHBox(){
        loadToFFHBox();
        loadToEmojiSetF();
    }
    @FXML
    public void movePFHBox(){
        loadToFPHBox();
        loadToEmojiSetF();
    }
    

       //MOUTH 
    public void loadToMFHBoxFirst3(){
        EmojiImage p = lMouth.get(lMouth.size()-1);
        EmojiImage m = lMouth.get(0);
        CurrentNodeM=m;
        EmojiImage n = moveMListFoward();
        MouthP= new ImageView(p.getImage());
        MouthM= new ImageView(m.getImage());
        MouthN= new ImageView(n.getImage());
        ListMouth.getChildren().set(1, MouthP);
        ListMouth.getChildren().set(2, MouthM);
        ListMouth.getChildren().set(3, MouthN);
    }

       public void loadToEmojiSetM(){
       Image i= CurrentNodeM.getImage();
       ImageView d= new ImageView(i);
       d.setId(CurrentNodeM.getName());
       d.setLayoutY(10);
       ImageView f=Emoji.get(0);
       ImageView e=Emoji.get(1);
       Emoji.set(2,d);
       refreshEmojiSet();
    }
    
    public void loadToMFHBox(){
       PreviousNodeM=CurrentNodeM;
       CurrentNodeM=moveMListFoward();  
       NextNodeM=moveMListFoward();
       ImageView c= new ImageView(CurrentNodeM.getImage());
       c.setId(CurrentNodeM.getName());
       MouthM=c;
       ImageView p= new ImageView(PreviousNodeM.getImage());
       p.setId(PreviousNodeM.getName());
       MouthP=p;
       ImageView n= new ImageView(NextNodeM.getImage());
       n.setId(NextNodeM.getName());
       MouthN=n;
       ListMouth.getChildren().set(1, MouthP);
       ListMouth.getChildren().set(2, MouthM);
       ListMouth.getChildren().set(3, MouthN); 
       System.out.println(CurrentNodeM.getName());
    }
    public void loadToMDHBox(){
       CurrentNodeM=PreviousNodeM;
       NextNodeM=moveMListFoward();
       PreviousNodeM=moveMListBack();
       ImageView c= new ImageView(CurrentNodeM.getImage());
       c.setId(CurrentNodeM.getName());
       MouthM=c;
       ImageView p= new ImageView(PreviousNodeM.getImage());
       p.setId(PreviousNodeM.getName());
       MouthP=p;
       ImageView n= new ImageView(NextNodeM.getImage());
       n.setId(NextNodeM.getName());
       MouthN=n;
       ListMouth.getChildren().set(1, MouthP);
       ListMouth.getChildren().set(2, MouthM);
       ListMouth.getChildren().set(3, MouthN); 
       System.out.println(CurrentNodeM.getName());
    }
    public EmojiImage moveMListFoward(){  
        for(int i=0;lMouth.size()>i;i++){
        if(lMouth.get(i).equals(CurrentNodeM)){
        if(i+1==lMouth.size()){
        return lMouth.get(0);
        }
        return lMouth.get(i+1);
        }
        }
        return lMouth.get(0);
    }
    

    public EmojiImage moveMListBack(){  
        for(int i=lMouth.size()-1;i>0;i--){
        if(lMouth.get(i).equals(CurrentNodeM)){
        if(i-1==lMouth.size()){
        return lMouth.get(lMouth.size()-1);
        }
        return lMouth.get(i-1);
        }
        }
        return lMouth.get(lMouth.size()-1);
    }
    
       public void loadToMPHBox(){
       NextNodeM=CurrentNodeM;
       CurrentNodeM=moveMListBack();  
       PreviousNodeM=moveMListBack();
       ImageView c= new ImageView(CurrentNodeM.getImage());
       c.setId(CurrentNodeM.getName());
       MouthM=c;
       ImageView p= new ImageView(PreviousNodeM.getImage());
       p.setId(PreviousNodeM.getName());
       MouthP=p;
       ImageView n= new ImageView(NextNodeM.getImage());
       n.setId(NextNodeM.getName());
       MouthN=n;
       ListMouth.getChildren().set(1, MouthP);
       ListMouth.getChildren().set(2, MouthM);
       ListMouth.getChildren().set(3, MouthN); 
       System.out.println(CurrentNodeM.getName());
    }
    
    @FXML
    public void moveNMHBox(){
        loadToMFHBox();
        loadToEmojiSetM();
    }
    @FXML
    public void movePMHBox(){
        loadToMPHBox();
        loadToEmojiSetM();
    }

    //EYES
    public void loadToEFHBoxFirst3(){
        EmojiImage p = lEyes.get(lEyes.size()-1);
        EmojiImage m = lEyes.get(0);
        CurrentNodeE=m;
        EmojiImage n = moveEListFoward();
        EyesP= new ImageView(p.getImage());
        EyesM= new ImageView(m.getImage());
        EyesN= new ImageView(n.getImage());
        ListEyes.getChildren().set(1, EyesP);
        ListEyes.getChildren().set(2, EyesM);
        ListEyes.getChildren().set(3, EyesN);
    }
    public void loadToEmojiSetE(){
       Image i= CurrentNodeE.getImage();
       ImageView d= new ImageView(i);
       d.setId(CurrentNodeE.getName());
       d.setLayoutY(-10);     
       ImageView f=Emoji.get(0);
       ImageView m=Emoji.get(2);
       Emoji.set(1,d);
       refreshEmojiSet();
    }
    
    public void loadToEFHBox(){   
       PreviousNodeE=CurrentNodeE;
       CurrentNodeE=moveEListFoward();  
       NextNodeE=moveEListFoward();
       ImageView c= new ImageView(CurrentNodeE.getImage());
       c.setId(CurrentNodeE.getName());
       EyesM=c;
       ImageView p= new ImageView(PreviousNodeE.getImage());
       p.setId(PreviousNodeE.getName());
       EyesP=p;
       ImageView n= new ImageView(NextNodeE.getImage());
       n.setId(NextNodeE.getName());
       EyesN=n;
       ListEyes.getChildren().set(1, EyesP);
       ListEyes.getChildren().set(2, EyesM);
       ListEyes.getChildren().set(3, EyesN); 
       System.out.println(CurrentNodeE.getName());
    }
    public void loadToEDHBox(){   
       CurrentNodeE=PreviousNodeE;
       NextNodeE=moveEListFoward();
       PreviousNodeE=moveEListBack();
       ImageView c= new ImageView(CurrentNodeE.getImage());
       c.setId(CurrentNodeE.getName());
       EyesM=c;
       ImageView p= new ImageView(PreviousNodeE.getImage());
       p.setId(PreviousNodeE.getName());
       EyesP=p;
       ImageView n= new ImageView(NextNodeE.getImage());
       n.setId(NextNodeE.getName());
       EyesN=n;
       ListEyes.getChildren().set(1, EyesP);
       ListEyes.getChildren().set(2, EyesM);
       ListEyes.getChildren().set(3, EyesN); 
       System.out.println(CurrentNodeE.getName());
    }
    public EmojiImage moveEListFoward(){  
        for(int i=0;lEyes.size()>i;i++){
        if(lEyes.get(i).equals(CurrentNodeE)){
        if(i+1==lEyes.size()){
        return lEyes.get(0);
        }
        return lEyes.get(i+1);
        }
        }
        return lEyes.get(0);
    }
    public EmojiImage moveEListBack(){  
       for(int i=lEyes.size()-1;i>0;i--){
        if(lEyes.get(i).equals(CurrentNodeE)){
        if(i-1==lEyes.size()){
        return lEyes.get(lEyes.size()-1);
        }
        return lEyes.get(i-1);
        }
        }
        return lEyes.get(lEyes.size()-1);
    }
    
       public void loadToEPHBox(){
       NextNodeE=CurrentNodeE;
       CurrentNodeE=moveEListBack();  
       PreviousNodeE=moveEListBack();
       ImageView c= new ImageView(CurrentNodeE.getImage());
       c.setId(CurrentNodeE.getName());
       EyesM=c;
       ImageView p= new ImageView(PreviousNodeE.getImage());
       p.setId(PreviousNodeE.getName());
       EyesP=p;
       ImageView n= new ImageView(NextNodeE.getImage());
       n.setId(NextNodeE.getName());
       EyesN=n;
       ListEyes.getChildren().set(1, EyesP);
       ListEyes.getChildren().set(2, EyesM);
       ListEyes.getChildren().set(3, EyesN); 
       System.out.println(CurrentNodeE.getName());
    }
    
    @FXML
    public void moveNEHBox(){
        loadToEFHBox();
        loadToEmojiSetE();
    }
    @FXML
    public void movePEHBox(){
        loadToEPHBox();
        loadToEmojiSetE();
    }
    //EYEBROWS

        public void loadToEbFHBoxFirst3(){
        EmojiImage p = lEyebrows.get(lEyebrows.size()-1);
        EmojiImage m = lEyebrows.get(0);
        CurrentNodeEb=m;
        EmojiImage n = moveEbListFoward();
        EyebrowsP= new ImageView(p.getImage());
        EyebrowsM= new ImageView(m.getImage());
        EyebrowsN= new ImageView(n.getImage());
        ListEyebrows.getChildren().set(1, EyebrowsP);
        ListEyebrows.getChildren().set(2, EyebrowsM);
        ListEyebrows.getChildren().set(3, EyebrowsN);
    }
    public void loadToEmojiSetEb(){
       Image i= CurrentNodeEb.getImage();
       ImageView d= new ImageView(i);
       d.setId(CurrentNodeEb.getName());
       d.setLayoutY(-15);     
       Emoji.set(3,d);
       refreshEmojiSet();
    }
    
    public void loadToEbFHBox(){   
       PreviousNodeEb=CurrentNodeEb;
       CurrentNodeEb=moveEbListFoward();  
       NextNodeEb=moveEbListFoward();
       ImageView c= new ImageView(CurrentNodeEb.getImage());
       c.setId(CurrentNodeEb.getName());
       EyebrowsM=c;
       ImageView p= new ImageView(PreviousNodeEb.getImage());
       p.setId(PreviousNodeEb.getName());
       EyebrowsP=p;
       ImageView n= new ImageView(NextNodeEb.getImage());
       n.setId(NextNodeEb.getName());
       EyebrowsN=n;
       ListEyebrows.getChildren().set(1, EyebrowsP);
       ListEyebrows.getChildren().set(2, EyebrowsM);
       ListEyebrows.getChildren().set(3, EyebrowsN); 
       System.out.println(CurrentNodeEb.getName());
    }
    public void loadToEbDHBox(){   
       CurrentNodeEb=PreviousNodeEb;
       NextNodeEb=moveEbListFoward();
       PreviousNodeEb=moveEbListBack();
       ImageView c= new ImageView(CurrentNodeEb.getImage());
       c.setId(CurrentNodeEb.getName());
       EyebrowsM=c;
       ImageView p= new ImageView(PreviousNodeEb.getImage());
       p.setId(PreviousNodeEb.getName());
       EyebrowsP=p;
       ImageView n= new ImageView(NextNodeEb.getImage());
       n.setId(NextNodeEb.getName());
       EyebrowsN=n;
       ListEyebrows.getChildren().set(1, EyebrowsP);
       ListEyebrows.getChildren().set(2, EyebrowsM);
       ListEyebrows.getChildren().set(3, EyebrowsN); 
       System.out.println(CurrentNodeEb.getName());
    }
    
    public EmojiImage moveEbListFoward(){  
        for(int i=0;lEyebrows.size()>i;i++){
        if(lEyebrows.get(i).equals(CurrentNodeEb)){
        if(i+1==lEyebrows.size()){
        return lEyebrows.get(0);
        }
        return lEyebrows.get(i+1);
        }
        }
        return lEyebrows.get(0);
    }
    public EmojiImage moveEbListBack(){  
       for(int i=lEyebrows.size()-1;i>0;i--){
        if(lEyebrows.get(i).equals(CurrentNodeEb)){
        if(i-1==lEyebrows.size()){
        return lEyebrows.get(lEyebrows.size()-1);
        }
        return lEyebrows.get(i-1);
        }
        }
        return lEyebrows.get(lEyebrows.size()-1);
    }
    
       public void loadToEbPHBox(){
       NextNodeEb=CurrentNodeEb;
       CurrentNodeEb=moveEbListBack();  
       PreviousNodeEb=moveEbListBack();
       ImageView c= new ImageView(CurrentNodeEb.getImage());
       c.setId(CurrentNodeEb.getName());
       EyebrowsM=c;
       ImageView p= new ImageView(PreviousNodeEb.getImage());
       p.setId(PreviousNodeEb.getName());
       EyebrowsP=p;
       ImageView n= new ImageView(NextNodeEb.getImage());
       n.setId(NextNodeEb.getName());
       EyebrowsN=n;
       ListEyebrows.getChildren().set(1, EyebrowsP);
       ListEyebrows.getChildren().set(2, EyebrowsM);
       ListEyebrows.getChildren().set(3, EyebrowsN); 
       System.out.println(CurrentNodeEb.getName());
    }
    
    @FXML
    public void moveNEbHBox(){
        loadToEbFHBox();
        loadToEmojiSetEb();
    }
    @FXML
    public void movePEbHBox(){
        loadToEbPHBox();
        loadToEmojiSetEb();
    }

    //ACCESSORIES
    
        public void loadToAFHBoxFirst3(){
        EmojiImage p = lAccessories.get(lAccessories.size()-1);
        EmojiImage m = lAccessories.get(0);
        CurrentNodeA=m;
        EmojiImage n = moveAListFoward();
        AccessoriesP= new ImageView(p.getImage());
        AccessoriesM= new ImageView(m.getImage());
        AccessoriesN= new ImageView(n.getImage());
        ListAccessories.getChildren().set(1, AccessoriesP);
        ListAccessories.getChildren().set(2, AccessoriesM);
        ListAccessories.getChildren().set(3, AccessoriesN);
    }
    public void loadToEmojiSetA(){
       Image i= CurrentNodeA.getImage();
       ImageView d= new ImageView(i);
       d.setId(CurrentNodeA.getName());
       d.setLayoutY(-10);
       Emoji.set(4,d);
       refreshEmojiSet();
    }
    
    public void loadToADHBox(){   
       CurrentNodeA=PreviousNodeA;
       NextNodeA=moveAListFoward();
       PreviousNodeA=moveAListBack();
       ImageView c= new ImageView(CurrentNodeA.getImage());
       c.setId(CurrentNodeA.getName());
       AccessoriesM=c;
       ImageView p= new ImageView(PreviousNodeA.getImage());
       p.setId(PreviousNodeA.getName());
       AccessoriesP=p;
       ImageView n= new ImageView(NextNodeA.getImage());
       n.setId(NextNodeA.getName());
       AccessoriesN=n;
       ListAccessories.getChildren().set(1, AccessoriesP);
       ListAccessories.getChildren().set(2, AccessoriesM);
       ListAccessories.getChildren().set(3, AccessoriesN); 
       System.out.println(CurrentNodeA.getName());
    }
    public void loadToAFHBox(){   
       PreviousNodeA=CurrentNodeA;
       CurrentNodeA=moveAListFoward();  
       NextNodeA=moveAListFoward();
       ImageView c= new ImageView(CurrentNodeA.getImage());
       c.setId(CurrentNodeA.getName());
       AccessoriesM=c;
       ImageView p= new ImageView(PreviousNodeA.getImage());
       p.setId(PreviousNodeA.getName());
       AccessoriesP=p;
       ImageView n= new ImageView(NextNodeA.getImage());
       n.setId(NextNodeA.getName());
       AccessoriesN=n;
       ListAccessories.getChildren().set(1, AccessoriesP);
       ListAccessories.getChildren().set(2, AccessoriesM);
       ListAccessories.getChildren().set(3, AccessoriesN); 
       System.out.println(CurrentNodeA.getName());
    }    
    public EmojiImage moveAListFoward(){  
        for(int i=0;lAccessories.size()>i;i++){
        if(lAccessories.get(i).equals(CurrentNodeA)){
        if(i+1==lAccessories.size()){
        return lAccessories.get(0);
        }
        return lAccessories.get(i+1);
        }
        }
        return lAccessories.get(0);
    }
    public EmojiImage moveAListBack(){  
       for(int i=lAccessories.size()-1;i>0;i--){
        if(lAccessories.get(i).equals(CurrentNodeA)){
        if(i-1==lAccessories.size()){
        return lAccessories.get(lAccessories.size()-1);
        }
        return lAccessories.get(i-1);
        }
        }
        return lAccessories.get(lAccessories.size()-1);
    }
    
       public void loadToAPHBox(){
       NextNodeA=CurrentNodeA;
       CurrentNodeA=moveAListBack();  
       PreviousNodeA=moveAListBack();
       ImageView c= new ImageView(CurrentNodeA.getImage());
       c.setId(CurrentNodeA.getName());
       AccessoriesM=c;
       ImageView p= new ImageView(PreviousNodeA.getImage());
       p.setId(PreviousNodeA.getName());
       AccessoriesP=p;
       ImageView n= new ImageView(NextNodeA.getImage());
       n.setId(NextNodeA.getName());
       AccessoriesN=n;
       ListAccessories.getChildren().set(1, AccessoriesP);
       ListAccessories.getChildren().set(2, AccessoriesM);
       ListAccessories.getChildren().set(3, AccessoriesN); 
       System.out.println(CurrentNodeA.getName());
    }
    
    @FXML
    public void moveNAHBox(){
        loadToAFHBox();
        loadToEmojiSetA();
    }
    @FXML
    public void movePAHBox(){
        loadToAPHBox();
        loadToEmojiSetA();
    }
    
    @FXML
    void volver()throws IOException {
        try {                          
            App.setRoot("pantallaUsuario1");
            } 
        catch (IOException ex) {
            
            } 
    }
    
    public static void setNombreUsuario(String nombre) {
        nombreUsuario = nombre;
    }
    
    
}
