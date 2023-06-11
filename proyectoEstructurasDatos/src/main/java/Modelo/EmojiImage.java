/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import TDA.*;
import java.io.BufferedReader;
import java.io.FileReader;
import javafx.scene.image.Image;
/**
 *
 * @author Win1OPro Station
 */
public class EmojiImage {
     private String name;
    private Image Eimage;

    public EmojiImage(String name, Image Eimage) {
        this.name = name;
        this.Eimage = Eimage;
    }
    
    public String getName() {
        return name;
    }

    public Image getImagerute() {
        return Eimage;
    }

    public void setImagerute(Image imagerute) {
        this.Eimage = imagerute;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public LinkedList<EmojiImage> loadImages(String Type){
    LinkedList<EmojiImage> images= new LinkedList();    
    try{
    BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Win1OPro Station\\Documents\\NetBeansProjects\\SpaceAdventure\\src\\main\\resources\\Data\\Items.txt"));
     String linea;
     while((linea=br.readLine())!=null){
     String[] datos= linea.split("/");
     String url= datos[1];
     Image img= new Image("Images."+Type.toLowerCase()+url);       
     EmojiImage f= new EmojiImage(datos[0],img);
     images.addLast(f);
     }
    }
    catch(Exception e){
    System.out.println(e);
    } 
    return images;
 }
}
