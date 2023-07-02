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

    public Image getImage() {
        return Eimage;
    }

    public void setImage(Image image) {
        this.Eimage = image;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
